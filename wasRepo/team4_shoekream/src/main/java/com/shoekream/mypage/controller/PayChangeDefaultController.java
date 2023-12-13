package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.AddressService;
import com.shoekream.mypage.service.PayInfoService;

@WebServlet("/mypage/payInfo/change")
public class PayChangeDefaultController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");

			if (loginMember == null) {
				throw new Exception();
			}
			String no = req.getParameter("no");
			String mamberNo = req.getParameter("mamberNo");

			PayInfoService as = new PayInfoService();
			int result = as.changeDefault(no,mamberNo);

			if (result > 0) {
				resp.sendRedirect("/shoekream/mypage/payInfo?no=" + loginMember.getNo());
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
