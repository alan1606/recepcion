/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.MedicoDao;
import DAO.MedicoDaoImpl;
import Tables.TableMedicos;
import Utilidades.BarUtil;
import Utilidades.DateUtil;
import Vistas.Medicos;
import Vistas.Menu;
import clientews.servicio.Medico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author alanm
 */
public class MedicoController implements ActionListener, KeyListener, MouseListener {

    private MedicoDao modeloMedicos;
    private Medicos vista;
    private Medico medico;

    public MedicoController(Medicos vista) {
        this.vista = vista;

        //Asignación de listeners
        this.vista.txtNombres.addKeyListener(this);
        this.vista.txtApellidos.addKeyListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        this.vista.txtEspecialidad.addKeyListener(this);
        this.vista.txtDireccion.addKeyListener(this);

        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnMin.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);

        this.vista.btnRegistrar.addKeyListener(this);
        this.vista.btnEliminar.addKeyListener(this);
        this.vista.btnModificar.addKeyListener(this);

        this.vista.checkCorreo.addActionListener(this);
        this.vista.checkEspecialidad.addActionListener(this);
        this.vista.checkNombre.addActionListener(this);
        this.vista.checkTelefono.addActionListener(this);

        this.vista.tableMedicos.addMouseListener(this);
    }

    public void iniciar() {
        vista.setTitle("Medicos");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        modeloMedicos = new MedicoDaoImpl();

        medico = new Medico();

        cargarMedicos();
        cargarComboReferentesORadiologos();
        vista.checkNombre.setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegresar) {
            regresar();
        } else if (e.getSource() == vista.btnSalir) {
            BarUtil.cerrar(vista);
        } else if (e.getSource() == vista.btnMin) {
            BarUtil.minimizar(vista);
        } else if (e.getSource() == vista.checkCorreo || e.getSource() == vista.checkEspecialidad || e.getSource() == vista.checkNombre || e.getSource() == vista.checkTelefono) {
            logicaCheckBoxes((JRadioButton) e.getSource());
        } else if (e.getSource() == vista.btnEliminar) {
            eliminar();
        } else if (e.getSource() == vista.btnModificar) {
            modificar();
        } else if (e.getSource() == vista.btnRegistrar) {
            registrar();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == vista.btnEliminar) {
                eliminar();
            } else if (e.getSource() == vista.btnModificar) {
                modificar();
            } else if (e.getSource() == vista.btnRegistrar) {
                registrar();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtNombres) {
            aMayusculas(vista.txtNombres);
        } else if (e.getSource() == vista.txtApellidos) {
            aMayusculas(vista.txtApellidos);
        } else if (e.getSource() == vista.txtBuscar) {
            aMayusculas(vista.txtBuscar);
            if (vista.txtBuscar.getText().equals("")) {
                cargarMedicos();
            } else {
                realizarBusqueda(vista.txtBuscar.getText());
            }
        } else if (e.getSource() == vista.txtEspecialidad) {
            aMayusculas(vista.txtEspecialidad);
        } else if (e.getSource() == vista.txtDireccion) {
            aMayusculas(vista.txtDireccion);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.tableMedicos) {
            if (vista.tableMedicos.getSelectedRow() != -1) {
                medico = obtenerMedicoDeFila(vista.tableMedicos.getSelectedRow());
                llenarCampos(medico);
            }
        }
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

    private void cargarMedicos() {
        TableMedicos tabla = new TableMedicos();
        tabla.cargarTabla(vista.tableMedicos, modeloMedicos.obtenerTodosLosMedicos());
    }

    private void cargarComboReferentesORadiologos() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            combo.addItem("REFERENTE");
            combo.addItem("RADIOLOGO");
            vista.comboReferenteRadiologo.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void regresar() {
        vista.dispose();
        Menu vista = new Menu();
        MenuController menu = new MenuController(vista);
        menu.iniciar();
    }

    private void logicaCheckBoxes(JRadioButton seleccionar) {
        vista.checkCorreo.setSelected(false);
        vista.checkEspecialidad.setSelected(false);
        vista.checkNombre.setSelected(false);
        vista.checkTelefono.setSelected(false);

        seleccionar.setSelected(true);
    }

    private void eliminar() {
        if (deseaEliminar() && vista.tableMedicos.getSelectedRow() != -1) {
            try {
                eliminarDb();
                limpiar();
                cargarMedicos();
            } catch (Exception e) {
                e.printStackTrace(System.out);
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar al médico");
            }
        }
    }

    private void registrar() {
        if (datosValidos() && deseaRegistrar()) {
            try {
                cargarDatosDesdeFormulario();
                guardarEnDb();
                limpiar();
                cargarMedicos();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar el médico");
                e.printStackTrace(System.out);
            }
        }
    }

    private void modificar() {
        if (deseaModificar() && vista.tableMedicos.getSelectedRow() != -1) {
            if (datosValidos()) {
                try {
                    cargarDatosDesdeFormulario();
                    persistirModificacionDb();
                    limpiar();
                    cargarMedicos();
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el médico");
                }

            }
        }
    }

    private void aMayusculas(JTextField textField) {
        textField.setText(textField.getText().toUpperCase());
    }

    private Medico obtenerMedicoDeFila(int fila) {
        Medico temporal = new Medico();
        try {
            temporal.setNombres(vista.tableMedicos.getValueAt(fila, 0).toString());
            temporal.setEspecialidad(vista.tableMedicos.getValueAt(fila, 2).toString());
            temporal.setTelefono(vista.tableMedicos.getValueAt(fila, 3).toString());
            temporal.setCorreo(vista.tableMedicos.getValueAt(fila, 4).toString());
            temporal.setDireccion(vista.tableMedicos.getValueAt(fila, 5).toString());
            temporal.setWhatsapp(vista.tableMedicos.getValueAt(fila, 7).toString());
            temporal.setToken("0");
            String radiologo = vista.tableMedicos.getValueAt(fila, 8).toString();
            if (radiologo.equals("RADIOLOGO")) {
                temporal.setRadiologo(true);
            } else {
                temporal.setRadiologo(false);
            }
            temporal.setId(Integer.parseInt(vista.tableMedicos.getValueAt(fila, 9).toString()));
            temporal.setFechaNacimiento(vista.tableMedicos.getValueAt(fila, 6).toString());
            temporal.setApellidos(vista.tableMedicos.getValueAt(fila, 1).toString());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return temporal;
    }

    private void llenarCampos(Medico medico) {
        vista.txtNombres.setText(medico.getNombres());
        vista.txtApellidos.setText(medico.getApellidos());
        vista.txtCorreo.setText(medico.getCorreo());
        vista.txtDireccion.setText(medico.getDireccion());
        vista.txtEspecialidad.setText(medico.getEspecialidad());
        vista.txtTelefono.setText(medico.getTelefono());
        vista.txtWhatsapp.setText(medico.getWhatsapp());

        System.out.println(medico.getFechaNacimiento());
        Date fesha = (DateUtil.stringToDate(DateUtil.stringLegibleDate(medico.getFechaNacimiento())));
        System.out.println(fesha);
        vista.dateFechaNacimiento.setDate(fesha);

        if (medico.isRadiologo()) {
            vista.comboReferenteRadiologo.setSelectedItem("RADIOLOGO");
        } else {
            vista.comboReferenteRadiologo.setSelectedItem("REFERENTE");
        }

    }

    private boolean deseaModificar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea modificar al médico? ", "Confirmar", dialog)) == 0;
    }

    private boolean datosValidos() {
        if (vista.txtNombres.getText().equals("")) {
            return false;
        }
        if (vista.txtApellidos.getText().equals("")) {
            return false;
        }
        if (vista.txtEspecialidad.getText().equals("")) {
            return false;
        }
     /*   if (vista.txtTelefono.getText().equals("") || vista.txtTelefono.getText().length() < 7) { //Por decir una longitud al telefono, mínimo siete caracteres
            return false;
        }*/
        if (vista.txtCorreo.getText().equals("")) {
            return false;
        }
        if (vista.txtDireccion.getText().equals("")) {
            return false;
        }
      /*  if (vista.dateFechaNacimiento.getDate() == null) {
            return false;
        }*/
        if (vista.txtWhatsapp.getText().equals("")) {
            return false;
        }
        if (vista.comboReferenteRadiologo.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private void cargarDatosDesdeFormulario() {
        medico.setNombres(vista.txtNombres.getText());
        medico.setApellidos(vista.txtApellidos.getText());
        medico.setCorreo(vista.txtCorreo.getText());
        medico.setDireccion(vista.txtDireccion.getText());
        medico.setEspecialidad(vista.txtEspecialidad.getText());
        medico.setFechaNacimiento(DateUtil.dateToString(vista.dateFechaNacimiento.getDate().getTime()));

        // 1 es referente, 2 es radiólogo
        if (vista.comboReferenteRadiologo.getSelectedIndex() == 2) {
            medico.setRadiologo(true);
        } else if (vista.comboReferenteRadiologo.getSelectedIndex() == 1) {
            medico.setRadiologo(false);
        }

        medico.setTelefono(vista.txtTelefono.getText());
        medico.setWhatsapp(vista.txtWhatsapp.getText());
        medico.setToken("0");
    }

    private void persistirModificacionDb() {
        modeloMedicos.actualizarMedico(medico);
    }

    private boolean deseaEliminar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar al médico? ", "Confirmar", dialog)) == 0;
    }

    private void eliminarDb() {
        modeloMedicos.eliminarMedico(medico);
    }

    private boolean deseaRegistrar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea registrar el médico? ", "Confirmar", dialog)) == 0;
    }

    private void guardarEnDb() {
        modeloMedicos.registrarMedico(medico);
    }

    private void limpiar() {
        vista.txtBuscar.setText("");
        vista.txtNombres.setText("");
        vista.txtApellidos.setText("");
        vista.txtEspecialidad.setText("");
        vista.txtTelefono.setText("");
        vista.txtCorreo.setText("");
        vista.txtDireccion.setText("");
        vista.dateFechaNacimiento.setDate(null);
        vista.txtWhatsapp.setText("");
        vista.comboReferenteRadiologo.setSelectedIndex(0);

        vista.txtNombres.requestFocus();
    }

    private void realizarBusqueda(String parametro) {

        TableMedicos tabla = new TableMedicos();

        if (vista.checkNombre.isSelected()) {
            tabla.cargarTabla(vista.tableMedicos, modeloMedicos.buscarMedicosPorNombre(parametro));
        } else if (vista.checkEspecialidad.isSelected()) {
            tabla.cargarTabla(vista.tableMedicos, modeloMedicos.buscarMedicoPorEspecialidad(parametro));
        } else if (vista.checkTelefono.isSelected()) {
            tabla.cargarTabla(vista.tableMedicos, modeloMedicos.buscarMedicoPorTelefono(parametro));
        } else if (vista.checkCorreo.isSelected()) {
            tabla.cargarTabla(vista.tableMedicos, modeloMedicos.buscarMedicoPorCorreo(parametro));
        }
    }

}
