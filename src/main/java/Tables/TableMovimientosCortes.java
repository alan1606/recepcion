/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import clientews.servicio.MovimientoCorte;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alanm
 */
public class TableMovimientosCortes {

    public void cargarTabla(JTable tabla, List<MovimientoCorte> list) {

        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Tipo");
        dt.addColumn("Cantidad");
        dt.addColumn("Fecha");
        dt.addColumn("Descripción");

        MovimientoCorte movimiento = new MovimientoCorte();

        for (int i = 0; i < list.size(); i++) {
            Object fila[] = new Object[4];
            movimiento = list.get(i);
            if (movimiento.isEntrada()) {
                fila[0] = "ENTRADA";
            } else {
                fila[0] = "SALIDA";
            }
            fila[1] = movimiento.getCantidad();
            fila[2] = movimiento.getFecha();
            fila[3] = movimiento.getDescripcion();
            dt.addRow(fila);
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(70);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(120);

    }

}
