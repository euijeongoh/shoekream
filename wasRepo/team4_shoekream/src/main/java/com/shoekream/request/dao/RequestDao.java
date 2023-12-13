package com.shoekream.request.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.page.vo.PageVo;
import com.shoekream.request.vo.RequestVo;

public class RequestDao {

	//게시글 전체 조회
		public List<RequestVo> RequestList(Connection conn, PageVo pvo) throws Exception{
			
			//sql
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT P.NO, M.NICKNAME, P.TITLE, TO_CHAR(P.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, HIT FROM PRODUCT_REGISTER_REQUEST_BOARD P JOIN MEMBER M ON P.MEMBER_NO = M.NO ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pvo.getStartRow());
			pstmt.setInt(2, pvo.getLastRow());
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			List<RequestVo> requestVoList = new ArrayList<RequestVo>();
			while(rs.next()) {
				String no = rs.getString("NO");
				String nickname = rs.getString("NICKNAME");
				String title = rs.getString("TITLE");
				String enrollDate = rs.getString("ENROLL_DATE");
				String hit = rs.getString("HIT");
				
				RequestVo vo = new RequestVo();
				
				vo.setNo(no);
				vo.setMemberNick(nickname);
				vo.setTitle(title);
				vo.setEnrollDate(enrollDate);
				vo.setHit(hit);
				
				requestVoList.add(vo);
			}
			
			//close
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
			return requestVoList;
			
		}

		//전체 게시글 갯수
		public int selectRequestCount(Connection conn) throws Exception{
			
			String sql = "SELECT COUNT(*) AS COUNT FROM PRODUCT_REGISTER_REQUEST_BOARD";
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
			public int selectSearchRequestCount(Connection conn, String title) throws Exception{
				
				String sql = "SELECT COUNT(*) FROM PRODUCT_REGISTER_REQUEST_BOARD WHERE TITLE LIKE '%' || ?|| '%'";
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
		public RequestVo selectRequestByNo(Connection conn, String no) throws Exception{
			
			//SQL
			String sql = "SELECT P.NO, M.NICKNAME, P.TITLE, P.CONTENT, TO_CHAR(P.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, P.HIT FROM PRODUCT_REGISTER_REQUEST_BOARD P JOIN MEMBER M ON P.MEMBER_NO = M.NO WHERE P.NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			RequestVo vo = null;
			if(rs.next()) {
				vo = new RequestVo();
				String requestNo = rs.getString("NO");
				String nickname = rs.getString("NICKNAME");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String hit = rs.getString("HIT");

				vo.setNo(requestNo);
				vo.setMemberNick(nickname);
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
			
			String sql = "UPDATE PRODUCT_REGISTER_REQUEST_BOARD SET HIT = HIT + 1 WHERE NO = ? AND DEL_YN='N' ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			int result = pstmt.executeUpdate();
			
			JDBCTemplate.close(pstmt);
			
			return result;
		}

		//게시글 검색(제목)
		public List<RequestVo> requestSearch(Connection conn, String title, PageVo pvo) throws Exception{
			
			//SQL
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM (   SELECT P.NO, P.TITLE, P.CONTENT, M.NICKNAME, TO_CHAR(P.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, HIT FROM PRODUCT_REGISTER_REQUEST_BOARD P JOIN MEMBER M ON P.MEMBER_NO = M.NO WHERE P.TITLE LIKE '%' || ? || '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
	 		pstmt.setInt(2, pvo.getStartRow());
	 		pstmt.setInt(3, pvo.getLastRow());
			
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			List<RequestVo> requestVoList = new ArrayList<RequestVo>();
			while(rs.next()) {
				
				RequestVo vo = new RequestVo();
				
				vo.setNo(rs.getString("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setMemberNick(rs.getString("NICKNAME"));
				vo.setEnrollDate(rs.getString("ENROLL_DATE"));
				vo.setHit(rs.getString("HIT"));
				
				requestVoList.add(vo);
				
			}
			
			return requestVoList;
			
			//close
		}

		//게시글 작성
		public int requestWrite(Connection conn, RequestVo vo) throws Exception{
			
			//SQL
			String sql = "INSERT INTO Request_BOARD ( NO, MEMBER_NO, MANAGER_NO, TITLE, CONTENT) VALUES  (SEQ_Request_BOARD_NO.NEXTVAL, 1, 2, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			int result = pstmt.executeUpdate();
			
			//close
			JDBCTemplate.close(pstmt);
			
			return result;
			
		}

		//게시글 삭제
		public int requestDelete(Connection conn, String no) throws Exception{
			//SQL
			String sql = "UPDATE PRODUCT_REGISTER_REQUEST_BOARD SET DEL_YN = 'Y' WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			int result = pstmt.executeUpdate();
			//rs
			
			//close
			JDBCTemplate.close(pstmt);
			
			return result;
			
		}
		
		//no로 DB받아오기
		public RequestVo getRequestByNo(Connection conn, String no) throws Exception{
			//SQL
			String sql = "SELECT TITLE, CONTENT FROM PRODUCT_REGISTER_REQUEST_BOARD WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			//rs
			RequestVo vo = null;
			if(rs.next()) {
				vo = new RequestVo();
				
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
		public int requestEdit(Connection conn, RequestVo vo) throws Exception{
			
			//SQL
			String sql = "UPDATE PRODUCT_REGISTER_REQUEST_BOARD SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?";
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
