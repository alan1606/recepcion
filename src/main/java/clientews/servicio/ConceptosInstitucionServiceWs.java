
package clientews.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ConceptosInstitucionServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConceptosInstitucionServiceWs {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns clientews.servicio.ConceptosInstitucion
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarConceptoInstitucionPorIdConceptoIdInstitucion", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarConceptoInstitucionPorIdConceptoIdInstitucion")
    @ResponseWrapper(localName = "encontrarConceptoInstitucionPorIdConceptoIdInstitucionResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarConceptoInstitucionPorIdConceptoIdInstitucionResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/encontrarConceptoInstitucionPorIdConceptoIdInstitucionRequest", output = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/encontrarConceptoInstitucionPorIdConceptoIdInstitucionResponse")
    public ConceptosInstitucion encontrarConceptoInstitucionPorIdConceptoIdInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Long arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.ConceptosInstitucion>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerConceptosLikeNombrePorPorIdInstitucion", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosLikeNombrePorPorIdInstitucion")
    @ResponseWrapper(localName = "obtenerConceptosLikeNombrePorPorIdInstitucionResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosLikeNombrePorPorIdInstitucionResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosLikeNombrePorPorIdInstitucionRequest", output = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosLikeNombrePorPorIdInstitucionResponse")
    public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Long arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.ConceptosInstitucion>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerConceptosLikeNombrePorPorIdInstitucionPorArea", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosLikeNombrePorPorIdInstitucionPorArea")
    @ResponseWrapper(localName = "obtenerConceptosLikeNombrePorPorIdInstitucionPorAreaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosLikeNombrePorPorIdInstitucionPorAreaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosLikeNombrePorPorIdInstitucionPorAreaRequest", output = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosLikeNombrePorPorIdInstitucionPorAreaResponse")
    public List<ConceptosInstitucion> obtenerConceptosLikeNombrePorPorIdInstitucionPorArea(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Long arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.ConceptosInstitucion>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerConceptosPorPorIdInstitucionPorArea", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosPorPorIdInstitucionPorArea")
    @ResponseWrapper(localName = "obtenerConceptosPorPorIdInstitucionPorAreaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosPorPorIdInstitucionPorAreaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosPorPorIdInstitucionPorAreaRequest", output = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosPorPorIdInstitucionPorAreaResponse")
    public List<ConceptosInstitucion> obtenerConceptosPorPorIdInstitucionPorArea(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.ConceptosInstitucion>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerConceptosInstitucionPorIdInstitucion", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosInstitucionPorIdInstitucion")
    @ResponseWrapper(localName = "obtenerConceptosInstitucionPorIdInstitucionResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerConceptosInstitucionPorIdInstitucionResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosInstitucionPorIdInstitucionRequest", output = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/obtenerConceptosInstitucionPorIdInstitucionResponse")
    public List<ConceptosInstitucion> obtenerConceptosInstitucionPorIdInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registrarConceptosInstitucion", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarConceptosInstitucion")
    @ResponseWrapper(localName = "registrarConceptosInstitucionResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarConceptosInstitucionResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/registrarConceptosInstitucionRequest", output = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/registrarConceptosInstitucionResponse")
    public void registrarConceptosInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        ConceptosInstitucion arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "actualizarConceptosInstitucion", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarConceptosInstitucion")
    @ResponseWrapper(localName = "actualizarConceptosInstitucionResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarConceptosInstitucionResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/actualizarConceptosInstitucionRequest", output = "http://servicio.sga.gm.com.mx/ConceptosInstitucionServiceWs/actualizarConceptosInstitucionResponse")
    public void actualizarConceptosInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        ConceptosInstitucion arg0);

}
