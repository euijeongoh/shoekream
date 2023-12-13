package com.shoekream.mypage.vo;


public class BiddingHistoryVo {

	private String biddingNo;
	private String memberNo;
	private String productNo;
	private String productName;
	private String productImg;
	private String productSizeNo;
	private String productSize;
	private String bidPrice;
	private String bidStatus;
	private String bidEnrollDate;
	private String bidExpireDate;
	
	public BiddingHistoryVo() {
		
	}

	public BiddingHistoryVo(String biddingNo, String memberNo, String productNo, String productName, String productImg,
			String productSizeNo, String productSize, String bidPrice, String bidStatus, String bidEnrollDate,
			String bidExpireDate) {
		super();
		this.biddingNo = biddingNo;
		this.memberNo = memberNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productImg = productImg;
		this.productSizeNo = productSizeNo;
		this.productSize = productSize;
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.bidEnrollDate = bidEnrollDate;
		this.bidExpireDate = bidExpireDate;
	}

	public String getBiddingNo() {
		return biddingNo;
	}

	public void setBiddingNo(String biddingNo) {
		this.biddingNo = biddingNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductSizeNo() {
		return productSizeNo;
	}

	public void setProductSizeNo(String productSizeNo) {
		this.productSizeNo = productSizeNo;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public String getBidEnrollDate() {
		return bidEnrollDate;
	}

	public void setBidEnrollDate(String bidEnrollDate) {
		this.bidEnrollDate = bidEnrollDate;
	}

	public String getBidExpireDate() {
		return bidExpireDate;
	}

	public void setBidExpireDate(String bidExpireDate) {
		this.bidExpireDate = bidExpireDate;
	}

	@Override
	public String toString() {
		return "BiddingHistoryVo [biddingNo=" + biddingNo + ", memberNo=" + memberNo + ", productNo=" + productNo
				+ ", productName=" + productName + ", productImg=" + productImg + ", productSizeNo=" + productSizeNo
				+ ", productSize=" + productSize + ", bidPrice=" + bidPrice + ", bidStatus=" + bidStatus
				+ ", bidEnrollDate=" + bidEnrollDate + ", bidExpireDate=" + bidExpireDate + "]";
	}

	
	
	
}
