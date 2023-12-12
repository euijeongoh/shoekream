package com.shoekream.review.vo;

public class ReviewProductVo {
	private String productNo;
	private String category;
	private String reviewNo;
	private String productName;
	private String productNameko;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	private String categoryNo;
	private String brandNo;
	
	
	public ReviewProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewProductVo(String productNo, String category, String reviewNo, String productName, String productNameko,
			String enrollDate, String modifyDate, String delYn, String categoryNo, String brandNo) {
		super();
		this.productNo = productNo;
		this.category = category;
		this.reviewNo = reviewNo;
		this.productName = productName;
		this.productNameko = productNameko;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
		this.categoryNo = categoryNo;
		this.brandNo = brandNo;
	}
	@Override
	public String toString() {
		return "ReviewProductVo [productNo=" + productNo + ", category=" + category + ", reviewNo=" + reviewNo
				+ ", productName=" + productName + ", productNameko=" + productNameko + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", delYn=" + delYn + ", categoryNo=" + categoryNo + ", brandNo="
				+ brandNo + "]";
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameko() {
		return productNameko;
	}
	public void setProductNameko(String productNameko) {
		this.productNameko = productNameko;
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

	
	

}
