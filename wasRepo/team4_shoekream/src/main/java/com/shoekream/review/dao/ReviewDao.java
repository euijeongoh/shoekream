package com.shoekream.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;
import com.shoekream.review.vo.CategoryVo;
import com.shoekream.review.vo.ReviewVo;

public class ReviewDao {

	//리뷰 목록 조회
	public List<ReviewVo> getReviewList(Connection conn) throws Exception {
		
		//sql
		String sql = "SELECT  MEMBER_NO AS  REVIEW_IMAGE , PROFILE_IMAGE , LIKE_BTN FROM REVIEW";		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<ReviewVo> reviewVoList = new ArrayList<ReviewVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String reviewImage = rs.getString("REVIEW_IMAGE");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String likeBtn = rs.getString("LIKE_BTN");
			
			ReviewVo vo = new ReviewVo();
			vo.setNo(no);
			vo.setReviewImage(reviewImage);
			vo.setProfileImage(profileImage);
			vo.setLikeBtn(likeBtn);
			
			reviewVoList.add(vo);
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return reviewVoList;
	}

	//리뷰작성
	public int write(Connection conn, ReviewVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

//	//카테고리 리스트 조회
//	public List<CategoryVo> getCategoryList(Connection conn) {
//		 
//		   //sql
//		   String sql="SELECT * FROM CATEGORY ORDER BY NO ;";
//		   PreparedStatement pstmt = conn.prepareStatement(sql);
//		   ResultSet rs = pstmt.executeQuery();
//		   
//		   //rs
//		   List<CategoryVo> voList = new ArrayList<CategoryVo>();
//		   while(rs.next()) {
//			   String no = rs.getString("NO");
//			   String name= rs.getString("NAME");
//			   
//			   CategoryVo vo = new CategoryVo();
//			   vo.setNo(no);
//			   vo.setName(name);
//			   voList.add(vo);
//			   
//		   }
//		   
//		   //close
//		   JDBCTemplate.close(rs);
//		   JDBCTemplate.close(pstmt);
//		   
//		   return voList;
//	   }

	

}//class
