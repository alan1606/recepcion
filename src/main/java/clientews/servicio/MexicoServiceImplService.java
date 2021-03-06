
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
@WebServiceClient(name = "MexicoServiceImplService", targetNamespace = "http://servicio.sga.gm.com.mx/", wsdlLocation = "http://201.116.155.166:9999/MexicoServiceImplService/MexicoServiceImpl?wsdl")
public class MexicoServiceImplService
    extends Service
{

    private final static URL MEXICOSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MEXICOSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName MEXICOSERVICEIMPLSERVICE_QNAME = new QName("http://servicio.sga.gm.com.mx/", "MexicoServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://201.116.155.166:9999/MexicoServiceImplService/MexicoServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MEXICOSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        MEXICOSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public MexicoServiceImplService() {
        super(__getWsdlLocation(), MEXICOSERVICEIMPLSERVICE_QNAME);
    }

    public MexicoServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MEXICOSERVICEIMPLSERVICE_QNAME, features);
    }

    public MexicoServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, MEXICOSERVICEIMPLSERVICE_QNAME);
    }

    public MexicoServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MEXICOSERVICEIMPLSERVICE_QNAME, features);
    }

    public MexicoServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MexicoServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MexicoServiceWs
     */
    @WebEndpoint(name = "MexicoServiceImplPort")
    public MexicoServiceWs getMexicoServiceImplPort() {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "MexicoServiceImplPort"), MexicoServiceWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MexicoServiceWs
     */
    @WebEndpoint(name = "MexicoServiceImplPort")
    public MexicoServiceWs getMexicoServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "MexicoServiceImplPort"), MexicoServiceWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MEXICOSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw MEXICOSERVICEIMPLSERVICE_EXCEPTION;
        }
        return MEXICOSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
