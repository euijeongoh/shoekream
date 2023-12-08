package com.shoekream.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.service.AdminProductListService;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.page.vo.PageVo;

@WebServlet("/admin/product/list")
public class AdminProductLIstController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AdminProductListService ps = new AdminProductListService();
			int listCount = ps.selectProductCount(); 
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null) {
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);
			int pageLimit = 5;
			int productLimit = 7;
			
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, productLimit);
			
			List<EnrollProductVo> productVoList = ps.selectProductList(pvo);
			req.setAttribute("productVoList", productVoList);
			req.setAttribute("pvo", pvo);
			req.getRequestDispatcher("/WEB-INF/views/admin/product/list.jsp").forward(req, resp);
			
			
				
		}catch(Exception e) {
			System.out.println("[ERROR-P001] 제품 목록 조회 중 에러 발생..");
			e.printStackTrace();
			req.setAttribute("errorMsg", "제품 목록 조회 에러");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String modelNumber = req.getParameter("modelNumber");
	}
	
}
