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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.HistoryCntVo;
import com.shoekream.mypage.vo.OrdersHistoryVo;
import com.shoekream.page.vo.PageVo;

@WebServlet("/mypage/buying/pendList")

public class BuyingPendingController extends HttpServlet{

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

			// 페이징 처리
			HistoryCntVo cntVo = service.getBuyingCnts(loginMember);
			
			int listCount = cntVo.getCntBid();
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);		
			List<OrdersHistoryVo> pendList = service.viewBuyingPendingList(loginMember, map);
			
			// 데이터 가공(map)
			Map<String, Object> respMap = new HashMap<String, Object>();
			respMap.put("pvo", pvo);
			respMap.put("pendList", pendList);
			
			// result json으로 변환 후 응답
			PrintWriter out = resp.getWriter();
			String respJson = mapper.writeValueAsString(respMap);
			System.out.println(respJson);
			out.write(respJson);
			
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
