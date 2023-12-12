package com.shoekream.product.vo;

public class ProductInfoVo {
	
	private String productNo;
	private String productName;
	private String thumbnail;
	private String brandName;
	private String modelName;
	private String immediatePrice;
	private String bidEnrollDate;
	private String productEnrollDate;
	
	public ProductInfoVo() {
		
	}

	public ProductInfoVo(String productNo, String productName, String thumbnail, String brandName, String modelName,
			String immediatePrice, String productEnrollDate) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.thumbnail = thumbnail;
		this.brandName = brandName;
		this.modelName = modelName;
		this.immediatePrice = immediatePrice;
		this.productEnrollDate = productEnrollDate;
	}

	public ProductInfoVo(String productName, String thumbnail, String brandName, String modelName,
			String immediatePrice, String bidEnrollDate) {
		super();
		this.productName = productName;
		this.thumbnail = thumbnail;
		this.brandName = brandName;
		this.modelName = modelName;
		this.immediatePrice = immediatePrice;
		this.bidEnrollDate = bidEnrollDate;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getImmediatePrice() {
		return immediatePrice;
	}

	public void setImmediatePrice(String immediatePrice) {
		this.immediatePrice = immediatePrice;
	}

	public String getBidEnrollDate() {
		return bidEnrollDate;
	}

	public void setBidEnrollDate(String bidEnrollDate) {
		this.bidEnrollDate = bidEnrollDate;
	}

	public String getProductEnrollDate() {
		return productEnrollDate;
	}

	public void setProductEnrollDate(String productEnrollDate) {
		this.productEnrollDate = productEnrollDate;
	}

	@Override
	public String toString() {
		return "ProductInfoVo [productNo=" + productNo + ", productName=" + productName + ", thumbnail=" + thumbnail
				+ ", brandName=" + brandName + ", modelName=" + modelName + ", immediatePrice=" + immediatePrice
				+ ", bidEnrollDate=" + bidEnrollDate + ", productEnrollDate=" + productEnrollDate + "]";
	}

	

	
	
}
