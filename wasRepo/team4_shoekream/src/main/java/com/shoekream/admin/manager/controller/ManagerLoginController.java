package com.shoekream.admin.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.admin.manager.service.ManagerService;
import com.shoekream.admin.manager.vo.ManagerVo;

@WebServlet("/admin/login")

public class ManagerLoginController extends HttpServlet {
	
	// 로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/member/admin_login.jsp").forward(req, resp);
		
	}
	
	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String adminId = req.getParameter("adminId");
			String adminPwd = req.getParameter("adminPwd");
			
			ManagerVo vo = new ManagerVo();
			vo.setId(adminId);
			vo.setPwd(adminPwd);
			
			// service
			ManagerService as = new ManagerService();
			ManagerVo loginAdmin = as.adminLogin(vo);
			
			// result(==view)
			if(loginAdmin==null) {
				throw new Exception("일치하는 회원정보 찾을 수 없음");
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("loginAdmin", loginAdmin);
			session.removeAttribute("loginError");
			
			resp.sendRedirect("/shoekream/admin/home");
		} catch(Exception e) {
			System.out.println("[ERROR-M] 로그인 작업 도중 예외 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.getSession().setAttribute("loginError", "아이디와 비밀번호를 다시 확인하세요.");
			resp.sendRedirect("/shoekream/admin/login");			
		}
	
	}
}
