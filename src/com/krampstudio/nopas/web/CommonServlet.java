package com.krampstudio.nopas.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.krampstudio.nopas.utils.TokenGenerator;

public class CommonServlet extends HttpServlet {
	
	/**
	 * serial number
	 */
	private static final long serialVersionUID = -5439371229763395655L;
	
	/**
	 * instantiate the app logger
	 */
	protected static final Logger log = Logger.getLogger(CommonServlet.class.getName());


	/**
	 * the current token
	 */
	private String token;
	
	/**
	 * The model map of the servlet data
	 */
	protected Map<String, Object> model = new HashMap<String, Object>();
	
	/**
	 * Get the model map
	 * @return the model map
	 */
	protected Map<String, Object> getModel(){
		return this.model;
	}
	
	/**
	 * Initialize the session token
	 * @param request
	 */
	protected void initToken(HttpServletRequest request){
		if(this.token == null){
			HttpSession session = request.getSession(true);
			if(session.getAttribute("token") == null){
				session.setAttribute("token", TokenGenerator.generateToken());
			}
			this.token = (String)session.getAttribute("token");
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
			return (sentToken.equals(this.token) && this.token != null);
		}
		return false;
	}

	/**
	 * Check if the current request contains a valid token
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	protected void doCheck(HttpServletRequest request, HttpServletResponse resp) throws IOException{
		initToken(request);
		if(!checkToken(request)){
			log.info("\nToken prob:\n" + this.token + "\n"+request.getParameter("token"));
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Security issue");
		}
	}
	
	/**
	 * Serialize the model map to a Json string and send it!
	 * @param resp
	 * @throws IOException
	 */
	protected void sendJson(HttpServletResponse resp) throws IOException{
		this.sendJson(resp, getModel());
	}

	protected void sendJson(HttpServletResponse resp, Object data) throws IOException{
		resp.setContentType("text/json");
		String json = new Gson().toJson(data);
		log.info("JSON : " + json);
		resp.getWriter().print(json);
	}
}