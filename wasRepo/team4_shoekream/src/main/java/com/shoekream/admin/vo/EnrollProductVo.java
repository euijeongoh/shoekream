package com.shoekream.admin.vo;

import java.util.Arrays;

public class EnrollProductVo {
	private String productNo;
	private String brand;
	private String category;
	private String productName;
	private String productNameKo;
	private String modelNumber;
	private String releasePrice;
	private String releaseDate;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	private String categoryNo;
	private String brandNo;
	private String[] sizeNo;
	private String[] size;
	private String sizeStr;
	private String sizeNoStr;
	public EnrollProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EnrollProductVo [productNo=" + productNo + ", brand=" + brand + ", category=" + category
				+ ", productName=" + productName + ", productNameKo=" + productNameKo + ", modelNumber=" + modelNumber
				+ ", releasePrice=" + releasePrice + ", releaseDate=" + releaseDate + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", delYn=" + delYn + ", categoryNo=" + categoryNo + ", brandNo="
				+ brandNo + ", sizeNo=" + Arrays.toString(sizeNo) + ", size=" + Arrays.toString(size) + ", sizeStr="
				+ sizeStr + ", sizeNoStr=" + sizeNoStr + "]";
	}
	public EnrollProductVo(String productNo, String brand, String category, String productName, String productNameKo,
			String modelNumber, String releasePrice, String releaseDate, String enrollDate, String modifyDate,
			String delYn, String categoryNo, String brandNo, String[] sizeNo, String[] size, String sizeStr,
			String sizeNoStr) {
		super();
		this.productNo = productNo;
		this.brand = brand;
		this.category = category;
		this.productName = productName;
		this.productNameKo = productNameKo;
		this.modelNumber = modelNumber;
		this.releasePrice = releasePrice;
		this.releaseDate = releaseDate;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
		this.categoryNo = categoryNo;
		this.brandNo = brandNo;
		this.sizeNo = sizeNo;
		this.size = size;
		this.sizeStr = sizeStr;
		this.sizeNoStr = sizeNoStr;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getReleasePrice() {
		return releasePrice;
	}
	public void setReleasePrice(String releasePrice) {
		this.releasePrice = releasePrice;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getBrandNo() {
		return brandNo;
	}
	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}
	public String[] getSizeNo() {
		return sizeNo;
	}
	public void setSizeNo(String[] sizeNo) {
		if(sizeNo == null) {
			this.sizeNoStr = ""	;
			return;
		}
		this.sizeNo = sizeNo;
		this.sizeNoStr = String.join(",", sizeNo);
	}
	public String[] getSize() {
		return size;
	}
	public void setSize(String[] size) {
		if(size == null) {
			this.sizeStr = "";
			return;
		}
		this.size = size;
		this.sizeStr = String.join(",", size);
	}
	public String getSizeStr() {
		if(size == null) {
			return "";
		}
		return String.join(",", size);
	}
	public void setSizeStr(String sizeStr) {
		this.sizeStr = sizeStr;
	}
	public String getSizeNoStr() {
		if(sizeNo == null) {
			return "";
		}
		return String.join(",", sizeNo);
	}
	public void setSizeNoStr(String sizeNoStr) {
		this.sizeNoStr = sizeNoStr;
	}
	
	
	
	
}
