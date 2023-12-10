package com.shoekream.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.product.vo.ProductInfoVo;

public class HomeDao {

	public List<ProductInfoVo> getRecentEnrolledProductList(Connection conn) throws Exception {
		// sql
		String sql = "SELECT * FROM ( SELECT ROWNUM , A.* FROM    ( SELECT BR.BRAND_NAME 브랜드명 , P.NAME 상품명 , P.NAME_KO 한국이름 , B.PRICE 즉시구매가 FROM PRODUCTS P LEFT JOIN BIDDING B ON B.PRODUCTS_NO = P.NO LEFT JOIN BRAND BR ON P.BRAND_NO = BR.NO ORDER BY P.ENROLL_DATE DESC ) A ) B WHERE ROWNUM BETWEEN 1 AND 5";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<ProductInfoVo> recentEnrollList = new ArrayList<ProductInfoVo>();
		while(rs.next()) {
			String brandName =  rs.getString("브랜드명");
			String productName = rs.getString("상품명");
			String productNameKo = rs.getString("한국이름");
			String immediatePrice = rs.getString("즉시구매가");
			
			if(immediatePrice==null) {
				immediatePrice = "-";
			}
			
			
			ProductInfoVo vo = new ProductInfoVo(brandName, productName, productNameKo, immediatePrice);
			recentEnrollList.add(vo);
			
		}
		
		return recentEnrollList;
	}

	public List<ProductInfoVo> getNewImmediatePriceList(Connection conn) throws Exception {
		//sql
		String sql = "SELECT * FROM ( SELECT ROWNUM , A.* FROM ( SELECT P.NAME 상품명 , P.NAME_KO 한국이름, BR.BRAND_NAME 브랜드 , SS.SHOES_SIZES 사이즈 , B.PRICE 즉시구매가 FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN BRAND BR ON P.BRAND_NO = BR.NO LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE B.BIDDING_STATUS_NO = 1 AND B.BIDDING_POSITION_NO = 1 ORDER BY B.ENROLL_DATE DESC ) A )B WHERE ROWNUM BETWEEN 1 AND 5";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<ProductInfoVo> newImmediatePriceList = new ArrayList<ProductInfoVo>();
		while(rs.next()) {
			String brandName =  rs.getString("브랜드");
			String productName = rs.getString("상품명");
			String productNameKo = rs.getString("한국이름");
			String immediatePrice = rs.getString("즉시구매가");

			if(immediatePrice==null) {
				immediatePrice = "-";
			}
			
			ProductInfoVo vo = new ProductInfoVo(brandName, productName, productNameKo, immediatePrice);
			newImmediatePriceList.add(vo);
			
		}
		return newImmediatePriceList;
	}

	
	
}
