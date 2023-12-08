package com.shoekream.review.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.review.dao.ReviewDao;
import com.shoekream.review.vo.ReviewVo;

public class ReviewService {
	
	//리뷰작성
	public int write(ReviewVo vo) throws Exception {
	      
      // conn
      Connection conn = JDBCTemplate.getConnection();
      
      // dao
      ReviewDao dao = new ReviewDao();
      int result = dao.write(conn, vo);
      
      // txs
      if(result == 1) {
         JDBCTemplate.commit(conn);
      }else {
         JDBCTemplate.rollback(conn);
      }
      
      // close
      JDBCTemplate.close(conn);
      
      return result;
   }
	
	//내 리뷰 목록 조회
	public List<ReviewVo> myReviewList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> myreviewVoList = dao.myReviewList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return myreviewVoList;
	}
	
	
	//전체 리뷰목록 조회
	public List<ReviewVo> selectReviewList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> reviewVoList = dao.ReviewList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return reviewVoList;
	}

	
	


}
