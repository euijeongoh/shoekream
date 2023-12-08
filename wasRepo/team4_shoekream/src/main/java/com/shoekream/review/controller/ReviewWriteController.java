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
	

	//리뷰작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    try {
	        // 사용자 로그인 여부 확인
	        MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
	        if (loginMember == null) {
	            req.setAttribute("errorMsg", "로그인이 필요한 페이지입니다.");
	            req.getRequestDispatcher("/WEB-INF/views/member/login.jsp"); //일단 주석처리 로그인 안되어있으면 로그인 페이지로 보내기
	            // 선택적으로 로그인 페이지로 리다이렉트하거나 다른 방식으로 처리할 수 있습니다.
	            // resp.sendRedirect("/member/login");
	        }

	        // 서비스 호출
	        ReviewService rs = new ReviewService();
	        List<ReviewVo> reviewVoList = rs.myReviewList();
	        
	        req.setAttribute("reviewVoList", reviewVoList);
	        req.getRequestDispatcher("/WEB-INF/views/review/write.jsp").forward(req, resp);

	    } catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("errorMsg", "리뷰 작성 에러");
	        req.getRequestDispatcher("/WEB-INF/views/review/write.jsp").forward(req, resp); //여기를 member/login로 고치기
	    }

	}

	
	//리뷰작성 로직
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      try {
    	  //인코딩
//	      req.setCharacterEncoding("UTF-8");   //필터에서 인코딩 처리 해줌
         
         HttpSession session = req.getSession();
         
         // data //이미지는 어떤 타입?
//         String memberNo = req.getParameter("memberNo");
         String comfortNo = req.getParameter("comfortNo");
         String fiveStarRating = req.getParameter("fiveStarRating");
         String content = req.getParameter("content");
         String likeBtn = req.getParameter("likeBtn");
         String reviewImage = req.getParameter("reviewImage");
         MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
         
         if(loginMember == null) {
            throw new Exception("로그인 안했음");
         }
         
         ReviewVo vo = new ReviewVo();
         vo.setComfortNo(comfortNo);
         vo.setFiveStarRating(fiveStarRating);
         vo.setContent(content);
         vo.setFiveStarRating(fiveStarRating);
         vo.setReviewImage(reviewImage);
         vo.setMemberNo(loginMember.getNo());
         
         // service
         ReviewService bs = new ReviewService();
         int result = bs.write(vo);
         
         // result == view
         if(result != 1) {
            throw new Exception("result 가 1이 아님 ,,,,");
         }
         
         req.getSession().setAttribute("alertMsg", "리뷰 작성 성공 !");
         resp.sendRedirect("/shoekream//review/mylist");
         
      }catch(Exception e) {
         System.out.println("[ERROR-B002] 리뷰 작성 실패 ...");
         e.printStackTrace();
         req.setAttribute("errorMsg", "리뷰 작성 실패 ...");
         req.getRequestDispatcher("/WEB-INF/views/review/mylist").forward(req, resp);
      }
      
   }


}
