package com.shoekream.notice.service;

import java.sql.Connection;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.controller.NoticeVo;
import com.shoekream.notice.dao.NoticeDao;

public class NoticeService {

	public List<NoticeVo> NoticeList() {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		NoticeDao dao = new NoticeDao();
		List<NoticeVo> voList = dao.NoticeList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	

}
