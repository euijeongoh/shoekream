package com.shoekream.mypage.vo;

/**
 * 
 */
/**
 * 
 */
public class PayInfoVo {

	private String No;
	private String memberNo;
	private String memberName;
	private String cardCompanyNo;
	private String cardCompanyName;
	private String cardNumber;
	private String noexpirationDate;
	private String cvcNumber;
	private String enrollDate;
	private String delYn;

	public PayInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PayInfoVo(String no, String memberNo, String memberName, String cardCompanyNo, String cardCompanyName,
			String cardNumber, String noexpirationDate, String cvcNumber, String enrollDate, String delYn) {
		super();
		No = no;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.cardCompanyNo = cardCompanyNo;
		this.cardCompanyName = cardCompanyName;
		this.cardNumber = cardNumber;
		this.noexpirationDate = noexpirationDate;
		this.cvcNumber = cvcNumber;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getNoexpirationDate() {
		return noexpirationDate;
	}

	public void setNoexpirationDate(String noexpirationDate) {
		this.noexpirationDate = noexpirationDate;
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
		return "PayInfoVo [No=" + No + ", memberNo=" + memberNo + ", memberName=" + memberName + ", cardCompanyNo="
				+ cardCompanyNo + ", cardCompanyName=" + cardCompanyName + ", cardNumber=" + cardNumber
				+ ", noexpirationDate=" + noexpirationDate + ", cvcNumber=" + cvcNumber + ", enrollDate=" + enrollDate
				+ ", delYn=" + delYn + "]";
	}

}
