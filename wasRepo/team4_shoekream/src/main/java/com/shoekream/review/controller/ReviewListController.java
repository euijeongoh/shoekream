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
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 로그인 여부 체크
        	MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
        	
        	if(loginMember==null) {
        		throw new Exception();
        	}
        	
			
			// service
			ReviewService rs = new ReviewService();
			
			List<ReviewVo> ReviewVoList = rs.selectReviewList(loginMember);
			
			for (ReviewVo reviewVo : ReviewVoList) {
				System.out.println(reviewVo);
			}
			
			// result
			req.setAttribute("reviewVoList", ReviewVoList);
			req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-G001] 갤러리 목록 조회 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "갤러리 목록 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
		}
		
	}
	
	
	
	
	
//   // 리뷰(스타일) 목록 화면
//   @Override
//   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	   
//      try {
//    	  
//    	 //service
//         ReviewService rs = new ReviewService();
//         List<ReviewVo> reviewVoList = rs.selectReviewList();
//
//         req.setAttribute("reviewVoList", reviewVoList);
//         req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
//
//      } catch (Exception e) {
//         System.out.println("조회 실패");
//         e.printStackTrace();
//         req.setAttribute("errorMsg", "게시글 목록 조회 에러");
//         req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
//      }
//   }
	
//	// 리뷰(스타일) 목록 화면
//	   @Override
//	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		   
//	      try {
//	    	  
//	    	 //service
//	         ReviewService rs = new ReviewService();
//	         List<ReviewVo> reviewVoList = rs.selectReviewList();
//	         
//	         for(ReviewVo reviewVo : reviewVoList) {
//	        	 System.out.println(reviewVo);
//	         }
//
//	         //result
//	         req.setAttribute("reviewVoList", reviewVoList);
//	         req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
//
//	      } catch (Exception e) {
//	         System.out.println("조회 실패");
//	         e.printStackTrace();
//	         req.setAttribute("errorMsg", "게시글 목록 조회 에러");
//	         req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
//	      }
//	   }
	
}
	   