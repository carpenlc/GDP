
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoqqOutputType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoqqOutputType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GeoTIFF 2 byte elevations"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DoqqOutputType")
@XmlEnum
public enum DoqqOutputType {

    @XmlEnumValue("GeoTIFF 2 byte elevations")
    GEO_TIFF_2_BYTE_ELEVATIONS("GeoTIFF 2 byte elevations");
    private final String value;

    DoqqOutputType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DoqqOutputType fromValue(String v) {
        for (DoqqOutputType c: DoqqOutputType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
