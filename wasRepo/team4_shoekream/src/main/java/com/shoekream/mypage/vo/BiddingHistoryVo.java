package com.shoekream.mypage.vo;


public class BiddingHistoryVo {

	private String shoeName;
	private String shoeImg;
	private String shoeSize;
	private String bidPrice;
	private String bidStatus;
	private String expireDate;
	private String enrollDate;
	
	public BiddingHistoryVo() {
		
	}
	
	public BiddingHistoryVo(String shoeName, String shoeImg, String shoeSize, String bidPrice, String bidStatus,
			String expireDate, String enrollDate) {
		super();
		this.shoeName = shoeName;
		this.shoeImg = shoeImg;
		this.shoeSize = shoeSize;
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.expireDate = expireDate;
		this.enrollDate = enrollDate;
	}
	
	public String getShoeName() {
		return shoeName;
	}
	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}
	public String getShoeImg() {
		return shoeImg;
	}
	public void setShoeImg(String shoeImg) {
		this.shoeImg = shoeImg;
	}
	public String getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(String shoeSize) {
		this.shoeSize = shoeSize;
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
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	@Override
	public String toString() {
		return "BiddingHistoryVo [shoeName=" + shoeName + ", shoeImg=" + shoeImg + ", shoeSize=" + shoeSize
				+ ", bidPrice=" + bidPrice + ", bidStatus=" + bidStatus + ", expireDate=" + expireDate + ", enrollDate="
				+ enrollDate + "]";
	}
	
	
}
