package com.shoekream.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;

public class AdminEnrollProductDao {

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

	// 브랜드 이름 -> 번호 문자열로 반환
	public EnrollProductVo brandCheck(Connection conn, String brand) throws Exception {
		String sql = "SELECT * FROM BRAND WHERE BRAND_NAME = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, brand);

		ResultSet rs = pstmt.executeQuery();

		EnrollProductVo dbVo = null;
		if (rs.next()) {
			int brandNo = rs.getInt(1);
			dbVo = new EnrollProductVo();
			dbVo.setBrandNo(String.valueOf(brandNo));
		}

		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}

	// 사이즈 배열 -> 사이즈 번호 배열로 반환
	public EnrollProductVo sizeCheck(Connection conn, String[] sizes) throws Exception {
		EnrollProductVo dbVo = new EnrollProductVo();
		List<String> sizeNoList = new ArrayList<>();
		for (String size : sizes) {
			// sql
			String sql = "SELECT * FROM SHOES_SIZES WHERE SHOES_SIZES = ?";
			// rs
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, size);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int sizeNo = rs.getInt(1);
				sizeNoList.add(String.valueOf(sizeNo));
			}
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		String[] sizeNoArr = sizeNoList.toArray(new String[0]);
		dbVo.setSizeNo(sizeNoArr);
		return dbVo;

	}

	public int enrollProduct(Connection conn, EnrollProductVo vo) throws Exception {
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
	
	public EnrollProductVo getEnrolledProductNo(Connection conn, EnrollProductVo vo) throws Exception{
		String sql = "SELECT NO FROM PRODUCTS WHERE MODEL_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getModelNumber());
		ResultSet rs = pstmt.executeQuery();
		EnrollProductVo dbVo = new EnrollProductVo();
		if(rs.next()) {
			int productNo = rs.getInt(1);
			dbVo.setProductNo(String.valueOf(productNo));
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}

	public int enrollProductSize(Connection conn, EnrollProductVo productSizesVo) throws Exception{
		String[] sizeNo = productSizesVo.getSizeNo();
		int result = 0;
		for(String size :sizeNo) {
			String sql = "INSERT INTO PRODUCT_SIZES(NO, PRODUCT_NO, SHOES_SIZES_NO) VALUES(SEQ_PRODUCT_SIZES_NO.NEXTVAL, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productSizesVo.getProductNo());
			pstmt.setString(2, size);
			result += pstmt.executeUpdate();

			JDBCTemplate.close(pstmt);
			
		}
		if(sizeNo.length == result) {
			return 1;
		}else {
			return 0;
		}
	}
	//제품 목록 조회
	public List<EnrollProductVo> selectProductList(Connection conn, PageVo pvo) throws Exception{
		//sql
		String sql = "SELECT NAME_KO, MODEL_NUMBER FROM PRODUCTS";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<EnrollProductVo> voList = new ArrayList<EnrollProductVo>();
		while(rs.next()) {
			String nameKo = rs.getString("NAME_KO");
			String modelNumber = rs.getString("MODEL_NUMBER");
			EnrollProductVo dbVo = new EnrollProductVo();
			dbVo.setProductNameKo(nameKo);
			dbVo.setModelNumber(modelNumber);
			
			voList.add(dbVo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}

	public int selectProductCount(Connection conn) throws Exception {
		String sql = "SELECT COUNT(*) FROM PRODUCTS WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return cnt;
	}

	public int delete(Connection conn, EnrollProductVo vo) throws Exception{
		
		
		for (EnrollProductVo vo : enrollProductVo) {
			
		}
		String sql = "UPDATE PRODUCTS SET DEL_YN = 'Y' WHERE MODEL_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getModelNumber());
		
		
		
	}
	
}
