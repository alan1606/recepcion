/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.CatalogoFormaPago;
import clientews.servicio.CatalogoFormaPagoServiceImplService;
import clientews.servicio.CatalogoFormaPagoServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class CatalogoFormaPagoDaoImp implements CatalogoFormaPagoDao{

    private CatalogoFormaPagoServiceWs servicio = null;

    public CatalogoFormaPagoDaoImp() {
        if(servicio == null){
            servicio = new CatalogoFormaPagoServiceImplService().getCatalogoFormaPagoServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }
    
    
    
    @Override
    public List<CatalogoFormaPago> obtenerFormasDePago() {
        return servicio.listarTodasFormasPago();
    }
    
}
