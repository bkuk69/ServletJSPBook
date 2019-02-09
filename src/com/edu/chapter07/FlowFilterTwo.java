package com.edu.chapter07;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterTwo implements Filter {
	String charset;
	public void init(FilterConfig config) {
		System.out.println("init() 호출 ...... Two");
		charset = config.getInitParameter("en");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding(charset);
		System.out.println("doFilter() 호출전........Two");
		chain.doFilter(req, resp);
		
		System.out.println("doFilter() 호출 후....... Two");

	}
	
	public void destroy() {
		System.out.println("destroy() 호출 ......Two");
	}


}
