package com.shoekream.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.member.MemberVo;
import com.shoekream.notice.service.NoticeService;
import com.shoekream.notice.vo.NoticeVo;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet{
	
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
			NoticeService ns = new NoticeService();
			NoticeVo vo = ns.selectNoticeListByNo(no);
			
			//result ==view
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/notice/detail.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-002] 게시글 상세 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}

}//class
