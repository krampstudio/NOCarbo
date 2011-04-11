package com.krampstudio.nopas.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.krampstudio.nopas.utils.TokenGenerator;

public class CommonServlet extends HttpServlet {
	
	/**
	 * serial number
	 */
	private static final long serialVersionUID = -5439371229763395655L;

	/**
	 * the current token
	 */
	private String token;
	
	/**
	 * Initialize the session token
	 * @param request
	 */
	private void initToken(HttpServletRequest request){
		if(token == null){
			HttpSession session = request.getSession(true);
			if(session.getAttribute("token") == null){
				session.setAttribute("token", TokenGenerator.generateToken());
			}
			token = (String)session.getAttribute("token");
		}
	}
	
	/**
	 * Check if the sent token is the right one
	 * @param request
	 * @return boolean
	 */
	private boolean checkToken(HttpServletRequest request){
		if(request.getParameter("token") != null){
			String sentToken = request.getParameter("token");
			return (sentToken == token && token != null);
		}
		return false;
	}

	/**
	 * Check if the current request contains a valid token
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	protected void doCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		initToken(req);
		if(!checkToken(req)){
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Security issue");
		}
	}

}