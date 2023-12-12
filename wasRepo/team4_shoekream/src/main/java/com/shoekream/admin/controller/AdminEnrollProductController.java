package com.shoekream.admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shoekream.admin.service.AdminEnrollProductService;
import com.shoekream.admin.vo.EnrollProductVo;
@MultipartConfig(
		maxFileSize = 1024 * 1024 *10,//파일 하나당 크기	
		maxRequestSize = 1024 * 1024 * 50//리퀘스트 전체 크기

)
@WebServlet("/admin/product/enroll")
public class AdminEnrollProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/product/enroll.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			
			//db에서 먼저 체크할 데이터들
			String category = req.getParameter("category");
			String brand = req.getParameter("brand");
			//사이즈 값들의 배열
			String[] sizes = req.getParameterValues("size");
			
			//service
			AdminEnrollProductService ps = new AdminEnrollProductService();
			

			//카테고리 번호를 가져올 vo
			EnrollProductVo categoryCheckVo = ps.categoryCheck(category);
			//가져온 카테고리 번호
			String categoryNo = categoryCheckVo.getCategoryNo();			
			
			//브랜드 번호를 가져올 vo
			EnrollProductVo brandCheckVo = ps.brandCheck(brand);
			//가져온 브랜드 번호
			String brandNo = brandCheckVo.getBrandNo();
			
			//사이즈 번호를 가져올 vo
			EnrollProductVo sizeCheckVo = ps.sizeCheck(sizes);
			//가져온 사이즈 번호
			String[] sizeNo = sizeCheckVo.getSizeNo();
			
			//DB의 PRODUCTS 테이블에 상품정보 등록
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
			//등록한 상품의 제품번호확인(modelNumber로 확인)
			EnrollProductVo productNoCheckVo = ps.getEnrolledProductNo(vo);
			String productNo = productNoCheckVo.getProductNo();
			vo.setProductNo(productNo);
			
			int result = ps.enrollProduct(vo);
			if(result != 1) {
				throw new Exception("result != 1");
			}
			
			EnrollProductVo productSizesVo = new EnrollProductVo();
			productSizesVo.setProductNo(productNo);
			productSizesVo.setSizeNo(sizeNo);
			
			int result2 = ps.enrollProductSize(productSizesVo);
			if(result2 != 1) {
				throw new Exception("result2 != 1");
			}
			
			req.setCharacterEncoding("UTF-8");
			Part f = req.getPart("f");
			
			InputStream in = f.getInputStream();
			//내보내기 준비
			String sep = File.separator;
			String path = req.getServletContext().getRealPath(sep + "resources"+sep + "img"+sep+"product");
			
			//원본파일명
			String submittedFileName = f.getSubmittedFileName();//f를 통해 제출된파일이름 가져오기
			//
			int index = submittedFileName.lastIndexOf(".");
			String ext = submittedFileName.substring(index);
			
			String fileName = sep+ modelNumber + ext;
			
			File target = new File(path+fileName);
			FileOutputStream out = new FileOutputStream(target);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = in.read(buf)) != -1) {
				out.write(buf, 0, size);//사이즈 만큼 내보내 주는 역할
				
			}
			
			//정리
			in.close();
			out.close();
			req.getSession().setAttribute("alertMsg", "제품 등록 성공!");
			resp.sendRedirect("/shoekream/admin/product/enroll");
		}catch(Exception e) {
			System.out.println("제품 등록 실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "제품 등록 실패");
		}
		
	}
}
