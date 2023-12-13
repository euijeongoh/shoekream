package com.shoekream.product.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shoekream.admin.service.AdminProductListService;
import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.product.service.ProductDetailService;

@WebServlet("/product")
public class ProductController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//db에서 전체 다 가져오기
			List<EnrollProductVo> productVoList = new ArrayList<EnrollProductVo>();
			ProductDetailService ps = new ProductDetailService();
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
		try {
			BufferedReader br = req.getReader();
			String str = "";
			String jsonStr = null;
			while( (str = br.readLine()) != null ) {
				jsonStr = str;
			}
			
			System.out.println(jsonStr);
			
			//gson
			Gson gson = new Gson();
			EnrollProductVo filterVo = gson.fromJson(jsonStr, EnrollProductVo.class);
			AdminProductListService ps = new AdminProductListService();
			String[] brandNos = filterVo.getBrandNos();
			String[] categoryNos = filterVo.getCategoryNos();
			System.out.println(Arrays.toString(brandNos));
			System.out.println(Arrays.toString(categoryNos));
			List<EnrollProductVo> filterProductList = ps.searchFilterProduct(filterVo);
			for(EnrollProductVo vo : filterProductList) {
				System.out.println(vo.getModelNumber());
			}
			req.setAttribute("filterProductList", filterProductList);
			resp.sendRedirect("/shoekream/product");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
