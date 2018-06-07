
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="security" type="{mil:nga:security}SecurityElement"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="downloadProductsXMLResponse" type="{mil:nga:downloadproductsxmlresponse}DownloadProductsXMLResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestResponse", namespace = "mil:nga:getProducts", propOrder = {
    "security",
    "message",
    "downloadProductsXMLResponse"
})
public class RequestResponse {

    @XmlElement(required = true)
    protected SecurityElement security;
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected DownloadProductsXMLResponse downloadProductsXMLResponse;

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
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the downloadProductsXMLResponse property.
     * 
     * @return
     *     possible object is
     *     {@link DownloadProductsXMLResponse }
     *     
     */
    public DownloadProductsXMLResponse getDownloadProductsXMLResponse() {
        return downloadProductsXMLResponse;
    }

    /**
     * Sets the value of the downloadProductsXMLResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link DownloadProductsXMLResponse }
     *     
     */
    public void setDownloadProductsXMLResponse(DownloadProductsXMLResponse value) {
        this.downloadProductsXMLResponse = value;
    }

}
