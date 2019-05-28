package mil.nga.coordinate_parse;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.1
 * 2019-05-28T13:57:05.265Z
 * Generated source version: 3.3.1
 *
 */
@WebServiceClient(name = "coordinate_parse_service",
                  wsdlLocation = "WEB-INF/wsdl/coordinate_parse_service.wsdl",
                  targetNamespace = "mil:nga:coordinate_parse")
public class CoordinateParseService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("mil:nga:coordinate_parse", "coordinate_parse_service");
    public final static QName CoordinateParseServicePort = new QName("mil:nga:coordinate_parse", "CoordinateParseServicePort");
    static {
        URL url = CoordinateParseService.class.getResource("WEB-INF/wsdl/coordinate_parse_service.wsdl");
        if (url == null) {
            url = CoordinateParseService.class.getClassLoader().getResource("WEB-INF/wsdl/coordinate_parse_service.wsdl");
        }
        if (url == null) {
            java.util.logging.Logger.getLogger(CoordinateParseService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "WEB-INF/wsdl/coordinate_parse_service.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CoordinateParseService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CoordinateParseService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CoordinateParseService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CoordinateParseService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CoordinateParseService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CoordinateParseService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CoordinateParse
     */
    @WebEndpoint(name = "CoordinateParseServicePort")
    public CoordinateParse getCoordinateParseServicePort() {
        return super.getPort(CoordinateParseServicePort, CoordinateParse.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CoordinateParse
     */
    @WebEndpoint(name = "CoordinateParseServicePort")
    public CoordinateParse getCoordinateParseServicePort(WebServiceFeature... features) {
        return super.getPort(CoordinateParseServicePort, CoordinateParse.class, features);
    }

}