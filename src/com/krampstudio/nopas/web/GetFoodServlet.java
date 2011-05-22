package com.krampstudio.nopas.web;

import java.io.IOException;
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doCheck(req, resp);
		
		if(req.getParameter("term") != null){
		
			String term = req.getParameter("term");
			if(term.length() > 2){
			
				PersistenceManager pm = PMF.getPersistenceManager();
				Query query = pm.newQuery(Food.class);
			    query.setFilter("name == nameParam");
			    query.declareParameters("String nameParam");
		
			    log.info("Query : " + query.toString());
			    
			    try {
			        @SuppressWarnings("unchecked")
					List<Food> results = (List<Food>) query.execute(term);
			        if (!results.isEmpty()) {
			        	this.sendJson(resp, results); 
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
	}

	
}
