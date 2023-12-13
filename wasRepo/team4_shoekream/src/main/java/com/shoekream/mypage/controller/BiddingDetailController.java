package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.mypage.service.MyPageService;

@WebServlet("/bidding/detail")

public class BiddingDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// data
		String bidNo = req.getParameter("bidNo");
		
		// service
		MyPageService service = new MyPageService();
//		BiddingVo service.viewBiddingDetail(bidNo);
		
		// result == view
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/biddingdetail.jsp").forward(req, resp);
	}
	
}
