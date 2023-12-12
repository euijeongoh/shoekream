package com.shoekream.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.vo.AccountVo;
import com.shoekream.mypage.vo.AddrBookVo;

public class AccountDao {

	public AccountVo selectAccount(Connection conn, String no) throws Exception{
		
		String spl = "SELECT A.NO ,A.MEMBER_NO ,A.BANK_AGENT_NO ,B.BANK_COMPANY_NAME AS BANK_AGENT_NAME ,A.ACCOUNT_NUMBER ,A.DEPOSITOR ,A.ENROLL_DATE FROM ACCOUNT A JOIN BANK_AGENT B ON A.BANK_AGENT_NO = B.NO WHERE A.NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(spl);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		AccountVo vo = null;
		if(rs.next()) {
			String No = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String bankAgentNo = rs.getString("BANK_AGENT_NO");
			String bankAgentName = rs.getString("BANK_AGENT_NAME");
			String accountNumber = rs.getString("ACCOUNT_NUMBER");
			String depositor = rs.getString("DEPOSITOR");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			vo = new AccountVo();
			vo.setNo(No);
			vo.setMemberNo(memberNo);
			vo.setBankAgentNo(bankAgentNo);
			vo.setBankAgentName(bankAgentName);
			vo.setAccountNumber(accountNumber);
			vo.setDepositor(depositor);
			vo.setEnrollDate(enrollDate);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);

		return vo;
	}

	public int updateAccount(Connection conn, AccountVo vo) throws Exception{
		
		String sql = "UPDATE ACCOUNT SET BANK_AGENT_NO = ? , ACCOUNT_NUMBER = ? , DEPOSITOR = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBankAgentNo());
		pstmt.setString(2, vo.getAccountNumber());
		pstmt.setString(3, vo.getDepositor());
		pstmt.setString(4, vo.getNo());
		int result = pstmt.executeUpdate();

		JDBCTemplate.close(pstmt);

		return result;
	}

}
