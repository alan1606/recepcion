/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CatalogoFormaPagoDao;
import DAO.CatalogoFormaPagoDaoImp;
import DAO.InstitucionDao;
import DAO.InstitucionDaoImp;
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
import Vistas.DatosFacturacion;
import Vistas.Menu;
import Vistas.PagarOrden;
import clientews.servicio.CatalogoFormaPago;
import clientews.servicio.Institucion;
import clientews.servicio.OrdenVenta;
import clientews.servicio.Pacientes;
import clientews.servicio.PagoOrdenVenta;
import clientews.servicio.VentaConceptos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    private CatalogoFormaPagoDao modeloFormasDePago;
    private ArrayList<CatalogoFormaPago> formasDePago;
    private CatalogoFormaPago formaPagoSeleccionada;
    private PagoOrdenVentaDao modeloPagoOrdenVenta;
    private OrdenVenta ordenSeleccionada;
    private ArrayList<VentaConceptos> estudiosDeOrden;

    public PagarOrdenController(PagarOrden vistaPrincipal, DatosFacturacion vistaFacturacion) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaFacturacion = vistaFacturacion;

        modeloOrdenesVenta = new OrdenVentaDaoImp();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloPacientes = new PacientesDaoImp();
        modeloInstituciones = new InstitucionDaoImp();
        modeloFormasDePago = new CatalogoFormaPagoDaoImp();
        modeloPagoOrdenVenta = new PagoOrdenVentaDaoImp();
        ordenSeleccionada = new OrdenVenta();

        this.vistaPrincipal.btnAgregar.addActionListener(this);
        this.vistaPrincipal.comboPaciente.addActionListener(this);
        this.vistaPrincipal.dateFecha.addPropertyChangeListener(this);
        this.vistaPrincipal.tableOrdenes.addMouseListener(this);
        this.vistaPrincipal.btnRegresar.addActionListener(this);
        this.vistaPrincipal.comboFormaPago.addActionListener(this);
        this.vistaPrincipal.btnPagar.addActionListener(this);
        this.vistaPrincipal.checkFactura.addActionListener(this);

        this.vistaFacturacion.btnGuardar.addActionListener(this);
    }

    public void iniciar() {
        vistaPrincipal.setTitle("Pagar órdenes");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
        cargarPacientes();
        cargarFormasDePago();
        iniciarTablaPagos();
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
        } else if (e.getSource() == vistaPrincipal.btnAgregar) {
            if (vistaPrincipal.comboFormaPago.getSelectedIndex() != 0 && !vistaPrincipal.txtCantidad.getText().equals("")) {
                if (esNumeroCantidad(vistaPrincipal.txtCantidad.getText())) {
                    double cantidad = Double.parseDouble(vistaPrincipal.txtCantidad.getText());
                    double total = Double.parseDouble(vistaPrincipal.txtTotal.getText());
                    double subtotalAcumuladoEnTabla = sumarSubPagos();
                    if (cantidad + subtotalAcumuladoEnTabla <= total) {
                        //Ya se completó la cantidad, exactamente, hay que registrar el pago
                        // o
                        //Aún no se completa para pagar, aún asi hay que registrar el pago
                        agregarATablaPagos(formaPagoSeleccionada.getFormaPagoFp(), cantidad);
                        vistaPrincipal.txtSubtotal.setText((cantidad + subtotalAcumuladoEnTabla) + "");
                    } else {
                        /*
                        Ya se pasó, hay que dar cambio, este caso puede suceder solo cuando en las formas de pago se incluye el efectivo, 
                        porque si se va a cobrar con tarjeta lo normal es que se pague exacto, el caso en el que hay que devolver dinero es que el efetivo que se va a pagar
                        es mayor a lo restante, por lo tanto, se le entrega efectivo, sin embargo, en la base de datos no hay que hacer ningún cambio
                        solamente mostrar en el cliente que hay que devolver cambio en efectivo y la cantidad, 
                        En el registro de la base de datos, el dinero ingresado en efectivo es solamnente lo restante, puesto que ya se le hubo entregado su cambio 
                         */
                        agregarATablaPagos("EFECTIVO", total - subtotalAcumuladoEnTabla);
                        vistaPrincipal.txtSubtotal.setText(total + "");
                        JOptionPane.showMessageDialog(null, "Regresar $" + ((subtotalAcumuladoEnTabla + cantidad) - total) + " de cambio en efectivo");
                    }
                    limpiarPago();
                }
            }
        } else if (e.getSource() == vistaPrincipal.comboFormaPago) {
            if (vistaPrincipal.comboFormaPago.getSelectedIndex() != 0) {
                formaPagoSeleccionada = formasDePago.get(vistaPrincipal.comboFormaPago.getSelectedIndex() - 1);
            }
        } else if (e.getSource() == vistaPrincipal.btnPagar) {
            if (datosValidos() && deseaPagar() == 0) {
                procesarPago();
            }
        } else if (e.getSource() == vistaFacturacion.btnGuardar) {
            if (datosFacturacionValidos()) {
                actualizarDatosFacturacion();
                limpiarFacturacion();
                vistaFacturacion.dispose();
            }
        } else if (e.getSource() == vistaPrincipal.checkFactura) {
            if (vistaPrincipal.checkFactura.isSelected()) {
                ordenSeleccionada.setRequiereFactura(true);
                pedirDatosFacturacion();
            } else {
                ordenSeleccionada.setRequiereFactura(false);
            }
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
        estudiosDeOrden = (ArrayList<VentaConceptos>) modeloVentaConceptos.findByIdOrdenVenta(idOrden);
        tableConceptos.cargarTablaEnPagos(vistaPrincipal.tableEstudios, estudiosDeOrden);
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
        } else {
            habilitarPagos(false);
            vistaPrincipal.checkFactura.setSelected(true);
        }

    }

    private void habilitarPagos(boolean valor) {
        vistaPrincipal.comboFormaPago.setEnabled(valor);
        vistaPrincipal.txtCantidad.setEnabled(valor);
        vistaPrincipal.btnAgregar.setEnabled(valor);
    }

    private void cargarFormasDePago() {
        formasDePago = (ArrayList<CatalogoFormaPago>) modeloFormasDePago.obtenerFormasDePago();
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (CatalogoFormaPago formaPagoFor : formasDePago) {
                combo.addItem(formaPagoFor.getFormaPagoFp());
            }
            vistaPrincipal.comboFormaPago.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private boolean esNumeroCantidad(String text) {
        double numero = 0;
        try {
            numero = Double.parseDouble(vistaPrincipal.txtCantidad.getText());
        } catch (Exception e) {
        }
        return numero != 0;
    }

    private double sumarSubPagos() {
        double total = 0;
        for (int i = 0; i < vistaPrincipal.tablePagos.getRowCount(); i++) {
            total += Double.parseDouble(vistaPrincipal.tablePagos.getValueAt(i, 1).toString());
        }
        return total;
    }

    private void agregarATablaPagos(String formaPagoFp, double cantidad) {
        boolean yaExistia = false;
        for (int i = 0; i < vistaPrincipal.tablePagos.getRowCount(); i++) {
            if (vistaPrincipal.tablePagos.getValueAt(i, 0).toString().equals(formaPagoFp)) {
                yaExistia = true;
                double existente = Double.parseDouble(vistaPrincipal.tablePagos.getValueAt(i, 1).toString());
                actualizarSubTotalEnFila(i, existente + cantidad);
                break;
            }
        }
        if (!yaExistia) {
            agregarATabla(formaPagoFp, cantidad);
        }
    }

    private void actualizarSubTotalEnFila(int fila, double cantidad) {
        vistaPrincipal.tablePagos.setValueAt(cantidad, fila, 1);
    }

    private void agregarATabla(String formaPagoFp, double cantidad) {
        DefaultTableModel dt = (DefaultTableModel) vistaPrincipal.tablePagos.getModel();

        Object[] ventaAgregar = new Object[2];
        ventaAgregar[0] = formaPagoFp;
        ventaAgregar[1] = cantidad;

        dt.addRow(ventaAgregar);

        vistaPrincipal.tablePagos.setModel(dt);
    }

    private void iniciarTablaPagos() {
        DefaultTableModel dt = new DefaultTableModel();

        dt.addColumn("Método");
        dt.addColumn("Total");

        vistaPrincipal.tablePagos.setModel(dt);
    }

    private void limpiarPago() {
        vistaPrincipal.comboFormaPago.setSelectedIndex(0);
        vistaPrincipal.txtCantidad.setText("");
    }

    private void procesarPago() {
        if (vistaPrincipal.txtInstitucion.getText().equals("PARTICULAR")) {
            procesarPagoParticular();
        } else {
            procesarPagoNoParticular();
        }
    }

    private void procesarPagoParticular() {
        if (datosValidosPagoParticular()) {
            PagoOrdenVenta pago = new PagoOrdenVenta();
            CatalogoFormaPago formaPagoTemporal;
            String formaPagoTabla = "";
            double cantidadTabla = 0d;
            String fechaActual = dateToStringOrdenVenta();
            ordenSeleccionada = modeloOrdenesVenta.obtenerOrdenVentaPorId(Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(vistaPrincipal.tableOrdenes.getSelectedRow(), 0).toString()));
            ordenSeleccionada.setPagado(true);
            ordenSeleccionada.setFechaVentaOv(fechaActual);
            pago.setIdOrdenVenta(ordenSeleccionada);

            if (vistaPrincipal.checkFactura.isSelected()) {
                ordenSeleccionada.setRequiereFactura(true);
                while (pacienteSeleccionado.getRazonSocialP().equals("") || pacienteSeleccionado.getRfcP().equals("")) {
                    pedirDatosFacturacion();
                }
            }

            for (int i = 0; i < vistaPrincipal.tablePagos.getRowCount(); i++) {
                formaPagoTabla = vistaPrincipal.tablePagos.getValueAt(i, 0).toString();
                System.out.println(formaPagoTabla);
                formaPagoTemporal = encontrarFormaPago(formaPagoTabla);
                cantidadTabla = Double.parseDouble(vistaPrincipal.tablePagos.getValueAt(i, 1).toString());
                pago.setCantidad(cantidadTabla);
                pago.setIdFormaPago(formaPagoTemporal);
                modeloPagoOrdenVenta.registrarPagoOrdenVenta(pago);
                System.out.println("me vengoooooooooo");
            }

            modeloOrdenesVenta.actualizar(ordenSeleccionada);

            for (VentaConceptos venta : estudiosDeOrden) {
                venta.setEstado("PAGADO");
                venta.setFechaVentaVc(fechaActual);
                modeloVentaConceptos.actualizarVentaConceptos(venta);
            }

            limpiarTablaOrdenes();
            limpiarTablaEstudios();
            limpiarTablaPagos();
            limpiar();

        }
    }

    private void procesarPagoNoParticular() {

        PagoOrdenVenta pago = new PagoOrdenVenta();
        CatalogoFormaPago formaPagoTemporal = new CatalogoFormaPago();
        String fechaActual = dateToStringOrdenVenta();
        ordenSeleccionada = modeloOrdenesVenta.obtenerOrdenVentaPorId(Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(vistaPrincipal.tableOrdenes.getSelectedRow(), 0).toString()));
        ordenSeleccionada.setPagado(true);
        ordenSeleccionada.setFechaVentaOv(fechaActual);
        pago.setIdOrdenVenta(ordenSeleccionada);

        if (vistaPrincipal.checkFactura.isSelected()) {
            ordenSeleccionada.setRequiereFactura(true);
        }

        formaPagoTemporal.setIdFp(Short.parseShort("3")); //Es trasnferencia 
        pago.setCantidad(0);
        pago.setIdFormaPago(formaPagoTemporal);
        modeloPagoOrdenVenta.registrarPagoOrdenVenta(pago);
        System.out.println("me vengoooooooooo");

        modeloOrdenesVenta.actualizar(ordenSeleccionada);

        for (VentaConceptos venta : estudiosDeOrden) {
            venta.setEstado("PAGADO");
            venta.setFechaVentaVc(fechaActual);
            modeloVentaConceptos.actualizarVentaConceptos(venta);
        }

        limpiarTablaOrdenes();
        limpiarTablaEstudios();
        limpiarTablaPagos();
        limpiar();

    }

    private boolean datosValidosPagoParticular() {
        if (vistaPrincipal.tablePagos.getRowCount() == 0) {
            return false;
        }
        return true;
    }

    private void pedirDatosFacturacion() {
        vistaFacturacion.setTitle("Registrar datos");
        vistaFacturacion.setLocationRelativeTo(null);
        vistaFacturacion.setVisible(true);

        vistaFacturacion.txtNombre.setText(pacienteSeleccionado.getRazonSocialP());
        vistaFacturacion.txtRfc.setText(pacienteSeleccionado.getRfcP());
    }

    private CatalogoFormaPago encontrarFormaPago(String formaPagoTabla) {
        for (CatalogoFormaPago temporal : formasDePago) {
            if (temporal.getFormaPagoFp().equals(formaPagoTabla)) {
                return temporal;
            }
        }
        return new CatalogoFormaPago();
    }

    private boolean datosFacturacionValidos() {
        if (vistaFacturacion.txtNombre.getText().equals("")) {
            return false;
        }
        if (vistaFacturacion.txtRfc.getText().equals("")) {
            return false;
        }
        return true;
    }

    private void actualizarDatosFacturacion() {
        pacienteSeleccionado.setRazonSocialP(vistaFacturacion.txtNombre.getText());
        pacienteSeleccionado.setRfcP(vistaFacturacion.txtRfc.getText());
        modeloPacientes.actualizar(pacienteSeleccionado);
    }

    private void limpiarFacturacion() {
        vistaFacturacion.txtNombre.setText("");
        vistaFacturacion.txtRfc.setText("");
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

    private void limpiarTablaPagos() {
        DefaultTableModel dt = (DefaultTableModel) vistaPrincipal.tablePagos.getModel();

        while (dt.getRowCount() > 0) {
            dt.removeRow(0);
        }

        vistaPrincipal.tablePagos.setModel(dt);
    }

    private void limpiar() {
        vistaPrincipal.dateFecha.setDate(null);
        vistaPrincipal.comboPaciente.setSelectedIndex(0);
        vistaPrincipal.txtInstitucion.setText("");
        vistaPrincipal.txtTotal.setText("");
        vistaPrincipal.txtCantidad.setText("");
        vistaPrincipal.txtSubtotal.setText("");
        vistaPrincipal.checkFactura.setSelected(false);
        ordenSeleccionada.setRequiereFactura(false);
        vistaPrincipal.comboFormaPago.setSelectedIndex(0);

    }

    private int deseaPagar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea pagar la órden? ", "Confirmar", dialog));
    }

    private boolean datosValidos() {
        double total = 0d;
        double subtotal = 0d;
        if (vistaPrincipal.tableOrdenes.getSelectedRow() == -1) {
            return false;
        }
        try {
            total = Double.parseDouble(vistaPrincipal.txtTotal.getText().toString());

            if (vistaPrincipal.txtInstitucion.getText().equals("PARTICULAR")) {
                subtotal = Double.parseDouble(vistaPrincipal.txtSubtotal.getText().toString());
            }
        } catch (Exception e) {
            return false;
        }
        if (subtotal < total) {
            return false;
        }
        return true;
    }

    private String dateToStringOrdenVenta() {
        Long date = new Date().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
