package com.shoekream.bidding;

public class BiddingVo {

	private String no;
	private String MemberNo;
	private String productsNo;
	private String productsSizesNo;
	private String products;
	private String biddingStatusNo;
	private String biddingPositionNo;
	private String price;
	private String enrollDate;
	private String expireDate;
	public BiddingVo() {
	}
	public BiddingVo(String no, String memberNo, String productsNo, String productsSizesNo, String products,
			String biddingStatusNo, String biddingPositionNo, String price, String enrollDate, String expireDate) {
		this.no = no;
		MemberNo = memberNo;
		this.productsNo = productsNo;
		this.productsSizesNo = productsSizesNo;
		this.products = products;
		this.biddingStatusNo = biddingStatusNo;
		this.biddingPositionNo = biddingPositionNo;
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
		return MemberNo;
	}
	public void setMemberNo(String memberNo) {
		MemberNo = memberNo;
	}
	public String getProductsNo() {
		return productsNo;
	}
	public void setProductsNo(String productsNo) {
		this.productsNo = productsNo;
	}
	public String getProductsSizesNo() {
		return productsSizesNo;
	}
	public void setProductsSizesNo(String productsSizesNo) {
		this.productsSizesNo = productsSizesNo;
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
	public String getBiddingPositionNo() {
		return biddingPositionNo;
	}
	public void setBiddingPositionNo(String biddingPositionNo) {
		this.biddingPositionNo = biddingPositionNo;
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
		return "BiddingVo [no=" + no + ", MemberNo=" + MemberNo + ", productsNo=" + productsNo + ", productsSizesNo="
				+ productsSizesNo + ", products=" + products + ", biddingStatusNo=" + biddingStatusNo
				+ ", biddingPositionNo=" + biddingPositionNo + ", price=" + price + ", enrollDate=" + enrollDate
				+ ", expireDate=" + expireDate + "]";
	}
	
}
