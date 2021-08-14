
package clientews.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para catalogoFormaPago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="catalogoFormaPago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="formaPagoFp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ordenVentaList" type="{http://servicio.sga.gm.com.mx/}ordenVenta" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "catalogoFormaPago", propOrder = {
    "idFp",
    "formaPagoFp",
    "ordenVentaList"
})
public class CatalogoFormaPago {

    protected Short idFp;
    protected String formaPagoFp;
    @XmlElement(nillable = true)
    protected List<OrdenVenta> ordenVentaList;

    /**
     * Obtiene el valor de la propiedad idFp.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIdFp() {
        return idFp;
    }

    /**
     * Define el valor de la propiedad idFp.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIdFp(Short value) {
        this.idFp = value;
    }

    /**
     * Obtiene el valor de la propiedad formaPagoFp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPagoFp() {
        return formaPagoFp;
    }

    /**
     * Define el valor de la propiedad formaPagoFp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPagoFp(String value) {
        this.formaPagoFp = value;
    }

    /**
     * Gets the value of the ordenVentaList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ordenVentaList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrdenVentaList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrdenVenta }
     * 
     * 
     */
    public List<OrdenVenta> getOrdenVentaList() {
        if (ordenVentaList == null) {
            ordenVentaList = new ArrayList<OrdenVenta>();
        }
        return this.ordenVentaList;
    }

}
