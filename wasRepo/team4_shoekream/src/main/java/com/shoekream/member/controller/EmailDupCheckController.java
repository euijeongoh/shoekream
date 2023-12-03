package com.shoekream.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.service.MemberService;

@WebServlet("/member/check/email")

public class EmailDupCheckController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			// data
			String email = req.getParameter("email");
			
			// service
			MemberService ms = new MemberService();
			boolean isDup = ms.checkEmailDup(email);
			
			// result
			System.out.println(isDup);
			if(isDup == true) {
				throw new Exception("이미 가입된 아이디");
			}
			
			out.write("{\"msg\" : \"ok\"}");
		} catch(Exception e) {
			out.write("{\"msg\" : \"no\"}");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
}
