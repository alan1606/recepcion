/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.InstitucionDao;
import DAO.InstitucionDaoImp;
import DAO.OrdenVentaDao;
import DAO.OrdenVentaDaoImp;
import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import DAO.VentaConceptosDao;
import DAO.VentaConceptosDaoImp;
import Tables.TableConceptos;
import Tables.TableOrdenesVenta;
import Vistas.DatosFacturacion;
import Vistas.Menu;
import Vistas.PagarOrden;
import clientews.servicio.Institucion;
import clientews.servicio.Pacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author alanm
 */
public class PagarOrdenController implements ActionListener, PropertyChangeListener, MouseListener {

    private PagarOrden vistaPrincipal;
    private DatosFacturacion vistaFacturacion;
    private OrdenVentaDao modeloOrdenesVenta;
    private VentaConceptosDao modeloVentaConceptos;
    private PacientesDao modeloPacientes;
    private ArrayList<Pacientes> pacientes;
    private Pacientes pacienteSeleccionado;
    private InstitucionDao modeloInstituciones;

    public PagarOrdenController(PagarOrden vistaPrincipal, DatosFacturacion vistaFacturacion) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaFacturacion = vistaFacturacion;

        modeloOrdenesVenta = new OrdenVentaDaoImp();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloPacientes = new PacientesDaoImp();
        modeloInstituciones = new InstitucionDaoImp();

        this.vistaPrincipal.btnAgregar.addActionListener(this);
        this.vistaPrincipal.comboPaciente.addActionListener(this);
        this.vistaPrincipal.dateFecha.addPropertyChangeListener(this);
        this.vistaPrincipal.tableOrdenes.addMouseListener(this);
        this.vistaPrincipal.btnRegresar.addActionListener(this);

        cargarPacientes();
    }

    public void iniciar() {
        vistaPrincipal.setTitle("Pagar órdenes");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.comboPaciente) {
            if (vistaPrincipal.comboPaciente.getSelectedIndex() != 0) {
                pacienteSeleccionado = pacientes.get(vistaPrincipal.comboPaciente.getSelectedIndex() - 1);
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
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == vistaPrincipal.dateFecha) {
            if (vistaPrincipal.dateFecha.getDate() != null) {
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
                cargarEstudios(idOrden);
                cargarTotal();
                cargarInstitucion();
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
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, modeloOrdenesVenta.obtenerConfirmadosEnFecha(fecha));
    }

    private void cargarEstudios(Long idOrden) {
        TableConceptos tableConceptos = new TableConceptos();
        tableConceptos.cargarTablaEnPagos(vistaPrincipal.tableEstudios, modeloVentaConceptos.findByIdOrdenVenta(idOrden));
    }

    private void cargarPacientes() {
        pacientes = (ArrayList<Pacientes>) modeloPacientes.encontrarTodos();
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Pacientes pacientesFor : pacientes) {
                combo.addItem(pacientesFor.getNombreCompletoP());
            }
            vistaPrincipal.comboPaciente.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void buscarPorPaciente(Long idPaciente) {
        TableOrdenesVenta tableOrdenesVenta = new TableOrdenesVenta();
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, modeloOrdenesVenta.obtenerConfirmadosPaciente(idPaciente));
    }

    private void buscarPorFechaYPaciente(String fecha, Long idPaciente) {
        TableOrdenesVenta tableOrdenesVenta = new TableOrdenesVenta();
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, modeloOrdenesVenta.obtenerConfirmadosFechaPaciente(fecha, idPaciente));
    }

    private void cargarTablaConceptosVacia() {
        TableConceptos tableConceptos = new TableConceptos();
        tableConceptos.cargarTablaVacia(vistaPrincipal.tableEstudios);
    }

    private void cargarTotal() {
        vistaPrincipal.txtTotal.setText(vistaPrincipal.tableOrdenes.getValueAt(vistaPrincipal.tableOrdenes.getSelectedRow(), 1).toString());
    }

    private void cargarInstitucion() {
        Institucion institucion = modeloInstituciones.findInstitucionByIdOrdenVenta(Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(vistaPrincipal.tableOrdenes.getSelectedRow(), 0).toString()));
        vistaPrincipal.txtInstitucion.setText(institucion.getNombreInstitucion());
        if (institucion.getNombreInstitucion().equals("PARTICULAR")) {
            habilitarPagos(true);
            vistaPrincipal.checkFactura.setSelected(false);
        }
        else{
            habilitarPagos(false);
            vistaPrincipal.checkFactura.setSelected(true);
        }

    }

    private void habilitarPagos(boolean valor) {
        vistaPrincipal.comboFormaPago.setEnabled(valor);
        vistaPrincipal.txtCantidad.setEnabled(valor);
        vistaPrincipal.btnAgregar.setEnabled(valor);
    }

}
