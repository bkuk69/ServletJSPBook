<%@page import="com.edu.chapter15.biz.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="member" class="com.edu.chapter15.beans.Member"/>
	<jsp:setProperty property="*" name="member"/>
	
	<%
		MemberService service = new MemberService();
		service.insertMember(member);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
		rd.forward(request, response);
	%>