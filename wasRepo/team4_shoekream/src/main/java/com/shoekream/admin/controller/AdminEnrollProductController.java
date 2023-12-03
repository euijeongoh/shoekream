package com.shoekream.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/product/enroll")
public class AdminEnrollProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/product/enroll.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productName = req.getParameter("productName");
		String modelNumber = req.getParameter("modelNumber");
		String releasePrice = req.getParameter("releasePrice");
		String category = req.getParameter("category");
		String brand = req.getParameter("brand");
		String releaseDate = req.getParameter("releaseDate");
		
		ProductVo vo = new ProductVo();
		vo.setProductName(productName);
		vo.setModelNumber(modelNumber);
		vo.setReleasePrice(releasePrice);
		vo.setCategory(category);
		vo.setBrand(brand);
		vo.setReleaseDate(releaseDate);
		
		AdminEnrollProductService ps = new AdminEnrollProductService();
		int result = ps.EnrollProduct(vo);
	}
}
