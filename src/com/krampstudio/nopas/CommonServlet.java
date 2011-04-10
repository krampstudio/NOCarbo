package com.krampstudio.nopas;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class CommonServlet extends HttpServlet {

	/**
	 * serial number
	 */
	private static final long serialVersionUID = -5439371229763395655L;

	
	boolean checkToken(HttpServletRequest request){
		if(request.getParameter("token") != null){
			
		}
		return false;
	}
}
