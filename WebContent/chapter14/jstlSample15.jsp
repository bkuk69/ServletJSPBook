<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="myoracle" 
		driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
		user="scott"
		password="tiger"
	/>
	<sql:query var="rs" dataSource="${myoracle}">
		select * from test
	</sql:query>
	<table>
<%-- 		<tr>
			<c:forEach var="columName" items="${rs.columNames }">
				<th><c:out value="${columnName }"/></th>
			</c:forEach>
		</tr> --%>
		<c:forEach var="row" items="${rs.rows }">
			<tr>
				<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.pwd}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>