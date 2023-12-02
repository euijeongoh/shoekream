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
			String phone = rs.getString("PHONE");
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
			loginMember.setPhone(phone);
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

}
