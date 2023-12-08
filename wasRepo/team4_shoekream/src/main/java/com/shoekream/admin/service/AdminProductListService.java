package com.shoekream.admin.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.admin.dao.AdminEnrollProductDao;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;

public class AdminProductListService {

	public List<EnrollProductVo> selectProductList(PageVo pvo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		AdminEnrollProductDao  dao = new AdminEnrollProductDao();
		
		List<EnrollProductVo> productVoList = dao.selectProductList(conn, pvo);
		
		JDBCTemplate.close(conn);
		
		return productVoList;
		
	}

	public int selectProductCount() throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		int result = dao.selectProductCount(conn);
		JDBCTemplate.close(conn);
		return result;
				
		
	}

}
