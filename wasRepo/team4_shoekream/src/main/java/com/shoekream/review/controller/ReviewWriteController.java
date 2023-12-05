package com.shoekream.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			//로그인 안되어있으면 에러페이지로 보내기
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
	        if(loginMember == null) {
//	        	resp.sendRedirect("/member/login");
	           req.setAttribute("errorMsg" , "잘못된 접근입니다. (로그인 하고 오세요)");
	           req.getRequestDispatcher("/WEB-INF/views/review/error.jsp").forward(req, resp);
	        }
			
			//service
			ReviewService rs = new ReviewService();
	        List<ReviewVo> reviewVoList = rs.getReviewList();
			req.setAttribute("reviewVoList", reviewVoList);
			req.getRequestDispatcher("/WEB-INF/views/review/write.jsp").forward(req, resp);

		}catch (Exception e){
			e.printStackTrace();
			req.setAttribute("errorMsg", "상품 리뷰 등록하기 (화면) 에러");
			req.getRequestDispatcher("/WEB-INF/views/review/error.jsp").forward(req, resp);
		}
		
	}
	
	// 게시글 작성 로직
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      try {
               
    	  //인코딩
//	      req.setCharacterEncoding("UTF-8");   //필터에서 인코딩 처리 해줌
         
         HttpSession session = req.getSession();
         
         // data //이미지는 어떤 타입?
         String fiveStarRating = req.getParameter("fiveStarRating");
         String comfortNO = req.getParameter("comfortNO");
         String content = req.getParameter("content");
         MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
         
         if(loginMember == null) {
            throw new Exception("로그인 안했음");
         }
         
         ReviewVo vo = new ReviewVo();
         vo.setFiveStarRating(fiveStarRating);
         vo.setComfortNo(comfortNO);
         vo.setContent(content);
         vo.setMemberNo(loginMember.getNo());
         
         // service
         ReviewService bs = new ReviewService();
         int result = bs.write(vo);
         
         // result == view
         if(result != 1) {
            throw new Exception("result 가 1이 아님 ,,,,");
         }
         
         req.getSession().setAttribute("alertMsg", "게시글 작성 성공 !");
         resp.sendRedirect("/shoekream//review/list");
         
      }catch(Exception e) {
         System.out.println("[ERROR-B002] 게시글 작성 실패 ...");
         e.printStackTrace();
         req.setAttribute("errorMsg", "게시글 작성 실패 ...");
         req.getRequestDispatcher("/WEB-INF/views/review/error.jsp").forward(req, resp);
      }
      
   }


}
