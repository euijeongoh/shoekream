//package com.shoekream.mypage.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.shoekream.member.MemberVo;
//import com.shoekream.mypage.service.MyPageService;
//import com.shoekream.mypage.vo.BuyingListVo;
//import com.shoekream.mypage.vo.SellingListVo;
//
//@WebServlet("/mypage/main")
//
//public class MyPageMainController extends HttpServlet{
//	
//	// 마이페이지 메인 화면 띄우기
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		try {
//			// data
//			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
//			
//			if(loginMember == null) {
//				resp.sendRedirect("/shoekream/member/login");
//			}
//			
//			// service
//			MyPageService mps = new MyPageService(); 
//			Map<String, Object> map = mps.getMyPageMainInfo(loginMember);
//			
//			// result == view
//			if(map == null) {
//				throw new Exception("마이페이지 화면 오류");
//			}
//			
//			
//			req.getRequestDispatcher("/WEB-INF/views/mypage/my.jsp").forward(req, resp);
//		} catch(Exception e) {
//			
//			e.printStackTrace();
//			resp.sendRedirect("/shoekream/home");
//		}
//		
//	}
//	
//}
