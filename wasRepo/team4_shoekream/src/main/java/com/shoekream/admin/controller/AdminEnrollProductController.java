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
			req.setCharacterEncoding("UTF-8");
			Part f = req.getPart("f");
			
			InputStream in = f.getInputStream();
			//내보내기 준비
			String sep = File.separator;
			String path = req.getServletContext().getRealPath(sep + "resources"+sep + "img"+sep+"product");
			
			String randomName = System.currentTimeMillis()+"_"+UUID.randomUUID();
			//원본파일명
			String submittedFileName = f.getSubmittedFileName();//f를 통해 제출된파일이름 가져오기
			//
			int index = submittedFileName.lastIndexOf(".");
			String ext = submittedFileName.substring(index);//원본 파일명에서 마지막글자 몇개,,,,"."뒤에 있는 글자들이 확장자가 될 것임
					//서브스트링으로 자르기 ->점찍힌 위치를 넣어줌 근데 뒤에서부터 탐색하니까 indexOf보단 
			String fileName = sep+ randomName + ext;
			
//			String fileName = sep+"abc.png";//저장 시 이 이름으로 저장/ 제출 된 그대로 저장하면 동일한 파일명으로 지정되서 다른사람이 같은이름으로 제출 시 덮어쓰기 됨
			//중복되지않을 랜덤한 파일명으로 해야겠지? 
			//sep+중복되지않는랜덤값+확장자 이렇게..
			
			File target = new File(path+fileName);
			FileOutputStream out = new FileOutputStream(target);
			
//			int data = 0;
//			while((data = in.read()) != -1) {
//				out.write(data);
//			}//하나읽고 내보내고 계속 반복
			//천글자 읽고 천글자 내보내기 어떰?
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = in.read(buf)) != -1) {
				//읽어온걸 바이트 배열에 담아주기;//내가 몇글자를 읽었는지 사이즈를 리턴해줌 읽을 게 없으면 -1리턴함
				out.write(buf, 0, size);//사이즈 만큼 내보내 주는 역할
				
			}
			
			//정리
			in.close();
			out.close();
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
			
			req.getSession().setAttribute("alertMsg", "제품 등록 성공!");
			resp.sendRedirect("/shoekream/admin/product/enroll");
		}catch(Exception e) {
			System.out.println("제품 등록 실패");
			e.printStackTrace();
			req.setAttribute("errorMsg", "제품 등록 실패");
		}
		
	}
}
