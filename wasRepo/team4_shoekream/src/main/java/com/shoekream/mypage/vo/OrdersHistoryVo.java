package com.shoekream.mypage.vo;

import java.util.List;

import com.shoekream.orders.vo.OrdersVo;

public class OrdersHistoryVo {
	
	// fields
	private String productName;
	private String productImg;
	private String productSize;
	private String orderStatus;
	private String orderDate;
	private String finalPrice;
	
	// constructor
	public OrdersHistoryVo() {
		
	}

	public OrdersHistoryVo(String productName, String productImg, String productSize, String orderStatus,
			String orderDate, String finalPrice) {
		super();
		this.productName = productName;
		this.productImg = productImg;
		this.productSize = productSize;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.finalPrice = finalPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "OrdersHistoryVo [productName=" + productName + ", productImg=" + productImg + ", productSize="
				+ productSize + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", finalPrice="
				+ finalPrice + "]";
	}

	
	
}
