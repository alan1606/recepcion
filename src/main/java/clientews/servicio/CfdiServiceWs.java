
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
@WebService(name = "CfdiServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CfdiServiceWs {


    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Cfdi>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarCfdis", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarCfdis")
    @ResponseWrapper(localName = "listarCfdisResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarCfdisResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/CfdiServiceWs/listarCfdisRequest", output = "http://servicio.sga.gm.com.mx/CfdiServiceWs/listarCfdisResponse")
    public List<Cfdi> listarCfdis();

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Cfdi
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerCfdiPorClave", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerCfdiPorClave")
    @ResponseWrapper(localName = "obtenerCfdiPorClaveResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerCfdiPorClaveResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/CfdiServiceWs/obtenerCfdiPorClaveRequest", output = "http://servicio.sga.gm.com.mx/CfdiServiceWs/obtenerCfdiPorClaveResponse")
    public Cfdi obtenerCfdiPorClave(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registrarCfdi", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarCfdi")
    @ResponseWrapper(localName = "registrarCfdiResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarCfdiResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/CfdiServiceWs/registrarCfdiRequest", output = "http://servicio.sga.gm.com.mx/CfdiServiceWs/registrarCfdiResponse")
    public void registrarCfdi(
        @WebParam(name = "arg0", targetNamespace = "")
        Cfdi arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "modificarCfdi", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ModificarCfdi")
    @ResponseWrapper(localName = "modificarCfdiResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ModificarCfdiResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/CfdiServiceWs/modificarCfdiRequest", output = "http://servicio.sga.gm.com.mx/CfdiServiceWs/modificarCfdiResponse")
    public void modificarCfdi(
        @WebParam(name = "arg0", targetNamespace = "")
        Cfdi arg0);

}
