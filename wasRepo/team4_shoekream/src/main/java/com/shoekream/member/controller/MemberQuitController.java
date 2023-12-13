package com.shoekream.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.member.service.MemberService;

@WebServlet("/member/quit")

public class MemberQuitController extends HttpServlet{
	
	// 탈퇴 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/quit.jsp").forward(req, resp);
		
	}
	
	// 회원 탈퇴 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			System.out.println("doPost 호출됨");
			// 데이터
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember==null) {
				resp.sendRedirect("/shoekream/home");
			}
			// service
			MemberService ms = new MemberService();
			int result = ms.quit(loginMember);
			System.out.println("=========");
			System.out.println(result);
			// result == view
			if(result == -2) {
				throw new Exception("탈퇴할 수 없는 회원");
			}
			
			if(result == -1) {
				throw new Exception("탈퇴 실패");
			}
			
			// 로그아웃
			req.getSession().invalidate();
			// 홈페이지로 redirect
			resp.sendRedirect("/shoekream/home");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.getSession().setAttribute("quitFail", "탈퇴할 수 없는 회원입니다.");
			resp.sendRedirect("/shoekream/member/quit");
		}
		
	}
}
