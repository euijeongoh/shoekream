package com.shoekream.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.notice.service.NoticeService;
import com.shoekream.notice.vo.NoticeVo;


@WebServlet("/notice/search")
public class NoticeSearchController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//data
		String title = req.getParameter("title");
		
		//service
		NoticeService ns = new NoticeService();
		List<NoticeVo> noticeVoList = ns.noticeSearch(title);
		
		
		//result == view

	}

}
