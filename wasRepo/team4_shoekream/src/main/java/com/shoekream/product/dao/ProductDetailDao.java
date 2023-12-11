package com.shoekream.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;

public class ProductDetailDao {
	//PRODUCTS테이블에서 데이터 추출
	public EnrollProductVo getProductDetail(Connection conn, String modelNumber) throws Exception{
		String sql = "SELECT * FROM PRODUCTS WHERE MODEL_NUMBER=?";
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
					
			dbVo = new EnrollProductVo();
			dbVo.setProductNo(productNo);
			dbVo.setProductName(name);
			dbVo.setProductNameKo(nameKo);
			dbVo.setReleasePrice(releasePrice);
			dbVo.setEnrollDate(releaseDate);
			
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
	    ResultSet rs = pstmt.executeQuery();
	    EnrollProductVo dbVo = new EnrollProductVo();
	    List<String> shoesSizesList = new ArrayList<>();
	    while(rs.next()) {
	        String shoesSizes = rs.getString("SS.SHOES_SIZES");
	        shoesSizesList.add(shoesSizes);
	    }
	    // 조회한 사이즈 정보를 EnrollProductVo 객체에 설정
	    String[] shoesSizesArray = shoesSizesList.toArray(new String[0]);
	    dbVo.setSize(shoesSizesArray);

	    JDBCTemplate.close(rs);
	    JDBCTemplate.close(pstmt);

	    return dbVo;
	}

	//체결거래탭에서 가져오기
	public List<BiddingVo> getBiddingDetail(Connection conn, String productNo) throws Exception {
	    String sql = "SELECT * FROM ( SELECT B.PRICE, B.EXPIRE_DATE, SS.SHOES_SIZES FROM BIDDING B LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_NO=PS.PRODUCT_NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO= SS.NO WHERE B.PRODUCTS_NO = ? AND B.BIDDING_STATUS_NO= 3 ORDER BY B.EXPIRE_DATE DESC ) WHERE ROWNUM <= 5;";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, productNo);
	    ResultSet rs = pstmt.executeQuery();
	    List<BiddingVo> biddingList = new ArrayList<BiddingVo>();
	    
	    while (rs.next()) {
	        BiddingVo dbVo = new BiddingVo();
	        // 현재 결과 셋에서 사용할 수 있는 필드만 설정
	        dbVo.setPrice(rs.getString("PRICE"));
	        dbVo.setExpireDate(rs.getString("EXPIRE_DATE"));
	        dbVo.setShoesSizes(rs.getString("SHOES_SIZES"));
	        biddingList.add(dbVo);
	    }
	    
	    rs.close();
	    pstmt.close();
	    
	    return biddingList;
	}
	
	//BIDDING테이블에서 데이터 추출
	public List<EnrollProductVo> getProductList(Connection conn) throws Exception{
		String sql = "SELECT P.NO AS NO, P.NAME AS NAME, P.RELEASE_PRICE AS RELEASE_PRICE, B.BRAND_NAME AS BRAND_NAME FROM PRODUCTS P JOIN BRAND B ON B.NO = P.BRAND_NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<EnrollProductVo> dbVo = new ArrayList<EnrollProductVo>();
		EnrollProductVo vo = null;
		while(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String releasePrice= rs.getString("RELEASE_PRICE");
			String brandName = rs.getString("BRAND_NAME");
			vo = new EnrollProductVo();
			vo.setProductNo(no);
			vo.setProductName(name);
			vo.setReleasePrice(releasePrice);
			vo.setBrand(brandName);
			dbVo.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}
}
