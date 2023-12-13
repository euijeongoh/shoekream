package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.BiddingDetailVo;

@WebServlet("/mypage/bidding/detail")

public class BiddingDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// loginMember null 체크
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember==null) {
				throw new Exception();
			}
			
			// data
			String bidNo = req.getParameter("biddingNo");
			
			// service
			MyPageService service = new MyPageService();
			BiddingDetailVo detailVo = service.viewBiddingDetail(bidNo);
			
			// result == view
			req.setAttribute("detailVo", detailVo);
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/biddingdetail.jsp").forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/shoekream/home");
		}
	}
	
}
