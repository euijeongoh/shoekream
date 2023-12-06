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
import com.shoekream.mypage.vo.BuyingListVo;
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
			String tab = req.getParameter("tab");
			System.out.println(tab);
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			
			// 데이터 뭉치기 - map
			Map<String, String> map = new HashMap<String, String>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("tab", tab);
			
			// service 호출
			MyPageService service = new MyPageService();
			// 구매내역 cnts
			HistoryCntVo cntVo = service.getBuyingCnts(loginMember, map);
			// 구매입찰 정보
			List<BuyingListVo> buyList = service.viewBuyingBidList(loginMember, map);
			
			// result (==view)
			req.setAttribute("cntVo", cntVo);
			req.setAttribute("buyList", buyList);
			
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/buying.jsp").forward(req, resp);
		} catch(Exception e) {
			
		}
	}
	
	
}
