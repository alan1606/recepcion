/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.MovimientoCorte;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface MovimientoCorteDao {
    public List<MovimientoCorte> obtenerMovimientosDeCorteMatutino(String fecha);

    public List<MovimientoCorte> obtenerMovimientosDeCorteVespertino(String fecha);

    public void registrarMovimientoCorte(MovimientoCorte movimiento);
}
