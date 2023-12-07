package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AddrBookVo;

public class AddressDao {

	public AddrBookVo selectAddrList(Connection conn, String no) throws Exception{
		
		String spl = "SELECT * FROM ADDERSS_BOOK WHERE MEMBER_NO = ? AND DEFAULT_ADDRESS_YN = 'Y' AND DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(spl);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		AddrBookVo vo = null;
		while (rs.next()) {
			String No = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String addressName = rs.getString("ADDRES_NAME");
			String addres = rs.getString("ADDRES");
			String detailAddres = rs.getString("DETAIL_ADDRES");
			String phoneNumber = rs.getString("PHONE_NUMBER");
			String postCode = rs.getString("POST_CODE");
			String defaultAddressYn = rs.getString("DEFAULT_ADDRESS_YN");
			String delYn = rs.getString("DEL_YN");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			vo = new AddrBookVo();
			vo.setNo(No);
			vo.setMemberNo(memberNo);
			vo.setAddersName(addressName);
			vo.setAddres(addres);
			vo.setDetailAddres(detailAddres);
			vo.setPhoneNumber(phoneNumber);
			vo.setPostCode(postCode);
			vo.setDefaultAddrYn(defaultAddressYn);
			vo.setDelYn(delYn);
			vo.setEnrollDate(enrollDate);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	public List<AddrBookVo> selectExtraAddrList(Connection conn, String no) throws Exception{
		
		String spl = "SELECT * FROM ADDERSS_BOOK WHERE MEMBER_NO = ? AND DEFAULT_ADDRESS_YN = 'N' AND DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(spl);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		List<AddrBookVo> extraVoList = new ArrayList<AddrBookVo>();
		while (rs.next()) {
			String No = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String addressName = rs.getString("ADDRES_NAME");
			String addres = rs.getString("ADDRES");
			String detailAddres = rs.getString("DETAIL_ADDRES");
			String phoneNumber = rs.getString("PHONE_NUMBER");
			String postCode = rs.getString("POST_CODE");
			String defaultAddressYn = rs.getString("DEFAULT_ADDRESS_YN");
			String delYn = rs.getString("DEL_YN");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			AddrBookVo extraVo = new AddrBookVo();
			extraVo.setNo(No);
			extraVo.setMemberNo(memberNo);
			extraVo.setAddersName(addressName);
			extraVo.setAddres(addres);
			extraVo.setDetailAddres(detailAddres);
			extraVo.setPhoneNumber(phoneNumber);
			extraVo.setPostCode(postCode);
			extraVo.setDefaultAddrYn(defaultAddressYn);
			extraVo.setDelYn(delYn);
			extraVo.setEnrollDate(enrollDate);
			
			extraVoList.add(extraVo);
			
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return extraVoList;
	}

}
