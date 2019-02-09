<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource var="myoracle"
	driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
	user="scott"
	password="tiger"
/>
<sql:transaction dataSource="${myoracle}" >
	<sql:update>
		update dept set loc='LOS ANGELES' where deptno=10
	</sql:update>
	<sql:update>
		insert into dept values(50, 'MARKETING','SEATTLE')
	</sql:update>
</sql:transaction>

<sql:query var="rs" dataSource="${myoracle}">
	select * from dept
</sql:query>

<table border="1">
	<tr>
		<th>DEPTNO</th><th>DNAME</th><th>Location</th>
	</tr>
	<c:forEach var="row" items="${rs.rows}">
		<tr>
			<td><c:out value="${row.deptno }" /></td>
			<td><c:out value="${row.dname }" /></td>
			<td><c:out value="${row.loc }" /></td>
		</tr>
	</c:forEach>
</table>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>