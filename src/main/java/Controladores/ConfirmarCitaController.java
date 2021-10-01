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
import Utilidades.UrlUtil;
import Vistas.ConfirmarCita;
import Vistas.Menu;
import clientews.servicio.OrdenVenta;
import clientews.servicio.VentaConceptos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
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

    private void enviarMensajes() {
        //Este método va a recorrer la tabla de los estudios que hay en ese día y va a mandar mensajes a los números que correspondan

        ///Sin embargo, hay que mandar mensaje por la órden, pudiendo encontrar cualquier estudio se manda un mensaje con todo el detalle, por lo tanto, se va a confirmar la
        //órden entera
        List<VentaConceptos> conceptosDeOrden;
        for (int i = 0; i < vista.tablePacientes.getRowCount(); i++) {
            String telefono = "";

            //Se intena obtener el telefono del cliente de la tabla
            try {
                telefono = vista.tablePacientes.getValueAt(i, 4).toString();
            } catch (Exception e) {
            }

            //Si hay un dato en el campo teléfono
            if (!telefono.equals("")) {
                telefono = limpiarTelefono(telefono); //Aquí se limpian los caracteres que no son números
                Long id = Long.parseLong(vista.tablePacientes.getValueAt(i, 0).toString());//Se obtiene el id del venta concepto
                String estudio = vista.tablePacientes.getValueAt(i, 1).toString(); //Se obtene la descripción del estudio mencionado
                String hora = vista.tablePacientes.getValueAt(i, 2).toString(); //La hora en que se asignó ese concepto
                String paciente = vista.tablePacientes.getValueAt(i, 3).toString(); //El nombre del paciente
                Long idPaciente = Long.parseLong(vista.tablePacientes.getValueAt(i, 6).toString()); //Id del paciente, para pasar a la api confirmadora
                Long idConcepto = Long.parseLong(vista.tablePacientes.getValueAt(i, 7).toString()); //Este valor también se envía a la api
                String mensaje = "";

                VentaConceptos elDeTabla = modeloVentaConceptos.findById(id);//Se busca el objeto como está realmente en la base de datos para saber a qué orden pertenece
                conceptosDeOrden = modeloVentaConceptos.findByIdOrdenVenta(elDeTabla.getIdOrdenVenta().getIdOv()); //Se buscan todos los conceptos de esa orden

                if (conceptosDeOrden.size() == 1) {//Si solo hay un concepto el mensaje va a estar en singular
                    mensaje = formatea("https://wa.me/%2B52" + telefono + "?text=" + "Hola " + paciente + " este mensaje es para confirmar su cita: ");
                } else {//Mensaje en plural
                    mensaje = formatea("https://wa.me/%2B52" + telefono + "?text=" + "Hola " + paciente + " este mensaje es para confirmar sus citas: ");
                }
                //Este for va a recorrer todos los ventaConceptos que existen respecto a esa orden

                for (VentaConceptos temporal : conceptosDeOrden) {
                    mensaje += formatea("%0A    *" + temporal.getIdConceptoEs().getConceptoTo() + " del día " + temporal.getFechaAsignado() + " a las " + temporal.getHoraAsignado());
                    temporal.setEstado("ESPERANDO CONFIRMACION");
                    modeloVentaConceptos.actualizarVentaConceptos(temporal);
                }

                mensaje += formatea("%0APara confirmar su asistencia por favor ingrese en el siguiente enlace: https://ris.diagnocare.app/confirmarCita/" + elDeTabla.getIdOrdenVenta().getIdOv()
                        + "%7C" + idPaciente + "%7C" + fechaParaEnviar(elDeTabla.getIdOrdenVenta().getFechaVentaOv())
                        + "%0A*NOTA: * Si no confirma su cita será asignada a otra persona, por lo que es indispensable que lo haga");

                UrlUtil.goToURL(mensaje);
                //Hay que actualizar el estado de la orden a esperando confirmacion
                // orden.setEstatusOv();     Pero me doy cuenta que no hay campo en la base de datos para eso jajajajaja

                //Hay que actualizar el estado de cada venta conceptos a esperando confirmacion
            } else {
                //Si no, simplemente se ignora y no se envía nada
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

    private String fechaParaEnviar(String fechaVentaOv) {
        String fecha = ""; //%5E
        for (int i = 0; i < fechaVentaOv.length(); i++) {
            if (fechaVentaOv.charAt(i) == ' ') {
                fecha += ",";
            } else {
                fecha += fechaVentaOv.charAt(i);
            }
        }
        return fecha;
    }
}
