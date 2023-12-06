package com.shoekream.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/mylist")
public class MyReviewListController extends HttpServlet {

    //내 리뷰게시글 목록화면
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ReviewService rs = new ReviewService();

            // data
            String currentPage_ = req.getParameter("pno");
            int currentPage = (currentPage_ == null) ? 1 : Integer.parseInt(currentPage_); // 현재 페이지
            int pageLimit = 5;
            int reviewLimit = 10;

         // service(layer 호출) - 이 부분을 주석 처리하거나 삭제
//          List<ReviewVo> reviewVoList = rs.selectReviewList(currentPage, pageLimit, reviewLimit);

          // result(==view)
//          req.setAttribute("reviewVoList", reviewVoList);
            req.getRequestDispatcher("/WEB-INF/views/review/mylist.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("[ERROR-B001] MyReviewList 조회 중 에러 발생...");
            e.printStackTrace();
//            req.setAttribute("errorMsg", "게시글 목록 조회 에러");
            req.setAttribute("errorMsg", "로그인이 필요한 페이지 입니다.");
            req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
        }
    }
}
