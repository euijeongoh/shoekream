package com.shoekream.request.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.dao.NoticeDao;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.qna.dao.QnaDao;
import com.shoekream.qna.vo.QnaVo;

public class RequestService {

public List<QnaVo> QnaList(PageVo pvo) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		List<QnaVo> qnaVoList = dao.QnaList(conn, pvo);
		
		//close
		JDBCTemplate.close(conn);
		
		return qnaVoList;
	}

	public int selectQnaCount() throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		int listCount = dao.selectQnaCount(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	public int selectSearchQnaCount(String title) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		int listCount = dao.selectSearchQnaCount(conn, title);
		
		//close
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	public QnaVo selectQnaListByNo(String no) throws Exception{
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		QnaVo vo = dao.selectQnaByNo(conn, no);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public List<QnaVo> qnaSearch(String title, PageVo pvo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		List<QnaVo> qnaVoList = dao.qnaSearch(conn, title, pvo);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
		
		return qnaVoList;
	}
	
	//게시글 작성
	public int qnaWrite(QnaVo vo) throws Exception{
		
		//conn 
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		int result = dao.qnaWrite(conn, vo);
		
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

	public int replyWrite(QnaVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		QnaDao dao = new QnaDao();
		int result = dao.replyWrite(conn, vo);
		
		//tx
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
}
