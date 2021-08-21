/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.AreasDao;
import DAO.AreasDaoImpl;
import DAO.ConceptosDao;
import DAO.ConceptosDaoImp;
import DAO.EquipoDicomDao;
import DAO.EquipoDicomDaoImp;
import DAO.InstitucionDao;
import DAO.InstitucionDaoImp;
import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import Tables.TablePacientes;
import Vistas.AgendarCita;
import clientews.servicio.Areas;
import clientews.servicio.Conceptos;
import clientews.servicio.EquipoDicom;
import clientews.servicio.Institucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author alanm
 */
public class AgendarCitaController implements KeyListener, MouseListener, ActionListener {

    private AgendarCita vista;
    private PacientesDao modeloPacientes;
    private InstitucionDao modeloInstituciones;
    private ConceptosDao modeloConceptos;
    private EquipoDicomDao modeloEquipoDicom;
    private AreasDao modeloAreas;

    public AgendarCitaController(AgendarCita vista) {
        this.vista = vista;

        modeloPacientes = new PacientesDaoImp();
        modeloInstituciones = new InstitucionDaoImp();
        modeloConceptos = new ConceptosDaoImp();
        modeloEquipoDicom = new EquipoDicomDaoImp();
        modeloAreas = new AreasDaoImpl();

        this.vista.radioNombre.addActionListener(this);
        this.vista.radioCurp.addActionListener(this);

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnNuevoPaciente.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnQuitar.addActionListener(this);

        this.vista.comboArea.addActionListener(this);
        this.vista.comboEstudio.addActionListener(this);
        this.vista.comboHora.addActionListener(this);
        this.vista.comboSala.addActionListener(this);
        this.vista.comboInstitucion.addActionListener(this);

        this.vista.tableEstudios.addMouseListener(this);
        this.vista.tablePacientes.addMouseListener(this);

        this.vista.txtBuscar.addKeyListener(this);

        setRadioNombreEnabled(true);
        cargarInstituciones();

    }

    public void iniciar() {
        vista.setTitle("Agendar cita");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.radioCurp) {
            setRadioCurpEnabled(true);
            setRadioNombreEnabled(false);
        } else if (e.getSource() == this.vista.radioNombre) {
            setRadioCurpEnabled(false);
            setRadioNombreEnabled(true);
        } else if (e.getSource() == this.vista.comboArea) {
            if (this.vista.comboArea.getSelectedIndex() != 0) {//Se selecciona una opción que es diferente de "Seleccione una opción"
                cargarEstudiosDeAreaInstitucion(vista.comboArea.getSelectedItem().toString(), vista.comboInstitucion.getSelectedItem().toString());
                cargarSalasDeArea(vista.comboArea.getSelectedItem().toString());
            }
        } else if (e.getSource() == this.vista.comboInstitucion) {
            if (this.vista.comboInstitucion.getSelectedIndex() != 0) //Selección de opción válida
            {
                cargarAreas(this.vista.comboInstitucion.getSelectedItem().toString());
            }
        } else if (e.getSource() == this.vista.comboSala) {
            if (todoListoVerificarAgenda()) {
                agenda();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == this.vista.txtBuscar) {
            if (this.vista.txtBuscar.getText().equals("")) {
                cargarTablaPacientesVacia();
            } else {
                if (this.vista.radioNombre.isSelected()) {
                    buscarPacientePorNombre(this.vista.txtBuscar.getText());
                } else {
                    buscarPacientePorCurp(this.vista.txtBuscar.getText());
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.tablePacientes) {
            if (vista.tablePacientes.getRowCount() != 0 && vista.tablePacientes.getSelectedColumn() != -1) { //Si la tabla tiene más de un registro y se seleccionó alguno
                int fila = vista.tablePacientes.getSelectedRow();
                String curp = (vista.tablePacientes.getValueAt(fila, 2)).toString();
                if (!curp.equals("")) { //si hay curp
                    vista.txtPaciente.setText(curp);
                }
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

    private void setRadioCurpEnabled(boolean b) {
        this.vista.radioCurp.setSelected(b);
    }

    private void setRadioNombreEnabled(boolean b) {
        this.vista.radioNombre.setSelected(b);
    }

    private void cargarTablaPacientesVacia() {
        TablePacientes tablePacientes = new TablePacientes();
        tablePacientes.cargarTablaVacia(this.vista.tablePacientes);
    }

    private void buscarPacientePorNombre(String text) {
        TablePacientes tablePacientes = new TablePacientes();
        tablePacientes.cargarTabla(this.vista.tablePacientes, modeloPacientes.buscarLikeNombre(this.vista.txtBuscar.getText()));
    }

    private void buscarPacientePorCurp(String text) {
        TablePacientes tablePacientes = new TablePacientes();
        tablePacientes.cargarTabla(this.vista.tablePacientes, modeloPacientes.buscarLikeCurp(this.vista.txtBuscar.getText()));
    }

    private void cargarInstituciones() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Institucion institucion : modeloInstituciones.listar()) {
                combo.addItem(institucion.getNombreInstitucion());
            }
            vista.comboInstitucion.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarAreas(String nombreInstitucion) {
        Institucion institucion = new Institucion();
        institucion.setNombreInstitucion(nombreInstitucion);
        institucion = modeloInstituciones.encontrarPorNombre(institucion);
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Areas area : modeloAreas.encontrarPorInstitucion(institucion)) {
                combo.addItem(area.getNombreA());
            }
            vista.comboArea.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarEstudiosDeAreaInstitucion(String nombre, String nombreInstitucion) {
        Areas area = modeloAreas.encontrarPorNombre(nombre);

        Institucion institucion = new Institucion();
        institucion.setNombreInstitucion(nombreInstitucion);
        institucion = modeloInstituciones.encontrarPorNombre(institucion);

        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Conceptos concepto : modeloConceptos.encontrarConceptosPorAreaInstitucion(institucion.getIdInstitucion(), area.getIdA())) {
                combo.addItem(concepto.getConceptoTo());
            }
            vista.comboEstudio.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarSalasDeArea(String nombre) {
        Areas area = modeloAreas.encontrarPorNombre(nombre);

        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (EquipoDicom equipo : modeloEquipoDicom.encontrarEquipoDicomPorArea(area)) {
                combo.addItem(equipo.getNombre());
            }
            vista.comboSala.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private boolean todoListoVerificarAgenda() {
        if (vista.comboInstitucion.getSelectedIndex() == 0) {
            return false;
        }
        if(vista.comboArea.getSelectedIndex()==0){
            return false;
        }
        if(vista.comboEstudio.getSelectedIndex()==0){
            return false;
        }
        if(vista.comboSala.getSelectedIndex()==0){
            return false;
        }
        return true;
    }

    private void agenda() {
        if(vista.comboInstitucion.getSelectedItem().toString().equals("PARTICULAR")){
            verificarAgendaParticular();
        }
        else{
            verificarAgendaInstitucion();
        }
    }

    private void verificarAgendaParticular() {
        Institucion particular = new Institucion();
        particular.setNombreInstitucion("PARTICULAR");
        
    }

    private void verificarAgendaInstitucion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
