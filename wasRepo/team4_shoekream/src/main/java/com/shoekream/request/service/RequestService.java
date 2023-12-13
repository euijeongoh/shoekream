package com.shoekream.request.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.faq.vo.FaqVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.request.dao.RequestDao;
import com.shoekream.request.vo.RequestVo;

public class RequestService {

	//전체 게시글 조회
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

	//전체 게시글 갯수
	public int selectRequestCount() throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		int listCount = dao.selectRequestCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	//검색 게시글 갯수
	public int selectSearchRequestCount(String title) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		int listCount = dao.selectSearchRequestCount(conn, title);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	//상세조회 + 조회수 증가
	public RequestVo selectRequestListByNo(String no) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		int result = dao.increaseHit(conn, no);
		RequestVo vo = null;
		if(result==1) {
			vo = dao.selectRequestByNo(conn, no);
		}
		
		//tx
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
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
	public int requestDelete(String no) throws Exception{
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

	//no로 DB받아오기
	public RequestVo getRequestByNo(String no) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		RequestVo vo = dao.getRequestByNo(conn, no);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//게시글 편집
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
