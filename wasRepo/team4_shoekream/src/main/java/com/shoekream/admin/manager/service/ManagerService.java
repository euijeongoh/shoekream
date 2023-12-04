package com.shoekream.admin.manager.service;

import java.sql.Connection;

import com.shoekream.admin.manager.dao.ManagerDao;
import com.shoekream.admin.manager.vo.ManagerVo;
import com.shoekream.db.util.JDBCTemplate;

public class ManagerService {

	public ManagerVo adminLogin(ManagerVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ManagerDao dao = new ManagerDao();
		ManagerVo loginAdmin = dao.adminLogin(conn, vo);
		
		// close
		JDBCTemplate.close(conn);
		
		return loginAdmin;
	}

}
