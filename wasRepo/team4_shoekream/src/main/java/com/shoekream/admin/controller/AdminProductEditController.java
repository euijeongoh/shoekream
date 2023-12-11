package com.shoekream.admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shoekream.admin.service.AdminProductListService;
import com.shoekream.admin.vo.EnrollProductVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 *10,//파일 하나당 크기	
		maxRequestSize = 1024 * 1024 * 50//리퀘스트 전체 크기

)

@WebServlet("/admin/product/edit/modelNumber")
public class AdminProductEditController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
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
			//modelNumber 가져오기(data)
			String modelNumber = req.getParameter("modelNumber");
			//가져온 modelNumber를 담아줄 객체 생성
			EnrollProductVo vo = new EnrollProductVo();
			vo.setModelNumber(modelNumber);
			//service
			AdminProductListService ps = new AdminProductListService();
			
			//service에서 가져온 정보를 담아줄 객체 생성
			EnrollProductVo dbVo = ps.getProductInfo(modelNumber);
			if(dbVo == null) {
				throw new Exception();
			}
			//PRODUCT_SIZES TABLE에서 가져올 사이즈배열을 담아줄 객체 생성
			List<String> sizes = ps.getProductSizesInfo(dbVo.getProductNo());
			//dbVo를 통해 브랜드명과 카테고리명을 가져올 객체 생성
			EnrollProductVo categoryVo = ps.getProductCategoryInfo(dbVo.getCategoryNo());
			EnrollProductVo brandVo = ps.getProductBrandInfo(dbVo.getBrandNo());
			
			
			req.setAttribute("dbVo", dbVo);
			req.setAttribute("sizes", sizes);
			req.setAttribute("categoryVo", categoryVo);
			req.setAttribute("brandVo", brandVo);
			
			req.getRequestDispatcher("/WEB-INF/views/admin/product/edit.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "상품정보 수정 중 에러 발생");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
		
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
}
