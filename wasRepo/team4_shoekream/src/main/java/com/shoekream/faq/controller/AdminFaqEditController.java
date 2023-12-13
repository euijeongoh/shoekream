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

@WebServlet("/admin/faq/edit")
public class AdminFaqEditController extends HttpServlet{

	
	//게시글 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			
			HttpSession session = req.getSession();
			ManagerVo loginAdmin = (ManagerVo)session.getAttribute("loginAdmin");
			if(loginAdmin == null) {
				throw new Exception("로그인 안했음");
			}
			
			//service
			FaqService fs = new FaqService();
			
			//result
			FaqVo vo = fs.getFaqByNo(no);
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/admin/board/faq/adminEdit.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("[ERROR-M003] 번호로 vo받아오는데 오류 발생!");
			e.printStackTrace();
		}
	}
	
	//게시글 수정 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("contents");
			
			FaqVo vo = new FaqVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			
			
			//service
			FaqService fs =  new FaqService();
			int result = fs.faqEdit(vo);
			
			//result == view
			if(result != 1) {
				throw new Exception();
			}
			
			req.getSession().setAttribute("alarm", "게시글 편집 성공!");
			resp.sendRedirect("/shoekream/admin/faq/list");
			
		}catch(Exception e) {
			System.out.println("[ERROR-M004] 게시글 편집 중 에러 발생!");
			e.printStackTrace();
			req.setAttribute("error", "게시글 삭제 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			
		}
	}

}
