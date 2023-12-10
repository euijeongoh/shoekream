package com.shoekream.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.member.service.MemberService;

@WebServlet("/member/join")

public class MemberJoinController extends HttpServlet{
	
	// 회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
		
	}
	
	// 회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String memberName = req.getParameter("memberName");
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			String email = req.getParameter("email");
			
			MemberVo vo = new MemberVo(memberName, memberId, memberPwd, memberPwd2, memberNick, email);
			
			// service
			MemberService service = new MemberService();
			int result = service.join(vo);
			
			// result == view
			if(result != 1) {
				throw new Exception("회원가입 작업 실패");
			}
			
			req.getSession().setAttribute("joinSuccess", "회원가입이 완료되었습니다.");
			resp.sendRedirect("/shoekream/member/login");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			resp.sendRedirect("/shoekream/home");
		}
		
	}
	
}
