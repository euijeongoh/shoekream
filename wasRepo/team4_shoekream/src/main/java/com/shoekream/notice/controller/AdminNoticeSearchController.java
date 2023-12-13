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
import com.shoekream.page.vo.PageVo;

@WebServlet("/admin/notice/search")
public class AdminNoticeSearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		NoticeService ns = new NoticeService();
		try {
			//data
			String title = req.getParameter("search");
			int listCount = ns.selectSearchNoticeCount(title);
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
//			HttpSession session = req.getSession();
//			ManagerVo loginAdmin = (ManagerVo)session.getAttribute("loginAdmin");
//			if(loginAdmin == null) {
//				throw new Exception("로그인 안했음");
//			}
			
			//service
			List<NoticeVo> noticeVoList = ns.noticeSearch(title, pvo);
			
			
			//result == view
			
			req.setAttribute("noticeVoList", noticeVoList);
			req.setAttribute("pvo", pvo);
			req.setAttribute("x", title);
			req.getRequestDispatcher("/WEB-INF/views/admin/board/notice/adminList.jsp").forward(req, resp);
			
			
		}catch(Exception e) {
			System.out.println("[ERROR-M005] 게시글 검색 중 에러 발생..");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp");
		}
	}

}
