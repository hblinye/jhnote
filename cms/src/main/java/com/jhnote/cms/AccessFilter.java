package com.jhnote.cms;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*" }, filterName = "accessFilter")
public class AccessFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String[] allowDomains = {
			"http://localhost:8080"
		};
		String originHeads = req.getHeader("Origin");
		Set<String> allowOrigins = new HashSet<String>(Arrays.asList(allowDomains));
		if (allowOrigins.contains(originHeads)) {
			res.setHeader("Access-Control-Allow-Origin", originHeads);
		}
		res.setHeader("Access-Control-Allow-Credentials","true");
        res.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept,mid,X-Token");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
	}

}
