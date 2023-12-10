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

@WebServlet("/buy/check")
public class BuyCheckController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			System.out.println("확인용 알람 buycheck dopost");
			
			String productsNo = req.getParameter("productsNo");
			String price = req.getParameter("price");
			String size = req.getParameter("size");
			
			BiddingVo vo = new BiddingVo();
			vo.setProductsNo(productsNo);
			vo.setPrice(price);
			vo.setShoesSizes(size);
			
			BiddingService bs = new BiddingService();
			BiddingVo dbVo = bs.productInfo(vo);
			
			System.out.println("BuyCheckController 에러확인 dbVo : " + dbVo);
			if (dbVo == null) {
				throw new Exception("예외 발생 : dbVo == null");
			}
			
			req.getSession().setAttribute("BuyProductInfo", dbVo);
			req.setAttribute("dbVo", dbVo);
			req.getRequestDispatcher("/WEB-INF/views/buy/check.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("buyCheck 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
}
