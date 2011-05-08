package com.krampstudio.nopas.web;

import java.io.IOException;

import javax.servlet.http.*;

public class NoPasServlet extends CommonServlet {
	
	private static final long serialVersionUID = 5328786455104325630L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		initToken(req);
		resp.sendRedirect("views/index.jsp");
		
	}
	
}
