package com.shoekream.member.service;

import java.sql.Connection;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.member.dao.MemberDao;

public class MemberService {

	// 로그인
	public MemberVo login(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);
	
		// close
		JDBCTemplate.close(conn);
		
		return loginMember;
	}
	
	// 아이디 중복 체크
	public boolean checkIdDup(String memberId) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		boolean isDup = dao.checkIdDup(conn, memberId);
		
		// close
		JDBCTemplate.close(conn);
		
		return isDup;
	}

}
