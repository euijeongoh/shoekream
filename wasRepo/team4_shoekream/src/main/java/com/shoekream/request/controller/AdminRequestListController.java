package com.shoekream.request.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.admin.manager.vo.ManagerVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.request.service.RequestService;
import com.shoekream.request.vo.RequestVo;

@WebServlet("/admin/request/list")
public class AdminRequestListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestService ns = new RequestService();

		try {
			
		String x = req.getParameter("x");
		//data
		int listCount = ns.selectRequestCount();
		String currentPage_ = req.getParameter("pno");
		if(currentPage_ == null) {
			currentPage_ = "1";
		}
		int currentPage = Integer.parseInt(currentPage_);
		int pageLimit = 5;
		int boardLimit = 10;
		PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
//		HttpSession session = req.getSession();
//		ManagerVo loginAdmin = (ManagerVo)session.getAttribute("loginAdmin");
//		if(loginAdmin == null) {
//			throw new Exception("로그인 안했음");
//		}
		
		//service
		List<RequestVo> requestVoList = ns.RequestList(pvo);
		
		//result == view
		req.setAttribute("requestVoList", requestVoList);
		req.setAttribute("pvo", pvo);
		req.setAttribute("x", x);
		req.getRequestDispatcher("/WEB-INF/views/admin/board/request/adminList.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-001] 게시글 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}

}
