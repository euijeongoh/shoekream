package com.shoekream.bidding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.biddingVo.BiddingVo;

public class BuySelectDao {

	public List<BiddingVo> buySelect(Connection conn) throws Exception{
		
		// sql
		String sql = "SELECT B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES , MIN(PRICE) AS PRICE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE B.BIDDING_STATUS_NO = 1 AND B.BIDDING_POSITION_NO = 2 AND B.EXPIRE_DATE >= SYSDATE GROUP BY SS.SHOES_SIZES, B.PRODUCTS_SIZES_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<BiddingVo> voList = new ArrayList<BiddingVo>();
		while(rs.next()) {
			BiddingVo dbVo = new BiddingVo();
			dbVo.setProductsSizesNo(rs.getString("PRODUCTS_SIZES_NO"));
			dbVo.setShoesSizes(rs.getString("SHOES_SIZES"));
			dbVo.setPrice(rs.getString("PRICE"));
			voList.add(dbVo);
//			System.out.println("에러확인 PRODUCTS_SIZES_NO : "+rs.getString("PRODUCTS_SIZES_NO"));
//			System.out.println("에러확인 SHOES_SIZES : "+rs.getString("SHOES_SIZES"));
//			System.out.println("에러확인 PRICE : "+rs.getString("PRICE"));
		}
		
		return voList;
	}

}
