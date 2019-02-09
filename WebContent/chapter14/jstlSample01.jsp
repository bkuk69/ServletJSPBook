<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.edu.chapter13.BookBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="name" value="Amy" />
	<c:out value="${name }"/><br>
	<c:remove var="name"/>
	<c:out value="${name }"/><br>
	
	<%
		BookBean book = new BookBean("The Secret","Byrne, Rhonda", "Atria Books");
		request.setAttribute("bookOne", book);
		
	%>
	<c:set var="title" value="${bookOne.title}" /><br>
	<c:out value="${title }"/>
	
	<c:set var="author" value="${bookOne.author }" /><br>
	<c:out value="${author }"/>
	
	<c:set var="publisher" value="${bookOne.publisher }" /><br>
	<c:out value="${publisher }"/><br>

	<c:set var="name">Tobey</c:set>
	<c:out value="${name}"/><br>
	
	<% 
		BookBean book2 = new BookBean("The Last Lecture", "Randy Pausch", "hyperion");
		request.setAttribute("bookTwo", book2);
	%>
	<c:set var="title">${bookTwo.title }</c:set>
	<c:out value="${title}"/><br>
	
	<c:set var="author"> <%=book2.getAuthor() %></c:set>
	<c:out value="${author}"/><br>
</body>
</html>