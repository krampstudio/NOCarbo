package com.krampstudio.nopas;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class NoPasServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
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
		resp.getWriter().println("Hello, world");
	}
}
