package com.shoekream.bidding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.member.MemberVo;

public class BuySelectDao {

	public List<BiddingVo> buySelect(Connection conn, BiddingVo vo) throws Exception{
		// sql
		String sql = "";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, );
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BiddingVo> voList = new ArrayList<BiddingVo>();
		if(rs.next()) {

			BiddingVo dbVo = new BiddingVo();
		}
		
		return voList;
	}

}
