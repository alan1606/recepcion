/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.OrdenVenta;
import clientews.servicio.PagoOrdenVenta;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface PagoOrdenVentaDao {
    public void registrarPagoOrdenVenta(PagoOrdenVenta pago);
        public void eliminarPagoOrdenVentaPorIdOrdenVenta(Long idOrdenVenta);
    public List<PagoOrdenVenta> obtenerPagosDeOrdenVenta(OrdenVenta ordenVenta);

}
