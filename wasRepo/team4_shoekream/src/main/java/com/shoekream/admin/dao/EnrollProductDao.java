package com.shoekream.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoekream.admin.vo.EnrollProductVo;

public class EnrollProductDao {

	public EnrollProductVo categoryCheck(Connection conn, String category) throws Exception{
		String sql = "";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			
		}
		return null;
	}

}
