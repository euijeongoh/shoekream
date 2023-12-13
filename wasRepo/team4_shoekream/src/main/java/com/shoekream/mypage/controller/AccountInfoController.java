package com.shoekream.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.AccountService;
import com.shoekream.mypage.vo.AccountVo;

@WebServlet("/mypage/ACCOUNT")
public class AccountInfoController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// data
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
						
			if(loginMember == null) {
				throw new Exception();
			}
			String no = req.getParameter("no");
			
			AccountService as = new AccountService();
			AccountVo avo = as.selectAccount(no);
			req.setAttribute("avo", avo);
			

			req.getRequestDispatcher("/WEB-INF/views/mypage/accountInfo.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/shoekream/member/login");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			String bankAgentNo = req.getParameter("bank");
			if(bankAgentNo.equals("국민은행")) {
				bankAgentNo = "1";
			}else if(bankAgentNo.equals("신한은행")){
				bankAgentNo = "2";
			}else if(bankAgentNo.equals("우리은행")){
				bankAgentNo = "3";
			}else if(bankAgentNo.equals("하나은행")){
				bankAgentNo = "4";
			}else if(bankAgentNo.equals("기업은행")){
				bankAgentNo = "5";
			}else if(bankAgentNo.equals("농협은행")){
				bankAgentNo = "6";
			}else if(bankAgentNo.equals("SC은행")){
				bankAgentNo = "7";
			}
			String accountNumber = req.getParameter("accountNumber");
			String depositor = req.getParameter("depositor");
			
			AccountVo vo = new AccountVo();
			vo.setNo(no);
			vo.setBankAgentNo(bankAgentNo);
			vo.setAccountNumber(accountNumber);
			vo.setDepositor(depositor);
			System.out.println(vo);
			
			AccountService as = new AccountService();
			int result = as.updateAccount(vo);
			
			if(result != 1) {
				throw new Exception("계좌 수정에서 오류");
			}
			resp.sendRedirect("/shoekream/mypage/ACCOUNT?no=1");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}

}
