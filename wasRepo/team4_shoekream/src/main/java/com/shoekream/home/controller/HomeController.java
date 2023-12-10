package com.shoekream.home.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.home.service.HomeService;

@WebServlet("/home")

public class HomeController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			/*
			 * DB에서 가져와야 하는 데이터
			 * - 신규 등록 상품, 새로운 즉시 구매가 뜬 상품
			 * 
			 */
			// service
			HomeService service = new HomeService();
			Map<String, Object> productMap = service.getProductLists();
			
			// result == view
			req.setAttribute("enrollList", productMap.get("enrollList"));
			req.setAttribute("immediatePriceList", productMap.get("immediatePriceList"));
			System.out.println(productMap.get("immediatePriceList"));
					
			req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
