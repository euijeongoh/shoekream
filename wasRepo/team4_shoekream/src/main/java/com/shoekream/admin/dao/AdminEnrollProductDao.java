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
	//상품 등록
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
	//상품 번호를 가져오기
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
	//사이즈 배열을 db에 등록하기
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
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT P.NO AS NO , P.NAME AS NAME, P.NAME_KO AS NAME_KO, P.MODEL_NUMBER AS MODEL_NUMBER, P.RELEASE_PRICE AS RELEASE_PRICE, P.RELEASE_DATE AS RELEASE_DATE, C.CATEGORY_NAME AS CATEGORY_NAME, B.BRAND_NAME AS BRAND_NAME FROM PRODUCTS P INNER JOIN CATEGORY C ON P.CATEGORY_NO = C.NO INNER JOIN BRAND B ON P.BRAND_NO = B.NO WHERE P.DEL_YN = 'N' ORDER BY P.MODEL_NUMBER DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		List<EnrollProductVo> voList = new ArrayList<EnrollProductVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String nameKo = rs.getString("NAME_KO");
			String modelNumber = rs.getString("MODEL_NUMBER");
			String category = rs.getString("CATEGORY_NAME");
			String brand = rs.getString("BRAND_NAME");
			String releasePrice = rs.getString("RELEASE_PRICE");
			String releaseDate = rs.getString("RELEASE_DATE");
			EnrollProductVo dbVo = new EnrollProductVo();
			dbVo.setProductNo(no);
			dbVo.setProductName(name);
			dbVo.setProductNameKo(nameKo);
			dbVo.setModelNumber(modelNumber);
			dbVo.setCategory(category);
			dbVo.setBrand(brand);
			dbVo.setReleasePrice(releasePrice);
			dbVo.setReleaseDate(releaseDate);
			
			voList.add(dbVo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return voList;
	}
	//상품의 갯수 출력(페이징을 위한)
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
	//상품목록에서 상품 지우기
	public int delete(Connection conn, EnrollProductVo vo) throws Exception{
		
		String sql = "UPDATE PRODUCTS SET DEL_YN = 'Y' WHERE MODEL_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = 0;
		
		String[] modelNumbers = vo.getModelNumbers();
		for(String modelNumber : modelNumbers) {
			pstmt.setString(1, modelNumber);
			result += pstmt.executeUpdate();
					
		}
		if(result == modelNumbers.length) {
			result = 1;
			JDBCTemplate.close(pstmt);
			return result;
		}else {
			result = 0;
			JDBCTemplate.close(pstmt);
			return result;
		}
		
		
	}
	//상품 정보수정을 위해 상품정보 불러오기
	public EnrollProductVo getProductInfo(Connection conn, String modelNumber) throws Exception{
		String sql = "SELECT * FROM PRODUCTS WHERE MODEL_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, modelNumber);
		ResultSet rs = pstmt.executeQuery();
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			String productNo = rs.getString("NO");
			String name = rs.getString("NAME");
			String nameKo = rs.getString("NAME_KO");
			String releasePrice = rs.getString("RELEASE_PRICE");
			String releaseDate = rs.getString("RELEASE_DATE");
			String categoryNo = rs.getString("CATEGORY_NO");
			String brandNo = rs.getString("BRAND_NO");
			
			dbVo = new EnrollProductVo();
			
			dbVo.setProductNo(productNo);
			dbVo.setProductName(name);
			dbVo.setProductNameKo(nameKo);
			dbVo.setReleaseDate(releaseDate);
			dbVo.setReleasePrice(releasePrice);
			dbVo.setCategoryNo(categoryNo);
			dbVo.setBrandNo(brandNo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	}
	//상품 정보수정을 위해 사이즈배열 가져오기
	public List<String> getProductSizesInfo(Connection conn, String productNo) throws Exception{
		String sql = "SELECT PS.PRODUCT_NO AS PRODUCT_NO, SS.SHOES_SIZES AS SIZES FROM PRODUCT_SIZES PS JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE PS.PRODUCT_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		List<String> sizes = new ArrayList<>();
		while(rs.next()) {
			String size = rs.getString("SIZES");
			sizes.add(size);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return sizes;
		
	}
	//상품 정보 수정을 위해 카테고리 이름 가져오기
	public EnrollProductVo getProductCategoryInfo(Connection conn, String categoryNo) throws Exception{
		String sql = "SELECT CATEGORY_NAME FROM CATEGORY WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, categoryNo);
		ResultSet rs = pstmt.executeQuery();
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			String categoryName = rs.getString("CATEGORY_NAME");
			dbVo = new EnrollProductVo();
			dbVo.setCategory(categoryName);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	}
	//브랜드 번호로 브랜드명 가져오기
	public EnrollProductVo getProductBrandInfo(Connection conn, String brandNo) throws Exception{
		String sql = "SELECT BRAND_NAME FROM BRAND WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, brandNo);
		ResultSet rs = pstmt.executeQuery();
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			String brandName = rs.getString("BRAND_NAME");
			dbVo = new EnrollProductVo();
			
			dbVo.setBrand(brandName);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}

	public int editProduct(Connection conn, EnrollProductVo vo) throws Exception{
		String sql = "UPDATE PRODUCTS SET BRAND_NO = ?, CATEGORY_NO = ?, NAME = ?, NAME_KO = ?, MODEL_NUMBER = ?, RELEASE_PRICE = ?, RELEASE_DATE = ?, DEL_YN = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBrandNo());
		pstmt.setString(2, vo.getCategoryNo());
		pstmt.setString(3, vo.getProductName());
		pstmt.setString(4, vo.getProductNameKo());
		pstmt.setString(5, vo.getModelNumber());
		pstmt.setString(6, vo.getReleasePrice());
		pstmt.setString(7, vo.getReleaseDate());
		pstmt.setString(8, vo.getDelYn());
		pstmt.setString(9, vo.getProductNo());

		int result = pstmt.executeUpdate();
		System.out.println("dao result : " + result);
		JDBCTemplate.close(pstmt);

		return result;
	}

	public int editProductSize(Connection conn, EnrollProductVo productSizesVo)throws Exception {
		String[] sizeNo = productSizesVo.getSizeNo();
		int result = 0;
		for(String size :sizeNo) {
			String sql = "UPDATE PRODUCT_SIZES SET SHOES_SIZES_NO = ? WHERE PRODUCT_NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, size);
			pstmt.setString(2, productSizesVo.getProductNo());
			result += pstmt.executeUpdate();

			JDBCTemplate.close(pstmt);
			
		}
		if(sizeNo.length == result) {
			return 1;
		}else {
			return 0;
		}
	}

	public EnrollProductVo getEnrolledProductNo(Connection conn, String modelNumber) throws Exception{
		String sql = "SELECT NO FROM PRODUCTS WHERE MODEL_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, modelNumber);
		ResultSet rs = pstmt.executeQuery();
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			String no = String.valueOf(rs.getInt(1));
			dbVo = new EnrollProductVo();
			dbVo.setProductNo(no);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	
	}

	
	
}
