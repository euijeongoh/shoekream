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
			System.out.println(no);

			PayInfoService as = new PayInfoService();
			PayInfoVo payVo = as.selectPayInfoList(no);
			req.setAttribute("payVo", payVo);

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
		
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			String memberNo = req.getParameter("MEMBER_NO");
			String cardCompanyNo = req.getParameter("CARD_COMPANY_NO");
			String cardNumber = req.getParameter("CARD_NUMBER");
			String expirationDate = req.getParameter("EXPIRATION_DATE");
			String cvcNumber = req.getParameter("CVC_NUMBER");
			String defaultPayInfoYn = req.getParameter("DEFAULT_PAYINFO_YN");

			PayInfoVo vo = new PayInfoVo();
			vo.setMemberNo(memberNo);
			vo.setCardCompanyNo(cardCompanyNo);
			vo.setCardNumber(cardNumber);
			vo.setNoexpirationDate(expirationDate);
			vo.setCvcNumber(cvcNumber);
			vo.setDefaultPayInfoYn(defaultPayInfoYn);
			
			System.out.println(vo);

			PayInfoService ps = new PayInfoService();
			int result = ps.insertPayInfo(vo);

			if (result != 1) {
				throw new Exception("카드 추가에서 오류");
			}
			resp.sendRedirect("/shoekream/mypage/payInfo?no=" + loginMember.getNo());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
