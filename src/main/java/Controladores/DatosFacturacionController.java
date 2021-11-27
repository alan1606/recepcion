/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CfdiDao;
import DAO.CfdiDaoImpl;
import DAO.DatosFacturacionDao;
import DAO.DatosFacturacionDaoImpl;
import DAO.PagoOrdenVentaDao;
import DAO.PagoOrdenVentaDaoImp;
import Utilidades.BarUtil;
import Vistas.DatosFacturacionVista;
import clientews.servicio.Cfdi;
import clientews.servicio.DatosFacturacion;
import clientews.servicio.OrdenVenta;
import clientews.servicio.PagoOrdenVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author alanm
 */
public class DatosFacturacionController implements ActionListener, KeyListener {

    private DatosFacturacionVista vista;
    private OrdenVenta ordenVenta;
    private List<PagoOrdenVenta> pagos;
    private PagoOrdenVentaDao modeloPagos;
    private int indiceFormaPago = -1;
    private boolean[] procesados;
    private DatosFacturacionDao modeloDatosFacturacion;
    private CfdiDao modeloCfdi;

    public DatosFacturacionController(DatosFacturacionVista vista) {
        this.vista = vista;
        this.vista.comboMetodoPago.addActionListener(this);

        this.vista.txtCiudad.addKeyListener(this);
        this.vista.txtCalle.addKeyListener(this);
        this.vista.txtColonia.addKeyListener(this);

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnMin.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Datos de facturacion");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        vista.txtTotal.setEditable(false);

        modeloPagos = new PagoOrdenVentaDaoImp();
        modeloDatosFacturacion = new DatosFacturacionDaoImpl();
        modeloCfdi = new CfdiDaoImpl();
        if (ordenVenta != null) {
            pagos = modeloPagos.obtenerPagosDeOrdenVenta(ordenVenta);
            cargarComboFormasPago();

            procesados = new boolean[pagos.size()];
            ponerArrayDeBooleanosEn(procesados, false);
        }
        cargarCfdis();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.comboMetodoPago) {
            if (vista.comboMetodoPago.getSelectedIndex() != 0) {
                indiceFormaPago = vista.comboMetodoPago.getSelectedIndex() - 1;
                if (!procesados[indiceFormaPago]) {
                    cargarTotalDeIndice(indiceFormaPago);
                } else {
                    JOptionPane.showMessageDialog(null, "Ya se han introducido los datos de ese pago");
                    vista.txtTotal.setText("");
                }
            } else {
                vista.txtTotal.setText("");
            }
        } else if (e.getSource() == vista.btnGuardar) {
            if (datosValidos()) {
                try {
                    registrarDatosFacturacion();
                    procesados[indiceFormaPago] = true;
                    JOptionPane.showMessageDialog(null, "Datos de facturación guardados");
                    if (yaSeRegistraronTodasFormasPago()) {
                        cerrar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Llene los datos de facturación de todos los pagos realizados");
                        vista.comboMetodoPago.setSelectedIndex(0);
                        vista.txtTotal.setText("");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se han podido registrar los datos de facturación");
                    ex.printStackTrace(System.out);
                }
            }
        } else if (e.getSource() == vista.btnMin) {
            BarUtil.minimizar(vista);
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
    }

    public OrdenVenta getOrdenVenta() {
        return ordenVenta;
    }

    public void setOrdenVenta(OrdenVenta ordenVenta) {
        this.ordenVenta = ordenVenta;
    }

    private void cargarComboFormasPago() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            pagos.forEach(p -> {
                combo.addItem(p.getIdFormaPago());
            });

            vista.comboMetodoPago.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    private void ponerArrayDeBooleanosEn(boolean[] procesados, boolean b) {
        for (int i = 0; i < procesados.length; i++) {
            procesados[i] = b;
        }
    }

    private void cargarTotalDeIndice(int indiceFormaPago) {
        vista.txtTotal.setText(pagos.get(indiceFormaPago).getCantidad() + "");
    }

    private boolean datosValidos() {
        if (vista.comboMetodoPago.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.txtTotal.getText().equals("")) {
            return false;
        }
        if (vista.txtCalle.getText().equals("")) {
            return false;
        }
        if (vista.txtCiudad.getText().equals("")) {
            return false;
        }
        if (vista.txtColonia.getText().equals("")) {
            return false;
        }
        if (vista.txtCorreo.getText().equals("")) {
            return false;
        }
        if (vista.txtCp.getText().equals("")) {
            return false;
        }
        if (vista.txtNombre.getText().equals("")) {
            return false;
        }
        if (vista.txtRfc.getText().equals("")) {
            return false;
        }
        if (vista.comboCfdi.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private void registrarDatosFacturacion() {
        DatosFacturacion temporal = new DatosFacturacion();
        temporal.setCalle(vista.txtCalle.getText());
        temporal.setCiudad(vista.txtCiudad.getText());
        temporal.setColonia(vista.txtColonia.getText());
        temporal.setCorreo(vista.txtCorreo.getText());
        temporal.setCp(vista.txtCp.getText());
        temporal.setIdCfdi((Cfdi) vista.comboCfdi.getSelectedItem());
        temporal.setIdPagoOrdenVenta(pagos.get(indiceFormaPago));
        temporal.setNombreORazon(vista.txtNombre.getText());
        temporal.setRfc(vista.txtRfc.getText());

        try {
            modeloDatosFacturacion.registrarDatosFacturacion(temporal);
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean yaSeRegistraronTodasFormasPago() {
        for (int i = 0; i < procesados.length; i++) {
            if (!procesados[i]) {
                return false;
            }
        }
        return true;
    }

    private void cerrar() {
        vista.dispose();
    }

    private void cargarCfdis() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            modeloCfdi.listarCfdis().forEach(c -> combo.addItem(c));
            vista.comboCfdi.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
