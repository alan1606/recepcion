/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.AreasDao;
import DAO.AreasDaoImpl;
import DAO.ConceptosDao;
import DAO.ConceptosDaoImp;
import DAO.EquipoDicomDao;
import DAO.EquipoDicomDaoImp;
import DAO.InstitucionDao;
import DAO.InstitucionDaoImp;
import DAO.OrdenVentaDao;
import DAO.OrdenVentaDaoImp;
import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import DAO.VentaConceptosDao;
import DAO.VentaConceptosDaoImp;
import Tables.TablePacientes;
import Utilidades.QrUtil;
import Vistas.Menu;
import Vistas.MenuUrgencias;
import Vistas.NuevoPaciente;
import Vistas.QrCode;
import Vistas.Urgencias;
import clientews.servicio.Areas;
import clientews.servicio.CatalogoFormaPago;
import clientews.servicio.Conceptos;
import clientews.servicio.EquipoDicom;
import clientews.servicio.Institucion;
import clientews.servicio.OrdenVenta;
import clientews.servicio.Pacientes;
import clientews.servicio.VentaConceptos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author alanm
 */
public class UrgenciasController implements KeyListener, MouseListener, ActionListener, PropertyChangeListener {

    private Urgencias vista;

    private PacientesDao modeloPacientes;
    private InstitucionDao modeloInstituciones;
    private ConceptosDao modeloConceptos;
    private EquipoDicomDao modeloEquipoDicom;
    private AreasDao modeloAreas;
    private VentaConceptosDao modeloVentaConceptos;
    private OrdenVentaDao modeloOrdenVenta;

    private boolean ordenVentaGenerada = false;
    private OrdenVenta orden;
    private Areas area;
    private Institucion institucion;
    private EquipoDicom sala;
    private Pacientes paciente;
    private Conceptos estudio;
    private VentaConceptos venta;
    private QrCode ventanaQr;

    private Date fechaActual;
    private String fechaSeleccionada;
    private XMLGregorianCalendar fechaActualXml;

    public UrgenciasController(Urgencias vista) {
        this.vista = vista;

        modeloPacientes = new PacientesDaoImp();
        modeloInstituciones = new InstitucionDaoImp();
        modeloConceptos = new ConceptosDaoImp();
        modeloEquipoDicom = new EquipoDicomDaoImp();
        modeloAreas = new AreasDaoImpl();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloOrdenVenta = new OrdenVentaDaoImp();
        ventanaQr = new QrCode();

        this.vista.radioNombre.addActionListener(this);
        this.vista.radioCurp.addActionListener(this);

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnNuevoPaciente.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnQuitar.addActionListener(this);
        this.vista.btnFoto.addActionListener(this);

        this.vista.comboArea.addActionListener(this);
        this.vista.comboEstudio.addActionListener(this);
        this.vista.comboHora.addActionListener(this);
        this.vista.comboSala.addActionListener(this);
        this.vista.comboInstitucion.addActionListener(this);

        this.vista.tableEstudios.addMouseListener(this);
        this.vista.tablePacientes.addMouseListener(this);

        this.vista.txtBuscar.addKeyListener(this);
        this.vista.btnRegresar.addActionListener(this);

        this.vista.fecha.addPropertyChangeListener(this);

        this.ventanaQr.lblCerrar.addMouseListener(this);
    }

    public void iniciar() {
        vista.setTitle("Urgencias");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        setRadioNombreEnabled(true);
        cargarInstituciones();
        iniciarTablaEstudios();
        obtenerFechaActual();
    }

    private void iniciarTablaEstudios() {

        DefaultTableModel dt = new DefaultTableModel();

        dt.addColumn("Id");
        dt.addColumn("Estudio");
        dt.addColumn("Hora");

        vista.tableEstudios.setModel(dt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.radioCurp) {
            setRadioCurpEnabled(true);
            setRadioNombreEnabled(false);
        } else if (e.getSource() == this.vista.radioNombre) {
            setRadioCurpEnabled(false);
            setRadioNombreEnabled(true);
        } else if (e.getSource() == this.vista.comboArea) {
            if (this.vista.comboArea.getSelectedIndex() != 0) {//Se selecciona una opción que es diferente de "Seleccione una opción"
                area = modeloAreas.encontrarPorNombre(vista.comboArea.getSelectedItem().toString());
                cargarEstudiosDeAreaInstitucion();
                cargarSalasDeArea();
            }
        } else if (e.getSource() == this.vista.comboInstitucion) {
            if (this.vista.comboInstitucion.getSelectedIndex() != 0) //Selección de opción válida
            {
                institucion = new Institucion();
                institucion.setNombreInstitucion(vista.comboInstitucion.getSelectedItem().toString());
                institucion = modeloInstituciones.encontrarPorNombre(institucion);
                cargarAreas();
                if (!institucion.getNombreInstitucion().equals("PARTICULAR") && vista.fecha.getDate() != null) { //Si no equivale a particular se procede a checar si no se ha superado el limite
                    if (!aunEsPosibleAgendarEnInstitucion()) {
                        JOptionPane.showMessageDialog(null, "La institución ha superado su límite diario en esa fecha");
                    }
                }
            }
        } else if (e.getSource() == this.vista.comboSala) {
            if (todoListoVerificarAgenda()) {
                sala = modeloEquipoDicom.encontrarEquipoDicomPorNombre(vista.comboSala.getSelectedItem().toString());
                agenda();
            }
        } else if (e.getSource() == vista.comboEstudio) {
            if (vista.comboEstudio.getSelectedIndex() != 0) {
                obtenerConcepto();
            }
        } else if (e.getSource() == this.vista.btnAgregar) {
            if (datosValidos() && vista.comboHora.getSelectedIndex() != 0) {
                agregarVentaConcepto();
            }
        } else if (e.getSource() == vista.btnQuitar) {
            if (vista.tableEstudios.getSelectedRow() != -1) {
                eliminarVenta();
                quitarDeTabla();
                if (todoListoVerificarAgenda()) {
                    agenda();
                }
            }
        } else if (e.getSource() == vista.btnGuardar) {
            if (datosValidos() && vista.tableEstudios.getRowCount() != 0 && deseaRegistrar() == 0) {
                try {
                    reiniciarVariables();
                    limpiarCampos();
                } catch (Exception ex) {
                }
            }
        } else if (e.getSource() == vista.btnNuevoPaciente) {
            vista.dispose();
            NuevoPacienteController controladorNuevoPaciente = new NuevoPacienteController(new NuevoPaciente());
            controladorNuevoPaciente.iniciar();
        } else if (e.getSource() == vista.btnRegresar) {
            vista.dispose();
            MenuUrgenciasController menu = new MenuUrgenciasController(new MenuUrgencias());
            menu.iniciar();
        } else if (e.getSource() == vista.btnCancelar) {
            if (deseaCancelar() == 0) {
                try {
                    reiniciarVariables();
                    limpiarCampos();
                } catch (Exception ex) {
                }
            }
        } else if (e.getSource() == vista.btnFoto) {
            if (ordenVentaGenerada) {
                try {
                    mostrarQr();
                } catch (Exception exc) {
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == this.vista.txtBuscar) {
            if (this.vista.txtBuscar.getText().equals("")) {
                cargarTablaPacientesVacia();
            } else {
                if (this.vista.radioNombre.isSelected()) {
                    buscarPacientePorNombre(this.vista.txtBuscar.getText());
                } else {
                    buscarPacientePorCurp(this.vista.txtBuscar.getText());
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.tablePacientes) {
            if (vista.tablePacientes.getRowCount() != 0 && vista.tablePacientes.getSelectedColumn() != -1) { //Si la tabla tiene más de un registro y se seleccionó alguno
                int fila = vista.tablePacientes.getSelectedRow();
                String curp = (vista.tablePacientes.getValueAt(fila, 2)).toString();
                if (!curp.equals("")) { //si hay curp
                    vista.txtPaciente.setText(curp);
                    obtenerPaciente();
                }
            }
        } else if (e.getSource() == vista.tableEstudios) {
            if (vista.tableEstudios.getRowCount() != 0 && vista.tableEstudios.getSelectedRow() != -1) {
                obtenerVentaSeleccionada();
            }
        } else if (e.getSource() == ventanaQr.lblCerrar) {
            cerrarQr();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void setRadioCurpEnabled(boolean b) {
        this.vista.radioCurp.setSelected(b);
    }

    private void setRadioNombreEnabled(boolean b) {
        this.vista.radioNombre.setSelected(b);
    }

    private void cargarTablaPacientesVacia() {
        TablePacientes tablePacientes = new TablePacientes();
        tablePacientes.cargarTablaVacia(this.vista.tablePacientes);
    }

    private void buscarPacientePorNombre(String text) {
        TablePacientes tablePacientes = new TablePacientes();
        tablePacientes.cargarTabla(this.vista.tablePacientes, modeloPacientes.buscarLikeNombre(this.vista.txtBuscar.getText()));
    }

    private void buscarPacientePorCurp(String text) {
        TablePacientes tablePacientes = new TablePacientes();
        tablePacientes.cargarTabla(this.vista.tablePacientes, modeloPacientes.buscarLikeCurp(this.vista.txtBuscar.getText()));
    }

    private void cargarInstituciones() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Institucion institucionFor : modeloInstituciones.listar()) {
                combo.addItem(institucionFor.getNombreInstitucion());
            }
            vista.comboInstitucion.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarAreas() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Areas areaFor : modeloAreas.encontrarPorInstitucion(institucion)) {
                combo.addItem(areaFor.getNombreA());
            }
            vista.comboArea.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarEstudiosDeAreaInstitucion() {

        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Conceptos conceptoFor : modeloConceptos.encontrarConceptosPorAreaInstitucion(institucion.getIdInstitucion(), area.getIdA())) {
                combo.addItem(conceptoFor.getConceptoTo());
            }
            vista.comboEstudio.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarSalasDeArea() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (EquipoDicom equipo : modeloEquipoDicom.encontrarEquipoDicomPorArea(area)) {
                combo.addItem(equipo.getNombre());
            }
            vista.comboSala.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private boolean todoListoVerificarAgenda() {
        if (vista.comboInstitucion.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboArea.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboEstudio.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboSala.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.fecha.getDate() == null) {
            return false;
        }
        return true;
    }

    private void agenda() {
        int horaInicio = horaAInt(area.getHoraInicio().toString(), 11, 14);
        int horaFin = horaAInt(area.getHoraFin().toString(), 11, 14);
        boolean par = false;
        boolean alternador = true;

        if (area.getDuracionMinutos() % 2 == 0) {
            par = true;
        }

        int duracion = area.getDuracionMinutos() / 2;

        String fecha = dateToString(vista.fecha.getDate().getTime());

        List<VentaConceptos> agendados = modeloVentaConceptos.findAgendadosByAreaEquipoDicomFecha(area.getIdA(), sala.getIdEquipo(), fecha);

        List<Integer> horasList = new ArrayList<>();

        for (VentaConceptos ventaFor : agendados) {
            horasList.add(horaAInt(ventaFor.getHoraAsignado(), 0, 3));
        }

        int minutos = 0;
        int horas = 0;

        int minutosMostrar = 0;
        int horasMostrar = 0;

        String horarioMostrar = "";

        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");

            int i = horaInicio;

            do {
                if (!estaOcupadaHora(i, horasList)) {
                    horarioMostrar = "";

                    horasMostrar = i / 100;
                    minutosMostrar = i % 100;

                    if (horasMostrar > 9) {
                        horarioMostrar += (horasMostrar + ":");
                    } else {
                        horarioMostrar += ("0" + horasMostrar + ":");
                    }

                    if (minutosMostrar == 0) {
                        horarioMostrar += "00";
                    } else if (minutosMostrar < 10) {
                        horarioMostrar += ("0" + minutosMostrar);
                    } else {
                        horarioMostrar += (minutosMostrar);
                    }
                    combo.addItem(horarioMostrar);
                }

                horas = duracion / 60;
                if (!par) {
                    if (alternador) {
                        minutos = duracion % 60;
                        alternador = false;
                    } else {
                        minutos = (duracion % 60) + 1;
                        alternador = true;
                    }
                } else {
                    minutos = duracion % 60;
                }

                i += (horas * 100 + minutos); //Sumatoria hecha

                //Convertir i a hora
                if ((i % 100) >= 60) {
                    i += 100;
                    i -= 60;
                }

            } while (i < horaFin);

            vista.comboHora.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void verificarAgendaInstitucion() {
        if (aunEsPosibleAgendarEnInstitucion()) {
            agenda();
        } else {
            JOptionPane.showMessageDialog(null, "La institución ha superado el límite diario de estudios");
            vaciarComboEstudios();
        }
    }

    private boolean aunEsPosibleAgendarEnInstitucion() {
        return true;
    }

    private int horaAInt(String hora, int inicioHora, int inicioMinutos) {
        String horasString = "";
        String minutosString = "";
        boolean dosPuntosSuperado = false;
        int posDospuntos = 0;
        int horaInt = 0;
        int minutosInt = 0;
        for (int i = inicioHora; i < inicioHora + 2; i++) {
            if (hora.charAt(i) == ':') {
                dosPuntosSuperado = true;
                posDospuntos = i;
                break;
            }
            if (!dosPuntosSuperado) {
                horasString += hora.charAt(i);
            }
        }
        if (!dosPuntosSuperado) {
            posDospuntos = inicioMinutos - 1;
        }
        for (int i = posDospuntos + 1; i < (posDospuntos + 1) + 2; i++) {
            minutosString += hora.charAt(i);
        }
        try {
            horaInt = Integer.parseInt(horasString);
            minutosInt = Integer.parseInt(minutosString);
        } catch (Exception e) {
        }

        return ((horaInt * 100) + minutosInt);
    }

    private String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private boolean estaOcupadaHora(int hora, List<Integer> horasList) {
        return horasList.contains(hora);
    }

    private int obtenerHora(String fecha) {

        String hora = "";

        for (int i = 0; i < 2; i++) {
            if (fecha.charAt(i) != ':') {
                hora += fecha.charAt(i);

            }
        }

        return Integer.parseInt(hora);
    }

    private int obtenerMinutos(String fecha) {
        String minutos = "";
        boolean dosPuntosSuperado = false;
        for (int i = 0; i < fecha.length(); i++) {
            if (dosPuntosSuperado) {
                minutos += fecha.charAt(i);
            }
            if (fecha.charAt(i) == ':') {
                dosPuntosSuperado = true;
            }

        }

        return Integer.parseInt(minutos);
    }

    private void agregarATabla(VentaConceptos venta) {
        DefaultTableModel dt = (DefaultTableModel) vista.tableEstudios.getModel();

        Object[] ventaAgregar = new Object[3];
        ventaAgregar[0] = venta.getIdVc();
        ventaAgregar[1] = venta.getIdConceptoEs().getConceptoTo();
        ventaAgregar[2] = venta.getHoraAsignado();

        dt.addRow(ventaAgregar);

        vista.tableEstudios.setModel(dt);

    }

    private void agregarVentaConcepto() {

        if (!ordenVentaGenerada) {
            generarOrdenVenta(fechaActualXml);
        }
        if (esInstitucionYHayDisponibilidad()) { //Si es particular o es institucion pero aún se puede agendarh
            generarVentaConceptos();

            if (enRealidadEstaDisponibleElEstudio()) {
                registrarVenta();

                obtenerVentaHecha();

                //Actualizar iuid
                agregarATabla(venta);

            } else {
                JOptionPane.showMessageDialog(null, "El estudio ya ha sido asignado, intente con una hora diferente");
            }
            agenda();//Auneu se haya registrado o no el concepto, hay que recargar los horarios
            //Una limpieza estaría bien
        }
    }

    private boolean esInstitucionYHayDisponibilidad() {
        if (vista.comboInstitucion.getSelectedItem().equals("PARTICULAR")) {
            return true;
        }
        if (aunEsPosibleAgendarEnInstitucion()) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "La institución ha superado su límite diario en esa fecha");
        return false;
    }

    private boolean datosValidos() {
        if (vista.txtPaciente.getText().equals("")) {
            return false;
        }
        if (vista.comboInstitucion.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboArea.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboEstudio.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboSala.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.fecha.getDate() == null) {
            return false;
        }
        return true;
    }

    private void generarOrdenVenta(XMLGregorianCalendar fechaActualXml) {
        CatalogoFormaPago formaPago = new CatalogoFormaPago();
        formaPago.setIdFp(Short.parseShort("1"));

        orden = new OrdenVenta();

        orden.setAdicionalesCOv(0f);

        orden.setAdicionalesEiOv(0f);

        orden.setAdicionalesElOv(0f);

        orden.setAdicionalesPOv(0f);

        orden.setAdicionalesSOv(0f);

        orden.setContadorOv(0);

        orden.setDescDCta(0);

        orden.setDescDImg(0);

        orden.setDescDLab(0);

        orden.setDescDPro(0);

        orden.setDescDServ(0);

        orden.setEstatusOv(Short.parseShort("0"));

        orden.setFacturadaOv(Short.parseShort("0"));

        orden.setFechaVentaOv(dateToStringOrdenVenta(fechaActual.getTime()));

        orden.setGranTotalOv(0f);

        orden.setIdFormaPago(formaPago);

        orden.setIdOv(0l);

        orden.setIdPacienteOv(paciente);

        orden.setIvaOv(0);

        orden.setMedicoCOv(0);

        orden.setMedicoEiOv(0);

        orden.setMedicoElOv(0);

        orden.setMotivoCOv("");

        orden.setMotivoDescCOv("");

        orden.setMotivoDescFOv("");

        orden.setMotivoDescIOv("");

        orden.setMotivoDescLOv("");

        orden.setMotivoDescSOv("");

        orden.setMuestrasOv("");

        orden.setNoTempOv("");

        orden.setObservacionesIOv("");

        orden.setObservacionesLOv("");

        orden.setObservacionesSOv("");

        orden.setPDescCta(Short.parseShort("0"));

        orden.setPDescImg(Short.parseShort("0"));

        orden.setPDescLab(Short.parseShort("0"));

        orden.setPDescPro(Short.parseShort("0"));

        orden.setPDescServ(Short.parseShort("0"));

        orden.setPagado(false);

        orden.setPersonalSOv(0);

        orden.setProcedenciaOv(Short.parseShort("0"));

        orden.setReferenciaOv("");

        orden.setRequiereFactura(false);

        orden.setSubTotalC(0f);

        orden.setSubTotalI(0f);

        orden.setSubTotalL(0f);

        orden.setSubTotalP(0f);

        orden.setSubTotalS(0f);

        orden.setSubtotalOv(0);

        orden.setSucursalOv(0);

        orden.setTDescCta(0f);

        orden.setTDescCta(0f);

        orden.setTDescImg(0f);

        orden.setTDescLab(0f);

        orden.setTDescPro(0f);

        orden.setTDescServ(0f);

        orden.setTotalC(0f);

        orden.setTotalEi(0f);

        orden.setTotalEl(0f);

        orden.setTotalP(0f);

        orden.setTotalS(0f);

        orden.setUsuarioOv(0);

        orden.setObservacionesIOv("");
        orden.setEstatusOv(Short.parseShort("1"));
        orden.setProcedenciaOv(Short.parseShort("1"));
        orden.setRequiereFactura(false);
        orden.setIdFormaPago(formaPago);
        orden.setPagado(false);

        //Indicar que ya se generó
        ordenVentaGenerada = true;

        registrarOrdenVenta();
        obtenerUltimaOrdenVenta();
    }

    private void registrarOrdenVenta() {
        modeloOrdenVenta.registrar(orden);
    }

    private void obtenerUltimaOrdenVenta() {
        orden = modeloOrdenVenta.encontrarUltimno();
    }

    private void obtenerPaciente() {
        paciente = modeloPacientes.buscarLikeCurp(vista.txtPaciente.getText()).get(0);
    }

    private void obtenerConcepto() {
        estudio = modeloConceptos.encontrarConceptoPorNombre(vista.comboEstudio.getSelectedItem().toString());
    }

    private void generarVentaConceptos() {
        venta = new VentaConceptos();
        venta.setIdInstitucion(institucion);
        venta.setIdPacienteVc(paciente);
        venta.setFechaVentaVc(dateToString(fechaActual.getTime()));
        venta.setEstatusVc(Short.parseShort("3"));
        venta.setUrgenteVc(Short.parseShort("0"));
        venta.setUsuarioEdo1E(426);
        venta.setFechaEdo1E(fechaActualXml);
        venta.setIdConceptoEs(estudio);
        venta.setIdPacs("1354asd4269");

        venta.setIdOrdenVenta(orden);

        String horaSeleccionada = vista.comboHora.getSelectedItem().toString();

        venta.setFechaAsignado(dateToString(vista.fecha.getDate().getTime()));
        venta.setHoraAsignado(horaSeleccionada);
        venta.setEnWorklist(false);
        venta.setIdEquipoDicom(sala);
        venta.setEstado("AGENDADO");
    }

    private void obtenerFechaActual() {
        fechaActual = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fechaActual);
        fechaActualXml = null;
        try {
            fechaActualXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(AgendarCitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void registrarVenta() {
        modeloVentaConceptos.registrarVentaConceptos(venta);
    }

    private void obtenerVentaHecha() {
        venta = modeloVentaConceptos.encontrarVentaConceptoPorOrdenVentaConceptoHoraAsignado(orden, estudio, venta.getHoraAsignado());
    }

    private void obtenerVentaSeleccionada() {
        int fila = vista.tableEstudios.getSelectedRow();
        venta = modeloVentaConceptos.findById(Long.parseLong(vista.tableEstudios.getValueAt(fila, 0).toString()));
        System.out.println(venta.getIdVc());
    }

    private void eliminarVenta() {
        modeloVentaConceptos.eliminarVentaConceptos(venta);
    }

    private boolean enRealidadEstaDisponibleElEstudio() {
        Long agendados = modeloVentaConceptos.encontrarNumeroVentaConceptosPorEquipoFechaHora(sala, venta.getFechaAsignado(), venta.getHoraAsignado());
        return agendados == 0;
    }

    private void quitarDeTabla() {
        DefaultTableModel dt = (DefaultTableModel) vista.tableEstudios.getModel();

        dt.removeRow(vista.tableEstudios.getSelectedRow());

        vista.tableEstudios.setModel(dt);
    }

    private void reiniciarVariables() {
        ordenVentaGenerada = false;
        orden = new OrdenVenta();
        area = new Areas();
        institucion = new Institucion();
        sala = new EquipoDicom();
        paciente = new Pacientes();
        estudio = new Conceptos();
        venta = new VentaConceptos();

    }

    private void limpiarCampos() {
        vista.txtBuscar.setText("");
        vista.radioNombre.setSelected(true);
        vista.radioCurp.setSelected(false);
        vista.txtPaciente.setText("");
        vista.comboInstitucion.setSelectedIndex(0);
        vista.fecha.setDate(null);

        vista.comboArea.setSelectedIndex(0);
        vista.comboEstudio.setSelectedIndex(0);
        vista.comboHora.setSelectedIndex(0);
        vista.comboSala.setSelectedIndex(0);

        limpiarTabla();
    }

    private void limpiarTabla() {
        DefaultTableModel dt = (DefaultTableModel) vista.tableEstudios.getModel();

        while (dt.getRowCount() > 0) {
            dt.removeRow(0);
        }

        vista.tableEstudios.setModel(dt);
    }

    private int deseaRegistrar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea registrar los estudios? ", "Confirmar", dialog));
    }

    private int deseaCancelar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea limpiar? ", "Confirmar", dialog));
    }

    private String dateToStringOrdenVenta(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private void vaciarComboEstudios() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            vista.comboEstudio.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == vista.fecha) {
            if (vista.fecha.getDate() != null) {
                fechaSeleccionada = dateToString(vista.fecha.getDate().getTime());
            }
            if (vista.fecha.getDate() != null && vista.comboInstitucion.getSelectedIndex() != 0 && !vista.comboInstitucion.getSelectedItem().toString().equals("PARTICULAR")) {
                if (!aunEsPosibleAgendarEnInstitucion()) { //Ya no hay
                    JOptionPane.showMessageDialog(null, "La institución ha superado su límite diario en esa fecha");
                }
            }
        }
    }

    private void mostrarQr() throws Exception {
        ventanaQr.setTitle("Escanear el código y subir imagen");
        ventanaQr.setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(QrUtil.generateQrCode("http://ns1.diagnocons.com/sistema/pruebaUpImg.php?fuente=recepcionQr&idOrdenVenta=" + orden.getIdOv()
                + "&idPaciente="
                + paciente.getIdP()
                + "&nombrePaciente=" + formatea(paciente.getNombreCompletoP()), 400, 260));
        ventanaQr.lblQr.setIcon(icono);
        ventanaQr.setVisible(true);
    }

    private String formatea(String string) {
        String nueva = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                nueva += "%20";
            } else {
                nueva += string.charAt(i);
            }
        }
        return nueva;
    }

    private void cerrarQr() {
        ventanaQr.dispose();
    }

}
