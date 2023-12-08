package com.shoekream.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.notice.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			NoticeService ns = new NoticeService();
			NoticeVo vo = ns.selectNoticeListByNo(no);
			
			//result ==view
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/notice/detail.jsp").forward(req, resp);
		
		}catch(Exception e) {
			
		}
		
		
		
		
	}

}
