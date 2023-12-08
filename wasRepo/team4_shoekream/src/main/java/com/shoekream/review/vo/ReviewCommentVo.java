package com.shoekream.review.vo;

public class ReviewCommentVo {

	private String no;
	private String memberNo;
	private String reviewNo;
	private String content;
	private String likeBtn;
	private String profileImage;
	
	
	public ReviewCommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewCommentVo(String no, String memberNo, String reviewNo, String content, String likeBtn,
			String profileImage) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.reviewNo = reviewNo;
		this.content = content;
		this.likeBtn = likeBtn;
		this.profileImage = profileImage;
	}
	@Override
	public String toString() {
		return "ReviewCommentVo [no=" + no + ", memberNo=" + memberNo + ", reviewNo=" + reviewNo + ", content="
				+ content + ", likeBtn=" + likeBtn + ", profileImage=" + profileImage + "]";
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
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
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
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
}
