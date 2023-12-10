package com.shoekream.bidding.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoekream.bidding.dao.BiddingDao;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.biddingVo.TestVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AddrBookVo;
import com.shoekream.orders.vo.OrdersVo;
import com.shoekream.product.vo.ProductInfoVo;

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
	
	
	
	
	
		
	// 입찰 상품 정보 조회
	public BiddingVo productInfo(BiddingVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BiddingDao dao = new BiddingDao();
		BiddingVo dbVo = dao.productInfo(conn, vo);
	
		// close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}
	// 상품 정보 조회
	public ProductInfoVo productInfo(String no) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BiddingDao dao = new BiddingDao();
		ProductInfoVo infoVo = dao.productInfo(conn, no);
		
		// close
		JDBCTemplate.close(conn);
		
		return infoVo;
	}
	
	






	// 최종 주문 정보 조회
	public Map<String, Object> resultInfo(String loginMemberNo) throws Exception{
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BiddingDao dao = new BiddingDao();
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 주소록, 계좌, 카드 정보
		AddrBookVo addInfo = dao.addInfo(conn, loginMemberNo);
		TestVo accInfo = dao.accInfo(conn, loginMemberNo);
		TestVo cardInfo = dao.cardInfo(conn, loginMemberNo);
		result.put("addInfo", addInfo);
		result.put("accInfo", accInfo);
		result.put("cardInfo", cardInfo);
			
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}





	// 주문 정보 조회
	public OrdersVo ordersInfo(String memberNo, String biddingNo, String productsNo) throws Exception{
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BiddingDao dao = new BiddingDao();
		System.out.println("에러확인 ordersInfo Service");
		OrdersVo ordersVo = dao.ordersInfo(conn, memberNo, biddingNo, productsNo);
		
		// close
		JDBCTemplate.close(conn);
		System.out.println("에러확인 ordersInfo Dao -> Service");
		return ordersVo;
	}





	// 주문 정보 입력
	public int orders(String loginMemberNo, String biddngNo, String productsNo) throws Exception{
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		BiddingDao dao = new BiddingDao();
		System.out.println("에러확인 orders Service");
		int result = dao.orders(conn, loginMemberNo, biddngNo, productsNo);
		
		// close
		JDBCTemplate.close(conn);
		System.out.println("에러확인 orders Dao -> Service");
		
		return result;
	}





}
