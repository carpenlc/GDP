
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DtedOutputType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DtedOutputType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ERDAS Lan"/>
 *     &lt;enumeration value="GeoTIFF 2 byte elevations"/>
 *     &lt;enumeration value="ARC-Info Lattice 5.0"/>
 *     &lt;enumeration value="Vista Pro"/>
 *     &lt;enumeration value="ERDAS Imagine"/>
 *     &lt;enumeration value="PNG"/>
 *     &lt;enumeration value="VRML"/>
 *     &lt;enumeration value="JPEG Shaded Relief Image"/>
 *     &lt;enumeration value="ARC Info ASCII Grid"/>
 *     &lt;enumeration value="ARC Info Float Grid"/>
 *     &lt;enumeration value="USGS DEM"/>
 *     &lt;enumeration value="Vis5D"/>
 *     &lt;enumeration value="IDRISI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DtedOutputType")
@XmlEnum
public enum DtedOutputType {

    @XmlEnumValue("ERDAS Lan")
    ERDAS_LAN("ERDAS Lan"),
    @XmlEnumValue("GeoTIFF 2 byte elevations")
    GEO_TIFF_2_BYTE_ELEVATIONS("GeoTIFF 2 byte elevations"),
    @XmlEnumValue("ARC-Info Lattice 5.0")
    ARC_INFO_LATTICE_5_0("ARC-Info Lattice 5.0"),
    @XmlEnumValue("Vista Pro")
    VISTA_PRO("Vista Pro"),
    @XmlEnumValue("ERDAS Imagine")
    ERDAS_IMAGINE("ERDAS Imagine"),
    PNG("PNG"),
    VRML("VRML"),
    @XmlEnumValue("JPEG Shaded Relief Image")
    JPEG_SHADED_RELIEF_IMAGE("JPEG Shaded Relief Image"),
    @XmlEnumValue("ARC Info ASCII Grid")
    ARC_INFO_ASCII_GRID("ARC Info ASCII Grid"),
    @XmlEnumValue("ARC Info Float Grid")
    ARC_INFO_FLOAT_GRID("ARC Info Float Grid"),
    @XmlEnumValue("USGS DEM")
    USGS_DEM("USGS DEM"),
    @XmlEnumValue("Vis5D")
    VIS_5_D("Vis5D"),
    IDRISI("IDRISI");
    private final String value;

    DtedOutputType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DtedOutputType fromValue(String v) {
        for (DtedOutputType c: DtedOutputType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
