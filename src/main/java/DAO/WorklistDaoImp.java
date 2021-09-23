/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.WorklistServiceImplService;
import clientews.servicio.WorklistServiceWs;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class WorklistDaoImp implements WorklistDao {

    private WorklistServiceWs servicio = null;

    public WorklistDaoImp() {
        if (servicio == null) {
            servicio = new WorklistServiceImplService().getWorklistServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public void registrarEnWorklist(long idVentaConcepto) {
        servicio.registrarEnWorklist(idVentaConcepto);
    }

    @Override
    public void registrarEnWorklistPorOrdenVenta(long idOrdenVenta) {
        servicio.registrarEnWorklistPorOrdenVenta(idOrdenVenta);
    }

}
