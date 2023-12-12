package com.shoekream.request.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.dao.NoticeDao;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.request.dao.RequestDao;
import com.shoekream.request.vo.RequestVo;

public class RequestService {

	//게시글 전체 목록 조회
	public List<RequestVo> RequestList(PageVo pvo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		List<RequestVo> requestVoList = dao.RequestList(conn, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return requestVoList;
	}

	//게시글 전체갯수조회
	public int selectRequestCount() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		int listCount = dao.selectNoticeCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	//게시글 상세조회 (+조회수 추가)
	public RequestVo selectRequestListByNo(String no) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		int result = dao.increaseHit(conn, no);
		RequestVo vo = dao.selectRequestByNo(conn, no);
//		RequestVo vo = null;
		if(result == 1) {
			vo = dao.selectRequestByNo(conn, no);
		}
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//게시글 검색 갯수 조회
	public int selectSearchRequestCount(String title) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		int listCount = dao.selectSearchReqeustCount(conn, title);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	//게시글 검색
	public List<RequestVo> requestSearch(String title, PageVo pvo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		List<RequestVo> requestVoList = dao.requestSearch(conn, title, pvo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return requestVoList;
	}

	//게시글 작성
	public int requestWrite(RequestVo vo) throws Exception{
		
		//conn 
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		int result = dao.requestWrite(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}

	//게시글 삭제
	public int requestDelete(String no, String memberNo) throws Exception {
		
			//conn
			Connection conn = JDBCTemplate.getConnection();
			
			//dao
			RequestDao dao = new RequestDao();
			int result = dao.requestDelete(conn, no);
			
			//tx
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			//close
			JDBCTemplate.close(conn);
			
			return result;
		}

	//게시글 수정
	public int requestEdit(RequestVo vo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		int result = dao.requestEdit(conn, vo);
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}


	
	
	
	
}
