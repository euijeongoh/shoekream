package com.shoekream.mypage.vo;

public class BuyingListVo {
	// 공통
	private String productName;
	private String productImg;
	private String productSize;
	
	// 구매입찰
	private int bidPrice;
	private String bidStatus;
	private String bidExpireDate;
	private String bidEnrollDate;
	
	// 주문
	private int orderPrice; // 주문금액
	private int finalPrice; // 결제금액(구매자 수수료 3%, 배송비 3000원)
	private String orderStatus;
	private String orderDate;
	
	
	public BuyingListVo() {
		
	}


	public BuyingListVo(String productName, String productImg, String productSize, int bidPrice, String bidStatus,
			String bidExpireDate, String bidEnrollDate, int orderPrice, int finalPrice, String orderStatus,
			String orderDate) {
		super();
		this.productName = productName;
		this.productImg = productImg;
		this.productSize = productSize;
		
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.bidExpireDate = bidExpireDate;
		this.bidEnrollDate = bidEnrollDate;
		
		this.orderPrice = orderPrice;
		this.finalPrice = (int)(orderPrice + orderPrice*0.3+3000);
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}
	
	
	
	
}
