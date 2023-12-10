package com.shoekream.home.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoekream.db.util.JDBCTemplate;
import com.shoekream.home.dao.HomeDao;
import com.shoekream.product.vo.ProductInfoVo;

public class HomeService {

	public Map<String, Object> getProductLists() throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		//dao
		HomeDao dao = new HomeDao();
		List<ProductInfoVo> recentEnrolledList = dao.getRecentEnrolledProductList(conn);
		List<ProductInfoVo> newImmediatePriceList = dao.getNewImmediatePriceList(conn);
		
		// 가공
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("enrollList", recentEnrolledList);
		listMap.put("immediatePriceList", newImmediatePriceList);
		
		// close
		JDBCTemplate.close(conn);
		
		return listMap;
	}
	
	
	
}
