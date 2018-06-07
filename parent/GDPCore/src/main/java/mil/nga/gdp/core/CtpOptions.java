
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CtpOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CtpOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="value" type="{mil:nga:downloadproductsxmlresponse}CtpOutputTypeValue" />
 *       &lt;attribute name="name" type="{mil:nga:downloadproductsxmlresponse}CtpOutputType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CtpOptions")
public class CtpOptions {

    @XmlAttribute(name = "value")
    protected CtpOutputTypeValue value;
    @XmlAttribute(name = "name")
    protected CtpOutputType name;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link CtpOutputTypeValue }
     *     
     */
    public CtpOutputTypeValue getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtpOutputTypeValue }
     *     
     */
    public void setValue(CtpOutputTypeValue value) {
        this.value = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link CtpOutputType }
     *     
     */
    public CtpOutputType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link CtpOutputType }
     *     
     */
    public void setName(CtpOutputType value) {
        this.name = value;
    }

}
