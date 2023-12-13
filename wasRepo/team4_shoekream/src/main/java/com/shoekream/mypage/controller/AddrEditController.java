package com.shoekream.mypage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.AddressService;
import com.shoekream.mypage.vo.AddrBookVo;

@WebServlet("/mypage/addr/edit")
public class AddrEditController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String no = req.getParameter("no");
			String name = req.getParameter("name");
			String phoneNum = req.getParameter("phone_num");
			String postCode = req.getParameter("post_code");
			String addr = req.getParameter("addr");
			String detailAddr = req.getParameter("detail_addr");
			String defaultAddr = req.getParameter("default_addr");
			
			AddrBookVo vo = new AddrBookVo();
			vo.setNo(no);
			vo.setAddersName(name);
			vo.setPhoneNumber(phoneNum);
			vo.setAddres(addr);
			vo.setDetailAddres(detailAddr);
			vo.setPostCode(postCode);
			vo.setDefaultAddrYn(defaultAddr);
			System.out.println(vo);
			
			AddressService as = new AddressService();
			int result = as.updateAddr(vo);
			
			if(result != 1) {
				throw new Exception("주소 수정에서 오류");
			}
			resp.sendRedirect("/shoekream/mypage/addr?no=1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}

}
