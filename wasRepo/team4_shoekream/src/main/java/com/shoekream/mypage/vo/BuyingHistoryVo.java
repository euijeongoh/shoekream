package com.shoekream.mypage.vo;

public class BuyingHistoryVo {
	
	// fields
	private String memberNo;
	private String biddingNo;
	private String orderNo;
	private String productNo;
	private String productName;
	private String productImg;
	private String productSize;
	private String orderStatus;
	private String orderDate;
	private String finalPrice;
	
	
	public BuyingHistoryVo() {
		
	}


	public BuyingHistoryVo(String memberNo, String biddingNo, String orderNo, String productNo, String productName,
			String productImg, String productSize, String orderStatus, String orderDate, String finalPrice) {
		super();
		this.memberNo = memberNo;
		this.biddingNo = biddingNo;
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productImg = productImg;
		this.productSize = productSize;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.finalPrice = finalPrice;
	}


	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public String getBiddingNo() {
		return biddingNo;
	}


	public void setBiddingNo(String biddingNo) {
		this.biddingNo = biddingNo;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public String getProductNo() {
		return productNo;
	}


	public void setProductNo(String productNo) {
		this.productNo = productNo;
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
		return "BuyingHistoryVo [memberNo=" + memberNo + ", biddingNo=" + biddingNo + ", orderNo=" + orderNo
				+ ", productNo=" + productNo + ", productName=" + productName + ", productImg=" + productImg
				+ ", productSize=" + productSize + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", finalPrice=" + finalPrice + "]";
	}
	
	
	
}
