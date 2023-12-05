package com.shoekream.admin.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.manager.service.ManagerService;
import com.shoekream.admin.manager.vo.ManagerVo;

@WebServlet("/admin/searchID")

public class ManagerSearchIDController extends HttpServlet {

	// 아이디 찾기 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/member/admin_searchID.jsp").forward(req, resp);
		
	}
	
	// 아이디 찾기 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			String adminName = req.getParameter("adminName");
			String adminPhone = req.getParameter("adminPhone");
			
			ManagerVo vo = new ManagerVo();
			vo.setName(adminName);
			vo.setPhone(adminPhone);
			
			// service
			ManagerService ms = new ManagerService();
			String id = ms.searchId(vo);
			
			// result == view
			if(id == null) {
				throw new Exception("일치하는 회원정보 찾을 수 없음");
			}
			
			req.setAttribute("idSearched", id);
			req.getRequestDispatcher("/WEB-INF/views/admin/member/admin_findID.jsp").forward(req, resp);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.getSession().setAttribute("searchIdFailed", "일치하는 회원정보를 찾을 수 없습니다. 로그인 페이지로 돌아갑니다.");
			resp.sendRedirect("/shoekream/admin/login");
		}
		
	}
	
}
