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
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.OrdersHistoryVo;
import com.shoekream.mypage.vo.WishListVo;
import com.shoekream.page.vo.PageVo;

public class MyPageDao {
	
	// 구매입찰 정보 조회(List) - 기간
	public List<BiddingHistoryVo> getBuyBiddingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , BS.BIDDING_STATUS BIDSTATUS , B.PRICE PRICE , B.ENROLL_DATE ENROLL_DATE , B.EXPIRE_DATE EXPIRE_DATE FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO=1 AND B.ENROLL_DATE BETWEEN ? AND ? ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, periodMap.get("startDate"));
		pstmt.setString(3, periodMap.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		List<BiddingHistoryVo> bidList = new ArrayList<BiddingHistoryVo>();
		while(rs.next()) {
			String shoeName = rs.getString("NAME");
			String shoeImg = rs.getString("THUMBNAIL");
			String shoeSize = rs.getString("SIZES");
			String bidStatus = rs.getString("BIDSTATUS");
			String bidPrice = rs.getString("PRICE");
			String bidEnrollDate = rs.getString("ENROLL_DATE");
			String bidExpireDate = rs.getString("EXPIRE_DATE");
			
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
	public List<OrdersHistoryVo> getBuyPendingInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , OS.ORDERS_STATUS ORDERSTATUS , O.TOTAL_PRICE PRICE , O.ORDERS_DATE ORDERS_DATE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO < 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, periodMap.get("startDate"));
		pstmt.setString(3, periodMap.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersHistoryVo> pendList = new ArrayList<OrdersHistoryVo>();
		while(rs.next()) {
			String productName = rs.getString("NAME");
			String productImg = rs.getString("THUMBNAIL");
			String productSize = rs.getString("SIZES");
			String orderStatus = rs.getString("ORDERSTATUS");
			String totalPrice = rs.getString("PRICE");
			String orderDate = rs.getString("ORDERS_DATE");
			
			OrdersHistoryVo pendVo = new OrdersHistoryVo();
			pendVo.setProductName(productName);
			pendVo.setProductImg(productImg);
			pendVo.setProductSize(productSize);
			pendVo.setOrderStatus(orderStatus);
			pendVo.setFinalPrice(totalPrice);
			pendVo.setOrderDate(orderDate);
			
			pendList.add(pendVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pendList;
	}
	
	// 완료된 구매내역 정보 조회(List)
	public List<OrdersHistoryVo> getBuyFinishedInfo(Connection conn, MemberVo loginMember, Map<String, String> periodMap) throws Exception {
		// sql
		String sql = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , OS.ORDERS_STATUS ORDERSTATUS , O.TOTAL_PRICE PRICE , O.ORDERS_DATE ORDER_DATE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6  AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, periodMap.get("startDate"));
		pstmt.setString(3, periodMap.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersHistoryVo> finishedList = new ArrayList<OrdersHistoryVo>();
		while(rs.next()) {
			String productName = rs.getString("NAME");
			String productImg = rs.getString("THUMBNAIL");
			String productSize = rs.getString("SIZES");
			String orderState = rs.getString("ORDERSTATUS");
			String finalPrice = rs.getString("PRICE");
			String orderDate = rs.getString("ORDER_DATE");
			
			OrdersHistoryVo finishedVo = new OrdersHistoryVo();
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
	public List<BiddingHistoryVo> getSellBiddingInfo(Connection conn, MemberVo loginMember, Map<String, String> map) throws Exception {
		// sql
		String sql = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , BS.BIDDING_STATUS BIDSTATUS , B.PRICE PRICE, B.EXPIRE_DATE, B.ENROLL_DATE FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO=2 AND B.ENROLL_DATE BETWEEN ? AND ? ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, map.get("startDate"));
		pstmt.setString(3, map.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BiddingHistoryVo> sellList = new ArrayList<BiddingHistoryVo>();
		while(rs.next()) {
			String productName = rs.getString("NAME");
			String productImg = rs.getString("THUMBNAIL");
			String productSize = rs.getString("SIZES");
			String bidPrice = rs.getString("PRICE");
			String bidStatus = rs.getString("BIDSTATUS");
			String bidExpireDate = rs.getString("EXPIRE_DATE");
			String bidEnrollDate = rs.getString("ENROLL_DATE");
			
			BiddingHistoryVo sellVo = new BiddingHistoryVo();
			sellVo.setShoeName(productName);
			sellVo.setShoeImg(productImg);
			sellVo.setShoeSize(productSize);
			sellVo.setBidPrice(bidPrice);
			sellVo.setBidStatus(bidStatus);
			sellVo.setExpireDate(bidExpireDate);
			sellVo.setEnrollDate(bidEnrollDate);
			
			sellList.add(sellVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return sellList;
	}

	// 진행중인 판매내역 정보 조회(List)
	public List<OrdersHistoryVo> getSellPendingInfo(Connection conn, MemberVo loginMember, Map<String, String> map) throws Exception {
		// sql
		String sql = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , OS.ORDERS_STATUS ORDERSTATUS , O.TOTAL_PRICE PRICE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO < 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, map.get("startDate"));
		pstmt.setString(3, map.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersHistoryVo> pendList = new ArrayList<OrdersHistoryVo>();
		while(rs.next()) {
			String productName = rs.getString("NAME");
			String productImg = rs.getString("THUMBNAIL");
			String productSize = rs.getString("SIZES");
			String orderStatus = rs.getString("ORDERSTATUS");
			String totalPrice = rs.getString("PRICE");
			
			OrdersHistoryVo pendVo = new OrdersHistoryVo();
			pendVo.setProductName(productName);
			pendVo.setProductImg(productImg);
			pendVo.setProductSize(productSize);
			pendVo.setOrderStatus(orderStatus);
			pendVo.setFinalPrice(totalPrice);
			
			pendList.add(pendVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pendList;
	}
		
	// 완료된 판매내역 정보 조회(List)
	public List<OrdersHistoryVo> getSellFinishedInfo(Connection conn, MemberVo loginMember, Map<String, String> map) throws Exception {
		// sql
		String sql = "SELECT P.NAME NAME , IMG.THUMBNAIL THUMBNAIL , SS.SHOES_SIZES  SIZES , OS.ORDERS_STATUS ORDERSTATUS , O.TOTAL_PRICE PRICE FROM ORDERS O LEFT JOIN ORDERS_STATUS OS ON OS.NO = O.ORDERS_STATUS_NO LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO LEFT JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6 AND O.ORDERS_DATE BETWEEN ? AND ? ORDER BY O.ORDERS_DATE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		pstmt.setString(2, map.get("startDate"));
		pstmt.setString(3, map.get("endDate"));
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<OrdersHistoryVo> finishedList = new ArrayList<OrdersHistoryVo>();
		while(rs.next()) {
			String productName = rs.getString("NAME");
			String productImg = rs.getString("THUMBNAIL");
			String productSize = rs.getString("SIZES");
			String orderState = rs.getString("ORDERSTATUS");
			String finalPrice = rs.getString("PRICE");
			
			OrdersHistoryVo finishedVo = new OrdersHistoryVo();
			finishedVo.setProductName(productName);
			finishedVo.setProductImg(productImg);
			finishedVo.setProductSize(productSize);
			finishedVo.setOrderStatus(orderState);
			finishedVo.setFinalPrice(finalPrice);
			
			finishedList.add(finishedVo);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
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

	public int getBuyingPendCnt(Connection conn, MemberVo loginMember) throws Exception {
		// sql
		String pendCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO < 6";
		PreparedStatement pstmt = conn.prepareStatement(pendCntSql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int pendCnt = 0;
		if(rs.next()) {
			pendCnt = rs.getInt("CNT");
		}
		
		System.out.println(pendCnt);
		
		// close
		JDBCTemplate.close(pstmt);
		
		return pendCnt;
	}

	public int getBuyingFinishedCnt(Connection conn, MemberVo loginMember) throws Exception {
		String finishedCntSql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE O.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6";
		PreparedStatement pstmt = conn.prepareStatement(finishedCntSql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int finishedCnt = 0;
		if(rs.next()) {
			finishedCnt = rs.getInt("CNT");
		}
		
		// close
		JDBCTemplate.close(pstmt);
	
		return finishedCnt;
	}
		
	// 판매내역 관련 cnt값들
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
		String sql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO < 6";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int pendCnt = -1;
		if(rs.next()) {
			pendCnt = rs.getInt("CNT");
		}
		
		// close
		JDBCTemplate.close(pstmt);
		
		return pendCnt;
	}

	public int getSellingFinishedCnt(Connection conn, MemberVo loginMember) throws Exception {
		String sql = "SELECT COUNT(*) CNT FROM ORDERS O LEFT JOIN BIDDING B ON O.BIDDING_NO = B.NO WHERE B.MEMBER_NO = ? AND B.BIDDING_POSITION_NO = 2 AND B.BIDDING_STATUS_NO = 3 AND O.ORDERS_STATUS_NO = 6";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMember.getNo());
		ResultSet rs = pstmt.executeQuery();
		
		int finishCnt = -1;
		if(rs.next()) {
			finishCnt = rs.getInt("CNT");
		}
		
		// close
		JDBCTemplate.close(pstmt);
		
		return finishCnt;
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


}
