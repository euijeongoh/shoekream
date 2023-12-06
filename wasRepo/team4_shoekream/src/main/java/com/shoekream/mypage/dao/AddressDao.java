package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AddrBookVo;

public class AddressDao {

	public List<AddrBookVo> selectAddrList(Connection conn, String no) throws Exception{
		
		String spl = "SELECT A.NO ,M.NAME AS MEMBER_NO ,A.MEMBER_NO ,A.ADDRES_NAME ,A.ADDRES ,A.DETAIL_ADDRES ,A.PHONE_NUMBER ,A.POST_CODE ,A.DEFAULT_ADDRESS_YN ,A.DEL_YN ,A.ENROLL_DATE FROM ADDERSS_BOOK A JOIN MEMBER M ON (A.MEMBER_NO = M.NO) WHERE A.MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(spl);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		List<AddrBookVo> addrBookList = new ArrayList<AddrBookVo>();
		while (rs.next()) {
			String No = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String memberName = rs.getString("MEMBER_Name");
			String addressName = rs.getString("ADDRES_NAME");
			String addres = rs.getString("ADDRES");
			String detailAddres = rs.getString("DETAIL_ADDRES");
			String phoneNumber = rs.getString("PHONE_NUMBER");
			String postCode = rs.getString("POST_CODE");
			String defaultAddressYn = rs.getString("DEFAULT_ADDRESS_YN");
			String delYn = rs.getString("DEL_YN");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			AddrBookVo vo = new AddrBookVo();
			vo.setNo(No);
			vo.setMemberNo(memberNo);
			vo.setMemberName(memberName);
			vo.setAddersName(addressName);
			vo.setAddres(addres);
			vo.setDetailAddres(detailAddres);
			vo.setPhoneNumber(phoneNumber);
			vo.setPostCode(postCode);
			vo.setDefaultAddrYn(defaultAddressYn);
			vo.setDelYn(delYn);
			vo.setEnrollDate(enrollDate);
			
			addrBookList.add(vo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return addrBookList;
	}

}
