package com.shoekream.bidding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.bidding.service.BiddingService;
import com.shoekream.biddingVo.BiddingVo;

@WebServlet("/buy/nowpayment")
public class BuyNowPaymentControlloer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String productsNo = req.getParameter("productsNo");
				System.out.println("에러확인 productsNo : " + productsNo);
			BiddingService bs = new BiddingService();
			List<BiddingVo> voList = bs.productList(productsNo);
			
			if (voList == null) {
				throw new Exception("예외발생 : voList == null");
			}
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/buy/nowpayment.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("에러발생 : buySelect 중 예외발생");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
}
