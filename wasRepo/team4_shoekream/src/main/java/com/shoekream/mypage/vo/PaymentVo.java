package com.shoekream.mypage.vo;

public class PaymentVo {

	private String no;
	private String memberNo;
	private String cardCompanyNo;
	private String cardCompanyName;
	private String cardNumber;
	private String expirationDate;
	private String cvcNumber;
	private String enrollDate;
	private String delYn;

	public PaymentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentVo(String no, String memberNo, String cardCompanyNo, String cardCompanyName, String cardNumber,
			String expirationDate, String cvcNumber, String enrollDate, String delYn) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.cardCompanyNo = cardCompanyNo;
		this.cardCompanyName = cardCompanyName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvcNumber = cvcNumber;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
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

	public String getCardCompanyNo() {
		return cardCompanyNo;
	}

	public void setCardCompanyNo(String cardCompanyNo) {
		this.cardCompanyNo = cardCompanyNo;
	}

	public String getCardCompanyName() {
		return cardCompanyName;
	}

	public void setCardCompanyName(String cardCompanyName) {
		this.cardCompanyName = cardCompanyName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvcNumber() {
		return cvcNumber;
	}

	public void setCvcNumber(String cvcNumber) {
		this.cvcNumber = cvcNumber;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "PaymentVo [no=" + no + ", memberNo=" + memberNo + ", cardCompanyNo=" + cardCompanyNo
				+ ", cardCompanyName=" + cardCompanyName + ", cardNumber=" + cardNumber + ", expirationDate="
				+ expirationDate + ", cvcNumber=" + cvcNumber + ", enrollDate=" + enrollDate + ", delYn=" + delYn + "]";
	}

}
