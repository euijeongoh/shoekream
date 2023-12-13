package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.AddressService;

@WebServlet("/mypage/addr/change")
public class AddrChangeDefaultController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");

			if (loginMember == null) {
				throw new Exception();
			}
			String no = req.getParameter("no");
			String memberNo = req.getParameter("memberNo");
			
			AddressService as = new AddressService();
			int result = as.changeDefault(no, memberNo);
			
			
			if(result > 0 ) {
				resp.sendRedirect("/shoekream/mypage/addr?no=" + loginMember.getNo());
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
