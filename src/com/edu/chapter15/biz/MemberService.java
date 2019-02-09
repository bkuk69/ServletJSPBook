package com.edu.chapter15.biz;

import com.edu.chapter15.beans.Member;
import com.edu.chapter15.dao.MemberDAO;
import com.edu.chapter16.vo.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public void insertMember(Member member) {
		dao.insert(member);
	}

	
}
