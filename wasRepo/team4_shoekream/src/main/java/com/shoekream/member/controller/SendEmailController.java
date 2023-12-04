package com.shoekream.member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authenticate/email")

public class SendEmailController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// data
		String inputEmail = req.getParameter("email");
		
		// mail server 설정
		String host = "smtp.naver.com";
		String user = "shoekream@naver.com";
		String password = "shoe!kream4"; // 내 네이버 패스워드
		
		// 메일 받을 주소
		String emailTo = inputEmail;
		
		
		
	}
	
	
}
