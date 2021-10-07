
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
@WebService(name = "MexicoServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MexicoServiceWs {


    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Mexico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarEstadosDeMexico", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEstadosDeMexico")
    @ResponseWrapper(localName = "encontrarEstadosDeMexicoResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEstadosDeMexicoResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MexicoServiceWs/encontrarEstadosDeMexicoRequest", output = "http://servicio.sga.gm.com.mx/MexicoServiceWs/encontrarEstadosDeMexicoResponse")
    public List<Mexico> encontrarEstadosDeMexico();

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Mexico
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarEstadoPorId", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEstadoPorId")
    @ResponseWrapper(localName = "encontrarEstadoPorIdResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEstadoPorIdResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MexicoServiceWs/encontrarEstadoPorIdRequest", output = "http://servicio.sga.gm.com.mx/MexicoServiceWs/encontrarEstadoPorIdResponse")
    public Mexico encontrarEstadoPorId(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Mexico
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarEstadoPorNombre", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEstadoPorNombre")
    @ResponseWrapper(localName = "encontrarEstadoPorNombreResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEstadoPorNombreResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MexicoServiceWs/encontrarEstadoPorNombreRequest", output = "http://servicio.sga.gm.com.mx/MexicoServiceWs/encontrarEstadoPorNombreResponse")
    public Mexico encontrarEstadoPorNombre(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
