<%@page import="java.util.ArrayList"%>
<%@page import="com.edu.chapter16.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<%
		ArrayList<MemberVO> members = (ArrayList<MemberVO>)request.getAttribute("list");
		if(!members.isEmpty()){%>
			<table border="1">
			<tr><th>ID</th><th>암호</th><th>이름</th><th>메일주소</th></tr>
			<% 
				for(MemberVO member:members){%>
				<tr>
					<td><%=member.getId() %></td>
					<td><%=member.getPassword() %></td>
					<td><%=member.getName() %></td>
					<td><%=member.getMail() %></td>
				</tr>
				<% }
			%>
			
	<% 	}else{
		out.print("<h3>등록된 회원정보가 없습니다.</h3>");
	}
	%>
	</table>
	<%@ include file="home.jsp" %>
</body>
</html>