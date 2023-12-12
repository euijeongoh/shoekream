package com.shoekream.review.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/edit")
public class ReviewEditController extends HttpServlet {
	
		// 게시글 수정 (화면)
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				//data
				String no = req.getParameter("no");
				ReviewService rs = new ReviewService();
				ReviewVo vo = rs.getReviewByNo(no);
				
				//result
				if(vo == null) {
					throw new Exception();
				}
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp").forward(req, resp);
			}catch(Exception e) {
				System.out.println("게시글 수정하기 화면 조회 에러 ...");
				e.printStackTrace();
				req.setAttribute("errorMsg", "게시글 수정 화면 조회 에러 ...");
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}
		}
		
		// 게시글 수정
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
				
				//data
				String comfortNo = req.getParameter("comfortNo");
				String content = req.getParameter("content");
				String no = req.getParameter("no");
				
				ReviewVo vo = new ReviewVo();
				vo.setComfortNo(comfortNo);
				vo.setContent(content);
				vo.setNo(no);
				
				//service
				ReviewService rs = new ReviewService();
				int result = rs.edit(vo);
				
				//result
				if(result != 1) {
					throw new Exception();
				}
				resp.sendRedirect("/app99/board/detail?no=" + no);
				
			}catch(Exception e) {
				e.printStackTrace();
				req.setAttribute("errorMsg", "게시글 수정 실패 ...");
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}
		}

	

}
