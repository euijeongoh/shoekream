package com.shoekream.mypage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.HistoryCntVo;

@WebServlet("/mypage/buying/bidding")

public class BuyingBiddingController extends HttpServlet{

	// 마이페이지 구매내역 구매입찰 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 로그인 여부 체크
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				resp.sendRedirect("/shoekream/member/login");
			}
			
			// parameter값 받아오기
//			String startDate = req.getParameter("startDate");
//			System.out.println(startDate);
//			String endDate = req.getParameter("endDate");
//			System.out.println(endDate);
			
			// 데이터 뭉치기 - map
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("startDate", startDate);
//			map.put("endDate", endDate);
			
			// service 호출
			MyPageService service = new MyPageService();
			BiddingHistoryVo historyVo = service.viewBuyingBiddingList(loginMember);
			
			// result (==view)
			req.setAttribute("bidList", historyVo.getBidList());
			req.setAttribute("cntVo", historyVo.getCntVo());
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/buy_buying.jsp").forward(req, resp);
		} catch(Exception e) {
			
		}
	}
	
	
}
