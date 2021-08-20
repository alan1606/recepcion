/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Institucion;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface InstitucionDao {

    public List<Institucion> listar();

    public Institucion encontrarPorId(Institucion institucion);

    public Institucion encontrarPorNombre(Institucion institucion);

}
