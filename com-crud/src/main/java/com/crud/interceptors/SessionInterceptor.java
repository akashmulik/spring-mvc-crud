package com.crud.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	private final Log log = LogFactory.getLog(this.getClass());
	private String SESSION_ID;

	public SessionInterceptor() {
		super();
	}

	public SessionInterceptor(String SESSION_ID) {
		super();
		this.SESSION_ID = SESSION_ID;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		
/*		log.info(request.getContextPath());
		log.info(request.getRequestURI());*/
		String url = request.getRequestURI().substring(request.getContextPath().length());
		log.info(url);
		
		if(url.equals("/login") || url.equals("/logout") || url.equals("/signup") || url.contains("/resources")) {
			return true;
		} 
			HttpSession session = request.getSession(false);
			
			if(session == null) {
				log.info("SESSION IS NULL");
				response.setHeader("session-info", "expired");
				//request.getRequestDispatcher("login").forward(request, response);
				response.sendRedirect("login");
				return false;
			}
			if(session.getAttribute("userID") == null) {
				log.info("SESSION ID NULL");
				session.invalidate();
				response.setHeader("session-info", "invalid");
				request.getRequestDispatcher("login").forward(request, response);
			//	response.sendRedirect("login");
				return false;
			} else {
				log.info("USER ID --->>> "+session.getAttribute("userID"));
				return true;
			}
	}

}
