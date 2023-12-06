package com.shoekream.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.controller.NoticeVo;

public class NoticeDao {

	public List<NoticeVo> NoticeList(Connection conn) throws Exception{
		
		//sql
		String sql = "SELECT TITLE, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM NOTICE_BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//rs
		List<NoticeVo> voList = null;
		while(rs.next()) {
			
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
	}

}
