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
import Vistas.AgendarCita;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AgendarCitaController implements KeyListener, MouseListener, ActionListener {

    private AgendarCita vista;

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

    private Date fechaActual;
    private XMLGregorianCalendar fechaActualXml;

    public AgendarCitaController(AgendarCita vista) {
        this.vista = vista;

        modeloPacientes = new PacientesDaoImp();
        modeloInstituciones = new InstitucionDaoImp();
        modeloConceptos = new ConceptosDaoImp();
        modeloEquipoDicom = new EquipoDicomDaoImp();
        modeloAreas = new AreasDaoImpl();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloOrdenVenta = new OrdenVentaDaoImp();

        this.vista.radioNombre.addActionListener(this);
        this.vista.radioCurp.addActionListener(this);

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnNuevoPaciente.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnQuitar.addActionListener(this);

        this.vista.comboArea.addActionListener(this);
        this.vista.comboEstudio.addActionListener(this);
        this.vista.comboHora.addActionListener(this);
        this.vista.comboSala.addActionListener(this);
        this.vista.comboInstitucion.addActionListener(this);

        this.vista.tableEstudios.addMouseListener(this);
        this.vista.tablePacientes.addMouseListener(this);

        this.vista.txtBuscar.addKeyListener(this);

        setRadioNombreEnabled(true);
        cargarInstituciones();
        iniciarTablaEstudios();
        obtenerFechaActual();
    }

    private void iniciarTablaEstudios() {

        DefaultTableModel dt = new DefaultTableModel();

        dt.addColumn("Estudio");
        dt.addColumn("Hora");

        vista.tableEstudios.setModel(dt);
    }

    public void iniciar() {
        vista.setTitle("Agendar cita");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
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
            if (datosValidos()) {
                agregarVentaConcepto();
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
        if (vista.comboInstitucion.getSelectedItem().toString().equals("PARTICULAR")) {
            verificarAgendaParticular();
        } else {
            verificarAgendaInstitucion();
        }
    }

    private void verificarAgendaParticular() {
        int horaInicio = horaAInt(area.getHoraInicio().toString());
        int horaFin = horaAInt(area.getHoraFin().toString());

        int duracion = area.getDuracionMinutos();

        String fecha = dateToString(vista.fecha.getDate().getTime());

        List<VentaConceptos> agendados = modeloVentaConceptos.findAgendadosByAreaEquipoDicomFecha(area.getIdA(), sala.getIdEquipo(), fecha);

        List<Integer> horasList = new ArrayList<>();

        for (VentaConceptos ventaFor : agendados) {
            horasList.add(horaAInt(ventaFor.getHoraAsignado()));
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

                    horarioMostrar += (horasMostrar + ":");

                    if (minutosMostrar == 0) {
                        horarioMostrar += "00";
                    } else if (minutosMostrar < 10) {
                        horarioMostrar += ("0" + minutosMostrar);
                    } else {
                        horarioMostrar += (minutosMostrar);
                    }
                    combo.addItem(horarioMostrar);
                }

                minutos = duracion % 60;
                horas = duracion / 60;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int horaAInt(String hora) {
        String horasString = "";
        String minutosString = "";
        int horaInt = 0;
        int minutosInt = 0;
        for (int i = 0; i < 2; i++) {
            horasString += hora.charAt(i);
        }
        for (int i = 3; i < 5; i++) {
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
        ventaAgregar[0] = venta.getIdConceptoEs().getConceptoTo();
        ventaAgregar[1] = venta.getHoraAsignado();

        dt.addRow(ventaAgregar);

        vista.tableEstudios.setModel(dt);

    }

    private void agregarVentaConcepto() {

        if (!ordenVentaGenerada) {
            generarOrdenVenta(fechaActualXml);
        }

        generarVentaConceptos();

        registrarVenta();

        obtenerVentaHecha();
        
        agregarATabla(venta);
        
        agenda();

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
        if (vista.comboHora.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private void generarOrdenVenta(XMLGregorianCalendar fechaActualXml) {
        CatalogoFormaPago formaPago = new CatalogoFormaPago();
        formaPago.setIdFp(Short.parseShort("1"));

        //Este constructor de mierda es culpa de tantos datos de mierda en la base de datos
        orden = new OrdenVenta(
                0f,
                0f,
                0f,
                0f,
                0f,
                0,
                0,
                0,
                0,
                0,
                0,
                Short.parseShort("0"),
                Short.parseShort("0"),
                fechaActualXml,
                0f,
                formaPago,
                0l,
                0, 0,
                0,
                0,
                0,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                Short.parseShort("0"),
                Short.parseShort("0"),
                Short.parseShort("0"),
                Short.parseShort("0"),
                Short.parseShort("0"),
                ordenVentaGenerada,
                0,
                Short.parseShort("0"),
                "",
                ordenVentaGenerada,
                0f,
                0f,
                0f,
                0f,
                0f,
                0,
                0, 0, 0, 0, 0, 0,
                0f,
                0f,
                0f,
                0f,
                0f,
                0);

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

}
