package com.shoekream.bidding.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.bidding.service.BiddingService;
import com.shoekream.biddingVo.BiddingVo;

@WebServlet("/buy/now")
public class BuyNowControlloer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String productsNo = req.getParameter("productsNo");
			String price = req.getParameter("price");
			String size = req.getParameter("size");
			
			BiddingVo vo = new BiddingVo();
			vo.setProductsNo(productsNo);
			vo.setPrice(price);
			vo.setShoesSizes(size);
			
			BiddingService bs = new BiddingService();
			Map<String, Object> m = bs.productList(vo);
			if (m == null) {
				throw new Exception("예외발생 : voList == null");
			}
			BiddingVo buyPrVo = (BiddingVo)m.get("buyPrVo");
			BiddingVo sellPrVo = (BiddingVo)m.get("sellPrVo");
			
			
			req.setAttribute("productsNo", productsNo);
			req.setAttribute("buyPrVo", buyPrVo);
			req.setAttribute("sellPrVo", sellPrVo);
			req.getRequestDispatcher("/WEB-INF/views/buy/now.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("에러발생 : buyNow 중 예외발생");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
	
}
