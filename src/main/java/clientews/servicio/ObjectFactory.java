
package clientews.servicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientews.servicio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistrarOrdenVenta_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarOrdenVenta");
    private final static QName _ObtenerOrdenVentaNoPagadosEnFechaResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerOrdenVentaNoPagadosEnFechaResponse");
    private final static QName _CatalogoFormaPago_QNAME = new QName("http://servicio.sga.gm.com.mx/", "catalogoFormaPago");
    private final static QName _RegistrarOrdenVentaResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarOrdenVentaResponse");
    private final static QName _ObtenerOrdenVentaNoPagadosFechaPacienteResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerOrdenVentaNoPagadosFechaPacienteResponse");
    private final static QName _ObtenerOrdenVentaNoPagadosPacienteResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerOrdenVentaNoPagadosPacienteResponse");
    private final static QName _OrdenVenta_QNAME = new QName("http://servicio.sga.gm.com.mx/", "ordenVenta");
    private final static QName _ObtenerOrdenVentaNoPagadosEnFecha_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerOrdenVentaNoPagadosEnFecha");
    private final static QName _ObtenerOrdenVentaNoPagadosFechaPaciente_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerOrdenVentaNoPagadosFechaPaciente");
    private final static QName _ObtenerOrdenVentaNoPagadosPaciente_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerOrdenVentaNoPagadosPaciente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerOrdenVentaNoPagadosFechaPacienteResponse }
     * 
     */
    public ObtenerOrdenVentaNoPagadosFechaPacienteResponse createObtenerOrdenVentaNoPagadosFechaPacienteResponse() {
        return new ObtenerOrdenVentaNoPagadosFechaPacienteResponse();
    }

    /**
     * Create an instance of {@link ObtenerOrdenVentaNoPagadosPacienteResponse }
     * 
     */
    public ObtenerOrdenVentaNoPagadosPacienteResponse createObtenerOrdenVentaNoPagadosPacienteResponse() {
        return new ObtenerOrdenVentaNoPagadosPacienteResponse();
    }

    /**
     * Create an instance of {@link CatalogoFormaPago }
     * 
     */
    public CatalogoFormaPago createCatalogoFormaPago() {
        return new CatalogoFormaPago();
    }

    /**
     * Create an instance of {@link RegistrarOrdenVentaResponse }
     * 
     */
    public RegistrarOrdenVentaResponse createRegistrarOrdenVentaResponse() {
        return new RegistrarOrdenVentaResponse();
    }

    /**
     * Create an instance of {@link ObtenerOrdenVentaNoPagadosEnFechaResponse }
     * 
     */
    public ObtenerOrdenVentaNoPagadosEnFechaResponse createObtenerOrdenVentaNoPagadosEnFechaResponse() {
        return new ObtenerOrdenVentaNoPagadosEnFechaResponse();
    }

    /**
     * Create an instance of {@link RegistrarOrdenVenta }
     * 
     */
    public RegistrarOrdenVenta createRegistrarOrdenVenta() {
        return new RegistrarOrdenVenta();
    }

    /**
     * Create an instance of {@link ObtenerOrdenVentaNoPagadosPaciente }
     * 
     */
    public ObtenerOrdenVentaNoPagadosPaciente createObtenerOrdenVentaNoPagadosPaciente() {
        return new ObtenerOrdenVentaNoPagadosPaciente();
    }

    /**
     * Create an instance of {@link ObtenerOrdenVentaNoPagadosEnFecha }
     * 
     */
    public ObtenerOrdenVentaNoPagadosEnFecha createObtenerOrdenVentaNoPagadosEnFecha() {
        return new ObtenerOrdenVentaNoPagadosEnFecha();
    }

    /**
     * Create an instance of {@link ObtenerOrdenVentaNoPagadosFechaPaciente }
     * 
     */
    public ObtenerOrdenVentaNoPagadosFechaPaciente createObtenerOrdenVentaNoPagadosFechaPaciente() {
        return new ObtenerOrdenVentaNoPagadosFechaPaciente();
    }

    /**
     * Create an instance of {@link OrdenVenta }
     * 
     */
    public OrdenVenta createOrdenVenta() {
        return new OrdenVenta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarOrdenVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarOrdenVenta")
    public JAXBElement<RegistrarOrdenVenta> createRegistrarOrdenVenta(RegistrarOrdenVenta value) {
        return new JAXBElement<RegistrarOrdenVenta>(_RegistrarOrdenVenta_QNAME, RegistrarOrdenVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenVentaNoPagadosEnFechaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerOrdenVentaNoPagadosEnFechaResponse")
    public JAXBElement<ObtenerOrdenVentaNoPagadosEnFechaResponse> createObtenerOrdenVentaNoPagadosEnFechaResponse(ObtenerOrdenVentaNoPagadosEnFechaResponse value) {
        return new JAXBElement<ObtenerOrdenVentaNoPagadosEnFechaResponse>(_ObtenerOrdenVentaNoPagadosEnFechaResponse_QNAME, ObtenerOrdenVentaNoPagadosEnFechaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoFormaPago }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "catalogoFormaPago")
    public JAXBElement<CatalogoFormaPago> createCatalogoFormaPago(CatalogoFormaPago value) {
        return new JAXBElement<CatalogoFormaPago>(_CatalogoFormaPago_QNAME, CatalogoFormaPago.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarOrdenVentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarOrdenVentaResponse")
    public JAXBElement<RegistrarOrdenVentaResponse> createRegistrarOrdenVentaResponse(RegistrarOrdenVentaResponse value) {
        return new JAXBElement<RegistrarOrdenVentaResponse>(_RegistrarOrdenVentaResponse_QNAME, RegistrarOrdenVentaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenVentaNoPagadosFechaPacienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerOrdenVentaNoPagadosFechaPacienteResponse")
    public JAXBElement<ObtenerOrdenVentaNoPagadosFechaPacienteResponse> createObtenerOrdenVentaNoPagadosFechaPacienteResponse(ObtenerOrdenVentaNoPagadosFechaPacienteResponse value) {
        return new JAXBElement<ObtenerOrdenVentaNoPagadosFechaPacienteResponse>(_ObtenerOrdenVentaNoPagadosFechaPacienteResponse_QNAME, ObtenerOrdenVentaNoPagadosFechaPacienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenVentaNoPagadosPacienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerOrdenVentaNoPagadosPacienteResponse")
    public JAXBElement<ObtenerOrdenVentaNoPagadosPacienteResponse> createObtenerOrdenVentaNoPagadosPacienteResponse(ObtenerOrdenVentaNoPagadosPacienteResponse value) {
        return new JAXBElement<ObtenerOrdenVentaNoPagadosPacienteResponse>(_ObtenerOrdenVentaNoPagadosPacienteResponse_QNAME, ObtenerOrdenVentaNoPagadosPacienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrdenVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "ordenVenta")
    public JAXBElement<OrdenVenta> createOrdenVenta(OrdenVenta value) {
        return new JAXBElement<OrdenVenta>(_OrdenVenta_QNAME, OrdenVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenVentaNoPagadosEnFecha }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerOrdenVentaNoPagadosEnFecha")
    public JAXBElement<ObtenerOrdenVentaNoPagadosEnFecha> createObtenerOrdenVentaNoPagadosEnFecha(ObtenerOrdenVentaNoPagadosEnFecha value) {
        return new JAXBElement<ObtenerOrdenVentaNoPagadosEnFecha>(_ObtenerOrdenVentaNoPagadosEnFecha_QNAME, ObtenerOrdenVentaNoPagadosEnFecha.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenVentaNoPagadosFechaPaciente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerOrdenVentaNoPagadosFechaPaciente")
    public JAXBElement<ObtenerOrdenVentaNoPagadosFechaPaciente> createObtenerOrdenVentaNoPagadosFechaPaciente(ObtenerOrdenVentaNoPagadosFechaPaciente value) {
        return new JAXBElement<ObtenerOrdenVentaNoPagadosFechaPaciente>(_ObtenerOrdenVentaNoPagadosFechaPaciente_QNAME, ObtenerOrdenVentaNoPagadosFechaPaciente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenVentaNoPagadosPaciente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerOrdenVentaNoPagadosPaciente")
    public JAXBElement<ObtenerOrdenVentaNoPagadosPaciente> createObtenerOrdenVentaNoPagadosPaciente(ObtenerOrdenVentaNoPagadosPaciente value) {
        return new JAXBElement<ObtenerOrdenVentaNoPagadosPaciente>(_ObtenerOrdenVentaNoPagadosPaciente_QNAME, ObtenerOrdenVentaNoPagadosPaciente.class, null, value);
    }

}
