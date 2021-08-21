
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

    private final static QName _Conceptos_QNAME = new QName("http://servicio.sga.gm.com.mx/", "conceptos");
    private final static QName _ConceptosInstitucion_QNAME = new QName("http://servicio.sga.gm.com.mx/", "conceptosInstitucion");
    private final static QName _ActualizarConceptosInstitucion_QNAME = new QName("http://servicio.sga.gm.com.mx/", "actualizarConceptosInstitucion");
    private final static QName _RegistrarConceptosInstitucion_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarConceptosInstitucion");
    private final static QName _Areas_QNAME = new QName("http://servicio.sga.gm.com.mx/", "areas");
    private final static QName _RegistrarConceptosInstitucionResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarConceptosInstitucionResponse");
    private final static QName _ActualizarConceptosInstitucionResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "actualizarConceptosInstitucionResponse");
    private final static QName _Institucion_QNAME = new QName("http://servicio.sga.gm.com.mx/", "institucion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActualizarConceptosInstitucion }
     * 
     */
    public ActualizarConceptosInstitucion createActualizarConceptosInstitucion() {
        return new ActualizarConceptosInstitucion();
    }

    /**
     * Create an instance of {@link ConceptosInstitucion }
     * 
     */
    public ConceptosInstitucion createConceptosInstitucion() {
        return new ConceptosInstitucion();
    }

    /**
     * Create an instance of {@link Conceptos }
     * 
     */
    public Conceptos createConceptos() {
        return new Conceptos();
    }

    /**
     * Create an instance of {@link Institucion }
     * 
     */
    public Institucion createInstitucion() {
        return new Institucion();
    }

    /**
     * Create an instance of {@link ActualizarConceptosInstitucionResponse }
     * 
     */
    public ActualizarConceptosInstitucionResponse createActualizarConceptosInstitucionResponse() {
        return new ActualizarConceptosInstitucionResponse();
    }

    /**
     * Create an instance of {@link Areas }
     * 
     */
    public Areas createAreas() {
        return new Areas();
    }

    /**
     * Create an instance of {@link RegistrarConceptosInstitucionResponse }
     * 
     */
    public RegistrarConceptosInstitucionResponse createRegistrarConceptosInstitucionResponse() {
        return new RegistrarConceptosInstitucionResponse();
    }

    /**
     * Create an instance of {@link RegistrarConceptosInstitucion }
     * 
     */
    public RegistrarConceptosInstitucion createRegistrarConceptosInstitucion() {
        return new RegistrarConceptosInstitucion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Conceptos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "conceptos")
    public JAXBElement<Conceptos> createConceptos(Conceptos value) {
        return new JAXBElement<Conceptos>(_Conceptos_QNAME, Conceptos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConceptosInstitucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "conceptosInstitucion")
    public JAXBElement<ConceptosInstitucion> createConceptosInstitucion(ConceptosInstitucion value) {
        return new JAXBElement<ConceptosInstitucion>(_ConceptosInstitucion_QNAME, ConceptosInstitucion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarConceptosInstitucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "actualizarConceptosInstitucion")
    public JAXBElement<ActualizarConceptosInstitucion> createActualizarConceptosInstitucion(ActualizarConceptosInstitucion value) {
        return new JAXBElement<ActualizarConceptosInstitucion>(_ActualizarConceptosInstitucion_QNAME, ActualizarConceptosInstitucion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarConceptosInstitucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarConceptosInstitucion")
    public JAXBElement<RegistrarConceptosInstitucion> createRegistrarConceptosInstitucion(RegistrarConceptosInstitucion value) {
        return new JAXBElement<RegistrarConceptosInstitucion>(_RegistrarConceptosInstitucion_QNAME, RegistrarConceptosInstitucion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Areas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "areas")
    public JAXBElement<Areas> createAreas(Areas value) {
        return new JAXBElement<Areas>(_Areas_QNAME, Areas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarConceptosInstitucionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarConceptosInstitucionResponse")
    public JAXBElement<RegistrarConceptosInstitucionResponse> createRegistrarConceptosInstitucionResponse(RegistrarConceptosInstitucionResponse value) {
        return new JAXBElement<RegistrarConceptosInstitucionResponse>(_RegistrarConceptosInstitucionResponse_QNAME, RegistrarConceptosInstitucionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarConceptosInstitucionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "actualizarConceptosInstitucionResponse")
    public JAXBElement<ActualizarConceptosInstitucionResponse> createActualizarConceptosInstitucionResponse(ActualizarConceptosInstitucionResponse value) {
        return new JAXBElement<ActualizarConceptosInstitucionResponse>(_ActualizarConceptosInstitucionResponse_QNAME, ActualizarConceptosInstitucionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Institucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "institucion")
    public JAXBElement<Institucion> createInstitucion(Institucion value) {
        return new JAXBElement<Institucion>(_Institucion_QNAME, Institucion.class, null, value);
    }

}
