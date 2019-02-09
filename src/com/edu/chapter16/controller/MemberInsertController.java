package com.edu.chapter16.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.chapter16.service.MemberService;
import com.edu.chapter16.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		//유효성 체크
		if(id.isEmpty() || password.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다.");
			HttpUtil.forward(req, resp, "/insertMember.do");
			return ;
		}
		
		//VO 객체 생성
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setMail(mail);
		
		//Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		//Output View로 이동
		req.setAttribute("id", id);
		HttpUtil.forward(req, resp,"/chapter16/memberOutput.jsp" );
				

	}

}
