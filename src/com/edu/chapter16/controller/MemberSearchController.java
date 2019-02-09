package com.edu.chapter16.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.chapter16.service.MemberService;
import com.edu.chapter16.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = null;
		if(job.equals("search")) {
			path="/chapter16/memberSearch.jsp";
		}else if(job.equals("update")) {
			path="/chapter16/memberUpdate.jsp";
		}else if(job.equals("delete")) {
			path="/chapter16/memberDelete.jsp";
		}
		if(id.isEmpty()) {
			req.setAttribute("error", "ID를 입력하지 않았습니다. 다시 입력해주시기 바랍니다.");
			HttpUtil.forward(req, resp, path);
			return ;
		}
		
		//Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);
		
		if(member == null) req.setAttribute("result", "검색된 정보가 없습니다.");
		
		req.setAttribute("member", member);
		if(job.equals("search")) {
			path ="/chapter16/memberSearchOutput.jsp";
			
		}
		HttpUtil.forward(req, resp, path);
	}

}
