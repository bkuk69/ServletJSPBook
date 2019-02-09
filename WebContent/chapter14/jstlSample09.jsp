<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
Parameter : ${param.name }<br>
<form action="jstlSample09.jsp" method="post">
	이름: <input type="text" name="name">
	<input type="submit" value="전송">
</form>
</body>
</html>