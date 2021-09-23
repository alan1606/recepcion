/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Usuarios;
import clientews.servicio.UsuariosServiceImplService;
import clientews.servicio.UsuariosServiceWs;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class UsuariosDaoImpl implements UsuariosDao {

    private UsuariosServiceWs servicio = null;

    public UsuariosDaoImpl() {
        if (servicio == null) {
            servicio = new UsuariosServiceImplService().getUsuariosServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public boolean loginValido(Usuarios usuario) {
        return servicio.esCorrectoLogin(usuario);
    }

}
