package com.shoekream.bidding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.RequestGroupInfo;

import com.shoekream.bidding.service.BiddingService;
import com.shoekream.orders.vo.OrdersVo;

@WebServlet("/sell/order")
public class SellOrderController extends HttpServlet{
	
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
		
		try {
			String name = "곽태윤";
			String dataName = getHiddenData(name, 1);
			req.setAttribute("trade","판매");
			req.setAttribute("process", " 진행 중");
			
			BiddingService bs = new BiddingService();
			OrdersVo ordersVo = bs.ordersInfo(req.getParameter("memberNo"),req.getParameter("biddingNo"),req.getParameter("productsNo"));
				System.out.println("orderController 에러확인 memberNo : " + req.getParameter("memberNo"));
				System.out.println("orderController 에러확인 biddingNo : " + req.getParameter("biddingNo"));
				System.out.println("orderController 에러확인 productsNo : " + req.getParameter("productsNo"));
			if (ordersVo == null) {
				throw new Exception("예외 발생 : ordersVo == null");
			}
				System.out.println("orderController 에러확인 ordersVo : " + ordersVo);
			
			req.setAttribute("ordersVo", ordersVo);
			
//			req.setAttribute("price", req.getParameter("price"));
//			req.setAttribute("commission", req.getParameter("commission"));
//			req.setAttribute("deliveryCharge", req.getParameter("deliveryCharge"));
//			req.setAttribute("totalAmount", req.getParameter("totalAmount"));
			
			int commission = ((int)(Math.round(((Integer.parseInt(ordersVo.getPrice()))*0.03)*0.01)*100));
			req.setAttribute("price", ordersVo.getPrice());
			req.setAttribute("commission", commission);
			req.setAttribute("totalAmount", ordersVo.getTotalPrice());
			
			
			req.getRequestDispatcher("/WEB-INF/views/sell/order.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("order 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/sell/order.jsp").forward(req, resp);
		
	}	
	
}
