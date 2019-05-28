package mil.nga.gdp.services;

import org.slf4j.LoggerFactory;

import mil.nga.gdp.GDPConstantsI;
import mil.nga.gdp.exceptions.ServiceUnavailableException;
import mil.nga.gdp.model.Item;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class implementing the logic required query the back-end data source.
 * 
 * @author L. Craig Carpenter
 */
public class ProductsService implements GDPConstantsI, Closeable {

	/**
	 * Set up the Log4j system throughout the class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ProductsService.class);
	
	/**
	 * JPA Entity manager object used throughout the class.
	 */
	private EntityManager em;
	
	/**
	 * Default no-arg constructor.
	 */
	public ProductsService() {}
	
	/**
	 * Accessor method for theh EntityManager object that will be used for 
	 * interacting with the backing data store.
	 * 
	 * @return The JPA EtityManager
	 * @throws ServiceUnavailableException Thrown if we cannot start the 
	 * JPA subsystem.
	 */
	private EntityManager getEntityManager() 
			throws ServiceUnavailableException {
		if (em == null) {
			LOG.warn("Injected EntityManger is null.  Creating un-managed "
					+ "EntityManager.");
			EntityManagerFactory emFactory = 
					Persistence.createEntityManagerFactory(
							APPLICATION_PERSISTENCE_CONTEXT);
			if (emFactory != null) {
				em = emFactory.createEntityManager();
			}
			else {
				throw new ServiceUnavailableException("Unable to start the "
						+ "JPA subsystem.  Unable to create the "
						+ "EntityManagerFactory.");
			}
			if (em == null) {
				throw new ServiceUnavailableException("Unable to start the "
						+ "JPA subsystem.  Unable to create the "
						+ "EntityManager.");
			}
		}
		return em;
	}
	
	/**
	 * Retrieve the list of products matching the input native SQL query.
	 * 
	 * @return The entire list of products stored in the back-end data store.
	 */
	public List<Item> getProducts(String nativeSQL) 
			throws ServiceUnavailableException {
		
		long startTime = System.currentTimeMillis();
		
		List<Item> products = new ArrayList<Item>();
		try {
			
			if ((nativeSQL != null) && (!nativeSQL.isEmpty())) {
				
				products = getEntityManager()
						.createNativeQuery(nativeSQL, Item.class)
						.getResultList();
			
				if (LOG.isDebugEnabled()) {
					LOG.debug("Native SQL query [ "
							+ nativeSQL
							+ " ] completed in [ "
							+ (System.currentTimeMillis() - startTime)
							+ " ] ms.");
				}
			}
			else {
				LOG.error("Client provided null or empty native SQL query "
						+ "command.  Resulting List<Item> will be empty.");
			}
		}
		catch (NoResultException nre) {
			LOG.warn("No products returned from [ "
					+ nativeSQL 
					+ " ] query. ");
		}
		return products;
	}
	
	/**
	 * Retrieve the entire product list from the back-end data store.
	 * @return The entire list of products stored in the back-end data store.
	 */
	public List<Item> getProducts() throws ServiceUnavailableException {
		
		long startTime = System.currentTimeMillis();
		
		List<Item> products = new ArrayList<Item>();
		try {
			
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Item> cq = cb.createQuery(Item.class);
			Root<Item> root = cq.from(Item.class);
			CriteriaQuery<Item> all = cq.select(root);
			TypedQuery<Item> allQuery = getEntityManager().createQuery(all);
			products = allQuery.getResultList();
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("Selected [ "
						+ products.size()
						+ " ] products from database in [ "
						+ (System.currentTimeMillis() - startTime)
						+ " ] ms.");
			}
		}
		catch (NoResultException nre) {
			LOG.warn("No products returned from 'SELECT *' command.");
		}
		return products;
	}
	
	/**
	 * Implementation of the <code>close()</code> method required by the 
	 * <code>Closeable</code> interface used to close database references.
	 */
	public void close() {
		if (em != null) {
			em.close();
		}
	}
	
}
