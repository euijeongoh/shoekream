package com.shoekream.review.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.member.MemberVo;
import com.shoekream.review.service.ReviewProductService;
import com.shoekream.review.service.ReviewService;
import com.shoekream.review.vo.ReviewVo;

@MultipartConfig(
	maxFileSize = 1024*1024*50,
	maxRequestSize = 1024*1024*5
)


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
	        String productNo = req.getParameter("productNo");
	        ReviewProductService ps = new ReviewProductService();
	        
	        EnrollProductVo productVo = ps.getProductInfo(productNo);
	        System.out.println(productVo);
	        req.setAttribute("productVo", productVo);
	        
	        
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
         MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
         

         if(loginMember == null) {
              throw new Exception("로그인 안했음");
           }
           
         Part f = req.getPart("f");
         InputStream in = f.getInputStream();
         String submittedFileName = f.getSubmittedFileName();
         System.out.println("-------");
         System.out.println(submittedFileName);
         System.out.println("-------");
         
      // data //이미지는 어떤 타입?
       String no = req.getParameter("no");
       String memberNo = req.getParameter("memberNo");
       String productNo = req.getParameter("productNo");
       String comfortNo = req.getParameter("comfortNo");
       String content = req.getParameter("write");
       
       
       
       // 읽기 준비
       
       // 내보내기 준비
       
       // DB에 저장될 이름을 만드는 작업
       String sep = File.separator;
       String path = sep + "resources" + sep + "img" + sep + "review";
       String realPath = req.getServletContext().getRealPath(path);
       String randomName = loginMember.getId() + "_" + productNo + "_" + System.currentTimeMillis() + "_" + UUID.randomUUID();
       String ext = submittedFileName.substring(submittedFileName.lastIndexOf("."));
       String fileName = sep + randomName + ext;
       
       // DB에 저장될 값
       String url = "/shoekream" + path + fileName;
       
       
       // 서버 업로드
       File target = new File(realPath + fileName);
       FileOutputStream out = new FileOutputStream(target);
       
       byte[] buf = new byte[1024];
       int size = 0;
       while((size = in.read(buf)) != -1) {
    	   out.write(buf, 0, size);
       }
       
       // 정리
       in.close();
       out.close();
       
//       String likeBtn = req.getParameter("likeBtn");
	   
	     ReviewVo vo = new ReviewVo();
	     vo.setNo(no);
	     vo.setMemberNo(loginMember.getNo());
	     vo.setProductNo(productNo);
	     vo.setComfortNo(comfortNo);
	     vo.setContent(content);
	     vo.setReviewImage(url);
//	     vo.setLikeBtn(likeBtn);
         
         // service
         ReviewService bs = new ReviewService();
         int result = bs.write(vo);
         
         // result == view
         if(result != 1) {
            throw new Exception("result 가 1이 아님 ,,,,");
         }
         
         
         req.getSession().setAttribute("alertMsg", "리뷰 작성 성공 !");
         resp.sendRedirect("/shoekream//review/write");
         
      }catch(Exception e) {
         System.out.println("[ERROR-B002] 리뷰 작성 실패 ...");
         e.printStackTrace();
         req.setAttribute("errorMsg", "리뷰 작성 실패 ...");
         req.getRequestDispatcher("/WEB-INF/views/review/wirte").forward(req, resp);
      }
      
   }


}