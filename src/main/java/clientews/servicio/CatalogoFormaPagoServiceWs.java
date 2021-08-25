
package clientews.servicio;

import java.util.List;
import javax.jws.WebMethod;
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
@WebService(name = "CatalogoFormaPagoServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CatalogoFormaPagoServiceWs {


    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.CatalogoFormaPago>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarTodasFormasPago", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarTodasFormasPago")
    @ResponseWrapper(localName = "listarTodasFormasPagoResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarTodasFormasPagoResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/CatalogoFormaPagoServiceWs/listarTodasFormasPagoRequest", output = "http://servicio.sga.gm.com.mx/CatalogoFormaPagoServiceWs/listarTodasFormasPagoResponse")
    public List<CatalogoFormaPago> listarTodasFormasPago();

}
