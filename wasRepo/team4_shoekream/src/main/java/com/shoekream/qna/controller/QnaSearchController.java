package com.shoekream.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.member.MemberVo;
import com.shoekream.page.vo.PageVo;
import com.shoekream.qna.service.QnaService;
import com.shoekream.qna.vo.QnaVo;

@WebServlet("/qna/search")
public class QnaSearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QnaService qs = new QnaService();
		try {
			//data
			String title = req.getParameter("search");
			int listCount = qs.selectSearchQnaCount(title);
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
			List<QnaVo> qnaVoList = qs.qnaSearch(title, pvo);
			
			
			//result == view
			
			req.setAttribute("qnaVoList", qnaVoList);
			req.setAttribute("pvo", pvo);
			req.setAttribute("x", title);
			req.getRequestDispatcher("/WEB-INF/views/board/qna/list.jsp").forward(req, resp);
			
			
		}catch(Exception e) {
			System.out.println("[ERROR-003] 게시글 검색 중 에러 발생..");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp");
		}
	}

}
