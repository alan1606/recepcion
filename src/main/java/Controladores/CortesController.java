/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Vistas.Cortes;

/**
 *
 * @author alanm
 */



public class CortesController {
    private Cortes vista;

    public CortesController(Cortes vista) {
        this.vista = vista;
    }

     public void iniciar() {
        vista.setTitle("Cortes");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
}
