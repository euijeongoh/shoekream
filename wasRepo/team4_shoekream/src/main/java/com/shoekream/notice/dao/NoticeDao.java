package com.shoekream.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.notice.controller.NoticeVo;
import com.shoekream.page.vo.PageVo;

public class NoticeDao {

	public List<NoticeVo> NoticeList(Connection conn, PageVo pvo) throws Exception{
		
		//sql
		String sql = "SELECT * FROM    ( SELECT ROWNUM RNUM, T.* FROM ( SELECT TITLE, TO_CHAR(ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE FROM NOTICE_BOARD WHERE DEL_YN = 'N' ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
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
		
		return noticeVoList;
		
	}

	public int selectNoticeCount(Connection conn) throws Exception{
		
		String sql = "SELECT COUNT(*) AS COUNT FROM NOTICE_BOARD WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		int count = 0;
		if(rs.next()) {
			count = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return count;
		
	
	}

}
