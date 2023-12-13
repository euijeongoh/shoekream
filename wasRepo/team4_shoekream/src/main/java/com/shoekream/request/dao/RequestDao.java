package com.shoekream.request.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.qna.vo.QnaVo;

public class RequestDao {

	//게시글 전체 조회
		public List<QnaVo> QnaList(Connection conn, PageVo pvo) throws Exception{
			
			//sql
			String sql = "SELECT * FROM    ( SELECT ROWNUM RNUM, T.* FROM ( SELECT Q.NO, M.NICKNAME, Q.TITLE, TO_CHAR(Q.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, REPLY_TITLE FROM QNA_BOARD Q JOIN MEMBER M ON Q.MEMBER_NO = M.NO ORDER BY Q.NO DESC) T ) WHERE RNUM BETWEEN ? AND ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pvo.getStartRow());
			pstmt.setInt(2, pvo.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			List<QnaVo> qnaVoList = new ArrayList<QnaVo>();
			while(rs.next()) {
				String no = rs.getString("NO");
				String nickname = rs.getString("NICKNAME");
				String title = rs.getString("TITLE");
				String enrollDate = rs.getString("ENROLL_DATE");
				String replyTitle = rs.getString("REPLY_TITLE");
				
				QnaVo vo = new QnaVo();
				
				vo.setNo(no);
				vo.setMemberNick(nickname);
				vo.setTitle(title);
				vo.setEnrollDate(enrollDate);
				vo.setReplyTitle(replyTitle);
				
				qnaVoList.add(vo);
			}
			
			//close
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
			return qnaVoList;
			
		}

		//전체 게시글 갯수
		public int selectQnaCount(Connection conn) throws Exception{
			
			String sql = "SELECT COUNT(*) AS COUNT FROM QNA_BOARD";
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
			public int selectSearchQnaCount(Connection conn, String title) throws Exception{
				
				String sql = "SELECT COUNT(*) FROM QNA_BOARD WHERE TITLE LIKE '%' || ?|| '%'";
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
		public QnaVo selectQnaByNo(Connection conn, String no) throws Exception{
			
			//SQL
			String sql = "SELECT Q.NO, M.NICKNAME, Q.TITLE, Q.CONTENT, TO_CHAR(Q.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, Q.REPLY_TITLE, Q.REPLY_CONTENT, TO_CHAR(Q.REPLY_ENROLL_DATE, 'YYYY.MM.DD') AS REPLY_ENROLL_DATE FROM QNA_BOARD Q JOIN MEMBER M ON Q.MEMBER_NO = M.NO WHERE Q.NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			QnaVo vo = null;
			if(rs.next()) {
				vo = new QnaVo();
				String qnaNo = rs.getString("NO");
				String nickname = rs.getString("NICKNAME");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String replyTitle = rs.getString("REPLY_TITLE");
				String replyContent = rs.getString("REPLY_CONTENT");
				String replyEnrollDate = rs.getString("REPLY_ENROLL_DATE");
				
				
				vo.setNo(qnaNo);
				vo.setMemberNick(nickname);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setEnrollDate(enrollDate);
				vo.setReplyTitle(replyTitle);
				vo.setReplyContent(replyContent);
				vo.setReplyEnrollDate(replyEnrollDate);
				
			}
			
			//close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
			return vo;
		}

		//게시글 검색(제목)
		public List<QnaVo> qnaSearch(Connection conn, String title, PageVo pvo) throws Exception{
			
			//SQL
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT Q.NO, Q.TITLE, Q.CONTENT, M.NICKNAME, TO_CHAR(Q.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM QNA_BOARD Q JOIN MEMBER M ON Q.MEMBER_NO = M.NO WHERE Q.TITLE LIKE '%' || ? || '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
	 		pstmt.setInt(2, pvo.getStartRow());
	 		pstmt.setInt(3, pvo.getLastRow());
			
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			List<QnaVo> qnaVoList = new ArrayList<QnaVo>();
			while(rs.next()) {
				
				QnaVo vo = new QnaVo();
				
				vo.setNo(rs.getString("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setMemberNick(rs.getString("NICKNAME"));
				vo.setEnrollDate(rs.getString("ENROLL_DATE"));
				
				qnaVoList.add(vo);
				
			}
			
			return qnaVoList;
			
			//close
		}

		//게시글 작성
		public int qnaWrite(Connection conn, QnaVo vo) throws Exception{
			
			//SQL
			String sql = "INSERT INTO QNA_BOARD ( NO, MEMBER_NO, MANAGER_NO, TITLE, CONTENT) VALUES  (SEQ_QNA_BOARD_NO.NEXTVAL, 1, 2, ?, ?)";
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

		public int replyWrite(Connection conn, QnaVo vo) throws Exception{
			//SQL
			String sql = "UPDATE QNA_BOARD SET REPLY_TITLE = ? , REPLY_CONTENT = ? , REPLY_ENROLL_DATE = SYSDATE WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getReplyTitle());
			pstmt.setString(2, vo.getReplyContent());
			pstmt.setString(3, vo.getNo());
			
			int result = pstmt.executeUpdate();
			
			//rs
			
			//close
			JDBCTemplate.close(conn);
			
			return result;
		}
}
