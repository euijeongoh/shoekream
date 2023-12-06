package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.vo.BuyingListVo;
import com.shoekream.mypage.vo.HistoryCntVo;
import com.shoekream.mypage.vo.SellingListVo;

public class MyPageDao {

	// 구매내역 관련 cnt값들
	public HistoryCntVo getBuyingCnts(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String bidCntSql = "SELECT COUNT(*) CNT FROM BIDDING WHERE MEMBER_NO = ? AND BIDDING_POSITION_NO = 1 AND BIDDING_STATUS_NO = 1";
		String pendCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON B.NO = O.BIDDING_NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 1 AND NOT O.ORDERS_STATUS_NO=5";
		String finishedCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON B.NO = O.BIDDING_NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 1 AND O.ORDERS_STATUS_NO=5";
		
		PreparedStatement bidCntPstmt = conn.prepareStatement(bidCntSql);
		PreparedStatement pendCntPstmt = conn.prepareStatement(pendCntSql);
		PreparedStatement finishedCntPstmt = conn.prepareStatement(finishedCntSql);
		
		bidCntPstmt.setString(1, loginMember.getNo());
		pendCntPstmt.setString(1, loginMember.getNo());
		finishedCntPstmt.setString(1, loginMember.getNo());
		
		ResultSet rs1 = bidCntPstmt.executeQuery();
		ResultSet rs2 = pendCntPstmt.executeQuery();
		ResultSet rs3 = finishedCntPstmt.executeQuery();
		
		// rs
		int bidCnt = 0;
		int pendCnt = 0;
		int finishedCnt = 0;
		if(rs1.next()) {
			bidCnt = rs1.getInt("CNT");
		}
		
		if(rs2.next()) {
			pendCnt = rs2.getInt("CNT");
		}
		
		if(rs3.next()) {
			finishedCnt = rs3.getInt("CNT");
		}
		
		HistoryCntVo cntVo = new HistoryCntVo();
		cntVo.setCntBid(bidCnt);
		cntVo.setCntPend(pendCnt);
		cntVo.setCntFinished(finishedCnt);
		
		return cntVo;
	}
	
	// 판매내역 관련 cnt값들
	public HistoryCntVo getSellingCnts(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String bidCntSql = "SELECT COUNT(*) CNT FROM BIDDING WHERE MEMBER_NO = ? AND BIDDING_POSITION_NO = 2 AND BIDDING_STATUS_NO = 1";
		String pendCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON B.NO = O.BIDDING_NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND NOT O.ORDERS_STATUS_NO=5";
		String finishedCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON B.NO = O.BIDDING_NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND O.ORDERS_STATUS_NO=5";
		
		PreparedStatement bidCntPstmt = conn.prepareStatement(bidCntSql);
		PreparedStatement pendCntPstmt = conn.prepareStatement(pendCntSql);
		PreparedStatement finishedCntPstmt = conn.prepareStatement(finishedCntSql);
		
		bidCntPstmt.setString(1, loginMember.getNo());
		pendCntPstmt.setString(1, loginMember.getNo());
		finishedCntPstmt.setString(1, loginMember.getNo());
		
		ResultSet rs1 = bidCntPstmt.executeQuery();
		ResultSet rs2 = pendCntPstmt.executeQuery();
		ResultSet rs3 = finishedCntPstmt.executeQuery();
		
		// rs
		int bidCnt = 0;
		int pendCnt = 0;
		int finishedCnt = 0;
		if(rs1.next()) {
			bidCnt = rs1.getInt("CNT");
		}
		
		if(rs2.next()) {
			pendCnt = rs2.getInt("CNT");
		}
		
		if(rs3.next()) {
			finishedCnt = rs3.getInt("CNT");
		}
		
		HistoryCntVo cntVo = new HistoryCntVo();
		cntVo.setCntBid(bidCnt);
		cntVo.setCntPend(pendCnt);
		cntVo.setCntFinished(finishedCnt);
		
		return cntVo;
	}
	
	
	// 구매입찰 정보 조회(List)
	public List<BuyingListVo> getBuyBiddingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , B.PRICE 입찰희망가 , BS.BIDDING_STATUS 입찰상태 , B.EXPIRE_DATE 입찰마감기한 , B.ENROLL_DATE 입찰생성일 FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 1 ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		List<BuyingListVo> bidList = new ArrayList<BuyingListVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			int bidPrice = rs.getInt("입찰희망가");
			String bidStatus = rs.getString("입찰상태");
			String bidExpireDate = rs.getString("입찰마감기한");
			String bidEnrollDate = rs.getString("입찰생성일");
			
			BuyingListVo bidVo = new BuyingListVo();
			bidVo.setProductName(productName);
			bidVo.setProductImg(productImg);
			bidVo.setProductSize(productSize);
			bidVo.setBidPrice(bidPrice);
			bidVo.setBidStatus(bidStatus);
			bidVo.setBidExpireDate(bidExpireDate);
			bidVo.setBidEnrollDate(bidEnrollDate);
			
			bidList.add(bidVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return bidList;
	}
	
	// 진행중인 구매내역 정보 조회(List)
	public List<BuyingListVo> getBuyPendingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 1 AND NOT O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BuyingListVo> pendList = new ArrayList<BuyingListVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderStatus = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			
			BuyingListVo pendVo = new BuyingListVo();
			pendVo.setProductName(productName);
			pendVo.setProductImg(productImg);
			pendVo.setProductSize(productSize);
			pendVo.setOrderStatus(orderStatus);
			pendVo.setOrderDate(orderDate);
			
			pendList.add(pendVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pendList;
	}
	
	// 완료된 구매내역 정보 조회(List)
	public List<BuyingListVo> getBuyFinishedInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 , O.TOTAL_PRICE 결제금액 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 1 AND O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BuyingListVo> finishedList = new ArrayList<BuyingListVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderState = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			int finalPrice = rs.getInt("결제금액");
			
			BuyingListVo finishedVo = new BuyingListVo();
			finishedVo.setProductName(productName);
			finishedVo.setProductImg(productImg);
			finishedVo.setProductSize(productSize);
			finishedVo.setOrderStatus(orderState);
			finishedVo.setOrderDate(orderDate);
			finishedVo.setFinalPrice(finalPrice);
			
			finishedList.add(finishedVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return finishedList;
	}

	// 판매입찰 정보 조회(List)
	public List<SellingListVo> getSellBiddingInfo(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , B.PRICE 입찰희망가 , BS.BIDDING_STATUS 입찰상태 , B.EXPIRE_DATE 입찰마감기한 , B.ENROLL_DATE 입찰생성일 FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 2 ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<SellingListVo> sellList = new ArrayList<SellingListVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			int bidPrice = rs.getInt("입찰희망가");
			String bidStatus = rs.getString("입찰상태");
			String bidExpireDate = rs.getString("입찰마감기한");
			String bidEnrollDate = rs.getString("입찰생성일");
			
			SellingListVo sellVo = new SellingListVo();
			sellVo.setProductName(productName);
			sellVo.setProductImg(productImg);
			sellVo.setProductSize(productSize);
			sellVo.setBidPrice(bidPrice);
			sellVo.setBidStatus(bidStatus);
			sellVo.setBidExpireDate(bidExpireDate);
			sellVo.setBidEnrollDate(bidEnrollDate);
			
			sellList.add(sellVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return sellList;
	}

	// 진행중인 판매내역 정보 조회(List)
	public List<SellingListVo> getSellPendingInfo(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 2 AND NOT O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<SellingListVo> pendList = new ArrayList<SellingListVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderStatus = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			
			SellingListVo pendVo = new SellingListVo();
			pendVo.setProductName(productName);
			pendVo.setProductImg(productImg);
			pendVo.setProductSize(productSize);
			pendVo.setOrderStatus(orderStatus);
			pendVo.setOrderDate(orderDate);
			
			pendList.add(pendVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pendList;
	}
		
	// 완료된 판매내역 정보 조회(List)
	public List<SellingListVo> getFinishedInfo(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 2 AND O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<SellingListVo> finishedList = new ArrayList<SellingListVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderState = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			int finalPrice = rs.getInt("결제금액");
			
			SellingListVo finishedVo = new SellingListVo();
			finishedVo.setProductName(productName);
			finishedVo.setProductImg(productImg);
			finishedVo.setProductSize(productSize);
			finishedVo.setOrderStatus(orderState);
			finishedVo.setOrderDate(orderDate);
			finishedVo.setFinalPrice(finalPrice);
			
			finishedList.add(finishedVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return finishedList;
	}
	
	// 관심상품 정보 조회(List)
	

	
	// 즉시구매가
}
