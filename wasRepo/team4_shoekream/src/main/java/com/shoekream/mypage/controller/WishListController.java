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
import com.shoekream.mypage.vo.HistoryCntVo;
import com.shoekream.mypage.vo.WishListVo;
import com.shoekream.page.vo.PageVo;

@WebServlet("/mypage/wishlist")

public class WishListController extends HttpServlet{

	// 관심상품 화면 불러오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 로그인 여부 체크
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");

			MyPageService service = new MyPageService();
			int listCount = service.getWishCnt(loginMember);
			String currentPage_ = req.getParameter("pno");
			if(currentPage_== null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			if(loginMember == null) {
				throw new Exception("로그인 안함");
			}
			
			// service
			List<WishListVo> wishList = service.viewWishListInfo(loginMember, pvo);
			
			
			// result (== view)
			req.setAttribute("wishList", wishList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/mypage/wishlist.jsp").forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/shoekream/member/login");
		}
		
	}
	
}
