package com.krampstudio.nopas.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krampstudio.nopas.model.Food;
import com.krampstudio.nopas.model.PMF;

public class GetFoodServlet extends CommonServlet {

	private static final long serialVersionUID = -2652825230141405547L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(doCheck(req, resp)){
		
			List<Food> results = new ArrayList<Food>();
			
			if(req.getParameter("term") != null){
			
				String term = req.getParameter("term").trim();
				if(term.length() >= 2){
				
					PersistenceManager pm = PMF.getPersistenceManager();
					Query query = pm.newQuery(Food.class);
				    query.setFilter("this.name.startsWith(:term)");
			
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
				}
			}
			this.sendJson(resp, results); 
		}
	}
}