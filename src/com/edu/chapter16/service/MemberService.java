package com.edu.chapter16.service;


import java.util.ArrayList;

import com.edu.chapter16.dao.MemberDAO;
import com.edu.chapter16.vo.MemberVO;

public class MemberService {

	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();
	
	
	private MemberService() {
		
	}
	
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
		
	}

	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);
		return member;
	}

	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
		
	}

	public void memberDelete(String id) {
		dao.memberDelete(id);
		
	}
	
	public ArrayList<MemberVO> memberList(){
		return dao.memberList();
	}

}
