/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.OrdenVenta;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface OrdenVentaDao {

    public OrdenVenta obtenerOrdenVentaPorId(Long idOrdenVenta);
    
    public OrdenVenta encontrarUltimno();

    public void registrar(OrdenVenta orden);

    public List<OrdenVenta> obtenerNoPagadosEnFecha(String date);

    public List<OrdenVenta> obtenerNoPagadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerNoPagadosPaciente(String idPaciente);

    public List<OrdenVenta> obtenerConfirmadosEnFecha(String date);

    public List<OrdenVenta> obtenerConfirmadosFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerConfirmadosPaciente(Long idPaciente);

    public void actualizar(OrdenVenta orden);
        public void actualizarTotalOrdenVenta(OrdenVenta ordenVenta);
            public Long obtenerTotalOrdenesEnUnDia(String fecha);

                 public List<OrdenVenta> obtenerOrdenVentaConfirmadasPagadasEnFecha(String date);

    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPagadasFechaPaciente(String date, Long idPaciente);

    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPagadasPaciente(Long idPaciente);

}
