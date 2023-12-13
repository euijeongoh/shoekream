package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.dao.MyPageDao;
import com.shoekream.mypage.vo.BiddingDetailVo;
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.HistoryCntVo;
import com.shoekream.mypage.vo.OrderDetailVo;
import com.shoekream.mypage.vo.BuyingHistoryVo;
import com.shoekream.mypage.vo.WishListVo;
import com.shoekream.page.vo.PageVo;

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
	public List<BuyingHistoryVo> viewBuyingPendingList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<BuyingHistoryVo> pendList = dao.getBuyPendingInfo(conn, loginMember, map);
		
		// close
		JDBCTemplate.close(conn);
		
		return pendList;
		
	}
	
	// 구매완료 내역 조회
	public List<BuyingHistoryVo> viewBuyingFinishedList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<BuyingHistoryVo> finishedList = dao.getBuyFinishedInfo(conn, loginMember, map);
		
		// close
		JDBCTemplate.close(conn);
		
		return finishedList;
	}

	// 관심상품 목록 조회
	public List<WishListVo> viewWishListInfo(MemberVo loginMember, PageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<WishListVo> wishList = dao.getWishProductsInfo(conn, loginMember, pvo);
		
		// close
		JDBCTemplate.close(conn);
		
		return wishList;
	}

	// 판매 관련 cnt값들
	public HistoryCntVo getSellingCnts(MemberVo loginMember) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		int bidCnt = dao.getSellingBidCnt(conn, loginMember);
		int pendCnt = dao.getSellingPendCnt(conn, loginMember);
		int finishedCnt = dao.getSellingFinishedCnt(conn, loginMember);
		
		HistoryCntVo cntVo = new HistoryCntVo(bidCnt, pendCnt, finishedCnt);
		
		// close
		JDBCTemplate.close(conn);
		
		return cntVo;
	}

	// 판매입찰 내역
	public List<BiddingHistoryVo> viewSellingBiddingList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<BiddingHistoryVo> bidList = dao.getSellBiddingInfo(conn, loginMember, map);			
		
		// close
		JDBCTemplate.close(conn);
		
		return bidList;
	}

	
	
	// 마이페이지 메인
	public Map<String, Object> getMyPageMainInfo(MemberVo loginMember, PageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		//구매내역 cnt
		int buyBidCnt = dao.getBuyingBidCnt(conn, loginMember);
		int buyPendCnt = dao.getBuyingPendCnt(conn, loginMember);
		int buyFinishCnt = dao.getBuyingFinishedCnt(conn, loginMember);
		
		HistoryCntVo buyCntVo = new HistoryCntVo(buyBidCnt, buyPendCnt, buyFinishCnt);
		
		//판매내역 cnt
		int sellBidCnt = dao.getSellingBidCnt(conn, loginMember);
		int sellPendCnt = dao.getSellingPendCnt(conn, loginMember);
		int sellFinishCnt = dao.getSellingFinishedCnt(conn, loginMember);
		
		HistoryCntVo sellCntVo = new HistoryCntVo(sellBidCnt, sellPendCnt, sellFinishCnt);
		
		// 관심상품 리스트
		List<WishListVo> wishList = dao.getWishProductsInfo(conn, loginMember, pvo);
		
		
		// 데이터 뭉치기
		Map<String, Object> myMainMap = new HashMap<String, Object>();
		myMainMap.put("buyCntVo", buyCntVo);
		myMainMap.put("sellCntVo", sellCntVo);
		myMainMap.put("wishList", wishList);
		
		// close
		JDBCTemplate.close(conn);
		
		
		return myMainMap;
	}

	// 프로필 이미지 DB에 저장
	public int saveImgSrcInDB(MemberVo loginMember, HttpServletRequest req, String src) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		Map<String, Object> map = dao.saveImgSrcInDB(conn, loginMember, src);
		
		int result = (int) map.get("result");
		// tx
		if( result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		// session 업데이트
		loginMember.setProfileImage(src);
		req.getSession().setAttribute("loginMember", loginMember);
		
		
		return result;
	}

	// 판매 진행중 내역 조회
	public List<BuyingHistoryVo> viewSellingPendingList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<BuyingHistoryVo> pendList = dao.getSellPendingInfo(conn, loginMember, map);			
		
		// close
		JDBCTemplate.close(conn);
		
		return pendList;
	}

	// 판매 완료 내역 조회
	public List<BuyingHistoryVo> viewSellingFinishedList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<BuyingHistoryVo> finishList = dao.getSellFinishedInfo(conn, loginMember, map);			
		
		// close
		JDBCTemplate.close(conn);
		
		return finishList;
	}


	public int deleteWishItem(MemberVo loginMember, String productNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		int result = dao.deleteWishItem(conn, loginMember, productNo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// close
		JDBCTemplate.close(conn);
		
		return result;
	}


	public int getWishCnt(MemberVo loginMember) throws Exception{
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		int wishCnt = dao.getWishCnt(conn, loginMember);
		
		// close
		JDBCTemplate.close(conn);
		
		return wishCnt;
	}


	public int updateMemberInfo(HttpServletRequest req, MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		int result = dao.updateMemberInfo(conn, vo);
		
		// tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		// session loginMember update
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		loginMember.setId(vo.getId());
		loginMember.setPwd(vo.getPwd());
		loginMember.setNickname(vo.getNickname());
		loginMember.setEmail(vo.getEmail());
		
		req.getSession().setAttribute("loginMember", loginMember);
		
		return result;
	}

	// 구매입찰 내역 상세조회
	public BiddingDetailVo viewBiddingDetail(String bidNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		BiddingDetailVo vo = dao.selectBiddingDetail(conn, bidNo);
		
		// close
		JDBCTemplate.close(conn);
		
		return vo;
	}


	// 주문 상세내역 조회
//	public OrderDetailVo viewOrderDetail(String orderNo) {
//		// conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		// dao
//		MyPageDao dao = new MyPageDao();
//		OrderDetailVo vo = dao.getOrderDetail(conn, orderNo);
//		
//		// close
//		JDBCTemplate.close(conn);
//		
//		
//		return vo;
//	}





	


		

}
