package com.shoekream.notice.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.dao.NoticeDao;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;

public class NoticeService {
	
	//게시글 전체 목록 조회
	public List<NoticeVo> NoticeList(PageVo pvo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		List<NoticeVo> noticeVoList = dao.NoticeList(conn, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return noticeVoList;
	}

	//게시글 전체 갯수 조회
	public int selectNoticeCount() throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		int listCount = dao.selectNoticeCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	//게시글 검색 갯수 조회
	public int selectSearchNoticeCount(String title) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		int listCount = dao.selectSearchNoticeCount(conn, title);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	//게시글 상세 조회
	public NoticeVo selectNoticeListByNo(String no) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		NoticeVo vo = dao.selectNoticeByNo(conn, no);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//게시글 검색
	public List<NoticeVo> noticeSearch(String title, PageVo pvo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		List<NoticeVo> noticeVoList = dao.noticeSearch(conn, title, pvo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return noticeVoList;
	}
	
	//게시글 작성
	public int noticeWrite(NoticeVo vo) throws Exception{
		
		//conn 
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		int result = dao.noticeWrite(conn, vo);
		
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

	//게시글 수정
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
