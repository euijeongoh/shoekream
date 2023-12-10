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

	public int quit(MemberVo loginMember) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		// 탈퇴 가능 여부 확인
		boolean canQuit = dao.checkPenaltyYn(conn, loginMember);
		
		int quitNo = 0;
		if(canQuit) {
			int result = dao.updateStatus(conn, loginMember);
			
			// tx
			if(result==1) {
				quitNo = 1; // update 작업 성공
				JDBCTemplate.commit(conn);
			} else {
				quitNo = -1; // update 작업 실패
				JDBCTemplate.rollback(conn);
			}
			
		} else {
			quitNo = -2; // 패널티로 인해 탈퇴가 불가능한 회원
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return quitNo;
	}

	public boolean checkEmailDup(String email) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		boolean isDup = dao.checkEmailDup(conn, email);
		
		// close
		JDBCTemplate.close(conn);
		
		return isDup;
	}

	public MemberVo searchId(String email) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.searchId(conn, email);
		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int join(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// business logic
		// 이름 한글 2-5자
		
		// 아이디 중복 체크
		
		// 아이디 6자 이상
		
		// 비밀번호 정규표현식 검사
		
		// 닉네임 3-5자 사이 한글
		
		// 이메일 중복 체크
		
		// 이메일 유효성 체크
		
		// dao
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
