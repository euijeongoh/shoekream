package com.shoekream.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.AddressService;
import com.shoekream.mypage.vo.AddrBookVo;

@WebServlet("/mypage/addr")
public class AddressController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			
			AddressService as = new AddressService();
			AddrBookVo vo = as.selectAddrList(no);
			System.out.println(vo);
			
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/mypage/addr.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String phoneNum = req.getParameter("phone_num");
		String postCode = req.getParameter("post_code");
		String addr = req.getParameter("addr");
		String detailAddr = req.getParameter("detail_addr");
		String defaultAddr = req.getParameter("default_addr");
	
	}

}
