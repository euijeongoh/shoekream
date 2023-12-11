package com.shoekream.bidding.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.bidding.service.BiddingService;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.biddingVo.TestVo;
import com.shoekream.mypage.vo.AddrBookVo;
import com.shoekream.orders.vo.OrdersVo;

@WebServlet("/buy/nowpayment")
public class BuyNowPaymentControlloer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int totalAmount = 0;
			
			String loginMemberNo = req.getParameter("loginMemberNo");
			String productsNo = req.getParameter("productsNo");
			String buyPrice = req.getParameter("buyPrice");
			String buySize = req.getParameter("buySize");
				System.out.println("BuyNowPaymentController 에러확인 loginMemberNo : " + loginMemberNo);
				System.out.println("BuyNowPaymentController 에러확인 productsNo : " + productsNo);
				System.out.println("BuyNowPaymentController 에러확인 buyPrice : " + buyPrice);
				System.out.println("BuyNowPaymentController 에러확인 buySize : " + buySize);
			
				
			BiddingVo vo = new BiddingVo();
			vo.setProductsNo(productsNo);
			vo.setPrice(buyPrice);
			vo.setShoesSizes(buySize);
				
			BiddingService bs = new BiddingService();
			BiddingVo dbVo = bs.productInfo(vo);
				System.out.println("BuyNowPaymentController 에러확인 dbVo : " + dbVo);
			if (dbVo == null) {
				throw new Exception("예외 발생 : dbVo == null");
			}
			
			int ordersResult = bs.orders(loginMemberNo, dbVo.getNo() ,productsNo, totalAmount);
			if (ordersResult != 1) {
				throw new Exception("예외 발생 : ordersResult != 1");
			}
			
			Map<String, Object> result = bs.resultInfo(loginMemberNo);
			if (result == null) {
				throw new Exception("예외 발생 : result == null");
			}
			
			AddrBookVo addInfo = (AddrBookVo)result.get("addInfo");
			TestVo accInfo = (TestVo)result.get("accInfo");
			TestVo cardInfo = (TestVo)result.get("cardInfo");
			
			
			int commission = ((int)(Math.round(((Integer.parseInt(dbVo.getPrice()))*0.03)*0.01)*100));
				System.out.println("BuyNowPaymentController 에러확인 commission : " + commission);
			int deliveryCharge = 3000;
				System.out.println("BuyNowPaymentController 에러확인 deliveryCharge : " + deliveryCharge);
			int price = Integer.parseInt(dbVo.getPrice());
				System.out.println("BuyNowPaymentController 에러확인 price : " + price);
			totalAmount = commission + deliveryCharge + price;
				System.out.println("BuyNowPaymentController 에러확인 totalAmount : " + totalAmount);
			
			
			req.setAttribute("commission", commission);
			req.setAttribute("deliveryCharge", deliveryCharge);
			req.setAttribute("totalAmount", totalAmount);
			
			req.getSession().setAttribute("addInfo", addInfo);
			req.getSession().setAttribute("accInfo", accInfo);
			req.getSession().setAttribute("cardInfo", cardInfo);
//			req.setAttribute("addInfo", addInfo);
//			req.setAttribute("accInfo", accInfo);
//			req.setAttribute("cardInfo", cardInfo);
			
			req.setAttribute("dbVo", dbVo);
			req.getRequestDispatcher("/WEB-INF/views/buy/nowpayment.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("buyNowPayment 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
}
