package com.edu.chapter16.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.chapter16.service.MemberService;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);

		HttpUtil.forward(req, resp, "/chapter16/memberDeleteOutput.jsp");

	}

}
