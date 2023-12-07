package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.dao.AddressDao;
import com.shoekream.mypage.vo.AddrBookVo;

public class AddressService {

	public AddrBookVo selectAddrList(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		AddressDao ad = new AddressDao();
		AddrBookVo vo = ad.selectAddrList(conn, no);

		JDBCTemplate.close(conn);

		return vo;

	}

	public List<AddrBookVo> selectExtraAddrList(String no) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();

		AddressDao ad = new AddressDao();
		List<AddrBookVo> extraVo = ad.selectExtraAddrList(conn, no);

		JDBCTemplate.close(conn);

		return extraVo;
	}

}
