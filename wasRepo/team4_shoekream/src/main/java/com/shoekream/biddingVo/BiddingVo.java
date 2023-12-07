package com.shoekream.biddingVo;

public class BiddingVo {

	private String no;
	private String memberNo;
		private String memberNick;
	private String productsNo;
		private String productsName;
	private String productsSizesNo;
		private String shoesSizes;
		private String products;
	private String biddingStatusNo;
		private String biddingStatus;
	private String biddingPositionNo;
		private String biddingPosition;
	private String price;
	private String enrollDate;
	private String expireDate;
	public BiddingVo() {
	}
	public BiddingVo(String no, String memberNo, String memberNick, String productsNo, String productsName,
			String productsSizesNo, String shoesSizes, String products, String biddingStatusNo, String biddingStatus,
			String biddingPositionNo, String biddingPosition, String price, String enrollDate, String expireDate) {
		this.no = no;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.productsNo = productsNo;
		this.productsName = productsName;
		this.productsSizesNo = productsSizesNo;
		this.shoesSizes = shoesSizes;
		this.products = products;
		this.biddingStatusNo = biddingStatusNo;
		this.biddingStatus = biddingStatus;
		this.biddingPositionNo = biddingPositionNo;
		this.biddingPosition = biddingPosition;
		this.price = price;
		this.enrollDate = enrollDate;
		this.expireDate = expireDate;
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
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getProductsNo() {
		return productsNo;
	}
	public void setProductsNo(String productsNo) {
		this.productsNo = productsNo;
	}
	public String getProductsName() {
		return productsName;
	}
	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}
	public String getProductsSizesNo() {
		return productsSizesNo;
	}
	public void setProductsSizesNo(String productsSizesNo) {
		this.productsSizesNo = productsSizesNo;
	}
	public String getShoesSizes() {
		return shoesSizes;
	}
	public void setShoesSizes(String shoesSizes) {
		this.shoesSizes = shoesSizes;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public String getBiddingStatusNo() {
		return biddingStatusNo;
	}
	public void setBiddingStatusNo(String biddingStatusNo) {
		this.biddingStatusNo = biddingStatusNo;
	}
	public String getBiddingStatus() {
		return biddingStatus;
	}
	public void setBiddingStatus(String biddingStatus) {
		this.biddingStatus = biddingStatus;
	}
	public String getBiddingPositionNo() {
		return biddingPositionNo;
	}
	public void setBiddingPositionNo(String biddingPositionNo) {
		this.biddingPositionNo = biddingPositionNo;
	}
	public String getBiddingPosition() {
		return biddingPosition;
	}
	public void setBiddingPosition(String biddingPosition) {
		this.biddingPosition = biddingPosition;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	@Override
	public String toString() {
		return "BiddingVo [no=" + no + ", memberNo=" + memberNo + ", memberNick=" + memberNick + ", productsNo="
				+ productsNo + ", productsName=" + productsName + ", productsSizesNo=" + productsSizesNo
				+ ", shoesSizes=" + shoesSizes + ", products=" + products + ", biddingStatusNo=" + biddingStatusNo
				+ ", biddingStatus=" + biddingStatus + ", biddingPositionNo=" + biddingPositionNo + ", biddingPosition="
				+ biddingPosition + ", price=" + price + ", enrollDate=" + enrollDate + ", expireDate=" + expireDate
				+ "]";
	}

	
	
}
