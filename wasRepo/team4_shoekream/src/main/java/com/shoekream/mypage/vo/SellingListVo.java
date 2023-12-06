package com.shoekream.mypage.vo;

public class SellingListVo {
	
	// 공통
	private String productName;
	private String productImg;
	private String productSize;
	
	// 판매입찰
	private int bidPrice;
	private String bidStatus;
	private String bidExpireDate;
	private String bidEnrollDate;
	
	// 거래
	private int orderPrice; // 거래금액
	private int finalPrice; // 정산금액(판매자 수수료 5%)
	private String orderStatus;
	private String orderDate;
	
	
	public SellingListVo() {
		
	}


	public SellingListVo(int cntAll, int cntBidding, int cntPending, int cntFinished, String productName,
			String productImg, String productSize, int bidPrice, String bidStatus, String bidExpireDate,
			String bidEnrollDate, int orderPrice, int finalPrice, String orderStatus, String orderDate) {
		super();
		this.productName = productName;
		this.productImg = productImg;
		this.productSize = productSize;
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.bidExpireDate = bidExpireDate;
		this.bidEnrollDate = bidEnrollDate;
		this.orderPrice = orderPrice;
		this.finalPrice = finalPrice;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
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


	public int getBidPrice() {
		return bidPrice;
	}


	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}


	public String getBidStatus() {
		return bidStatus;
	}


	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}


	public String getBidExpireDate() {
		return bidExpireDate;
	}


	public void setBidExpireDate(String bidExpireDate) {
		this.bidExpireDate = bidExpireDate;
	}


	public String getBidEnrollDate() {
		return bidEnrollDate;
	}


	public void setBidEnrollDate(String bidEnrollDate) {
		this.bidEnrollDate = bidEnrollDate;
	}


	public int getOrderPrice() {
		return orderPrice;
	}


	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}


	public int getFinalPrice() {
		return finalPrice;
	}


	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
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


	@Override
	public String toString() {
		return "SellingListVo [productName=" + productName + ", productImg=" + productImg
				+ ", productSize=" + productSize + ", bidPrice=" + bidPrice + ", bidStatus=" + bidStatus
				+ ", bidExpireDate=" + bidExpireDate + ", bidEnrollDate=" + bidEnrollDate + ", orderPrice=" + orderPrice
				+ ", finalPrice=" + finalPrice + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
	}
	
	
	
	
	
}
