/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import DAO.VentaConceptosDao;
import DAO.VentaConceptosDaoImp;
import Tables.TableConceptos;
import Vistas.ConfirmarCita;
import Vistas.Menu;
import clientews.servicio.VentaConceptos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alanm
 */
public class ConfirmarCitaController implements ActionListener, KeyListener, MouseListener, PropertyChangeListener {

    private ConfirmarCita vista;
    private VentaConceptosDao modeloVentaConceptos;
    private PacientesDao modeloPacientes;

    public ConfirmarCitaController(ConfirmarCita vista) {
        this.vista = vista;

        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloPacientes = new PacientesDaoImp();

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnRegresar.addActionListener(this);
        this.vista.btnConfirmarManual.addActionListener(this);

        this.vista.dateFecha.addPropertyChangeListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            enviarMensajes();
        } else if (e.getSource() == vista.btnRegresar) {
            vista.dispose();
            Menu vista = new Menu();
            MenuController menu = new MenuController(vista);
            menu.iniciar();
        } else if (e.getSource() == vista.btnConfirmarManual) {
            if (deseaConfirmar() == 0) {
                confirmacionManual();
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
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getSource() == vista.dateFecha) {
            if (vista.dateFecha.getDate() != null) {
                cargarConceptosDe(dateToString(vista.dateFecha.getDate().getTime()));
            }
        }

    }

    public void iniciar() {
        vista.setTitle("Confirmar citas");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private void cargarConceptosDe(String fecha) {
        TableConceptos tabla = new TableConceptos();
        tabla.cargarTabla(this.vista.tablePacientes, modeloVentaConceptos.findAgendadosByFecha(fecha));
    }

    public void goToURL(String URL) {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(ConfirmarCitaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void enviarMensajes() {
        for (int i = 0; i < vista.tablePacientes.getRowCount(); i++) {
            String telefono = "";

            try {
                telefono = vista.tablePacientes.getValueAt(i, 4).toString();
            } catch (Exception e) {
            }

            if (!telefono.equals("")) {
                telefono = limpiarTelefono(telefono);
                Long id = Long.parseLong(vista.tablePacientes.getValueAt(i, 0).toString());
                String estudio = vista.tablePacientes.getValueAt(i, 1).toString();
                String hora = vista.tablePacientes.getValueAt(i, 2).toString();
                String paciente = vista.tablePacientes.getValueAt(i, 3).toString();
                Long idPaciente = Long.parseLong(vista.tablePacientes.getValueAt(i, 6).toString());
                Long idConcepto = Long.parseLong(vista.tablePacientes.getValueAt(i, 7).toString());

                String mensaje = formatea("https://wa.me/%2B52" + telefono + "?text=" + "Hola " + paciente + " este mensaje es para confirmar su cita del día "
                        + dateToString(vista.dateFecha.getDate().getTime()) + " de su estudio: "
                        + estudio + " a las " + hora + "%0APara confirmar su cita, por favor ingrese en el siguiente enlace: https://ris.diagnocare.app/confirmarCita/" + id
                        + "-" + idPaciente + "-" + idConcepto
                        + "%0A*NOTA: * Si no confirma su cita será asignada a otra persona, por lo que es indispensable que lo haga"
                );

                goToURL(mensaje);

            } else {
                continue;
            }

        }
    }

    private String limpiarTelefono(String telefono) {
        String resultado = "";
        char car = 'a';
        for (int i = 0; i < telefono.length(); i++) {
            car = telefono.charAt(i);
            if (car >= '0' && car <= '9') {
                resultado += car;
            }
        }
        return resultado;
    }

    private String formatea(String string) {
        String nueva = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                nueva += "%20";
            } else {
                nueva += string.charAt(i);
            }
        }
        return nueva;
    }

    private void confirmacionManual() {
        if (vista.tablePacientes.getSelectedRow() != -1) { //Si se seleccionó una fila
            Long idVentaConcepto = obtenerIdVentaConceptoDeFila(vista.tablePacientes.getSelectedRow());
            VentaConceptos seleccionado = modeloVentaConceptos.findById(idVentaConcepto);
            seleccionado.setEstado("CONFIRMADO");
            modeloVentaConceptos.actualizarVentaConceptos(seleccionado);
            if (vista.dateFecha.getDate() != null) {
                cargarConceptosDe(dateToString(vista.dateFecha.getDate().getTime()));
            }
            JOptionPane.showMessageDialog(null, "Se ha confirmado la orden");
        }
    }

    private Long obtenerIdVentaConceptoDeFila(int selectedRow) {
        Long id = 0l;
        try {
            id = Long.parseLong(vista.tablePacientes.getValueAt(selectedRow, 0).toString());
        } catch (Exception e) {
        }
        return id;
    }

    private int deseaConfirmar() {
 int dialog = JOptionPane.YES_NO_OPTION;
        return (JOptionPane.showConfirmDialog(null, "¿Seguro que desea confirmar la cita? ", "Confirmar", dialog));
    }
}
