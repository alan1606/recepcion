/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.OrdenVenta;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface OrdenVentaDao {
    public OrdenVenta encontrarUltimno();
    public void registrar(OrdenVenta orden);
        public List<OrdenVenta> obtenerNoPagadosEnFecha(String date);

}
