package com.shoekream.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.CategoryVo;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/write")
public class ReviewWriteController extends HttpServlet {
	
	//리뷰 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//로그인 안되어있으면 에러이지로 보내기
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
	        if(loginMember == null) {
//	        	resp.sendRedirect("/member/login");
	           req.setAttribute("errorMsg" , "잘못된 접근입니다. (로그인 하고 오세요)");
	           req.getRequestDispatcher("/WEB-INF/views/riview/error.jsp").forward(req, resp);
	        }
			
			//service
			ReviewService rs = new ReviewService();
	        List<ReviewVo> reviewVoList = rs.getReviewList();
			req.setAttribute("reviewVoList", reviewVoList);
			req.getRequestDispatcher("/WEB-INF/views/review/write.jsp").forward(req, resp);

		}catch (Exception e){
			e.printStackTrace();
			req.setAttribute("errorMsg", "상품 리뷰 등록하기 (화면) 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

}
