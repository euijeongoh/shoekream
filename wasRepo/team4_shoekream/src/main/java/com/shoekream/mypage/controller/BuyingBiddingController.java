package com.shoekream.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.BiddingHistoryVo;

@WebServlet("/mypage/buying/bidList")

public class BuyingBiddingController extends HttpServlet{

	// 구매입찰 내역
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 로그인 여부 체크
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				resp.sendRedirect("/shoekream/member/login");
			}
			
			// parameter값 받아오기
			String startDate = req.getParameter("startDate");
			System.out.println(startDate);
			String endDate = req.getParameter("endDate");
			System.out.println(endDate);
			
			// 데이터 뭉치기 - map
			Map<String, String> map = new HashMap<String, String>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			
			// service 호출
			MyPageService service = new MyPageService();
			List<BiddingHistoryVo> bidList = service.viewBuyingBiddingList(loginMember, map);
			
			// result (==view)

			ObjectMapper mapper = new ObjectMapper();
			 
			// result.json 파일로 저장
			
			PrintWriter out = resp.getWriter();
			String bidListJson = mapper.writeValueAsString(bidList);
			System.out.println(bidListJson);
			out.write(bidListJson);
			
			out.close();
			
		} catch(Exception e) {
			
		}
	}
	
	
}
