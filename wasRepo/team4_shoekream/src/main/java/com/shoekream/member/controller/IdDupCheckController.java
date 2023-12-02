package com.shoekream.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.service.MemberService;

@WebServlet("/member/check/id")

public class IdDupCheckController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		try {
			// 데이터
			String memberId = req.getParameter("memberId");
			System.out.println(memberId);
			// service
			MemberService ms = new MemberService();
			boolean isDup = ms.checkIdDup(memberId);
			System.out.println(isDup);
			// result
			if(isDup == true) {
				throw new Exception("[ERROR-M-3] 아이디 중복");
			}
			
			out.write("{\"msg\" : \"ok\"}");			
		} catch(Exception e) {
			out.write("{\"msg\" : \"no\"}");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
