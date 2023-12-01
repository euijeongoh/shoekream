package com.shoekream.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.member.MemberVo;
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
		try {
			// 데이터
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
		
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			
			// service
			MemberService ms = new MemberService();
			MemberVo loginMember = ms.login(vo);
			
			// result
			if(loginMember == null) {
				throw new Exception("[ERROR-M-01] 일치하는 회원정보 없음");
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("loginMember", loginMember);
			
			resp.sendRedirect("/shoekream/home");
		} catch(Exception e) {
			System.out.println("[ERROR-M] 로그인 작업 도중 예외 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errorMsg", "로그인 실패");
			resp.sendRedirect("/shoekream/member/login");
		}
	}
}
