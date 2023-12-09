package com.shoekream.admin.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.admin.dao.AdminEnrollProductDao;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;

public class AdminProductListService {

	public List<EnrollProductVo> selectProductList(PageVo pvo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		AdminEnrollProductDao  dao = new AdminEnrollProductDao();
		
		List<EnrollProductVo> productVoList = dao.selectProductList(conn, pvo);
		//close
		JDBCTemplate.close(conn);
		
		return productVoList;
		
	}

	public int selectProductCount() throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		int result = dao.selectProductCount(conn);
		//close
		JDBCTemplate.close(conn);
		return result;
				
		
	}

	public int delete(EnrollProductVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		int result = dao.delete(conn,vo);
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

}
