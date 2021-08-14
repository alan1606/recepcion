/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import Vistas.DatosFacturacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author alanm
 */
public class DatosFacturacionController implements ActionListener, MouseListener, KeyListener {

    private DatosFacturacion vista;
    private PacientesDao modelo;
    /*private Pacientes paciente;*/
    
   /* public DatosFacturacionController(DatosFacturacion vista, Pacientes paciente) {
        this.vista = vista;

        modelo = new PacientesDaoImp();

        this.vista.btnGuardar.addActionListener(this);

        this.vista.txtNombre.addKeyListener(this);
        this.vista.txtRfc.addKeyListener(this);

        //Se agrega un action listener por cada objeto
    }*/

    public void iniciar() {
        vista.setTitle("Datos de facturación");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardar();
        }
    }

    private void guardar() {
        if (datosValidos()) {
            persistirDb();
        }
    }

    private boolean datosValidos() {
        if (vista.txtNombre.equals("")) {
            return false;
        }
        if (vista.txtRfc.equals("")) {
            return false;
        }
        return true;
    }

    private void persistirDb(){
    ///Persiste el objeto pacientes con los datos modificados
    
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
