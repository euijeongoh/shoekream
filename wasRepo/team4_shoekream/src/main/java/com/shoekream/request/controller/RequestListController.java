package com.shoekream.request.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.page.vo.PageVo;
import com.shoekream.request.service.RequestService;
import com.shoekream.request.vo.RequestVo;

@WebServlet("/request/list")
public class RequestListController extends HttpServlet{

	//화면출력
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			RequestService rs = new RequestService();

			try {
			String x = req.getParameter("x");
			//data
			int listCount = rs.selectRequestCount();
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//service
			List<RequestVo> requestVoList = rs.RequestList(pvo);
			
			//result == view
			req.setAttribute("requestVoList", requestVoList);
			req.setAttribute("pvo", pvo);
			req.setAttribute("x", x);
			req.getRequestDispatcher("/WEB-INF/views/board/request/list.jsp").forward(req, resp);
			
			}catch(Exception e) {
				System.out.println("[ERROR-001] 게시글 조회 중 에러 발생..");
				req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
				e.printStackTrace();
			}
		}
	
}
