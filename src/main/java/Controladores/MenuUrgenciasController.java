/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.UsuariosDao;
import DAO.UsuariosDaoImpl;
import Utilidades.BarUtil;
import Utilidades.Md5Util;
import Vistas.Empalmes;
import Vistas.Menu;
import Vistas.MenuUrgencias;
import Vistas.Urgencias;
import clientews.servicio.Usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author alanm
 */
public class MenuUrgenciasController implements ActionListener {

    private MenuUrgencias vista;
    private Usuarios usuario;
    private UsuariosDao modeloUsuarios;

    public MenuUrgenciasController(MenuUrgencias vista) {
        this.vista = vista;

        usuario = new Usuarios();
        usuario.setUsuarioU("ADMINURGENCIAS");

        modeloUsuarios = new UsuariosDaoImpl();

        this.vista.btnEmpalme.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
        this.vista.btnUrgencia.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.btnMin.addActionListener(this);
    }

    public void iniciar() {
        JLabel jPassword = new JLabel("Contraseña");
        JTextField password = new JPasswordField();
        Object[] ob = {jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "Ingrese la contraseña del administrador", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String passwordValue = password.getText();
            usuario.setContrasenaU(Md5Util.getMD5(passwordValue));
            System.out.println(usuario.getContrasenaU());
            if (loginValido()) {
                vista.setTitle("Urgencias");
                vista.setLocationRelativeTo(null);
                vista.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Favor de solicitar autorización");
                abrirMainMenu();
            }
        } else {
            abrirMainMenu();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegresar) {
            abrirMainMenu();
        }
        else if(e.getSource() == vista.btnUrgencia){
            abrirUrgencias();
        }
        else if(e.getSource() == vista.btnEmpalme){
            abrirEmpalmes();
        }
        else if(e.getSource() == vista.btnSalir){
            BarUtil.cerrar(vista);
        }
        else if (e.getSource() == vista.btnMin){
            BarUtil.minimizar(vista);
        }
    }

    private void abrirMainMenu() {
        vista.dispose();
        MenuController menu = new MenuController(new Menu());
        menu.iniciar();
    }

    private boolean loginValido() {
        return modeloUsuarios.loginValido(usuario);
    }
    
    private void abrirUrgencias(){
     vista.dispose();
        UrgenciasController urgencias = new UrgenciasController(new Urgencias());
        urgencias.iniciar();
    }

    private void abrirEmpalmes() {
        vista.dispose();
        EmpalmesController empalmes = new EmpalmesController(new Empalmes());
        empalmes.iniciar();
    }

}
