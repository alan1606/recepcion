/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.PagoOrdenVenta;

/**
 *
 * @author alanm
 */
public interface PagoOrdenVentaDao {
    public void registrarPagoOrdenVenta(PagoOrdenVenta pago);
        public void eliminarPagoOrdenVentaPorIdOrdenVenta(Long idOrdenVenta);

}
