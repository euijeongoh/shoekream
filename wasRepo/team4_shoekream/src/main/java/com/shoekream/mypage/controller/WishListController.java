package com.shoekream.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;
import com.shoekream.mypage.vo.WishListVo;

@WebServlet("/mypage/wishlist")

public class WishListController extends HttpServlet{

	// 관심상품 화면 불러오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 로그인 여부 체크
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				resp.sendRedirect("/shoekream/member/login");
			}
			
			// service
			MyPageService service = new MyPageService();
			List<WishListVo> wishList = service.viewWishListInfo(loginMember);
			
			
			
			// result (== view)
			req.setAttribute("wishList", wishList);
			req.getRequestDispatcher("/WEB-INF/views/mypage/wishlist.jsp").forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
}
