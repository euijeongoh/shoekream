package com.shoekream.qna.vo;

public class QnaVo {

	private String no;
	private String managerNo;
	private String memberNo;
	private String memberNick;
	private String title;
	private String content;
	private String enrollDate;
	private String hit;
	private String reply;
	private String replyEnrollDate;
	public QnaVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaVo(String no, String managerNo, String memberNo, String memberNick, String title, String content,
			String enrollDate, String hit, String reply, String replyEnrollDate) {
		super();
		this.no = no;
		this.managerNo = managerNo;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.hit = hit;
		this.reply = reply;
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
	public final String getReply() {
		return reply;
	}
	public final void setReply(String reply) {
		this.reply = reply;
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
				+ ", reply=" + reply + ", replyEnrollDate=" + replyEnrollDate + "]";
	}

}