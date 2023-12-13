package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.mypage.dao.AddressDao;
import com.shoekream.mypage.dao.PayInfoDao;
import com.shoekream.mypage.vo.PayInfoVo;

public class PayInfoService {

	public PayInfoVo selectPayInfoList(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		PayInfoDao ad = new PayInfoDao();
		PayInfoVo vo = ad.selectPayInfoList(conn, no);

		JDBCTemplate.close(conn);

		return vo;
	}

	public List<PayInfoVo> selectExtraPayInfoList(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		PayInfoDao ad = new PayInfoDao();
		List<PayInfoVo> extraVo = ad.selectExtraPayInfoList(conn, no);

		JDBCTemplate.close(conn);

		return extraVo;
	}

	public int changeDefault(String no, String mamberNo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();

		PayInfoDao ad = new PayInfoDao();
		int result = ad.changeDefaultYn(conn, no, mamberNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);

		return result;
	}

	public int insertPayInfo(PayInfoVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		PayInfoDao pd = new PayInfoDao();
		int result = pd.insertPayinfo(conn, vo);

		JDBCTemplate.close(conn);

		return result;
	
	}

	public int payInfoDelete(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		PayInfoDao ad = new PayInfoDao();
		int result = ad.payInfoDelete(conn, no);

		JDBCTemplate.close(conn);

		return result;
	}

}
