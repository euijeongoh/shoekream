package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.vo.BiddingDetailVo;
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.BuyingHistoryVo;
import com.shoekream.mypage.vo.OrderDetailVo;
import com.shoekream.mypage.vo.WishListVo;
import com.shoekream.page.vo.PageVo;

public class MyPageDao {
	
	// 구매입찰 정보 조회(List) - 기간
	public List<BiddingHistoryVo> getBuyBiddingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT B.NO BIDDING_NO , B.MEMBER_NO MEMBER_NO , P.NO PRODUCT_NO , P.NAME PRODUCT_NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , PS.SHOES_SIZES_NO SIZE_NO , BS.BIDDING_STATUS BIDSTATUS , B.PRICE PRICE , B.ENROLL_DATE ENROLL_DATE , TO_DATE(EXTRACT(YEAR FROM B.EXPIRE_DATE) || '-' || EXTRACT(MONTH FROM B.EXPIRE_DATE) || '-' || EXTRACT(DAY FROM B.EXPIRE_DATE), 'YYYY-MM-DD') EXPIRE_DATE FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO=1 AND B.ENROLL_DATE BETWEEN ? AND ? ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, periodMap.get("startDate"));
		pstmt.setString(3, periodMap.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		List<BiddingHistoryVo> bidList = new ArrayList<BiddingHistoryVo>();
		while(rs.next()) {
			String biddingNo = rs.getString("BIDDING_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String productNo = rs.getString("PRODUCT_NO");
			String productName = rs.getString("PRODUCT_NAME");
			String productImg = rs.getString("THUMBNAIL");
			String productSize = rs.getString("SIZES");
			String productSizeNo = rs.getString("SIZE_NO");
			String bidStatus = rs.getString("BIDSTATUS");
			String bidPrice = rs.getString("PRICE");
			String bidEnrollDate = rs.getString("ENROLL_DATE");
			String bidExpireDate = rs.getString("EXPIRE_DATE");
			System.out.println(bidExpireDate);
			BiddingHistoryVo bidVo = new BiddingHistoryVo();
			bidVo.setBiddingNo(biddingNo);
			bidVo.setMemberNo(memberNo);
			bidVo.setProductNo(productNo);
			bidVo.setProductName(productName);
			bidVo.setProductImg(productImg);
			bidVo.setProductSize(productSize);
			bidVo.setProductSizeNo(productSizeNo);
			bidVo.setBidStatus(bidStatus);
			bidVo.setBidPrice(bidPrice);
			bidVo.setBidEnrollDate(bidEnrollDate);
			bidVo.setBidExpireDate(bidExpireDate);
			
			bidList.add(bidVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return bidList;
	}
	
	// 진행중인 구매내역 정보 조회(List)
	public List<BuyingHistoryVo> getBuyPendingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql1 = "SELECT O.MEMBER_NO MEMBER_NO , B.NO BIDDING_NO , P.NO PRODUCT_NO , P.NAME PRODUCT_NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.NO ORDER_NO , OS.ORDERS_STATUS ORDER_STATUS , O.TOTAL_PRICE PRICE , O.ORDERS_DATE ORDERS_DATE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO = ? AND O.ORDERS_STATUS_NO < 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE";
		String sql2 = "SELECT O.MEMBER_NO MEMBER_NO , B.NO BIDDING_NO , P.NO PRODUCT_NO , P.NAME PRODUCT_NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.NO ORDER_NO, OS.ORDERS_STATUS ORDER_STATUS , O.TOTAL_PRICE PRICE , O.ORDERS_DATE ORDERS_DATE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO != ?  AND O.ORDERS_STATUS_NO <6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt1.setString(3, periodMap.get("startDate"));
		pstmt1.setString(4, periodMap.get("endDate"));
		
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		pstmt2.setString(3, periodMap.get("startDate"));
		pstmt2.setString(4, periodMap.get("endDate"));
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		// rs
		List<BuyingHistoryVo> pendList = new ArrayList<BuyingHistoryVo>();
		while(rs1.next()) {
			String memberNo = rs1.getString("MEMBER_NO");
			String biddingNo = rs1.getString("BIDDING_NO");
			String productNo = rs1.getString("PRODUCT_NO");
			String productName = rs1.getString("PRODUCT_NAME");
			String productImg = rs1.getString("THUMBNAIL");
			String productSize = rs1.getString("SIZES");
			String orderNo = rs1.getString("ORDER_NO");
			String orderStatus = rs1.getString("ORDER_STATUS");
			String finalPrice = rs1.getString("PRICE");
			String orderDate = rs1.getString("ORDERS_DATE");
			
			BuyingHistoryVo pendVo1 = new BuyingHistoryVo();
			pendVo1.setMemberNo(memberNo);
			pendVo1.setBiddingNo(biddingNo);
			pendVo1.setProductNo(productNo);
			pendVo1.setProductName(productName);
			pendVo1.setProductImg(productImg);
			pendVo1.setProductSize(productSize);
			pendVo1.setOrderNo(orderNo);
			pendVo1.setOrderStatus(orderStatus);
			pendVo1.setFinalPrice(finalPrice);
			pendVo1.setOrderDate(orderDate);
			
			pendList.add(pendVo1);
		}
		
		while(rs2.next()) {
			String memberNo = rs2.getString("MEMBER_NO");
			String biddingNo = rs2.getString("BIDDING_NO");
			String productNo = rs2.getString("PRODUCT_NO");
			String productName = rs2.getString("PRODUCT_NAME");
			String productImg = rs2.getString("THUMBNAIL");
			String productSize = rs2.getString("SIZES");
			String orderNo = rs2.getString("ORDER_NO");
			String orderStatus = rs2.getString("ORDER_STATUS");
			String finalPrice = rs2.getString("PRICE");
			String orderDate = rs2.getString("ORDERS_DATE");
			
			BuyingHistoryVo pendVo2 = new BuyingHistoryVo();
			pendVo2.setMemberNo(memberNo);
			pendVo2.setBiddingNo(biddingNo);
			pendVo2.setProductNo(productNo);
			pendVo2.setProductName(productName);
			pendVo2.setProductImg(productImg);
			pendVo2.setProductSize(productSize);
			pendVo2.setOrderNo(orderNo);
			pendVo2.setOrderStatus(orderStatus);
			pendVo2.setFinalPrice(finalPrice);
			pendVo2.setOrderDate(orderDate);
			
			pendList.add(pendVo2);
		}
		
		// close
		JDBCTemplate.close(rs1);
		JDBCTemplate.close(rs2);
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
		
		return pendList;
	}
	
	// 완료된 구매내역 정보 조회(List)
	public List<BuyingHistoryVo> getBuyFinishedInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql1 = "SELECT O.MEMBER_NO MEMBER_NO , B.NO BIDDING_NO , P.NO PRODUCT_NO , P.NAME PRODUCT_NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.NO ORDER_NO, OS.ORDERS_STATUS ORDER_STATUS , O.TOTAL_PRICE PRICE , O.ORDERS_DATE ORDERS_DATE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO = ? AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE DESC";
		String sql2 = "SELECT O.MEMBER_NO MEMBER_NO , B.NO BIDDING_NO , P.NO PRODUCT_NO , P.NAME PRODUCT_NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.NO ORDER_NO, OS.ORDERS_STATUS ORDER_STATUS , O.TOTAL_PRICE PRICE , O.ORDERS_DATE ORDERS_DATE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO=? AND B.MEMBER_NO != ? AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt1.setString(3, periodMap.get("startDate"));
		pstmt1.setString(4, periodMap.get("endDate"));
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		pstmt2.setString(3, periodMap.get("startDate"));
		pstmt2.setString(4, periodMap.get("endDate"));
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		// rs
		List<BuyingHistoryVo> finishedList = new ArrayList<BuyingHistoryVo>();
		while(rs1.next()) {
			String memberNo = rs1.getString("MEMBER_NO");
			String biddingNo = rs1.getString("BIDDING_NO");
			String productNo = rs1.getString("PRODUCT_NO");
			String productName = rs1.getString("PRODUCT_NAME");
			String productImg = rs1.getString("THUMBNAIL");
			String productSize = rs1.getString("SIZES");
			String orderStatus = rs1.getString("ORDER_STATUS");
			String orderNo = rs1.getString("ORDER_NO");
			String finalPrice = rs1.getString("PRICE");
			String orderDate = rs1.getString("ORDERS_DATE");
			
			BuyingHistoryVo finishedVo1 = new BuyingHistoryVo();
			finishedVo1.setMemberNo(memberNo);
			finishedVo1.setBiddingNo(biddingNo);
			finishedVo1.setProductNo(productNo);
			finishedVo1.setProductName(productName);
			finishedVo1.setProductImg(productImg);
			finishedVo1.setProductSize(productSize);
			finishedVo1.setOrderStatus(orderStatus);
			finishedVo1.setFinalPrice(finalPrice);
			finishedVo1.setOrderNo(orderNo);
			finishedVo1.setOrderDate(orderDate);
			
			finishedList.add(finishedVo1);
		}

		while(rs2.next()) {
			String memberNo = rs2.getString("MEMBER_NO");
			String biddingNo = rs2.getString("BIDDING_NO");
			String productNo = rs2.getString("PRODUCT_NO");
			String productName = rs2.getString("PRODUCT_NAME");
			String productImg = rs2.getString("THUMBNAIL");
			String productSize = rs2.getString("SIZES");
			String orderNo = rs2.getString("ORDER_NO");
			String orderStatus = rs2.getString("ORDER_STATUS");
			String finalPrice = rs2.getString("PRICE");
			String orderDate = rs2.getString("ORDERS_DATE");
			
			BuyingHistoryVo finishedVo2 = new BuyingHistoryVo();
			finishedVo2.setMemberNo(memberNo);
			finishedVo2.setBiddingNo(biddingNo);
			finishedVo2.setProductNo(productNo);
			finishedVo2.setProductName(productName);
			finishedVo2.setProductImg(productImg);
			finishedVo2.setProductSize(productSize);
			finishedVo2.setOrderNo(orderNo);
			finishedVo2.setOrderStatus(orderStatus);
			finishedVo2.setFinalPrice(finalPrice);
			finishedVo2.setOrderDate(orderDate);
			
			finishedList.add(finishedVo2);
		}
		
		// close
		JDBCTemplate.close(rs1);
		JDBCTemplate.close(rs2);
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
		
		return finishedList;
	}

	// 판매입찰 정보 조회(List)
	public List<BiddingHistoryVo> getSellBiddingInfo(Connection conn, MemberVo loginMember, Map<String, String> map) throws Exception {
		// sql
		String sql = "SELECT "
				+ "B.NO BIDDING_NO "
				+ ", B.MEMBER_NO MEMBER_NO "
				+ ", P.NO PRODUCT_NO "
				+ ", P.NAME PRODUCT_NAME "
				+ ", IMG.THUMBNAIL THUMBNAIL "
				+ ", SS.SHOES_SIZES  SIZES "
				+ ", PS.SHOES_SIZES_NO SIZE_NO "
				+ ", BS.BIDDING_STATUS BIDSTATUS "
				+ ", B.PRICE PRICE "
				+ ", B.ENROLL_DATE ENROLL_DATE "
				+ ", TO_DATE(EXTRACT(YEAR FROM B.EXPIRE_DATE) || '-' || EXTRACT(MONTH FROM B.EXPIRE_DATE) || '-' || EXTRACT(DAY FROM B.EXPIRE_DATE), 'YYYY-MM-DD') EXPIRE_DATE "
				+ "FROM BIDDING B "
				+ "LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO "
				+ "LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO "
				+ "LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO "
				+ "LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO "
				+ "LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO "
				+ "WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO=1 AND B.ENROLL_DATE BETWEEN ? AND ? "
				+ "ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, map.get("startDate"));
		pstmt.setString(3, map.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BiddingHistoryVo> bidList = new ArrayList<BiddingHistoryVo>();
		while(rs.next()) {
			String biddingNo = rs.getString("BIDDING_NO");
			String memberNo = rs.getString("MEMBER_NO");
			String productNo = rs.getString("PRODUCT_NO");
			String productName = rs.getString("PRODUCT_NAME");
			String productImg = rs.getString("THUMBNAIL");
			String productSize = rs.getString("SIZES");
			String productSizeNo = rs.getString("SIZE_NO");
			String bidStatus = rs.getString("BIDSTATUS");
			String bidPrice = rs.getString("PRICE");
			String bidEnrollDate = rs.getString("ENROLL_DATE");
			String bidExpireDate = rs.getString("EXPIRE_DATE");
			
			BiddingHistoryVo bidVo = new BiddingHistoryVo();
			bidVo.setBiddingNo(biddingNo);
			bidVo.setMemberNo(memberNo);
			bidVo.setProductNo(productNo);
			bidVo.setProductName(productName);
			bidVo.setProductImg(productImg);
			bidVo.setProductSize(productSize);
			bidVo.setProductSizeNo(productSizeNo);
			bidVo.setBidStatus(bidStatus);
			bidVo.setBidPrice(bidPrice);
			bidVo.setBidEnrollDate(bidEnrollDate);
			bidVo.setBidExpireDate(bidExpireDate);
			
			bidList.add(bidVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return bidList;
	}

	// 진행중인 판매내역 정보 조회(List)
	public List<BuyingHistoryVo> getSellPendingInfo(Connection conn, MemberVo loginMember, Map<String, String> map) throws Exception {
		// sql
		String sql1 = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.TOTAL_PRICE PRICE , O.NO ORDER_NO, OS.ORDERS_STATUS ORDERSTATUS FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO <6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE DESC";
		String sql2 = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.TOTAL_PRICE PRICE , O.NO ORDER_NO, OS.ORDERS_STATUS ORDERSTATUS FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO != ? AND B.BIDDING_POSITION_NO = 1 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO < 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt1.setString(3, map.get("startDate"));
		pstmt1.setString(4, map.get("endDate"));
		
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		pstmt2.setString(3, map.get("startDate"));
		pstmt2.setString(4, map.get("endDate"));
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		// rs
		List<BuyingHistoryVo> pendList = new ArrayList<BuyingHistoryVo>();
		while(rs1.next()) {
			String productName = rs1.getString("NAME");
			String productImg = rs1.getString("THUMBNAIL");
			String productSize = rs1.getString("SIZES");
			String orderNo = rs1.getString("ORDER_NO");
			String orderStatus = rs1.getString("ORDERSTATUS");
			String totalPrice = rs1.getString("PRICE");
			
			BuyingHistoryVo pendVo = new BuyingHistoryVo();
			pendVo.setProductName(productName);
			pendVo.setProductImg(productImg);
			pendVo.setProductSize(productSize);
			pendVo.setOrderNo(orderNo);
			pendVo.setOrderStatus(orderStatus);
			pendVo.setFinalPrice(totalPrice);
			
			pendList.add(pendVo);
		}
		
		while(rs2.next()) {
			String productName = rs2.getString("NAME");
			String productImg = rs2.getString("THUMBNAIL");
			String productSize = rs2.getString("SIZES");
			String orderNo = rs2.getString("ORDER_NO");
			String orderStatus = rs2.getString("ORDERSTATUS");
			String totalPrice = rs2.getString("PRICE");
			
			BuyingHistoryVo pendVo = new BuyingHistoryVo();
			pendVo.setProductName(productName);
			pendVo.setProductImg(productImg);
			pendVo.setProductSize(productSize);
			pendVo.setOrderNo(orderNo);
			pendVo.setOrderStatus(orderStatus);
			pendVo.setFinalPrice(totalPrice);
			
			pendList.add(pendVo);
		}
		
		// close
		JDBCTemplate.close(rs1);
		JDBCTemplate.close(rs2);
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
		
		return pendList;
	}
		
	// 완료된 판매내역 정보 조회(List)
	public List<BuyingHistoryVo> getSellFinishedInfo(Connection conn, MemberVo loginMember, Map<String, String> map) throws Exception {
		// sql
		String sql1 = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.TOTAL_PRICE PRICE , O.NO ORDER_NO, OS.ORDERS_STATUS ORDERSTATUS FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE DESC";
		String sql2 = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , O.TOTAL_PRICE PRICE , O.NO ORDER_NO, OS.ORDERS_STATUS ORDERSTATUS FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO != ? AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE DESC";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt1.setString(3, map.get("startDate"));
		pstmt1.setString(4, map.get("endDate"));
		
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		pstmt2.setString(3, map.get("startDate"));
		pstmt2.setString(4, map.get("endDate"));
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		// rs
		List<BuyingHistoryVo> finishedList = new ArrayList<BuyingHistoryVo>();
		while(rs1.next()) {
			String productName = rs1.getString("NAME");
			String productImg = rs1.getString("THUMBNAIL");
			String productSize = rs1.getString("SIZES");
			String orderNo = rs1.getString("ORDER_NO");
			String orderState = rs1.getString("ORDERSTATUS");
			String finalPrice = rs1.getString("PRICE");
			
			BuyingHistoryVo finishedVo = new BuyingHistoryVo();
			finishedVo.setProductName(productName);
			finishedVo.setProductImg(productImg);
			finishedVo.setProductSize(productSize);
			finishedVo.setOrderNo(orderNo);
			finishedVo.setOrderStatus(orderState);
			finishedVo.setFinalPrice(finalPrice);
			
			finishedList.add(finishedVo);
		}
		
		while(rs2.next()) {
			String productName = rs2.getString("NAME");
			String productImg = rs2.getString("THUMBNAIL");
			String productSize = rs2.getString("SIZES");
			String orderState = rs2.getString("ORDERSTATUS");
			String orderNo = rs2.getString("ORDER_NO");
			String finalPrice = rs2.getString("PRICE");
			
			BuyingHistoryVo finishedVo = new BuyingHistoryVo();
			finishedVo.setProductName(productName);
			finishedVo.setProductImg(productImg);
			finishedVo.setProductSize(productSize);
			finishedVo.setOrderNo(orderNo);
			finishedVo.setOrderStatus(orderState);
			finishedVo.setFinalPrice(finalPrice);
			
			finishedList.add(finishedVo);
		}
		
		// close
		JDBCTemplate.close(rs1);
		JDBCTemplate.close(rs2);
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
		
		return finishedList;
	}

	// 관심상품 정보 조회(List)
	public List<WishListVo> getWishProductsInfo(Connection conn, MemberVo loginMember, PageVo pvo) throws Exception {
		// sql
		String productSql = "SELECT * FROM ( SELECT ROWNUM , A.* FROM ( SELECT BR.BRAND_NAME BRAND_NAME , P.NO PRODUCT_NO , P.MODEL_NUMBER MODEL_NUMBER , P.NAME PRODUCT_NAME , IMG.THUMBNAIL THUMBNAIL FROM WISHLIST W LEFT JOIN PRODUCTS P ON W.PRODUCTS_NO = P.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BRAND BR ON P.BRAND_NO = BR.NO WHERE W.MEMBER_NO = ? ORDER BY W.WISH_DATE DESC ) A ) WHERE ROWNUM BETWEEN ? AND ?";
		String priceSql = "SELECT MIN(B.PRICE) 즉시구매가 FROM BIDDING B WHERE B.BIDDING_POSITION_NO = 2 AND B.PRODUCTS_NO = ?";
		PreparedStatement pstmt1 = conn.prepareStatement(productSql);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setInt(2, pvo.getStartRow());
		pstmt1.setInt(3, pvo.getLastRow());
		ResultSet rs = pstmt1.executeQuery();
		
		List<WishListVo> productList = new ArrayList<WishListVo>();
		while(rs.next()) {
			String brandName = rs.getString("BRAND_NAME");
			String productNo = rs.getString("PRODUCT_NO");
			String modelNumber = rs.getString("MODEL_NUMBER");
			String productName = rs.getString("PRODUCT_NAME");
			String productImg = rs.getString("THUMBNAIL");
			
			WishListVo wishVo = new WishListVo();
			
			wishVo.setBrandName(brandName);
			wishVo.setProductNo(productNo);
			wishVo.setModelNumber(modelNumber);
			wishVo.setProductName(productName);
			wishVo.setProductImg(productImg);
			
			productList.add(wishVo);
		}
		
		// close
		JDBCTemplate.close(pstmt1);
		
		PreparedStatement pstmt2 = null;
		for(int i = 0; i<productList.size(); ++i) {
			pstmt2 = conn.prepareStatement(priceSql);
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
		
		// close
		JDBCTemplate.close(pstmt2);
		
		
		return productList;
		
	}

	// 구매내역 관련 cnt값들
	public int getBuyingBidCnt(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String bidCntSql = "SELECT COUNT(*) CNT FROM BIDDING B WHERE B.MEMBER_NO = ? AND BIDDING_POSITION_NO=1";
		PreparedStatement bidCntPstmt = conn.prepareStatement(bidCntSql);
		bidCntPstmt.setString(1, loginMember.getNo());
		ResultSet rs = bidCntPstmt.executeQuery();
		
		// rs
		int bidCnt = 0;
		if(rs.next()) {
			bidCnt = rs.getInt("CNT");
		}
		
		System.out.println(bidCnt);
		// close
		JDBCTemplate.close(bidCntPstmt);
		
		return bidCnt;
	}

	/**
	 * 구매진행 cnt
	 * sql1: loginMember가 구매입찰을 직접 하고, 후에 타 회원에 의해 즉시판매된 경우
	 * sql2: loginMember가 타 회원의 판매입찰을 즉시구매한 경우
	 * cnt값의 sum
	 */
	public int getBuyingPendCnt(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql1 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO = ? AND O.ORDERS_STATUS_NO < 6";
		String sql2 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO != ? AND O.ORDERS_STATUS_NO <6";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		int pendCnt1_ = 0;
		int pendCnt2_ = 0;
		if(rs1.next()) {
			pendCnt1_ = rs1.getInt("CNT");
		}
		
		if(rs2.next()) {
			pendCnt2_ = rs2.getInt("CNT");
		}
		
		int pendCnt = pendCnt1_ + pendCnt2_;
		
		System.out.println(pendCnt);
		
		// close
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
		
		return pendCnt;
	}

	/**
	 * 구매완료 cnt
	 * sql1: loginMember가 구매입찰을 직접 하고, 후에 타 회원에 의해 즉시판매된 경우
	 * sql2: loginMember가 타 회원의 판매입찰을 즉시구매한 경우
	 * cnt값의 sum
	 */
	public int getBuyingFinishedCnt(Connection conn, MemberVo loginMember) throws Exception {
		String sql1 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO = ? AND O.ORDERS_STATUS_NO = 6";
		String sql2 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO=? AND B.MEMBER_NO != ? AND O.ORDERS_STATUS_NO = 6";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		int finishedCnt1_ = 0;
		int finishedCnt2_ = 0;
		if(rs1.next()) {
			finishedCnt1_ = rs1.getInt("CNT");
		}
		
		if(rs2.next()) {
			finishedCnt2_ = rs2.getInt("CNT");
		}
		
		int finishedCnt = finishedCnt1_ + finishedCnt2_;
		
		System.out.println(finishedCnt);
		
		// close
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
	
		return finishedCnt;
	}
	

	// 판매내역 관련 cnt값들
	// 판매입찰
	public int getSellingBidCnt(Connection conn, MemberVo loginMember) throws Exception {
		String sql ="SELECT COUNT(*) CNT FROM BIDDING B WHERE B.MEMBER_NO = ? AND BIDDING_POSITION_NO=2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int bidCnt = -1;
		if(rs.next()) {
			bidCnt = rs.getInt("CNT");
		}
		
		// close
		JDBCTemplate.close(pstmt);
		
		return bidCnt;
	}

	public int getSellingPendCnt(Connection conn, MemberVo loginMember) throws Exception {
		String sql1 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND O.ORDERS_STATUS_NO <6";
		String sql2 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO != ? AND B.BIDDING_POSITION_NO = 1 AND O.ORDERS_STATUS_NO < 6";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		int pendCnt1_ = 0;
		int pendCnt2_ = 0;
		if(rs1.next()) {
			pendCnt1_ = rs1.getInt("CNT");
		}
		
		if(rs2.next()) {
			pendCnt2_ = rs2.getInt("CNT");
		}
		
		int pendCnt = pendCnt1_ + pendCnt2_;
		
		System.out.println(pendCnt);
		
		// close
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
		
		return pendCnt;
	}

	public int getSellingFinishedCnt(Connection conn, MemberVo loginMember) throws Exception {
		String sql1 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE B.MEMBER_NO = ? AND O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND O.ORDERS_STATUS_NO = 6";
		String sql2 = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.MEMBER_NO != ? AND O.ORDERS_STATUS_NO = 6";
		PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		pstmt1.setString(1, loginMember.getNo());
		pstmt1.setString(2, loginMember.getNo());
		pstmt2.setString(1, loginMember.getNo());
		pstmt2.setString(2, loginMember.getNo());
		
		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();
		
		int finishedCnt1_ = 0;
		int finishedCnt2_ = 0;
		if(rs1.next()) {
			finishedCnt1_ = rs1.getInt("CNT");
		}
		
		if(rs2.next()) {
			finishedCnt2_ = rs2.getInt("CNT");
		}
		
		int finishedCnt = finishedCnt1_ + finishedCnt2_;
		
		System.out.println(finishedCnt);
		
		// close
		JDBCTemplate.close(pstmt1);
		JDBCTemplate.close(pstmt2);
	
		return finishedCnt;
	}

	public Map<String, Object> saveImgSrcInDB(Connection conn, MemberVo loginMember, String src) throws Exception {
		// sql
		String sql = "UPDATE MEMBER SET PROFILE_IMAGE = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, src);
		pstmt.setString(2, loginMember.getNo());
		
		int result = pstmt.executeUpdate();
		
		// loginMember에 src 넣어주기
		if(result == 1) {
			loginMember.setProfileImage(src);
		}
		
		// 데이터 가공
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginMember", loginMember);
		map.put("result", result);
		
		// close
		JDBCTemplate.close(pstmt);
		
		return map;
	}

	public int deleteWishItem(Connection conn, MemberVo loginMember, String productNo) throws Exception {
		// sql
		String sql = "DELETE FROM WISHLIST WHERE PRODUCTS_NO = ? AND MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		pstmt.setString(2, loginMember.getNo());
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int getWishCnt(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String sql = "SELECT COUNT(*) CNT FROM WISHLIST WHERE MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int wishCnt = -1;
		if(rs.next()) {
			wishCnt =  rs.getInt("CNT");
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return wishCnt;
	}

	public int updateMemberInfo(Connection conn, MemberVo vo) throws Exception {
		// sql
		String sql = "UPDATE MEMBER SET ID=? , PWD=?, NICKNAME=?, EMAIL=? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNickname());
		pstmt.setString(4, vo.getEmail());
		pstmt.setString(5, vo.getNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	// 구매입찰 내역 상세 조회
	public BiddingDetailVo selectBiddingDetail(Connection conn, String bidNo) throws Exception {
		// sql
		String sql = "SELECT IMG.THUMBNAIL THUMBNAIL , P.MODEL_NUMBER MODEL_NO , P.NAME NAME , P.NAME_KO NAME_KO , SS.SHOES_SIZES  SIZES , BS.BIDDING_STATUS BID_STATUS , SUBSTR(TO_CHAR(B.EXPIRE_DATE), 1, 8) EXPIRE_DATE , B.PRICE PRICE , AB.ADDRES_NAME ADDRESS_NAME , AB.ADDRES ADDRESS , AB.DETAIL_ADDRES DETAIL_ADDRESS , AB.PHONE_NUMBER PHONE , C.CARD_NUMBER CARD_NUMBER , CC.CARD_COMPANY_NAME CARD_COMPANY FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO LEFT JOIN MEMBER M ON M.NO = B.MEMBER_NO LEFT JOIN ADDERSS_BOOK AB ON AB.MEMBER_NO = M.NO LEFT JOIN CARD C ON C.MEMBER_NO = M.NO LEFT JOIN CARD_COMPANY CC ON CC.NO = C.CARD_COMPANY_NO WHERE B.NO = ? AND AB.DEFAULT_ADDRESS_YN = 'Y'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bidNo);
		ResultSet rs = pstmt.executeQuery();
		
		BiddingDetailVo vo = null;
		if(rs.next()) {
			String productImg = rs.getString("THUMBNAIL");
			String modelNumber = rs.getString("MODEL_NO");
			String productName = rs.getString("NAME");
			String productNameKo = rs.getString("NAME_KO");
			String productSize = rs.getString("SIZES");
			String bidStatus = rs.getString("BID_STATUS");
			String expireDate = rs.getString("EXPIRE_DATE");
			int bidPrice = rs.getInt("PRICE");
			String addressName = rs.getString("ADDRESS_NAME");
			String address = rs.getString("ADDRESS");
			String detailAddress = rs.getString("DETAIL_ADDRESS");
			String phone = rs.getString("PHONE");
			String cardNumber = rs.getString("CARD_NUMBER");
			String cardCompany = rs.getString("CARD_COMPANY");
			
			vo = new BiddingDetailVo();
			vo.setProductImg(productImg);
			vo.setModelNumber(modelNumber);
			vo.setProductName(productName);
			vo.setProductNameKo(productNameKo);
			vo.setProductSize(productSize);
			vo.setBidStatus(bidStatus);
			vo.setBidExpireDate(expireDate);
			vo.setBidPrice(bidPrice);
			vo.setCommission(bidPrice);
			vo.setFinalPrice(bidPrice, vo.getCommission());
			vo.setAddressName(addressName);
			vo.setAddress(address);
			vo.setDetailAddress(detailAddress);
			vo.setPhone(phone);
			vo.setCardNumber(cardNumber);
			vo.setCardCompany(cardCompany);
			
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

public OrderDetailVo getOrderDetail(Connection conn, String orderNo) throws Exception {
	// sql
	String sql = "SELECT IMG.THUMBNAIL THUMBNAIL , P.MODEL_NUMBER MODEL_NO , P.NAME NAME , P.NAME_KO NAME_KO , SS.SHOES_SIZES  SIZES , OS.ORDERS_STATUS ORDER_STATUS , SUBSTR(TO_CHAR(O.ORDERS_DATE), 1, 8) ORDER_DATE , O.TOTAL_PRICE TOTAL_PRICE , O.COMMISSION COMMISSION , B.PRICE BID_PRICE , AB.ADDRES_NAME ADDRESS_NAME , AB.ADDRES ADDRESS , AB.DETAIL_ADDRES DETAIL_ADDRESS , AB.PHONE_NUMBER PHONE , C.CARD_NUMBER CARD_NUMBER , CC.CARD_COMPANY_NAME CARD_COMPANY FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN MEMBER M ON M.NO = O.MEMBER_NO LEFT JOIN ADDERSS_BOOK AB ON AB.MEMBER_NO = M.NO LEFT JOIN CARD C ON C.MEMBER_NO = M.NO LEFT JOIN CARD_COMPANY CC ON CC.NO = C.CARD_COMPANY_NO WHERE O.NO = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, orderNo);
	
	ResultSet rs = pstmt.executeQuery();
	
	OrderDetailVo vo = null;
	if(rs.next()) {
		String productImg = rs.getString("THUMBNAIL");
		String modelNumber = rs.getString("MODEL_NO");
		String productName = rs.getString("NAME");
		String productNameKo = rs.getString("NAME_KO");
		String productSize = rs.getString("SIZES");
		String orderStatus = rs.getString("ORDER_STATUS");
		String orderDate = rs.getString("ORDER_DATE");
		String bidPrice = rs.getString("BID_PRICE");
		String commission = rs.getString("COMMISSION");
		String finalPrice = rs.getString("TOTAL_PRICE");
		String addressName = rs.getString("ADDRESS_NAME");
		String address = rs.getString("ADDRESS");
		String detailAddress = rs.getString("DETAIL_ADDRESS");
		String phone = rs.getString("PHONE");
		String cardNumber = rs.getString("CARD_NUMBER");
		String cardCompany = rs.getString("CARD_COMPANY");
		
		
		vo = new OrderDetailVo();
		vo.setProductImg(productImg);
		vo.setModelNumber(modelNumber);
		vo.setProductName(productName);
		vo.setProductNameKo(productNameKo);
		vo.setProductSize(productSize);
		vo.setOrderStatus(orderStatus);
		vo.setBidPrice(bidPrice);
		vo.setCommission(commission);
		vo.setFinalPrice(finalPrice);
		vo.setAddressName(addressName);
		vo.setAddress(address);
		vo.setDetailAddress(detailAddress);
		vo.setPhone(phone);
		vo.setCardNumber(cardNumber);
		vo.setCardCompany(cardCompany);
	}
	
	JDBCTemplate.close(rs);
	JDBCTemplate.close(pstmt);
	
	return vo;
}


}
