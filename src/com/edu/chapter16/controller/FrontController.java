package com.edu.chapter16.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String charset = null;
	
	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig sc) {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/chapter16/memberInsert.do", new MemberInsertController());
		list.put("/chapter16/memberSearch.do", new MemberSearchController());
		list.put("/chapter16/memberUpdate.do", new MemberUpdateController());
		list.put("/chapter16/memberDelete.do", new MemberDeleteController());
		list.put("/chapter16/memberList.do", new MemberListController());
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding(charset);
		String url = req.getRequestURI();
		
		String contextPath = req.getContextPath();
		
		String path = url.substring(contextPath.length());
	
		Controller subController = list.get(path);
	
		subController.execute(req, resp);
	}
}
