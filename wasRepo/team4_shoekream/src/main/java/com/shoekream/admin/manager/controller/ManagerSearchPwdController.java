package com.shoekream.admin.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.manager.service.ManagerService;
import com.shoekream.admin.manager.vo.ManagerVo;

@WebServlet("/admin/searchPwd")

public class ManagerSearchPwdController extends HttpServlet {
	
	// 비밀번호 찾기 화면 띄우기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/member/admin_searchPwd.jsp").forward(req, resp);
		
	}
	
	// 비밀번호 찾기 위한 인증번호 보내기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			String managerId = req.getParameter("managerId");
			String email = req.getParameter("email");
			
			ManagerVo vo = new ManagerVo();
			vo.setId(managerId);
			vo.setEmail(email);
			
			// service
			ManagerService service = new ManagerService();
			boolean emailSent = service.sendPwdEmail(vo);
			
			// result == view
			if(emailSent == false) {
				throw new Exception("이메일 전송 실패");
			}
			
			req.getRequestDispatcher("/WEB-INF/views/admin/member/admin_updatePwd.jsp").forward(req, resp);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
