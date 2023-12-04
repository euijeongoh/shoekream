package com.shoekream.admin.service;

import java.sql.Connection;

import com.shoekream.admin.dao.EnrollProductDao;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;

public class EnrollProductService {



	public EnrollProductVo categoryCheck(String category) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		EnrollProductDao dao = new EnrollProductDao();
		
		EnrollProductVo checkVo = dao.categoryCheck(conn, category);
		
		JDBCTemplate.close(conn);
		
		return checkVo;
	}

	
}
