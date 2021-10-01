
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
@WebService(name = "OrdenVentaServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OrdenVentaServiceWs {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registrarOrdenVenta", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarOrdenVenta")
    @ResponseWrapper(localName = "registrarOrdenVentaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarOrdenVentaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/registrarOrdenVentaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/registrarOrdenVentaResponse")
    public void registrarOrdenVenta(
        @WebParam(name = "arg0", targetNamespace = "")
        OrdenVenta arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.OrdenVenta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerOrdenVentaNoPagadosEnFecha", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaNoPagadosEnFecha")
    @ResponseWrapper(localName = "obtenerOrdenVentaNoPagadosEnFechaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaNoPagadosEnFechaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaNoPagadosEnFechaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaNoPagadosEnFechaResponse")
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosEnFecha(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.OrdenVenta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerOrdenVentaNoPagadosFechaPaciente", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaNoPagadosFechaPaciente")
    @ResponseWrapper(localName = "obtenerOrdenVentaNoPagadosFechaPacienteResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaNoPagadosFechaPacienteResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaNoPagadosFechaPacienteRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaNoPagadosFechaPacienteResponse")
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosFechaPaciente(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Long arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.OrdenVenta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerOrdenVentaNoPagadosPaciente", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaNoPagadosPaciente")
    @ResponseWrapper(localName = "obtenerOrdenVentaNoPagadosPacienteResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaNoPagadosPacienteResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaNoPagadosPacienteRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaNoPagadosPacienteResponse")
    public List<OrdenVenta> obtenerOrdenVentaNoPagadosPaciente(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns clientews.servicio.OrdenVenta
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerUltimaOrdenVentaRegistrada", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerUltimaOrdenVentaRegistrada")
    @ResponseWrapper(localName = "obtenerUltimaOrdenVentaRegistradaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerUltimaOrdenVentaRegistradaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerUltimaOrdenVentaRegistradaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerUltimaOrdenVentaRegistradaResponse")
    public OrdenVenta obtenerUltimaOrdenVentaRegistrada();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.OrdenVenta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerOrdenVentaConfirmadasEnFecha", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaConfirmadasEnFecha")
    @ResponseWrapper(localName = "obtenerOrdenVentaConfirmadasEnFechaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaConfirmadasEnFechaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaConfirmadasEnFechaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaConfirmadasEnFechaResponse")
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasEnFecha(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.OrdenVenta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerOrdenVentaConfirmadasFechaPaciente", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaConfirmadasFechaPaciente")
    @ResponseWrapper(localName = "obtenerOrdenVentaConfirmadasFechaPacienteResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaConfirmadasFechaPacienteResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaConfirmadasFechaPacienteRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaConfirmadasFechaPacienteResponse")
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasFechaPaciente(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Long arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.OrdenVenta>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerOrdenVentaConfirmadasPaciente", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaConfirmadasPaciente")
    @ResponseWrapper(localName = "obtenerOrdenVentaConfirmadasPacienteResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaConfirmadasPacienteResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaConfirmadasPacienteRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaConfirmadasPacienteResponse")
    public List<OrdenVenta> obtenerOrdenVentaConfirmadasPaciente(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.OrdenVenta
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerOrdenVentaPorId", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaPorId")
    @ResponseWrapper(localName = "obtenerOrdenVentaPorIdResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerOrdenVentaPorIdResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaPorIdRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerOrdenVentaPorIdResponse")
    public OrdenVenta obtenerOrdenVentaPorId(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "actualizarOrdenVenta", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarOrdenVenta")
    @ResponseWrapper(localName = "actualizarOrdenVentaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarOrdenVentaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/actualizarOrdenVentaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/actualizarOrdenVentaResponse")
    public void actualizarOrdenVenta(
        @WebParam(name = "arg0", targetNamespace = "")
        OrdenVenta arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerTotalDeVenta", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerTotalDeVenta")
    @ResponseWrapper(localName = "obtenerTotalDeVentaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerTotalDeVentaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerTotalDeVentaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerTotalDeVentaResponse")
    public double obtenerTotalDeVenta(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "actualizarTotalOrdenVenta", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarTotalOrdenVenta")
    @ResponseWrapper(localName = "actualizarTotalOrdenVentaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarTotalOrdenVentaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/actualizarTotalOrdenVentaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/actualizarTotalOrdenVentaResponse")
    public void actualizarTotalOrdenVenta(
        @WebParam(name = "arg0", targetNamespace = "")
        OrdenVenta arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Long
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerTotalOrdenesEnUnDia", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerTotalOrdenesEnUnDia")
    @ResponseWrapper(localName = "obtenerTotalOrdenesEnUnDiaResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerTotalOrdenesEnUnDiaResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerTotalOrdenesEnUnDiaRequest", output = "http://servicio.sga.gm.com.mx/OrdenVentaServiceWs/obtenerTotalOrdenesEnUnDiaResponse")
    public Long obtenerTotalOrdenesEnUnDia(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
