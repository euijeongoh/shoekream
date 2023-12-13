package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AddrBookVo;
import com.shoekream.mypage.vo.PayInfoVo;

public class PayInfoDao {

	public PayInfoVo selectPayInfoList(Connection conn, String no) throws Exception{
		
		String spl = "SELECT C.NO ,C.MEMBER_NO ,M.NAME AS MEMBER_NAME ,C.CARD_COMPANY_NO ,CP.CARD_COMPANY_NAME AS CARD_COMPANY_NAME ,C.CARD_NUMBER ,C.EXPIRATION_DATE ,C.CVC_NUMBER ,C.DEFAULT_PAYINFO_YN ,C.ENROLL_DATE ,C.DEL_YN FROM CARD C JOIN MEMBER M ON M.NO = C.MEMBER_NO JOIN CARD_COMPANY CP ON CP.NO = C.CARD_COMPANY_NO WHERE C.MEMBER_NO = ? AND C.DEL_YN = 'N' AND DEFAULT_PAYINFO_YN = 'Y'";
		PreparedStatement pstmt = conn.prepareStatement(spl);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		PayInfoVo vo = null;
		while (rs.next()) {
			String No = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String memberName = rs.getString("MEMBER_NAME");
			String cardCompanyNo = rs.getString("CARD_COMPANY_NO");
			String cardCompanyName = rs.getString("CARD_COMPANY_NAME");
			String cardNumber = rs.getString("CARD_NUMBER");
			String expirationDate = rs.getString("EXPIRATION_DATE");
			String cvcNumber = rs.getString("CVC_NUMBER");
			String defaultPayInfoYn = rs.getString("DEFAULT_PAYINFO_YN");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");

			vo = new PayInfoVo();
			vo.setNo(No);
			vo.setMemberNo(memberNo);
			vo.setMemberName(memberName);
			vo.setCardCompanyNo(cardCompanyNo);
			vo.setCardCompanyName(cardCompanyName);
			vo.setCardNumber(cardNumber);
			vo.setNoexpirationDate(expirationDate);
			vo.setCvcNumber(cvcNumber);
			vo.setCvcNumber(defaultPayInfoYn);
			vo.setDelYn(delYn);
			vo.setEnrollDate(enrollDate);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}

	public List<PayInfoVo> selectExtraPayInfoList(Connection conn, String no) throws Exception{
		
		String spl = "SELECT C.NO ,C.MEMBER_NO ,M.NAME AS MEMBER_NAME ,C.CARD_COMPANY_NO ,CP.CARD_COMPANY_NAME AS CARD_COMPANY_NAME ,C.CARD_NUMBER ,C.EXPIRATION_DATE ,C.CVC_NUMBER ,C.DEFAULT_PAYINFO_YN ,C.ENROLL_DATE ,C.DEL_YN FROM CARD C JOIN MEMBER M ON M.NO = C.MEMBER_NO JOIN CARD_COMPANY CP ON CP.NO = C.CARD_COMPANY_NO WHERE C.MEMBER_NO = ? AND C.DEL_YN = 'N' AND DEFAULT_PAYINFO_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(spl);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		List<PayInfoVo> extraVoList = new ArrayList<PayInfoVo>();
		while (rs.next()) {
			String No = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String memberName = rs.getString("MEMBER_NAME");
			String cardCompanyNo = rs.getString("CARD_COMPANY_NO");
			String cardCompanyName = rs.getString("CARD_COMPANY_NAME");
			String cardNumber = rs.getString("CARD_NUMBER");
			String expirationDate = rs.getString("EXPIRATION_DATE");
			String cvcNumber = rs.getString("CVC_NUMBER");
			String defaultPayInfoYn = rs.getString("DEFAULT_PAYINFO_YN");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");

			PayInfoVo extraVo = new PayInfoVo();
			extraVo.setNo(No);
			extraVo.setMemberNo(memberNo);
			extraVo.setMemberName(memberName);
			extraVo.setCardCompanyNo(cardCompanyNo);
			extraVo.setCardCompanyName(cardCompanyName);
			extraVo.setCardNumber(cardNumber);
			extraVo.setNoexpirationDate(expirationDate);
			extraVo.setCvcNumber(cvcNumber);
			extraVo.setDefaultPayInfoYn(defaultPayInfoYn);
			extraVo.setDelYn(delYn);
			extraVo.setEnrollDate(enrollDate);
			
			extraVoList.add(extraVo);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return extraVoList;
	}

}
