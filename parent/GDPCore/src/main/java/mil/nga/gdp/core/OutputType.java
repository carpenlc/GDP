
package mil.nga.gdp.core;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rpfOptions" type="{mil:nga:downloadproductsxmlresponse}RpfOptions" maxOccurs="unbounded"/>
 *         &lt;element name="dtedOptions" type="{mil:nga:downloadproductsxmlresponse}DtedOptions" maxOccurs="unbounded"/>
 *         &lt;element name="doqqOptions" type="{mil:nga:downloadproductsxmlresponse}DoqqOptions" maxOccurs="unbounded"/>
 *         &lt;element name="srtmOptions" type="{mil:nga:downloadproductsxmlresponse}SrtmOptions" maxOccurs="unbounded"/>
 *         &lt;element name="ctpOptions" type="{mil:nga:downloadproductsxmlresponse}CtpOptions" maxOccurs="unbounded"/>
 *         &lt;element name="defaultFormat" type="{mil:nga:downloadproductsxmlresponse}DefaultFormat"/>
 *       &lt;/sequence>
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputType", propOrder = {
    "rpfOptions",
    "dtedOptions",
    "doqqOptions",
    "srtmOptions",
    "ctpOptions",
    "defaultFormat"
})
public class OutputType {

    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true, nillable = true)
    protected List<RpfOptions> rpfOptions;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true, nillable = true)
    protected List<DtedOptions> dtedOptions;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true, nillable = true)
    protected List<DoqqOptions> doqqOptions;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true, nillable = true)
    protected List<SrtmOptions> srtmOptions;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true, nillable = true)
    protected List<CtpOptions> ctpOptions;
    @XmlElement(namespace = "mil:nga:downloadproductsxmlresponse", required = true)
    protected DefaultFormat defaultFormat;
    @XmlAttribute(name = "value")
    protected BigInteger value;

    /**
     * Gets the value of the rpfOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rpfOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRpfOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RpfOptions }
     * 
     * 
     */
    public List<RpfOptions> getRpfOptions() {
        if (rpfOptions == null) {
            rpfOptions = new ArrayList<RpfOptions>();
        }
        return this.rpfOptions;
    }

    /**
     * Gets the value of the dtedOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dtedOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDtedOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtedOptions }
     * 
     * 
     */
    public List<DtedOptions> getDtedOptions() {
        if (dtedOptions == null) {
            dtedOptions = new ArrayList<DtedOptions>();
        }
        return this.dtedOptions;
    }

    /**
     * Gets the value of the doqqOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the doqqOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDoqqOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DoqqOptions }
     * 
     * 
     */
    public List<DoqqOptions> getDoqqOptions() {
        if (doqqOptions == null) {
            doqqOptions = new ArrayList<DoqqOptions>();
        }
        return this.doqqOptions;
    }

    /**
     * Gets the value of the srtmOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the srtmOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSrtmOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SrtmOptions }
     * 
     * 
     */
    public List<SrtmOptions> getSrtmOptions() {
        if (srtmOptions == null) {
            srtmOptions = new ArrayList<SrtmOptions>();
        }
        return this.srtmOptions;
    }

    /**
     * Gets the value of the ctpOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ctpOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCtpOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CtpOptions }
     * 
     * 
     */
    public List<CtpOptions> getCtpOptions() {
        if (ctpOptions == null) {
            ctpOptions = new ArrayList<CtpOptions>();
        }
        return this.ctpOptions;
    }

    /**
     * Gets the value of the defaultFormat property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultFormat }
     *     
     */
    public DefaultFormat getDefaultFormat() {
        return defaultFormat;
    }

    /**
     * Sets the value of the defaultFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultFormat }
     *     
     */
    public void setDefaultFormat(DefaultFormat value) {
        this.defaultFormat = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValue(BigInteger value) {
        this.value = value;
    }

}
