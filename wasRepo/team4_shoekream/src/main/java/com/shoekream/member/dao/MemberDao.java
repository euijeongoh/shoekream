package com.shoekream.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;

public class MemberDao {

	public MemberVo login(Connection conn, MemberVo vo) throws Exception {
		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		MemberVo loginMember = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nickname = rs.getString("NICKNAME");
			String email = rs.getString("EMAIL");
			String joinDate = rs.getString("JOIN_DATE");
			String delYn = rs.getString("DEL_YN");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String point = rs.getString("POINT");
			String penaltyYn = rs.getString("PENALTY_YN");
			
			loginMember = new MemberVo();
			loginMember.setNo(no);
			loginMember.setName(name);
			loginMember.setId(id);
			loginMember.setPwd(pwd);
			loginMember.setNickname(nickname);
			loginMember.setEmail(email);
			loginMember.setJoinDate(joinDate);
			loginMember.setDelYn(delYn);
			loginMember.setProfileImage(profileImage);
			loginMember.setPoint(point);
			loginMember.setPenaltyYn(penaltyYn);
		}
		
		return loginMember;
	}

	public boolean checkIdDup(Connection conn, String memberId) throws Exception {
		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		boolean isDup = false;
		if(rs.next()) {
			isDup = true;
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		System.out.println(isDup);
		return isDup;
	}

	public boolean checkEmailDup(Connection conn, String email) throws Exception {
		// sql
		String sql = "SELECT EMAIL FROM MEMBER WHERE EMAIL=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		// rs
		boolean isDup = false;
		if(rs.next()) {
			isDup = true;
		}
		
		return isDup;
	}

	public int updateStatus(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "UPDATE MEMBER SET DEL_YN='Y' WHERE NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public MemberVo searchId(Connection conn, String email) throws Exception {
		// sql
		String sql = "SELECT ID FROM MEMBER WHERE EMAIL = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null; 
		if(rs.next()) {
			String id = rs.getString("ID");
			
			vo = new MemberVo();
			
			vo.setId(id);
		}
		
		return vo;
	}

	// 패널티 여부 확인
	public boolean checkPenaltyYn(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT PENALTY_YN FROM MEMBER WHERE NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		String penaltyYn = null;
		if(rs.next()) {
			penaltyYn = rs.getString("PENALTY_YN");
		}
		
		boolean canQuit = false;
		if(penaltyYn.equals('N')) {
			canQuit = true;
		}
		
		return canQuit;
	}

	// 회원가입
	public int join(Connection conn, MemberVo vo) throws Exception {
		// sql
		String sql = "INSERT INTO MEMBER(NO, NAME, ID, PWD, NICKNAME, EMAIL) VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getId());
		pstmt.setString(3, vo.getPwd());
		pstmt.setString(4, vo.getNickname());
		pstmt.setString(5, vo.getEmail());
		
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
	
		return result;
	}

}
