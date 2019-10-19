package com.eye.op.common.handler;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;


public class SpecialCharacterFilter implements Filter {

	private static final Logger logger = Logger.getLogger(SpecialCharacterFilter.class);
	
	private static List<String> specialCharacters;

	public static List<String> getSpecialCharacters() {
		return specialCharacters;
	}

	public static void setSpecialCharacters(List<String> specialCharacters) {
		SpecialCharacterFilter.specialCharacters = specialCharacters;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (!ServletFileUpload.isMultipartContent(req)) {
			Map<String, String[]> params = req.getParameterMap();
			for (Entry<String, String[]> kvpair : params.entrySet()) {
				String[] vals = kvpair.getValue();
				if (vals != null && vals.length > 0) {
					for (String val : vals) {
						System.out.println(val);
						if (hasSpecialChar(val)) {
							logger.error("[SPECIALCHAR] " + kvpair.getKey() + " : " + val);
							response.setContentType("application/json");
							response.setCharacterEncoding("UTF-8");
							Map<String,String> map = new HashMap<String, String>();
							map.put("result", "error");
							map.put("msg", val+"中包含特殊字符");
							JSONObject responseJSONObject = JSONObject.fromObject(map);
							PrintWriter out = response.getWriter();
							out.print(responseJSONObject.toString());
							out.flush();
				            out.close();
							return;
						}
					}					
				}
			}
		}
		chain.doFilter(req, res);
	}
	

	public boolean hasSpecialChar(String val) {
		for (String errflag : specialCharacters) {
			if (val.contains(errflag) || val.contains(errflag.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
