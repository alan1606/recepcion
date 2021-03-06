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
import DAO.UsuariosDao;
import DAO.UsuariosDaoImpl;
import DAO.VentaConceptosDao;
import DAO.VentaConceptosDaoImp;
import DAO.WorklistDao;
import DAO.WorklistDaoImp;
import Tables.TableConceptos;
import Tables.TableOrdenesVenta;
import Utilidades.BarUtil;
import Utilidades.Md5Util;
import Vistas.DatosFacturacionVista;
import Vistas.Menu;
import Vistas.PagarCortesia;
import Vistas.PagarOrden;
import clientews.servicio.CatalogoFormaPago;
import clientews.servicio.Institucion;
import clientews.servicio.OrdenVenta;
import clientews.servicio.Pacientes;
import clientews.servicio.PagoOrdenVenta;
import clientews.servicio.Usuarios;
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
import java.util.Arrays;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alanm
 */
public class PagarOrdenController implements ActionListener, PropertyChangeListener, MouseListener, KeyListener {

    private PagarOrden vistaPrincipal;
    private OrdenVentaDao modeloOrdenesVenta;
    private VentaConceptosDao modeloVentaConceptos;
    private PacientesDao modeloPacientes;
    private WorklistDao modeloWorklist;
    private Pacientes pacienteSeleccionado;
    private InstitucionDao modeloInstituciones;
    private CatalogoFormaPagoDao modeloFormasDePago;
    private CatalogoFormaPago formaPagoSeleccionada;
    private PagoOrdenVentaDao modeloPagoOrdenVenta;
    private OrdenVenta ordenSeleccionada;
    private ArrayList<VentaConceptos> estudiosDeOrden;
    private Usuarios usuario;
    private UsuariosDao modeloUsuarios;

    public PagarOrdenController(PagarOrden vistaPrincipal, DatosFacturacionVista vistaFacturacion) {
        this.vistaPrincipal = vistaPrincipal;

        modeloOrdenesVenta = new OrdenVentaDaoImp();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloPacientes = new PacientesDaoImp();
        modeloInstituciones = new InstitucionDaoImp();
        modeloFormasDePago = new CatalogoFormaPagoDaoImp();
        modeloPagoOrdenVenta = new PagoOrdenVentaDaoImp();
        modeloWorklist = new WorklistDaoImp();
        ordenSeleccionada = new OrdenVenta();

        usuario = new Usuarios();
        usuario.setUsuarioU("ADMINURGENCIAS");

        modeloUsuarios = new UsuariosDaoImpl();

        this.vistaPrincipal.btnAgregar.addActionListener(this);
        this.vistaPrincipal.comboPaciente.addActionListener(this);
        this.vistaPrincipal.dateFecha.addPropertyChangeListener(this);
        this.vistaPrincipal.tableOrdenes.addMouseListener(this);
        this.vistaPrincipal.btnRegresar.addActionListener(this);
        this.vistaPrincipal.comboFormaPago.addActionListener(this);
        this.vistaPrincipal.btnPagar.addActionListener(this);
        this.vistaPrincipal.checkFactura.addActionListener(this);

        this.vistaPrincipal.txtPaciente.addKeyListener(this);

        this.vistaPrincipal.btnSalir.addActionListener(this);
        this.vistaPrincipal.btnMin.addActionListener(this);
    }

    public void iniciar() {
        vistaPrincipal.setTitle("Pagar ??rdenes");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
        cargarFormasDePago();
        iniciarTablaPagos();
        cargarPacienteVacio();
        deshabilitar(vistaPrincipal.txtInstitucion);
        deshabilitar(vistaPrincipal.txtTotal);
        deshabilitar(vistaPrincipal.txtSubtotal);
    }

    public void iniciar(OrdenVenta ordenVentaDesdeAgenda) {
        this.ordenSeleccionada = ordenVentaDesdeAgenda;
        mostrarOrdenes(ordenVentaDesdeAgenda);
        vistaPrincipal.tableOrdenes.getSelectionModel().setSelectionInterval(0,1);
        
        vistaPrincipal.setTitle("Pagar ??rdenes");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
        cargarFormasDePago();
        iniciarTablaPagos();
        cargarPacienteVacio();
        deshabilitar(vistaPrincipal.txtInstitucion);
        deshabilitar(vistaPrincipal.txtTotal);
        deshabilitar(vistaPrincipal.txtSubtotal);

        cargarEstudios(ordenSeleccionada.getIdOv());
        Long idPaciente = Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(0, 4).toString());
        pacienteSeleccionado = buscarPacientePorId(idPaciente);
        vistaPrincipal.txtTotal.setText(ordenVentaDesdeAgenda.getTotalEi() + ""); //Cargar total
        cargarInstitucionDesdeAgenda();

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
        } else if (e.getSource() == vistaPrincipal.btnAgregar) {
            if (vistaPrincipal.comboFormaPago.getSelectedIndex() != 0 && !vistaPrincipal.txtCantidad.getText().equals("")) {
                if (formaPagoSeleccionada.getFormaPagoFp().equals("CORTESIA")) {
                    if (vistaPrincipal.tablePagos.getRowCount() == 0) {
                        double cantidad = Double.parseDouble(vistaPrincipal.txtCantidad.getText());
                        agregarATablaPagos(formaPagoSeleccionada.getFormaPagoFp(), cantidad);
                        vistaPrincipal.txtSubtotal.setText(cantidad + "");
                    }
                    limpiarPago();
                } else if (esNumeroCantidad(vistaPrincipal.txtCantidad.getText())) {
                    if (!hayCortesiaAgregada()) {
                        double cantidad = Double.parseDouble(vistaPrincipal.txtCantidad.getText());
                        double total = Double.parseDouble(vistaPrincipal.txtTotal.getText());
                        double subtotalAcumuladoEnTabla = sumarSubPagos();
                        if (cantidad + subtotalAcumuladoEnTabla <= total) {
                            //Ya se complet?? la cantidad, exactamente, hay que registrar el pago
                            // o
                            //A??n no se completa para pagar, a??n asi hay que registrar el pago
                            agregarATablaPagos(formaPagoSeleccionada.getFormaPagoFp(), cantidad);
                            vistaPrincipal.txtSubtotal.setText((cantidad + subtotalAcumuladoEnTabla) + "");
                        } else {
                            /*
                        Ya se pas??, hay que dar cambio, este caso puede suceder solo cuando en las formas de pago se incluye el efectivo, 
                        porque si se va a cobrar con tarjeta lo normal es que se pague exacto, el caso en el que hay que devolver dinero es que el efetivo que se va a pagar
                        es mayor a lo restante, por lo tanto, se le entrega efectivo, sin embargo, en la base de datos no hay que hacer ning??n cambio
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
            }
        } else if (e.getSource() == vistaPrincipal.comboFormaPago) {
            if (vistaPrincipal.comboFormaPago.getSelectedIndex() != 0) {
                formaPagoSeleccionada = obtenerFormaPagoPorId(obtenerIdFormaPago(vistaPrincipal.comboFormaPago.getSelectedItem().toString()));
                System.out.println(formaPagoSeleccionada.getIdFp() + " " + formaPagoSeleccionada.getFormaPagoFp());
            }
        } else if (e.getSource() == vistaPrincipal.btnPagar) {
            if (datosValidos() && deseaPagar() == 0) {
                if (!hayCortesiaAgregada()) {
                    procesarWorklist();
                    actualizarEstadoDeConceptosAEnWorklist();
                    procesarPago();
                    if (vistaPrincipal.checkFactura.isSelected() && vistaPrincipal.txtInstitucion.getText().equals("PARTICULAR")) {
                        abrirDatosFacturacion();
                    }
                    limpiarTablaOrdenes();
                    limpiarTablaEstudios();
                    limpiarTablaPagos();
                    limpiar();
                } else if (adminAutorizado()) {
                    procesarWorklist();
                    actualizarEstadoDeConceptosAEnWorklist();
                    procesarPago();
                    ordenSeleccionada.setTotalEl(ordenSeleccionada.getTotalEi());
                    ordenSeleccionada.setTotalEi(Float.parseFloat(vistaPrincipal.txtSubtotal.getText()));
                    modeloOrdenesVenta.actualizar(ordenSeleccionada);
                    PagarCortesiaController pagoCortesia = new PagarCortesiaController(new PagarCortesia(), ordenSeleccionada);
                    System.out.println("antes de abrir cortesia, requiere factura = " + ordenSeleccionada.isRequiereFactura());
                    pagoCortesia.iniciar();

                    limpiarTablaOrdenes();
                    limpiarTablaEstudios();
                    limpiarTablaPagos();
                    limpiar();
                } else {
                    limpiarTablaOrdenes();
                    limpiarTablaEstudios();
                    limpiarTablaPagos();
                    limpiar();
                }
            }
        } else if (e.getSource() == vistaPrincipal.checkFactura) {
            if (vistaPrincipal.checkFactura.isSelected()) {
                ordenSeleccionada.setRequiereFactura(true);
                System.out.println("factura");
            } else {
                ordenSeleccionada.setRequiereFactura(false);
                System.out.println("ya no factura");
            }
        } else if (e.getSource() == vistaPrincipal.btnSalir) {
            BarUtil.cerrar(vistaPrincipal);
        } else if (e.getSource() == vistaPrincipal.btnMin) {
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

    private void cargarInstitucionDesdeAgenda() {
        Institucion institucion = modeloInstituciones.findInstitucionByIdOrdenVenta(ordenSeleccionada.getIdOv());
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
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCI??N");
            for (CatalogoFormaPago formaPagoFor : modeloFormasDePago.obtenerFormasDePago()) {
                if (formaPagoFor.getIdFp() != 1) {
                    combo.addItem(formaPagoFor.getFormaPagoFp() + " :" + formaPagoFor.getIdFp());
                }
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

        Object[] ventaAgregar = new Object[3];
        ventaAgregar[0] = formaPagoFp;
        ventaAgregar[1] = cantidad;

        dt.addRow(ventaAgregar);

        vistaPrincipal.tablePagos.setModel(dt);
    }

    private void iniciarTablaPagos() {
        DefaultTableModel dt = new DefaultTableModel();

        dt.addColumn("M??todo");
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
            PagoOrdenVenta pago = new PagoOrdenVenta();//Se crea el objeto pago que va a vincular la orden de venta con la forma de pago
            CatalogoFormaPago formaPagoTemporal; //Este objeto temporal va a ser cada pago hecho en la tablita
            String formaPagoTabla = ""; //En esta variable se guarda el texto de la tabla
            double cantidadTabla = 0d; //Aqu?? la cantidad
            String fechaActual = dateToStringOrdenVenta(); //Esta es la fecha actual en datetime, para lo fecha de venta 
            String fechaActualPreparadaBusqueda = dateToString(new Date().getTime()); //Esta fecha sirve para buscar las ordenes que se han hecho en el d+ia
            Long contador = modeloOrdenesVenta.obtenerTotalOrdenesEnUnDia(fechaActualPreparadaBusqueda); //Se obtiene el total de ??rdenes hechas en el d??a
            ++contador;
            System.out.println(contador);
            //Se obtiene el id de la orden dese la ta tabla y se busca en el backend
            ordenSeleccionada = modeloOrdenesVenta.obtenerOrdenVentaPorId(Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(vistaPrincipal.tableOrdenes.getSelectedRow(), 0).toString()));
            ordenSeleccionada.setPagado(true);
            ordenSeleccionada.setFechaVentaOv(fechaActual);
            ordenSeleccionada.setContadorOv(Integer.parseInt(contador + ""));
            ordenSeleccionada.setReferenciaOv(formatoADateParaReferencia(fechaActualPreparadaBusqueda) + "-" + contador);

            pago.setIdOrdenVenta(ordenSeleccionada);
            ordenSeleccionada.setRequiereFactura(vistaPrincipal.checkFactura.isSelected());
            System.out.println("Requiere factura" + ordenSeleccionada.isRequiereFactura());

            for (int i = 0; i < vistaPrincipal.tablePagos.getRowCount(); i++) {
                formaPagoTabla = vistaPrincipal.tablePagos.getValueAt(i, 0).toString();
                System.out.println(formaPagoTabla);
                formaPagoTemporal = encontrarFormaPago(formaPagoTabla);
                cantidadTabla = Double.parseDouble(vistaPrincipal.tablePagos.getValueAt(i, 1).toString());
                pago.setCantidad(cantidadTabla);
                pago.setIdFormaPago(formaPagoTemporal);
                modeloPagoOrdenVenta.registrarPagoOrdenVenta(pago);
                System.out.println("pagado en forma pago");
            }

            int i = 1;
            for (VentaConceptos venta : estudiosDeOrden) {
                venta.setEstado("PAGADO");
                venta.setFechaVentaVc(fechaActual);
                venta.setContadorVc(i);
                venta.setReferenciaVc(ordenSeleccionada.getReferenciaOv());
                i++;
                modeloVentaConceptos.actualizarVentaConceptos(venta);
            }

            modeloOrdenesVenta.actualizar(ordenSeleccionada);

        }
    }

    private void procesarPagoNoParticular() {
        PagoOrdenVenta pago = new PagoOrdenVenta();
        CatalogoFormaPago formaPagoTemporal = new CatalogoFormaPago();
        String fechaActual = dateToStringOrdenVenta();
        String fechaActualPreparadaBusqueda = dateToString(new Date().getTime()); //Esta fecha sirve para buscar las ordenes que se han hecho en el d+ia
        Long contador = modeloOrdenesVenta.obtenerTotalOrdenesEnUnDia(fechaActualPreparadaBusqueda); //Se obtiene el total de ??rdenes hechas en el d??a
        ++contador;
        ordenSeleccionada = modeloOrdenesVenta.obtenerOrdenVentaPorId(Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(vistaPrincipal.tableOrdenes.getSelectedRow(), 0).toString()));
        ordenSeleccionada.setPagado(true);
        ordenSeleccionada.setFechaVentaOv(fechaActual);
        ordenSeleccionada.setContadorOv(Integer.parseInt(contador + ""));
        ordenSeleccionada.setReferenciaOv(formatoADateParaReferencia(fechaActualPreparadaBusqueda) + "-" + contador);
        pago.setIdOrdenVenta(ordenSeleccionada);

        if (vistaPrincipal.checkFactura.isSelected()) {
            ordenSeleccionada.setRequiereFactura(true);
        }

        formaPagoTemporal.setIdFp(Short.parseShort("3")); //Es trasnferencia 
        pago.setCantidad(0);
        pago.setIdFormaPago(formaPagoTemporal);
        modeloPagoOrdenVenta.registrarPagoOrdenVenta(pago);
        System.out.println("pagoNoParticular");

        modeloOrdenesVenta.actualizar(ordenSeleccionada);

        int i = 1;
        for (VentaConceptos venta : estudiosDeOrden) {
            venta.setEstado("PAGADO");
            venta.setFechaVentaVc(fechaActual);
            venta.setContadorVc(i);
            venta.setReferenciaVc(ordenSeleccionada.getReferenciaOv());
            i++;
            modeloVentaConceptos.actualizarVentaConceptos(venta);
        }

    }

    private boolean datosValidosPagoParticular() {
        if (vistaPrincipal.tablePagos.getRowCount() == 0) {
            return false;
        }
        return true;
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
        return (JOptionPane.showConfirmDialog(null, "??Seguro que desea pagar la ??rden? ", "Confirmar", dialog));
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
        if (subtotal < total && !hayCortesiaAgregada()) {
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

    private Long obtenerIdPacienteDeComboBox() {
        String id = "";
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

    private short obtenerIdFormaPago(String formaPago) {
        String id = "";
        boolean dosPuntosSuperado = false;
        for (int i = 0; i < formaPago.length(); i++) {
            if (formaPago.charAt(i) == ':') {
                dosPuntosSuperado = true;
            } else if (dosPuntosSuperado) {
                id += formaPago.charAt(i);
            }
        }
        return Short.parseShort(id);
    }

    private CatalogoFormaPago obtenerFormaPagoPorId(short idFormaPago) {
        return modeloFormasDePago.encontrarFormaPagoPorId(idFormaPago);
    }

    private CatalogoFormaPago encontrarFormaPago(String formaPagoTabla) {
        return modeloFormasDePago.encontrarFormaPagoPorNombre(formaPagoTabla);
    }

    private void procesarWorklist() {
        int fila = vistaPrincipal.tableOrdenes.getSelectedRow();
        if (fila != -1) {
            try {
                modeloWorklist.registrarEnWorklistPorOrdenVenta(Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(fila, 0).toString()));
                System.out.println("Procesada worklist " + Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(fila, 0).toString()));
            } catch (Exception e) {
                System.out.println("Error al procesar worklist");
            }
        }

    }

    private String formatoADateParaReferencia(String fecha) {
        String formateada = "";
        for (int i = 0; i < fecha.length(); i++) {
            if (fecha.charAt(i) != '-') {
                formateada += fecha.charAt(i);
            }
        }
        return formateada;
    }

    private void deshabilitar(JTextField objeto) {
        objeto.setEditable(false);
    }

    private void actualizarEstadoDeConceptosAEnWorklist() {
        for (VentaConceptos venta : estudiosDeOrden) {
            if (venta.getIdConceptoEs().getDicom() == Short.parseShort("1")) {
                venta.setEnWorklist(true);
                modeloVentaConceptos.actualizarVentaConceptos(venta);
                System.out.println("Venta " + venta.getIdVc() + " en worklist (booleano)");
            }
        }
    }

    private boolean hayCortesiaAgregada() {
        boolean yaExistia = false;
        for (int i = 0; i < vistaPrincipal.tablePagos.getRowCount(); i++) {
            if (vistaPrincipal.tablePagos.getValueAt(i, 0).toString().equals("CORTESIA")) {
                yaExistia = true;
                break;
            }
        }
        return yaExistia;
    }

    public boolean adminAutorizado() {
        JLabel jPassword = new JLabel("Contrase??a");
        JTextField password = new JPasswordField();
        Object[] ob = {jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Ingrese la contrase??a del administrador", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String passwordValue = password.getText();
            usuario.setContrasenaU(Md5Util.getMD5(passwordValue));
            System.out.println(usuario.getContrasenaU());
            boolean loginValido = modeloUsuarios.loginValido(usuario);
            if (loginValido) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Favor de solicitar autorizaci??n");
                return false;
            }
        } else {
            return false;
        }
    }

    private void abrirDatosFacturacion() {
        DatosFacturacionController controladorDatosFacturacion = new DatosFacturacionController(new DatosFacturacionVista());
        controladorDatosFacturacion.setOrdenVenta(ordenSeleccionada);
        controladorDatosFacturacion.iniciar();
    }

    private void mostrarOrdenes(OrdenVenta ordenVentaDesdeAgenda) {
        TableOrdenesVenta tableOrdenesVenta = new TableOrdenesVenta();
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, Arrays.asList(ordenVentaDesdeAgenda));
    }

}
