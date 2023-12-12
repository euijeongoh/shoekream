package com.shoekream.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;

@WebServlet("/mypage/wishlist/delete")

public class WishListDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		try {
			// data
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			System.out.println("======");
			System.out.println(loginMember);
			System.out.println("--------");
			String productNo = req.getParameter("productNo");
			
			// service
			MyPageService service = new MyPageService();
			int result = service.deleteWishItem(loginMember, productNo);
			
			// result == view
			if(result != 1) {
				throw new Exception("삭제 작업 오류");
			}
			
			pw.write("{\"msg\" : \"done\"}");
		} catch(Exception e) {
			e.printStackTrace();
			pw.write("{\"msg\" : \"no\"}");			
		}
	}
	
	
}
