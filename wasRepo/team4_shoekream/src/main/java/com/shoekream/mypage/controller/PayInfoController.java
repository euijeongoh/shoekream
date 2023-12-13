package com.shoekream.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.AddressService;
import com.shoekream.mypage.service.PayInfoService;
import com.shoekream.mypage.vo.AddrBookVo;
import com.shoekream.mypage.vo.PayInfoVo;

@WebServlet("/mypage/payInfo")

public class PayInfoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");

			if (loginMember == null) {
				throw new Exception();
			}
			String no = req.getParameter("no");

			PayInfoService as = new PayInfoService();
			PayInfoVo payVvo = as.selectPayInfoList(no);
			req.setAttribute("payVvo", payVvo);

			List<PayInfoVo> extraPayInfoVo = as.selectExtraPayInfoList(no);
			req.setAttribute("extraPayInfoVo", extraPayInfoVo);

			req.getRequestDispatcher("/WEB-INF/views/mypage/payment.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-A001] 주소록 조회에서 오류남");
			resp.sendRedirect("/shoekream/member/login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
