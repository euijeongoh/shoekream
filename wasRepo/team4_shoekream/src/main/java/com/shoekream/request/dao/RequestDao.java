package com.shoekream.request.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.request.vo.RequestVo;

public class RequestDao {
	
	//게시글 전체 조회
	public List<RequestVo> RequestList(Connection conn, PageVo pvo) throws Exception{
		
		//sql
		String sql = "SELECT * FROM    ( SELECT ROWNUM RNUM, T.* FROM ( SELECT NO, TITLE, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM PRODUCT_REGISTER_REQUEST_BOARD WHERE DEL_YN = 'N' ORDER BY NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<RequestVo> requestVoList = new ArrayList<RequestVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			RequestVo nv = new RequestVo();
			
			nv.setNo(no);
			nv.setTitle(title);
			nv.setEnrollDate(enrollDate);
			
			requestVoList.add(nv);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return requestVoList;
		
	}

	//게시글 상세조회
	public RequestVo selectRequestByNo(Connection conn, String no) throws Exception{
		
		//SQL
		String sql = "SELECT NO, TITLE, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM PRODUCT_REGISTER_REQUEST_BOARD WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		RequestVo vo = null;
		if(rs.next()) {
			vo = new RequestVo();
			String No = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			vo.setNo(No);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setEnrollDate(enrollDate);
		}
		
		//close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return vo;
	}

	//검색 게시글 갯수
	public int selectSearchReqeustCount(Connection conn, String title) throws Exception{
		
		String sql = "SELECT COUNT(*) FROM PRODUCT_REGISTER_REQUEST_BOARD WHERE DEL_YN = 'N' AND TITLE LIKE '%' || ?|| '%'";
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

	//게시글 검색(제목)
	public List<RequestVo> requestSearch(Connection conn, String title, PageVo pvo) throws Exception{
			
			//SQL
			String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT NO, TITLE, CONTENT, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM PRODUCT_REGISTER_REQUEST_BOARD WHERE DEL_YN = 'N' AND TITLE LIKE '%' || ?|| '%' ORDER BY NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
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
				vo.setEnrollDate(rs.getString("ENROLL_DATE"));
				
				requestVoList.add(vo);
				
			}
			
			return requestVoList;
			
			//close
		}

	//게시글 작성
	public int requestWrite(Connection conn, RequestVo vo) throws Exception {
		
		//SQL
		String sql = "INSERT INTO PRODUCT_REGISTER_REQUEST_BOARD(NO, MEMBER_NO, TITLE, CONTENT ) VALUES(SEQ_PRODUCT_REGISTER_REQUEST_BOARD_NO.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getNo());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getContent());
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
		
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	//조회수 증가
	public int increaseHit(Connection conn, String no) throws Exception {
		
		//sql
		String sql = "UPDATE PRODUCT_REGISTER_REQUEST_BOARD SET HIT = HIT +1 WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();		
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
		
		
		
}
