package com.shoekream.faq.vo;

public class FaqVo {

	private String no;
	private String managerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String delYn;
	private String hit;
	public FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqVo(String no, String managerNo, String title, String content, String enrollDate, String modifyDate,
			String delYn, String hit) {
		super();
		this.no = no;
		this.managerNo = managerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.delYn = delYn;
		this.hit = hit;
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
	public final String getModifyDate() {
		return modifyDate;
	}
	public final void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public final String getDelYn() {
		return delYn;
	}
	public final void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public final String getHit() {
		return hit;
	}
	public final void setHit(String hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", managerNo=" + managerNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn=" + delYn + ", hit=" + hit
				+ "]";
	}
	

}
