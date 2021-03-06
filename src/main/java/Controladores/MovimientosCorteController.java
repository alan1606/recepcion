/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.MovimientoCorteDao;
import DAO.MovimientoCorteDaoImpl;
import Tables.TableMovimientosCortes;
import Utilidades.BarUtil;
import Utilidades.DateUtil;
import Vistas.Menu;
import Vistas.MovimientosCorte;
import clientews.servicio.MovimientoCorte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author alanm
 */
public class MovimientosCorteController implements ActionListener, KeyListener {

    private MovimientosCorte vista;
    private MovimientoCorte movimiento;
    private MovimientoCorteDao modeloMovimientoCorte;

    public MovimientosCorteController(MovimientosCorte vista) {
        this.vista = vista;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
        this.vista.txtDescripcion.addKeyListener(this);
        
        this.vista.btnSalir.addActionListener(this);
        this.vista.btnMin.addActionListener(this);
        
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
        else if(e.getSource() == vista.btnSalir){
            BarUtil.cerrar(vista);
        }
        else if(e.getSource() == vista.btnMin){
            BarUtil.minimizar(vista);
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
            combo.addItem("SELECCIONE UNA OPCI??N");
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == vista.txtDescripcion){
            vista.txtDescripcion.setText(vista.txtDescripcion.getText().toUpperCase());
        }
    }

}
