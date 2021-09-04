
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

    private final static QName _RegistrarPagoOrdenVenta_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarPagoOrdenVenta");
    private final static QName _PagoOrdenVenta_QNAME = new QName("http://servicio.sga.gm.com.mx/", "pagoOrdenVenta");
    private final static QName _CatalogoFormaPago_QNAME = new QName("http://servicio.sga.gm.com.mx/", "catalogoFormaPago");
    private final static QName _OrdenVenta_QNAME = new QName("http://servicio.sga.gm.com.mx/", "ordenVenta");
    private final static QName _RegistrarPagoOrdenVentaResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarPagoOrdenVentaResponse");
    private final static QName _Pacientes_QNAME = new QName("http://servicio.sga.gm.com.mx/", "pacientes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CatalogoFormaPago }
     * 
     */
    public CatalogoFormaPago createCatalogoFormaPago() {
        return new CatalogoFormaPago();
    }

    /**
     * Create an instance of {@link PagoOrdenVenta }
     * 
     */
    public PagoOrdenVenta createPagoOrdenVenta() {
        return new PagoOrdenVenta();
    }

    /**
     * Create an instance of {@link RegistrarPagoOrdenVenta }
     * 
     */
    public RegistrarPagoOrdenVenta createRegistrarPagoOrdenVenta() {
        return new RegistrarPagoOrdenVenta();
    }

    /**
     * Create an instance of {@link Pacientes }
     * 
     */
    public Pacientes createPacientes() {
        return new Pacientes();
    }

    /**
     * Create an instance of {@link RegistrarPagoOrdenVentaResponse }
     * 
     */
    public RegistrarPagoOrdenVentaResponse createRegistrarPagoOrdenVentaResponse() {
        return new RegistrarPagoOrdenVentaResponse();
    }

    /**
     * Create an instance of {@link OrdenVenta }
     * 
     */
    public OrdenVenta createOrdenVenta() {
        return new OrdenVenta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarPagoOrdenVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarPagoOrdenVenta")
    public JAXBElement<RegistrarPagoOrdenVenta> createRegistrarPagoOrdenVenta(RegistrarPagoOrdenVenta value) {
        return new JAXBElement<RegistrarPagoOrdenVenta>(_RegistrarPagoOrdenVenta_QNAME, RegistrarPagoOrdenVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagoOrdenVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "pagoOrdenVenta")
    public JAXBElement<PagoOrdenVenta> createPagoOrdenVenta(PagoOrdenVenta value) {
        return new JAXBElement<PagoOrdenVenta>(_PagoOrdenVenta_QNAME, PagoOrdenVenta.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link OrdenVenta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "ordenVenta")
    public JAXBElement<OrdenVenta> createOrdenVenta(OrdenVenta value) {
        return new JAXBElement<OrdenVenta>(_OrdenVenta_QNAME, OrdenVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarPagoOrdenVentaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarPagoOrdenVentaResponse")
    public JAXBElement<RegistrarPagoOrdenVentaResponse> createRegistrarPagoOrdenVentaResponse(RegistrarPagoOrdenVentaResponse value) {
        return new JAXBElement<RegistrarPagoOrdenVentaResponse>(_RegistrarPagoOrdenVentaResponse_QNAME, RegistrarPagoOrdenVentaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pacientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "pacientes")
    public JAXBElement<Pacientes> createPacientes(Pacientes value) {
        return new JAXBElement<Pacientes>(_Pacientes_QNAME, Pacientes.class, null, value);
    }

}
