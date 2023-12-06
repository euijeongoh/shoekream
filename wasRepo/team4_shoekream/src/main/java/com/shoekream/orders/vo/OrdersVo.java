package com.shoekream.orders.vo;

public class OrdersVo {

	private String no;
	private String memberNo;
		private String memberName;
	private String ordersStatusNo;
		private String ordersStatus;
	private String biddingNo;
	private String productNo;
		private String productName;
	private String inspectionNo;
		private String inspection;
	private String ordersDate;
	private String paymentType;
	private String paymentDate;
	private String storageDate;
	private String checkDate;
	private String returnDAte;
	private String sendDate;
	private String totalPrice;
	public OrdersVo() {
	}
	public OrdersVo(String no, String memberNo, String memberName, String ordersStatusNo, String ordersStatus,
			String biddingNo, String productNo, String productName, String inspectionNo, String inspection,
			String ordersDate, String paymentType, String paymentDate, String storageDate, String checkDate,
			String returnDAte, String sendDate, String totalPrice) {
		this.no = no;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.ordersStatusNo = ordersStatusNo;
		this.ordersStatus = ordersStatus;
		this.biddingNo = biddingNo;
		this.productNo = productNo;
		this.productName = productName;
		this.inspectionNo = inspectionNo;
		this.inspection = inspection;
		this.ordersDate = ordersDate;
		this.paymentType = paymentType;
		this.paymentDate = paymentDate;
		this.storageDate = storageDate;
		this.checkDate = checkDate;
		this.returnDAte = returnDAte;
		this.sendDate = sendDate;
		this.totalPrice = totalPrice;
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
	public String getOrdersStatusNo() {
		return ordersStatusNo;
	}
	public void setOrdersStatusNo(String ordersStatusNo) {
		this.ordersStatusNo = ordersStatusNo;
	}
	public String getOrdersStatus() {
		return ordersStatus;
	}
	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getInspectionNo() {
		return inspectionNo;
	}
	public void setInspectionNo(String inspectionNo) {
		this.inspectionNo = inspectionNo;
	}
	public String getInspection() {
		return inspection;
	}
	public void setInspection(String inspection) {
		this.inspection = inspection;
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
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
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
	public String getReturnDAte() {
		return returnDAte;
	}
	public void setReturnDAte(String returnDAte) {
		this.returnDAte = returnDAte;
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
	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", memberNo=" + memberNo + ", memberName=" + memberName + ", ordersStatusNo="
				+ ordersStatusNo + ", ordersStatus=" + ordersStatus + ", biddingNo=" + biddingNo + ", productNo="
				+ productNo + ", productName=" + productName + ", inspectionNo=" + inspectionNo + ", inspection="
				+ inspection + ", ordersDate=" + ordersDate + ", paymentType=" + paymentType + ", paymentDate="
				+ paymentDate + ", storageDate=" + storageDate + ", checkDate=" + checkDate + ", returnDAte="
				+ returnDAte + ", sendDate=" + sendDate + ", totalPrice=" + totalPrice + "]";
	}
	
}
