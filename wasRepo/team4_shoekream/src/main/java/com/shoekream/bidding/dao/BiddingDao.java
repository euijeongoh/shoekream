package com.shoekream.bidding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.biddingVo.TestVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AddrBookVo;
import com.shoekream.product.vo.ProductInfoVo;

public class BiddingDao {


	// 구매하기
	public List<BiddingVo> buySelect(Connection conn, String productsNo) throws Exception{

		// sql
		String sql = "SELECT SHOES_SIZES, MIN(PRICE) AS PRICE FROM ( SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE PRODUCTS_NO = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '판매입찰' AND B.EXPIRE_DATE >= SYSDATE ) GROUP BY SHOES_SIZES";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productsNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<BiddingVo> voList = new ArrayList<BiddingVo>();
		while(rs.next()) {
			BiddingVo dbVo = new BiddingVo();
			dbVo.setShoesSizes(rs.getString("SHOES_SIZES"));
			dbVo.setPrice(rs.getString("PRICE"));
			voList.add(dbVo);
			//			System.out.println("에러확인 SHOES_SIZES : "+rs.getString("SHOES_SIZES"));
			//			System.out.println("에러확인 PRICE : "+rs.getString("PRICE"));
		}

		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return voList;
	}


	
	
	
	// 구매 상품 정보(즉시 구매가 : 판매입찰)
	public BiddingVo buyProductList(Connection conn, BiddingVo vo) throws Exception{
		System.out.println(vo.getProductsNo());
		System.out.println(vo.getPrice());
		System.out.println(vo.getShoesSizes());
		
		// sql
		String sql = "SELECT B.NO AS NO ,B.MEMBER_NO AS MEMBER_NO ,B.PRODUCTS_NO AS PRODUCTS_NO ,B.PRODUCTS_SIZES_NO AS PRODUCTS_SIZES_NO ,SS.SHOES_SIZES AS SHOES_SIZES ,B.BIDDING_STATUS_NO AS BIDDING_STATUS_NO ,BS.BIDDING_STATUS AS BIDDING_STATUS ,B.BIDDING_POSITION_NO AS BIDDING_POSITION_NO ,BP.BIDDING_POSITION AS BIDDING_POSITION ,B.PRICE AS PRICE ,B.ENROLL_DATE AS ENROLL_DATE ,B.EXPIRE_DATE AS EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '판매입찰' AND B.EXPIRE_DATE >= SYSDATE AND B.PRODUCTS_NO = ? AND B.PRICE = ? AND SS.SHOES_SIZES = ? ORDER BY NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProductsNo());
		pstmt.setString(2, vo.getPrice());
		pstmt.setString(3, vo.getShoesSizes());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		BiddingVo buyPrVo = null;
		if(rs.next()) {
			buyPrVo = new BiddingVo();
			buyPrVo.setShoesSizes(rs.getString("SHOES_SIZES"));
			buyPrVo.setPrice(rs.getString("PRICE"));
						System.out.println("buyProductList : 판매입찰(즉시구매가)");
						System.out.println("dao에러확인 SHOES_SIZES : "+rs.getString("SHOES_SIZES"));
						System.out.println("dao에러확인 PRICE : "+rs.getString("PRICE"));
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return buyPrVo;
	}
	// 판매 상품 정보(즉시 판매가 : 구매입찰)
	public BiddingVo sellProductList(Connection conn, BiddingVo vo) throws Exception{
		System.out.println(vo.getProductsNo());
		System.out.println(vo.getShoesSizes());
		// sql
		String sql = "SELECT SHOES_SIZES , MAX(PRICE) AS PRICE FROM ( SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE PRODUCTS_NO = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '구매입찰' AND B.EXPIRE_DATE >= SYSDATE ) GROUP BY SHOES_SIZES HAVING SHOES_SIZES = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProductsNo());
		pstmt.setString(2, vo.getShoesSizes());
		ResultSet rs = pstmt.executeQuery();

		// rs
		BiddingVo sellPrVo = null;
		if(rs.next()) {
			sellPrVo = new BiddingVo();
			sellPrVo.setShoesSizes(rs.getString("SHOES_SIZES"));
			sellPrVo.setPrice(rs.getString("PRICE"));
						System.out.println("sellProductList : 구매입찰(즉시판매가)");
						System.out.println("dao에러확인 SHOES_SIZES : "+rs.getString("SHOES_SIZES"));
						System.out.println("dao에러확인 PRICE : "+rs.getString("PRICE"));
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return sellPrVo;
	}

	
	
	
	
	// 입찰 상품 정보 조회
	public BiddingVo productInfo(Connection conn, BiddingVo vo) throws Exception{

		// sql
		String sql = "SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.PRODUCTS_NO = ? AND B.PRICE = ? AND SS.SHOES_SIZES = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '판매입찰' AND B.EXPIRE_DATE >= SYSDATE ORDER BY NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProductsNo());
		pstmt.setString(2, vo.getPrice());
		pstmt.setString(3, vo.getShoesSizes());
		ResultSet rs = pstmt.executeQuery();

		// rs
		BiddingVo dbVo = null;
		if(rs.next()) {
			dbVo = new BiddingVo();
			dbVo.setNo(rs.getString(1));
			dbVo.setMemberNo(rs.getString(2));
			dbVo.setProductsNo(rs.getString(3));
			dbVo.setProductsSizesNo(rs.getString(4));
			dbVo.setShoesSizes(rs.getString(5));
			dbVo.setBiddingStatusNo(rs.getString(6));
			dbVo.setBiddingStatus(rs.getString(7));
			dbVo.setBiddingPositionNo(rs.getString(8));
			dbVo.setBiddingPosition(rs.getString(9));
			dbVo.setPrice(rs.getString(10));
			dbVo.setEnrollDate(rs.getString(11));
			dbVo.setExpireDate(rs.getString(12));
			System.out.println("productInfo : 상품 정보 조회");
			System.out.println("dao에러확인 dbVo : " + dbVo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return dbVo;
	}
	// 제품 정보
	public ProductInfoVo productInfo(Connection conn, String no) throws Exception{

		// sql
		String sql = "SELECT NO ,BRAND_NO ,CATEGORY_NO ,NAME ,NAME_KO ,MODEL_NUMBER ,RELEASE_PRICE ,RELEASE_DATE ,ENROLL_DATE ,MODIFY_DATE ,DEL_YN FROM PRODUCTS WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  no);
		ResultSet rs = pstmt.executeQuery();

		// rs
		ProductInfoVo infoVo = null;
		if(rs.next()) {
			infoVo = new ProductInfoVo();
			infoVo.setProductName(rs.getString(4));;
			infoVo.setProductKoName(rs.getString(5));;
			infoVo.setImmediatePrice(rs.getString(6));;
			System.out.println("infoVo : 제품 정보");
			System.out.println("dao에러확인 infoVo : " + infoVo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return infoVo;
	}


	
	

	// 주소록 조회
	public AddrBookVo addInfo(Connection conn, String loginMemberNo) throws Exception{

		// sql
		String sql = "SELECT * FROM ADDERSS_BOOK WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemberNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		AddrBookVo addInfo = null;
		if(rs.next()) {
			addInfo = new AddrBookVo();
			addInfo.setNo(rs.getString(1));
			addInfo.setMemberNo(rs.getString(2));
			addInfo.setAddersName(rs.getString(3));
			addInfo.setAddres(rs.getString(4));
			addInfo.setDetailAddres(rs.getString(5));
			addInfo.setPhoneNumber(rs.getString(6));
			addInfo.setPostCode(rs.getString(7));
			addInfo.setDefaultAddrYn(rs.getString(8));
			addInfo.setDelYn(rs.getString(9));
			addInfo.setEnrollDate(rs.getString(10));
			System.out.println("addInfo : 주소록 조회");
			System.out.println("dao에러확인 addInfo : " + addInfo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return addInfo;
	}
	// 계좌 조회
	public TestVo accInfo(Connection conn, String loginMemberNo) throws Exception {

		// sql
		String sql = "SELECT A.NO ,A.MEMBER_NO ,A.BANK_AGENT_NO ,A.ACCOUNT_NUMBER ,A.DEPOSITOR ,A.ENROLL_DATE ,BA.NO ,BA.BANK_COMPANY_NAME FROM ACCOUNT A JOIN BANK_AGENT BA ON A.NO = BA.NO WHERE A.NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemberNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		TestVo accInfo = null;
		if(rs.next()) {
			accInfo = new TestVo();
			System.out.println("accInfo : 계좌 조회");
			System.out.println("dao에러확인 accInfo : " + accInfo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return accInfo;
	}
	// 카드 조회
	public TestVo cardInfo(Connection conn, String loginMemberNo) throws Exception {

		// sql
		String sql = "SELECT C.NO ,C.MEMBER_NO ,C.CARD_COMPANY_NO ,C.CARD_NUMBER ,C.EXPIRATION_DATE ,C.CVC_NUMBER ,C.ENROLL_DATE ,C.DEL_YN ,CC.NO ,CC.CARD_COMPANY_NAME FROM CARD C JOIN CARD_COMPANY CC ON C.NO = CC.NO WHERE C.NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemberNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		TestVo cardInfo = null;
		if(rs.next()) {
			cardInfo = new TestVo();
			System.out.println("cardInfo : 카드 조회");
			System.out.println("dao에러확인 cardInfo : " + cardInfo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return cardInfo;
	}
}
