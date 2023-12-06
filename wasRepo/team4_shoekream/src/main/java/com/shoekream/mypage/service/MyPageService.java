package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.dao.MyPageDao;
import com.shoekream.mypage.vo.BuyingListVo;
import com.shoekream.mypage.vo.HistoryCntVo;

public class MyPageService {
	
	// 구매내역 구매입찰 정보 띄우기
	public List<BuyingListVo> viewBuyingBidList(MemberVo loginMember, Map<String, String> map) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		MyPageDao dao = new MyPageDao();
		List<BuyingListVo> bidList = dao.getBuyBiddingInfo(conn, loginMember, map);
		
		// close
		JDBCTemplate.close(conn);
		
		return bidList;
	}

	// 구매내역 cnt 값
	public HistoryCntVo getBuyingCnts(MemberVo loginMember, Map<String, String> map) throws Exception {
		return null;
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
	
	
}
