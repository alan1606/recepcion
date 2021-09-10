/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.CatalogoFormaPago;
import java.util.List;

/**
 *
 * @author alanm
 */
public interface CatalogoFormaPagoDao {
    public List<CatalogoFormaPago> obtenerFormasDePago();
}
