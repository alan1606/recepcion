/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.MovimientoCorteDao;
import DAO.MovimientoCorteDaoImpl;
import Tables.TableMovimientosCortes;
import Utilidades.DateUtil;
import Vistas.Menu;
import Vistas.MovimientosCorte;
import clientews.servicio.MovimientoCorte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author alanm
 */
public class MovimientosCorteController implements ActionListener {

    private MovimientosCorte vista;
    private MovimientoCorte movimiento;
    private MovimientoCorteDao modeloMovimientoCorte;

    public MovimientosCorteController(MovimientosCorte vista) {
        this.vista = vista;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);

        modeloMovimientoCorte = new MovimientoCorteDaoImpl();
    }

    public void iniciar() {
        vista.setTitle("Registrar movimientos en corte");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        cargarComboTipos();
        cargarMovimientos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (datosValidos()) {
                agregarMovimiento();
                limpiar();
                cargarMovimientos();
            }
        } else if (e.getSource() == vista.btnRegresar) {
            regresar();
        }

    }

    private boolean datosValidos() {
        if (vista.comboTipo.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.txtDescripcion.getText().equals("")) {
            return false;
        }
        try {
            Double.parseDouble(vista.txtCantidad.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void agregarMovimiento() {
        movimiento = new MovimientoCorte();
        movimiento.setCantidad(Double.parseDouble(vista.txtCantidad.getText()));
        movimiento.setDescripcion(vista.txtDescripcion.getText());
        if (vista.comboTipo.getSelectedItem().toString().equals("ENTRADA")) {
            movimiento.setEntrada(true);
        } else {
            movimiento.setEntrada(false);
        }
        Date fechaActual = new Date();
        movimiento.setFecha(DateUtil.dateTimeToString(fechaActual.getTime()));

        modeloMovimientoCorte.registrarMovimientoCorte(movimiento);
    }

    private void regresar() {
        vista.dispose();
        Menu vista = new Menu();
        MenuController menu = new MenuController(vista);
        menu.iniciar();
    }

    private void cargarComboTipos() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            combo.addItem("ENTRADA");
            combo.addItem("SALIDA");

            vista.comboTipo.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarMovimientos() {
        Date fechaActual = new Date();
        TableMovimientosCortes tableMovimientosCortes = new TableMovimientosCortes();
        if(fechaActual.getHours()<13){
                tableMovimientosCortes.cargarTabla(vista.tableMovimientos, modeloMovimientoCorte.obtenerMovimientosDeCorteMatutino(DateUtil.dateToString(fechaActual.getTime())));
        }
        else{
                tableMovimientosCortes.cargarTabla(vista.tableMovimientos, modeloMovimientoCorte.obtenerMovimientosDeCorteVespertino(DateUtil.dateToString(fechaActual.getTime())));
        }
    }

    private void limpiar() {
        vista.comboTipo.setSelectedIndex(0);
        vista.txtCantidad.setText("");
        vista.txtDescripcion.setText("");
    }

}
