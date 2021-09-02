/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Vistas.NuevoPaciente;
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
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author alanm
 */
public class NuevoPacienteController implements ActionListener, KeyListener {

    private NuevoPaciente vista;
    private Pacientes paciente;
    private Date fechaActual;
    private XMLGregorianCalendar fechaActualXml;

    public NuevoPacienteController(NuevoPaciente vista) {
        this.vista = vista;

        obtenerFechaActual();

    }

    public void iniciar() {
        vista.setTitle("Nuevo paciente");
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
                    Logger.getLogger(NuevoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                registrar();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void crearPaciente() throws Exception {
        paciente = new Pacientes();
        String curp = generarCurp();
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

        if (vista.comboEntidad.getSelectedItem().toString() != "MEXICO") {
            entidad = "NE";
        } else {
            entidad = encontrarEntidad();
        }

        return CurpGenerator.generar(vista.txtApellidoPaterno.getText(), vista.txtApellidoMaterno.toString(), vista.txtNombre.getText(), sexo, dateToString(vista.dateFechaNacimiento.getDate().getTime()), entidad);
    }

    private String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private String encontrarEntidad() {
        String entidad = vista.comboEntidad.getSelectedItem().toString();
        String c12Y13 ="";
        if (entidad == "AGUASCALIENTES")
        {
            c12Y13 = "AS";
        }
        else if (entidad=="BAJA CALIFORNIA")
        {
            c12Y13 = "BC";
        }
        else if (entidad=="BAJA CALIFORNIA SUR")
        {
            c12Y13 = "BS";
        }
        else if (entidad=="CAMPECHE")
        {
            c12Y13 = "CC";
        }
        else if (entidad=="COAHUILA DE ZARAGOZA")
        {
            c12Y13 = "CL";
        }
        else if (entidad=="COLIMA")
        {
            c12Y13 = "CM";
        }
        else if (entidad=="CHIAPAS")
        {
            c12Y13 = "CS";
        }
        else if (entidad=="CHIHUAHUA")
        {
            c12Y13 = "CH";
        }
        else if (entidad=="CIUDAD DE MEXICO")
        {
            c12Y13 = "DF";
        }
        else if (entidad=="DURANGO")
        {
            c12Y13 = "DG";
        }
        else if (entidad=="GUANAJUATO")
        {
            c12Y13 = "GT";
        }
        else if (entidad=="GUERRERO")
        {
            c12Y13 = "GR";
        }
        else if (entidad=="HIDALGO")
        {
            c12Y13 = "HG";
        }
        else if (entidad=="JALISCO")
        {
            c12Y13 = "JC";
        }
        else if (entidad=="MEXICO")
        {
            c12Y13 = "MC";
        }
        else if (entidad=="MICHOACAN DE OCAMPO")
        {
            c12Y13 = "MN";
        }
        else if (entidad=="MORELOS")
        {
            c12Y13 = "MS";
        }
        else if (entidad=="NAYARIT")
        {
            c12Y13 = "NT";
        }
        else if(entidad == "NUEVO LEON")
        {
            c12Y13 = "NL";
        }
        else if(entidad == "OAXACA")
        {
            c12Y13 = "OC";
        }
        else if(entidad == "PUEBLA")
        {
            c12Y13 = "PL";
        }
        else if(entidad == "QUERETARO")
        {
            c12Y13 = "QT";
        }
        else if(entidad == "QUINTANA ROO")
        {
            c12Y13 = "QR";
        }
        else if(entidad == "SAN LUIS POTOSI")
        {
            c12Y13 = "SP";
        }
        else if(entidad == "SINALOA")
        {
            c12Y13 = "SL";
        }
        else if(entidad == "SONORA")
        {
            c12Y13 = "SR";
        }
        else if(entidad == "TABASCO")
        {
            c12Y13 = "TC";
        }
        else if(entidad == "TAMAULIPAS")
        {
            c12Y13 = "TS";
        }
        else if(entidad == "TLAXCALA")
        {
            c12Y13 = "TL";
        }
        else if(entidad == "VERACRUZ DE IGNACIO DE LA LLAVE")
        {
            c12Y13 = "VZ";
        }
        else if(entidad == "YUCATAN")
        {
            c12Y13 = "YN";
        }
        else if(entidad == "ZACATECAS")
        {
            c12Y13 = "ZS";
        }
        return c12Y13;
    }

 
}
