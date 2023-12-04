package com.shoekream.admin.service;

import java.sql.Connection;

import com.shoekream.admin.dao.EnrollProductDao;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;

public class EnrollProductService {


	public EnrollProductVo checkCategoryInfo(String category) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		EnrollProductDao dao = new EnrollProductDao();
		
		EnrollProductVo checkVo = dao.checkInfo(conn, category);
		
		JDBCTemplate.close(conn);
		
		return checkVo;
	}

	
}
