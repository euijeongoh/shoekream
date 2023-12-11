package com.shoekream.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.review.vo.ReviewCommentVo;

public class ReviewCommentDao {

	
	//댓글 작성
	public int reviewCommentwrite(Connection conn, ReviewCommentVo vo) throws Exception {
		
		String sql = "INSERT INTO REVIEW_COMMENT(NO, MEMBER_NO, REVIEW_NO, CONTENT, LIKE_BTN) VALUES(SEQ_REVIEW_COMMENT_NO.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberNo());
		pstmt.setString(2, vo.getReviewNo());
		pstmt.setString(4, vo.getContent());
		pstmt.setString(5, vo.getLikeBtn());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

//	//댓글 목록
//	public List<ReviewCommentVo> ReviewCommentList(Connection conn) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
		
}
