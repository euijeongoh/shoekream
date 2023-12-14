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

@WebServlet("/admin/request/search")
public class AdminRequestSearchController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestService qs = new RequestService();
		try {
			//data
			String x = req.getParameter("x");
			
			HttpSession session = req.getSession();
			ManagerVo loginAdmin = (ManagerVo)session.getAttribute("loginAdmin");
			if(loginAdmin == null) {
				throw new Exception("로그인 안했음");
			}
			
			String title = req.getParameter("search");
			int listCount = qs.selectSearchRequestCount(title);
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//service
			List<RequestVo> requestVoList = qs.requestSearch(title, pvo);

			//result == view
			
			req.setAttribute("requestVoList", requestVoList);
			req.setAttribute("pvo", pvo);
			req.setAttribute("x", title);
			req.getRequestDispatcher("/WEB-INF/views/admin/board/request/adminList.jsp").forward(req, resp);
			
			
		}catch(Exception e) {
			System.out.println("[ERROR-003] 게시글 검색 중 에러 발생..");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp");
		}
	}
}
