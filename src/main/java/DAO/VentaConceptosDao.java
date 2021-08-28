/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Conceptos;
import clientews.servicio.Institucion;
import clientews.servicio.OrdenVenta;
import clientews.servicio.Pacientes;
import clientews.servicio.VentaConceptos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface VentaConceptosDao {
    public VentaConceptos findById(Long id);
    
    public List<VentaConceptos> findAllVentaConceptos();

    public List<VentaConceptos> findVentaConceptosByPacienteFechaEnWorklist(Pacientes paciente, String fecha, boolean enWorklist);

    public List<VentaConceptos> findVentaConceptosByInstitucionFechas(Institucion institucion, String fechaInicio, String fechaFin);

    public VentaConceptos findByIdPacs(String idPacs);

    public void registrarVentaConceptos(VentaConceptos ventaConceptos);

    public void registrarVentaConceptos(List<VentaConceptos> ventaConceptos);

    public boolean actualizarIdOrdenVenta();

    public List<VentaConceptos> findByIdOrdenVenta(Long idOrdenVenta);

    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFecha(Integer idArea, Long idEquipoDicom, String fecha);

    public List<VentaConceptos> findAgendadosByAreaEquipoDicomFechaInstitucion(Integer idArea, Long idEquipoDicom, String fecha, Long idInstitucion);

    public VentaConceptos encontrarVentaConceptoPorOrdenVentaConceptoHoraAsignado(OrdenVenta ordenVenta, Conceptos conceptos, String horaAsingnado);

    public void eliminarVentaConceptos(VentaConceptos venta);
    
}
