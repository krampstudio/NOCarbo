package com.krampstudio.nopas.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.krampstudio.nopas.model.entities.Food;
import com.krampstudio.nopas.model.manager.FoodManager;

public class FoodServlet extends CommonServlet {

	private static final long serialVersionUID = -2652825230141405547L;
	
	private FoodManager foodMgr = new FoodManager();
	
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
		
				foodAdded = foodMgr.save(food);
				
			}
			this.model.put("foodAdded", foodAdded);
			
			this.sendJson(resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(doCheck(req, resp)){
			
			if(req.getParameter("term") != null){
				
				List<Food> results = new ArrayList<Food>();
				
				String term = req.getParameter("term").trim();
				if(term.length() >= 2){
				
					results = foodMgr.search(term);
				}
				
				this.sendJson(resp, results);
			}
		}
	}
}