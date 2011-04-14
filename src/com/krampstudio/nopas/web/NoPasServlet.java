package com.krampstudio.nopas.web;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.krampstudio.nopas.model.Food;
import com.krampstudio.nopas.model.PMF;

public class NoPasServlet extends CommonServlet {
	
	private static final long serialVersionUID = 5328786455104325630L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		initToken(req);
		resp.sendRedirect("views/index.jsp");
		
		/*
		
		PersistenceManager pm = PMF.getPersistenceManager();
		
		  Food f = new Food();
		  f.setName("Petits lus");
		  f.setBrand("LU");
		  f.setDescription("Gateaux secs");

        try {
            pm.makePersistent(f);
        } 
        finally {
            pm.close();
        }
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");*/
	}
	
}
