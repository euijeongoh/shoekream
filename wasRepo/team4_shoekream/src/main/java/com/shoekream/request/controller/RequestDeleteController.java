package com.shoekream.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.request.service.RequestService;

@WebServlet("/request/delete")
public class RequestDeleteController extends HttpServlet{

	
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
			RequestService rs = new RequestService();
			int result =rs.requestDelete(no);
			
			//result == view
			if(result != 1) {
				throw new Exception();
			}
			req.getSession().setAttribute("alarm", "게시글 삭제 성공!");
			resp.sendRedirect("/shoekream/request/list");
		}catch(Exception e) {
			System.out.println("[ERROR-M002] 게시글 삭제 중 에러 발생!");
			e.printStackTrace();
			req.setAttribute("error", "게시글 삭제 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
	}
}
