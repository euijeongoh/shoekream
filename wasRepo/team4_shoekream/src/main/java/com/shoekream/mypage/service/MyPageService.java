package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.dao.MyPageDao;
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.HistoryCntVo;
import com.shoekream.mypage.vo.OrdersHistoryVo;
import com.shoekream.mypage.vo.WishListVo;
import com.shoekream.orders.vo.OrdersVo;

public class MyPageService {
	
	// 구매내역 cnt값, 구매입찰 내역 정보
	public BiddingHistoryVo viewBuyingBiddingList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		HistoryCntVo cntVo = dao.getBuyingCnts(conn, loginMember);
		List<BiddingVo> bidList = dao.getBuyBiddingInfo(conn, loginMember, map);			

		
		// dto(BiddingHistoryVo)로 데이터 뭉치기
		BiddingHistoryVo historyVo = new BiddingHistoryVo(bidList, cntVo);
		
		
		// close
		JDBCTemplate.close(conn);
		
		return historyVo;
	}
	
	public BiddingHistoryVo viewBuyingBiddingList(MemberVo loginMember) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		HistoryCntVo cntVo = dao.getBuyingCnts(conn, loginMember);
		List<BiddingVo> bidList = dao.getBuyBiddingInfo(conn, loginMember);			

		
		// dto(BiddingHistoryVo)로 데이터 뭉치기
		BiddingHistoryVo historyVo = new BiddingHistoryVo(bidList, cntVo);
		
		
		// close
		JDBCTemplate.close(conn);
		
		return historyVo;
	}
	
	// 구매내역 cnt값, 구매진행중 내역
	public OrdersHistoryVo viewBuyingPendingList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		HistoryCntVo cntVo = dao.getBuyingCnts(conn, loginMember);
		
		List<OrdersVo> bidList = dao.getBuyPendingInfo(conn, loginMember, map);		
		
		// dto(BiddingHistoryVo)로 데이터 뭉치기
		OrdersHistoryVo historyVo = new OrdersHistoryVo(bidList, cntVo);
		
		
		// close
		JDBCTemplate.close(conn);
		
		return historyVo;
	}
	
	// 구매내역 cnt값, 구매완료 내역
	public OrdersHistoryVo viewBuyingFinishedList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		HistoryCntVo cntVo = dao.getBuyingCnts(conn, loginMember);
		
		List<OrdersVo> bidList = dao.getBuyFinishedInfo(conn, loginMember, map);		
		
		// dto(BiddingHistoryVo)로 데이터 뭉치기
		OrdersHistoryVo historyVo = new OrdersHistoryVo(bidList, cntVo);
		
		
		// close
		JDBCTemplate.close(conn);
		
		return historyVo;
	}
	// 구매내역 정보 
//	public Map<String, Object> getMyPageMainInfo(MemberVo loginMember) throws Exception {
//		// conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		// dao
//		MyPageDao dao = new MyPageDao();
//		// 구매내역 정보
//		List<BuyingListVo> buyList = dao.getBuyingInfo(conn, loginMember);
//		// 판매내역 정보
//		List<SellingListVo> sellList = dao.getSellingInfo(conn, loginMember);
//		// 관심상품 정보
//		
//		// 전달map
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("buyList", buyList);
//		map.put("sellList", sellList);
//		
//		return map;
//	}
	
	// 관심상품 목록 조회
	public List<WishListVo> viewWishListInfo(MemberVo loginMember) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<WishListVo> wishList = dao.getWishProductsInfo(conn, loginMember);
		
		// close
		JDBCTemplate.close(conn);
		
		return wishList;
	}

//	public HistoryCntVo getBuyingCnts(MemberVo loginMember) {
//		// conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		// dao
//		MyPageDao dao = new MyPageDao();
//		int bidCnt = dao.getBiddingCnt(conn, loginMember);
////		int pendCnt = dao.getPendingCnt(conn, loginMember);
////		int finishedCnt = dao.getFinishedCnt(conn, loginMember);
//		
////		HistoryCntVeo cntVo = new HistoryCntVo(bidCnt, pendCnt, finishedCnt);
//		
//		// close
//		JDBCTemplate.close(conn);
//		
////		return cntVo;
//	}

	
	
}
