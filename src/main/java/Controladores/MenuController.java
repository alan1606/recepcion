/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.AgendarCita;
import Vistas.Cancelaciones;
import Vistas.ConfirmarCita;
import Vistas.Cortes;
import Vistas.DatosFacturacion;
import Vistas.Menu;
import Vistas.MenuUrgencias;
import Vistas.MovimientosCorte;
import Vistas.PagarOrden;
import Vistas.Reagendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alanm
 */
public class MenuController implements ActionListener {

    private Menu vista;

    public static void main(String[] args) {
        Menu vista = new Menu();
        MenuController menu = new MenuController(vista);
        menu.iniciar();
    }
    
    public void iniciar() {
        vista.setTitle("Menú");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public MenuController(Menu vista) {
        this.vista = vista;
        this.vista.btnAgendar.addActionListener(this);
        this.vista.btnConfirmar.addActionListener(this);
        this.vista.btnPagar.addActionListener(this);
        this.vista.btnCortes.addActionListener(this);
        this.vista.btnEntradas.addActionListener(this);
        this.vista.btnUrgencias.addActionListener(this);
        this.vista.btnReagendar.addActionListener(this);
        this.vista.btnCancelaciones.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnAgendar) {
            abrirAgendarCita();
        } else if (e.getSource() == this.vista.btnConfirmar) {
            abrirConfirmarCita();
        } else if (e.getSource() == this.vista.btnPagar) {
            abrirPagarOrden();
        } else if(e.getSource() == this.vista.btnCortes){
            abrirCortes();
        }else if(e.getSource() == this.vista.btnEntradas){
            abrirMovimientosCortes();
        }else if(e.getSource() == this.vista.btnUrgencias){
            abrirUrgencias();
        }else if(e.getSource() == this.vista.btnReagendar){
            abrirReagendar();
        }
        else if(e.getSource() == this.vista.btnCancelaciones){
            abrirCancelaciones();
        }
    }

    private void abrirAgendarCita() {
        vista.dispose();
        AgendarCitaController controladorCitas = new AgendarCitaController(new AgendarCita());
        controladorCitas.iniciar();
    }

    private void abrirConfirmarCita() {
        vista.dispose();
        ConfirmarCitaController controladorConfirmaciones = new ConfirmarCitaController(new ConfirmarCita());
        controladorConfirmaciones.iniciar();
    }

    private void abrirPagarOrden() {
        vista.dispose();
        PagarOrdenController controladorPagarOrden = new PagarOrdenController(new PagarOrden(), new DatosFacturacion());
        controladorPagarOrden.iniciar();
    }

    private void abrirCortes() {
        vista.dispose();
        CortesController controladorCortes = new CortesController(new Cortes());
        controladorCortes.iniciar();
    }

    private void abrirMovimientosCortes() {
        vista.dispose();
        MovimientosCorteController controladorMovimientos = new MovimientosCorteController(new MovimientosCorte());
        controladorMovimientos.iniciar();
    }

    private void abrirUrgencias() {
        vista.dispose();
        MenuUrgenciasController controladorUrgencias = new MenuUrgenciasController(new MenuUrgencias());
        controladorUrgencias.iniciar();
    }

    private void abrirReagendar() {
        vista.dispose();
        ReagendarController controladorReagendar = new ReagendarController(new Reagendar());
        controladorReagendar.iniciar();
    }

    private void abrirCancelaciones() {
        vista.dispose();
        CancelacionesController controladorCancelaciones = new CancelacionesController(new Cancelaciones());
        controladorCancelaciones.iniciar();
    }

}
