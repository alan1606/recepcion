/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Medico;
import clientews.servicio.MedicoServiceImplService;
import clientews.servicio.MedicoServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class MedicoDaoImpl implements MedicoDao {

    private MedicoServiceWs servicio;

    public MedicoDaoImpl() {
        if (servicio == null) {
            servicio = new MedicoServiceImplService().getMedicoServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public void registrarMedico(Medico medico) {
        servicio.registrarMedico(medico);
    }

    @Override
    public void eliminarMedico(Medico medico) {
        servicio.eliminarMedico(medico);
    }

    @Override
    public Medico buscarMedicoPorId(Integer idMedico) {
       return servicio.buscarMedicoPorId(idMedico);
    }

    @Override
    public List<Medico> obtenerTodosLosMedicos() {
        return servicio.obtenerTodosLosMedicos();
    }

    @Override
    public List<Medico> obtenerMedicosReferentes() {
        return servicio.obtenerMedicosReferentes();
    }

    @Override
    public List<Medico> obtenerMedicosRadiologos() {
        return servicio.obtenerMedicosRadiologos();
    }

    @Override
    public List<Medico> buscarMedicosPorNombre(String nombre) {
        return servicio.buscarMedicosPorNombre(nombre);
    }

    @Override
    public List<Medico> buscarMedicoPorEspecialidad(String especialidad) {
        return servicio.buscarMedicoPorEspecialidad(especialidad);
    }

    @Override
    public List<Medico> buscarMedicoPorTelefono(String telefono) {
        return servicio.buscarMedicoPorTelefono(telefono);
    }

    @Override
    public List<Medico> buscarMedicoPorCorreo(String correo) {
        return servicio.buscarMedicoPorCorreo(correo);
    }

    @Override
    public void actualizarMedico(Medico medico) {
        servicio.actualizarMedico(medico);
    }

    @Override
    public List<Medico> buscarReferentesLikeNombre(String nombre) {
        return servicio.buscarRerefenteLikeNombre(nombre);
    }

}
