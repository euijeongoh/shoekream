package com.shoekream.request.vo;

public class RequestVo {

	private String no;
	private String memberNo;
	private String memberNick;
	private String title;
	private String content;
	private String enrollDate;
	private String hit;
	public RequestVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestVo(String no, String memberNo, String memberNick, String title, String content, String enrollDate,
			String hit) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.hit = hit;
	}
	public final String getNo() {
		return no;
	}
	public final void setNo(String no) {
		this.no = no;
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
	@Override
	public String toString() {
		return "RequestVo [no=" + no + ", memberNo=" + memberNo + ", memberNick=" + memberNick + ", title=" + title
				+ ", content=" + content + ", enrollDate=" + enrollDate + ", hit=" + hit + "]";
	}
	
	
}