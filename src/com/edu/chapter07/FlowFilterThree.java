package com.edu.chapter07;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="timer", urlPatterns= {"/third"})
public class FlowFilterThree implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		System.out.println("수행시간 : " + executeTime + " ms");
				
	}

}
