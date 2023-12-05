package com.shoekream.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/send/email")

public class EmailSendController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		try {
			// data
			String inputEmail = req.getParameter("email");
			
			// email server 설정
			String emailTitle = "[SHOEKREAM] 회원가입 이메일 인증";
			String emailFrom = "shoekream@naver.com";
			String fromName = "관리자";
			// email client 설정
			String emailTo = inputEmail;
			
			// smtp server 정보
			Properties props = new Properties(); 
			props.put("mail.smtp.host", "smtp.naver.com"); // host 정보 네이버에서 갖고 오기
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enabel", "true");
			
			// 인증번호 생성
			SecureRandom random = SecureRandom.getInstance("NativePRNG");
			
			String AuthenticationKey = random.toString();
			System.out.println(AuthenticationKey);
			
			
			// session 생성
			Session session = Session.getDefaultInstance(props, null);
			// 이메일 전송
			MimeMessage msg = new MimeMessage(session);
			InternetAddress from = new InternetAddress(emailFrom, "SHOEKREAM");
			InternetAddress to = new InternetAddress(emailTo);
			
			msg.setFrom(from);
			msg.addRecipient(Message.RecipientType.TO, to);
			// email 정보
			msg.setSubject(emailTitle);
			msg.setText("회원가입 이메일 인증번호 : " + AuthenticationKey);
			
			Transport.send(msg);
			System.out.println("이메일 전송 완료");
			
			// 인증번호 session에 저장
			HttpSession saveAuthKey = req.getSession();
			saveAuthKey.setAttribute("AuthenticationKey", AuthenticationKey);
			
			// 응답
			out.write("{\"reply\" : \"ok\"}");
		} catch(Exception e) {
			out.write("{\"replay\" : \"no\"}");
			e.printStackTrace();
		}
		
		
	}
	
}
