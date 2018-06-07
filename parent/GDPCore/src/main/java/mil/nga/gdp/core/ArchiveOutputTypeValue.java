
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArchiveOutputTypeValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArchiveOutputTypeValue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ZipFTP"/>
 *     &lt;enumeration value="TarFTP"/>
 *     &lt;enumeration value="GzipFTP"/>
 *     &lt;enumeration value="CompressFTP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArchiveOutputTypeValue")
@XmlEnum
public enum ArchiveOutputTypeValue {

    @XmlEnumValue("ZipFTP")
    ZIP_FTP("ZipFTP"),
    @XmlEnumValue("TarFTP")
    TAR_FTP("TarFTP"),
    @XmlEnumValue("GzipFTP")
    GZIP_FTP("GzipFTP"),
    @XmlEnumValue("CompressFTP")
    COMPRESS_FTP("CompressFTP");
    private final String value;

    ArchiveOutputTypeValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ArchiveOutputTypeValue fromValue(String v) {
        for (ArchiveOutputTypeValue c: ArchiveOutputTypeValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
