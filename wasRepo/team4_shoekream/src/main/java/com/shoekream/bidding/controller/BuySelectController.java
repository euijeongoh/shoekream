package com.shoekream.bidding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.bidding.service.BuySelectService;
import com.shoekream.biddingVo.BiddingVo;

@WebServlet("/buy/select")
public class BuySelectController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String productsNo = req.getParameter("productsNo");
				// 받아와야 함
				productsNo = "46";
			BuySelectService bs = new BuySelectService();
			List<BiddingVo> voList = bs.buySelect(productsNo);
			
			if (voList == null) {
				throw new Exception("예외발생 : voList == null");
			}
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/buy/select.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("에러발생 : 예외");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String productsNo = req.getParameter("productsNo");
			System.out.println("에러확인 productsNo : " + productsNo);
		String price = req.getParameter("price");
			System.out.println("에러확인 price : " + price);
		String size = req.getParameter("size");
			System.out.println("에러확인 size : " + size);
		
		BiddingVo dbVo = new BiddingVo();
		dbVo.setProductsNo(productsNo);
		dbVo.setPrice(price);
		dbVo.setShoesSizes(size);
		
		System.out.println(dbVo.getProductsNo());
		System.out.println(dbVo.getPrice());
		System.out.println(dbVo.getShoesSizes());
		
		req.setAttribute("dbVo", dbVo);
		req.getRequestDispatcher("/WEB-INF/views/buy/check.jsp").forward(req, resp);
		
	}

}
