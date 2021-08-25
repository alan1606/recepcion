/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Institucion;
import clientews.servicio.Pacientes;
import clientews.servicio.VentaConceptos;
import clientews.servicio.VentaConceptosServiceImplService;
import clientews.servicio.VentaConceptosServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class VentaConceptosDaoImp implements VentaConceptosDao{

    private VentaConceptosServiceWs servicio = null;

    public VentaConceptosDaoImp() {
        if (servicio == null) {
            servicio = new VentaConceptosServiceImplService().getVentaConceptosServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }
    
    
    @Override
    public List<VentaConceptos> findAllVentaConceptos() {
        return servicio.listarTodosVentaConceptos();
    }

    @Override
    public List<VentaConceptos> findVentaConceptosByPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist) {
        return servicio.encontrarVentaConceptosPorPacienteFechaEnWorklist(paciente, fecha, enWorklist);
    }

    @Override
    public List<VentaConceptos> findVentaConceptosByInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin) {
        return servicio.encontrarVentaConceptosPorInstitucionFechas(institucion, fechaFin, fechaFin);
    }

    @Override
    public VentaConceptos findByIdPacs(String idPacs) {
        return servicio.encontrarVentaConceptosPorIdPacs(idPacs);
    }

    @Override
    public void registrarVentaConceptos(VentaConceptos ventaConceptos) {
       // servicio.
    }

    @Override
    public void registrarVentaConceptos(List<VentaConceptos> ventaConceptos) {
       
    }

    @Override
    public boolean actualizarIdOrdenVenta() {
        return servicio.actualizarIdOrdenVenta();
    }

    @Override
    public List<VentaConceptos> findByIdOrdenVenta(Long idOrdenVenta) {
        return servicio.encontarVentaConceptosPorIdOrdenVenta(idOrdenVenta);
    }

    @Override
    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFecha(Integer idArea, Long idEquipoDicom, String fecha) {
        return servicio.encontrarAgendadosPorAreaEquipoDicomFecha(idArea, idEquipoDicom, fecha);
    }

    @Override
    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFechaInstitucion(Integer idArea, Long idEquipoDicom, String fecha, Long idInstitucion) {
        return servicio.encontrarAgendadosPorAreaEquipoDicomFechaInstitucion(idArea, idInstitucion, fecha, idInstitucion);
    }
    
}
