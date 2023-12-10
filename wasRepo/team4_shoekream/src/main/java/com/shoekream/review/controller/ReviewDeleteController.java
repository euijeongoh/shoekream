package com.shoekream.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//data
			String no = req.getParameter("no");
			ReviewVo loginMember = (ReviewVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				throw new Exception("잘못된 접근입니다. (로그인 안하고 삭제 노노)");
			}
			String memberNo = loginMember.getNo();
			
			//service
			ReviewService rs = new ReviewService();
			int result = rs.delete(no, memberNo);
			
			//reuslt == view
			if(result != 1) {
				throw new Exception("게시글 삭제 중 에러 발생 ..");
			}
			
			//게시글 삭제 성공 => 게시글 목록으로 이동
			req.getSession().setAttribute("alertMsg", "게시글 삭제 성공!");
			resp.sendRedirect("/shoekream/review/list");
			
		}catch (Exception e){
			System.out.println("[ERROR-B004] 게시글 삭제 중 에러 발생 ..");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 삭제 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/review/error.jsp").forward(req, resp);
		}
		
	}

}
