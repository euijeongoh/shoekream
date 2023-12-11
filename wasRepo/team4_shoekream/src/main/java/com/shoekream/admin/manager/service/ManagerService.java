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

	public String searchId(ManagerVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ManagerDao dao = new ManagerDao();
		String id = dao.searchId(conn, vo);
		
		// close
		JDBCTemplate.close(conn);
		
		return id;
	}

	public boolean sendPwdEmail(ManagerVo vo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		ManagerDao dao = new ManagerDao();
		boolean managerExists = dao.searchManagerByIdEmail(conn, vo);
	
		if(managerExists==false) {
			throw new Exception("일치하는 회원정보 없음");
		}
		
		// email server
		String emailFrom = "shoekream4@gmail.com";
		String username = "shoekream";
		
		// email client
		String emailTo = vo.getEmail();
		
		final String smtpEmail = "shoekream4@gmail.com";
		final String password = "tlqkmvllkldryzck";
		
		// smtp server 정보
		Properties props = new Properties();
		props.put("mail.transport.protocal", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com"); // host 정보 네이버에서 갖고 오기
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.quitwait", "false");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// 인증번호 생성(일단 이메일 가는 거 보고)
		SecureRandom random = SecureRandom.getInstanceStrong();
		byte[] randomBytes = new byte[6];
		random.nextBytes(randomBytes);
		// 바이트 배열을 Base64로 인코딩하여 문자열로 반환
		String authenticationKey = Base64.getEncoder().encodeToString(randomBytes);
		
		// email 내용
		String emailTitle = "[SHOEKREAM] 임시 비밀번호 발급";
		String emailContent = "임시 비밀번호 : " + authenticationKey;
		
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		MimeMessage mail = new MimeMessage(session);
		mail.setContent(emailContent, "text/plain; charset=utf-8");
		InternetAddress from = new InternetAddress(emailFrom, "shoekream@naver.com");
		InternetAddress to = new InternetAddress(emailTo);
		
		// email 정보
		mail.setSubject(emailTitle);
		mail.setFrom(from);
		mail.setRecipient(Message.RecipientType.TO, to);
		mail.setText(emailContent);
		
		// email 전송
		Transport t = session.getTransport("smtp");
		t.connect(smtpEmail, password);
		t.sendMessage(mail, mail.getAllRecipients());
		t.close();
		System.out.println("이메일 전송 완료");
		
		boolean emailSent = true;
		
//		// 임시 비밀번호로 비밀번호 update
//		int result = dao.updatePwd(conn, vo, tempPwd_);
//		
//		// tx
//		if(result == 1) {
//			JDBCTemplate.commit(conn);
//		} else {
//			JDBCTemplate.rollback(conn);
//		}
//		
		// conn close
		JDBCTemplate.close(conn);
		
		
		return emailSent;
	
	}

	public int updatePwd(String authKey, String newPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
