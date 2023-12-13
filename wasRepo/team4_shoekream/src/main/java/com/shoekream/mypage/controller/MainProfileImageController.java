package com.shoekream.mypage.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shoekream.member.MemberVo;
import com.shoekream.mypage.service.MyPageService;

@MultipartConfig(
		maxFileSize = 1024*1024*10,
		maxRequestSize = 1024*1024*10*5
)


@WebServlet("/mypage/profile/upload")

public class MainProfileImageController extends HttpServlet {

	// 프로필 사진 업로드 팝업 띄우기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/my_popup.jsp").forward(req, resp);
		
	}
	
	// 프로필 사진 업로드 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			MemberVo loginMember = (MemberVo) req.getSession().getAttribute("loginMember");
			
			Part f = req.getPart("f");
			
			String fileUrl = null;
			// 읽기 준비
			InputStream in = f.getInputStream();
			
			// 내보내기 준비
			String submittedFileName = f.getSubmittedFileName();
			String ext = submittedFileName.substring(submittedFileName.lastIndexOf("."));
			String sep = File.separator;
			// 경로
			// 새 파일명 지정
			String randomName = loginMember.getId() + "_" + System.currentTimeMillis() + "_" + UUID.randomUUID();
			String path = sep + "resources" + sep + "img" + sep + "profile";
			String realPath = req.getServletContext().getRealPath(path);
			String fileName = sep + randomName + ext;
			
			// 확장자 가져오기
			
			String src = "/shoekream" + path + fileName;
			System.out.println(src);
			
			File target = new File(realPath+fileName);
			FileOutputStream out = new FileOutputStream(target);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while( (size = in.read(buf)) != -1) {
				out.write(buf, 0, size);
			}
				      
			// 정리
			in.close();
			out.close();
			
			// service
			MyPageService service = new MyPageService();
			int result = service.saveImgSrcInDB(loginMember, req, src);
			
			if(result != 1) {
				throw new Exception();
			}
			
			req.getRequestDispatcher("/WEB-INF/views/mypage/my_popup2.jsp").forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
}
