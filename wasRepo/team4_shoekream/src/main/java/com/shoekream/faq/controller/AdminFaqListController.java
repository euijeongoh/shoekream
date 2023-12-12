package com.shoekream.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.faq.service.FaqService;
import com.shoekream.faq.vo.FaqVo;
import com.shoekream.page.vo.PageVo;

@WebServlet("/admin/faq/list")
public class AdminFaqListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FaqService fs = new FaqService();

		try {
		//data
		int listCount = fs.selectFaqCount();
		String currentPage_ = req.getParameter("pno");
		if(currentPage_ == null) {
			currentPage_ = "1";
		}
		int currentPage = Integer.parseInt(currentPage_);
		int pageLimit = 5;
		int boardLimit = 10;
		PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
		//service
		List<FaqVo> faqVoList = fs.FaqList(pvo);
		
		//result == view
		req.setAttribute("faqVoList", faqVoList);
		req.setAttribute("pvo", pvo);
		req.getRequestDispatcher("/WEB-INF/views/admin/board/faq/adminList.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-001] 게시글 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}

}
