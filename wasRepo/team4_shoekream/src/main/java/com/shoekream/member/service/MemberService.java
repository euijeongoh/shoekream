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
		boolean nameOk = vo.getName().matches("[ㄱ-ㅣ가-힣]{2,5}");
		if(!nameOk) {
			throw new Exception("이름 형식");
		}
		// 아이디 중복 체크
		MemberDao dao = new MemberDao();
		boolean idDup = dao.checkIdDup(conn, vo.getId());
		if(idDup==true) {
			throw new Exception("아이디 중복");
		}
		// 아이디 6자 이상
		if(vo.getId().length() <6) {
			throw new Exception("아이디 길이 6자 미만");
		}
		
		// 비밀번호 정규표현식 검사
		boolean pwdOk = vo.getPwd().matches("[ㄱ-ㅣ가-힣]{2,5}");
		if(!pwdOk) {
			throw new Exception("이름 형식");
		}
		
		// 비밀번호 일치 확인
		boolean pwdSame = vo.getPwd().equals(vo.getPwd2());
		if(!pwdSame) {
			throw new Exception("비밀번호 일치여부 문제");
		}
		
		// 닉네임 3-5자 사이 한글
		boolean nickOk = vo.getNickname().matches("[ㄱ-ㅣ가-힣]{3,5}");
		if(!nickOk) {
			throw new Exception("닉네임 형식 문제");
		}
		
		// 이메일 중복 체크
		boolean emailDup = dao.checkEmailDup(conn, vo.getEmail());
		if(emailDup==true) {
			throw new Exception("이메일 중복");
		}
		
		// 이메일 유효성 체크
		boolean emailOk = vo.getNickname().matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
		if(!emailOk) {
			throw new Exception("이메일 형식문제");
		}

		// 회원가입 작업
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
