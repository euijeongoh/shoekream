package com.shoekream.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.admin.manager.vo.ManagerVo;
import com.shoekream.faq.service.FaqService;
import com.shoekream.faq.vo.FaqVo;

@WebServlet("/admin/faq/write")
public class AdminFaqWriteController extends HttpServlet{
	
	//게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/board/faq/adminWrite.jsp").forward(req, resp);
	}
	
	//게시글 작성 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			//data
			String title = req.getParameter("title");
			String content = req.getParameter("contents");
			
			FaqVo vo = new FaqVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			HttpSession session = req.getSession();
			ManagerVo loginAdmin = (ManagerVo)session.getAttribute("loginAdmin");
			if(loginAdmin == null) {
				throw new Exception("로그인 안했음");
			}
			
			//service
			FaqService fs = new FaqService();
			int result = fs.faqWrite(vo);
			
			//result == view
			if(result != 1) {
				throw new Exception("result값이 1이 아님...");
			}
			
			req.getSession().setAttribute("alarm", "게시글 작성 성공!");
			resp.sendRedirect("/shoekream/admin/faq/list");
			
		}catch(Exception e) {
			System.out.println("[ERROR-M001] 공지사항 게시글 생성 중 에러 발생");
			e.printStackTrace();
			req.setAttribute("error", "게시글 작성 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common.fail.jsp").forward(req, resp);
		}
	}
}
