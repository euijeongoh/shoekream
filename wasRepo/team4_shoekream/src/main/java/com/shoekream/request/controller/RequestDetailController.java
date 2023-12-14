package com.shoekream.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.member.MemberVo;
import com.shoekream.request.service.RequestService;
import com.shoekream.request.vo.RequestVo;


@WebServlet("/request/detail")
public class RequestDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String no = req.getParameter("no");
			
			HttpSession session = req.getSession();
			MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
			if(loginMember == null) {
				throw new Exception("로그인 안했음");
			}
			
			//service
			RequestService qs = new RequestService();
			RequestVo vo = qs.selectRequestListByNo(no);
			
			//result ==view
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/WEB-INF/views/board/request/detail.jsp").forward(req, resp);
		
		}catch(Exception e) {
			System.out.println("[ERROR-002] 게시글 상세 조회 중 에러 발생..");
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
