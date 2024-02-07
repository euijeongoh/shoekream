package com.shoekream.mypage.controller;

import java.io.BufferedReader;
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

import com.google.gson.Gson;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.BiddingHistoryVo;
import com.shoekream.mypage.vo.HistoryCntVo;
import com.shoekream.page.vo.PageVo;

@WebServlet("/mypage/buying/bidList")

public class BuyingBiddingController extends HttpServlet{

	// 구매입찰 내역
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 응답 인코딩 설정
			resp.setCharacterEncoding("UTF-8");
			
			// 로그인 여부 체크
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				resp.sendRedirect("/shoekream/member/login");
			}
			
			// json문자열 읽어들이기
			BufferedReader br = req.getReader();
			String str = "";
			String jsonStr = null;
			while( (str = br.readLine()) != null ) {
				jsonStr = str;
			}
			System.out.println(jsonStr);
			
			// json to map
			Gson gson = new Gson();
			Map<String, String> map = gson.fromJson(jsonStr, Map.class);
			
			// service 호출
			MyPageService service = new MyPageService();
			List<BiddingHistoryVo> bidList = service.viewBuyingBiddingList(loginMember, map); // pvo에 알맞게 service, dao 바꾸기 
			
			// result json으로 변환 후 응답
			PrintWriter out = resp.getWriter();
			String bidListJson = gson.toJson(bidList);
			out.write(bidListJson);
			
			// close
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
