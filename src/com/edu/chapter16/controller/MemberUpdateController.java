package com.edu.chapter16.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.chapter16.service.MemberService;
import com.edu.chapter16.vo.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		if(id.isEmpty() || password.isEmpty() || name.isEmpty()|| mail.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력하세요");
			HttpUtil.forward(req, resp, "/chapter16/memberUpdate.jsp");
			return ;
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setMail(mail);
		
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		req.setAttribute("id", id);
		HttpUtil.forward(req, resp, "/chapter16/memberUpdateOutput.jsp");

	}

}
