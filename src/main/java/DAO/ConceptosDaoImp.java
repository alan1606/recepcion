/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clientews.servicio.Conceptos;
import clientews.servicio.ConceptosServiceImplService;
import clientews.servicio.ConceptosServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author alanm
 */
public class ConceptosDaoImp implements ConceptosDao{
    
    private ConceptosServiceWs servicio =  null;

    public ConceptosDaoImp() {
        if (servicio == null) {
            servicio = new ConceptosServiceImplService().getConceptosServiceImplPort();
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, LoginData.user);
            ((BindingProvider) servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, LoginData.password);
        }
    }

    @Override
    public Conceptos encontrarConceptoPorId(Conceptos conceptos) {
        return servicio.encontrarConceptoPorId(conceptos);
    }

    @Override
    public List<Conceptos> encontrarConceptosPorIdVentaConceptos(Long idVentaConceptos) {
        return servicio.encontrarConceptosPorIdVentaConceptos(idVentaConceptos);
    }

    @Override
    public List<Conceptos> encontrarConceptosPorIdArea(Integer idArea) {
        return servicio.encontrarConceptosPorIdArea(idArea);
    }

    @Override
    public List<Conceptos> encontrarConceptosPorAreaInstitucion(Long idInstitucion, Integer idArea) {
        return servicio.encontrarConceptosPorInstitucionArea(idInstitucion, idArea);
    }

    @Override
    public Conceptos encontrarConceptoPorNombre(String nombre) {
        return servicio.encontrarConceptoPorNombre(nombre);
    }
    
    
    
}
