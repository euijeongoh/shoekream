package com.shoekream.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;

public class ProductDetailDao {
	//PRODUCTS테이블에서 데이터 추출
	public EnrollProductVo getProductDetail(Connection conn, EnrollProductVo enrolledProductVo) throws Exception{
		String sql = "SELECT * FROM PRODUCTS WHERE MODEL_NUMBER=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, enrolledProductVo.getModelNumber());
		
		ResultSet rs = pstmt.executeQuery();
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			String productNo = rs.getString("NO");
			String name = rs.getString("NAME");
			String nameKo = rs.getString("NAME_KO");
			String releasePrice = rs.getString("RELEASE_PRICE");
			String releaseDate = rs.getString("RELEASE_DATE");
			String modelNumber = rs.getString("MODEL_NUMBER");
					
			dbVo = new EnrollProductVo();
			dbVo.setProductNo(productNo);
			dbVo.setProductName(name);
			dbVo.setProductNameKo(nameKo);
			dbVo.setReleasePrice(releasePrice);
			dbVo.setEnrollDate(releaseDate);
			dbVo.setModelNumber(modelNumber);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	}

	
	//SHOES_SIZES테이블에서 데이터 추출
	public EnrollProductVo getShoesSizesDetail(Connection conn, EnrollProductVo productDetailVo) throws Exception{
		
		String sql = "SELECT PS.PRODUCT_NO, SS.SHOES_SIZES FROM PRODUCT_SIZES PS JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE PS.PRODUCT_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productDetailVo.getProductNo());
		
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return  dbVo;
	}
	
	
	//BIDDING테이블에서 데이터 추출

}
