package com.shoekream.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.service.AdminProductListService;
import com.shoekream.admin.vo.EnrollProductVo;

@WebServlet("/product")
public class ProductController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//db에서 전체 다 가져오기
			List<EnrollProductVo> productVoList = new ArrayList<EnrollProductVo>();
			AdminProductListService ps = new AdminProductListService();
			productVoList = ps.getProductList();
			
			if(productVoList == null) {
				throw new Exception();
			}
			req.setAttribute("productVoList", productVoList);
			req.getRequestDispatcher("/WEB-INF/views/product/product.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String brand = req.getParameter("brand");
		String price = req.getParameter("price");
		
		
		//브랜드이름으로 브랜드번호 가져오기,,,,,,,
		EnrollProductVo brandVo = new EnrollProductVo();
		brandVo.setBrand(brand);
		
		
	}
}
