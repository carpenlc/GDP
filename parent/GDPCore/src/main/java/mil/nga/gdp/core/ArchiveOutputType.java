
package mil.nga.gdp.core;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArchiveOutputType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArchiveOutputType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Windows ZIP file"/>
 *     &lt;enumeration value="Unix Tar File"/>
 *     &lt;enumeration value="Windows Gzip file Compressed"/>
 *     &lt;enumeration value="UNIX z file Compressed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArchiveOutputType")
@XmlEnum
public enum ArchiveOutputType {

    @XmlEnumValue("Windows ZIP file")
    WINDOWS_ZIP_FILE("Windows ZIP file"),
    @XmlEnumValue("Unix Tar File")
    UNIX_TAR_FILE("Unix Tar File"),
    @XmlEnumValue("Windows Gzip file Compressed")
    WINDOWS_GZIP_FILE_COMPRESSED("Windows Gzip file Compressed"),
    @XmlEnumValue("UNIX z file Compressed")
    UNIX_Z_FILE_COMPRESSED("UNIX z file Compressed");
    private final String value;

    ArchiveOutputType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ArchiveOutputType fromValue(String v) {
        for (ArchiveOutputType c: ArchiveOutputType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
