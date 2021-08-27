/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.OrdenVenta;
import clientews.servicio.OrdenVentaServiceImplService;
import clientews.servicio.OrdenVentaServiceWs;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class OrdenVentaDaoImp implements OrdenVentaDao {

    private OrdenVentaServiceWs servicio = null;

    public OrdenVentaDaoImp() {
        if (servicio == null) {
            servicio = new OrdenVentaServiceImplService().getOrdenVentaServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public OrdenVenta encontrarUltimno() {
        return servicio.obtenerUltimaOrdenVentaRegistrada();
        
    }

    @Override
    public void registrar(OrdenVenta orden) {
        servicio.registrarOrdenVenta(orden);
    }
    
    

}
