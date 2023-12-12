package com.shoekream.request.vo;

public class RequestVo {

		private String no;
		private String memberNo;
		private String title;
		private String content;
		private String enrollDate;
		private String modifyDate;
		private String delYn;
		private String hit;
		public RequestVo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RequestVo(String no, String memberNo, String title, String content, String enrollDate, String modifyDate,
				String delYn, String hit) {
			super();
			this.no = no;
			this.memberNo = memberNo;
			this.title = title;
			this.content = content;
			this.enrollDate = enrollDate;
			this.modifyDate = modifyDate;
			this.delYn = delYn;
			this.hit = hit;
		}
		@Override
		public String toString() {
			return "RequestVo [no=" + no + ", memberNo=" + memberNo + ", title=" + title + ", content=" + content
					+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", delYn=" + delYn + ", hit=" + hit
					+ "]";
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
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
		public String getHit() {
			return hit;
		}
		public void setHit(String hit) {
			this.hit = hit;
		}
		
		
		
		
}
