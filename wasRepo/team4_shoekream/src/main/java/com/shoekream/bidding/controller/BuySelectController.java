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
			BuySelectService bs = new BuySelectService();
			List<BiddingVo> voList = bs.buySelect();
			
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

}
