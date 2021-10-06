/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.PagoOrdenVenta;
import clientews.servicio.PagoOrdenVentaServiceImplService;
import clientews.servicio.PagoOrdenVentaServiceWs;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class PagoOrdenVentaDaoImp implements PagoOrdenVentaDao{

    private PagoOrdenVentaServiceWs servicio = null;

    public PagoOrdenVentaDaoImp() {
        if (servicio == null) {
            servicio = new PagoOrdenVentaServiceImplService().getPagoOrdenVentaServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }
    
    
    
    @Override
    public void registrarPagoOrdenVenta(PagoOrdenVenta pago) {
        servicio.registrarPagoOrdenVenta(pago);
    }

    @Override
    public void eliminarPagoOrdenVentaPorIdOrdenVenta(Long idOrdenVenta) {
        servicio.eliminarPagoOrdenVentaPorIdOrdenVenta(idOrdenVenta);
    }
    
}
