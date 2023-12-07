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
import com.shoekream.mypage.vo.AddrBookVo;

@WebServlet("/mypage/addr")
public class AddressController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			
			AddressService as = new AddressService();
			AddrBookVo vo = as.selectAddrList(no);
			req.setAttribute("vo", vo);
			
			List<AddrBookVo> extraVo = as.selectExtraAddrList(no);
			req.setAttribute("extraVo", extraVo);
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/addr.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR-A001] 주소록 조회에서 오류남");
		}
	}

}
