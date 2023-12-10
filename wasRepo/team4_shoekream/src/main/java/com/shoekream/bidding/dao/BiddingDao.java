package com.shoekream.bidding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.biddingVo.BiddingVo;

public class BiddingDao {


	// 구매하기
	public List<BiddingVo> buySelect(Connection conn, String productsNo) throws Exception{

		// sql
		String sql = "SELECT SHOES_SIZES, MIN(PRICE) AS PRICE FROM ( SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE PRODUCTS_NO = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '판매입찰' AND B.EXPIRE_DATE >= SYSDATE ) GROUP BY SHOES_SIZES";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productsNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<BiddingVo> voList = new ArrayList<BiddingVo>();
		while(rs.next()) {
			BiddingVo dbVo = new BiddingVo();
			dbVo.setShoesSizes(rs.getString("SHOES_SIZES"));
			dbVo.setPrice(rs.getString("PRICE"));
			voList.add(dbVo);
			//			System.out.println("에러확인 SHOES_SIZES : "+rs.getString("SHOES_SIZES"));
			//			System.out.println("에러확인 PRICE : "+rs.getString("PRICE"));
		}

		return voList;
	}


	
	
	
	// 구매 상품 정보(즉시 구매가 : 판매입찰)
	public BiddingVo buyProductList(Connection conn, BiddingVo vo) throws Exception{
		System.out.println(vo.getProductsNo());
		System.out.println(vo.getPrice());
		System.out.println(vo.getShoesSizes());
		
		// sql
		String sql = "SELECT B.NO AS NO ,B.MEMBER_NO AS MEMBER_NO ,B.PRODUCTS_NO AS PRODUCTS_NO ,B.PRODUCTS_SIZES_NO AS PRODUCTS_SIZES_NO ,SS.SHOES_SIZES AS SHOES_SIZES ,B.BIDDING_STATUS_NO AS BIDDING_STATUS_NO ,BS.BIDDING_STATUS AS BIDDING_STATUS ,B.BIDDING_POSITION_NO AS BIDDING_POSITION_NO ,BP.BIDDING_POSITION AS BIDDING_POSITION ,B.PRICE AS PRICE ,B.ENROLL_DATE AS ENROLL_DATE ,B.EXPIRE_DATE AS EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '판매입찰' AND B.EXPIRE_DATE >= SYSDATE AND B.PRODUCTS_NO = ? AND B.PRICE = ? AND SS.SHOES_SIZES = ? ORDER BY NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProductsNo());
		pstmt.setString(2, vo.getPrice());
		pstmt.setString(3, vo.getShoesSizes());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		BiddingVo buyPrVo = null;
		if(rs.next()) {
			buyPrVo = new BiddingVo();
			buyPrVo.setShoesSizes(rs.getString("SHOES_SIZES"));
			buyPrVo.setPrice(rs.getString("PRICE"));
						System.out.println("buyProductList : 판매입찰(즉시구매가)");
						System.out.println("dao에러확인 SHOES_SIZES : "+rs.getString("SHOES_SIZES"));
						System.out.println("dao에러확인 PRICE : "+rs.getString("PRICE"));
		}
		return buyPrVo;
	}
	// 판매 상품 정보(즉시 판매가 : 구매입찰)
	public BiddingVo sellProductList(Connection conn, BiddingVo vo) throws Exception{
		System.out.println(vo.getProductsNo());
		System.out.println(vo.getShoesSizes());
		// sql
		String sql = "SELECT SHOES_SIZES , MAX(PRICE) AS PRICE FROM ( SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE PRODUCTS_NO = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '구매입찰' AND B.EXPIRE_DATE >= SYSDATE ) GROUP BY SHOES_SIZES HAVING SHOES_SIZES = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProductsNo());
		pstmt.setString(2, vo.getShoesSizes());
		ResultSet rs = pstmt.executeQuery();

		// rs
		BiddingVo sellPrVo = null;
		if(rs.next()) {
			sellPrVo = new BiddingVo();
			sellPrVo.setShoesSizes(rs.getString("SHOES_SIZES"));
			sellPrVo.setPrice(rs.getString("PRICE"));
						System.out.println("sellProductList : 구매입찰(즉시판매가)");
						System.out.println("dao에러확인 SHOES_SIZES : "+rs.getString("SHOES_SIZES"));
						System.out.println("dao에러확인 PRICE : "+rs.getString("PRICE"));
		}
		return sellPrVo;
	}

	
	
	
	
	// 상품 정보 조회
	public BiddingVo productInfo(Connection conn, BiddingVo vo) throws Exception{

		// sql
		String sql = "SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.PRODUCTS_NO = ? AND B.PRICE = ? AND SS.SHOES_SIZES = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '판매입찰' AND B.EXPIRE_DATE >= SYSDATE ORDER BY NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProductsNo());
		pstmt.setString(2, vo.getPrice());
		pstmt.setString(3, vo.getShoesSizes());
		ResultSet rs = pstmt.executeQuery();

		// rs
		BiddingVo dbVo = null;
		if(rs.next()) {
			dbVo = new BiddingVo();
			dbVo.setNo(rs.getString(1));
			dbVo.setMemberNo(rs.getString(2));
			dbVo.setProductsNo(rs.getString(3));
			dbVo.setProductsSizesNo(rs.getString(4));
			dbVo.setShoesSizes(rs.getString(5));
			dbVo.setBiddingStatusNo(rs.getString(6));
			dbVo.setBiddingStatus(rs.getString(7));
			dbVo.setBiddingPositionNo(rs.getString(8));
			dbVo.setBiddingPosition(rs.getString(9));
			dbVo.setPrice(rs.getString(10));
			dbVo.setEnrollDate(rs.getString(11));
			dbVo.setExpireDate(rs.getString(12));
			System.out.println("productInfo : 상품 정보 조회");
			System.out.println("dao에러확인 dbVo : " + dbVo);
		}
		return dbVo;
	}
}
