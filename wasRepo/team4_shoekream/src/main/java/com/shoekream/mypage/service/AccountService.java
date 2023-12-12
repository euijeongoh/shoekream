package com.shoekream.mypage.controller;

import java.sql.Connection;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.dao.AddressDao;
import com.shoekream.mypage.vo.AccountVo;
import com.shoekream.mypage.vo.AddrBookVo;

public class AccountService {

	public AccountVo selectAccount(String no) throws Exception{

		Connection conn = JDBCTemplate.getConnection();

		AccountDao ad = new AccountDao();
		AccountVo vo = ad.selectAccount(conn, no);

		JDBCTemplate.close(conn);

		return vo;
	
	}

	public int updateAccount(AccountVo vo) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();

		AccountDao ad = new AccountDao();
		int result = ad.updateAccount(conn, vo);

		JDBCTemplate.close(conn);

		return result;
	}

}
