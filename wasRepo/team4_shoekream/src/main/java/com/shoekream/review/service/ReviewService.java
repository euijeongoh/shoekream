package com.shoekream.review.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.notice.dao.NoticeDao;
import com.shoekream.notice.vo.NoticeVo;
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

	
	//내 리뷰 목록 조회 (리뷰 리스트)
	public List<ReviewVo> myReviewList(MemberVo loginMember) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> myreviewVoList = dao.myReviewList(conn, loginMember);
		
		//close
		JDBCTemplate.close(conn);
		
		return myreviewVoList;
	}
	
	
	//전체 리뷰목록 조회 (리뷰 리스트)
	public List<ReviewVo> selectReviewList(MemberVo loginMember) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> reviewVoList = dao.myReviewList(conn, loginMember);
		
		//close
		JDBCTemplate.close(conn);
		
		return reviewVoList;
	}
	
	
	//리뷰 상세조회
	public ReviewVo selectReviewByNo(String no) throws Exception {
	    
		// conn
	    Connection conn = JDBCTemplate.getConnection();

	    // dao
	    ReviewDao dao = new ReviewDao();
	    ReviewVo vo = dao.selectReviewByNo(conn, no);

	    // tx
//	    JDBCTemplate.close(conn);
//	    Map<String, Object> map = new HashMap<String, Object>();
//	    map.put("vo", vo);

	    return vo;
	    
		}


	//리뷰삭제
	public int delete(String no, String memberNo) throws Exception {
	 //conn
      Connection conn = JDBCTemplate.getConnection();
      
      //dao
      ReviewDao dao = new ReviewDao();
      int result = dao.delete(conn , no , memberNo);
      
      //tx
      if(result == 1) {
         JDBCTemplate.commit(conn);
      }else {
         JDBCTemplate.rollback(conn);
      }
      
      //close
      JDBCTemplate.close(conn);

      return result;
   }//delete


	//리뷰 수정
	public int edit(ReviewVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		int result = dao.updateReviewByNo(conn, vo);
		
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
	
	//no로 DB받아오기
	public ReviewVo getReviewByNo(String no) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		ReviewVo vo = dao.getReviewByNo(conn, no);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}
	
	
		
	}

