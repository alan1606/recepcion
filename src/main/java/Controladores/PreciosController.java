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
import DAO.ConceptosInstitucionDao;
import DAO.ConceptosInstitucionDaoImpl;
import DAO.InstitucionDao;
import DAO.InstitucionDaoImp;
import Vistas.Menu;
import Vistas.Precios;
import clientews.servicio.Areas;
import clientews.servicio.Conceptos;
import clientews.servicio.ConceptosInstitucion;
import clientews.servicio.Institucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Ultrasonido
 */
public class PreciosController implements ActionListener {

    private Precios vista;
    private Institucion institucion;
    private InstitucionDao modeloInstituciones;
    private AreasDao modeloAreas;
    private ConceptosDao modeloConceptos;
    private ConceptosInstitucionDao modeloConceptosInstitucion;
    private ConceptosInstitucion conceptoInstitucion;
    private Areas area;
    private Conceptos estudio;

    public PreciosController(Precios vista) {

        this.vista = vista;

        this.vista.btnRegresar.addActionListener(this);
        this.vista.comboArea.addActionListener(this);
        this.vista.comboEstudio.addActionListener(this);

        modeloInstituciones = new InstitucionDaoImp();
        modeloAreas = new AreasDaoImpl();
        modeloConceptos = new ConceptosDaoImp();
        modeloConceptosInstitucion = new ConceptosInstitucionDaoImpl();
    }

    public void iniciar() {
        vista.setTitle("Consultar precios");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        cargarInstitucionParticular();
        cargarAreas();
        
        vista.lblPrecio.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vista.comboArea) {
            if (this.vista.comboArea.getSelectedIndex() != 0) {//Se selecciona una opción que es diferente de "Seleccione una opción"
                area = modeloAreas.encontrarPorNombre(vista.comboArea.getSelectedItem().toString());
                cargarEstudiosDeAreaInstitucion();
            }
        } else if (e.getSource() == vista.comboEstudio) {
            if (vista.comboEstudio.getSelectedIndex() != 0) {
                obtenerConcepto();
                cargarPrecio();
            }
        }
        else if(e.getSource() == vista.btnRegresar){
            abrirMenu();
        }

    }

    private void cargarInstitucionParticular() {
        institucion = new Institucion();
        institucion.setNombreInstitucion("PARTICULAR");
        institucion = modeloInstituciones.encontrarPorNombre(institucion);
    }

    private void cargarAreas() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Areas areaFor : modeloAreas.encontrarPorInstitucion(institucion)) {
                combo.addItem(areaFor.getNombreA());
            }
            vista.comboArea.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarEstudiosDeAreaInstitucion() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Conceptos conceptoFor : modeloConceptos.encontrarConceptosPorAreaInstitucion(institucion.getIdInstitucion(), area.getIdA())) {
                combo.addItem(conceptoFor.getConceptoTo());
            }
            vista.comboEstudio.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void obtenerConcepto() {
        estudio = modeloConceptos.encontrarConceptoPorNombre(vista.comboEstudio.getSelectedItem().toString());
    }

    private void cargarPrecio() {
        try {
            conceptoInstitucion = modeloConceptosInstitucion.encontrarConceptoInstitucionPorIdConceptoIdInstitucion(estudio.getIdTo(), institucion.getIdInstitucion());
            vista.lblPrecio.setText("$" + conceptoInstitucion.getPrecioPublico() + "");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, "El concepto no se ofrece para particulares");
        }
    }

    private void abrirMenu() {
        vista.dispose();
        MenuController menu = new MenuController(new Menu());
        menu.iniciar();
    }
    
}
