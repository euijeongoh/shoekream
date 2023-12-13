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

	public EnrollProductVo getEnrolledProductNo(EnrollProductVo vo)throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		EnrollProductVo dbVo = dao.getEnrolledProductNo(conn, vo);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}

	public int enrollProductSize(EnrollProductVo productSizesVo) throws Exception{
		//Conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		int result = dao.enrollProductSize(conn, productSizesVo);
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

	public int editProduct(EnrollProductVo vo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		int result = dao.editProduct(conn, vo);
		
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
	//상품의 데이터 수정
	public int editProductSize(EnrollProductVo productSizesVo) throws Exception{
		//Conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		int result = dao.editProductSize(conn, productSizesVo);
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	//modelNumber로 상품번호 가져오기
	public EnrollProductVo getEnrolledProductNo(String modelNumber) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		EnrollProductVo dbVo = dao.getEnrolledProductNo(conn, modelNumber);
		JDBCTemplate.close(conn);
		return dbVo;
	}
	
}
