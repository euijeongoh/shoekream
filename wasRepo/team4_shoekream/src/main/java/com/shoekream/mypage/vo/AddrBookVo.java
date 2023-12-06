package com.shoekream.mypage.vo;

public class AddrBookVo {

	private String no;
	private String memberNo;
	private String memberName;
	private String addersName;
	private String addres;
	private String detailAddres;
	private String phoneNumber;
	private String postCode;
	private String defaultAddrYn;
	private String delYn;
	private String enrollDate;

	public AddrBookVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddrBookVo(String no, String memberNo, String memberName, String addersName, String addres,
			String detailAddres, String phoneNumber, String postCode, String defaultAddrYn, String delYn,
			String enrollDate) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.addersName = addersName;
		this.addres = addres;
		this.detailAddres = detailAddres;
		this.phoneNumber = phoneNumber;
		this.postCode = postCode;
		this.defaultAddrYn = defaultAddrYn;
		this.delYn = delYn;
		this.enrollDate = enrollDate;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getAddersName() {
		return addersName;
	}

	public void setAddersName(String addersName) {
		this.addersName = addersName;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getDetailAddres() {
		return detailAddres;
	}

	public void setDetailAddres(String detailAddres) {
		this.detailAddres = detailAddres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getDefaultAddrYn() {
		return defaultAddrYn;
	}

	public void setDefaultAddrYn(String defaultAddrYn) {
		this.defaultAddrYn = defaultAddrYn;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "AddrBookVo [no=" + no + ", memberNo=" + memberNo + ", memberName=" + memberName + ", addersName="
				+ addersName + ", addres=" + addres + ", detailAddres=" + detailAddres + ", phoneNumber=" + phoneNumber
				+ ", postCode=" + postCode + ", defaultAddrYn=" + defaultAddrYn + ", delYn=" + delYn + ", enrollDate="
				+ enrollDate + "]";
	}

}
