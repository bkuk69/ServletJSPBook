package com.edu.chapter07;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterOne implements Filter {

	public void init(FilterConfig config) {
		System.out.println("init() 호출 ...... One");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter() 호출전........One");
		chain.doFilter(req, resp);
		
		System.out.println("doFilter() 호출 후....... One");

	}
	
	public void destroy() {
		System.out.println("destroy() 호출 ......One");
	}

}
