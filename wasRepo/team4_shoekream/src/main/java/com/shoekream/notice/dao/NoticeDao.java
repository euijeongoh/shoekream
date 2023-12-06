package com.shoekream.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		List<NoticeVo> noticeVoList = new ArrayList<NoticeVo>();
		while(rs.next()) {
			String title = rs.getString("TITLE");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			NoticeVo nv = new NoticeVo();
			
			nv.setTitle(title);
			nv.setEnrollDate(enrollDate);
			
			noticeVoList.add(nv);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		System.out.println("테스트 : " + noticeVoList);
		return noticeVoList;
		
	}

}
