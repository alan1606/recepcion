
package clientews.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para equipoDicom complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="equipoDicom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idEquipo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="modalidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aeTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ventaConceptosList" type="{http://servicio.sga.gm.com.mx/}ventaConceptos" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idArea" type="{http://servicio.sga.gm.com.mx/}areas" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "equipoDicom", propOrder = {
    "idEquipo",
    "modalidad",
    "nombre",
    "aeTitle",
    "ventaConceptosList",
    "idArea"
})
public class EquipoDicom {

    protected Long idEquipo;
    protected String modalidad;
    protected String nombre;
    protected String aeTitle;
    @XmlElement(nillable = true)
    protected List<VentaConceptos> ventaConceptosList;
    protected Areas idArea;

    /**
     * Obtiene el valor de la propiedad idEquipo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdEquipo() {
        return idEquipo;
    }

    /**
     * Define el valor de la propiedad idEquipo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdEquipo(Long value) {
        this.idEquipo = value;
    }

    /**
     * Obtiene el valor de la propiedad modalidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * Define el valor de la propiedad modalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModalidad(String value) {
        this.modalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad aeTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAeTitle() {
        return aeTitle;
    }

    /**
     * Define el valor de la propiedad aeTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAeTitle(String value) {
        this.aeTitle = value;
    }

    /**
     * Gets the value of the ventaConceptosList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ventaConceptosList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVentaConceptosList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VentaConceptos }
     * 
     * 
     */
    public List<VentaConceptos> getVentaConceptosList() {
        if (ventaConceptosList == null) {
            ventaConceptosList = new ArrayList<VentaConceptos>();
        }
        return this.ventaConceptosList;
    }

    /**
     * Obtiene el valor de la propiedad idArea.
     * 
     * @return
     *     possible object is
     *     {@link Areas }
     *     
     */
    public Areas getIdArea() {
        return idArea;
    }

    /**
     * Define el valor de la propiedad idArea.
     * 
     * @param value
     *     allowed object is
     *     {@link Areas }
     *     
     */
    public void setIdArea(Areas value) {
        this.idArea = value;
    }

}
