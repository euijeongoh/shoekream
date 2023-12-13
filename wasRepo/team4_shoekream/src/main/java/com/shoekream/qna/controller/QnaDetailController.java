package com.shoekream.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.qna.service.QnaService;
import com.shoekream.qna.vo.QnaVo;

@WebServlet("/qna/detail")
public class QnaDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			
//			HttpSession session = req.getSession();
//			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
//			if(loginMember == null) {
//				throw new Exception("로그인 안했음");
//			}
			
			//service
			QnaService qs = new QnaService();
			QnaVo vo = qs.selectQnaListByNo(no);
			
			//result ==view
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/qna/detail.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-002] 게시글 상세 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
