package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.HistoryCntVo;

@WebServlet("/mypage/buying")

public class BuyingController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 여부 체크
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		if(loginMember == null) {
			resp.sendRedirect("/shoekream/member/login");
		}
		
		// service 호출
		MyPageService service = new MyPageService();
//		HistoryCntVo cntVo = service.getBuyingCnts(loginMember);
		req.getRequestDispatcher("/WEB-INF/views/mypage/buying.jsp").forward(req, resp);
		
	}
	
}
