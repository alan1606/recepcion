/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.OrdenVentaDao;
import DAO.OrdenVentaDaoImp;
import DAO.PacientesDao;
import DAO.PacientesDaoImp;
import DAO.VentaConceptosDao;
import DAO.VentaConceptosDaoImp;
import Tables.TableConceptos;
import Tables.TableOrdenesVenta;
import Vistas.DatosFacturacion;
import Vistas.PagarOrden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author alanm
 */
public class PagarOrdenController implements ActionListener, PropertyChangeListener, MouseListener{
    
    private PagarOrden vistaPrincipal;
    private DatosFacturacion vistaFacturacion;
    private OrdenVentaDao modeloOrdenesVenta;
    private VentaConceptosDao modeloVentaConceptos;
    private PacientesDao modeloPacientes;
    
    
    public PagarOrdenController(PagarOrden vistaPrincipal, DatosFacturacion vistaFacturacion) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaFacturacion = vistaFacturacion;
        
        modeloOrdenesVenta = new OrdenVentaDaoImp();
        modeloVentaConceptos = new VentaConceptosDaoImp();
        modeloPacientes = new PacientesDaoImp();
        
        this.vistaPrincipal.btnPagar.addActionListener(this);
        this.vistaPrincipal.comboPaciente.addActionListener(this);
        this.vistaPrincipal.dateFecha.addPropertyChangeListener(this);
        this.vistaPrincipal.tableOrdenes.addMouseListener(this);
    }
    
    public void iniciar() {
        vistaPrincipal.setTitle("Pagar órdenes");
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getSource() == vistaPrincipal.dateFecha){
            if(vistaPrincipal.dateFecha.getDate()!=null){
                mostrarOrdenes(dateToString(vistaPrincipal.dateFecha.getDate().getTime()));
            }
        }
    }
    
       @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vistaPrincipal.tableOrdenes){
            System.out.println("aaaaaaaa");
            int fila = vistaPrincipal.tableOrdenes.getSelectedRow();
            if(fila != -1){
                Long idOrden = Long.parseLong(vistaPrincipal.tableOrdenes.getValueAt(fila, 0).toString());
                cargarEstudios(idOrden);
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
    
     private String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    private void mostrarOrdenes(String fecha) {
        TableOrdenesVenta tableOrdenesVenta = new TableOrdenesVenta();
        tableOrdenesVenta.cargarTabla(vistaPrincipal.tableOrdenes, modeloOrdenesVenta.obtenerNoPagadosEnFecha(fecha));
    }

    private void cargarEstudios(Long idOrden) {
        TableConceptos tableConceptos = new TableConceptos();
        tableConceptos.cargarTabla(vistaPrincipal.tableEstudios, modeloVentaConceptos.findByIdOrdenVenta(idOrden));
    }

 
    
}
