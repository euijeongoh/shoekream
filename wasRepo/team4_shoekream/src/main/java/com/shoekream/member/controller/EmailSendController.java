package com.shoekream.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
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

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/send/email")

public class EmailSendController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		try {
			// data
			String inputEmail = req.getParameter("email");
			System.out.println(inputEmail);
			// email server
			String emailFrom = "shoekream4@gmail.com";
			String username = "shoekream";
//			String userPwd = "shoe!kream0821";
			// email client
			String emailTo = inputEmail;
			
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
			
//			props.put("mail.smtps.ssl.protocals", "TLSv1.2");
//			props.put("mail.smtp.ssl.enable", "true");
//			props.put("mail.smtp.ssl.trust", "smtp.naver.com");
//			props.put("mail.user", username);
//			props.put("mail.password", userPwd);
//			props.put("mail.smtp.starttls.required", "true");
			
			// 인증번호 생성(일단 이메일 가는 거 보고)
			SecureRandom random = SecureRandom.getInstanceStrong();
			
			byte[] randomBytes = new byte[6];
			// 바이트 배열을 Base64로 인코딩하여 문자열로 반환
			String authenticationKey = Base64.getEncoder().encodeToString(randomBytes);
			System.out.println(authenticationKey);
			
			// email 내용
			String emailTitle = "[SHOEKREAM] 회원가입 이메일 인증";
			String emailContent = "회원가입 이메일 인증번호 : " + authenticationKey;
			
			// session 생성
//			Session session = Session.getInstance(props, new Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(username,
//                            userPwd);
//                }
//            });
			
			Session session = Session.getInstance(props);
			session.setDebug(true);
			
			System.out.println("g");
			
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
			
			// 인증번호 json형태의 문자열로 담아서 응답하기
			
			req.getSession().setAttribute("AuthenticationKey", authenticationKey);
			Map<String, String> map = new HashMap<String, String>();
			map.put("authKey", authenticationKey);
			map.put("mail", "ok");
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonData = mapper.writeValueAsString(map);
			
			out.write(jsonData);
			
		} catch(Exception e) {
			out.write("{\"mail\" : \"no\"}");
			e.printStackTrace();
		}
		
		
	}
	
}
