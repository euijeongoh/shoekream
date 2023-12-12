package com.shoekream.review.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.member.MemberVo;
import com.shoekream.review.service.ReviewProductService;
import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/detail")
public class ReviewDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		
		//사용자 로그인 여부 확인
		MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
		if(loginMember == null) {
			req.setAttribute("errorMsg", "로그인이 필요한 페이지입니다");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
		}
		
		//data
		String no = req.getParameter("no");
		String productNo = req.getParameter("productNo");
//		String productVo = req.getParameter("productVo");
		String reviewVo = req.getParameter("reviewVo");
		System.out.println(no);
		System.out.println(no);
		System.out.println(no);
		System.out.println(no);
		
		//service
		ReviewService bs = new ReviewService();
		EnrollProductVo po= new EnrollProductVo();
		ReviewProductService ps = new ReviewProductService();
		EnrollProductVo ro = ps.getProductInfo(productNo);
//		BoardVo vo = bs.selectBoardByNo(no); -> 댓글 생기기 전엔 이것만 있었음
		ReviewVo vo = bs.selectReviewByNo(no);
		System.out.println(vo);
		
		//result == view
		req.setAttribute("vo", vo);
		req.setAttribute("productVo", productVo);
		req.setAttribute("reviewVo", reviewVo);
		req.getRequestDispatcher("/WEB-INF/views/review/detail.jsp").forward(req, resp);
		
	}catch (Exception e) {
		System.out.println("[ERROR-B003] 리뷰 상세조회 중 에러발생");
		e.printStackTrace();
		req.setAttribute("errorMsg", "게시글 상세조회 실패");
		req.getRequestDispatcher("/WEB-INF/views/review/detail.jsp").forward(req, resp);
	}
}
}
