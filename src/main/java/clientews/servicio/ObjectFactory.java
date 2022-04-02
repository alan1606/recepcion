
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

    private final static QName _Medico_QNAME = new QName("http://servicio.sga.gm.com.mx/", "medico");
    private final static QName _ObtenerTodosLosMedicos_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerTodosLosMedicos");
    private final static QName _BuscarMedicoPorTelefono_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorTelefono");
    private final static QName _RegistrarMedico_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarMedico");
    private final static QName _RegistrarMedicoResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "registrarMedicoResponse");
    private final static QName _ObtenerMedicosReferentesResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerMedicosReferentesResponse");
    private final static QName _ObtenerTodosLosMedicosResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerTodosLosMedicosResponse");
    private final static QName _ObtenerMedicosReferentes_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerMedicosReferentes");
    private final static QName _BuscarMedicoPorCorreo_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorCorreo");
    private final static QName _BuscarMedicoPorEspecialidadResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorEspecialidadResponse");
    private final static QName _ObtenerMedicosRadiologos_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerMedicosRadiologos");
    private final static QName _BuscarMedicosPorNombreResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicosPorNombreResponse");
    private final static QName _ActualizarMedico_QNAME = new QName("http://servicio.sga.gm.com.mx/", "actualizarMedico");
    private final static QName _BuscarMedicoPorIdResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorIdResponse");
    private final static QName _BuscarMedicosPorNombre_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicosPorNombre");
    private final static QName _BuscarMedicoPorCorreoResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorCorreoResponse");
    private final static QName _BuscarMedicoPorEspecialidad_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorEspecialidad");
    private final static QName _ActualizarMedicoResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "actualizarMedicoResponse");
    private final static QName _BuscarMedicoPorId_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorId");
    private final static QName _EliminarMedico_QNAME = new QName("http://servicio.sga.gm.com.mx/", "eliminarMedico");
    private final static QName _ObtenerMedicosRadiologosResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "obtenerMedicosRadiologosResponse");
    private final static QName _EliminarMedicoResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "eliminarMedicoResponse");
    private final static QName _BuscarMedicoPorTelefonoResponse_QNAME = new QName("http://servicio.sga.gm.com.mx/", "buscarMedicoPorTelefonoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActualizarMedicoResponse }
     * 
     */
    public ActualizarMedicoResponse createActualizarMedicoResponse() {
        return new ActualizarMedicoResponse();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorId }
     * 
     */
    public BuscarMedicoPorId createBuscarMedicoPorId() {
        return new BuscarMedicoPorId();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorEspecialidad }
     * 
     */
    public BuscarMedicoPorEspecialidad createBuscarMedicoPorEspecialidad() {
        return new BuscarMedicoPorEspecialidad();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorTelefonoResponse }
     * 
     */
    public BuscarMedicoPorTelefonoResponse createBuscarMedicoPorTelefonoResponse() {
        return new BuscarMedicoPorTelefonoResponse();
    }

    /**
     * Create an instance of {@link EliminarMedicoResponse }
     * 
     */
    public EliminarMedicoResponse createEliminarMedicoResponse() {
        return new EliminarMedicoResponse();
    }

    /**
     * Create an instance of {@link ObtenerMedicosRadiologosResponse }
     * 
     */
    public ObtenerMedicosRadiologosResponse createObtenerMedicosRadiologosResponse() {
        return new ObtenerMedicosRadiologosResponse();
    }

    /**
     * Create an instance of {@link EliminarMedico }
     * 
     */
    public EliminarMedico createEliminarMedico() {
        return new EliminarMedico();
    }

    /**
     * Create an instance of {@link ObtenerMedicosReferentesResponse }
     * 
     */
    public ObtenerMedicosReferentesResponse createObtenerMedicosReferentesResponse() {
        return new ObtenerMedicosReferentesResponse();
    }

    /**
     * Create an instance of {@link ObtenerTodosLosMedicosResponse }
     * 
     */
    public ObtenerTodosLosMedicosResponse createObtenerTodosLosMedicosResponse() {
        return new ObtenerTodosLosMedicosResponse();
    }

    /**
     * Create an instance of {@link RegistrarMedicoResponse }
     * 
     */
    public RegistrarMedicoResponse createRegistrarMedicoResponse() {
        return new RegistrarMedicoResponse();
    }

    /**
     * Create an instance of {@link RegistrarMedico }
     * 
     */
    public RegistrarMedico createRegistrarMedico() {
        return new RegistrarMedico();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorTelefono }
     * 
     */
    public BuscarMedicoPorTelefono createBuscarMedicoPorTelefono() {
        return new BuscarMedicoPorTelefono();
    }

    /**
     * Create an instance of {@link Medico }
     * 
     */
    public Medico createMedico() {
        return new Medico();
    }

    /**
     * Create an instance of {@link ObtenerTodosLosMedicos }
     * 
     */
    public ObtenerTodosLosMedicos createObtenerTodosLosMedicos() {
        return new ObtenerTodosLosMedicos();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorCorreoResponse }
     * 
     */
    public BuscarMedicoPorCorreoResponse createBuscarMedicoPorCorreoResponse() {
        return new BuscarMedicoPorCorreoResponse();
    }

    /**
     * Create an instance of {@link ActualizarMedico }
     * 
     */
    public ActualizarMedico createActualizarMedico() {
        return new ActualizarMedico();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorIdResponse }
     * 
     */
    public BuscarMedicoPorIdResponse createBuscarMedicoPorIdResponse() {
        return new BuscarMedicoPorIdResponse();
    }

    /**
     * Create an instance of {@link BuscarMedicosPorNombre }
     * 
     */
    public BuscarMedicosPorNombre createBuscarMedicosPorNombre() {
        return new BuscarMedicosPorNombre();
    }

    /**
     * Create an instance of {@link BuscarMedicosPorNombreResponse }
     * 
     */
    public BuscarMedicosPorNombreResponse createBuscarMedicosPorNombreResponse() {
        return new BuscarMedicosPorNombreResponse();
    }

    /**
     * Create an instance of {@link ObtenerMedicosRadiologos }
     * 
     */
    public ObtenerMedicosRadiologos createObtenerMedicosRadiologos() {
        return new ObtenerMedicosRadiologos();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorCorreo }
     * 
     */
    public BuscarMedicoPorCorreo createBuscarMedicoPorCorreo() {
        return new BuscarMedicoPorCorreo();
    }

    /**
     * Create an instance of {@link BuscarMedicoPorEspecialidadResponse }
     * 
     */
    public BuscarMedicoPorEspecialidadResponse createBuscarMedicoPorEspecialidadResponse() {
        return new BuscarMedicoPorEspecialidadResponse();
    }

    /**
     * Create an instance of {@link ObtenerMedicosReferentes }
     * 
     */
    public ObtenerMedicosReferentes createObtenerMedicosReferentes() {
        return new ObtenerMedicosReferentes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Medico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "medico")
    public JAXBElement<Medico> createMedico(Medico value) {
        return new JAXBElement<Medico>(_Medico_QNAME, Medico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerTodosLosMedicos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerTodosLosMedicos")
    public JAXBElement<ObtenerTodosLosMedicos> createObtenerTodosLosMedicos(ObtenerTodosLosMedicos value) {
        return new JAXBElement<ObtenerTodosLosMedicos>(_ObtenerTodosLosMedicos_QNAME, ObtenerTodosLosMedicos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorTelefono }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorTelefono")
    public JAXBElement<BuscarMedicoPorTelefono> createBuscarMedicoPorTelefono(BuscarMedicoPorTelefono value) {
        return new JAXBElement<BuscarMedicoPorTelefono>(_BuscarMedicoPorTelefono_QNAME, BuscarMedicoPorTelefono.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarMedico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarMedico")
    public JAXBElement<RegistrarMedico> createRegistrarMedico(RegistrarMedico value) {
        return new JAXBElement<RegistrarMedico>(_RegistrarMedico_QNAME, RegistrarMedico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarMedicoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "registrarMedicoResponse")
    public JAXBElement<RegistrarMedicoResponse> createRegistrarMedicoResponse(RegistrarMedicoResponse value) {
        return new JAXBElement<RegistrarMedicoResponse>(_RegistrarMedicoResponse_QNAME, RegistrarMedicoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerMedicosReferentesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerMedicosReferentesResponse")
    public JAXBElement<ObtenerMedicosReferentesResponse> createObtenerMedicosReferentesResponse(ObtenerMedicosReferentesResponse value) {
        return new JAXBElement<ObtenerMedicosReferentesResponse>(_ObtenerMedicosReferentesResponse_QNAME, ObtenerMedicosReferentesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerTodosLosMedicosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerTodosLosMedicosResponse")
    public JAXBElement<ObtenerTodosLosMedicosResponse> createObtenerTodosLosMedicosResponse(ObtenerTodosLosMedicosResponse value) {
        return new JAXBElement<ObtenerTodosLosMedicosResponse>(_ObtenerTodosLosMedicosResponse_QNAME, ObtenerTodosLosMedicosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerMedicosReferentes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerMedicosReferentes")
    public JAXBElement<ObtenerMedicosReferentes> createObtenerMedicosReferentes(ObtenerMedicosReferentes value) {
        return new JAXBElement<ObtenerMedicosReferentes>(_ObtenerMedicosReferentes_QNAME, ObtenerMedicosReferentes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorCorreo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorCorreo")
    public JAXBElement<BuscarMedicoPorCorreo> createBuscarMedicoPorCorreo(BuscarMedicoPorCorreo value) {
        return new JAXBElement<BuscarMedicoPorCorreo>(_BuscarMedicoPorCorreo_QNAME, BuscarMedicoPorCorreo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorEspecialidadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorEspecialidadResponse")
    public JAXBElement<BuscarMedicoPorEspecialidadResponse> createBuscarMedicoPorEspecialidadResponse(BuscarMedicoPorEspecialidadResponse value) {
        return new JAXBElement<BuscarMedicoPorEspecialidadResponse>(_BuscarMedicoPorEspecialidadResponse_QNAME, BuscarMedicoPorEspecialidadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerMedicosRadiologos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerMedicosRadiologos")
    public JAXBElement<ObtenerMedicosRadiologos> createObtenerMedicosRadiologos(ObtenerMedicosRadiologos value) {
        return new JAXBElement<ObtenerMedicosRadiologos>(_ObtenerMedicosRadiologos_QNAME, ObtenerMedicosRadiologos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicosPorNombreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicosPorNombreResponse")
    public JAXBElement<BuscarMedicosPorNombreResponse> createBuscarMedicosPorNombreResponse(BuscarMedicosPorNombreResponse value) {
        return new JAXBElement<BuscarMedicosPorNombreResponse>(_BuscarMedicosPorNombreResponse_QNAME, BuscarMedicosPorNombreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarMedico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "actualizarMedico")
    public JAXBElement<ActualizarMedico> createActualizarMedico(ActualizarMedico value) {
        return new JAXBElement<ActualizarMedico>(_ActualizarMedico_QNAME, ActualizarMedico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorIdResponse")
    public JAXBElement<BuscarMedicoPorIdResponse> createBuscarMedicoPorIdResponse(BuscarMedicoPorIdResponse value) {
        return new JAXBElement<BuscarMedicoPorIdResponse>(_BuscarMedicoPorIdResponse_QNAME, BuscarMedicoPorIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicosPorNombre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicosPorNombre")
    public JAXBElement<BuscarMedicosPorNombre> createBuscarMedicosPorNombre(BuscarMedicosPorNombre value) {
        return new JAXBElement<BuscarMedicosPorNombre>(_BuscarMedicosPorNombre_QNAME, BuscarMedicosPorNombre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorCorreoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorCorreoResponse")
    public JAXBElement<BuscarMedicoPorCorreoResponse> createBuscarMedicoPorCorreoResponse(BuscarMedicoPorCorreoResponse value) {
        return new JAXBElement<BuscarMedicoPorCorreoResponse>(_BuscarMedicoPorCorreoResponse_QNAME, BuscarMedicoPorCorreoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorEspecialidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorEspecialidad")
    public JAXBElement<BuscarMedicoPorEspecialidad> createBuscarMedicoPorEspecialidad(BuscarMedicoPorEspecialidad value) {
        return new JAXBElement<BuscarMedicoPorEspecialidad>(_BuscarMedicoPorEspecialidad_QNAME, BuscarMedicoPorEspecialidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarMedicoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "actualizarMedicoResponse")
    public JAXBElement<ActualizarMedicoResponse> createActualizarMedicoResponse(ActualizarMedicoResponse value) {
        return new JAXBElement<ActualizarMedicoResponse>(_ActualizarMedicoResponse_QNAME, ActualizarMedicoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorId")
    public JAXBElement<BuscarMedicoPorId> createBuscarMedicoPorId(BuscarMedicoPorId value) {
        return new JAXBElement<BuscarMedicoPorId>(_BuscarMedicoPorId_QNAME, BuscarMedicoPorId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarMedico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "eliminarMedico")
    public JAXBElement<EliminarMedico> createEliminarMedico(EliminarMedico value) {
        return new JAXBElement<EliminarMedico>(_EliminarMedico_QNAME, EliminarMedico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerMedicosRadiologosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "obtenerMedicosRadiologosResponse")
    public JAXBElement<ObtenerMedicosRadiologosResponse> createObtenerMedicosRadiologosResponse(ObtenerMedicosRadiologosResponse value) {
        return new JAXBElement<ObtenerMedicosRadiologosResponse>(_ObtenerMedicosRadiologosResponse_QNAME, ObtenerMedicosRadiologosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarMedicoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "eliminarMedicoResponse")
    public JAXBElement<EliminarMedicoResponse> createEliminarMedicoResponse(EliminarMedicoResponse value) {
        return new JAXBElement<EliminarMedicoResponse>(_EliminarMedicoResponse_QNAME, EliminarMedicoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarMedicoPorTelefonoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.sga.gm.com.mx/", name = "buscarMedicoPorTelefonoResponse")
    public JAXBElement<BuscarMedicoPorTelefonoResponse> createBuscarMedicoPorTelefonoResponse(BuscarMedicoPorTelefonoResponse value) {
        return new JAXBElement<BuscarMedicoPorTelefonoResponse>(_BuscarMedicoPorTelefonoResponse_QNAME, BuscarMedicoPorTelefonoResponse.class, null, value);
    }

}
