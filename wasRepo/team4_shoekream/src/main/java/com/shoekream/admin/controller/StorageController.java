package com.shoekream.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.service.OrdersService;
import com.shoekream.admin.vo.OrdersVo;
import com.shoekream.page.vo.PageVo;

@WebServlet("/admin/order/storage/list")
public class StorageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			OrdersService os = new OrdersService();
			
			//date
			int listCount = os.selectOrdersCount();				//전체 게시글 개수
			String currentPage_ = req.getParameter("pno");
			if(currentPage_ == null){
				currentPage_ = "1";
			}
			int currentPage = Integer.parseInt(currentPage_);	//현제페이지
			int pageLimit = 5;			// 개발자 맘대로
			int boardLimit = 10;		// 개발자 맘대로
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			//service
			List<OrdersVo> OrderVoList =  os.selectOrderList(pvo);
			
			//result
			req.setAttribute("OrderVoList", OrderVoList);
			req.setAttribute("pvo" , pvo);
			req.getRequestDispatcher("/WEB-INF/views/admin/order/list/storage.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("[ERROR-B001]게시글 목록 조회 중 에러 발생");
			e.printStackTrace();
		}
		
	}

}
