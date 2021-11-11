/*



package DAO;

import Controladores.*;
import DAO.PacientesDao;
import Vistas.DatosFacturacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DatosFacturacionController implements ActionListener, MouseListener, KeyListener {

    private DatosFacturacion vista;
    private PacientesDao modelo;


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

}
*/