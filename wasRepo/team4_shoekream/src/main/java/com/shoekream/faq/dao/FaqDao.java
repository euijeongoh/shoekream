package com.shoekream.faq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.faq.vo.FaqVo;
import com.shoekream.page.vo.PageVo;

public class FaqDao {

	
	//게시글 전체 조회
	public List<FaqVo> FaqList(Connection conn, PageVo pvo) throws Exception{
		
		//sql
		String sql = "SELECT * FROM    ( SELECT ROWNUM RNUM, T.* FROM ( SELECT NO, TITLE, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, HIT FROM FAQ_BOARD WHERE DEL_YN = 'N' ORDER BY NO DESC) T ) WHERE RNUM BETWEEN ? AND ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<FaqVo> faqVoList = new ArrayList<FaqVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			String hit = rs.getString("HIT");
			
			FaqVo vo = new FaqVo();
			
			vo.setNo(no);
			vo.setTitle(title);
			vo.setEnrollDate(enrollDate);
			vo.setHit(hit);
			
			faqVoList.add(vo);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return faqVoList;
		
	}

	//전체 게시글 갯수
	public int selectFaqCount(Connection conn) throws Exception{
		
		String sql = "SELECT COUNT(*) AS COUNT FROM FAQ_BOARD WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		int count = 0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return count;
		
	
	}
	
	//검색 게시글 갯수
		public int selectSearchFaqCount(Connection conn, String title) throws Exception{
			
			String sql = "SELECT COUNT(*) FROM FAQ_BOARD WHERE DEL_YN = 'N' AND TITLE LIKE '%' || ?|| '%'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			ResultSet rs = pstmt.executeQuery();
			
			int count = 0;
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
			return count;
			
		
		}

	//게시글 상세 조회
	public FaqVo selectFaqByNo(Connection conn, String no) throws Exception{
		
		//SQL
		String sql = "SELECT NO, TITLE, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, HIT FROM FAQ_BOARD WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		FaqVo vo = null;
		if(rs.next()) {
			vo = new FaqVo();
			String faqNo = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String hit =rs.getString("HIT");
			
			vo.setNo(faqNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
			vo.setHit(hit);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}
	
	
	//상세조회 시 조회수 증가
	public int increaseHit(Connection conn, String no) throws Exception{
		
		String sql = "UPDATE FAQ_BOARD SET HIT = HIT + 1 WHERE NO = ? AND DEL_YN='N' ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//게시글 검색(제목)
	public List<FaqVo> faqSearch(Connection conn, String title, PageVo pvo) throws Exception{
		
		//SQL
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT NO, TITLE, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM FAQ_BOARD WHERE DEL_YN = 'N' AND TITLE LIKE '%' || ?|| '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
 		pstmt.setInt(2, pvo.getStartRow());
 		pstmt.setInt(3, pvo.getLastRow());
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<FaqVo> faqVoList = new ArrayList<FaqVo>();
		while(rs.next()) {
			
			FaqVo vo = new FaqVo();
			
			vo.setNo(rs.getString("NO"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			
			faqVoList.add(vo);
			
		}
		
		return faqVoList;
		
		//close
	}

	//게시글 작성
	public int faqWrite(Connection conn, FaqVo vo) throws Exception{
		
		//SQL
		String sql = "INSERT INTO FAQ_BOARD ( NO, MANAGER_NO, TITLE, CONTENT ) VALUES (SEQ_FAQ_BOARD_NO.NEXTVAL, 1, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	//게시글 삭제
	public int faqDelete(Connection conn, String no) throws Exception{
		//SQL
		String sql = "UPDATE FAQ_BOARD SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		int result = pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	
	//no로 DB받아오기
	public FaqVo getFaqByNo(Connection conn, String no) throws Exception{
		//SQL
		String sql = "SELECT TITLE, CONTENT FROM FAQ_BOARD WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		FaqVo vo = null;
		if(rs.next()) {
			vo = new FaqVo();
			
			vo.setNo(no);
			vo.setTitle(rs.getString("TITLE")); 
			vo.setContent(rs.getString("CONTENT"));
			
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
		
	}

	//게시글 수정
	public int faqEdit(Connection conn, FaqVo vo) throws Exception{
		
		//SQL
		String sql = "UPDATE Faq_BOARD SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getNo());
		
		int result = pstmt.executeUpdate();
		
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}


	

}
