package com.shoekream.biddingVo;

public class BiddingVo {

	private String no;
	private String memberNo;
	private String productsNo;
	private String productsSizesNo;
	private String shoesSizes;
	private String products;
	private String biddingStatusNo;
	private String biddingPositionNo;
	private String price;
	private String enrollDate;
	private String expireDate;
	public BiddingVo() {
	}
	public BiddingVo(String no, String memberNo, String productsNo, String productsSizesNo, String shoesSizes,
			String products, String biddingStatusNo, String biddingPositionNo, String price, String enrollDate,
			String expireDate) {
		this.no = no;
		this.memberNo = memberNo;
		this.productsNo = productsNo;
		this.productsSizesNo = productsSizesNo;
		this.shoesSizes = shoesSizes;
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
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
		return "BiddingVo [no=" + no + ", memberNo=" + memberNo + ", productsNo=" + productsNo + ", productsSizesNo="
				+ productsSizesNo + ", shoesSizes=" + shoesSizes + ", products=" + products + ", biddingStatusNo="
				+ biddingStatusNo + ", biddingPositionNo=" + biddingPositionNo + ", price=" + price + ", enrollDate="
				+ enrollDate + ", expireDate=" + expireDate + "]";
	}
	
}
