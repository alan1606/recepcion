/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Mexico;
import clientews.servicio.MexicoServiceImplService;
import clientews.servicio.MexicoServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class MexicoDaoImpl implements MexicoDao {

    private MexicoServiceWs servicio = null;

    public MexicoDaoImpl() {
        if (servicio == null) {
            servicio = new MexicoServiceImplService().getMexicoServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public List<Mexico> encontrarEstadosDeMexico() {
        return servicio.encontrarEstadosDeMexico();
    }

}
