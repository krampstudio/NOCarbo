package com.krampstudio.nopas.model.manager;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.krampstudio.nopas.model.entities.Food;
import com.krampstudio.nopas.model.entities.PMF;

/**
 * Enables you to manage Food entities
 * @author Bertrand Chevrier <chevrier.bertrand@gmail.com>
 */
public class FoodManager extends Manager{

	/**
	 * Get all the foods (paginated and ordered by name)
	 * @param start
	 * @param end
	 * @return the list of foods
	 */
	@SuppressWarnings("unchecked")
	public List<Food> getAll(int start, int end){
		
		List<Food> results = null;
		
		PersistenceManager pm = PMF.getPersistenceManager();
		Query query = pm.newQuery(Food.class);
		query.setRange(start, end);
		query.setOrdering("name asc");
		
		 log.info("Query : " + query.toString());
		
		try {
			results = (List<Food>) query.execute();
	    } 
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally {
	        query.closeAll();
	    }
		return results;
	}
	
	/**
	 * conveniance method that retrieve the 1st 100 foods
	 * @see FoodManager#getAll(int, int)
	 * @return the list of foods
	 */
	public List<Food> getAll(){
		return this.getAll(0, 100);
	}
	
	/**
	 * Search food by name
	 * @param term the stating by term
	 * @return the list of matching food
	 */
	@SuppressWarnings("unchecked")
	public List<Food> search(String term){
		List<Food> results = null;
		PersistenceManager pm = PMF.getPersistenceManager();
		Query query = pm.newQuery(Food.class);
	    query.setFilter("this.name.startsWith(labelParam)");
	    query.declareParameters("java.lang.String labelParam");

	    log.info("Query : " + query.toString());
	    
	    try {
	    	results = (List<Food>) query.execute(term);
	    } 
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally {
	        query.closeAll();
	    }
		return results;
	}
	
	/**
	 * Save a food entity
	 * @param food the entity to save
	 * @return true if saved
	 */
	public boolean save(Food food){
		boolean returnValue = false;
		
		PersistenceManager pm = PMF.getPersistenceManager();
	    try {
	    	pm.makePersistent(food);
	    	returnValue  = (food.getKey() != null);
	    } 
	    finally {
	    	pm.close();
	    }
		
		return returnValue;
	}
}
