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

//@WebServlet("/review/list")
//public class ReviewListController extends HttpServlet {
//	
//
//   //게시글 목록 화면
//   @Override
//   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	   
//      try {
//    	  ReviewService bs = new ReviewService();
//
//    	  //data
//    	  int listCount = bs.selectReviewCount();	//전체 게시글 갯수
//    	  String currentPage_ = req.getParameter("pno");
//    	  if(currentPage_ == null) {
//    		 currentPage_ = "1";
//    	  }
//    	  int currentPage = Integer.parseInt(currentPage_);	//현재 페이지
//    	  int pageLimit = 5;
//    	  int reviewLimit = 10;
//         PageVo pvo = new PageVo (listCount, currentPage, pageLimit, reviewLimit);
//         
//         
//         //service(layer 호출)
//         List<ReviewVo> reviewVoList = bs.selectReviewList(pvo);
//         
//         //result(==view)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
//         req.setAttribute("reviewVoList", reviewVoList);
//         req.setAttribute("pvo", pvo);;
//         req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
//         
//      }catch(Exception e) {
//         System.out.println("[ERROR-B001] 게시글 목록 조회 중 에러 발생...");
//         e.printStackTrace();
//         req.setAttribute("errorMsg", "게시글 목록 조회 에러");
//         req.getRequestDispatcher("/WEB-INF/views/review/error.jsp").forward(req, resp);
//      }
//   }
//   
//}