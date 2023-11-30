package com.shoekream.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.service.MemberService;

@WebServlet("/member/login")

public class MemberLoginController extends HttpServlet{
	
	// 로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		
	}
	
	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memebrPwd");
	
		// service
		MemberService ms = new MemberService();
	}
}
