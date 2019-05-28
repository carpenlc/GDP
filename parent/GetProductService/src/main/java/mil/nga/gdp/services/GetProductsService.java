package mil.nga.gdp.services;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.OperationFactory;
import mil.nga.gdp.RequestArchiveService;
import mil.nga.gdp.exceptions.IllegalTypeException;
import mil.nga.gdp.exceptions.InvalidParameterException;
import mil.nga.gdp.util.FileUtils;

/**
 * Entry point for the getProducts service.  
 * 
 * @author L. Craig Carpenter
 */
public class GetProductsService extends HttpServlet implements GDPConstantsI {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -947778029946334010L;
	
	/** 
	 * Set up the logging subsystem for use throughout the class
	 */
	static final Logger LOG = LoggerFactory.getLogger(
			GetProductsService.class);
	
	/**
	 * The doGet method will simply forward all calls to the doPost method
	 * which contains the logic for the <code>GetProductsService</code>.
	 */
	@Override
	public void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) {
		doPost(request, response);
	}
	
	/**
	 * 
	 */
	@Override
	public void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		long   startTime = System.currentTimeMillis();
		String requestID = FileUtils.generateUniqueToken(REQUEST_ID_LENGTH);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Request received.  Request ID => [ "
					+ requestID 
					+ " ].");
		}
		
		try {
			
			Map<String, String> inputParams = getInputParams(request);
			RequestArchiveService.getInstance().archiveRequest(inputParams, requestID);
			OperationFactory.getInstance().runOperation(inputParams);
			
		}
		catch (IllegalTypeException ite) {
			LOG.error("IllegalTypeException encountered while processing "
					+ "incoming request.  Error => [ "
					+ ite.getMessage()
					+ " ].");
		}
		catch (IllegalStateException ise) {
			LOG.error("IllegalStateException encountered while processing "
					+ "incoming request.  Error => [ "
					+ ise.getMessage()
					+ " ].");
		}
		catch (InvalidParameterException iipe) {
			LOG.error("InvalidParameterException encountered while "
					+ "processing the incoming request.  Error => [ "
					+ iipe.getMessage()
					+ " ].");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Request processed in [ "
					+ (System.currentTimeMillis() - startTime)
					+ " ] ms.");
		}
		
	}
	
	/**
	 * Extract the input parameters and store the key/values in a Map for
	 * further processing.  All keys are stored in lower case format.
	 * 
	 * @param request Incoming HTTP request object.
	 * @return All of the input parameters stored in a map object.
	 */
	private Map<String, String> getInputParams(HttpServletRequest request) 
			throws InvalidParameterException {
		Map<String, String> inputParams = new HashMap<String, String>();
		if (request != null) {
			if (request.getParameterNames() != null) {
				for (Enumeration<String> e = request.getParameterNames(); 
						e.hasMoreElements();) {
					String key = ((String)e.nextElement()).toLowerCase();
					String value = request.getParameter(key);
					inputParams.put(key, value);
				}
				LOG.info("Input request contained [ "
						+ inputParams.size()
						+ " ] parameters.");
			}
			else {
				throw new InvalidParameterException(
						"Client did not supply any input parameters.  The "
						+ "call to HttpServletRequest.getParameterNames() "
						+ "returned null.");
			}
		}
		else {
			throw new InvalidParameterException(
					"The input HttpServletRequest object is null.  This "
					+ "should never happen.");
		}
		return inputParams;
	}
	
	
}
