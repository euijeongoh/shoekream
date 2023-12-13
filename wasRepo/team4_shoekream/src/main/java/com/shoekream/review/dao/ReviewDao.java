package com.shoekream.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.MemberVo;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.review.vo.ReviewVo;

public class ReviewDao {
	
	
	//리뷰작성                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	public int write(Connection conn, ReviewVo vo) throws Exception {
		
	 //SQL
	  String sql = "INSERT INTO REVIEW(NO, MEMBER_NO, PRODUCT_NO, COMFORT_NO, CONTENT, REVIEW_IMAGE) VALUES(SEQ_REVIEW_NO.NEXTVAL, ?, ?, ?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getMemberNo());
      pstmt.setString(2, vo.getProductNo());
      pstmt.setString(3, vo.getComfortNo());
      pstmt.setString(4, vo.getContent());
      pstmt.setString(5, vo.getReviewImage());
//      pstmt.setString(5, vo.getLikeBtn());
//      pstmt.setString(6,  vo.getReviewImage());
      int result = pstmt.executeUpdate();
      
      //close
      JDBCTemplate.close(pstmt);
      return result;
      
   }
	

	//내 리뷰 목록조회 (리스트)
	public List<ReviewVo> myReviewList(Connection conn, MemberVo loginMember) throws Exception {
		
		//sql
		String sql = "SELECT NO, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM REVIEW WHERE DEL_YN = 'N' ORDER BY ENROLL_DATE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<ReviewVo> myreviewVoList = new ArrayList<ReviewVo>();
		while(rs.next()) {
			
			String no = rs.getString("NO");
			String enrollDate = rs.getString("ENROLL_DATE");
//			String likeBtn = rs.getString("LIKE_BTN");
//			String reviewImage = rs.getString("REVIEW_IMAGE");
//			String profileImage = rs.getString("PROFILE_IMAGE");
			
			ReviewVo vo = new ReviewVo();
			vo.setNo(no);
			vo.setEnrollDate(enrollDate);
//			vo.setLikeBtn(likeBtn);
//			vo.setReviewImage(reviewImage);
//			vo.setProfileImage(profileImage);
			
			myreviewVoList.add(vo);
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return myreviewVoList;
	}
	
	
	
	//전체 리뷰 목록 조회
		public List<ReviewVo> ReviewList(Connection conn, MemberVo loginMember) throws Exception {
			
			//sql
			String sql = "SELECT R.NO    REVIEW_NO , M.NICKNAME    NICK , M.PROFILE_IMAGE   PROFILE , R.ENROLL_DATE REVIEW_ENROLL , R.MODIFY_DATE REVIEW_MODIFY , RIMG.FILE_PATH    REVIEW_IMAGE FROM REVIEW R LEFT JOIN MEMBER M ON R.MEMBER_NO = M.NO LEFT JOIN REVIEW_IMAGE RIMG ON R.NO = RIMG.REVIEW_NO WHERE R.MEMBER_NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginMember.getNo());
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			List<ReviewVo> reviewVoList = new ArrayList<ReviewVo>();
			while(rs.next()) {
				
				String reviewNo = rs.getString("REVIEW_NO");
				String memberNick = rs.getString("NICK");
				String memberProfile = rs.getString("PROFILE");
				String enrollDate = rs.getString("REVIEW_ENROLL");
				String modifyDate = rs.getString("REVIEW_MODIFY");
				String reviewImage = rs.getString("REVIEW_IMAGE");
				
				ReviewVo vo = new ReviewVo();
				vo.setNo(reviewNo);
				vo.setMemberNick(memberNick);
				vo.setProfileImage(memberProfile);
				vo.setEnrollDate(enrollDate);
				vo.setModifyDate(modifyDate);
				vo.setReviewImage(reviewImage);
				
				reviewVoList.add(vo);
				
			}
			
			//close
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
			return reviewVoList;
		}
		
		
//	public List<ReviewVo> reviewList(Connection conn) throws Exception {
//	    // sql
//	    String sql = "SELECT I.THUMBNAIL_YN, R.NO, R.REVIEW_NO, R.MEMBER_NO, R.ENROLL_DATE, R.MODIFY_DATE, I.NO AS IMAGE_NO, I.REVIEW_IMAGE_NO, I.FILE_PATH FROM REVIEW R JOIN REVIEW_IMAGE I ON R.NO = I.REVIEW_NO WHERE DEL_YN = 'N' ORDER BY R.ENROLL_DATE DESC";
//	    PreparedStatement pstmt = conn.prepareStatement(sql);
//	    ResultSet rs = pstmt.executeQuery();
//
//	    // rs
//	    List<ReviewVo> reviewVoList = new ArrayList<>();
//	    while (rs.next()) {
//	        String no = rs.getString("NO");
//	        String reviewNo = rs.getString("REVIEW_NO");
//	        String memberNo = rs.getString("MEMBER_NO");
//	        String enrollDate = rs.getString("ENROLL_DATE");
//	        String modifyDate = rs.getString("MODIFY_DATE");
//
//	        String imageNo = rs.getString("IMAGE_NO");
//	        String reviewImageNo = rs.getString("REVIEW_IMAGE_NO");
//	        String filePath = rs.getString("FILE_PATH");
//	        String thumbnailYn = rs.getString("THUMBNAIL_YN");
//
//	        ReviewVo reviewVo = new ReviewVo(no, reviewNo, memberNo, enrollDate, modifyDate, imageNo, reviewImageNo, filePath, thumbnailYn);
//	        reviewVoList.add(reviewVo);
//	    }
//
//	    // 조회한 데이터를 용이하게 가공
//	    Map<String, ReviewVo> map = new HashMap<>();
//	    for (ReviewVo reviewVo : reviewVoList) {
//	        map.put(reviewVo.getReviewNo(), reviewVo);
//	    }
//
//	    for (ReviewVo reviewVo : reviewVoList) {
//	        String No = reviewVo.getNo();
//	        String imageNo = reviewVo.getImageNo();
//	        String reviewImageNo = reviewVo.getReviewImageNo();
//	        String filePath = reviewVo.getFilePath();
//	        String thumbnailYn = reviewVo.getThumbnailYn();
//
//	        ReviewImageVo attVo = new ReviewImageVo(imageNo, reviewImageNo, filePath, thumbnailYn);
//	        ReviewVo target = map.get(attVo.getReviewImageNo());
//	        if (target != null) {
//	            target.getReviewImage().add(attVo);
//	        }
//	    }
//
//	    ArrayList<ReviewVo> result = new ArrayList<>(map.values());
//
//	    // result에서 썸네일 객체 셋팅
//	    for (ReviewVo reviewVo : result) {
//	        List<ReviewImageVo> attVoList = reviewVo.getReviewImage();
//	        for (ReviewImageVo attVo : attVoList) {
//	            String thumbnailYn = attVo.getThumbnailYn();
//	            if (thumbnailYn.equals("Y")) {
//	                reviewVo.setThumbnailVo(attVo);
//	                break;
//	            }
//	        }
//	    }
//
//	    // close
//	    JDBCTemplate.close(rs);
//	    JDBCTemplate.close(pstmt);
//
//	    return result;
//	}
	
//			ReviewVo vo = new ReviewVo();
//			vo.setNo(no);
//			vo.setMemberNo(memberNo);
//			vo.setLikeBtn(likeBtn);
//			vo.setReviewImage(reviewImage);
//			vo.setProfileImage(profileImage);
//			
//			reviewVoList.add(vo);
//			
//		}
//		
//		//close
//		JDBCTemplate.close(pstmt);
//		JDBCTemplate.close(rs);
//		
//		return reviewVoList;
//	}


	//리뷰 상세조회
	public ReviewVo selectReviewByNo(Connection conn, String no) throws Exception {
		
		//sql
		String sql = "SELECT NO, MEMBER_NO, PRODUCT_NO, COMFORT_NO, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, MODIFY_DATE FROM REVIEW WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		ReviewVo vo = null;
		if(rs.next()) {
			vo = new ReviewVo();
			String No = rs.getString("NO");
			String memberNo = rs.getString("MEMBER_NO");
			String productNo = rs.getString("PRODUCT_NO");
			String comfortNo = rs.getString("COMFORT_NO");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String ModifyDate = rs.getString("MODIFY_DATE");
			
			vo.setNo(No);
			vo.setMemberNo(memberNo);
			vo.setProductNo(productNo);
			vo.setComfortNo(comfortNo);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setModifyDate(ModifyDate);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
		
	}


	//리뷰 삭제
	public int delete(Connection conn, String no, String memberNo) throws Exception{
		
		  //SQL
	      String sql = "UPDATE REVIEW SET DEL_YN = 'Y' WHERE NO = ? AND MEMBER_NO = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, no);
	      pstmt.setString(2, memberNo);
	      int result = pstmt.executeUpdate();
	      
	      //close
	      JDBCTemplate.close(pstmt);
	      
	      return result;
	      
	   }//delete
	
	
	//리뷰 수정
	 public int updateReviewByNo(Connection conn, ReviewVo vo) throws Exception {
		   // SQL
		   String sql = "UPDATE REVIEW SET COMFORT_NO = ?, CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ? AND DEL_YN = 'Y'";
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, vo.getComfortNo());
		   pstmt.setString(2, vo.getContent());
		   pstmt.setString(3, vo.getNo());
		   int result = pstmt.executeUpdate();
		   
		   // close
		   JDBCTemplate.close(pstmt);
		   
		   return result; 
	   }


	public EnrollProductVo getProductInfo(Connection conn, String productNo) throws Exception{
		String sql = "SELECT NAME, NAME_KO FROM PRODUCTS WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productNo);
		ResultSet rs = pstmt.executeQuery();
		
		EnrollProductVo dbVo = null;
		if(rs.next()) {
			String name = rs.getString("NAME");
			String nameKo = rs.getString("NAME_KO");
//			String productNo = rs.getString("PRODUCT_NO");
			dbVo = new EnrollProductVo();
			
			dbVo.setProductName(name);
			dbVo.setProductNameKo(nameKo);
			dbVo.setProductNo(productNo);
			
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return dbVo;
	}
	
	//no로 DB받아오기
	public ReviewVo getReviewByNo(Connection conn, String no) throws Exception{
		//SQL
		String sql = "SELECT TITLE, CONTENT FROM REVIEW WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		ReviewVo vo = null;
		if(rs.next()) {
			vo = new ReviewVo();
			
			vo.setNo(no);
			vo.setContent(rs.getString("CONTENT"));
			
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
		
	}



}//class