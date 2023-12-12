package com.shoekream.mypage.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.page.vo.PageVo;

@WebServlet("/mypage/main")

public class MyPageMainController extends HttpServlet{
	
	// 마이페이지 메인 화면 띄우기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			if(loginMember == null) {
				throw new Exception();
			}
			
			// service
			MyPageService mps = new MyPageService(); 
			
			int listCount = mps.getWishCnt(loginMember);
			String currentPage_ = req.getParameter("pno");
			if(currentPage_== null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			// 구매내역 cnt , 판매내역 cnt, 관심상품 list
			Map<String, Object> myMainMap = mps.getMyPageMainInfo(loginMember, pvo);
			
			// result == view
			req.setAttribute("buyCntVo", myMainMap.get("buyCntVo"));
			req.setAttribute("sellCntVo", myMainMap.get("sellCntVo"));
			req.setAttribute("wishList", myMainMap.get("wishList"));
			System.out.println(myMainMap.get("wishList"));
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/my.jsp").forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/shoekream/member/login");
		}
		
	}
	
}
