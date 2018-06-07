
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="frameCount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileSize_bytes" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PostURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bbox" type="{mil:nga:downloadproductsxmlresponse}BBOX"/>
 *         &lt;element name="product" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="command" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="palType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nullvalue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="outputType" type="{mil:nga:downloadproductsxmlresponse}OutputType"/>
 *         &lt;element name="archiveType" type="{mil:nga:downloadproductsxmlresponse}ArchiveType"/>
 *         &lt;element name="listFile" type="{mil:nga:downloadproductsxmlresponse}ListFile"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProdTag" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
    "productName",
    "productDescription",
    "frameCount",
    "fileSizeBytes",
    "postURL",
    "bbox",
    "product",
    "command",
    "palType",
    "nullvalue",
    "outputType",
    "archiveType",
    "listFile"
})
public class Product {

    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String productName;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String productDescription;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String frameCount;
    @XmlElement(name = "fileSize_bytes", namespace = "mil:nga:downloadproductsxmlresponse")
    protected long fileSizeBytes;
    @XmlElement(name = "PostURL", namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String postURL;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected BBOX bbox;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String product;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String command;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String palType;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected String nullvalue;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected OutputType outputType;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected ArchiveType archiveType;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected ListFile listFile;
    @XmlAttribute(name = "ProdTag", required = true)
    protected String prodTag;

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the productDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the value of the productDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDescription(String value) {
        this.productDescription = value;
    }

    /**
     * Gets the value of the frameCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrameCount() {
        return frameCount;
    }

    /**
     * Sets the value of the frameCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameCount(String value) {
        this.frameCount = value;
    }

    /**
     * Gets the value of the fileSizeBytes property.
     * 
     */
    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    /**
     * Sets the value of the fileSizeBytes property.
     * 
     */
    public void setFileSizeBytes(long value) {
        this.fileSizeBytes = value;
    }

    /**
     * Gets the value of the postURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostURL() {
        return postURL;
    }

    /**
     * Sets the value of the postURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostURL(String value) {
        this.postURL = value;
    }

    /**
     * Gets the value of the bbox property.
     * 
     * @return
     *     possible object is
     *     {@link BBOX }
     *     
     */
    public BBOX getBbox() {
        return bbox;
    }

    /**
     * Sets the value of the bbox property.
     * 
     * @param value
     *     allowed object is
     *     {@link BBOX }
     *     
     */
    public void setBbox(BBOX value) {
        this.bbox = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the command property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the value of the command property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommand(String value) {
        this.command = value;
    }

    /**
     * Gets the value of the palType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPalType() {
        return palType;
    }

    /**
     * Sets the value of the palType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPalType(String value) {
        this.palType = value;
    }

    /**
     * Gets the value of the nullvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNullvalue() {
        return nullvalue;
    }

    /**
     * Sets the value of the nullvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNullvalue(String value) {
        this.nullvalue = value;
    }

    /**
     * Gets the value of the outputType property.
     * 
     * @return
     *     possible object is
     *     {@link OutputType }
     *     
     */
    public OutputType getOutputType() {
        return outputType;
    }

    /**
     * Sets the value of the outputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputType }
     *     
     */
    public void setOutputType(OutputType value) {
        this.outputType = value;
    }

    /**
     * Gets the value of the archiveType property.
     * 
     * @return
     *     possible object is
     *     {@link ArchiveType }
     *     
     */
    public ArchiveType getArchiveType() {
        return archiveType;
    }

    /**
     * Sets the value of the archiveType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArchiveType }
     *     
     */
    public void setArchiveType(ArchiveType value) {
        this.archiveType = value;
    }

    /**
     * Gets the value of the listFile property.
     * 
     * @return
     *     possible object is
     *     {@link ListFile }
     *     
     */
    public ListFile getListFile() {
        return listFile;
    }

    /**
     * Sets the value of the listFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListFile }
     *     
     */
    public void setListFile(ListFile value) {
        this.listFile = value;
    }

    /**
     * Gets the value of the prodTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdTag() {
        return prodTag;
    }

    /**
     * Sets the value of the prodTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdTag(String value) {
        this.prodTag = value;
    }

}
