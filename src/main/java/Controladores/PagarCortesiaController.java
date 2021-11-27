/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CatalogoFormaPagoDao;
import DAO.CatalogoFormaPagoDaoImp;
import DAO.OrdenVentaDao;
import DAO.OrdenVentaDaoImp;
import DAO.PagoOrdenVentaDao;
import DAO.PagoOrdenVentaDaoImp;
import Vistas.DatosFacturacionVista;

import Vistas.PagarCortesia;
import clientews.servicio.CatalogoFormaPago;
import clientews.servicio.OrdenVenta;
import clientews.servicio.PagoOrdenVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author alanm
 */
public class PagarCortesiaController implements ActionListener, MouseListener, KeyListener {

    private OrdenVenta ordenVenta;
    private PagoOrdenVentaDao modeloPagoOrdenVenta;
    private CatalogoFormaPagoDao modeloFormasDePago;
    private CatalogoFormaPago formaPagoSeleccionada;
    private OrdenVentaDao modeloOrdenVenta;
    
    private PagarCortesia vista;

    public PagarCortesiaController(PagarCortesia vista, OrdenVenta ordenVenta) {
        this.ordenVenta = ordenVenta;
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);;
        this.vista.comboFormaDePago.addActionListener(this);

    }

    public void iniciar() {

        vista.setTitle("Pagar cortesía");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        vista.txtTotal.setEditable(false);
        vista.txtSubtotal.setEditable(false);
        vista.txtSubtotal.setText("0");

        modeloPagoOrdenVenta = new PagoOrdenVentaDaoImp();
        modeloFormasDePago = new CatalogoFormaPagoDaoImp();
        modeloOrdenVenta = new OrdenVentaDaoImp();
        
        if (ordenVenta != null) {
            //Hay que cargar el total
            vista.txtTotal.setText(ordenVenta.getTotalEi() + "");
            System.out.println("en funcion iniciar pago cortesia, requiere factura = " + ordenVenta.isRequiereFactura());
        }

        cargarFormasDePago();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.comboFormaDePago) {
            if (vista.comboFormaDePago.getSelectedIndex() != 0) {
                formaPagoSeleccionada = obtenerFormaPagoPorId(obtenerIdFormaPago(vista.comboFormaDePago.getSelectedItem().toString()));
                System.out.println(formaPagoSeleccionada.getIdFp() + " " + formaPagoSeleccionada.getFormaPagoFp());
            }
        } else if (e.getSource() == vista.btnAgregar) {
            if (datosValidos()) {
                if ((Double.parseDouble(vista.txtSubtotal.getText()) + Double.parseDouble(vista.txtCantidad.getText())) <= ordenVenta.getTotalEi()) {
                    procesarPago();
                    if ((Double.parseDouble(vista.txtSubtotal.getText()) + Double.parseDouble(vista.txtCantidad.getText())) == ordenVenta.getTotalEi()) {
                        ordenVenta = modeloOrdenVenta.obtenerOrdenVentaPorId(ordenVenta.getIdOv());
                        if (ordenVenta.isRequiereFactura()) {
                            abrirDatosFacturacion();
                        }
                        salir();
                    } else {
                        vista.txtSubtotal.setText((Double.parseDouble(vista.txtSubtotal.getText()) + Double.parseDouble(vista.txtCantidad.getText())) + "");
                        vista.comboFormaDePago.setSelectedIndex(0);
                        vista.txtCantidad.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada supera el total, intente otra cantidad");
                    vista.txtCantidad.setText("");
                }
            } else {
                System.out.println("datos no validos");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public OrdenVenta getOrdenVenta() {
        return ordenVenta;
    }

    public void setOrdenVenta(OrdenVenta ordenVenta) {
        this.ordenVenta = ordenVenta;
    }

    private void procesarPago() {

        PagoOrdenVenta pago = new PagoOrdenVenta();//Se crea el objeto pago que va a vincular la orden de venta con la forma de pago

        pago.setIdOrdenVenta(ordenVenta);

        pago.setCantidad(Double.parseDouble(vista.txtCantidad.getText()));
        pago.setIdFormaPago(formaPagoSeleccionada);
        modeloPagoOrdenVenta.registrarPagoOrdenVenta(pago);

    }

    private void cargarFormasDePago() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (CatalogoFormaPago formaPagoFor : modeloFormasDePago.obtenerFormasDePago()) {
                combo.addItem(formaPagoFor.getFormaPagoFp() + " :" + formaPagoFor.getIdFp());
            }
            vista.comboFormaDePago.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private CatalogoFormaPago obtenerFormaPagoPorId(short idFormaPago) {
        return modeloFormasDePago.encontrarFormaPagoPorId(idFormaPago);
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

    private boolean datosValidos() {
        if (vista.comboFormaDePago.getSelectedIndex() == 0) {
            System.out.println("forma de pago no seleccionada");
            return false;
        }
        if (vista.txtCantidad.getText().equals("")) {
            System.out.println("cantidad vacia");
            return false;
        }
        if (!esDouble(vista.txtCantidad.getText())) {
            System.out.println("cantidad no es numero");
            return false;
        }
        return true;
    }

    public boolean esDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    private void salir() {
        JOptionPane.showMessageDialog(null, "El pago ha sido realizado");
        vista.dispose();
    }

    private void abrirDatosFacturacion() {
        DatosFacturacionController controladorDatosFacturacion = new DatosFacturacionController(new DatosFacturacionVista());
        controladorDatosFacturacion.setOrdenVenta(ordenVenta);
        controladorDatosFacturacion.iniciar();
    }

}
