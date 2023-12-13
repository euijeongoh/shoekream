package com.shoekream.mypage.vo;

public class OrderDetailVo {
	
	private String productImg;
	private String modelNumber;
	private String productName;
	private String productNameKo;
	private String productSize;
	private String orderStatus;
	private String bidPrice;
	private String finalPrice;
	private String commission;
	
	private String addressName;
	private String phone;
	private String address;
	private String detailAddress;
	private String cardCompany;
	private String cardNumber;
	public OrderDetailVo() {
		
	}
	public OrderDetailVo(String productImg, String modelNumber, String productName, String productNameKo,
			String productSize, String orderStatus, String bidPrice, String finalPrice, String commission,
			String addressName, String phone, String address, String detailAddress, String cardCompany,
			String cardNumber) {
		super();
		this.productImg = productImg;
		this.modelNumber = modelNumber;
		this.productName = productName;
		this.productNameKo = productNameKo;
		this.productSize = productSize;
		this.orderStatus = orderStatus;
		this.bidPrice = bidPrice;
		this.finalPrice = finalPrice;
		this.commission = commission;
		this.addressName = addressName;
		this.phone = phone;
		this.address = address;
		this.detailAddress = detailAddress;
		this.cardCompany = cardCompany;
		this.cardNumber = cardNumber;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKo() {
		return productNameKo;
	}
	public void setProductNameKo(String productNameKo) {
		this.productNameKo = productNameKo;
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
	public String getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getCardCompany() {
		return cardCompany;
	}
	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Override
	public String toString() {
		return "OrderDetailVo [productImg=" + productImg + ", modelNumber=" + modelNumber + ", productName="
				+ productName + ", productNameKo=" + productNameKo + ", productSize=" + productSize + ", orderStatus="
				+ orderStatus + ", bidPrice=" + bidPrice + ", finalPrice=" + finalPrice + ", commission=" + commission
				+ ", addressName=" + addressName + ", phone=" + phone + ", address=" + address + ", detailAddress="
				+ detailAddress + ", cardCompany=" + cardCompany + ", cardNumber=" + cardNumber + "]";
	}
	
	
	
}
