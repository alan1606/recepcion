/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Usuarios;

/**
 *
 * @author alanm
 */
public interface UsuariosDao {
    
    public boolean loginValido(Usuarios usuario);
    
}
