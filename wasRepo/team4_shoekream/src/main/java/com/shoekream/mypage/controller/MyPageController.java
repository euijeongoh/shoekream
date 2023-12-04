package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.member.service.MemberService;

@WebServlet("/mypage/main")

public class MyPageController extends HttpServlet{
	
	// 마이페이지 메인 화면 띄우기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// data
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		
		if(loginMember == null) {
			resp.sendRedirect("/shoekream/member/login");
		}
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/my.jsp").forward(req, resp);
		
	}
	
}
