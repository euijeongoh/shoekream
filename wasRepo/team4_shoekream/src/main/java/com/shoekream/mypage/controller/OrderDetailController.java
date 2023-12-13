package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.OrderDetailVo;

@WebServlet("/order/detail")

public class OrderDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new Exception();
			}
			
			//data
			String orderNo = req.getParameter("orderNo");
			
			// service
			MyPageService service = new MyPageService();
			OrderDetailVo orderDetailVo = service.viewOrderDetail(orderNo);
			
			// result == view
			req.setAttribute("orderDetailVo", orderDetailVo);
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/orderDetail.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/shoekream/home");
		}
		
	}
	
}
