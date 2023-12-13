package com.shoekream.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.faq.service.FaqService;
import com.shoekream.faq.vo.FaqVo;
import com.shoekream.member.MemberVo;
import com.shoekream.page.vo.PageVo;

@WebServlet("/faq/list")
public class FaqListController extends HttpServlet{

	//화면출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FaqService fs = new FaqService();

		try {
			
		String x = req.getParameter("x");
			
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
		
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		if(loginMember == null) {
			throw new Exception("로그인 안했음");
		}
		
		
		//service
		List<FaqVo> faqVoList = fs.FaqList(pvo);
		
		//result == view
		req.setAttribute("faqVoList", faqVoList);
		req.setAttribute("pvo", pvo);
		req.setAttribute("x", x);
		req.getRequestDispatcher("/WEB-INF/views/board/faq/list.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-001] 게시글 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
	
}
