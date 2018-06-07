
package mil.nga.gdp.core;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mil.nga.gdp.core package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RequestResponse_QNAME = new QName("mil:nga:getProducts", "requestResponse");
    private final static QName _GetProductsWKTmessage_QNAME = new QName("mil:nga:getProducts", "GetProductsWKTmessage");
    private final static QName _DownloadProductsXMLResponse_QNAME = new QName("mil:nga:downloadproductsxmlresponse", "downloadProductsXMLResponse");
    private final static QName _GetProductsUnitNamemessage_QNAME = new QName("mil:nga:getProducts", "GetProductsUnitNamemessage");
    private final static QName _GetProductsAORJMPmessage_QNAME = new QName("mil:nga:getProducts", "GetProductsAOR_JMPmessage");
    private final static QName _GetProductsBBOXmessage_QNAME = new QName("mil:nga:getProducts", "GetProductsBBOXmessage");
    private final static QName _GetProductsCNTRYmessage_QNAME = new QName("mil:nga:getProducts", "GetProductsCNTRYmessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mil.nga.gdp.core
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListFile }
     * 
     */
    public ListFile createListFile() {
        return new ListFile();
    }

    /**
     * Create an instance of {@link GetProductsCNTRYmessage }
     * 
     */
    public GetProductsCNTRYmessage createGetProductsCNTRYmessage() {
        return new GetProductsCNTRYmessage();
    }

    /**
     * Create an instance of {@link RequestResponse }
     * 
     */
    public RequestResponse createRequestResponse() {
        return new RequestResponse();
    }

    /**
     * Create an instance of {@link GetProductsWKTmessage }
     * 
     */
    public GetProductsWKTmessage createGetProductsWKTmessage() {
        return new GetProductsWKTmessage();
    }

    /**
     * Create an instance of {@link GetProductsUnitNamemessage }
     * 
     */
    public GetProductsUnitNamemessage createGetProductsUnitNamemessage() {
        return new GetProductsUnitNamemessage();
    }

    /**
     * Create an instance of {@link GetProductsAORJMPmessage }
     * 
     */
    public GetProductsAORJMPmessage createGetProductsAORJMPmessage() {
        return new GetProductsAORJMPmessage();
    }

    /**
     * Create an instance of {@link GetProductsBBOXmessage }
     * 
     */
    public GetProductsBBOXmessage createGetProductsBBOXmessage() {
        return new GetProductsBBOXmessage();
    }

    /**
     * Create an instance of {@link SecurityElement }
     * 
     */
    public SecurityElement createSecurityElement() {
        return new SecurityElement();
    }

    /**
     * Create an instance of {@link DownloadProductsXMLResponse }
     * 
     */
    public DownloadProductsXMLResponse createDownloadProductsXMLResponse() {
        return new DownloadProductsXMLResponse();
    }

    /**
     * Create an instance of {@link CtpOptions }
     * 
     */
    public CtpOptions createCtpOptions() {
        return new CtpOptions();
    }

    /**
     * Create an instance of {@link DoqqOptions }
     * 
     */
    public DoqqOptions createDoqqOptions() {
        return new DoqqOptions();
    }

    /**
     * Create an instance of {@link ArchiveType }
     * 
     */
    public ArchiveType createArchiveType() {
        return new ArchiveType();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link DefaultFormat }
     * 
     */
    public DefaultFormat createDefaultFormat() {
        return new DefaultFormat();
    }

    /**
     * Create an instance of {@link DtedOptions }
     * 
     */
    public DtedOptions createDtedOptions() {
        return new DtedOptions();
    }

    /**
     * Create an instance of {@link BBOX }
     * 
     */
    public BBOX createBBOX() {
        return new BBOX();
    }

    /**
     * Create an instance of {@link ArchiveOptions }
     * 
     */
    public ArchiveOptions createArchiveOptions() {
        return new ArchiveOptions();
    }

    /**
     * Create an instance of {@link RpfOptions }
     * 
     */
    public RpfOptions createRpfOptions() {
        return new RpfOptions();
    }

    /**
     * Create an instance of {@link SrtmOptions }
     * 
     */
    public SrtmOptions createSrtmOptions() {
        return new SrtmOptions();
    }

    /**
     * Create an instance of {@link OutputType }
     * 
     */
    public OutputType createOutputType() {
        return new OutputType();
    }

    /**
     * Create an instance of {@link ListFile.ListFilePath }
     * 
     */
    public ListFile.ListFilePath createListFileListFilePath() {
        return new ListFile.ListFilePath();
    }

    /**
     * Create an instance of {@link ListFile.ListFileContents }
     * 
     */
    public ListFile.ListFileContents createListFileListFileContents() {
        return new ListFile.ListFileContents();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "mil:nga:getProducts", name = "requestResponse")
    public JAXBElement<RequestResponse> createRequestResponse(RequestResponse value) {
        return new JAXBElement<RequestResponse>(_RequestResponse_QNAME, RequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsWKTmessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "mil:nga:getProducts", name = "GetProductsWKTmessage")
    public JAXBElement<GetProductsWKTmessage> createGetProductsWKTmessage(GetProductsWKTmessage value) {
        return new JAXBElement<GetProductsWKTmessage>(_GetProductsWKTmessage_QNAME, GetProductsWKTmessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadProductsXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "mil:nga:downloadproductsxmlresponse", name = "downloadProductsXMLResponse")
    public JAXBElement<DownloadProductsXMLResponse> createDownloadProductsXMLResponse(DownloadProductsXMLResponse value) {
        return new JAXBElement<DownloadProductsXMLResponse>(_DownloadProductsXMLResponse_QNAME, DownloadProductsXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsUnitNamemessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "mil:nga:getProducts", name = "GetProductsUnitNamemessage")
    public JAXBElement<GetProductsUnitNamemessage> createGetProductsUnitNamemessage(GetProductsUnitNamemessage value) {
        return new JAXBElement<GetProductsUnitNamemessage>(_GetProductsUnitNamemessage_QNAME, GetProductsUnitNamemessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsAORJMPmessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "mil:nga:getProducts", name = "GetProductsAOR_JMPmessage")
    public JAXBElement<GetProductsAORJMPmessage> createGetProductsAORJMPmessage(GetProductsAORJMPmessage value) {
        return new JAXBElement<GetProductsAORJMPmessage>(_GetProductsAORJMPmessage_QNAME, GetProductsAORJMPmessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsBBOXmessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "mil:nga:getProducts", name = "GetProductsBBOXmessage")
    public JAXBElement<GetProductsBBOXmessage> createGetProductsBBOXmessage(GetProductsBBOXmessage value) {
        return new JAXBElement<GetProductsBBOXmessage>(_GetProductsBBOXmessage_QNAME, GetProductsBBOXmessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsCNTRYmessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "mil:nga:getProducts", name = "GetProductsCNTRYmessage")
    public JAXBElement<GetProductsCNTRYmessage> createGetProductsCNTRYmessage(GetProductsCNTRYmessage value) {
        return new JAXBElement<GetProductsCNTRYmessage>(_GetProductsCNTRYmessage_QNAME, GetProductsCNTRYmessage.class, null, value);
    }

}
