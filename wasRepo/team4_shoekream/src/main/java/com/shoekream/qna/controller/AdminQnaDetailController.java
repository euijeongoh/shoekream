package com.shoekream.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.qna.service.QnaService;
import com.shoekream.qna.vo.QnaVo;

@WebServlet("/admin/qna/detail")
public class AdminQnaDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			
			//service
			QnaService qs = new QnaService();
			QnaVo vo = qs.selectQnaListByNo(no);
			
			//result ==view
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/admin/board/qna/adminDetail.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-002] 게시글 상세 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		//data
			String qnaNo = req.getParameter("no");
			System.out.println(qnaNo);
			String replyTitle = req.getParameter("replyTitle");
			String replyContents = req.getParameter("replyContent");
			
			QnaVo vo = new QnaVo();
			vo.setNo(qnaNo);
			vo.setReplyTitle(replyTitle);
			vo.setReplyContent(replyContents);
	
			//service
			QnaService qs = new QnaService();
			int result = qs.replyWrite(vo);
			
			//result == view
			if(result != 1) {
				throw new Exception();
			}
			
			req.getSession().setAttribute("alarm", "게시글 답글 작성 성공!");
			resp.sendRedirect("/shoekream/admin/qna/list");
			
		}catch(Exception e) {
			System.out.println("[ERROR-M001] QNA 답글 작성 중 에러 발생!");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
	}
}
