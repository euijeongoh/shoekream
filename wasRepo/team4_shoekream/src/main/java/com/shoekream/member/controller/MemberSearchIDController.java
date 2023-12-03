package com.shoekream.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.member.service.MemberService;

@WebServlet("/member/searchID")

public class MemberSearchIDController extends HttpServlet {
	
	// 아이디 찾기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/searchID.jsp").forward(req, resp);
		
	}
	
	// 아이디 찾기 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String email = req.getParameter("email");
			
			// service
			MemberService ms = new MemberService();
			MemberVo vo = ms.searchId(email);
			
			// result(== view)
			
			if(vo==null) {
				throw new Exception("일치하는 회원정보 없음");
			}
			
			String id = vo.getId();
			String searchResult = id.replaceAll(id.substring(2, 4), "**");
			System.out.println(searchResult);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			resp.sendRedirect("/shoekream/member/login");
		}
	}
	
}
