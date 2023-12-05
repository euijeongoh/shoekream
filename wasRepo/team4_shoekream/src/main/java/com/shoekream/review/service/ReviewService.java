package com.shoekream.review.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;
import com.shoekream.review.dao.ReviewDao;
import com.shoekream.review.vo.CategoryVo;
import com.shoekream.review.vo.ReviewVo;

public class ReviewService {
	
	//리뷰 작성
	public int write(ReviewVo vo) throws Exception {
	      
      // conn
      Connection conn = JDBCTemplate.getConnection();
      
      // dao
      ReviewDao dao = new ReviewDao();
      int result = dao.write(conn, vo);
      
      // tx
      if(result == 1) {
         JDBCTemplate.commit(conn);
      }else {
         JDBCTemplate.rollback(conn);
      }
      
      // close
      JDBCTemplate.close(conn);
      
      return result;
   }
	
	//리뷰 목록 조회
	public List<ReviewVo> getReviewList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> reviewVoList = dao.getReviewList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return reviewVoList;
	}


//	//전체 리뷰 갯수 조회
//	public int selectBoardCount() throws Exception {
//	      
//      // conn
//      Connection conn = JDBCTemplate.getConnection();
//      
//      // dao
//      ReviewDao dao = new ReviewDao();
//      int cnt = dao.selectReviewCount(conn);
//      
//      // close
//      JDBCTemplate.close(conn);
//      
//      return cnt;
      
//   }//selectReviewCount

//	//카테고리 리스트 조회
//	public List<CategoryVo> getCategoryList() {
//			   
//	   //conn
//	   Connection conn = JDBCTemplate.getConnection();
//	   
//	   //dao
//	   ReviewDao dao = new ReviewDao();
//	   List<CategoryVo> voList = dao.getCategoryList(conn);
//	   
//	   //close
//	   JDBCTemplate.close(conn);
//	   
//	   return voList;
//	}

	public List<ReviewVo> selectReviewList(PageVo pvo) {
		// TODO Auto-generated method stub
		return null;
	}



	

	
	
}
