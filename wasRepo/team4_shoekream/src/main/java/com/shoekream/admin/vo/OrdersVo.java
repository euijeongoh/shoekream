package com.shoekream.admin.vo;

public class OrdersVo {

	private String no;
	private String memberNo;
	private String ordersStatusNo;
	private String biddingNo;
	private String productNo;
	private String inspectionNo;
	private String ordersDate;
	private String paymentType;
	private String paymentdate;
	private String storageDate;
	private String checkDate;
	private String returnDate;
	private String sendDate;
	private String totalPrice;
	private String memberName;
	private String email;
	private String productName;
	private String productNameKo;
	private String price;
	private String checkResult;
	private String ordersStatus;

	public OrdersVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersVo(String no, String memberNo, String ordersStatusNo, String biddingNo, String productNo,
			String inspectionNo, String ordersDate, String paymentType, String paymentdate, String storageDate,
			String checkDate, String returnDate, String sendDate, String totalPrice, String memberName, String email,
			String productName, String productNameKo, String price, String checkResult, String ordersStatus) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.ordersStatusNo = ordersStatusNo;
		this.biddingNo = biddingNo;
		this.productNo = productNo;
		this.inspectionNo = inspectionNo;
		this.ordersDate = ordersDate;
		this.paymentType = paymentType;
		this.paymentdate = paymentdate;
		this.storageDate = storageDate;
		this.checkDate = checkDate;
		this.returnDate = returnDate;
		this.sendDate = sendDate;
		this.totalPrice = totalPrice;
		this.memberName = memberName;
		this.email = email;
		this.productName = productName;
		this.productNameKo = productNameKo;
		this.price = price;
		this.checkResult = checkResult;
		this.ordersStatus = ordersStatus;
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

	public String getOrdersStatusNo() {
		return ordersStatusNo;
	}

	public void setOrdersStatusNo(String ordersStatusNo) {
		this.ordersStatusNo = ordersStatusNo;
	}

	public String getBiddingNo() {
		return biddingNo;
	}

	public void setBiddingNo(String biddingNo) {
		this.biddingNo = biddingNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getInspectionNo() {
		return inspectionNo;
	}

	public void setInspectionNo(String inspectionNo) {
		this.inspectionNo = inspectionNo;
	}

	public String getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(String ordersDate) {
		this.ordersDate = ordersDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(String storageDate) {
		this.storageDate = storageDate;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKo() {
		return productNameKo;
	}

	public void setProductNameKo(String productNameKo) {
		this.productNameKo = productNameKo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", memberNo=" + memberNo + ", ordersStatusNo=" + ordersStatusNo + ", biddingNo="
				+ biddingNo + ", productNo=" + productNo + ", inspectionNo=" + inspectionNo + ", ordersDate="
				+ ordersDate + ", paymentType=" + paymentType + ", paymentdate=" + paymentdate + ", storageDate="
				+ storageDate + ", checkDate=" + checkDate + ", returnDate=" + returnDate + ", sendDate=" + sendDate
				+ ", totalPrice=" + totalPrice + ", memberName=" + memberName + ", email=" + email + ", productName="
				+ productName + ", productNameKo=" + productNameKo + ", price=" + price + ", checkResult=" + checkResult
				+ ", ordersStatus=" + ordersStatus + "]";
	}

}
