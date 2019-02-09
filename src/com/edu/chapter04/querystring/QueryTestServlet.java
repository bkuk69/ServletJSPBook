package com.edu.chapter04.querystring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 질의문자열</title></head>");
		out.print("<body>");
		out.print("<h1>Get 방식으로 요청되었습니다.</h1>");

		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");

		out.print("ID : " + id +"<br/>");
		out.print("암호 : " + password +"<br/>");
		out.print("이름 : " + name +"<br/>");
		out.print("취미: <br/>");
		for(String hobby : hobbies) {
			out.print(hobby +" <br/>");
		}
		out.print("<br/>");
		out.print("성별 : " + gender+"<br/>");
		out.print("종교 : " + religion + "<br/>");
		out.print("자기소개 : " + introduction +"<br/>");
		
		out.print("전체 질의문자열: " + req.getQueryString()+"<br/>");
		out.print("</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 질의문자열</title></head>");
		out.print("<body>");
		out.print("<h1>POST 방식으로 요청되었습니다.</h1>");

		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");

		out.print("ID : " + id +"<br/>");
		out.print("암호 : " + password +"<br/>");
		out.print("이름 : " + name +"<br/>");
		out.print("취미: <br/>");
		for(String hobby : hobbies) {
			out.print(hobby +" <br/>");
		}
		out.print("<br/>");
		out.print("성별 : " + gender+"<br/>");
		out.print("종교 : " + religion + "<br/>");
		out.print("자기소개 : " + introduction +"<br/>");
		
		out.print("전체 질의문자열: " + req.getQueryString()+"<br/>");
		out.print("</body></html>");
		out.close();
	}
}
