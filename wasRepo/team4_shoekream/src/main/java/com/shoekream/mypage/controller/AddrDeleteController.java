package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.mypage.service.AddressService;

@WebServlet("/mypage/addr/delete")
public class AddrDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String no = req.getParameter("no");
			System.out.println(no);

			AddressService as = new AddressService();
			int result = as.addrDelete(no);
			
			if(result == 1) {
				resp.sendRedirect("/shoekream/mypage/addr?no=1");
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
