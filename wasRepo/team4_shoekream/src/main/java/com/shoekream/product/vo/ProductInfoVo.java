package com.shoekream.product.vo;

public class ProductInfoVo {
	
	private String brandName;
	private String productName;
	private String productKoName;
	private String immediatePrice;
	public ProductInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductInfoVo(String brandName, String productName, String productKoName, String immediatePrice) {
		super();
		this.brandName = brandName;
		this.productName = productName;
		this.productKoName = productKoName;
		this.immediatePrice = immediatePrice;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductKoName() {
		return productKoName;
	}
	public void setProductKoName(String productKoName) {
		this.productKoName = productKoName;
	}
	public String getImmediatePrice() {
		return immediatePrice;
	}
	public void setImmediatePrice(String immediatePrice) {
		this.immediatePrice = immediatePrice;
	}
	@Override
	public String toString() {
		return "ProductInfoVo [brandName=" + brandName + ", productName=" + productName + ", productKoName="
				+ productKoName + ", immediatePrice=" + immediatePrice + "]";
	}
	

	
}
