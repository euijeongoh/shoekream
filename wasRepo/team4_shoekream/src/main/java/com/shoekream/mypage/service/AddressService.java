package com.shoekream.mypage.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<AddrBookVo> selectExtraAddrList(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		AddressDao ad = new AddressDao();
		List<AddrBookVo> extraVo = ad.selectExtraAddrList(conn, no);

		JDBCTemplate.close(conn);

		return extraVo;
	}

	public int insertAddr(AddrBookVo vo) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		AddressDao ad = new AddressDao();
		int result = ad.insertAddr(conn, vo);

		JDBCTemplate.close(conn);

		return result;
	}

	public int addrDelete(String no) throws Exception {

		Connection conn = JDBCTemplate.getConnection();

		AddressDao ad = new AddressDao();
		int result = ad.addrDelete(conn, no);

		JDBCTemplate.close(conn);

		return result;
	}

	public AddrBookVo editAddr(String no) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		AddressDao ad = new AddressDao();
		AddrBookVo vo = ad.selectAddrNoList(conn, no);

		// close
		JDBCTemplate.close(conn);

		return vo;
	}

	public int updateAddr(AddrBookVo vo) throws Exception {
		Connection conn = JDBCTemplate.getConnection();

		AddressDao ad = new AddressDao();
		int result = ad.updateAddr(conn, vo);

		JDBCTemplate.close(conn);

		return result;
	}

	public Map<String, Object> changeDefault(String no) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		AddressDao ad = new AddressDao();
		int result = ad.changeDefaultYn(conn, no);
		int result2 = ad.changeDefaultNy(conn, no);
		
		if (result == 1 && result2 == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("result2", result2);

		// close
		JDBCTemplate.close(conn);
		
		return map;
	}

}
