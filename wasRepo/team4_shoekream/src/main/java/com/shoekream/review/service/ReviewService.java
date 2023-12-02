package com.shoekream.review.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.review.dao.ReviewDao;
import com.shoekream.review.vo.ReviewVo;

public class ReviewService {

	//리뷰 목록 조회
	public List<ReviewVo> selectReviewList(PageVo pvo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		ReviewDao dao = new ReviewDao();
		List<ReviewVo> reviewVoList = dao.selectReviewList(conn, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return reviewVoList;
	}

	
	
}
