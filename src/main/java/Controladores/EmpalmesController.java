/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.AreasDao;
import DAO.AreasDaoImpl;
import DAO.EquipoDicomDao;
import DAO.EquipoDicomDaoImp;
import DAO.OrdenVentaDao;
import DAO.OrdenVentaDaoImp;
import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import DAO.VentaConceptosDao;
import DAO.VentaConceptosDaoImp;
import DAO.WorklistDao;
import DAO.WorklistDaoImp;
import Tables.TableConceptos;
import Tables.TableOrdenesVenta;
import Utilidades.BarUtil;
import Utilidades.DateUtil;
import Vistas.Empalmes;
import Vistas.Menu;
import clientews.servicio.Areas;
import clientews.servicio.EquipoDicom;
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
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alanm
 */
public class EmpalmesController implements ActionListener, PropertyChangeListener, MouseListener, KeyListener {

    private Empalmes vistaPrincipal;
    private OrdenVentaDao modeloOrdenesVenta;
    private VentaConceptosDao modeloVentaConceptos;
    private PacientesDao modeloPacientes;
    private Pacientes pacienteSeleccionado;
    private OrdenVenta ordenSeleccionada;
    private ArrayList<VentaConceptos> estudiosDeOrden;
    private Areas area;
    private EquipoDicom sala;
    private AreasDao modeloAreas;
    private EquipoDicomDao modeloEquipoDicom;
    private VentaConceptos estudioSeleccionado;
    private WorklistDao modeloWorklist;
    
    public EmpalmesController(Empalmes vista) {
        this.vistaPrincipal = vista;

        modeloOrdenesVenta = new OrdenVentaDaoImp();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloAreas = new AreasDaoImpl();
        modeloEquipoDicom = new EquipoDicomDaoImp();
        modeloPacientes = new PacientesDaoImp();
        modeloWorklist = new WorklistDaoImp();
        ordenSeleccionada = new OrdenVenta();

        this.vistaPrincipal.btnGuardar.addActionListener(this);
        this.vistaPrincipal.comboPaciente.addActionListener(this);
        this.vistaPrincipal.dateFecha.addPropertyChangeListener(this);
        this.vistaPrincipal.dateNuevaFecha.addPropertyChangeListener(this);
        this.vistaPrincipal.tableOrdenes.addMouseListener(this);
        this.vistaPrincipal.tableEstudios.addMouseListener(this);
        this.vistaPrincipal.btnRegresar.addActionListener(this);
        this.vistaPrincipal.txtPaciente.addKeyListener(this);
        this.vistaPrincipal.btnSalir.addActionListener(this);
        this.vistaPrincipal.btnMin.addActionListener(this);
    }

    public void iniciar() {
        vistaPrincipal.setTitle("Empalmes");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);

        cargarPacienteVacio();
        cargarHoraVacio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.comboPaciente) {
            if (vistaPrincipal.comboPaciente.getSelectedIndex() != 0) {
                pacienteSeleccionado = buscarPacientePorId(obtenerIdPacienteDeComboBox());
                if (vistaPrincipal.dateFecha.getDate() != null) {
                    buscarPorFechaYPaciente(dateToString(vistaPrincipal.dateFecha.getDate().getTime()), pacienteSeleccionado.getIdP());
                } else {
                    buscarPorPaciente(pacienteSeleccionado.getIdP());
                }
            } else {
                if (vistaPrincipal.dateFecha.getDate() != null) {
                    mostrarOrdenes(dateToString(vistaPrincipal.dateFecha.getDate().getTime()));
                }
            }
            if (vistaPrincipal.tableOrdenes.getRowCount() == 0) {
                cargarTablaConceptosVacia();
            }
        } else if (e.getSource() == vistaPrincipal.btnRegresar) {
            vistaPrincipal.dispose();
            Menu vista = new Menu();
            MenuController menu = new MenuController(vista);
            menu.iniciar();
        } else if (e.getSource() == vistaPrincipal.btnGuardar) {
            if (datosValidos()) {
                estudioSeleccionado.setHoraAsignado(vistaPrincipal.comboHora.getSelectedItem().toString());
                estudioSeleccionado.setFechaAsignado(DateUtil.dateToString(vistaPrincipal.dateNuevaFecha.getDate().getTime()));
                if (enRealidadEstaDisponibleElEstudio()) {
                    if (deseaActualizar() == 0) {
                        actualizarEstudio();
                         if (estudioSeleccionado.isEnWorklist()) {
                            modeloWorklist.registrarEnWorklist(estudioSeleccionado.getIdVc());
                            System.out.println("Actualic?? la worklist");
                        } else {
                            System.out.println("No hay que registrar en worklist");
                        }
                        cargarEstudios(ordenSeleccionada.getIdOv());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Se acaba de agendar un estudio en esa hora, intente otra");
                }

                cargarHoraVacio();
                vistaPrincipal.dateNuevaFecha.setDate(null);
                    
            }
        }
        else if(e.getSource() == vistaPrincipal.btnSalir){
            BarUtil.cerrar(vistaPrincipal);
        }
        else if(e.getSource() == vistaPrincipal.btnMin){
            BarUtil.minimizar(vistaPrincipal);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == vistaPrincipal.dateFecha) {
            if (vistaPrincipal.dateFecha.getDate() != null) {

                //Este c??digo lo puedo simplificar en una funcion
                if (vistaPrincipal.comboPaciente.getSelectedIndex() == 0) {
                    mostrarOrdenes(dateToString(vistaPrincipal.dateFecha.getDate().getTime()));
                } else {
                    buscarPorFechaYPaciente(dateToString(vistaPrincipal.dateFecha.getDate().getTime()), pacienteSeleccionado.getIdP());
                }
            } else {
                if (vistaPrincipal.comboPaciente.getSelectedIndex() != 0) {
                    buscarPorPaciente(pacienteSeleccionado.getIdP());
                }
            }
            if (vistaPrincipal.tableOrdenes.getRowCount() == 0) {
                cargarTablaConceptosVacia();
            }
        } else if (evt.getSource() == vistaPrincipal.dateNuevaFecha) {
            //checar agenda
            if (vistaPrincipal.tableEstudios.getSelectedRow() != -1) {
                agenda();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaPrincipal.tableOrdenes) {
            int fila = vistaPrincipal.tableOrdenes.getSelectedRow();
            if (fila != -1) {
                Long idOrden = Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(fila, 0).toString());
                Long idPaciente = Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(fila, 4).toString());
                cargarEstudios(idOrden);
                pacienteSeleccionado = buscarPacientePorId(idPaciente);
            }
        }
        if (e.getSource() == vistaPrincipal.tableEstudios) {
            //Obtener area y sala
            if (vistaPrincipal.tableEstudios.getSelectedRow() != -1) {
                Long id = Long.parseLong(vistaPrincipal.tableEstudios.getValueAt(vistaPrincipal.tableEstudios.getSelectedRow(), 0).toString());
                System.out.println(id);
                estudioSeleccionado = modeloVentaConceptos.findById(id);
                sala = estudioSeleccionado.getIdEquipoDicom();
                area = sala.getIdArea();
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

    private String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private void mostrarOrdenes(String fecha) {
        TableOrdenesVenta tableOrdenesVenta = new TableOrdenesVenta();
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, modeloOrdenesVenta.obtenerOrdenVentaConfirmadasPagadasEnFecha(fecha));
    }

    private void cargarEstudios(Long idOrden) {
        TableConceptos tableConceptos = new TableConceptos();
        estudiosDeOrden = (ArrayList<VentaConceptos>) modeloVentaConceptos.findByIdOrdenVenta(idOrden);
        tableConceptos.cargarTablaEnPagos(vistaPrincipal.tableEstudios, estudiosDeOrden);
    }

    private void cargarPacientes() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCI??N");
            for (Pacientes pacientesFor : modeloPacientes.buscarLikeNombre(vistaPrincipal.txtPaciente.getText())) {
                combo.addItem(pacientesFor.getNombreCompletoP() + " :" + pacientesFor.getIdP());
            }
            vistaPrincipal.comboPaciente.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void buscarPorPaciente(Long idPaciente) {
        TableOrdenesVenta tableOrdenesVenta = new TableOrdenesVenta();
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, modeloOrdenesVenta.obtenerOrdenVentaConfirmadasPagadasPaciente(idPaciente));
    }

    private void buscarPorFechaYPaciente(String fecha, Long idPaciente) {
        TableOrdenesVenta tableOrdenesVenta = new TableOrdenesVenta();
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, modeloOrdenesVenta.obtenerOrdenVentaConfirmadasPagadasFechaPaciente(fecha, idPaciente));
    }

    private void cargarTablaConceptosVacia() {
        TableConceptos tableConceptos = new TableConceptos();
        tableConceptos.cargarTablaVacia(vistaPrincipal.tableEstudios);
    }

    private void limpiarTablaOrdenes() {

        DefaultTableModel dt = (DefaultTableModel) vistaPrincipal.tableOrdenes.getModel();

        while (dt.getRowCount() > 0) {
            dt.removeRow(0);
        }

        vistaPrincipal.tableOrdenes.setModel(dt);

    }

    private void limpiarTablaEstudios() {
        DefaultTableModel dt = (DefaultTableModel) vistaPrincipal.tableEstudios.getModel();

        while (dt.getRowCount() > 0) {
            dt.removeRow(0);
        }

        vistaPrincipal.tableEstudios.setModel(dt);
    }

    private void limpiar() {
        vistaPrincipal.dateFecha.setDate(null);
        vistaPrincipal.comboPaciente.setSelectedIndex(0);

    }

    private String dateToStringOrdenVenta() {
        Long date = new Date().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private Pacientes buscarPacientePorId(Long idPaciente) {
        return modeloPacientes.buscarPorId(idPaciente);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaPrincipal.txtPaciente && !vistaPrincipal.txtPaciente.getText().equals("")) {
            cargarPacientes();
        }

    }

    private void cargarPacienteVacio() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCI??N");

            vistaPrincipal.comboPaciente.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void agenda() {
        System.out.println("Buscando agenda");
        int horaInicio = horaAInt(area.getHoraInicio().toString(), 0, 3);
        int horaFin = horaAInt(area.getHoraFin().toString(), 0, 3);
        boolean par = false;
        boolean alternador = true;

        if (area.getDuracionMinutos() % 2 == 0) {
            par = true;
        }

        int duracion = area.getDuracionMinutos() / 2;

        String fecha = dateToString(vistaPrincipal.dateNuevaFecha.getDate().getTime());

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
            combo.addItem("SELECCIONE UNA OPCI??N");

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

            vistaPrincipal.comboHora.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
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

    private boolean estaOcupadaHora(int hora, List<Integer> horasList) {
        return horasList.contains(hora);
    }

    private boolean datosValidos() {
        if (vistaPrincipal.tableEstudios.getSelectedRow() == -1) {
            return false;
        }
        if (vistaPrincipal.dateNuevaFecha.getDate() == null) {
            return false;
        }
        if (vistaPrincipal.comboHora.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private void actualizarEstudio() {
        modeloVentaConceptos.actualizarVentaConceptos(estudioSeleccionado);
        JOptionPane.showMessageDialog(null, "Estudio actualizado");
    }

    private boolean enRealidadEstaDisponibleElEstudio() {
        Long agendados = modeloVentaConceptos.encontrarNumeroVentaConceptosPorEquipoFechaHora(sala, estudioSeleccionado.getFechaAsignado(), estudioSeleccionado.getHoraAsignado());
        return agendados == 0;
    }

    private int deseaActualizar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "Confirme con " + pacienteSeleccionado.getNombreCompletoP() + "\nAl tel??fono " + pacienteSeleccionado.getTCelularp() + "\n\n??Desea reagendar la cita?", "Confirmar", dialog));
    }

    private Long obtenerIdPacienteDeComboBox() {
        String id = "";
        Long idPaciente = 0l;
        boolean dosPuntosSuperado = false;
        String texto = vistaPrincipal.comboPaciente.getSelectedItem().toString();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ':') {
                dosPuntosSuperado = true;
            } else if (dosPuntosSuperado) {
                id += texto.charAt(i);
            }
        }
        System.out.println(id);
        return Long.parseLong(id);
    }

    private void cargarHoraVacio() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCI??N");

            vistaPrincipal.comboHora.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
