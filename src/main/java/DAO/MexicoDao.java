/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Mexico;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface MexicoDao {
    public List<Mexico> encontrarEstadosDeMexico();
    public Mexico encontrarEstadoPorId(Integer id);
public Mexico encontrarEstadoPorNombre(String nombre);
}
