package com.shoekream.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.page.vo.PageVo;
import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {

   // 리뷰(스타일) 목록 화면
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
      try {
         ReviewService rs = new ReviewService();

         // data
         String currentPage_ = req.getParameter("pno");
         int currentPage = (currentPage_ == null) ? 1 : Integer.parseInt(currentPage_); // 현재 페이지
         int pageLimit = 5;
         int reviewLimit = 10;
         

         // service(layer 호출)
         List<ReviewVo> reviewVoList = rs.selectReviewList();

         // result(==view)
         // req.setAttribute("reviewVoList", reviewVoList);
         req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);

      } catch (Exception e) {
         System.out.println("[ERROR-B001] ReviewList 조회 중 에러 발생...");
         e.printStackTrace();
         req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
      }
   }
}
