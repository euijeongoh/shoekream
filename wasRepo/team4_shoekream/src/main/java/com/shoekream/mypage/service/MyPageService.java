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
	
	// 구매내역 관련 cnt값
	public HistoryCntVo getBuyingCnts(MemberVo loginMember) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		int bidCnt = dao.getBuyingBidCnt(conn, loginMember);
		int pendCnt = dao.getBuyingPendCnt(conn, loginMember);
		int finishedCnt = dao.getBuyingFinishedCnt(conn, loginMember);
		
		HistoryCntVo cntVo = new HistoryCntVo(bidCnt, pendCnt, finishedCnt);
		
		// close
		JDBCTemplate.close(conn);
		
		return cntVo;
	}
	
	
	// 구매입찰 내역 정보
	public List<BiddingHistoryVo> viewBuyingBiddingList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<BiddingHistoryVo> bidList = dao.getBuyBiddingInfo(conn, loginMember, map);			
		
		// close
		JDBCTemplate.close(conn);
		
		return bidList;
	}

	// 구매 진행중 내역 정보
	public List<OrdersHistoryVo> viewBuyingPendingList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<OrdersHistoryVo> pendList = dao.getBuyPendingInfo(conn, loginMember, map);
		
		// close
		JDBCTemplate.close(conn);
		
		return pendList;
		
	}
	
	// 구매완료 내역 조회
	public List<OrdersHistoryVo> viewBuyingFinishedList(MemberVo loginMember, Map<String, String> map) throws Exception {
		return null;
	}

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

	// 마이페이지 메인
	public Map<String, Object> getMyPageMainInfo(MemberVo loginMember) {
		
		
		
		return null;
	}


	


		

}
