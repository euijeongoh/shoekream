package com.shoekream.admin.manager.service;

import java.security.SecureRandom;
import java.sql.Connection;
import java.util.Base64;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.shoekream.admin.manager.dao.ManagerDao;
import com.shoekream.admin.manager.vo.ManagerVo;
import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.member.dao.MemberDao;
import com.shoekream.member.util.GenerateTempPwd;

public class ManagerService {

	public ManagerVo adminLogin(ManagerVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ManagerDao dao = new ManagerDao();
		ManagerVo loginAdmin = dao.adminLogin(conn, vo);
		
		// close
		JDBCTemplate.close(conn);
		
		return loginAdmin;
	}

}
