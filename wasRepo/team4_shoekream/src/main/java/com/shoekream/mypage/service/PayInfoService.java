package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.dao.PayInfoDao;
import com.shoekream.mypage.vo.PayInfoVo;

public class PayInfoService {

	public PayInfoVo selectPayInfoList(String no) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();

		PayInfoDao ad = new PayInfoDao();
		PayInfoVo vo = ad.selectPayInfoList(conn, no);

		JDBCTemplate.close(conn);

		return vo;
	}

	public List<PayInfoVo> selectExtraPayInfoList(String no) throws Exception{
		
		Connection conn = JDBCTemplate.getConnection();

		PayInfoDao ad = new PayInfoDao();
		List<PayInfoVo> extraVo = ad.selectExtraPayInfoList(conn, no);

		JDBCTemplate.close(conn);

		return extraVo;
	}



}
