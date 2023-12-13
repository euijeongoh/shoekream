package com.shoekream.request.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.request.service.RequestService;
import com.shoekream.request.vo.RequestVo;

@WebServlet("/request/edit")
public class RequestEditController extends HttpServlet {
	
	// 게시글 수정 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			RequestService qs = new RequestService();
			req.getRequestDispatcher("/WEB-INF/views/request/write.jsp").forward(req, resp);

			//result
			if(vo == null) {
				throw new Exception();
			}
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/request/edit.jsp").forward(req, resp);
		}catch(Exception e) {
			System.out.println("게시글 수정하기 화면 조회 에러 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 화면 조회 에러 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
	// 게시글 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			//data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String category = req.getParameter("category");
			String no = req.getParameter("no");
			
			RequestVo vo = new RequestVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setNo(no);
			
			//service
			RequestService bs = new RequestService();
			int result = bs.requestEdit(vo);
			
			//result
			if(result != 1) {
				throw new Exception();
			}
			resp.sendRedirect("/shoekream/request/detail?no=" + no);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

}//class
