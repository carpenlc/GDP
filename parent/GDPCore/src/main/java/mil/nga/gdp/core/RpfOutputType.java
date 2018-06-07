
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RpfOutputType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RpfOutputType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUN Raster"/>
 *     &lt;enumeration value="ERDAS Lan"/>
 *     &lt;enumeration value="TIFF"/>
 *     &lt;enumeration value="GeoTIFF 2 byte elevations"/>
 *     &lt;enumeration value="BMP"/>
 *     &lt;enumeration value="MapInfo"/>
 *     &lt;enumeration value="ERDAS Imagine"/>
 *     &lt;enumeration value="PNG"/>
 *     &lt;enumeration value="ArcView Raster"/>
 *     &lt;enumeration value="JPEG"/>
 *     &lt;enumeration value="USGS DEM"/>
 *     &lt;enumeration value="SGI RGB"/>
 *     &lt;enumeration value="IDRISI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RpfOutputType")
@XmlEnum
public enum RpfOutputType {

    @XmlEnumValue("SUN Raster")
    SUN_RASTER("SUN Raster"),
    @XmlEnumValue("ERDAS Lan")
    ERDAS_LAN("ERDAS Lan"),
    TIFF("TIFF"),
    @XmlEnumValue("GeoTIFF 2 byte elevations")
    GEO_TIFF_2_BYTE_ELEVATIONS("GeoTIFF 2 byte elevations"),
    BMP("BMP"),
    @XmlEnumValue("MapInfo")
    MAP_INFO("MapInfo"),
    @XmlEnumValue("ERDAS Imagine")
    ERDAS_IMAGINE("ERDAS Imagine"),
    PNG("PNG"),
    @XmlEnumValue("ArcView Raster")
    ARC_VIEW_RASTER("ArcView Raster"),
    JPEG("JPEG"),
    @XmlEnumValue("USGS DEM")
    USGS_DEM("USGS DEM"),
    @XmlEnumValue("SGI RGB")
    SGI_RGB("SGI RGB"),
    IDRISI("IDRISI");
    private final String value;

    RpfOutputType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RpfOutputType fromValue(String v) {
        for (RpfOutputType c: RpfOutputType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
