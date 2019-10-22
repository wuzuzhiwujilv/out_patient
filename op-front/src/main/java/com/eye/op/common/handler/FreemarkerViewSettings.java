package com.eye.op.common.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class FreemarkerViewSettings extends FreeMarkerView {
	@Override
	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int port = request.getServerPort();
		String path = request.getContextPath();
		String basePath = scheme + "://" + serverName + ":" + port + path;
		model.put("ctx", basePath);
		super.exposeHelpers(model, request);
	}
}
