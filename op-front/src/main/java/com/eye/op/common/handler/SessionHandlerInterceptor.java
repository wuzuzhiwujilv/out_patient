package com.eye.op.common.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eye.op.common.bean.User;
import com.eye.op.common.utils.Constant;

public class SessionHandlerInterceptor implements HandlerInterceptor{
	private static Logger logger = Logger.getLogger(SessionHandlerInterceptor.class); 

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(request.getRequestURL().toString());
		logger.info(request.getRequestURL().toString());
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int port = request.getServerPort();
		String path = request.getContextPath();
		String basePath = scheme + "://" + serverName + ":" + port + path;
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(basePath);
			return false;
		}
		User user = (User) session.getAttribute(Constant.SESSION_USER);
		if (user == null) {
			response.sendRedirect(basePath);
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
