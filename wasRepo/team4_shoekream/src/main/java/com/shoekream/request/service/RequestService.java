package com.shoekream.request.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.dao.NoticeDao;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.request.dao.RequestDao;
import com.shoekream.request.vo.RequestVo;

public class RequestService {

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

	public RequestVo selectRequestListByNo(String no) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		RequestDao dao = new RequestDao();
		RequestVo vo = dao.selectRequestByNo(conn, no);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

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

	public int noticeDelete(String no) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		int result = dao.noticeDelete(conn, no);
		
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
	public NoticeVo getNoticeByNo(String no) throws Exception{
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		NoticeVo vo = dao.getNoticeByNo(conn, no);
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int noticeEdit(NoticeVo vo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		int result = dao.noticeEdit(conn, vo);
		
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
