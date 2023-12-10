package com.shoekream.bidding.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoekream.bidding.dao.BiddingDao;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;

public class BiddingService {
	
	
	// 구매하기
	public List<BiddingVo> buySelect(String productsNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BiddingDao dao = new BiddingDao();
		List<BiddingVo> voList = dao.buySelect(conn, productsNo);
	
		// close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	
	// 구매 상품 정보(판매입찰)
	public Map<String, Object> productList(BiddingVo vo) throws Exception{
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BiddingDao dao = new BiddingDao();
		
		Map<String, Object> m = new HashMap<String, Object>();
		
		// 구매하려는 최저가 상품 객체
		BiddingVo buyPrVo = dao.buyProductList(conn, vo);
		// 구매가가 너무 높아서 구매입찰하려는데 
		BiddingVo sellPrVo = dao.sellProductList(conn, vo);
			// 이렇게 하면 안됨.. el 의 forEach 도 향상된 포문이라..ㅠㅠ
			// 아마도 HashMap을 써야 할 것 같음 
			// Map<String, Object> 변수 = new HashMap<String, Object>();
		m.put("buyPrVo", buyPrVo);
		m.put("sellPrVo", sellPrVo);
	
		// close
		JDBCTemplate.close(conn);
		
		return m;
	}
	
}
