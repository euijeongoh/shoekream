package com.shoekream.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.member.service.MemberService;

@WebServlet("/member/searchPwd")

public class MemberSearchPwdController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/searchPwd.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			String memberId = req.getParameter("memberId");
			String email = req.getParameter("email");
			
			MemberVo vo = new MemberVo();
			vo.setId(memberId);
			vo.setEmail(email);
			
			// service
			MemberService service = new MemberService();
			int result = service.sendPwdEmail(vo);
			
			req.setAttribute("sendEmailSuccess", "해당 이메일로 임시 비밀번호가 발급되었습니다.");
			
			// result == view
			if(result != 1) {
				throw new Exception("비밀번호 업데이트 실패");
			}
			
			req.getRequestDispatcher("/WEB-INF/views/member/searchPwd_result.jsp").forward(req, resp);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
