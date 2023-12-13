package com.shoekream.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.notice.service.NoticeService;
import com.shoekream.notice.vo.NoticeVo;

@WebServlet("/admin/notice/edit")
public class AdminNoticeEditController extends HttpServlet{

	
	//게시글 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
//			HttpSession session = req.getSession();
//			ManagerVo loginAdmin = (ManagerVo)session.getAttribute("loginAdmin");
//			if(loginAdmin == null) {
//				throw new Exception("로그인 안했음");
//			}
			
			//service
			NoticeService ns = new NoticeService();
			NoticeVo vo = ns.getNoticeByNo(no);

			//result
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/admin/board/notice/adminEdit.jsp").forward(req, resp);
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
			
			NoticeVo vo = new NoticeVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			
			
			//service
			NoticeService ns =  new NoticeService();
			int result = ns.noticeEdit(vo);
			
			//result == view
			if(result != 1) {
				throw new Exception();
			}
			
			req.getSession().setAttribute("alarm", "게시글 편집 성공!");
			resp.sendRedirect("/shoekream/admin/notice/list");
			
		}catch(Exception e) {
			System.out.println("[ERROR-M004] 게시글 편집 중 에러 발생!");
			e.printStackTrace();
			req.setAttribute("error", "게시글 삭제 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			
		}
	}

}
