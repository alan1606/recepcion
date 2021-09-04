/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.AgendarCita;
import Vistas.ConfirmarCita;
import Vistas.Menu;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnAgendar) {
            abrirAgendarCita();
        } else if (e.getSource() == this.vista.btnConfirmar) {
            abrirConfirmarCita();
        } else if (e.getSource() == this.vista.btnPagar) {
            abrirPagarOrden();
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
        /*vista.dispose();
        PagarOrdenController controladorPagarOrden = new PagarOrdenController(new PagarOrden());
        controladorPagarOrden.iniciar();*/
    }

}
