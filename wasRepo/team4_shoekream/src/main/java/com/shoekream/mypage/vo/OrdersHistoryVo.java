package com.shoekream.mypage.vo;

import java.util.List;

import com.shoekream.orders.vo.OrdersVo;

public class OrdersHistoryVo {
	
	// fields
	private List<OrdersVo> orderList;
	private HistoryCntVo cntVo;
	
	// constructor
	public OrdersHistoryVo() {
		
	}
	
	

	public OrdersHistoryVo(List<OrdersVo> orderList, HistoryCntVo cntVo) {
		super();
		this.orderList = orderList;
		this.cntVo = cntVo;
	}



	// getter setter
	public List<OrdersVo> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrdersVo> orderList) {
		this.orderList = orderList;
	}

	public HistoryCntVo getCntVo() {
		return cntVo;
	}

	public void setCntVo(HistoryCntVo cntVo) {
		this.cntVo = cntVo;
	}

	// toString
	@Override
	public String toString() {
		return "OrdersHistoryVo [orderList=" + orderList + ", cntVo=" + cntVo + "]";
	}


	
	
	
}
