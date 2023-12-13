package com.shoekream.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.request.service.RequestService;
import com.shoekream.request.vo.RequestVo;

@WebServlet("/request/write")
public class RequestWriteController extends HttpServlet {
	
	//게시글 작성 화면
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/views/board/request/write.jsp").forward(req, resp);
		}
		
		//게시글 작성 로직
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			try {
				//data
				String title = req.getParameter("title");
				String content = req.getParameter("contents");
				
				RequestVo vo = new RequestVo();
				vo.setTitle(title);
				vo.setContent(content);
				
//				HttpSession session = req.getSession();
//				MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
//				if(loginMember == null) {
//					throw new Exception("로그인 안했음");
//				}
				
				//service
				RequestService qs = new RequestService();
				int result = qs.requestWrite(vo);
				
				//result == view
				if(result != 1) {
					throw new Exception("result값이 1이 아님...");
				}
				
				req.getSession().setAttribute("alarm", "게시글 작성 성공!");
				resp.sendRedirect("/shoekream/request/list");
				
			}catch(Exception e) {
				System.out.println("[ERROR-M001] Q&A 게시글 생성 중 에러 발생");
				e.printStackTrace();
				req.setAttribute("error", "게시글 작성 실패...");
				req.getRequestDispatcher("/WEB-INF/views/common.fail.jsp").forward(req, resp);
			}
		}

}
