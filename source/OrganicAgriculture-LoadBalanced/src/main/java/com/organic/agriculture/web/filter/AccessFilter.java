package com.organic.agriculture.web.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.organic.agriculture.web.client.ComputeClient;


public class AccessFilter extends ZuulFilter {

	@Autowired
	ComputeClient computeClient;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Object accessToken = request.getParameter("accessToken");
		
//		String token = request.getParameter("token");
//		if ("POST".equalsIgnoreCase(request.getMethod())) {
//			try {
//				token = CharStreams.toString(request.getReader());
//			} catch (IOException e) {
//				token = null;
//			}
//	    }
//		if (token != null && token.length() > 0) {
//			ResponseEntity<String> resp = computeClient.authenticate(token);
//		}
		if (accessToken == null) {

			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

}
