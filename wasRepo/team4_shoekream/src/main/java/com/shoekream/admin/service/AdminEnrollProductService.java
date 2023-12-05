package com.shoekream.admin.service;

import java.sql.Connection;

import com.shoekream.admin.dao.AdminEnrollProductDao;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;

public class AdminEnrollProductService {


	//카테고리 확인
	public EnrollProductVo categoryCheck(String category) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		EnrollProductVo dbVo = dao.categoryCheck(conn, category);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}
	
	//브랜드 확인
	public EnrollProductVo brandCheck(String brand) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		EnrollProductVo dbVo = dao.brandCheck(conn, brand);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
		
	}
	
	//사이즈 확인
	public EnrollProductVo sizeCheck(String[] sizes) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		EnrollProductVo dbVo = dao.sizeCheck(conn, sizes);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}
	
	//제품 등록
	public int enrollProduct(EnrollProductVo vo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		int result = dao.enrollProduct(conn, vo);
		
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
