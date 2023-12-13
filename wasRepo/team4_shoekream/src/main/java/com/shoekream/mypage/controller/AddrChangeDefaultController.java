package com.shoekream.mypage.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.dao.AddressDao;
import com.shoekream.mypage.service.AddressService;

@WebServlet("/mypage/addr/change")
public class AddrChangeDefaultController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String no = req.getParameter("no");
			
			AddressService as = new AddressService();
			Map<String, Object> map = as.changeDefault(no);
			
			int result = (int) map.get("result");
			int result2 = (int) map.get("result");
			
			if(result == 1 && result2 == 1) {
				req.getRequestDispatcher("/WEB-INF/views/mypage/addr.jsp").forward(req, resp);
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
