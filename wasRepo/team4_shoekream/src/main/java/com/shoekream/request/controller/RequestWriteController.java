package com.shoekream.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.member.MemberVo;
import com.shoekream.request.service.RequestService;
import com.shoekream.request.vo.RequestVo;
import com.shoekream.review.vo.ReviewVo;

@WebServlet("/request/write")
public class RequestWriteController extends HttpServlet {
	
	// 게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			//로그인 안되어있으면 에러페이지로 보내기
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				req.setAttribute("errorMsg"	, "잘못된 접근입니다. (로그인 하고 오세요)");
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}
			
			RequestService bs = new RequestService();
//			List<CategoryVo> categoryVoList = bs.getCategoryList(); 
//			req.setAttribute("categoryVoList", categoryVoList);
			req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 작성하기 (화면) 에러 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	// 게시글 작성 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
					
			//인코딩
//			req.setCharacterEncoding("UTF-8");	//필터에서 인코딩 처리 해줌
			
			HttpSession session = req.getSession();
			
			// data
//			String category = req.getParameter("category");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			
			
			
			RequestVo vo = new RequestVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMemberNo(loginMember.getNo());
			
			// service
			RequestService qs = new RequestService();
			int result = qs.requestWrite(vo);
			
			// result == view
			if(result != 1) {
				throw new Exception("result 가 1이 아님 ,,,,");
			}
			
			req.getSession().setAttribute("alertMsg", "게시글 작성 성공 !");
			resp.sendRedirect("/shoekream/request/list");
			
		}catch(Exception e) {
			System.out.println("[ERROR-B002] 게시글 작성 실패 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 작성 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}



}
