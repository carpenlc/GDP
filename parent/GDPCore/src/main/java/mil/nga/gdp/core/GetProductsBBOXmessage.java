
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetProductsBBOXmessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProductsBBOXmessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="security" type="{mil:nga:security}SecurityElement"/>
 *         &lt;element name="origGdnCompatable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="productTag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="boundingBox" type="{mil:nga:downloadproductsxmlresponse}BBOX"/>
 *         &lt;element name="fromDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="toDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="directDownload" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProductsBBOXmessage", namespace = "mil:nga:getProducts", propOrder = {
    "security",
    "origGdnCompatable",
    "productTag",
    "boundingBox",
    "fromDate",
    "toDate",
    "directDownload"
})
public class GetProductsBBOXmessage {

    @XmlElement(required = true, nillable = true)
    protected SecurityElement security;
    protected boolean origGdnCompatable;
    @XmlElement(required = true)
    protected String productTag;
    @XmlElement(required = true)
    protected BBOX boundingBox;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fromDate;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar toDate;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean directDownload;

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityElement }
     *     
     */
    public SecurityElement getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityElement }
     *     
     */
    public void setSecurity(SecurityElement value) {
        this.security = value;
    }

    /**
     * Gets the value of the origGdnCompatable property.
     * 
     */
    public boolean isOrigGdnCompatable() {
        return origGdnCompatable;
    }

    /**
     * Sets the value of the origGdnCompatable property.
     * 
     */
    public void setOrigGdnCompatable(boolean value) {
        this.origGdnCompatable = value;
    }

    /**
     * Gets the value of the productTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductTag() {
        return productTag;
    }

    /**
     * Sets the value of the productTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductTag(String value) {
        this.productTag = value;
    }

    /**
     * Gets the value of the boundingBox property.
     * 
     * @return
     *     possible object is
     *     {@link BBOX }
     *     
     */
    public BBOX getBoundingBox() {
        return boundingBox;
    }

    /**
     * Sets the value of the boundingBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link BBOX }
     *     
     */
    public void setBoundingBox(BBOX value) {
        this.boundingBox = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDate(XMLGregorianCalendar value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDate(XMLGregorianCalendar value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the directDownload property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDirectDownload() {
        return directDownload;
    }

    /**
     * Sets the value of the directDownload property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirectDownload(Boolean value) {
        this.directDownload = value;
    }

}
