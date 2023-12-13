package com.shoekream.review.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.review.dao.ReviewCommentDao;
import com.shoekream.review.dao.ReviewDao;
import com.shoekream.review.vo.ReviewCommentVo;
import com.shoekream.review.vo.ReviewVo;

public class ReviewCommentService {

	
	//댓글작성
	public int reviewCommentwrite(ReviewCommentVo vo) throws Exception {
	      
      // conn
      Connection conn = JDBCTemplate.getConnection();
      
      // dao
      ReviewCommentDao dao = new ReviewCommentDao();
      int result = dao.reviewCommentwrite(conn, vo);
      
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

	
////	//댓글 목록
//	public List<ReviewCommentVo> reviewCommentList() throws Exception{
//		
//		//conn
//		Connection conn = JDBCTemplate.getConnection();
//		
//		//dao
//		ReviewCommentDao dao = new ReviewCommentDao();
//		List<ReviewCommentVo> reviewCommentVoList = dao.ReviewCommentList(conn);
//		
//		//close
//		JDBCTemplate.close(conn);
//		
//		return reviewCommentList();
//	}

}
