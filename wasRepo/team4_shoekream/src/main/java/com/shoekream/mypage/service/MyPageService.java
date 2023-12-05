package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.dao.MyPageDao;
import com.shoekream.mypage.vo.BuyingListVo;
import com.shoekream.mypage.vo.SellingListVo;

public class MyPageService {

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
