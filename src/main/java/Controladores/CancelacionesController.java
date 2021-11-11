/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import DAO.OrdenVentaDao;
import DAO.OrdenVentaDaoImp;
import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import DAO.PagoOrdenVentaDao;
import DAO.PagoOrdenVentaDaoImp;
import DAO.VentaConceptosDao;
import DAO.VentaConceptosDaoImp;
import Tables.TableConceptos;
import Tables.TableOrdenesVenta;
import Utilidades.BarUtil;
import Vistas.Cancelaciones;
import Vistas.Menu;
import clientews.servicio.Areas;
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
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alanm
 */
public class CancelacionesController implements ActionListener, PropertyChangeListener, MouseListener, KeyListener {

    private Cancelaciones vistaPrincipal;
    private OrdenVentaDao modeloOrdenesVenta;
    private VentaConceptosDao modeloVentaConceptos;
    private PacientesDao modeloPacientes;
    private PagoOrdenVentaDao modeloPagos;
    private Pacientes pacienteSeleccionado;
    private OrdenVenta ordenSeleccionada;
    private ArrayList<VentaConceptos> estudiosDeOrden;
    private Areas area;
    private EquipoDicom sala;
    private VentaConceptos estudioSeleccionado;
    private Institucion institucion;
    private String fechaSeleccionada;

    public CancelacionesController(Cancelaciones vista) {
        this.vistaPrincipal = vista;

        modeloOrdenesVenta = new OrdenVentaDaoImp();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloPacientes = new PacientesDaoImp();
        modeloPagos = new PagoOrdenVentaDaoImp();
        ordenSeleccionada = new OrdenVenta();

        
        this.vistaPrincipal.btnCancelar.addActionListener(this);
        this.vistaPrincipal.comboPaciente.addActionListener(this);
        this.vistaPrincipal.dateFecha.addPropertyChangeListener(this);
        this.vistaPrincipal.tableOrdenes.addMouseListener(this);
        this.vistaPrincipal.btnRegresar.addActionListener(this);
        this.vistaPrincipal.txtPaciente.addKeyListener(this);
        
        this.vistaPrincipal.btnSalir.addActionListener(this);
        this.vistaPrincipal.btnMin.addActionListener(this);
    }

    public void iniciar() {
        vistaPrincipal.setTitle("Cancelaciones");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);

        cargarPacienteVacio();
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
        } else if (e.getSource() == vistaPrincipal.btnCancelar) {
            if (datosValidos()) {
                System.out.println(modeloVentaConceptos.esCandidatoParaEliminarConceptosDeOrden(ordenSeleccionada.getIdOv()));
                if (modeloVentaConceptos.esCandidatoParaEliminarConceptosDeOrden(ordenSeleccionada.getIdOv()) < 1) {
                    if (deseaCancelar() == 0) {
                        eliminarVentaConceptos();
                        eliminarPagosOrdenVenta();
                        eliminarOrdenVenta();
                        limpiar();
                        limpiarTablaOrdenes();
                        limpiarTablaEstudios();
                        JOptionPane.showMessageDialog(null, "Se ha cancelado la órden");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar la órden porque ya ha sido tomado un estudio de esta");
                }

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
                //Este código lo puedo simplificar en una funcion
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
                ordenSeleccionada = modeloOrdenesVenta.obtenerOrdenVentaPorId(idOrden);
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
            combo.addItem("SELECCIONE UNA OPCIÓN");
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
        System.out.println(modeloOrdenesVenta.obtenerOrdenVentaConfirmadasPagadasPaciente(idPaciente).size());
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
        vistaPrincipal.txtPaciente.setText("");
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

    private boolean datosValidos() {
        if (vistaPrincipal.tableOrdenes.getSelectedRow() == -1) {
            return false;
        }
        return true;
    }

    private int deseaCancelar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la órden?", "Confirmar", dialog));
    }

    private ComboBoxModel comboBoxVacio(JComboBox combo) {
        try {
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return combo.getModel();
    }

    private void cargarPacienteVacio() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");

            vistaPrincipal.comboPaciente.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
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

    private void eliminarVentaConceptos() {
        modeloVentaConceptos.eliminarVentaConceptosPorIdOrdenVenta(ordenSeleccionada.getIdOv());
        System.out.println("Venta conceptos eliminados");
    }

    private void eliminarOrdenVenta() {
        modeloOrdenesVenta.eliminarOrdenVenta(ordenSeleccionada);
        System.out.println("Órden seleccionada");
    }

    private void eliminarPagosOrdenVenta() {
        modeloPagos.eliminarPagoOrdenVentaPorIdOrdenVenta(ordenSeleccionada.getIdOv());
    }

}
