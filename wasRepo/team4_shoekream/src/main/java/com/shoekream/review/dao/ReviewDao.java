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
	
	
	//리뷰작성                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	public int write(Connection conn, ReviewVo vo) throws Exception {
		
	 //SQL
	  String sql = "INSERT INTO REVIEW(NO ,MEMBER_NO ,PRODUCT_NO ,COMFORT_NO ,FIVE_STAR_RATING ,CONTENT ,LIKE_BTN ,REVIEW_IMAGE ,PROFILE_IMAGE) VALUES(SEQ_REVIEW_NO.NEXTVAL, ? ,? ,? ,? ,? ,? ,? ,?)";
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
		String sql = "SELECT MEMBER_NO, PROFILE_IMAGE , LIKE_BTN FROM REVIEW";		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<ReviewVo> myreviewVoList = new ArrayList<ReviewVo>();
		while(rs.next()) {
			
			String memberNo = rs.getString("MEMBER_NO");
			String profileImage = rs.getString("PROFILE_IMAGE");
			String likeBtn = rs.getString("LIKE_BTN");
			
			ReviewVo vo = new ReviewVo();
			vo.setNo(memberNo);
			vo.setProfileImage(profileImage);
			vo.setLikeBtn(likeBtn);
			
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
		String sql = "SELECT MEMBER_NO AS  REVIEW_IMAGE , PROFILE_IMAGE , LIKE_BTN FROM REVIEW";		
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

	
	public int selectReviewCount(Connection conn) throws Exception {
		
		//sql
		String sql = "SELECT COUNT(*) as cnt FROM REVIEW WHERE STATUS = 'O'";
        PreparedStatement pstmt = conn.prepareStatement(sql);
      
        ResultSet rs = pstmt.executeQuery();
      
        //rs
        int cnt = 0;
        if(rs.next()) {
//	         int cnt = rs.getInt("cnt");
           cnt = rs.getInt(1); //첫번째 열을 가져오겠다 라는 뜻, 계산에 써야되기 때문에 String이 아닌 Int로 받아줌
        }
      
        //close
        JDBCTemplate.close(rs);
        JDBCTemplate.close(pstmt);
      
        return cnt;
         
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
