package com.krampstudio.nopas.model.manager;

import java.util.ArrayList;
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
	 * Search food by name
	 * @param term the stating by term
	 * @return the list of matching food
	 */
	@SuppressWarnings("unchecked")
	public List<Food> search(String term){
		List<Food> results = new ArrayList<Food>();
		PersistenceManager pm = PMF.getPersistenceManager();
		Query query = pm.newQuery(Food.class);
	    query.setFilter("this.name.startsWith(labelParam)");
	    query.declareParameters("java.lang.String labelParam");

	    log.info("Query : " + query.toString());
	    
	    try {
			for(Food food : (List<Food>) query.execute(term)){
				results.add(food);
			}
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
		if(food.getKey() != null){
			return this.update(food);
		}
		return this.add(food);
	}
	
	/**
	 * 
	 * @param food
	 * @return 
	 */
	private boolean add(Food food){
		
		boolean returnValue = false;
		
		PersistenceManager pm = PMF.getPersistenceManager();
	    try {
	    	pm.makePersistent(food);
	    	returnValue  = (food.getKey().getId() > 0);
	    } 
	    finally {
	    	pm.close();
	    }
		
		return returnValue;
	}
	
	private boolean update(Food food){
		
		return false;
	}
}
