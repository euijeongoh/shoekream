package com.shoekream.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.service.EnrollProductService;
import com.shoekream.admin.vo.EnrollProductVo;

@WebServlet("/admin/product/enroll")
public class EnrollProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/product/enroll.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//db에 먼저 가야할 데이터들
			String category = req.getParameter("category");
			String brand = req.getParameter("brand");
			String[] size = req.getParameterValues("size");
			
			EnrollProductService ps = new EnrollProductService();
			EnrollProductVo catogoryCheckVo = ps.categoryCheck(category);
			
			
			
			
			String productName = req.getParameter("productName");
			String modelNumber = req.getParameter("modelNumber");
			String releasePrice = req.getParameter("releasePrice");
			String releaseDate = req.getParameter("releaseDate");
			
			EnrollProductVo vo = new EnrollProductVo();
			vo.setProductName(productName);
			vo.setModelNumber(modelNumber);
			vo.setReleasePrice(releasePrice);
			vo.setCategory(category);
			vo.setBrand(brand);
			vo.setReleaseDate(releaseDate);
			
			EnrollProductService ps = new EnrollProductService();
		}catch(Exception e) {
			
		}
		
	}
}
