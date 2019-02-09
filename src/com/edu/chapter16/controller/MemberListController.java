package com.edu.chapter16.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.chapter16.service.MemberService;
import com.edu.chapter16.vo.MemberVO;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVO> list = service.memberList();
		
		req.setAttribute("list", list);
		System.out.println("a");
		HttpUtil.forward(req, resp, "/chapter16/memberListOutput.jsp");
		System.out.println("b");
	}

}
