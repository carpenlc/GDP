package mil.nga.gdp.datasource;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.gdp.exceptions.InvalidParameterException;
import mil.nga.gdp.model.Item;

/**
 * This class implements the interface to the Gateway <code>GDP.PRODUCTS</code> 
 * table.  
 * 
 * @author L. Craig Carpenter
 */
public class ProductFactory {

	/** 
	 * Set up the logging subsystem for use throughout the class
	 */
	static final Logger LOG = LoggerFactory.getLogger(
			ProductFactory.class);
	
	/**
	 * Number of elapsed milliseconds before the internal product list 
	 * needs to be refreshed.
	 */
	private static final long REFRESH_NEEDED = 24 * 60 * 60 * 1000;
	
	/**
	 * Complete list of products from the GDP.PRODUCTS table.
	 */
	private List<Item> productList;
	
	/**
	 * The last time the in-memory product list was refreshed.
	 */
	private Date lastRefresh;
	
	/**
	 * Get the amount of time that has elapsed since the last product refresh.
	 * @return The amount of time in milliseconds that have elapsed since the 
	 * last refresh of the product list.
	 */
	private long getElapsedTime() {
		long elapsedTime = 0;
		if (lastRefresh != null) {
			elapsedTime = System.currentTimeMillis() - lastRefresh.getTime();
		}
		return elapsedTime;
	}
	
	/**
	 * Check to see if the in-memory product list needs to be refreshed.
	 * @return True if the in-memory list needs to be refreshed.
	 */
	private boolean needsRefresh() {
		if ((lastRefresh == null) ||
			(getElapsedTime() == 0) || 
			(getElapsedTime() > REFRESH_NEEDED)) {
			return true;
		}
		return false;
	}
	
	
	private List<Item> refresh() {
		
	}
	
	public List<Item> getProductList() {
		long startTime = System.currentTimeMillis();
		if (needsRefresh()) {
			LOG.info("Refreshing product list.");
			
			lastRefresh = new Date();
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Product list refreshed in [ " 
					+ (System.currentTimeMillis() - startTime)
					+ " ] ms.");
		}
		return productList;
	}
	
	/**
	 * This method is largely migrated from the legacy GDP code.  It really 
	 * just ensures that if a product String comes in with mixed case it can 
	 * be matched to an existing product type.
	 * 
	 * @param questionable The input product string.
	 * @return The prodTag value matching the input string.  If no match is 
	 * found the method returns null.
	 */
	public String getProductTag(String questionable) 
			throws InvalidParameterException {
		
		String productString = null;
		
		if ((questionable != null) && (!questionable.isEmpty())) {
			List<Item> products = getProductList();
			if (products != null) {
				for (Item product : products) {
					if (product.getProdTag().equalsIgnoreCase(questionable)) {
						productString = product.getProdTag();
					}
				}
			}
			else {
				LOG.error("Unable to obtain the list of available product types.");
			}
		}
		else {
			throw new InvalidParameterException("Input product is null or "
					+ "not defined.  Product type must be populated.");
		}
		
		return productString;
	}
	
}
