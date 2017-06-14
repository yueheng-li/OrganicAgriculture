package com.organic.agriculture.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
		
		String token = request.getParameter("token");
		if (token != null && token.length() > 0) {
			ResponseEntity<String> resp = computeClient.authenticate(token);
		}
		if (accessToken == null) {

			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return 10002;
		}
		return 200;
	}

}
