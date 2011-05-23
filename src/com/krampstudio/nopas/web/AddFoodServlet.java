package com.krampstudio.nopas.web;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krampstudio.nopas.model.Food;
import com.krampstudio.nopas.model.PMF;

public class AddFoodServlet extends CommonServlet {

	private static final long serialVersionUID = -5417413037327897867L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(doCheck(req, resp)){

			boolean foodAdded = false;
			
			PersistenceManager pm = PMF.getPersistenceManager();
			
			if(req.getParameter("food-name") != null){
				
				Food f = new Food();
				f.setName(req.getParameter("food-name"));
				f.setBrand(req.getParameter("food-brand"));
				f.setDescription(req.getParameter("food-description"));
		
			    try {
			    	pm.makePersistent(f);
			    	this.model.put("food-id", f.getKey().getId());
			    	foodAdded = true;
			    } 
			    finally {
			    	pm.close();
			    }
			    
			    
			}
			this.model.put("foodAdded", foodAdded);
			
			this.sendJson(resp);
		}
	}

	
}
