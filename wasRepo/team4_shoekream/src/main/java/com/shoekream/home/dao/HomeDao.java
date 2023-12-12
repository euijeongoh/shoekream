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
		String sql = "SELECT * FROM ( SELECT ROWNUM , A.* FROM ( SELECT P.NO PRODUCT_NO, P.NAME PRODUCT_NAME, IMG.THUMBNAIL THUMBNAIL, BR.BRAND_NAME BRAND, P.MODEL_NUMBER MODEL,  MIN(B.PRICE) AS MIN_PRICE, MAX(P.ENROLL_DATE) AS PRODUCT_ENROLL_DATE FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN BRAND BR ON BR.NO = P.BRAND_NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO WHERE B.BIDDING_POSITION_NO = 2 GROUP BY P.NO, P.NAME, IMG.THUMBNAIL, BR.BRAND_NAME, P.MODEL_NUMBER ORDER BY MIN_PRICE ASC, PRODUCT_ENROLL_DATE DESC ) A ) WHERE ROWNUM BETWEEN 1 AND 5";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<ProductInfoVo> recentEnrollList = new ArrayList<ProductInfoVo>();
		while(rs.next()) {
			String productNo =  rs.getString("PRODUCT_NO");
			String productName = rs.getString("PRODUCT_NAME");
			String thumbnail = rs.getString("THUMBNAIL");
			String brand = rs.getString("BRAND");
			String model = rs.getString("MODEL");
			String immediatePrice = rs.getString("MIN_PRICE");
			String productEnrollDate = rs.getString("PRODUCT_ENROLL_DATE");
			
			if(immediatePrice==null) {
				immediatePrice = "-";
			}
			
			
			ProductInfoVo vo = new ProductInfoVo(productNo, productName, thumbnail, brand, model, immediatePrice, productEnrollDate);
			recentEnrollList.add(vo);
			
		}
		
		return recentEnrollList;
	}

	public List<ProductInfoVo> getNewImmediatePriceList(Connection conn) throws Exception {
		//sql
		String sql = "SELECT * FROM ( SELECT ROWNUM , A.* FROM ( SELECT P.NO PRODUCT_NO, P.NAME PRODUCT_NAME, IMG.THUMBNAIL THUMBNAIL, BR.BRAND_NAME BRAND, P.MODEL_NUMBER MODEL, MIN(B.PRICE) AS MIN_PRICE, MAX(B.ENROLL_DATE) AS LATEST_ENROLL_DATE FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO LEFT JOIN BRAND BR ON BR.NO = P.BRAND_NO LEFT JOIN IMAGE IMG ON IMG.PRODUCT_NO = P.NO WHERE B.BIDDING_POSITION_NO = 2 GROUP BY P.NO, P.NAME, IMG.THUMBNAIL, BR.BRAND_NAME, P.MODEL_NUMBER ORDER BY MIN_PRICE ASC, LATEST_ENROLL_DATE DESC ) A ) WHERE ROWNUM BETWEEN 1 AND 5";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		List<ProductInfoVo> newImmediatePriceList = new ArrayList<ProductInfoVo>();
		while(rs.next()) {
			String productNo =  rs.getString("PRODUCT_NO");
			String productName = rs.getString("PRODUCT_NAME");
			String thumbnail = rs.getString("THUMBNAIL");
			String brand = rs.getString("BRAND");
			String model = rs.getString("MODEL");
			String minPrice = rs.getString("MIN_PRICE");
			String latestEnrollDate = rs.getString("LATEST_ENROLL_DATE");

			if(minPrice==null) {
				minPrice = "-";
			}
			
			ProductInfoVo vo = new ProductInfoVo(productNo, productName, thumbnail, brand, model, minPrice, latestEnrollDate);
			newImmediatePriceList.add(vo);
			
		}
		return newImmediatePriceList;
	}

	
	
}
