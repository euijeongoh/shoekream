package com.shoekream.bidding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AccountVo;
import com.shoekream.mypage.vo.AddrBookVo;
import com.shoekream.mypage.vo.PaymentVo;
import com.shoekream.orders.vo.OrdersVo;
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
			infoVo.setBrandName(rs.getString(5));;
			infoVo.setModelName(rs.getString(6));;
//				System.out.println("infoVo : 제품 정보");
//				System.out.println("dao에러확인 infoVo : " + infoVo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return infoVo;
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
//				System.out.println("productInfo : 상품 정보 조회");
//				System.out.println("dao에러확인 dbVo : " + dbVo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return dbVo;
	}
	
	
	
	
	// 구매 상품 정보(즉시 구매가 : 판매입찰)
	public BiddingVo buyProductList(Connection conn, BiddingVo vo) throws Exception{
			System.out.println("에러확인 : vo.getProductsNo() : " + vo.getProductsNo());
			System.out.println("에러확인 : vo.getPrice() : " + vo.getPrice());
			System.out.println("에러확인 : vo.getShoesSizes() : " + vo.getShoesSizes());
		
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
			System.out.println("에러확인 : vo.getProductsNo() : " + vo.getProductsNo());
			System.out.println("에러확인 : vo.getProductsNo() : " + vo.getShoesSizes());
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
//				System.out.println("addInfo : 주소록 조회");
//				System.out.println("dao에러확인 addInfo : " + addInfo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return addInfo;
	}
	// 계좌 조회
	public AccountVo accInfo(Connection conn, String loginMemberNo) throws Exception {

		// sql
		String sql = "SELECT A.NO ,A.MEMBER_NO ,A.BANK_AGENT_NO ,A.ACCOUNT_NUMBER ,A.DEPOSITOR ,A.ENROLL_DATE,BA.BANK_COMPANY_NAME FROM ACCOUNT A JOIN BANK_AGENT BA ON A.NO = BA.NO WHERE A.NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemberNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		AccountVo accInfo = null;
		if(rs.next()) {
			accInfo = new AccountVo();
			accInfo.setNo(rs.getString(1));
			accInfo.setMemberNo(rs.getString(2));
			accInfo.setBankAgentNo(rs.getString(3));
			accInfo.setAccountNumber(rs.getString(4));
			accInfo.setDepositor(rs.getString(5));
			accInfo.setEnrollDate(rs.getString(6));
			accInfo.setBankAgentName(rs.getString(7));
//				System.out.println("accInfo : 계좌 정보 조회");
//				System.out.println("dao에러확인 accInfo : " + accInfo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return accInfo;
	}
	// 카드 조회
	public PaymentVo cardInfo(Connection conn, String loginMemberNo) throws Exception {

		// sql
		String sql = "SELECT C.NO ,C.MEMBER_NO ,C.CARD_COMPANY_NO ,C.CARD_NUMBER ,C.EXPIRATION_DATE ,C.CVC_NUMBER ,C.ENROLL_DATE,CC.CARD_COMPANY_NAME FROM CARD C JOIN CARD_COMPANY CC ON C.NO = CC.NO WHERE C.NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginMemberNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		PaymentVo cardInfo = null;
		if(rs.next()) {
			cardInfo = new PaymentVo();
			cardInfo.setNo(rs.getNString(1));
			cardInfo.setMemberNo(rs.getNString(2));
			cardInfo.setCardCompanyNo(rs.getNString(3));
			cardInfo.setCardNumber(rs.getNString(4));
			cardInfo.setExpirationDate(rs.getNString(5));
			cardInfo.setCvcNumber(rs.getNString(6));
			cardInfo.setEnrollDate(rs.getNString(7));
			cardInfo.setCardCompanyName(rs.getNString(8));
//				System.out.println("cardInfo : 카드 조회");
//				System.out.println("dao에러확인 cardInfo : " + cardInfo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return cardInfo;
	}




	// 주문 정보 조회
	public OrdersVo ordersInfo(Connection conn, String memberNo, String biddingNo, String productsNo) throws Exception{

		// sql
		String sql = "SELECT O.NO ,O.MEMBER_NO ,O.ORDERS_STATUS_NO ,OS.ORDERS_STATUS ,O.BIDDING_NO ,O.PRODUCT_NO ,O.INSPECTION_NO ,I.CHECK_RESULT ,O.ORDERS_DATE ,O.PAYMENT_TYPE ,O.PAYMENT_DATE ,O.STORAGE_DATE ,O.CHECK_DATE ,O.RETURN_DATE ,O.SEND_DATE ,O.TOTAL_PRICE ,O.COMMISSION ,P.NAME ,B.PRICE FROM ORDERS O JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO JOIN INSPECTION I ON O.INSPECTION_NO = I.NO JOIN MEMBER M ON O.MEMBER_NO = M.NO JOIN BIDDING B ON O.BIDDING_NO = B.NO JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO WHERE O.MEMBER_NO = ? AND O.BIDDING_NO = ? AND O.PRODUCT_NO = ? ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, biddingNo);
		pstmt.setString(3, productsNo);
//			System.out.println("에러확인 ordersInfo Dao");
		ResultSet rs = pstmt.executeQuery();
//			System.out.println("에러확인 ordersInfo Dao executeQuery()");

		// rs
		OrdersVo ordersVo = null;
		if(rs.next()) {
//				System.out.println("에러확인 ordersInfo Dao if(rs.next())");
//				System.out.println("조회하는 biddingNo 가 일치하지 않음.. INSERT 먼저 할 것.");
			ordersVo = new OrdersVo();
			ordersVo.setNo(rs.getString(1));
			ordersVo.setMemberNo(rs.getString(2));
			ordersVo.setOrdersStatusNo(rs.getString(3));
			ordersVo.setOrdersStatus(rs.getString(4));
			ordersVo.setBiddingNo(rs.getString(5));
			ordersVo.setProductNo(rs.getString(6));
			ordersVo.setInspectionNo(rs.getString(7));
			ordersVo.setInspection(rs.getString(8));
			ordersVo.setOrdersDate(rs.getString(9));
			ordersVo.setPaymentType(rs.getString(10));
			ordersVo.setPaymentDate(rs.getString(11));
			ordersVo.setStorageDate(rs.getString(12));
			ordersVo.setCheckDate(rs.getString(13));
			ordersVo.setReturnDAte(rs.getString(14));
			ordersVo.setSendDate(rs.getString(15));
			ordersVo.setTotalPrice(rs.getString(16));
			ordersVo.setCommission(rs.getString(17));
			ordersVo.setPrice(rs.getString(19));
//				System.out.println("ordersVo : 주문 조회");
//				System.out.println("dao에러확인 ordersVo : " + ordersVo);
		}
//			System.out.println("에러확인 ordersInfo Dao before close()");
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return ordersVo;
	}




	// 주문 정보 입력
	public int orders(Connection conn, String loginMemberNo, String biddngNo, String productsNo, String commissionStr, String totalAmountStr) throws Exception{
		
		// sql
		String sql = "INSERT INTO ORDERS VALUES(SEQ_ORDERS_NO.NEXTVAL, ?, 4, ?, ?, 1, SYSDATE, '카드', SYSDATE, NULL, NULL, NULL, NULL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//			System.out.println("orders : 주문 정보 입력");
//			System.out.println("dao에러확인 loginMemberNo : " + loginMemberNo);
//			System.out.println("dao에러확인 biddngNo : " + biddngNo);
//			System.out.println("dao에러확인 productsNo : " + productsNo);
//			System.out.println("dao에러확인 totalAmount : " + totalAmountStr);
//			System.out.println("dao에러확인 commission : " + commissionStr);
		pstmt.setString(1, loginMemberNo);
		pstmt.setString(2, biddngNo);
		pstmt.setString(3, productsNo);
		pstmt.setString(4, totalAmountStr);
		pstmt.setString(5, commissionStr);
		int result = pstmt.executeUpdate();

		// rs
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}




	// 입찰 등록
	public int buyBidding(Connection conn, String memberNo, String productsNo, String productsSizesNo, String biddingPrice, String deadline) throws Exception{
		// sql
		String sql = "INSERT INTO BIDDING VALUES(SEQ_BIDDING_NO.NEXTVAL, ?, ?, ?, 1, 1, ?, SYSDATE, TO_DATE(?,'YYYY/MM/DD'))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
			System.out.println("orders : 주문 정보 입력");
			System.out.println("dao에러확인 memberNo : " + memberNo);
			System.out.println("dao에러확인 productsNo : " + productsNo);
			System.out.println("dao에러확인 productsSizesNo : " + productsSizesNo);
			System.out.println("dao에러확인 biddingPrice : " + biddingPrice);
			System.out.println("dao에러확인 deadline : " + deadline);
		pstmt.setString(1, memberNo);
		pstmt.setString(2, productsNo);
		pstmt.setString(3, productsSizesNo);
		pstmt.setString(4, biddingPrice);
		pstmt.setString(5, deadline);
		int result = pstmt.executeUpdate();

		// rs
		
		// close
		JDBCTemplate.close(pstmt);
		
		return result;
	}


//	------------------------------------------------------------------------------------------------------------------------









//	------------------------------------------------------------------------------------------------------------------------
	
	
	
	// 1-1. 판매하기
	public List<BiddingVo> sellSelect(Connection conn, String productsNo) throws Exception{

		// sql
		String sql = "SELECT SHOES_SIZES, MAX(PRICE) AS PRICE FROM ( SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE PRODUCTS_NO = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '구매입찰' AND B.EXPIRE_DATE >= SYSDATE ) GROUP BY SHOES_SIZES";
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

	
	

	// 1-2. 판매 상품 정보(즉시 판매가 : 구매입찰)
	public ProductInfoVo sellProductInfo(Connection conn, String productsNo) throws Exception{

		// sql
		String sql = "SELECT NO ,BRAND_NO ,CATEGORY_NO ,NAME ,NAME_KO ,MODEL_NUMBER ,RELEASE_PRICE ,RELEASE_DATE ,ENROLL_DATE ,MODIFY_DATE ,DEL_YN FROM PRODUCTS WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  productsNo);
		ResultSet rs = pstmt.executeQuery();

		// rs
		ProductInfoVo infoVo = null;
		if(rs.next()) {
			infoVo = new ProductInfoVo();
			infoVo.setProductName(rs.getString(4));;
			infoVo.setBrandName(rs.getString(5));;
			infoVo.setModelName(rs.getString(6));;
//				System.out.println("infoVo : 제품 정보");
//				System.out.println("dao에러확인 infoVo : " + infoVo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return infoVo;
	}

	
	
	
	// 2. 입찰 상품 정보 조회
	public BiddingVo sellProductInfo(Connection conn, BiddingVo vo) throws Exception{

		// sql
		String sql = "SELECT B.NO ,B.MEMBER_NO ,B.PRODUCTS_NO ,B.PRODUCTS_SIZES_NO ,SS.SHOES_SIZES ,B.BIDDING_STATUS_NO ,BS.BIDDING_STATUS ,B.BIDDING_POSITION_NO ,BP.BIDDING_POSITION ,B.PRICE ,B.ENROLL_DATE ,B.EXPIRE_DATE FROM BIDDING B JOIN PRODUCT_SIZES PS ON B.PRODUCTS_SIZES_NO = PS.NO JOIN SHOES_SIZES SS ON PS.SHOES_SIZES_NO = SS.NO JOIN BIDDING_POSITION BP ON B.BIDDING_POSITION_NO = BP.NO JOIN BIDDING_STATUS BS ON B.BIDDING_STATUS_NO = BS.NO WHERE B.PRODUCTS_NO = ? AND B.PRICE = ? AND SS.SHOES_SIZES = ? AND BIDDING_STATUS = '진행중' AND BIDDING_POSITION = '구매입찰' AND B.EXPIRE_DATE >= SYSDATE ORDER BY NO";
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
//				System.out.println("productInfo : 상품 정보 조회");
//				System.out.println("dao에러확인 dbVo : " + dbVo);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return dbVo;
	}
	
}
