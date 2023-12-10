package com.shoekream.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;

public class NoticeDao {

	
	//게시글 전체 조회
	public List<NoticeVo> NoticeList(Connection conn, PageVo pvo) throws Exception{
		
		//sql
		String sql = "SELECT * FROM    ( SELECT ROWNUM RNUM, T.* FROM ( SELECT NO, TITLE, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM NOTICE_BOARD WHERE DEL_YN = 'N' ORDER BY NO DESC) T ) WHERE RNUM BETWEEN ? AND ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			NoticeVo nv = new NoticeVo();
			
			nv.setNo(no);
			nv.setTitle(title);
			nv.setEnrollDate(enrollDate);
			
			noticeVoList.add(nv);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return noticeVoList;
		
	}

	//전체 게시글 갯수
	public int selectNoticeCount(Connection conn) throws Exception{
		
		String sql = "SELECT COUNT(*) AS COUNT FROM NOTICE_BOARD WHERE DEL_YN = 'N'";
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
		public int selectSearchNoticeCount(Connection conn, String title) throws Exception{
			
			String sql = "SELECT COUNT(*) FROM NOTICE_BOARD WHERE DEL_YN = 'N' AND TITLE LIKE '%' || ?|| '%'";
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
	public NoticeVo selectNoticeByNo(Connection conn, String no) throws Exception{
		
		//SQL
		String sql = "SELECT NO, TITLE, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM NOTICE_BOARD WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		NoticeVo vo = null;
		if(rs.next()) {
			vo = new NoticeVo();
			String noticeNo = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			vo.setNo(noticeNo);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	//게시글 검색(제목)
	public List<NoticeVo> noticeSearch(Connection conn, String title, PageVo pvo) throws Exception{
		
		//SQL
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT NO, TITLE, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM NOTICE_BOARD WHERE DEL_YN = 'N' AND TITLE LIKE '%' || ?|| '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
 		pstmt.setInt(2, pvo.getStartRow());
 		pstmt.setInt(3, pvo.getLastRow());
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		while(rs.next()) {
			
			NoticeVo vo = new NoticeVo();
			
			vo.setNo(rs.getString("NO"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setEnrollDate(rs.getString("ENROLL_DATE"));
			
			noticeVoList.add(vo);
			
		}
		
		return noticeVoList;
		
		//close
	}

	//게시글 작성
	public int noticeWrite(Connection conn, NoticeVo vo) throws Exception{
		
		//SQL
		String sql = "INSERT INTO NOTICE_BOARD ( NO, MANAGER_NO, TITLE, CONTENT ) VALUES (SEQ_NOTICE_BOARD_NO.NEXTVAL, 1, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	//게시글 삭제
	public int noticeDelete(Connection conn, String no) throws Exception{
		//SQL
		String sql = "UPDATE NOTICE_BOARD SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		int result = pstmt.executeUpdate();
		//rs
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	
	//no로 DB받아오기
	public NoticeVo getNoticeByNo(Connection conn, String no) throws Exception{
		//SQL
		String sql = "SELECT TITLE, CONTENT FROM NOTICE_BOARD WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		NoticeVo vo = null;
		if(rs.next()) {
			vo = new NoticeVo();
			
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
	public int noticeEdit(Connection conn, NoticeVo vo) throws Exception{
		
		//SQL
		String sql = "UPDATE NOTICE_BOARD SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";
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
