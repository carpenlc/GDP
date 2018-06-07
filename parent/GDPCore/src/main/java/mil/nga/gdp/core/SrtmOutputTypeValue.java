
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SrtmOutputTypeValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SrtmOutputTypeValue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="aoim"/>
 *     &lt;enumeration value="doim"/>
 *     &lt;enumeration value="water"/>
 *     &lt;enumeration value="shape"/>
 *     &lt;enumeration value="shcm"/>
 *     &lt;enumeration value="thed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SrtmOutputTypeValue")
@XmlEnum
public enum SrtmOutputTypeValue {

    @XmlEnumValue("aoim")
    AOIM("aoim"),
    @XmlEnumValue("doim")
    DOIM("doim"),
    @XmlEnumValue("water")
    WATER("water"),
    @XmlEnumValue("shape")
    SHAPE("shape"),
    @XmlEnumValue("shcm")
    SHCM("shcm"),
    @XmlEnumValue("thed")
    THED("thed");
    private final String value;

    SrtmOutputTypeValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SrtmOutputTypeValue fromValue(String v) {
        for (SrtmOutputTypeValue c: SrtmOutputTypeValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
