package com.shoekream.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoekream.admin.vo.EnrollProductVo;
import com.shoekream.biddingVo.BiddingVo;
import com.shoekream.product.service.ProductDetailService;

@WebServlet("/product/detail")
public class ProductDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//modelNumber 가져오기
			String modelNumber = req.getParameter("modelNumber");
			
			ProductDetailService ps = new ProductDetailService();
			
			
			
			//PRODUCTS테이블 쪽 데이터(bidding을 위해 productNo도 가져옴)
			EnrollProductVo productDetailVo = ps.getProductDetail(modelNumber);
			if(productDetailVo == null) {
				throw new Exception("상품 상세조회 중 에러 발생");
			}
			productDetailVo.setModelNumber(modelNumber);
			// 제품번호(PRODUCTS테이블의 NO)를 넘겨서 그에 해당하는 사이즈를 가져오기위해 PRODUCT_SIZES테이블에 접근해서
			// 해당 제품이 가질 수 있는 SHOES_SIZES_NO의 배열을 가져오고 SHOES_SIZES테이블에서 배열 원소에 해당하는 사이즈 값을 반환
			List<EnrollProductVo> shoesSizesList = new ArrayList<EnrollProductVo>();
			shoesSizesList = ps.getShoesSizesDetail(productDetailVo);
			System.out.println(shoesSizesList);
			//BIDDING 테이블 쪽 데이터
			List<BiddingVo> biddingList = ps.getBiddingDetail(productDetailVo.getProductNo());
//			가져온걸 담아주기
			//즉시구매가 가져오기..
			String immediatelyBuyingPrice = ps.getBuyingPrice(productDetailVo.getProductNo());
			//즉시판매가 가져오기..
			String immediatelySellingPrice = ps.getSellingPrice(productDetailVo.getProductNo());
			
			//구매입찰목록 가져오기
			List<BiddingVo> buyBiddingLIst = ps.getBuyBiddingList(productDetailVo.getProductNo());
			List<BiddingVo> sellBiddingLIst = ps.getSellBiddingList(productDetailVo.getProductNo());
			//판매입찰목록 가져오기
//			PRODUCTS테이블
			req.setAttribute("productDetailVo", productDetailVo);
			//SHOES_SIZES테이블
			req.setAttribute("shoesSizesList", shoesSizesList);
			//BIDDING테이블
			req.setAttribute("biddingList", biddingList);
			//구매입찰목록
			req.setAttribute("buyBiddingList", buyBiddingLIst);
			//판매입찰목록
			req.setAttribute("sellBiddingList", sellBiddingLIst);
			
			//즉시구매가 담아주기
			req.setAttribute("buyingPrice", immediatelyBuyingPrice);
			//즉시판매가 담아주기
			req.setAttribute("sellingPrice", immediatelySellingPrice);
			req.getRequestDispatcher("/WEB-INF/views/product/detail.jsp").forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
