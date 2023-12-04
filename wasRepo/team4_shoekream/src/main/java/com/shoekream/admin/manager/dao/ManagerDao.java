package com.shoekream.admin.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shoekream.admin.manager.vo.ManagerVo;
import com.shoekream.db.util.JDBCTemplate;

public class ManagerDao {

	public ManagerVo adminLogin(Connection conn, ManagerVo vo) throws Exception {
		// SQL
		String sql = "SELECT * FROM MANAGER WHERE ID=? AND PWD=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		
		// rs
		ManagerVo loginAdmin = null;
		if(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String delYn = rs.getString("DEL_YN");
			
			loginAdmin = new ManagerVo();
			loginAdmin.setNo(no);
			loginAdmin.setName(name);
			loginAdmin.setId(id);
			loginAdmin.setPwd(pwd);
			loginAdmin.setDelYn(delYn);
		}
		
		// close
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginAdmin;
	}

}
