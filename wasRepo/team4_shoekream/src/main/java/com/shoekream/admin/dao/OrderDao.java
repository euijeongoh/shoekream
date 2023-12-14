package com.shoekream.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.admin.vo.OrdersVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;

public class OrderDao {

	public int selectStorageListCount(Connection conn) throws Exception {
		// sql
		String sql = "SELECT COUNT(*) AS CNT FROM ORDERS WHERE ORDERS_STATUS_NO = '1'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		// rs
		int cnt = 0;
		if (rs.next()) {
			cnt = rs.getInt(1);
		}

		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return cnt;
	}

	public List<OrdersVo> selectStorageList(Connection conn, PageVo pvo) throws Exception {
		String sql = "SELECT * FROM (SELECT * FROM ( SELECT  ROWNUM RNUM, T.* FROM ( SELECT O.NO ,O.MEMBER_NO ,O.ORDERS_STATUS_NO ,O.BIDDING_NO ,O.PRODUCT_NO ,O.INSPECTION_NO ,O.ORDERS_DATE ,O.PAYMENT_TYPE ,O.PAYMENT_DATE ,O.STORAGE_DATE ,O.CHECK_DATE ,O.RETURN_DATE ,O.SEND_DATE ,O.TOTAL_PRICE ,M.NAME AS MEMBER_NAME ,M.EMAIL AS EMAIL ,P.NAME AS PRODUCT_NAME ,P.NAME_KO AS PRODUCT_NAME_KO ,B.PRICE AS PRICE ,I.CHECK_RESULT AS CHECK_RESULT ,OS.ORDERS_STATUS AS ORDERS_STATUS FROM ORDERS O JOIN MEMBER M ON O.MEMBER_NO = M.NO JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO JOIN BIDDING B ON O.BIDDING_NO = B.NO JOIN INSPECTION I ON O.INSPECTION_NO = I.NO JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO WHERE O.ORDERS_STATUS_NO = '4' AND I.NO = 1 AND O.INSPECTION_NO = 1 ORDER BY O.NO DESC ) T ) WHERE (BIDDING_NO, TOTAL_PRICE) IN ( SELECT BIDDING_NO, MAX(TOTAL_PRICE) FROM ORDERS GROUP BY BIDDING_NO)) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<OrdersVo> OrdersVoList = new ArrayList<OrdersVo>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String ordersStatusNo = rs.getString("ORDERS_STATUS_NO");
			String biddingNo = rs.getString("BIDDING_NO");
			String productNo = rs.getString("PRODUCT_NO");
			String inspectionNo = rs.getString("INSPECTION_NO");
			String ordersDate = rs.getString("ORDERS_DATE");
			String paymentType = rs.getString("PAYMENT_TYPE");
			String paymentdate = rs.getString("PAYMENT_DATE");
			String storageDate = rs.getString("STORAGE_DATE");
			String checkDate = rs.getString("CHECK_DATE");
			String returnDate = rs.getString("RETURN_DATE");
			String sendDate = rs.getString("SEND_DATE");
			String totalPrice = rs.getString("TOTAL_PRICE");
			String memberName = rs.getString("MEMBER_NAME");
			String email = rs.getString("EMAIL");
			String productName = rs.getString("PRODUCT_NAME");
			String productNameKo = rs.getString("PRODUCT_NAME_KO");
			String price = rs.getString("PRICE");
			String checkResult = rs.getString("CHECK_RESULT");
			String ordersStatus = rs.getString("ORDERS_STATUS");

			OrdersVo vo = new OrdersVo();
			vo.setNo(no);
			vo.setMemberNo(memberNo);
			vo.setOrdersStatusNo(ordersStatusNo);
			vo.setBiddingNo(biddingNo);
			vo.setProductNo(productNo);
			vo.setInspectionNo(inspectionNo);
			vo.setOrdersDate(ordersDate);
			vo.setPaymentType(paymentType);
			vo.setPaymentdate(paymentdate);
			vo.setStorageDate(storageDate);
			vo.setCheckDate(checkDate);
			vo.setReturnDate(returnDate);
			vo.setSendDate(sendDate);
			vo.setTotalPrice(totalPrice);
			vo.setMemberName(memberName);
			vo.setEmail(email);
			vo.setProductName(productName);
			vo.setProductNameKo(productNameKo);
			vo.setPrice(price);
			vo.setCheckResult(checkResult);
			vo.setOrdersStatus(ordersStatus);

			OrdersVoList.add(vo);
		}

		// close

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return OrdersVoList;
	}

	public List<OrdersVo> selectCheckList(Connection conn, PageVo pvo) throws Exception{
		String sql = "SELECT * FROM (SELECT * FROM ( SELECT  ROWNUM RNUM, T.* FROM ( SELECT O.NO ,O.MEMBER_NO ,O.ORDERS_STATUS_NO ,O.BIDDING_NO ,O.PRODUCT_NO ,O.INSPECTION_NO ,O.ORDERS_DATE ,O.PAYMENT_TYPE ,O.PAYMENT_DATE ,O.STORAGE_DATE ,O.CHECK_DATE ,O.RETURN_DATE ,O.SEND_DATE ,O.TOTAL_PRICE ,M.NAME AS MEMBER_NAME ,M.EMAIL AS EMAIL ,P.NAME AS PRODUCT_NAME ,P.NAME_KO AS PRODUCT_NAME_KO ,B.PRICE AS PRICE ,I.CHECK_RESULT AS CHECK_RESULT ,OS.ORDERS_STATUS AS ORDERS_STATUS FROM ORDERS O JOIN MEMBER M ON O.MEMBER_NO = M.NO JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO JOIN BIDDING B ON O.BIDDING_NO = B.NO JOIN INSPECTION I ON O.INSPECTION_NO = I.NO JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO WHERE O.ORDERS_STATUS_NO = '1' AND I.NO = 1 ORDER BY O.NO DESC ) T ) WHERE (BIDDING_NO, TOTAL_PRICE) IN ( SELECT BIDDING_NO, MAX(TOTAL_PRICE) FROM ORDERS GROUP BY BIDDING_NO)) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<OrdersVo> OrdersVoList = new ArrayList<OrdersVo>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String ordersStatusNo = rs.getString("ORDERS_STATUS_NO");
			String biddingNo = rs.getString("BIDDING_NO");
			String productNo = rs.getString("PRODUCT_NO");
			String inspectionNo = rs.getString("INSPECTION_NO");
			String ordersDate = rs.getString("ORDERS_DATE");
			String paymentType = rs.getString("PAYMENT_TYPE");
			String paymentdate = rs.getString("PAYMENT_DATE");
			String storageDate = rs.getString("STORAGE_DATE");
			String checkDate = rs.getString("CHECK_DATE");
			String returnDate = rs.getString("RETURN_DATE");
			String sendDate = rs.getString("SEND_DATE");
			String totalPrice = rs.getString("TOTAL_PRICE");
			String memberName = rs.getString("MEMBER_NAME");
			String email = rs.getString("EMAIL");
			String productName = rs.getString("PRODUCT_NAME");
			String productNameKo = rs.getString("PRODUCT_NAME_KO");
			String price = rs.getString("PRICE");
			String checkResult = rs.getString("CHECK_RESULT");
			String ordersStatus = rs.getString("ORDERS_STATUS");

			OrdersVo vo = new OrdersVo();
			vo.setNo(no);
			vo.setMemberNo(memberNo);
			vo.setOrdersStatusNo(ordersStatusNo);
			vo.setBiddingNo(biddingNo);
			vo.setProductNo(productNo);
			vo.setInspectionNo(inspectionNo);
			vo.setOrdersDate(ordersDate);
			vo.setPaymentType(paymentType);
			vo.setPaymentdate(paymentdate);
			vo.setStorageDate(storageDate);
			vo.setCheckDate(checkDate);
			vo.setReturnDate(returnDate);
			vo.setSendDate(sendDate);
			vo.setTotalPrice(totalPrice);
			vo.setMemberName(memberName);
			vo.setEmail(email);
			vo.setProductName(productName);
			vo.setProductNameKo(productNameKo);
			vo.setPrice(price);
			vo.setCheckResult(checkResult);
			vo.setOrdersStatus(ordersStatus);

			OrdersVoList.add(vo);
		}

		// close

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return OrdersVoList;

	}

	public List<OrdersVo> selectSendList(Connection conn, PageVo pvo) throws Exception{
		
		String sql = "SELECT * FROM (SELECT * FROM ( SELECT  ROWNUM RNUM, T.* FROM ( SELECT O.NO ,O.MEMBER_NO ,O.ORDERS_STATUS_NO ,O.BIDDING_NO ,O.PRODUCT_NO ,O.INSPECTION_NO ,O.ORDERS_DATE ,O.PAYMENT_TYPE ,O.PAYMENT_DATE ,O.STORAGE_DATE ,O.CHECK_DATE ,O.RETURN_DATE ,O.SEND_DATE ,O.TOTAL_PRICE ,M.NAME AS MEMBER_NAME ,M.EMAIL AS EMAIL ,P.NAME AS PRODUCT_NAME ,P.NAME_KO AS PRODUCT_NAME_KO ,B.PRICE AS PRICE ,I.CHECK_RESULT AS CHECK_RESULT ,OS.ORDERS_STATUS AS ORDERS_STATUS FROM ORDERS O JOIN MEMBER M ON O.MEMBER_NO = M.NO JOIN PRODUCTS P ON O.PRODUCT_NO = P.NO JOIN BIDDING B ON O.BIDDING_NO = B.NO JOIN INSPECTION I ON O.INSPECTION_NO = I.NO JOIN ORDERS_STATUS OS ON O.ORDERS_STATUS_NO = OS.NO WHERE O.ORDERS_STATUS_NO = '2' AND (I.NO = '2' OR I.NO = '3') ORDER BY O.NO DESC ) T ) WHERE (BIDDING_NO, TOTAL_PRICE) IN ( SELECT BIDDING_NO, MAX(TOTAL_PRICE) FROM ORDERS GROUP BY BIDDING_NO)) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();

		// rs
		List<OrdersVo> OrdersVoList = new ArrayList<OrdersVo>();
		while (rs.next()) {
			String no = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String ordersStatusNo = rs.getString("ORDERS_STATUS_NO");
			String biddingNo = rs.getString("BIDDING_NO");
			String productNo = rs.getString("PRODUCT_NO");
			String inspectionNo = rs.getString("INSPECTION_NO");
			String ordersDate = rs.getString("ORDERS_DATE");
			String paymentType = rs.getString("PAYMENT_TYPE");
			String paymentdate = rs.getString("PAYMENT_DATE");
			String storageDate = rs.getString("STORAGE_DATE");
			String checkDate = rs.getString("CHECK_DATE");
			String returnDate = rs.getString("RETURN_DATE");
			String sendDate = rs.getString("SEND_DATE");
			String totalPrice = rs.getString("TOTAL_PRICE");
			String memberName = rs.getString("MEMBER_NAME");
			String email = rs.getString("EMAIL");
			String productName = rs.getString("PRODUCT_NAME");
			String productNameKo = rs.getString("PRODUCT_NAME_KO");
			String price = rs.getString("PRICE");
			String checkResult = rs.getString("CHECK_RESULT");
			String ordersStatus = rs.getString("ORDERS_STATUS");

			OrdersVo vo = new OrdersVo();
			vo.setNo(no);
			vo.setMemberNo(memberNo);
			vo.setOrdersStatusNo(ordersStatusNo);
			vo.setBiddingNo(biddingNo);
			vo.setProductNo(productNo);
			vo.setInspectionNo(inspectionNo);
			vo.setOrdersDate(ordersDate);
			vo.setPaymentType(paymentType);
			vo.setPaymentdate(paymentdate);
			vo.setStorageDate(storageDate);
			vo.setCheckDate(checkDate);
			vo.setReturnDate(returnDate);
			vo.setSendDate(sendDate);
			vo.setTotalPrice(totalPrice);
			vo.setMemberName(memberName);
			vo.setEmail(email);
			vo.setProductName(productName);
			vo.setProductNameKo(productNameKo);
			vo.setPrice(price);
			vo.setCheckResult(checkResult);
			vo.setOrdersStatus(ordersStatus);

			OrdersVoList.add(vo);
		}

		// close

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return OrdersVoList;
	}

}
