package com.shoekream.bidding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.biddingVo.BiddingVo;

@WebServlet("/buy/bidding")
public class BuyBiddingControlloer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BiddingVo buyPrVo = new BiddingVo();
		String buyPrice = req.getParameter("buyPrice");
		String buySize = req.getParameter("buySize");
		buyPrVo.setPrice(buyPrice);
		buyPrVo.setShoesSizes(buySize);
		
		BiddingVo sellPrVo = new BiddingVo();
		String sellPrice = req.getParameter("sellPrice");
		String sellSize = req.getParameter("sellSize");
		sellPrVo.setPrice(sellPrice);
		sellPrVo.setShoesSizes(sellSize);
		
		
		String productsNo = req.getParameter("productsNo");
		req.setAttribute("productsNo", productsNo);
		req.setAttribute("buyPrVo", buyPrVo);
		req.setAttribute("sellPrVo", sellPrVo);
		req.getRequestDispatcher("/WEB-INF/views/buy/bidding.jsp").forward(req, resp);
		
	}
	
}
