
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SrtmOutputType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SrtmOutputType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ascending Orthorectified Image Mosaic Files"/>
 *     &lt;enumeration value="Descending Orthorectified Image Mosaic Files"/>
 *     &lt;enumeration value="Shuttle Water Body Data Files"/>
 *     &lt;enumeration value="Void Shape Files"/>
 *     &lt;enumeration value="Seam-Hole Composite Map Files"/>
 *     &lt;enumeration value="Terrain Height Error Data Files"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SrtmOutputType")
@XmlEnum
public enum SrtmOutputType {

    @XmlEnumValue("Ascending Orthorectified Image Mosaic Files")
    ASCENDING_ORTHORECTIFIED_IMAGE_MOSAIC_FILES("Ascending Orthorectified Image Mosaic Files"),
    @XmlEnumValue("Descending Orthorectified Image Mosaic Files")
    DESCENDING_ORTHORECTIFIED_IMAGE_MOSAIC_FILES("Descending Orthorectified Image Mosaic Files"),
    @XmlEnumValue("Shuttle Water Body Data Files")
    SHUTTLE_WATER_BODY_DATA_FILES("Shuttle Water Body Data Files"),
    @XmlEnumValue("Void Shape Files")
    VOID_SHAPE_FILES("Void Shape Files"),
    @XmlEnumValue("Seam-Hole Composite Map Files")
    SEAM_HOLE_COMPOSITE_MAP_FILES("Seam-Hole Composite Map Files"),
    @XmlEnumValue("Terrain Height Error Data Files")
    TERRAIN_HEIGHT_ERROR_DATA_FILES("Terrain Height Error Data Files");
    private final String value;

    SrtmOutputType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SrtmOutputType fromValue(String v) {
        for (SrtmOutputType c: SrtmOutputType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
