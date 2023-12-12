package com.shoekream.mypage.vo;

public class AccountVo {

	private String no;
	private String memberNo;
	private String bankAgentNo;
	private String bankAgentName;
	private String accountNumber;
	private String depositor;
	private String enrollDate;

	public AccountVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountVo(String no, String memberNo, String bankAgentNo, String bankAgentName, String accountNumber,
			String depositor, String enrollDate) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.bankAgentNo = bankAgentNo;
		this.bankAgentName = bankAgentName;
		this.accountNumber = accountNumber;
		this.depositor = depositor;
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

	public String getBankAgentNo() {
		return bankAgentNo;
	}

	public void setBankAgentNo(String bankAgentNo) {
		this.bankAgentNo = bankAgentNo;
	}

	public String getBankAgentName() {
		return bankAgentName;
	}

	public void setBankAgentName(String bankAgentName) {
		this.bankAgentName = bankAgentName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "AccountVo [no=" + no + ", memberNo=" + memberNo + ", bankAgentNo=" + bankAgentNo + ", bankAgentName="
				+ bankAgentName + ", accountNumber=" + accountNumber + ", depositor=" + depositor + ", enrollDate="
				+ enrollDate + "]";
	}

}
