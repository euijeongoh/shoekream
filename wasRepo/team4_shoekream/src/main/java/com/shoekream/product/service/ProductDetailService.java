package com.shoekream.product.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.product.dao.ProductDetailDao;

public class ProductDetailService {
	// PRODUCTS테이블 쪽 데이터
	public EnrollProductVo getProductDetail(String modelNumber) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		ProductDetailDao dao = new ProductDetailDao();
		EnrollProductVo dbVo = new EnrollProductVo();

		dbVo = dao.getProductDetail(conn, modelNumber);
		// close
		JDBCTemplate.close(conn);

		return dbVo;
	}
	// SHOES_SIZES테이블 쪽 데이터
	// BIDDING테이블 쪽 데이터

	public List<EnrollProductVo> getShoesSizesDetail(EnrollProductVo productDetailVo) throws Exception {
		// Conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		ProductDetailDao dao = new ProductDetailDao();
		List<EnrollProductVo> dbVo = new ArrayList<EnrollProductVo>();
		// enrolledProductVo를 넘겨줌으로써 사이즈 배열 가져오기
		dbVo = dao.getShoesSizesDetail(conn, productDetailVo);

		// close
		JDBCTemplate.close(conn);

		return dbVo;
	}

	public List<BiddingVo> getBiddingDetail(String productNo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		ProductDetailDao dao = new ProductDetailDao();
		List<BiddingVo> biddingList = dao.getBiddingDetail(conn, productNo);

		// close
		JDBCTemplate.close(conn);

		return biddingList;
	}

	public List<EnrollProductVo> getProductList() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		ProductDetailDao dao = new ProductDetailDao();
		List<EnrollProductVo> productVoList = dao.getProductList(conn);
		// close
		JDBCTemplate.close(conn);
		return productVoList;
	}

	public String getBuyingPrice(String productNo) throws Exception {
		// Conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		ProductDetailDao dao = new ProductDetailDao();

		String getPrice = dao.getBuyingPrice(conn, productNo);

		JDBCTemplate.close(conn);
		return getPrice;
	}

	public String getSellingPrice(String productNo) throws Exception {
		// Conn
		Connection conn = JDBCTemplate.getConnection();
		// dao
		ProductDetailDao dao = new ProductDetailDao();

		String getPrice = dao.getSellingPrice(conn, productNo);

		JDBCTemplate.close(conn);
		return getPrice;
	}
	
	public List<BiddingVo> getBuyBiddingList(String productNo) throws Exception{
		//Conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		ProductDetailDao dao = new ProductDetailDao();
		
		List<BiddingVo> biddingList = dao.getBuyBiddingList(conn, productNo);
		
		JDBCTemplate.close(conn);
		return biddingList;
	}
	public List<BiddingVo> getSellBiddingList(String productNo) throws Exception{
		//Conn
		Connection conn = JDBCTemplate.getConnection();
		//dao
		ProductDetailDao dao = new ProductDetailDao();
		
		List<BiddingVo> biddingList = dao.getBuyBiddingList(conn, productNo);
		
		JDBCTemplate.close(conn);
		return biddingList;
	}

	public int addWishList(String memberNo, String productNo) throws Exception{
		Connection conn = JDBCTemplate.getConnection();
		
		ProductDetailDao dao = new ProductDetailDao();
		
		int result = dao.addWishList(conn, memberNo, productNo);
		
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
}