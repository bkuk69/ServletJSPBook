<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입 페이지입니다.</h3>
	<form action="memberProc.jsp" method="post">
		ID: <input type="text" name="id" ><br>
		암호: <input type="password" name="password"><br>
		이름: <input type="text" name="name"><br>
		E-mail:<input type="text" name="mail"><br>
		<input type="submit" value="가입"><br>
	</form>
</body>
</html>