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
import com.shoekream.review.service.ReviewCommentService;
import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewCommentVo;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/review/comment")
public class ReviewCommentController extends HttpServlet {
	
	//댓글 작성화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    try {
	        //사용자 로그인 여부 확인
	        MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
	        if (loginMember == null) {
	        	req.setAttribute("errorMsg", "로그인이 필요한 페이지입니다.");
//	            req.getRequestDispatcher("/WEB-INF/views/member/login.jsp"); //일단 주석처리 로그인 안되어있으면 로그인 페이지로 보내기
	            // 선택적으로 로그인 페이지로 리다이렉트하거나 다른 방식으로 처리할 수 있습니다.
	            // resp.sendRedirect("/member/login");
	        }

	        // 서비스 호출
	        ReviewCommentService cs = new ReviewCommentService();
//	        List<ReviewCommentVo> reviewCommentVoList = cs.reviewCommentList();
	        
//	        req.setAttribute("reviewCommnetVoList", reviewCommentVoList);
	        req.getRequestDispatcher("/WEB-INF/views/review/comment.jsp").forward(req, resp);

	    	} catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("errorMsg", "댓글 작성 에러");
	        req.getRequestDispatcher("/WEB-INF/views/review/comment.jsp").forward(req, resp); //여기를 board 로 고치기
	    }

	}

	
	// 댓글 작성 로직
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      try {
              
    	  //인코딩
//	      req.setCharacterEncoding("UTF-8");   //필터에서 인코딩 처리 해줌
         
         HttpSession session = req.getSession();
         
         // data
//       String memberNo = req.getParameter("memberNo");
         String content = req.getParameter("content");
         String likeBtn = req.getParameter("likeBtn");
         MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
         
//         if(loginMember == null) {
//            throw new Exception("로그인 안했음");
//         }
         
         ReviewCommentVo vo = new ReviewCommentVo();
//         vo.setMemberNo(memberNo);
         vo.setContent(content);
         vo.setLikeBtn(likeBtn);
         vo.setMemberNo(loginMember.getNo());
         
         // service
         ReviewCommentService bs = new ReviewCommentService();
         int result = bs.reviewCommentwrite(vo);
         
         // result == view
         if(result != 1) {
            throw new Exception("result 가 1이 아님 ,,,,");
         }
         
         req.getSession().setAttribute("alertMsg", "댓글 작성 성공 !");
         resp.sendRedirect("/shoekream/review/comment");
         
      }catch(Exception e) {
         System.out.println("[ERROR-B002] 댓글 작성 실패 ...");
         e.printStackTrace();
         req.setAttribute("errorMsg", "댓글 작성 실패 ...");
         req.getRequestDispatcher("/WEB-INF/views/review/comment.jsp").forward(req, resp);
      }
      
   }


}
