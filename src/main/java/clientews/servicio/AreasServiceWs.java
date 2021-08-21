
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
@WebService(name = "AreasServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AreasServiceWs {


    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Areas>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarTodasAreas", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarTodasAreas")
    @ResponseWrapper(localName = "listarTodasAreasResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarTodasAreasResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/AreasServiceWs/listarTodasAreasRequest", output = "http://servicio.sga.gm.com.mx/AreasServiceWs/listarTodasAreasResponse")
    public List<Areas> listarTodasAreas();

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Areas
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarPorId", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarPorId")
    @ResponseWrapper(localName = "listarPorIdResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarPorIdResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/AreasServiceWs/listarPorIdRequest", output = "http://servicio.sga.gm.com.mx/AreasServiceWs/listarPorIdResponse")
    public Areas listarPorId(
        @WebParam(name = "arg0", targetNamespace = "")
        Areas arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Areas
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerAreaPorNombre", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerAreaPorNombre")
    @ResponseWrapper(localName = "obtenerAreaPorNombreResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerAreaPorNombreResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/AreasServiceWs/obtenerAreaPorNombreRequest", output = "http://servicio.sga.gm.com.mx/AreasServiceWs/obtenerAreaPorNombreResponse")
    public Areas obtenerAreaPorNombre(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Areas>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerAreasPorInstitucion", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerAreasPorInstitucion")
    @ResponseWrapper(localName = "obtenerAreasPorInstitucionResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerAreasPorInstitucionResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/AreasServiceWs/obtenerAreasPorInstitucionRequest", output = "http://servicio.sga.gm.com.mx/AreasServiceWs/obtenerAreasPorInstitucionResponse")
    public List<Areas> obtenerAreasPorInstitucion(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

}
