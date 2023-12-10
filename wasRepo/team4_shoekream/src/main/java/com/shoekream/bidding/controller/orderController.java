package com.shoekream.bidding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.RequestGroupInfo;

@WebServlet("/buy/order")
public class orderController extends HttpServlet{
	
	public static String getHiddenData(String data, int index) {
		String hiddenData = data.substring(0, index); {
			for(int i = 0; i < data.length() - index; i++) {
				hiddenData += "*";
			}
		}
		return hiddenData;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/buy/order.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "곽태윤";
		String dataName = getHiddenData(name, 1);
		req.setAttribute("trade","구매");
		req.setAttribute("process", " 진행 중");
		
		req.setAttribute("price", req.getParameter("price"));
		req.setAttribute("commission", req.getParameter("commission"));
		req.setAttribute("deliveryCharge", req.getParameter("deliveryCharge"));
		req.setAttribute("totalAmount", req.getParameter("totalAmount"));
		req.getRequestDispatcher("/WEB-INF/views/buy/order.jsp").forward(req, resp);
		
	}	
	
}
