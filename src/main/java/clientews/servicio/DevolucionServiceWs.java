
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
@WebService(name = "DevolucionServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DevolucionServiceWs {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registrarDevolucion", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarDevolucion")
    @ResponseWrapper(localName = "registrarDevolucionResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarDevolucionResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/registrarDevolucionRequest", output = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/registrarDevolucionResponse")
    public void registrarDevolucion(
        @WebParam(name = "arg0", targetNamespace = "")
        Devolucion arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Devolucion>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarDevolucionesPorFecha", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarDevolucionesPorFecha")
    @ResponseWrapper(localName = "buscarDevolucionesPorFechaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarDevolucionesPorFechaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/buscarDevolucionesPorFechaRequest", output = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/buscarDevolucionesPorFechaResponse")
    public List<Devolucion> buscarDevolucionesPorFecha(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Devolucion
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarDevolucionPorId", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarDevolucionPorId")
    @ResponseWrapper(localName = "encontrarDevolucionPorIdResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarDevolucionPorIdResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/encontrarDevolucionPorIdRequest", output = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/encontrarDevolucionPorIdResponse")
    public Devolucion encontrarDevolucionPorId(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Devolucion>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerDevolucionesPorIdOrdenVenta", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerDevolucionesPorIdOrdenVenta")
    @ResponseWrapper(localName = "obtenerDevolucionesPorIdOrdenVentaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerDevolucionesPorIdOrdenVentaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/obtenerDevolucionesPorIdOrdenVentaRequest", output = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/obtenerDevolucionesPorIdOrdenVentaResponse")
    public List<Devolucion> obtenerDevolucionesPorIdOrdenVenta(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Devolucion
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerDevolucionPorIdPagoOrdenVenta", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerDevolucionPorIdPagoOrdenVenta")
    @ResponseWrapper(localName = "obtenerDevolucionPorIdPagoOrdenVentaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerDevolucionPorIdPagoOrdenVentaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/obtenerDevolucionPorIdPagoOrdenVentaRequest", output = "http://servicio.sga.gm.com.mx/DevolucionServiceWs/obtenerDevolucionPorIdPagoOrdenVentaResponse")
    public Devolucion obtenerDevolucionPorIdPagoOrdenVenta(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

}