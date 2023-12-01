package com.shoekream.member.service;

import java.sql.Connection;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.member.dao.MemberDao;

public class MemberService {

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

}
