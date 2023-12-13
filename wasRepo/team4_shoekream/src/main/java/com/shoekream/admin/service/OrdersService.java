package com.shoekream.admin.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.admin.dao.OrderDao;
import com.shoekream.admin.vo.OrdersVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;

public class OrdersService {

	public int selectOrdersCount() throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		OrderDao dao = new OrderDao();
		int cnt = dao.selectStorageListCount(conn);

		// close
		JDBCTemplate.close(conn);

		return cnt;
	}

	public List<OrdersVo> selectStorageList(PageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		OrderDao dao = new OrderDao();
		List<OrdersVo> OrderVoList = dao.selectStorageList(conn, pvo);

		// close
		JDBCTemplate.close(conn);

		return OrderVoList;
	}

	public List<OrdersVo> selectCheckList(PageVo pvo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		OrderDao dao = new OrderDao();
		List<OrdersVo> OrderVoList = dao.selectCheckList(conn, pvo);

		// close
		JDBCTemplate.close(conn);

		return OrderVoList;
	}

	public List<OrdersVo> selectSendList(PageVo pvo) throws Exception{
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		OrderDao dao = new OrderDao();
		List<OrdersVo> OrderVoList = dao.selectSendList(conn, pvo);

		// close
		JDBCTemplate.close(conn);

		return OrderVoList;

	}

}
