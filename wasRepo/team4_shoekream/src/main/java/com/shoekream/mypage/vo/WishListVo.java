package com.shoekream.mypage.vo;

public class WishListVo {

	private String brandName;
	private String productNo;
	private String productName;
	private String modelNumber;
	private String productImg;
	private String immediatePrice;
	
	
	public WishListVo() {
		
	}
	
	
	public WishListVo(String brandName, String productNo, String productName, String modelNumber, String productImg,
			String immediatePrice) {
		super();
		this.brandName = brandName;
		this.productNo = productNo;
		this.productName = productName;
		this.modelNumber = modelNumber;
		this.productImg = productImg;
		this.immediatePrice = immediatePrice;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getImmediatePrice() {
		return immediatePrice;
	}
	public void setImmediatePrice(String immediatePrice) {
		this.immediatePrice = immediatePrice;
	}
	@Override
	public String toString() {
		return "WishListVo [brandName=" + brandName + ", productNo=" + productNo + ", productName=" + productName
				+ ", modelNumber=" + modelNumber + ", productImg=" + productImg + ", immediatePrice=" + immediatePrice
				+ "]";
	}
	
	
}
