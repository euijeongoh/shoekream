package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;

@WebServlet("/mypage/selling")

public class SellingController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// data
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		
		if(loginMember==null) {
			
		}
		
		
		
	}
	
}
