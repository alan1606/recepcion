/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Pacientes;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface PacientesDao {
    List<Pacientes> encontrarTodos();
    List<Pacientes> buscarLikeNombre(String nombre);
    List<Pacientes> buscarLikeCurp(String curp);
    Pacientes buscarPorId(Long id);
    void guardar(Pacientes paciente);
    void actualizar(Pacientes paciente);
}
