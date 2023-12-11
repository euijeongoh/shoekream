package com.shoekream.admin.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.manager.service.ManagerService;

@WebServlet("/admin/admin/updatePwd")

public class ManagerUpdatePwdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/member/admin_updatePwd_result.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String authKey = req.getParameter("authKey");
			String newPwd = req.getParameter("newPwd");
			
			// service
			ManagerService service = new ManagerService();
			int result = service.updatePwd(authKey, newPwd);
			
			// result == view
			if(result != 1) {
				throw new Exception("비밀번호 변경 작업 실패");
			}
			
			req.getRequestDispatcher("");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
