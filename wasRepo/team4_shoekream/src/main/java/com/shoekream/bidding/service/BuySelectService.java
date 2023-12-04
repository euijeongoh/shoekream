package com.shoekream.bidding.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.bidding.dao.BuySelectDao;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.member.dao.MemberDao;

public class BuySelectService {
	
	// 로그인
	public BiddingVo buySelect(BiddingVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BuySelectDao dao = new BuySelectDao();
		List<BiddingVo> voList = dao.buySelect(conn, vo);
	
		// close
		JDBCTemplate.close(conn);
		
		return null;
	}
	
}
