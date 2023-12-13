package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AddrBookVo;

public class AddressDao {

	public AddrBookVo selectAddrList(Connection conn, String no) throws Exception {

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

	public List<AddrBookVo> selectExtraAddrList(Connection conn, String no) throws Exception {

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

	public int insertAddr(Connection conn, AddrBookVo vo) throws Exception {

		System.out.println(vo.getAddersName());

		String sql = "INSERT INTO ADDERSS_BOOK (NO ,MEMBER_NO ,ADDRES_NAME ,ADDRES ,DETAIL_ADDRES ,PHONE_NUMBER ,POST_CODE ,DEFAULT_ADDRESS_YN) VALUES (SEQ_ADDERSS_BOOK_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNo());
		pstmt.setString(2, vo.getAddersName());
		pstmt.setString(3, vo.getAddres());
		pstmt.setString(4, vo.getDetailAddres());
		pstmt.setString(5, vo.getPhoneNumber());
		pstmt.setString(6, vo.getPostCode());
		pstmt.setString(7, vo.getDefaultAddrYn());
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}

	public int addrDelete(Connection conn, String no) throws Exception {

		String sql = "UPDATE ADDERSS_BOOK SET DEL_YN = 'Y' WHERE NO = ? AND DEFAULT_ADDRESS_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}

	public AddrBookVo selectAddrNoList(Connection conn, String no) throws Exception {

		String sql = "SELECT NO ,ADDRES_NAME ,ADDRES ,DETAIL_ADDRES ,PHONE_NUMBER ,POST_CODE ,DEFAULT_ADDRESS_YN FROM ADDERSS_BOOK WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();

		AddrBookVo vo = null;
		if (rs.next()) {
			String No = rs.getString("NO");
			String addresName = rs.getString("ADDRES_NAME");
			String addres = rs.getString("ADDRES");
			String detailAddres = rs.getString("DETAIL_ADDRES");
			String phoneNumber = rs.getString("PHONE_NUMBER");
			String postCode = rs.getString("POST_CODE");
			String defaultAddressYn = rs.getString("DEFAULT_ADDRESS_YN");

			vo = new AddrBookVo();
			vo.setNo(No);
			vo.setAddersName(addresName);
			vo.setAddres(addres);
			vo.setDetailAddres(detailAddres);
			vo.setPhoneNumber(phoneNumber);
			vo.setPostCode(postCode);
			vo.setDefaultAddrYn(defaultAddressYn);

		}

		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}

	public int updateAddr(Connection conn, AddrBookVo vo) throws Exception{
		
		String sql = "UPDATE ADDERSS_BOOK SET ADDRES_NAME = ? ,ADDRES = ? ,DETAIL_ADDRES = ? ,PHONE_NUMBER = ? ,POST_CODE = ? ,DEFAULT_ADDRESS_YN = ? WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAddersName());
		pstmt.setString(2, vo.getAddres());
		pstmt.setString(3, vo.getDetailAddres());
		pstmt.setString(4, vo.getPhoneNumber());
		pstmt.setString(5, vo.getPostCode());
		pstmt.setString(6, vo.getDefaultAddrYn());
		pstmt.setString(7, vo.getNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);

		return result;
	}

	public int changeDefaultYn(Connection conn, String no) throws Exception{
		
		String sql = "UPDATE ADDERSS_BOOK SET DEFAULT_ADDRESS_YN = CASE WHEN DEFAULT_ADDRESS_YN = 'N' THEN 'Y' WHEN DEFAULT_ADDRESS_YN = 'Y' THEN 'N' ELSE DEFAULT_ADDRESS_YN END WHERE DEL_YN = 'N' AND MEMBER_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		

		return result;
	}


}
