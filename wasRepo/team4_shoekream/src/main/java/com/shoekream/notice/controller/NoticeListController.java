package com.shoekream.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.notice.service.NoticeService;

@WebServlet("/notice/member/main")
public class NoticeListController extends HttpServlet{

	//화면출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		//data
				
		//service
		NoticeService ns = new NoticeService();
		List<NoticeVo> noticeVoList = ns.NoticeList();
		
		req.setAttribute("noticeVoList", noticeVoList);
		
		//result == view
		req.getRequestDispatcher("/WEB-INF/views/board/notice/notice_member.jsp").forward(req, resp);
		
		}catch(Exception e) {
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
	
}
