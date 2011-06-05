package com.krampstudio.nopas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krampstudio.nopas.model.entities.Food;
import com.krampstudio.nopas.model.entities.FoodCategory;
import com.krampstudio.nopas.model.manager.FoodManager;

/**
 * 
 * @author Bertrand Chevrier <chevrier.bertrand@gmail.com>
 */
public class FoodServlet extends CommonServlet {

	private static final long serialVersionUID = -2652825230141405547L;
	
	/**
	 * 
	 */
	private FoodManager foodMgr = new FoodManager();
	
	
	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(doCheck(req, resp)){

			boolean foodAdded = false;
			
			if(req.getParameter("food-name") != null){
				
				Food food = new Food();
		
				food.setName(req.getParameter("food-name"));
				food.setBrand(req.getParameter("food-brand"));
				food.setDescription(req.getParameter("food-description"));
				food.setCategory(FoodCategory.valueOf(req.getParameter("food-category")));
		
				foodAdded = foodMgr.save(food);
				
			}
			this.model.put("foodAdded", foodAdded);
			
			this.sendJson(resp);
		}
	}
	
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(doCheck(req, resp)){
			
			List<Food> foods = null;
			
			//get one
			if(req.getParameter("food-key") != null){
				
			}
			
			//search
			else if(req.getParameter("term") != null){
				
				String term = req.getParameter("term").trim();
				if(term.length() >= 2){
				
					foods = foodMgr.search(term);
				}
			}
			
			//list / get all
			else{
				foods = foodMgr.getAll();
			}
		
			this.sendJson(resp, foods);
		}
	}
}