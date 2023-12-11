package com.shoekream.review.service;

import java.sql.Connection;

import com.shoekream.admin.dao.AdminEnrollProductDao;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.review.dao.ReviewDao;
import com.shoekream.review.vo.ReviewProductVo;

public class ReviewProductService {

//	//카테고리 확인
//		public ReviewProductVo categoryCheck(String category) throws Exception{
//			//conn
//			Connection conn = JDBCTemplate.getConnection();
//			
//			//dao
//			ReviewDao dao = new ReviewDao();
//			
//			ReviewProductVo dbVo = dao.categoryCheck(conn, category);
//			
//			//close
//			JDBCTemplate.close(conn);
//			
//			return dbVo;
//		}
		
		//브랜드 확인
		public ReviewProductVo brandCheck(String brand) throws Exception{
			//conn
			Connection conn = JDBCTemplate.getConnection();
			
			//dao
//			ReviewDao dao = new ReviewDao();
			
			ReviewProductVo dbVo = dao.brandCheck(conn, brand);
			
			//close
			JDBCTemplate.close(conn);
			
			return dbVo;
			
		}
		
		public EnrollProductVo getReviewProductNo(ReviewProductVo vo)throws Exception {
			//conn
			Connection conn = JDBCTemplate.getConnection();
			
			//dao
			ReviewDao dao = new ReviewDao();
			
			ReviewProductVo dbVo = dao.getReviewProductNo(conn, vo);
			
			//close
			JDBCTemplate.close(conn);
			
			return dbVo;
		}
}
