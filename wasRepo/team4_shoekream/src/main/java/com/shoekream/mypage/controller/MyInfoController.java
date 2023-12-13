package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;

@WebServlet("/mypage/info")

public class MyInfoController extends HttpServlet {
	
	// 로그인 정보 수정 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/mypage/info.jsp").forward(req, resp);
	}
	
	
	// 로그인 정보 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// loginMember check
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			if(loginMember==null) {
				throw new Exception("로그인 안함");
			}
			
			String memberNo = loginMember.getNo();
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberNick = req.getParameter("memberNick");
			String memberEmail = req.getParameter("memberEmail");
			
			MemberVo vo = new MemberVo();
			vo.setNo(memberNo);
			vo.setId(memberId);
			vo.setPwd(memberPwd);
			vo.setNickname(memberNick);
			vo.setEmail(memberEmail);
			
			MyPageService service = new MyPageService();
			int result = service.updateMemberInfo(req, vo);
			
			// result
			if(result != 1) {
				throw new Exception();
			}
			
			resp.sendRedirect("/shoekream/mypage/info");
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/shoekream/mypage/main");
		}
	}
}
