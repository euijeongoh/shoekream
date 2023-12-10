package com.shoekream.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.notice.service.NoticeService;

@WebServlet("/admin/notice/delete")
public class AdminNoticeDeleteController extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			NoticeService ns = new NoticeService();
			int result =ns.noticeDelete(no);
			
			//result == view
			if(result != 1) {
				throw new Exception();
			}
			req.getSession().setAttribute("alarm", "게시글 삭제 성공!");
			resp.sendRedirect("/shoekream/admin/notice/list");
		}catch(Exception e) {
			System.out.println("[ERROR-M002] 게시글 삭제 중 에러 발생!");
			e.printStackTrace();
			req.setAttribute("error", "게시글 삭제 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
	}
}