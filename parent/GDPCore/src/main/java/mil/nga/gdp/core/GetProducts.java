
package mil.nga.gdp.core;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GetProducts", targetNamespace = "mil:nga:getProducts")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GetProducts {


    /**
     * 
     * @param parameters
     * @return
     *     returns mil.nga.gdp.core.RequestResponse
     */
    @WebMethod
    @WebResult(name = "requestResponse", targetNamespace = "mil:nga:getProducts", partName = "result")
    public RequestResponse getProductsBbox(
        @WebParam(name = "GetProductsBBOXmessage", targetNamespace = "mil:nga:getProducts", partName = "parameters")
        GetProductsBBOXmessage parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns mil.nga.gdp.core.RequestResponse
     */
    @WebMethod
    @WebResult(name = "requestResponse", targetNamespace = "mil:nga:getProducts", partName = "result")
    public RequestResponse getProductsWkt(
        @WebParam(name = "GetProductsWKTmessage", targetNamespace = "mil:nga:getProducts", partName = "parameters")
        GetProductsWKTmessage parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns mil.nga.gdp.core.RequestResponse
     */
    @WebMethod
    @WebResult(name = "requestResponse", targetNamespace = "mil:nga:getProducts", partName = "result")
    public RequestResponse getProductsUnit(
        @WebParam(name = "GetProductsUnitNamemessage", targetNamespace = "mil:nga:getProducts", partName = "parameters")
        GetProductsUnitNamemessage parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns mil.nga.gdp.core.RequestResponse
     */
    @WebMethod
    @WebResult(name = "requestResponse", targetNamespace = "mil:nga:getProducts", partName = "result")
    public RequestResponse getProductsCNTRY(
        @WebParam(name = "GetProductsCNTRYmessage", targetNamespace = "mil:nga:getProducts", partName = "parameters")
        GetProductsCNTRYmessage parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns mil.nga.gdp.core.RequestResponse
     */
    @WebMethod
    @WebResult(name = "requestResponse", targetNamespace = "mil:nga:getProducts", partName = "result")
    public RequestResponse getProductsAorJmp(
        @WebParam(name = "GetProductsAOR_JMPmessage", targetNamespace = "mil:nga:getProducts", partName = "parameters")
        GetProductsAORJMPmessage parameters);

}
