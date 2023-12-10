package com.shoekream.bidding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.biddingVo.BiddingVo;

public class BuySelectDao {

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

}
