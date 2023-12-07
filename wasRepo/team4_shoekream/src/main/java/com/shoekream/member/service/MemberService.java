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
		
		// 내 프로필, 거래내역, 관심상품, 리뷰 게시물, 미사용 보유 포인트 등의 정보가 사라지게 되며 
		// 재가입을 하더라도 복구가 불가능합니다.
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

}
