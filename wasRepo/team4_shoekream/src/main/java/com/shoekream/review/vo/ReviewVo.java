package com.shoekream.review.vo;

import java.util.ArrayList;
import java.util.List;

public class ReviewVo {
	
	private String no;
	private String memberNo;
	private String memberNick;
	private String reviewNo;
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
//	private String 

	
	private String imageNo;
	private String reviewImageNo;
	private String filePath;
	private String thumbnailYn;
	
	private List<ReviewImageVo> reviewImageVoList = new ArrayList<ReviewImageVo>();	//여기다가 attachment를 담아주면 됨 (attachment 변수를 만든 것)
	private ReviewImageVo thumbnailVo;
	public ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewVo(String no, String memberNo, String memberNick, String reviewNo, String productNo, String comfortNo,
			String fiveStarRating, String content, String likeBtn, String enrollDate, String modifyDate, String delYN,
			String reviewImage, String profileImage, String imageNo, String reviewImageNo, String filePath,
			String thumbnailYn, List<ReviewImageVo> reviewImageVoList, ReviewImageVo thumbnailVo) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.reviewNo = reviewNo;
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
		this.imageNo = imageNo;
		this.reviewImageNo = reviewImageNo;
		this.filePath = filePath;
		this.thumbnailYn = thumbnailYn;
		this.reviewImageVoList = reviewImageVoList;
		this.thumbnailVo = thumbnailVo;
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
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
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
	public List<ReviewImageVo> getReviewImageVoList() {
		return reviewImageVoList;
	}
	public void setReviewImageVoList(List<ReviewImageVo> reviewImageVoList) {
		this.reviewImageVoList = reviewImageVoList;
	}
	public ReviewImageVo getThumbnailVo() {
		return thumbnailVo;
	}
	public void setThumbnailVo(ReviewImageVo thumbnailVo) {
		this.thumbnailVo = thumbnailVo;
	}
	@Override
	public String toString() {
		return "ReviewVo [no=" + no + ", memberNo=" + memberNo + ", memberNick=" + memberNick + ", reviewNo=" + reviewNo
				+ ", productNo=" + productNo + ", comfortNo=" + comfortNo + ", fiveStarRating=" + fiveStarRating
				+ ", content=" + content + ", likeBtn=" + likeBtn + ", enrollDate=" + enrollDate + ", modifyDate="
				+ modifyDate + ", delYN=" + delYN + ", reviewImage=" + reviewImage + ", profileImage=" + profileImage
				+ ", imageNo=" + imageNo + ", reviewImageNo=" + reviewImageNo + ", filePath=" + filePath
				+ ", thumbnailYn=" + thumbnailYn + ", reviewImageVoList=" + reviewImageVoList + ", thumbnailVo="
				+ thumbnailVo + "]";
	}
	
	
	
	
	
	

}
