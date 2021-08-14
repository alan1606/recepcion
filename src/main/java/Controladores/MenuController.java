/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alanm
 */
public class MenuController implements ActionListener {
    
    private Menu vista;

    public MenuController(Menu vista) {
        this.vista = vista;
        this.vista.btnAgendar.addActionListener(this);
        this.vista.btnConfirmar.addActionListener(this);
        this.vista.btnPagar.addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vista.btnAgendar){
            abrirAgendarCita();
        }
        else if(e.getSource()==this.vista.btnConfirmar){
            abrirConfirmarCita();
        }
        else if(e.getSource()==this.vista.btnPagar){
            abrirPagarOrden();
        }
    }
    
    
    private void abrirAgendarCita(){
    
    }
    
    private void abrirConfirmarCita(){
    
    }
    
    private void abrirPagarOrden(){
    //Ventana pagar.abrir
    //Cierra esta
    }
    
    
}
