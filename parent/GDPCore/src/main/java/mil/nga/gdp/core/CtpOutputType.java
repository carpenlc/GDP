
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CtpOutputType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CtpOutputType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Include Collarless"/>
 *     &lt;enumeration value="Include Collared"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CtpOutputType")
@XmlEnum
public enum CtpOutputType {

    @XmlEnumValue("Include Collarless")
    INCLUDE_COLLARLESS("Include Collarless"),
    @XmlEnumValue("Include Collared")
    INCLUDE_COLLARED("Include Collared");
    private final String value;

    CtpOutputType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CtpOutputType fromValue(String v) {
        for (CtpOutputType c: CtpOutputType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
