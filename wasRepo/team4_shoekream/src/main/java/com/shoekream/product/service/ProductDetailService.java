package com.shoekream.product.service;

import java.sql.Connection;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.product.dao.ProductDetailDao;

public class ProductDetailService {
	//PRODUCTS테이블 쪽 데이터
	public EnrollProductVo getProductDetail(EnrollProductVo enrolledProductVo) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		ProductDetailDao dao = new ProductDetailDao();
		EnrollProductVo dbVo = new EnrollProductVo();
		
		dbVo = dao.getProductDetail(conn, enrolledProductVo);
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}
	//SHOES_SIZES테이블 쪽 데이터
	//BIDDING테이블 쪽 데이터

	public EnrollProductVo getShoesSizesDetail(EnrollProductVo productDetailVo) throws Exception{
		//Conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		ProductDetailDao dao = new ProductDetailDao();
		EnrollProductVo dbVo = new EnrollProductVo();
			//enrolledProductVo를 넘겨줌으로써 사이즈 배열 가져오기
		dbVo = dao.getShoesSizesDetail(conn, productDetailVo);
		
		//close
		JDBCTemplate.close(conn);
		
		return dbVo;
	}

}
