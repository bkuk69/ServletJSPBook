<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("name");
		if(user == null){
			user = "Guest";
		}
	%>
	<h1>Hello <%=user %></h1>
</body>
</html>