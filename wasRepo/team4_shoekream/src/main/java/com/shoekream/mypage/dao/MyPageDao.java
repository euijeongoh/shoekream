package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.HistoryCntVo;
import com.shoekream.mypage.vo.WishListVo;
import com.shoekream.orders.vo.OrdersVo;

public class MyPageDao {

	
	
	
	// 판매내역 관련 cnt값들
	public HistoryCntVo getSellingCnts(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String bidCntSql = "SELECT COUNT(*) FROM BIDDING B WHERE MEMBER_NO = ? AND BIDDING_POSITION_NO = 1";
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
	
	// 구매입찰 정보 조회(List) - 기간
	public List<BiddingHistoryVo> getBuyBiddingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , B.PRICE 입찰희망가 , BS.BIDDING_STATUS 입찰상태 , B.EXPIRE_DATE 입찰마감기한 , B.ENROLL_DATE 입찰생성일 FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 1 AND B.ENROLL_DATE BETWEEN ? AND ? ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, periodMap.get("startDate"));
		pstmt.setString(3, periodMap.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		List<BiddingHistoryVo> bidList = new ArrayList<BiddingHistoryVo>();
		while(rs.next()) {
			String shoeName = rs.getString("상품명");
			String shoeImg = rs.getString("썸네일");
			String shoeSize = rs.getString("사이즈");
			String bidPrice = rs.getString("입찰희망가");
			String bidStatus = rs.getString("입찰상태");
			String bidExpireDate = rs.getString("입찰마감기한");
			String bidEnrollDate = rs.getString("입찰생성일");
			
			BiddingHistoryVo bidVo = new BiddingHistoryVo();
			bidVo.setShoeName(shoeName);
			bidVo.setShoeImg(shoeImg);
			bidVo.setShoeSize(shoeSize);
			bidVo.setBidPrice(bidPrice);
			bidVo.setBidStatus(bidStatus);
			bidVo.setExpireDate(bidExpireDate);
			bidVo.setEnrollDate(bidEnrollDate);
			
			bidList.add(bidVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return bidList;
	}
	
	// 진행중인 구매내역 정보 조회(List)
	public List<OrdersVo> getBuyPendingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 1 AND NOT O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersVo> pendList = new ArrayList<OrdersVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderStatus = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			
			OrdersVo pendVo = new OrdersVo();
			pendVo.setProductName(productName);
//			pendVo.setProductImg(productImg);
//			pendVo.setProductSize(productSize);
			pendVo.setOrdersStatus(orderStatus);
			pendVo.setOrdersDate(orderDate);
			
			pendList.add(pendVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pendList;
	}
	
	// 완료된 구매내역 정보 조회(List)
	public List<OrdersVo> getBuyFinishedInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 , O.TOTAL_PRICE 결제금액 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 1 AND O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersVo> finishedList = new ArrayList<OrdersVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderState = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			int finalPrice = rs.getInt("결제금액");
			
			OrdersVo finishedVo = new OrdersVo();
//			finishedVo.setProductName(productName);
//			finishedVo.setProductImg(productImg);
//			finishedVo.setProductSize(productSize);
//			finishedVo.setOrderStatus(orderState);
//			finishedVo.setOrderDate(orderDate);
//			finishedVo.setFinalPrice(finalPrice);
			
			finishedList.add(finishedVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return finishedList;
	}

	// 판매입찰 정보 조회(List)
	public List<BiddingVo> getSellBiddingInfo(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , B.PRICE 입찰희망가 , BS.BIDDING_STATUS 입찰상태 , B.EXPIRE_DATE 입찰마감기한 , B.ENROLL_DATE 입찰생성일 FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 2 ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BiddingVo> sellList = new ArrayList<BiddingVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			int bidPrice = rs.getInt("입찰희망가");
			String bidStatus = rs.getString("입찰상태");
			String bidExpireDate = rs.getString("입찰마감기한");
			String bidEnrollDate = rs.getString("입찰생성일");
			
			BiddingVo sellVo = new BiddingVo();
//			sellVo.setProductName(productName);
//			sellVo.setProductImg(productImg);
//			sellVo.setProductSize(productSize);
//			sellVo.setBidPrice(bidPrice);
//			sellVo.setBidStatus(bidStatus);
//			sellVo.setBidExpireDate(bidExpireDate);
//			sellVo.setBidEnrollDate(bidEnrollDate);
			
			sellList.add(sellVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return sellList;
	}

	// 진행중인 판매내역 정보 조회(List)
	public List<OrdersVo> getSellPendingInfo(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 2 AND NOT O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersVo> pendList = new ArrayList<OrdersVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderStatus = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			
			OrdersVo pendVo = new OrdersVo();
//			pendVo.setProductName(productName);
//			pendVo.setProductImg(productImg);
//			pendVo.setProductSize(productSize);
//			pendVo.setOrderStatus(orderStatus);
//			pendVo.setOrderDate(orderDate);
			
			pendList.add(pendVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pendList;
	}
		
	// 완료된 판매내역 정보 조회(List)
	public List<OrdersVo> getFinishedInfo(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT P.NAME 상품명 , IMG.THUMBNAIL 썸네일 , SS.SHOES_SIZES 사이즈 , OS.ORDERS_STATUS 주문상태 , O.ORDERS_DATE 주문일자 FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON PS.PRODUCT_NO = P.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 2 AND O.ORDERS_STATUS_NO = 5 ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersVo> finishedList = new ArrayList<OrdersVo>();
		while(rs.next()) {
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			String productSize = rs.getString("사이즈");
			String orderState = rs.getString("주문상태");
			String orderDate = rs.getString("주문일자");
			int finalPrice = rs.getInt("결제금액");
			
			OrdersVo finishedVo = new OrdersVo();
//			finishedVo.setProductName(productName);
//			finishedVo.setProductImg(productImg);
//			finishedVo.setProductSize(productSize);
//			finishedVo.setOrderStatus(orderState);
//			finishedVo.setOrderDate(orderDate);
//			finishedVo.setFinalPrice(finalPrice);
			
			finishedList.add(finishedVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return finishedList;
	}

	// 관심상품 정보 조회(List)
	public List<WishListVo> getWishProductsInfo(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String productSql = "SELECT BR.BRAND_NAME 브랜드 , P.NO 상품번호 , P.NAME 상품명 , IMG.THUMBNAIL 썸네일 FROM WISHLIST W LEFT JOIN PRODUCTS P ON W.PRODUCTS_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BRAND BR ON P.BRAND_NO = BR.NO WHERE W.MEMBER_NO = ?";
		String priceSql = "SELECT MIN(B.PRICE) 즉시구매가 FROM BIDDING B WHERE B.BIDDING_POSITION_NO = 2 AND B.PRODUCTS_NO = ?";
		PreparedStatement pstmt1 = conn.prepareStatement(productSql);
		pstmt1.setString(1, loginMember.getNo());
		ResultSet rs = pstmt1.executeQuery();
		
		List<WishListVo> productList = new ArrayList<WishListVo>();
		while(rs.next()) {
			String brandName = rs.getString("브랜드");
			String productNo = rs.getString("상품번호");
			String productName = rs.getString("상품명");
			String productImg = rs.getString("썸네일");
			
			WishListVo wishVo = new WishListVo();
			
			wishVo.setBrandName(brandName);
			wishVo.setProductName(productName);
			wishVo.setProductNo(productNo);
			wishVo.setProductImg(productImg);
			
			productList.add(wishVo);
		}
		
		for(int i = 0; i<productList.size(); ++i) {
			PreparedStatement pstmt2 = conn.prepareStatement(priceSql);
			pstmt2.setString(1, productList.get(i).getProductNo());
			ResultSet rs2 = pstmt2.executeQuery();
			
			if(rs2.next()) {
				String immediatePrice = rs2.getString("즉시구매가");
				
				if(immediatePrice == null) {
					immediatePrice = "-";
				}
				
				productList.get(i).setImmediatePrice(immediatePrice);
			}
		}
		
		return productList;
		
	}

	// 구매내역 관련 cnt값들
	public int getBuyingBidCnt(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String bidCntSql = "SELECT COUNT(*) CNT FROM BIDDING WHERE MEMBER_NO = ? AND BIDDING_POSITION_NO = 1 AND BIDDING_STATUS_NO = 1";
		PreparedStatement bidCntPstmt = conn.prepareStatement(bidCntSql);
		bidCntPstmt.setString(1, loginMember.getNo());
		ResultSet rs = bidCntPstmt.executeQuery();
		
		// rs
		int bidCnt = 0;
		if(rs.next()) {
			bidCnt = rs.getInt("CNT");
		}
		
		return bidCnt;
	}

	public int getBuyingPendCnt(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String pendCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON B.NO = O.BIDDING_NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 1 AND NOT O.ORDERS_STATUS_NO=5";
		PreparedStatement pstmt = conn.prepareStatement(pendCntSql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int pendCnt = 0;
		if(rs.next()) {
			pendCnt = rs.getInt("CNT");
		}
		
		return pendCnt;
	}

	public int getBuyingFinishedCnt(Connection conn, MemberVo loginMember) throws Exception {
		String finishedCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON B.NO = O.BIDDING_NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 1 AND O.ORDERS_STATUS_NO=5";
		PreparedStatement pstmt = conn.prepareStatement(finishedCntSql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int finishedCnt = 0;
		if(rs.next()) {
			finishedCnt = rs.getInt("CNT");
		}
	
		return finishedCnt;
	}
	
		
	// 판매내역 관련 cnt값들
}
