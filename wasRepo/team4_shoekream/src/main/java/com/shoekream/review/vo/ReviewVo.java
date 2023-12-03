package com.shoekream.review.vo;

public class ReviewVo {
	
	private String no;
	private String memberNo;
	private String productNo;
	private String comfortNo;
	private String fiveStarRating;
	private String content;
	private String likeBtn;
	private String enrollDate;
	private String modifyDate;
	private String delYN;
	private String reviewImage;
	private String profileImage;
	
	
	public ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewVo(String no, String memberNo, String productNo, String comfortNo, String fiveStarRating,
			String content, String likeBtn, String enrollDate, String modifyDate, String delYN, String reviewImage,
			String profileImage) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.productNo = productNo;
		this.comfortNo = comfortNo;
		this.fiveStarRating = fiveStarRating;
		this.content = content;
		this.likeBtn = likeBtn;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYN = delYN;
		this.reviewImage = reviewImage;
		this.profileImage = profileImage;
	}
	@Override
	public String toString() {
		return "ReviewVo [no=" + no + ", memberNo=" + memberNo + ", productNo=" + productNo + ", comfortNo=" + comfortNo
				+ ", fiveStarRating=" + fiveStarRating + ", content=" + content + ", likeBtn=" + likeBtn
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYN=" + delYN + ", reviewImage="
				+ reviewImage + ", profileImage=" + profileImage + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getComfortNo() {
		return comfortNo;
	}
	public void setComfortNo(String comfortNo) {
		this.comfortNo = comfortNo;
	}
	public String getFiveStarRating() {
		return fiveStarRating;
	}
	public void setFiveStarRating(String fiveStarRating) {
		this.fiveStarRating = fiveStarRating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLikeBtn() {
		return likeBtn;
	}
	public void setLikeBtn(String likeBtn) {
		this.likeBtn = likeBtn;
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
	public String getDelYN() {
		return delYN;
	}
	public void setDelYN(String delYN) {
		this.delYN = delYN;
	}
	public String getReviewImage() {
		return reviewImage;
	}
	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
	

	

}
