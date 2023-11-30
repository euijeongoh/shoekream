package com.shoekream.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")

public class HomeController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * DB에서 가져와야 하는 데이터
		 * - 신규 등록 상품, 새로운 즉시 구매가 뜬 상품
		 * 
		 */
				
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
	}
	
}
