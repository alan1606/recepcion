
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
    private final static QName _EncontrarPacientePorIdResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarPacientePorIdResponse");
    private final static QName _CatalogoFormaPago_QNAME = new QName("http://servicio.sga.gm.com.mx/", "catalogoFormaPago");
    private final static QName _EncontrarEnVentaConceptos_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarEnVentaConceptos");
    private final static QName _EncontrarPacientePorCurpResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarPacientePorCurpResponse");
    private final static QName _OrdenVenta_QNAME = new QName("http://servicio.sga.gm.com.mx/", "ordenVenta");
    private final static QName _Pacientes_QNAME = new QName("http://servicio.sga.gm.com.mx/", "pacientes");
    private final static QName _ListarTodoResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "listarTodoResponse");
    private final static QName _EncontrarEnVentaConceptosResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarEnVentaConceptosResponse");
    private final static QName _EquipoDicom_QNAME = new QName("http://servicio.sga.gm.com.mx/", "equipoDicom");
    private final static QName _EncontrarPacientePorId_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarPacientePorId");
    private final static QName _VentaConceptos_QNAME = new QName("http://servicio.sga.gm.com.mx/", "ventaConceptos");
    private final static QName _ListarTodo_QNAME = new QName("http://servicio.sga.gm.com.mx/", "listarTodo");
    private final static QName _EncontrarPacientePorCurp_QNAME = new QName("http://servicio.sga.gm.com.mx/", "encontrarPacientePorCurp");
    private final static QName _Areas_QNAME = new QName("http://servicio.sga.gm.com.mx/", "areas");
    private final static QName _Institucion_QNAME = new QName("http://servicio.sga.gm.com.mx/", "institucion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VentaConceptos }
     * 
     */
    public VentaConceptos createVentaConceptos() {
        return new VentaConceptos();
    }

    /**
     * Create an instance of {@link EncontrarPacientePorId }
     * 
     */
    public EncontrarPacientePorId createEncontrarPacientePorId() {
        return new EncontrarPacientePorId();
    }

    /**
     * Create an instance of {@link EncontrarEnVentaConceptosResponse }
     * 
     */
    public EncontrarEnVentaConceptosResponse createEncontrarEnVentaConceptosResponse() {
        return new EncontrarEnVentaConceptosResponse();
    }

    /**
     * Create an instance of {@link EquipoDicom }
     * 
     */
    public EquipoDicom createEquipoDicom() {
        return new EquipoDicom();
    }

    /**
     * Create an instance of {@link Institucion }
     * 
     */
    public Institucion createInstitucion() {
        return new Institucion();
    }

    /**
     * Create an instance of {@link Areas }
     * 
     */
    public Areas createAreas() {
        return new Areas();
    }

    /**
     * Create an instance of {@link EncontrarPacientePorCurp }
     * 
     */
    public EncontrarPacientePorCurp createEncontrarPacientePorCurp() {
        return new EncontrarPacientePorCurp();
    }

    /**
     * Create an instance of {@link ListarTodo }
     * 
     */
    public ListarTodo createListarTodo() {
        return new ListarTodo();
    }

    /**
     * Create an instance of {@link EncontrarPacientePorCurpResponse }
     * 
     */
    public EncontrarPacientePorCurpResponse createEncontrarPacientePorCurpResponse() {
        return new EncontrarPacientePorCurpResponse();
    }

    /**
     * Create an instance of {@link CatalogoFormaPago }
     * 
     */
    public CatalogoFormaPago createCatalogoFormaPago() {
        return new CatalogoFormaPago();
    }

    /**
     * Create an instance of {@link EncontrarEnVentaConceptos }
     * 
     */
    public EncontrarEnVentaConceptos createEncontrarEnVentaConceptos() {
        return new EncontrarEnVentaConceptos();
    }

    /**
     * Create an instance of {@link EncontrarPacientePorIdResponse }
     * 
     */
    public EncontrarPacientePorIdResponse createEncontrarPacientePorIdResponse() {
        return new EncontrarPacientePorIdResponse();
    }

    /**
     * Create an instance of {@link Conceptos }
     * 
     */
    public Conceptos createConceptos() {
        return new Conceptos();
    }

    /**
     * Create an instance of {@link ListarTodoResponse }
     * 
     */
    public ListarTodoResponse createListarTodoResponse() {
        return new ListarTodoResponse();
    }

    /**
     * Create an instance of {@link Pacientes }
     * 
     */
    public Pacientes createPacientes() {
        return new Pacientes();
    }

    /**
     * Create an instance of {@link OrdenVenta }
     * 
     */
    public OrdenVenta createOrdenVenta() {
        return new OrdenVenta();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarPacientePorIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarPacientePorIdResponse")
    public JAXBElement<EncontrarPacientePorIdResponse> createEncontrarPacientePorIdResponse(EncontrarPacientePorIdResponse value) {
        return new JAXBElement<EncontrarPacientePorIdResponse>(_EncontrarPacientePorIdResponse_QNAME, EncontrarPacientePorIdResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarEnVentaConceptos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarEnVentaConceptos")
    public JAXBElement<EncontrarEnVentaConceptos> createEncontrarEnVentaConceptos(EncontrarEnVentaConceptos value) {
        return new JAXBElement<EncontrarEnVentaConceptos>(_EncontrarEnVentaConceptos_QNAME, EncontrarEnVentaConceptos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarPacientePorCurpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarPacientePorCurpResponse")
    public JAXBElement<EncontrarPacientePorCurpResponse> createEncontrarPacientePorCurpResponse(EncontrarPacientePorCurpResponse value) {
        return new JAXBElement<EncontrarPacientePorCurpResponse>(_EncontrarPacientePorCurpResponse_QNAME, EncontrarPacientePorCurpResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Pacientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "pacientes")
    public JAXBElement<Pacientes> createPacientes(Pacientes value) {
        return new JAXBElement<Pacientes>(_Pacientes_QNAME, Pacientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarTodoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "listarTodoResponse")
    public JAXBElement<ListarTodoResponse> createListarTodoResponse(ListarTodoResponse value) {
        return new JAXBElement<ListarTodoResponse>(_ListarTodoResponse_QNAME, ListarTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarEnVentaConceptosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarEnVentaConceptosResponse")
    public JAXBElement<EncontrarEnVentaConceptosResponse> createEncontrarEnVentaConceptosResponse(EncontrarEnVentaConceptosResponse value) {
        return new JAXBElement<EncontrarEnVentaConceptosResponse>(_EncontrarEnVentaConceptosResponse_QNAME, EncontrarEnVentaConceptosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EquipoDicom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "equipoDicom")
    public JAXBElement<EquipoDicom> createEquipoDicom(EquipoDicom value) {
        return new JAXBElement<EquipoDicom>(_EquipoDicom_QNAME, EquipoDicom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarPacientePorId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarPacientePorId")
    public JAXBElement<EncontrarPacientePorId> createEncontrarPacientePorId(EncontrarPacientePorId value) {
        return new JAXBElement<EncontrarPacientePorId>(_EncontrarPacientePorId_QNAME, EncontrarPacientePorId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VentaConceptos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "ventaConceptos")
    public JAXBElement<VentaConceptos> createVentaConceptos(VentaConceptos value) {
        return new JAXBElement<VentaConceptos>(_VentaConceptos_QNAME, VentaConceptos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarTodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "listarTodo")
    public JAXBElement<ListarTodo> createListarTodo(ListarTodo value) {
        return new JAXBElement<ListarTodo>(_ListarTodo_QNAME, ListarTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncontrarPacientePorCurp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "encontrarPacientePorCurp")
    public JAXBElement<EncontrarPacientePorCurp> createEncontrarPacientePorCurp(EncontrarPacientePorCurp value) {
        return new JAXBElement<EncontrarPacientePorCurp>(_EncontrarPacientePorCurp_QNAME, EncontrarPacientePorCurp.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Institucion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "institucion")
    public JAXBElement<Institucion> createInstitucion(Institucion value) {
        return new JAXBElement<Institucion>(_Institucion_QNAME, Institucion.class, null, value);
    }

}
