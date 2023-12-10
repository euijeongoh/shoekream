package com.shoekream.bidding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.bidding.service.BiddingService;
import com.shoekream.biddingVo.BiddingVo;

@WebServlet("/buy/select")
public class BuySelectController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String productsNo = req.getParameter("productsNo");
				// 받아와야 함
				productsNo = "46";
			BiddingService bs = new BiddingService();
			List<BiddingVo> voList = bs.buySelect(productsNo);
			
			if (voList == null) {
				throw new Exception("예외 발생 : voList == null");
			}
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/buy/select.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("buySelect 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
