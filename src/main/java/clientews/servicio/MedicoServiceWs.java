
package clientews.servicio;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
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
@WebService(name = "MedicoServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MedicoServiceWs {


    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Medico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerMedicosReferentes", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerMedicosReferentes")
    @ResponseWrapper(localName = "obtenerMedicosReferentesResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerMedicosReferentesResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/obtenerMedicosReferentesRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/obtenerMedicosReferentesResponse")
    public List<Medico> obtenerMedicosReferentes();

    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Medico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerMedicosRadiologos", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerMedicosRadiologos")
    @ResponseWrapper(localName = "obtenerMedicosRadiologosResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerMedicosRadiologosResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/obtenerMedicosRadiologosRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/obtenerMedicosRadiologosResponse")
    public List<Medico> obtenerMedicosRadiologos();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registrarMedico", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarMedico")
    @ResponseWrapper(localName = "registrarMedicoResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarMedicoResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/registrarMedicoRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/registrarMedicoResponse")
    public void registrarMedico(
        @WebParam(name = "arg0", targetNamespace = "")
        Medico arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "eliminarMedico", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EliminarMedico")
    @ResponseWrapper(localName = "eliminarMedicoResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EliminarMedicoResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/eliminarMedicoRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/eliminarMedicoResponse")
    public void eliminarMedico(
        @WebParam(name = "arg0", targetNamespace = "")
        Medico arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Medico
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarMedicoPorId", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorId")
    @ResponseWrapper(localName = "buscarMedicoPorIdResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorIdResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorIdRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorIdResponse")
    public Medico buscarMedicoPorId(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Medico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerTodosLosMedicos", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerTodosLosMedicos")
    @ResponseWrapper(localName = "obtenerTodosLosMedicosResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ObtenerTodosLosMedicosResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/obtenerTodosLosMedicosRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/obtenerTodosLosMedicosResponse")
    public List<Medico> obtenerTodosLosMedicos();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Medico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarMedicoPorTelefono", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorTelefono")
    @ResponseWrapper(localName = "buscarMedicoPorTelefonoResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorTelefonoResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorTelefonoRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorTelefonoResponse")
    public List<Medico> buscarMedicoPorTelefono(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Medico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarMedicoPorCorreo", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorCorreo")
    @ResponseWrapper(localName = "buscarMedicoPorCorreoResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorCorreoResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorCorreoRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorCorreoResponse")
    public List<Medico> buscarMedicoPorCorreo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Medico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarMedicoPorEspecialidad", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorEspecialidad")
    @ResponseWrapper(localName = "buscarMedicoPorEspecialidadResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicoPorEspecialidadResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorEspecialidadRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicoPorEspecialidadResponse")
    public List<Medico> buscarMedicoPorEspecialidad(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "actualizarMedico", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarMedico")
    @ResponseWrapper(localName = "actualizarMedicoResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarMedicoResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/actualizarMedicoRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/actualizarMedicoResponse")
    public void actualizarMedico(
        @WebParam(name = "arg0", targetNamespace = "")
        Medico arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Medico>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarMedicosPorNombre", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicosPorNombre")
    @ResponseWrapper(localName = "buscarMedicosPorNombreResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.BuscarMedicosPorNombreResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicosPorNombreRequest", output = "http://servicio.sga.gm.com.mx/MedicoServiceWs/buscarMedicosPorNombreResponse")
    public List<Medico> buscarMedicosPorNombre(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
