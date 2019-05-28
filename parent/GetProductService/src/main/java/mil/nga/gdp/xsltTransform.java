package mil.nga.egmc.xslt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Michael Koblents
 */
public class xsltTransform {

    public static String xmlToJsonTransform(String source) throws TransformerException, TransformerConfigurationException
    {
        String sourceXLST = "/mil/nga/egmc/xslt/xml-to-json.xsl";
        //String sourceXLST = "/mil/nga/egmc/xslt/xml_json.xsl";
        //XSLT
        InputStream in_xslt = xsltTransform.class.getResourceAsStream(sourceXLST);
        StreamSource xslt = new StreamSource(in_xslt);
        //input
        StreamSource input= new StreamSource( new ByteArrayInputStream(source.getBytes()));
        //output
        ByteArrayOutputStream out_stream = new ByteArrayOutputStream();
        StreamResult output = new StreamResult(out_stream);
        //transform
        //USE SAXON for handling XSLT v2
       //System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer transformer = tfactory.newTransformer(xslt);
        transformer.transform(input, output);

        return out_stream.toString();
    }
}
