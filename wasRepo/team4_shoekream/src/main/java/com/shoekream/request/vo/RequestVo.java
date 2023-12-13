package com.shoekream.request.vo;

public class RequestVo {

	private String no;
	private String managerNo;
	private String memberNo;
	private String memberNick;
	private String title;
	private String content;
	private String enrollDate;
	private String hit;
	private String replyTitle;
	private String replyContent;
	private String replyEnrollDate;
	public RequestVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestVo(String no, String managerNo, String memberNo, String memberNick, String title, String content,
			String enrollDate, String hit, String replyTitle, String replyContent, String replyEnrollDate) {
		super();
		this.no = no;
		this.managerNo = managerNo;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.hit = hit;
		this.replyTitle = replyTitle;
		this.replyContent = replyContent;
		this.replyEnrollDate = replyEnrollDate;
	}
	public final String getNo() {
		return no;
	}
	public final void setNo(String no) {
		this.no = no;
	}
	public final String getManagerNo() {
		return managerNo;
	}
	public final void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}
	public final String getMemberNo() {
		return memberNo;
	}
	public final void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public final String getMemberNick() {
		return memberNick;
	}
	public final void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final String getEnrollDate() {
		return enrollDate;
	}
	public final void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public final String getHit() {
		return hit;
	}
	public final void setHit(String hit) {
		this.hit = hit;
	}
	public final String getReplyTitle() {
		return replyTitle;
	}
	public final void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}
	public final String getReplyContent() {
		return replyContent;
	}
	public final void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public final String getReplyEnrollDate() {
		return replyEnrollDate;
	}
	public final void setReplyEnrollDate(String replyEnrollDate) {
		this.replyEnrollDate = replyEnrollDate;
	}
	@Override
	public String toString() {
		return "QnaVo [no=" + no + ", managerNo=" + managerNo + ", memberNo=" + memberNo + ", memberNick=" + memberNick
				+ ", title=" + title + ", content=" + content + ", enrollDate=" + enrollDate + ", hit=" + hit
				+ ", replyTitle=" + replyTitle + ", replyContent=" + replyContent + ", replyEnrollDate="
				+ replyEnrollDate + "]";
	}
	
}