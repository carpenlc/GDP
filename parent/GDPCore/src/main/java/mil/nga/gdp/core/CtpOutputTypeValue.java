
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CtpOutputTypeValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CtpOutputTypeValue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ctp_collarless"/>
 *     &lt;enumeration value="ctp_collared"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CtpOutputTypeValue")
@XmlEnum
public enum CtpOutputTypeValue {

    @XmlEnumValue("ctp_collarless")
    CTP_COLLARLESS("ctp_collarless"),
    @XmlEnumValue("ctp_collared")
    CTP_COLLARED("ctp_collared");
    private final String value;

    CtpOutputTypeValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CtpOutputTypeValue fromValue(String v) {
        for (CtpOutputTypeValue c: CtpOutputTypeValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
