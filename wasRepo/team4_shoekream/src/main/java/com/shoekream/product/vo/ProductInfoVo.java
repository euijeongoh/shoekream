package com.shoekream.product.vo;

public class ProductInfoVo {
	
	private String productNo;
	private String productName;
	private String productNameKo;
	private String thumbnail;
	private String brandName;
	private String modelName;
	private String size;
	private String immediatePrice;
	private String bidEnrollDate;
	private String productEnrollDate;
	public ProductInfoVo() {
		super();
		// TODO Auto-generated constructor stub
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


	public ProductInfoVo(String productNo, String productName, String productNameKo, String thumbnail, String brandName,
			String modelName, String size, String immediatePrice, String bidEnrollDate, String productEnrollDate) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productNameKo = productNameKo;
		this.thumbnail = thumbnail;
		this.brandName = brandName;
		this.modelName = modelName;
		this.size = size;
		this.immediatePrice = immediatePrice;
		this.bidEnrollDate = bidEnrollDate;
		this.productEnrollDate = productEnrollDate;
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
	public String getProductNameKo() {
		return productNameKo;
	}
	public void setProductNameKo(String productNameKo) {
		this.productNameKo = productNameKo;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
		return "ProductInfoVo [productNo=" + productNo + ", productName=" + productName + ", productNameKo="
				+ productNameKo + ", thumbnail=" + thumbnail + ", brandName=" + brandName + ", modelName=" + modelName
				+ ", size=" + size + ", immediatePrice=" + immediatePrice + ", bidEnrollDate=" + bidEnrollDate
				+ ", productEnrollDate=" + productEnrollDate + "]";
	}
	
	
	

	
	
}
