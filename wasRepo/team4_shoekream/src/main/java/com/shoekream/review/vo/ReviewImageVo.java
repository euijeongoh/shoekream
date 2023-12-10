package com.shoekream.review.vo;

public class ReviewImageVo {

	private String imageNo;
	private String reviewImageNo;
	private String productNo;
	private String reviewNo;
	private String filePath;
	private String thumbnailYn;
	public ReviewImageVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewImageVo(String imageNo, String reviewImageNo, String productNo, String reviewNo, String filePath,
			String thumbnailYn) {
		super();
		this.imageNo = imageNo;
		this.reviewImageNo = reviewImageNo;
		this.productNo = productNo;
		this.reviewNo = reviewNo;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
	}
	@Override
	public String toString() {
		return "ReviewImageVo [imageNo=" + imageNo + ", reviewImageNo=" + reviewImageNo + ", productNo=" + productNo
				+ ", reviewNo=" + reviewNo + ", filePath=" + filePath + ", thumbnailYn=" + thumbnailYn + "]";
	}
	public String getImageNo() {
		return imageNo;
	}
	public void setImageNo(String imageNo) {
		this.imageNo = imageNo;
	}
	public String getReviewImageNo() {
		return reviewImageNo;
	}
	public void setReviewImageNo(String reviewImageNo) {
		this.reviewImageNo = reviewImageNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getThumbnailYn() {
		return thumbnailYn;
	}
	public void setThumbnailYn(String thumbnailYn) {
		this.thumbnailYn = thumbnailYn;
	}
	
	
	
	
	
	
}
