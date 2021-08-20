
package clientews.servicio;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "OrdenVentaServiceImplService", targetNamespace = "http://servicio.sga.gm.com.mx/", wsdlLocation = "http://localhost:8080/OrdenVentaServiceImplService/OrdenVentaServiceImpl?wsdl")
public class OrdenVentaServiceImplService
    extends Service
{

    private final static URL ORDENVENTASERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException ORDENVENTASERVICEIMPLSERVICE_EXCEPTION;
    private final static QName ORDENVENTASERVICEIMPLSERVICE_QNAME = new QName("http://servicio.sga.gm.com.mx/", "OrdenVentaServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/OrdenVentaServiceImplService/OrdenVentaServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ORDENVENTASERVICEIMPLSERVICE_WSDL_LOCATION = url;
        ORDENVENTASERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public OrdenVentaServiceImplService() {
        super(__getWsdlLocation(), ORDENVENTASERVICEIMPLSERVICE_QNAME);
    }

    public OrdenVentaServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ORDENVENTASERVICEIMPLSERVICE_QNAME, features);
    }

    public OrdenVentaServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, ORDENVENTASERVICEIMPLSERVICE_QNAME);
    }

    public OrdenVentaServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ORDENVENTASERVICEIMPLSERVICE_QNAME, features);
    }

    public OrdenVentaServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrdenVentaServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OrdenVentaServiceWs
     */
    @WebEndpoint(name = "OrdenVentaServiceImplPort")
    public OrdenVentaServiceWs getOrdenVentaServiceImplPort() {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "OrdenVentaServiceImplPort"), OrdenVentaServiceWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrdenVentaServiceWs
     */
    @WebEndpoint(name = "OrdenVentaServiceImplPort")
    public OrdenVentaServiceWs getOrdenVentaServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "OrdenVentaServiceImplPort"), OrdenVentaServiceWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ORDENVENTASERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw ORDENVENTASERVICEIMPLSERVICE_EXCEPTION;
        }
        return ORDENVENTASERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
