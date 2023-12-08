package com.shoekream.notice.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.dao.NoticeDao;
import com.shoekream.notice.vo.NoticeVo;
import com.shoekream.page.vo.PageVo;

public class NoticeService {

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

	public List<NoticeVo> noticeSearch(String title) {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		List<NoticeVo> noticeVoList = dao.noticeSearch(conn, title);
		
		//tx
		
		//close
		JDBCTemplate.close(conn);
	}

}
