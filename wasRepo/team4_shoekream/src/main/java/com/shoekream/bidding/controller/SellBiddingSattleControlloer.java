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
import com.shoekream.mypage.vo.AccountVo;
import com.shoekream.mypage.vo.AddrBookVo;
import com.shoekream.mypage.vo.PaymentVo;

@WebServlet("/sell/biddingsattle")
public class SellBiddingSattleControlloer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String biddingPrice = req.getParameter("biddingPrice");
		String deadline = req.getParameter("deadline");
			System.out.println("-----------------SellBiddingSattle-----------------");
			System.out.println("에러확인 biddingPrice : " + biddingPrice);
			System.out.println("에러확인 deadline : " + deadline);
		
		

		try {
			String loginMemberNo = req.getParameter("loginMemberNo");
			String productsNo = req.getParameter("productsNo");
			String buyPrice = req.getParameter("buyPrice");
			String buySize = req.getParameter("buySize");
				System.out.println("에러확인 loginMemberNo : " + loginMemberNo);
				System.out.println("에러확인 productsNo : " + productsNo);
				System.out.println("에러확인 buyPrice : " + buyPrice);
				System.out.println("에러확인 buySize : " + buySize);
			
				
			BiddingVo vo = new BiddingVo();
			vo.setProductsNo(productsNo);
			vo.setPrice(buyPrice);
			vo.setShoesSizes(buySize);
				
			BiddingService bs = new BiddingService();
			BiddingVo dbVo = bs.productInfo2sell(vo);
				System.out.println("SellBiddingSattle 에러확인 dbVo : " + dbVo);
			if (dbVo == null) {
				throw new Exception("예외 발생 : dbVo == null");
			}
			
			int commission = ((int)(Math.round(((Integer.parseInt(biddingPrice))*0.05)*0.01)*100));
			int price = Integer.parseInt(biddingPrice);
			int totalAmount = price - commission;
				System.out.println("에러확인 commission : " + commission);
				System.out.println("에러확인 price : " + price);
				System.out.println("에러확인 totalAmount : " + totalAmount);
			
			String commissionStr = String.valueOf(commission);
			String totalAmountStr = String.valueOf(totalAmount);

			
			int ordersResult = bs.orders(loginMemberNo, dbVo.getNo() ,productsNo, commissionStr, totalAmountStr  );
			if (ordersResult != 1) {
				throw new Exception("예외 발생 : ordersResult != 1");
			}
			
			Map<String, Object> result = bs.resultInfo(loginMemberNo);
			if (result == null) {
				throw new Exception("예외 발생 : result == null");
			}
			
			AddrBookVo addInfo = (AddrBookVo)result.get("addInfo");
			AccountVo accInfo = (AccountVo)result.get("accInfo");
			PaymentVo cardInfo = (PaymentVo)result.get("cardInfo");
				System.out.println("에러확인 cardInfo : " + cardInfo);

			
			req.getSession().setAttribute("addInfo", addInfo);
			req.getSession().setAttribute("accInfo", accInfo);
			req.getSession().setAttribute("cardInfo", cardInfo);
			
			req.setAttribute("commission", commission);
			req.setAttribute("totalAmount", totalAmount);
			req.setAttribute("biddingPrice", biddingPrice);
			req.setAttribute("deadline", deadline);
			
			req.setAttribute("dbVo", dbVo);
			req.getRequestDispatcher("/WEB-INF/views/sell/biddingsattle.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("SellBiddingSattle 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/sell/biddingsattle.jsp").forward(req, resp);
		
	}
	
}
