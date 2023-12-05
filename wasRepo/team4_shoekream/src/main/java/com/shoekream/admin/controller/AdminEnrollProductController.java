package com.shoekream.admin.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoekream.admin.service.AdminEnrollProductService;
import com.shoekream.admin.vo.EnrollProductVo;

@WebServlet("/admin/product/enroll")
public class AdminEnrollProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/product/enroll.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			//db에서 먼저 체크할 데이터들
			String category = req.getParameter("category");
			String brand = req.getParameter("brand");
			//사이즈 값들의 배열
			String[] sizes = req.getParameterValues("size");
			
			//service
			AdminEnrollProductService ps = new AdminEnrollProductService();
			

			//카테고리 번호를 가져올 vo
//			System.out.println(category);
			EnrollProductVo categoryCheckVo = ps.categoryCheck(category);
			//가져온 카테고리 번호
			String categoryNo = categoryCheckVo.getCategoryNo();			
//			System.out.println(categoryNo);
			
			//브랜드 번호를 가져올 vo
			EnrollProductVo brandCheckVo = ps.brandCheck(brand);
			//가져온 브랜드 번호
//			System.out.println("brand : " + brand);
			String brandNo = brandCheckVo.getBrandNo();
//			System.out.println("brandNo : " + brandNo);
			
			//사이즈 번호를 가져올 vo
			EnrollProductVo sizeCheckVo = ps.sizeCheck(sizes);
			//가져온 사이즈 번호
			String[] sizeNo = sizeCheckVo.getSize();
			
			//DB의 PRODUCTS 테이블에 상품정보 등록
			System.out.println("sizes : " + Arrays.toString(sizes));
			System.out.println("sizeNo = "+ sizeNo);
			String productName = req.getParameter("productName");
			String modelNumber = req.getParameter("modelNumber");
			String releasePrice = req.getParameter("releasePrice");
			String releaseDate = req.getParameter("releaseDate");
			String productNameKo = req.getParameter("productNameKo");
			EnrollProductVo vo = new EnrollProductVo();
			vo.setProductName(productName);
			vo.setProductNameKo(productNameKo);
			vo.setModelNumber(modelNumber);
			vo.setReleasePrice(releasePrice);
			vo.setCategoryNo(categoryNo);
			vo.setBrandNo(brandNo);
			vo.setReleaseDate(releaseDate);
			vo.setDelYn("N");
			
			int result = ps.enrollProduct(vo);
			if(result != 1) {
				throw new Exception("result != 1");
			}
			
				
			
			EnrollProductVo productSizesVo = new EnrollProductVo();
			
			
			
			req.getSession().setAttribute("alertMsg", "제품 등록 성공!");
			resp.sendRedirect("/shoekream/product/enroll");
		}catch(Exception e) {
			System.out.println("제품 등록 실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "제품 등록 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
}
