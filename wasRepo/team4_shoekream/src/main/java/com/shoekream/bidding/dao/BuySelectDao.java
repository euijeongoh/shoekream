package com.shoekream.bidding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.member.MemberVo;

public class BuySelectDao {

	public List<BiddingVo> buySelect(Connection conn, BiddingVo vo) {
		// sql
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BiddingVo> voList = new ArrayList<BiddingVo>();
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
			
			BiddingVo dbVo = new BiddingVo();
			dbVo.setNo(no);
			dbVo.setName(name);
			dbVo.setId(id);
			dbVo.setPwd(pwd);
			dbVo.setNickname(nickname);
			dbVo.setPhone(phone);
			dbVo.setJoinDate(joinDate);
			dbVo.setDelYn(delYn);
			dbVo.setProfileImage(profileImage);
			dbVo.setPoint(point);
			dbVo.setPenaltyYn(penaltyYn);
		}
		
		return voList;
	}

}
