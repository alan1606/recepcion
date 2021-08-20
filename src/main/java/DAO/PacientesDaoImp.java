/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.PacienteServiceImplService;
import clientews.servicio.PacienteServiceWs;
import clientews.servicio.Pacientes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class PacientesDaoImp implements PacientesDao {

    private PacienteServiceWs servicio = null;

    public PacientesDaoImp() {
        if (servicio == null) {
            servicio = new PacienteServiceImplService().getPacienteServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public List<Pacientes> buscarLikeNombre(String nombre) {

        return servicio.encontrarPacienteLikeNombre(nombre);
    }

    @Override
    public List<Pacientes> buscarLikeCurp(String curp) {
        return servicio.encontrarPacienteLikeCurp(curp);
    }

    @Override
    public Pacientes buscarPorId(Long id) {
        Pacientes paciente = new Pacientes();
        paciente.setIdP(id);
        return servicio.encontrarPacientePorId(paciente);
    }

    @Override
    public void guardar(Pacientes paciente) {
        servicio.registrarPaciente(paciente);
    }

    @Override
    public void actualizar(Pacientes paciente) {
        servicio.actualizarPaciente(paciente);
    }

}
