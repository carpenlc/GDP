
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Bounding Box of the product as a Lower Left / Upper Right Corners.  Required to be [+|-]DD for each coordinate.
 *         Example: -10.098723 for LowerLeftLat.
 *       
 * 
 * <p>Java class for BBOX complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BBOX">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LowerLeftLat" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LowerLeftLon" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="UpperRightLat" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="UpperRightLon" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BBOX", propOrder = {
    "lowerLeftLat",
    "lowerLeftLon",
    "upperRightLat",
    "upperRightLon"
})
public class BBOX {

    @XmlElement(name = "LowerLeftLat", namespace = "mil:nga:downloadproductsxmlresponse")
    protected double lowerLeftLat;
    @XmlElement(name = "LowerLeftLon", namespace = "mil:nga:downloadproductsxmlresponse")
    protected double lowerLeftLon;
    @XmlElement(name = "UpperRightLat", namespace = "mil:nga:downloadproductsxmlresponse")
    protected double upperRightLat;
    @XmlElement(name = "UpperRightLon", namespace = "mil:nga:downloadproductsxmlresponse")
    protected double upperRightLon;

    /**
     * Gets the value of the lowerLeftLat property.
     * 
     */
    public double getLowerLeftLat() {
        return lowerLeftLat;
    }

    /**
     * Sets the value of the lowerLeftLat property.
     * 
     */
    public void setLowerLeftLat(double value) {
        this.lowerLeftLat = value;
    }

    /**
     * Gets the value of the lowerLeftLon property.
     * 
     */
    public double getLowerLeftLon() {
        return lowerLeftLon;
    }

    /**
     * Sets the value of the lowerLeftLon property.
     * 
     */
    public void setLowerLeftLon(double value) {
        this.lowerLeftLon = value;
    }

    /**
     * Gets the value of the upperRightLat property.
     * 
     */
    public double getUpperRightLat() {
        return upperRightLat;
    }

    /**
     * Sets the value of the upperRightLat property.
     * 
     */
    public void setUpperRightLat(double value) {
        this.upperRightLat = value;
    }

    /**
     * Gets the value of the upperRightLon property.
     * 
     */
    public double getUpperRightLon() {
        return upperRightLon;
    }

    /**
     * Sets the value of the upperRightLon property.
     * 
     */
    public void setUpperRightLon(double value) {
        this.upperRightLon = value;
    }

}
