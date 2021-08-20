/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Areas;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface AreasDao {

    public Areas encontrarPorId(Integer id);

    public List<Areas> listar();
    
    public Areas encontrarPorNombre(String nombre);
}
