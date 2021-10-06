/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.MexicoDao;
import DAO.MexicoDaoImpl;
import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import Vistas.AgendarCita;
import Vistas.ModificarPaciente;
import Vistas.NuevoPaciente;
import clientews.servicio.Mexico;
import clientews.servicio.Pacientes;
import curp.CurpGenerator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author alanm
 */
public class ModificarPacienteController implements ActionListener, KeyListener {

    private ModificarPaciente vista;
    private Pacientes paciente;
    private Date fechaActual;
    private XMLGregorianCalendar fechaActualXml;
    private MexicoDao modeloMexico;
    private PacientesDao modeloPacientes;

    public ModificarPacienteController(ModificarPaciente vista) {
        this.vista = vista;

        obtenerFechaActual();
        cargarSexo();
        cargarPaises();
        ponerComboEntidadVacio();

        modeloMexico = new MexicoDaoImpl();
        modeloPacientes = new PacientesDaoImp();

        this.vista.comboPais.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.comboSexo.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
        
        this.vista.txtNombre.addKeyListener(this);
        this.vista.txtApellidoMaterno.addKeyListener(this);
        this.vista.txtApellidoPaterno.addKeyListener(this);

    }

    public void iniciar() {
        vista.setTitle("Modificar paciente");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            if (datosValidos()) {
                try {
                    crearPaciente();
                } catch (Exception ex) {
                    Logger.getLogger(ModificarPacienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                registrar();
            }
        } else if (e.getSource() == vista.comboPais) {
            if (vista.comboPais.getSelectedItem().toString().equals("MEXICO")) {
                cargarEstados();
                habilitarEstados(true);
            } else {
                ponerComboEntidadVacio();
                if (vista.comboEntidad.getItemCount() != 0) {
                    vista.comboEntidad.setSelectedIndex(0);
                }
                habilitarEstados(false);
            }
        } else if (e.getSource() == vista.comboSexo) {
            if (datosValidosCurp()) {
                try {
                    vista.txtCurp.setText(generarCurp());
                } catch (Exception ex) {
                    Logger.getLogger(ModificarPacienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == vista.btnLimpiar) {
            limpiar();
            habilitarEstados(true);
        } else if (e.getSource() == vista.btnCancelar || e.getSource() == vista.btnRegresar) {
            abrirAgenda();
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
        if (e.getSource() == vista.txtNombre) {
            vista.txtNombre.setText(vista.txtNombre.getText().toUpperCase());
        } else if (e.getSource() == vista.txtApellidoMaterno) {
            vista.txtApellidoMaterno.setText(vista.txtApellidoMaterno.getText().toUpperCase());
        } else if (e.getSource() == vista.txtApellidoPaterno) {
            vista.txtApellidoPaterno.setText(vista.txtApellidoPaterno.getText().toUpperCase());
        }
    }

    private boolean datosValidos() {
        if (vista.txtNombre.getText().equals("")) {
            return false;
        }
        if (vista.txtApellidoMaterno.equals("")) {
            return false;
        }
        if (vista.txtCurp.equals("")) {
            return false;
        }
        if (vista.txtTelefono.equals("")) {
            return false;
        }
        if (vista.txtCorreo.equals("")) {
            return false;
        }
        if (vista.comboPais.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboSexo.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.dateFechaNacimiento.getDate() == null) {
            return false;
        }

        //Tratar entidades
        if (vista.comboPais.getSelectedItem().toString() == "MEXICO" && vista.comboEntidad.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private void registrar() {
        if (deseaRegistrar() == 0) {
            modeloPacientes.guardar(paciente);
            JOptionPane.showMessageDialog(null, "Paciente registrado");
            limpiar();
            habilitarEstados(true);
        }
    }

    private void crearPaciente() throws Exception {
        paciente = new Pacientes();
        String curp = vista.txtCurp.getText();
        //Estos sí importan o hay que ponerlos por defecto
        paciente.setAmaternoP(vista.txtApellidoMaterno.getText());
        paciente.setApaternoP(vista.txtApellidoPaterno.getText());
        paciente.setEmailP(vista.txtCorreo.getText());

        paciente.setFNacp(aXmlDate(vista.dateFechaNacimiento.getDate()));

        paciente.setIdP(0l);
        paciente.setNombreCompletoP(vista.txtNombre.getText() + " " + vista.txtApellidoPaterno.getText() + " " + vista.txtApellidoMaterno.getText());
        paciente.setNombreP(vista.txtNombre.getText());

        paciente.setSexoP(Short.parseShort(vista.comboSexo.getSelectedIndex() + "")); //1 Mujer  2 hombre

        paciente.setTCelularp(vista.txtTelefono.getText());
        paciente.setCurpP(curp);
        paciente.setIdSucursalp(Short.parseShort("1")); //Todos están así
        paciente.setIdUsuarioRp(3);
        paciente.setFechaRp(fechaActualXml);
        paciente.setNacionalidadP(Short.parseShort("146"));
        paciente.setActivoP(Short.parseShort("1"));

        paciente.setEntidadNacimientoP(0);
        paciente.setEntidadFederativap(0);
        paciente.setEntidadFederativapf(0);
        paciente.setEmailPf("");
        paciente.setAlergiasP("");
        paciente.setApgarP(Short.parseShort("0"));
        paciente.setCalleP("");
        paciente.setCallePf("");
        paciente.setCentroSaludP(0);
        paciente.setCiudadP("");
        paciente.setCiudadPf("");
        paciente.setColoniaP("");
        paciente.setColoniaPf("");
        paciente.setContactoEmergenciap("");
        paciente.setCoordenadasP(null);
        paciente.setCpP("");
        paciente.setCpPf("");
        paciente.setEdoCivilP(Short.parseShort("0"));
        paciente.setEscolaridadP(Short.parseShort("0"));
        paciente.setExtensionTtp("");
        paciente.setGrupoEtnicop(Short.parseShort("0"));
        paciente.setIdDiscapacidadp(Short.parseShort("0"));
        paciente.setIdOcupacionp(0);
        paciente.setIdReligionp(Short.parseShort("0"));
        paciente.setMunicipioP(0);
        paciente.setMunicipioPf(0);
        paciente.setNSocioeconomicop(Short.parseShort("0"));
        paciente.setNoSeguridadSocialP("");
        paciente.setNotasP("");
        paciente.setParentescoContactoP(Short.parseShort("0"));
        paciente.setRazonSocialP("");
        paciente.setRfcFP("");
        paciente.setRfcP("");
        paciente.setTEmergenciap("");
        paciente.setTParticularp("");
        paciente.setTSanguineop(Short.parseShort("0"));
        paciente.setTTrabajop("");
        paciente.setTViviendap(Short.parseShort("0"));
        paciente.setTamizP(Short.parseShort("0"));

    }

    private void obtenerFechaActual() {
        fechaActual = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fechaActual);
        fechaActualXml = null;
        try {
            fechaActualXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(AgendarCitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private XMLGregorianCalendar aXmlDate(Date date) {
        XMLGregorianCalendar fecha = null;
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        try {
            fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(AgendarCitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }

    private String generarCurp() throws Exception {
        String sexo = "";
        String entidad = "";

        if (vista.comboSexo.getSelectedIndex() == 1) {
            sexo = "M";
        } else {
            sexo = "H";
        }
        if (vista.comboPais.getSelectedItem().toString() != "MEXICO") {
            entidad = "NE";
        } else {
            entidad = encontrarEntidad();
        }
        System.out.println(dateToString(vista.dateFechaNacimiento.getDate().getTime()));
        return CurpGenerator.generar(vista.txtApellidoPaterno.getText(), vista.txtApellidoMaterno.getText(), vista.txtNombre.getText(), sexo, dateToString(vista.dateFechaNacimiento.getDate().getTime()), entidad);
    }

    private String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private void cargarEstados() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            for (Mexico estado : modeloMexico.encontrarEstadosDeMexico()) {
                combo.addItem(estado.getDEstado());
            }
            vista.comboEntidad.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarPaises() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            combo.addItem("MEXICO");
            combo.addItem("OTRO");
            vista.comboPais.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cargarSexo() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            combo.addItem("FEMENINO");
            combo.addItem("MASCULINO");
            vista.comboSexo.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private String encontrarEntidad() {
        String entidad = vista.comboEntidad.getSelectedItem().toString();
        String c12Y13 = "";
        if (entidad.equals("AGUASCALIENTES")) {
            c12Y13 = "AS";
        } else if (entidad.equals("BAJA CALIFORNIA")) {
            c12Y13 = "BC";
        } else if (entidad.equals("BAJA CALIFORNIA SUR")) {
            c12Y13 = "BS";
        } else if (entidad.equals("CAMPECHE")) {
            c12Y13 = "CC";
        } else if (entidad.equals("COAHUILA DE ZARAGOZA")) {
            c12Y13 = "CL";
        } else if (entidad.equals("COLIMA")) {
            c12Y13 = "CM";
        } else if (entidad.equals("CHIAPAS")) {
            c12Y13 = "CS";
        } else if (entidad.equals("CHIHUAHUA")) {
            c12Y13 = "CH";
        } else if (entidad.equals("CIUDAD DE MEXICO")) {
            c12Y13 = "DF";
        } else if (entidad.equals("DURANGO")) {
            c12Y13 = "DG";
        } else if (entidad.equals("GUANAJUATO")) {
            c12Y13 = "GT";
        } else if (entidad.equals("GUERRERO")) {
            c12Y13 = "GR";
        } else if (entidad.equals("HIDALGO")) {
            c12Y13 = "HG";
        } else if (entidad.equals("JALISCO")) {
            c12Y13 = "JC";
        } else if (entidad.equals("MEXICO")) {
            c12Y13 = "MC";
        } else if (entidad.equals("MICHOACAN DE OCAMPO")) {
            c12Y13 = "MN";
        } else if (entidad.equals("MORELOS")) {
            c12Y13 = "MS";
        } else if (entidad.equals("NAYARIT")) {
            c12Y13 = "NT";
        } else if (entidad.equals("NUEVO LEON")) {
            c12Y13 = "NL";
        } else if (entidad.equals("OAXACA")) {
            c12Y13 = "OC";
        } else if (entidad.equals("PUEBLA")) {
            c12Y13 = "PL";
        } else if (entidad.equals("QUERETARO")) {
            c12Y13 = "QT";
        } else if (entidad.equals("QUINTANA ROO")) {
            c12Y13 = "QR";
        } else if (entidad.equals("SAN LUIS POTOSI")) {
            c12Y13 = "SP";
        } else if (entidad.equals("SINALOA")) {
            c12Y13 = "SL";
        } else if (entidad.equals("SONORA")) {
            c12Y13 = "SR";
        } else if (entidad.equals("TABASCO")) {
            c12Y13 = "TC";
        } else if (entidad.equals("TAMAULIPAS")) {
            c12Y13 = "TS";
        } else if (entidad.equals("TLAXCALA")) {
            c12Y13 = "TL";
        } else if (entidad.equals("VERACRUZ DE IGNACIO DE LA LLAVE")) {
            c12Y13 = "VZ";
        } else if (entidad.equals("YUCATAN")) {
            c12Y13 = "YN";
        } else if (entidad.equals("ZACATECAS")) {
            c12Y13 = "ZS";
        }
        return c12Y13;
    }

    private void habilitarEstados(boolean b) {
        vista.comboEntidad.setEnabled(b);
    }

    private boolean datosValidosCurp() {
        if (vista.txtNombre.getText().equals("")) {
            return false;
        }
        if (vista.txtApellidoMaterno.getText().equals("")) {
            return false;
        }
        if (vista.txtApellidoPaterno.getText().equals("")) {
            return false;
        }
        if (vista.dateFechaNacimiento.getDate() == null) {
            return false;
        }
        if (vista.comboPais.getSelectedItem().toString().equals("MEXICO") && vista.comboEntidad.getSelectedIndex() == 0) {
            return false;
        }
        if (vista.comboSexo.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private int deseaRegistrar() {
        int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea registrar el paciente? ", "Registrar", dialog));
    }

    private void limpiar() {
        vista.txtNombre.setText("");
        vista.txtApellidoMaterno.setText("");
        vista.txtApellidoPaterno.setText("");
        vista.txtCorreo.setText("");
        vista.txtCurp.setText("");
        vista.txtTelefono.setText("");

        vista.comboEntidad.setSelectedIndex(0);
        vista.comboPais.setSelectedIndex(0);
        vista.comboSexo.setSelectedIndex(0);

        vista.dateFechaNacimiento.setDate(null);

    }

    private void ponerComboEntidadVacio() {
        try {
            JComboBox combo = new JComboBox();
            combo.removeAllItems();
            combo.addItem("SELECCIONE UNA OPCIÓN");
            vista.comboEntidad.setModel(combo.getModel());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void abrirAgenda() {
        vista.dispose();
        AgendarCitaController controladorCitas = new AgendarCitaController(new AgendarCita());
        controladorCitas.iniciar();
    }

}
