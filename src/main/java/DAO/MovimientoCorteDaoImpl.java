/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.MovimientoCorte;
import clientews.servicio.MovimientoCorteServiceImplService;
import clientews.servicio.MovimientoCorteServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class MovimientoCorteDaoImpl implements MovimientoCorteDao{

    private MovimientoCorteServiceWs servicio = null;

    public MovimientoCorteDaoImpl() {
        if(servicio == null){
            servicio = new MovimientoCorteServiceImplService().getMovimientoCorteServiceImplPort();
                    ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }
    
    
    
    @Override
    public List<MovimientoCorte> obtenerMovimientosDeCorteMatutino(String fecha) {
        return servicio.obtenerMovimientosDeCorteMatutino(fecha);
    }

    @Override
    public List<MovimientoCorte> obtenerMovimientosDeCorteVespertino(String fecha) {
        return servicio.obtenerMovimientosDeCorteVespertino(fecha);
    }

    @Override
    public void registrarMovimientoCorte(MovimientoCorte movimiento) {
        servicio.registrarMovimientoCorte(movimiento);
    }
    
}
