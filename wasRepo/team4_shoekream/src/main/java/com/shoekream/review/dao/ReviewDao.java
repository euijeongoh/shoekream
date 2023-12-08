package com.shoekream.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.review.vo.ReviewVo;

public class ReviewDao {
	
	
	//리뷰작성                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	public int write(Connection conn, ReviewVo vo) throws Exception {
		
	 //SQL
	  String sql = "INSERT INTO REVIEW(NO ,MEMBER_NO ,PRODUCT_NO ,COMFORT_NO ,FIVE_STAR_RATING ,CONTENT ,REVIEW_IMAGE ,PROFILE_IMAGE) VALUES(SEQ_REVIEW_NO.NEXTVAL, ? ,? ,? ,? ,? ,? ,?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getNo());
      pstmt.setString(2, vo.getMemberNo());
      pstmt.setString(3, vo.getProductNo());
      pstmt.setString(4, vo.getComfortNo());
      pstmt.setString(5, vo.getFiveStarRating());
      pstmt.setString(6, vo.getContent());
      pstmt.setString(7, vo.getLikeBtn());
      pstmt.setString(8, vo.getReviewImage());
      pstmt.setString(9, vo.getProfileImage());
      int result = pstmt.executeUpdate();
      
      //close
      JDBCTemplate.close(pstmt);
      return result;
      
   }
	

	//내 리뷰 목록 조회
	public List<ReviewVo> myReviewList(Connection conn) throws Exception {
		
		//sql
		String sql = "SELECT NO, LIKE_BTN, REVIEW_IMAGE, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM REVIEW WHERE DEL_YN = 'N' ORDER BY ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<ReviewVo> myreviewVoList = new ArrayList<ReviewVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String likeBtn = rs.getString("LIKE_BTN");
			String reviewImage = rs.getString("REVIEW_IMAGE");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			ReviewVo vo = new ReviewVo();
			vo.setNo(no);
			vo.setLikeBtn(likeBtn);
			vo.setReviewImage(reviewImage);
			vo.setProfileImage(profileImage);
			vo.setEnrollDate(enrollDate);
			
			myreviewVoList.add(vo);
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return myreviewVoList;
	}
	
	
	
	//전체 리뷰 목록 조회
	public List<ReviewVo> ReviewList(Connection conn) throws Exception {
		
		//sql
		String sql = "SELECT NO, MEMBER_NO, LIKE_BTN, REVIEW_IMAGE, PROFILE_IMAGE FROM REVIEW WHERE DEL_YN = 'N' ORDER BY ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<ReviewVo> reviewVoList = new ArrayList<ReviewVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String likeBtn = rs.getString("LIKE_BTN");
			String reviewImage = rs.getString("REVIEW_IMAGE");
			String profileImage = rs.getString("PROFILE_IMAGE");
			
			ReviewVo vo = new ReviewVo();
			vo.setNo(no);
			vo.setMemberNo(memberNo);
			vo.setLikeBtn(likeBtn);
			vo.setReviewImage(reviewImage);
			vo.setProfileImage(profileImage);
			
			reviewVoList.add(vo);
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return reviewVoList;
	}


}//class
