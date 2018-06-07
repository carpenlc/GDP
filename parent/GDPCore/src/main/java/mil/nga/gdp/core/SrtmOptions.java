
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SrtmOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SrtmOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="value" type="{mil:nga:downloadproductsxmlresponse}SrtmOutputTypeValue" />
 *       &lt;attribute name="name" type="{mil:nga:downloadproductsxmlresponse}SrtmOutputType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SrtmOptions")
public class SrtmOptions {

    @XmlAttribute(name = "value")
    protected SrtmOutputTypeValue value;
    @XmlAttribute(name = "name")
    protected SrtmOutputType name;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link SrtmOutputTypeValue }
     *     
     */
    public SrtmOutputTypeValue getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link SrtmOutputTypeValue }
     *     
     */
    public void setValue(SrtmOutputTypeValue value) {
        this.value = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link SrtmOutputType }
     *     
     */
    public SrtmOutputType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link SrtmOutputType }
     *     
     */
    public void setName(SrtmOutputType value) {
        this.name = value;
    }

}
