/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.OrdenVenta;
import clientews.servicio.OrdenVentaServiceImplService;
import clientews.servicio.OrdenVentaServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class OrdenVentaDaoImp implements OrdenVentaDao {

    private OrdenVentaServiceWs servicio = null;

    public OrdenVentaDaoImp() {
        if (servicio == null) {
            servicio = new OrdenVentaServiceImplService().getOrdenVentaServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public OrdenVenta encontrarUltimno() {
        return servicio.obtenerUltimaOrdenVentaRegistrada();
        
    }

    @Override
    public void registrar(OrdenVenta orden) {
        servicio.registrarOrdenVenta(orden);
    }

    @Override
    public List<OrdenVenta> obtenerNoPagadosEnFecha(String date) {
        return servicio.obtenerOrdenVentaNoPagadosEnFecha(date);
    }

    @Override
    public List<OrdenVenta> obtenerNoPagadosFechaPaciente(String date, Long idPaciente) {
        return servicio.obtenerOrdenVentaNoPagadosFechaPaciente(date, idPaciente);
    }

    @Override
    public List<OrdenVenta> obtenerNoPagadosPaciente(String idPaciente) {
        return servicio.obtenerOrdenVentaNoPagadosPaciente(idPaciente);
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosEnFecha(String date) {
        return servicio.obtenerOrdenVentaConfirmadasEnFecha(date);
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosFechaPaciente(String date, Long idPaciente) {
       return servicio.obtenerOrdenVentaConfirmadasFechaPaciente(date, idPaciente);
    }

    @Override
    public List<OrdenVenta> obtenerConfirmadosPaciente(Long idPaciente) {
        return servicio.obtenerOrdenVentaConfirmadasPaciente(idPaciente);
    }

    @Override
    public OrdenVenta obtenerOrdenVentaPorId(Long idOrdenVenta) {
        return servicio.obtenerOrdenVentaPorId(idOrdenVenta);
    }

    @Override
    public void actualizar(OrdenVenta orden) {
         servicio.actualizarOrdenVenta(orden);
    }

    @Override
    public void actualizarTotalOrdenVenta(OrdenVenta ordenVenta) {
        servicio.actualizarTotalOrdenVenta(ordenVenta);
    }

    @Override
    public Long obtenerTotalOrdenesEnUnDia(String fecha) {
        return  servicio.obtenerTotalOrdenesEnUnDia(fecha);
    }
    
    

}
