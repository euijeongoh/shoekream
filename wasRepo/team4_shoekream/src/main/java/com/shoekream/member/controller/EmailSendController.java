package com.shoekream.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
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
			// email server
			String emailFrom = "shoekream@naver.com";
			String username = "shoekream";
			String userPwd = "shoe!kream4";
			// email client
			String emailTo = inputEmail;
			
			// smtp server 정보
			Properties props = new Properties(); 
			props.put("mail.smtp.host", "smtp.naver.com"); // host 정보 네이버에서 갖고 오기
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", "smtp.naver.com");
			props.put("mail.user", username);
			props.put("mail.password", userPwd);
			
			// 인증번호 생성
//			SecureRandom random = SecureRandom.getInstance();
			
			String AuthenticationKey = "12345";
			
			// email 내용
			String emailTitle = "[SHOEKREAM] 회원가입 이메일 인증";
			String emailContent = "회원가입 이메일 인증번호 : " + AuthenticationKey;
			
			// session 생성
			
			Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username,
                            userPwd);
                }
            });
			
			session.setDebug(true);
			
			System.out.println("g");
			// 이메일 전송0
			MimeMessage mail = new MimeMessage(session);
			mail.setContent(emailContent, "text/plain; charset=utf-8");
			InternetAddress from = new InternetAddress(emailFrom, "shoekream@naver.com");
			InternetAddress to = new InternetAddress(emailTo);
			
			// email 정보
			mail.setSubject(emailTitle);
			mail.setFrom(from);
			mail.setRecipient(Message.RecipientType.TO, to);
			mail.setText(emailContent);
			Transport.send(mail);
			System.out.println("이메일 전송 완료");
			
			// 인증번호 session에 저장
			HttpSession saveAuthKey = req.getSession();
			saveAuthKey.setAttribute("AuthenticationKey", AuthenticationKey);
			
			// 응답
			out.write("{\"reply\" : \"ok\"}");
		} catch(Exception e) {
			out.write("{\"reply\" : \"no\"}");
			e.printStackTrace();
		}
		
		
	}
	
}
