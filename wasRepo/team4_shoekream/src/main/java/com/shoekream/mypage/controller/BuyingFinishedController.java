package com.shoekream.mypage.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.BuyingHistoryVo;

@WebServlet("/mypage/buying/finishList")

public class BuyingFinishedController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setCharacterEncoding("UTF-8");
			
			// 로그인 여부 체크
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				resp.sendRedirect("/shoekream/member/login");
			}
			
			BufferedReader br = req.getReader();
			String str = "";
			String jsonStr = null;
			while( (str = br.readLine()) != null ) {
				jsonStr = str;
			}

			// json to map
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>() {};
			Map<String, String> map = mapper.readValue(jsonStr, typeReference);
			
			// service 호출
			MyPageService service = new MyPageService();
			List<BuyingHistoryVo> finishedList = service.viewBuyingFinishedList(loginMember, map);
			System.out.println(finishedList);
			// result json으로 변환 후 응답
			PrintWriter out = resp.getWriter();
			String finishedListJson = mapper.writeValueAsString(finishedList);
			out.write(finishedListJson);
			
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
