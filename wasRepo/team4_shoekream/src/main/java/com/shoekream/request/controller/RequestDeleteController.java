package com.shoekream.request.controller;

import java.rmi.AccessException;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.request.service.RequestService;

@WebServlet("/request/delete")
public class RequestDeleteController extends HttpServlet {
	
	// 게시글 삭제
	// UPDATE BOARD SET STATUS = 'X' WHERE NO = ? and writer_no = ?
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String no = req.getParameter("no");
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			if(loginMember == null) {
				throw new Exception("잘못된 접근입니다. (로그인 안하고 삭제 ㄴㄴ)");
			}
			String memberNo = loginMember.getNo();
			
			// service
			RequestService qs = new RequestService();
			int result = qs.requestDelete(no, memberNo);
			
			// result == view
			if(result != 1) {
				throw new Exception("게시글 삭제 중 에러 발생 ...");
			}
			// 게시글 삭제 성공 => 게시글 목록으로 이동
			req.getSession().setAttribute("alertMsg", "게시글 삭제 성공!");
			resp.sendRedirect("/shoekream/request/list");
			
		}catch(Exception e) {
			System.out.println("[ERROR-B004] 게시글 삭제 중 에러 발생 ...");
			e.printStackTrace();
			req.setAttribute("errorMsg", "게시글 삭제 중 에러 발생 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}//doGet
	
}//class