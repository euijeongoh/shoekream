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
import com.shoekream.product.vo.ProductInfoVo;

@WebServlet("/sell/select")
public class SellSelectController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String productsNo = req.getParameter("productsNo");
				// 받아와야 함
			
			BiddingService bs = new BiddingService();
			List<BiddingVo> voList = bs.sellSelect(productsNo);
			
			if (voList == null) {
				throw new Exception("예외 발생 : voList == null");
			}
			
			ProductInfoVo productInfoVo = bs.sellProductInfo(productsNo);
//				System.out.println("BuySelectController 에러확인 infoVo : " + productInfoVo);
				
			/**
			 * 
			 */
			req.getSession().setAttribute("productInfoVo", productInfoVo);
			
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/sell/select.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("buySelect 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}

