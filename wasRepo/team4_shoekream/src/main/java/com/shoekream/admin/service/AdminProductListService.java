package com.shoekream.admin.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.admin.dao.AdminEnrollProductDao;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;

public class AdminProductListService {
	//상품 목록 조회
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
	//페이징을 위한 상품의 갯수 세기
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
	//상품목록에서 상품 삭제하기
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
	//모델넘버로 상품정보 가져오기
	public EnrollProductVo getProductInfo(String modelNumber) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		EnrollProductVo dbVo = dao.getProductInfo(conn, modelNumber);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
		
	}
	//사이즈 배열 가져오기
	public List<String> getProductSizesInfo(String productNo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		List<String> sizes = dao.getProductSizesInfo(conn, productNo);
		//close
		JDBCTemplate.close(conn);
		
		
		return sizes;
	}
	//카테고리 번호로 카테고리명 가져오기
	public EnrollProductVo getProductCategoryInfo(String categoryNo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		EnrollProductVo dbVo = dao.getProductCategoryInfo(conn, categoryNo);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}
	//브랜드 번호로 브랜드명 가져오기
	public EnrollProductVo getProductBrandInfo(String brandNo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		EnrollProductVo dbVo = dao.getProductBrandInfo(conn, brandNo);
		
		//close
		JDBCTemplate.close(conn);
		
		
		return dbVo;
	}
	public List<EnrollProductVo> searchFilterProduct(EnrollProductVo filterVo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		AdminEnrollProductDao dao = new AdminEnrollProductDao();
		
		List<EnrollProductVo> dbVoList = dao.searchFilterProduct(conn, filterVo);
		
		JDBCTemplate.close(conn);
		return dbVoList;
	}


}
