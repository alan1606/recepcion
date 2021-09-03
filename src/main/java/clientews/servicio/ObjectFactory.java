
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

    private final static QName _EncontrarEstadosDeMexicoResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarEstadosDeMexicoResponse");
    private final static QName _EncontrarEstadosDeMexico_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarEstadosDeMexico");
    private final static QName _Mexico_QNAME = new QName("http://servicio.sga.gm.com.mx/", "mexico");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Mexico }
     * 
     */
    public Mexico createMexico() {
        return new Mexico();
    }

    /**
     * Create an instance of {@link EncontrarEstadosDeMexico }
     * 
     */
    public EncontrarEstadosDeMexico createEncontrarEstadosDeMexico() {
        return new EncontrarEstadosDeMexico();
    }

    /**
     * Create an instance of {@link EncontrarEstadosDeMexicoResponse }
     * 
     */
    public EncontrarEstadosDeMexicoResponse createEncontrarEstadosDeMexicoResponse() {
        return new EncontrarEstadosDeMexicoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarEstadosDeMexicoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarEstadosDeMexicoResponse")
    public JAXBElement<EncontrarEstadosDeMexicoResponse> createEncontrarEstadosDeMexicoResponse(EncontrarEstadosDeMexicoResponse value) {
        return new JAXBElement<EncontrarEstadosDeMexicoResponse>(_EncontrarEstadosDeMexicoResponse_QNAME, EncontrarEstadosDeMexicoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarEstadosDeMexico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarEstadosDeMexico")
    public JAXBElement<EncontrarEstadosDeMexico> createEncontrarEstadosDeMexico(EncontrarEstadosDeMexico value) {
        return new JAXBElement<EncontrarEstadosDeMexico>(_EncontrarEstadosDeMexico_QNAME, EncontrarEstadosDeMexico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mexico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "mexico")
    public JAXBElement<Mexico> createMexico(Mexico value) {
        return new JAXBElement<Mexico>(_Mexico_QNAME, Mexico.class, null, value);
    }

}
