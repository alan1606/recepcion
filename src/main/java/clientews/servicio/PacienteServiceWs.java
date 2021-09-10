
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
@WebService(name = "PacienteServiceWs", targetNamespace = "http://servicio.sga.gm.com.mx/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PacienteServiceWs {


    /**
     * 
     * @return
     *     returns java.util.List<clientews.servicio.Pacientes>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarTodosPacientes", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarTodosPacientes")
    @ResponseWrapper(localName = "listarTodosPacientesResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ListarTodosPacientesResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/listarTodosPacientesRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/listarTodosPacientesResponse")
    public List<Pacientes> listarTodosPacientes();

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Pacientes
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarPacientePorId", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacientePorId")
    @ResponseWrapper(localName = "encontrarPacientePorIdResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacientePorIdResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacientePorIdRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacientePorIdResponse")
    public Pacientes encontrarPacientePorId(
        @WebParam(name = "arg0", targetNamespace = "")
        Pacientes arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Pacientes>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarPacienteLikeCurp", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacienteLikeCurp")
    @ResponseWrapper(localName = "encontrarPacienteLikeCurpResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacienteLikeCurpResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacienteLikeCurpRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacienteLikeCurpResponse")
    public List<Pacientes> encontrarPacienteLikeCurp(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns clientews.servicio.Pacientes
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarPacientePorCurp", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacientePorCurp")
    @ResponseWrapper(localName = "encontrarPacientePorCurpResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacientePorCurpResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacientePorCurpRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacientePorCurpResponse")
    public Pacientes encontrarPacientePorCurp(
        @WebParam(name = "arg0", targetNamespace = "")
        Pacientes arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Pacientes>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarPacienteLikeNombre", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacienteLikeNombre")
    @ResponseWrapper(localName = "encontrarPacienteLikeNombreResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarPacienteLikeNombreResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacienteLikeNombreRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarPacienteLikeNombreResponse")
    public List<Pacientes> encontrarPacienteLikeNombre(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "registrarPaciente", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarPaciente")
    @ResponseWrapper(localName = "registrarPacienteResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.RegistrarPacienteResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/registrarPacienteRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/registrarPacienteResponse")
    public void registrarPaciente(
        @WebParam(name = "arg0", targetNamespace = "")
        Pacientes arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "actualizarPaciente", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarPaciente")
    @ResponseWrapper(localName = "actualizarPacienteResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.ActualizarPacienteResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/actualizarPacienteRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/actualizarPacienteResponse")
    public void actualizarPaciente(
        @WebParam(name = "arg0", targetNamespace = "")
        Pacientes arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<clientews.servicio.Pacientes>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "encontrarEnVentaConceptos", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEnVentaConceptos")
    @ResponseWrapper(localName = "encontrarEnVentaConceptosResponse", targetNamespace = "http://servicio.sga.gm.com.mx/", className = "clientews.servicio.EncontrarEnVentaConceptosResponse")
    @Action(input = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarEnVentaConceptosRequest", output = "http://servicio.sga.gm.com.mx/PacienteServiceWs/encontrarEnVentaConceptosResponse")
    public List<Pacientes> encontrarEnVentaConceptos(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
