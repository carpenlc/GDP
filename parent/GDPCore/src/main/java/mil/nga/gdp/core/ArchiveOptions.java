
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArchiveOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArchiveOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="type" type="{mil:nga:downloadproductsxmlresponse}ArchiveOutputTypeValue" />
 *       &lt;attribute name="name" type="{mil:nga:downloadproductsxmlresponse}ArchiveOutputType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArchiveOptions")
public class ArchiveOptions {

    @XmlAttribute(name = "type")
    protected ArchiveOutputTypeValue type;
    @XmlAttribute(name = "name")
    protected ArchiveOutputType name;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ArchiveOutputTypeValue }
     *     
     */
    public ArchiveOutputTypeValue getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchiveOutputTypeValue }
     *     
     */
    public void setType(ArchiveOutputTypeValue value) {
        this.type = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link ArchiveOutputType }
     *     
     */
    public ArchiveOutputType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchiveOutputType }
     *     
     */
    public void setName(ArchiveOutputType value) {
        this.name = value;
    }

}
