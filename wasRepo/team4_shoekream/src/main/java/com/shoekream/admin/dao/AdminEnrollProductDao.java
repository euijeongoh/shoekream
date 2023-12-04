package com.shoekream.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;

public class AdminEnrollProductDao {

	//카테고리 이름->번호 문자열로 반환
	public EnrollProductVo categoryCheck(Connection conn, String category) throws Exception{
		String sql = "SELECT * FROM CATEGORY WHERE CATEGORY_NAME = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, category);

		ResultSet rs = pstmt.executeQuery();
		
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			int categoryNo = rs.getInt(1);
			dbVo = new EnrollProductVo();
			dbVo.setCategoryNo(String.valueOf(categoryNo));
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}
	//브랜드 이름 -> 번호 문자열로 반환
	public EnrollProductVo brandCheck(Connection conn, String brand) throws Exception{
		String sql = "SELECT * FROM BRAND WHERE BRAND_NAME = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, brand);
		
		ResultSet rs = pstmt.executeQuery();
		
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			int brandNo = rs.getInt(1);
			dbVo= new EnrollProductVo();
			dbVo.setBrandNo(String.valueOf(brandNo));
		}
				
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}
	//사이즈 배열 -> 사이즈 번호 배열로 반환
	public EnrollProductVo sizeCheck(Connection conn, String[] size) {

		String sql = "SELECT * FROM ";
		return null;
	}

	public int enrollProduct(Connection conn, EnrollProductVo vo) throws Exception{
		String sql = "INSERT INTO PRODUCTS(NO, BRAND_NO, CATEGORY_NO, NAME, NAME_KO, MODEL_NUMBER, RELEASE_PRICE, RELEASE_DATE, DEL_YN) VALUES(SEQ_PRODUCTS_NO.NEXTVAL, ?,?,)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(0, sql);
		pstmt.setString(0, sql);
		pstmt.setString(0, sql);
		pstmt.setString(0, sql);
		
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
