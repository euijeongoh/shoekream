package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.AddressService;
import com.shoekream.mypage.service.PayInfoService;

@WebServlet("/mypage/payInfo/delete")
public class PayDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new Exception();
			}
			String no = req.getParameter("no");
			System.out.println(no);

			PayInfoService as = new PayInfoService();
			int result = as.payInfoDelete(no);
			
			if(result == 1) {
				resp.sendRedirect("/shoekream/mypage/payInfo?no=" + loginMember.getNo());
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/shoekream/member/login");
		}
	}
	

}
