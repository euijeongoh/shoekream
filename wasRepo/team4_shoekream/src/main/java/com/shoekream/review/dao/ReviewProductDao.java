package com.shoekream.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.review.vo.ReviewProductVo;

public class ReviewProductDao {

	// 카테고리 이름->번호 문자열로 반환
	public EnrollProductVo categoryCheck(Connection conn, String category) throws Exception {
		String sql = "SELECT * FROM CATEGORY WHERE CATEGORY_NAME = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, category);

		ResultSet rs = pstmt.executeQuery();

		EnrollProductVo dbVo = null;
		if (rs.next()) {
			int categoryNo = rs.getInt(1);
			dbVo = new EnrollProductVo();
			dbVo.setCategoryNo(String.valueOf(categoryNo));
		}

		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}
	
	
	//브랜들 이름                                                                                                                                                      
	public ReviewProductVo brandCheck(Connection conn, ReviewProductVo vo) throws Exception{
		String sql = "SELECT * FROM PRODUCTS WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProductNo());
		ResultSet rs = pstmt.executeQuery();
		ReviewProductVo dbVo = new ReviewProductVo();
		if(rs.next()) {
			int productNo = rs.getInt(1);
			dbVo.setProductNo(String.valueOf(productNo));
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}
	
	
	//제품
	public int reviewProduct(Connection conn, EnrollProductVo vo) throws Exception {
		String sql = "INSERT INTO PRODUCTS(NO, BRAND_NO, CATEGORY_NO, NAME, NAME_KO, MODEL_NUMBER, RELEASE_PRICE, RELEASE_DATE, DEL_YN) VALUES(SEQ_PRODUCTS_NO.NEXTVAL, ?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBrandNo());
		pstmt.setString(2, vo.getCategoryNo());
		pstmt.setString(3, vo.getProductName());
		pstmt.setString(4, vo.getProductNameKo());
		pstmt.setString(5, vo.getModelNumber());
		pstmt.setString(6, vo.getReleasePrice());
		pstmt.setString(7, vo.getReleaseDate());
		pstmt.setString(8, vo.getDelYn());

		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}
	
	public ReviewProductVo getReviewProductNo(Connection conn, EnrollProductVo vo) throws Exception{
		String sql = "SELECT NO FROM PRODUCTS WHERE MODEL_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getModelNumber());
		ResultSet rs = pstmt.executeQuery();
		ReviewProductVo dbVo = new ReviewProductVo();
		if(rs.next()) {
			int productNo = rs.getInt(1);
			dbVo.setProductNo(String.valueOf(productNo));
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}
	
}
