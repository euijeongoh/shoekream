package com.shoekream.bidding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.bidding.service.BiddingService;
import com.shoekream.orders.vo.OrdersVo;

@WebServlet("/sell/biddingorder")
public class SellBiddingOrderController extends HttpServlet{

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
			System.out.println("-----------------/sell/biddingorder-----------------");
		try {
			String name = "곽태윤";
			String dataName = getHiddenData(name, 1);
			System.out.println(dataName);

			req.setAttribute("trade","입찰이");
			req.setAttribute("process", " 등록되었습니다.");

			String memberNo = req.getParameter("memberNo");
			String productsNo = req.getParameter("productsNo");
			String productsSizesNo = req.getParameter("productsSizesNo");
			String biddingPrice = req.getParameter("biddingPrice");
			String deadline = req.getParameter("deadline");

			System.out.println("-----------------입찰등록-----------------");
			System.out.println("에러확인 memberNo : " + memberNo);
			System.out.println("에러확인 productsNo : " + productsNo);
			System.out.println("에러확인 productsSizesNo : " + productsSizesNo);
			System.out.println("에러확인 biddingPrice : " + biddingPrice);
			System.out.println("에러확인 deadline : " + deadline);

			BiddingService bs = new BiddingService();
			int result = bs.sellBidding(memberNo, productsNo, productsSizesNo, biddingPrice, deadline);
			if (result != 1) {
				throw new Exception("예외 발생 : result != 1");
			}


			int commission = ((int)(Math.round(((Integer.parseInt(biddingPrice))*0.05)*0.01)*100));
			int price = Integer.parseInt(biddingPrice);
			int totalAmount = price - commission;

			req.setAttribute("deadline", deadline);
			req.setAttribute("commission", commission);
			req.setAttribute("price", price);
			req.setAttribute("totalAmount", totalAmount);

			//				BiddingService bs = new BiddingService();
			//				OrdersVo ordersVo = bs.ordersInfo(req.getParameter("memberNo"),req.getParameter("biddingNo"),req.getParameter("productsNo"));
			//					System.out.println("-----------------배송/결제-----------------");
			//					System.out.println("에러확인 memberNo : " + req.getParameter("memberNo"));
			//					System.out.println("에러확인 biddingNo : " + req.getParameter("biddingNo"));
			//					System.out.println("에러확인 productsNo : " + req.getParameter("productsNo"));
			//				if (ordersVo == null) {
			//					throw new Exception("예외 발생 : ordersVo == null");
			//				}
			//					System.out.println("에러확인 ordersVo : " + ordersVo);

			//				req.setAttribute("ordersVo", ordersVo);

			//				req.setAttribute("price", req.getParameter("price"));
			//				req.setAttribute("commission", req.getParameter("commission"));
			//				req.setAttribute("deliveryCharge", req.getParameter("deliveryCharge"));
			//				req.setAttribute("totalAmount", req.getParameter("totalAmount"));

			//				int commission = ((int)(Math.round(((Integer.parseInt(ordersVo.getPrice()))*0.03)*0.01)*100));
			//				req.setAttribute("price", ordersVo.getPrice());
			//				req.setAttribute("commission", commission);
			//				req.setAttribute("totalAmount", ordersVo.getTotalPrice());

			req.getRequestDispatcher("/WEB-INF/views/sell/biddingorder.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("입찰 등록 중 예외 발생");
			e.printStackTrace();
		}

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/sell/biddingorder.jsp").forward(req, resp);

	}	

}
