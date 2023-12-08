package com.shoekream.bidding.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.bidding.dao.BuySelectDao;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;

public class BuySelectService {
	
	// 로그인
	public List<BiddingVo> buySelect(String productsNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BuySelectDao dao = new BuySelectDao();
		List<BiddingVo> voList = dao.buySelect(conn, productsNo);
	
		// close
		JDBCTemplate.close(conn);
		
		return voList;
	}
	
}
