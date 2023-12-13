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
			dbVo.setReleaseDate(releaseDate);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	}

	
	//SHOES_SIZES테이블에서 데이터 추출
	public List<EnrollProductVo> getShoesSizesDetail(Connection conn, EnrollProductVo productDetailVo) throws Exception {
	    String sql = "SELECT PS.PRODUCT_NO AS PRODUCT_NO, SS.SHOES_SIZES AS SHOES_SIZES FROM PRODUCT_SIZES PS JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO WHERE PS.PRODUCT_NO = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, productDetailVo.getProductNo());
	    ResultSet rs = pstmt.executeQuery();

	    List<EnrollProductVo> shoesSizesList = new ArrayList<>();
	    while (rs.next()) {
	        EnrollProductVo dbVo = new EnrollProductVo();
	        String productNo = rs.getString("PRODUCT_NO");
	        String sizeStr = rs.getString("SHOES_SIZES");
	        
	        dbVo.setProductNo(productNo);
	        dbVo.setSizeStr(sizeStr); 
	        
	        shoesSizesList.add(dbVo);
	    }
	    JDBCTemplate.close(rs);
	    JDBCTemplate.close(pstmt);

	    return shoesSizesList;
	}


	//체결거래탭에서 가져오기
	public List<BiddingVo> getBiddingDetail(Connection conn, String productNo) throws Exception {
	    String sql = "SELECT * FROM ( SELECT B.PRICE, B.EXPIRE_DATE, SS.SHOES_SIZES FROM BIDDING B LEFT JOIN PRODUCT_SIZES PS ON B.PRODUCTS_NO=PS.PRODUCT_NO LEFT JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO= SS.NO WHERE B.PRODUCTS_NO = ? AND B.BIDDING_STATUS_NO= 3 ORDER BY B.EXPIRE_DATE DESC ) WHERE ROWNUM <= 5";
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
	    
	    JDBCTemplate.close(rs);
	    JDBCTemplate.close(pstmt);
	    
	    return biddingList;
	}
	
	//특정 상품의 구매입찰 목록을 보여주기
	public List<BiddingVo> getBuyBiddingList(Connection conn, String productNo) throws Exception{
		String sql = "SELECT B.NO, B.PRODUCTS_NO, P.NAME, B.PRICE, B.ENROLL_DATE FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO WHERE B.PRODUCTS_NO = ? AND B.BIDDING_POSITION_NO = 1 ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		List<BiddingVo> biddingList = new ArrayList<BiddingVo>();
		
		while(rs.next()) {
			BiddingVo dbVo = new BiddingVo();
			dbVo.setNo(rs.getString("NO"));
			dbVo.setProductsNo(rs.getString("PRODUCTS_NO"));
			dbVo.setProductsName(rs.getString("NAME"));
			dbVo.setPrice(rs.getString("PRICE"));
			dbVo.setEnrollDate(rs.getString("ENROLL_DATE"));
			biddingList.add(dbVo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return biddingList;
	}
	//특정 상품의 판매입찰 목록을 보여주기
	public List<BiddingVo> getSellBiddingList(Connection conn, String productNo) throws Exception{
		String sql = "SELECT B.NO, B.PRODUCTS_NO, P.NAME, B.PRICE, B.ENROLL_DATE FROM BIDDING B LEFT JOIN PRODUCTS P ON B.PRODUCTS_NO = P.NO WHERE B.PRODUCTS_NO = ? AND B.BIDDING_POSITION_NO = 2 ORDER BY B.ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		List<BiddingVo> biddingList = new ArrayList<BiddingVo>();
		
		while(rs.next()) {
			BiddingVo dbVo = new BiddingVo();
			dbVo.setNo(rs.getString("NO"));
			dbVo.setProductsNo(rs.getString("PRODUCTS_NO"));
			dbVo.setProductsName(rs.getString("NAME"));
			dbVo.setPrice(rs.getString("PRICE"));
			dbVo.setEnrollDate(rs.getString("ENROLL_DATE"));
			biddingList.add(dbVo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return biddingList;
	}
	
	//BIDDING테이블에서 데이터 추출
	
	    
	//
	public List<EnrollProductVo> getProductList(Connection conn) throws Exception{
		String sql = "SELECT P.NO AS NO, P.NAME AS NAME, P.RELEASE_PRICE AS RELEASE_PRICE, P.MODEL_NUMBER AS MODEL_NUMBER, B.BRAND_NAME AS BRAND_NAME FROM PRODUCTS P JOIN BRAND B ON B.NO = P.BRAND_NO ORDER BY P.NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<EnrollProductVo> dbVo = new ArrayList<EnrollProductVo>();
		EnrollProductVo vo = null;
		while(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String releasePrice= rs.getString("RELEASE_PRICE");
			String brandName = rs.getString("BRAND_NAME");
			String modelNumber = rs.getString("MODEL_NUMBER");
			vo = new EnrollProductVo();
			vo.setProductNo(no);
			vo.setProductName(name);
			vo.setReleasePrice(releasePrice);
			vo.setBrand(brandName);
			vo.setModelNumber(modelNumber);
			dbVo.add(vo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return dbVo;
	}

	//즉시판매가 구하기
	public String getBuyingPrice(Connection conn, String productNo) throws Exception{
		String sql = "SELECT SHOES_SIZES , MAX(PRICE) AS PRICE FROM ( SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE PRODUCTS_NO = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '구매입찰' AND B.EXPIRE_DATE >= SYSDATE ) GROUP BY SHOES_SIZES";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		String price = null;
		if(rs.next()) {
			price = rs.getString("PRICE");
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return price;
	}

	//즉시구매가 구하
	public String getSellingPrice(Connection conn, String productNo) throws Exception{
		String sql = "SELECT SHOES_SIZES , MIN(PRICE) AS PRICE FROM ( SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE PRODUCTS_NO = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '판매입찰' AND B.EXPIRE_DATE >= SYSDATE ) GROUP BY SHOES_SIZES";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		String price = null;
		if(rs.next()) {
			price = rs.getString("PRICE");
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return price;
	}

	//위시리스트 추가
	public int addWishList(Connection conn, String memberNo, String productNo) throws Exception{
		String sql = "INSERT INTO WISHLIST(NO, MEMBER_NO, PRODUCTS_NO, WISH_DATE) VALUES(SEQ_WISHLIST_NO.NEXTVAL, ?,?,SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, productNo);
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}	
}
