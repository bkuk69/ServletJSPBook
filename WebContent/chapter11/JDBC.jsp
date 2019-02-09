<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	//1. JDBC 드라이버 로딩하기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//2. DB 서버 접속하기
	String url= "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	
	//3. Statement or PreparedStatement 객체 생성하기
	//Statement stmt = conn.createStatement();
	
	String id = request.getParameter("id");
	String pwd =request.getParameter("pwd"); 
	//4. SQL 실행
	String sql = "insert into test values(?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, pwd);
	pstmt.executeUpdate();
	Statement stmt = conn.createStatement();
	sql ="select * from test";
	stmt.executeUpdate(sql);
	ResultSet rs = stmt.executeQuery(sql);

	while(rs.next()){
		out.print("<br>" + rs.getString("id") + " : " + rs.getString(2));
	}
	//5. 자원해제
	rs.close(); 
	stmt.close();
	pstmt.close();
	conn.close();
	%>

,   