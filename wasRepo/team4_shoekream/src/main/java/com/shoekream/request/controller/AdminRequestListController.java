package com.shoekream.request.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.page.vo.PageVo;
import com.shoekream.qna.service.QnaService;
import com.shoekream.qna.vo.QnaVo;

@WebServlet("/admin/request/list")
public class AdminRequestListController extends HttpServlet{

	//화면출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QnaService qs = new QnaService();

		try {
		String x = req.getParameter("x");
		//data
		int listCount = qs.selectQnaCount();
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
		List<QnaVo> QnaVoList = qs.QnaList(pvo);
		
		//result == view
		req.setAttribute("qnaVoList", QnaVoList);
		req.setAttribute("pvo", pvo);
		req.setAttribute("x", x);
		req.getRequestDispatcher("/WEB-INF/views/admin/board/qna/adminList.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-001] 게시글 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
