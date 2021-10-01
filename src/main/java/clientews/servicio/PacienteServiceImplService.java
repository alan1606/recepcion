
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
@WebServiceClient(name = "PacienteServiceImplService", targetNamespace = "http://servicio.sga.gm.com.mx/", wsdlLocation = "http://172.17.200.61:8080/PacienteServiceImplService/PacienteServiceImpl?wsdl")
public class PacienteServiceImplService
    extends Service
{

    private final static URL PACIENTESERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException PACIENTESERVICEIMPLSERVICE_EXCEPTION;
    private final static QName PACIENTESERVICEIMPLSERVICE_QNAME = new QName("http://servicio.sga.gm.com.mx/", "PacienteServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://172.17.200.61:8080/PacienteServiceImplService/PacienteServiceImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PACIENTESERVICEIMPLSERVICE_WSDL_LOCATION = url;
        PACIENTESERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public PacienteServiceImplService() {
        super(__getWsdlLocation(), PACIENTESERVICEIMPLSERVICE_QNAME);
    }

    public PacienteServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PACIENTESERVICEIMPLSERVICE_QNAME, features);
    }

    public PacienteServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, PACIENTESERVICEIMPLSERVICE_QNAME);
    }

    public PacienteServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PACIENTESERVICEIMPLSERVICE_QNAME, features);
    }

    public PacienteServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PacienteServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PacienteServiceWs
     */
    @WebEndpoint(name = "PacienteServiceImplPort")
    public PacienteServiceWs getPacienteServiceImplPort() {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "PacienteServiceImplPort"), PacienteServiceWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PacienteServiceWs
     */
    @WebEndpoint(name = "PacienteServiceImplPort")
    public PacienteServiceWs getPacienteServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "PacienteServiceImplPort"), PacienteServiceWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PACIENTESERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw PACIENTESERVICEIMPLSERVICE_EXCEPTION;
        }
        return PACIENTESERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
