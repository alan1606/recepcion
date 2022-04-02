/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import clientews.servicio.Medico;
import clientews.servicio.Pacientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alanm
 */
public class TableMedicos {

    public void cargarTabla(JTable tabla, List<Medico> list) {

        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Nombres");
        dt.addColumn("Apellidos");
        dt.addColumn("Especialidad");
        dt.addColumn("Teléfono");
        dt.addColumn("Correo");
        dt.addColumn("Dirección");
        dt.addColumn("Fecha de nacimiento");
        dt.addColumn("Whatsapp");
        dt.addColumn("Referente");
        dt.addColumn("Id");

        list.forEach(m -> {
            Object fila[] = new Object[10];
            fila[0] = m.getNombres();
            fila[1] = m.getApellidos();
            fila[2] = m.getEspecialidad();
            fila[3] = m.getTelefono();
            fila[4] = m.getCorreo();
            fila[5] = m.getDireccion();
            fila[6] = m.getFechaNacimiento();
            fila[7] = m.getWhatsapp();
            if (m.isRadiologo()) {
                fila[8] = "RADIOLOGO";
            } else {
                fila[8] = "REFERENTE";
            }
            fila[9] = m.getId();

            dt.addRow(fila);
        });

        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(30);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(30);
        columnModel.getColumn(7).setPreferredWidth(30);
        columnModel.getColumn(8).setPreferredWidth(30);
        columnModel.getColumn(9).setPreferredWidth(1);
    }

    public void cargarTablaVacia(JTable tabla) {

        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Nombres");
        dt.addColumn("Apellidos");
        dt.addColumn("Especialidad");
        dt.addColumn("Teléfono");
        dt.addColumn("Correo");
        dt.addColumn("Dirección");
        dt.addColumn("Fecha de nacimiento");
        dt.addColumn("Whatsapp");
        dt.addColumn("Referente");
        dt.addColumn("Id");

        Medico medico = new Medico();

        Object fila[] = new Object[5];
        fila[0] = "";
        fila[1] = "";
        fila[2] = "";
        fila[3] = "";
        fila[4] = "";
        fila[5] = "";
        fila[6] = "";
        fila[7] = "";
        fila[8] = "";
        fila[9] = "";
        dt.addRow(fila);

        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(30);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(30);
        columnModel.getColumn(7).setPreferredWidth(30);
        columnModel.getColumn(8).setPreferredWidth(30);
        columnModel.getColumn(9).setPreferredWidth(1);
    }

}
