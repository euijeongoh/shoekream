package com.shoekream.review.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/detail")
public class ReviewDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		
		//data
		String no = req.getParameter("no");
		
		//service
		ReviewService bs = new ReviewService();
//		BoardVo vo = bs.selectBoardByNo(no); -> 댓글 생기기 전엔 이것만 있었음
		ReviewVo vo = bs.selectReviewByNo(no);
		System.out.println(vo);
		
		//result == view
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/review/detail.jsp").forward(req, resp);
		
	}catch (Exception e) {
		System.out.println("[ERROR-B003] 게시글 상세조회 중 에러발생");
		e.printStackTrace();
		req.setAttribute("errorMsg", "게시글 상세조회 실패");
		req.getRequestDispatcher("/WEB-INF/views/review/list").forward(req, resp);
	}
}
}
