package com.korea.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿은 서블릿 컨테이너가 관리하도록 web.xml에 등록하거나  @WebServlet("/name") 형태로 등록해야 한다.
@WebServlet("/boardServlet")
public class GetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		try {
			//1. Driver 로드 함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			//2. 연결 객체 만들기 conn hr/hr
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("연결 성공");
			
			//3. 쿼리 관리 객체 생성하기, 쿼리 준비
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			
			
			//4. 쿼리에 관련된 변수 값 세팅
			
			//5. 실행. 그리고 결과값을 받아 처리하는 객체 생성(엔터에 해당함)
				//select 문은 executeQuery();  --> ResultSet객체 반환
				//insert, update, delete --> executeUpdate --> Int 값 반환
			rs = pstmt.executeQuery();
			
			//파일의 타입과 문자 코딩을 PrintWriter 객체 전에 기술
			response.setContentType("text/html; charset=utf-8");
			
			
			
			//Html파일을 만들기 위한 sTream객체 생성후에 html파일 생성
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>게시판</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3 align=center>게시판</h3>");
			out.println("<table border=1 width=700 align=center");
			out.println("<tr>");
			out.println("<th>번호</th>");
			out.println("<th width=450>타이틀</th>");
			out.println("<th>날짜</th>");
			out.println("<th>작성자</th>");
			out.println("<th>조회수</th>");
			out.println("</tr>");
			
			
			
			//6. 쿼리 결과를 처리하여 표시
			while(rs.next()) {
				//rs는 꺼내온 한 출에 대한 값을 컬럼명 또는 인덱스로 저장
				//각 컬럼의 값은 getXXX("컬럼명") 형태. XXX는 타입
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String nickname = rs.getString("nickname");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int cnt = rs.getInt("cnt");
				String userid = rs.getString("userid");
				
				//도스창 출력
				System.out.println(seq + "\t" + title + "\t" + nickname +"\t" + content + "\t" + regdate +"\t" + cnt + "\t" + userid);
				
				//html출력
				out.println("<tr>");
				out.println("<td>"+ seq +"</td>");
				out.println("<td width=450>" + title +"</td>");
				out.println("<td>" + regdate + "</td>");
				out.println("<td>" + nickname + "</td>");
				out.println("<td>" + cnt +"</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			
			// 7. 사용한 자원을 닫는다.
			//Connection, PreparedStatement, ResultSet 객체를 나중에 사용한 것부터 닫는다.
			try {
				if(rs != null) {
				rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
