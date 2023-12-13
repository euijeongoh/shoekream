package com.shoekream.mypage.vo;

public class BiddingDetailVo {
	
	private String productImg;
	private String modelNumber;
	private String productName;
	private String productNameKo;
	private String productSize;
	
	private String bidStatus;
	private String bidExpireDate;
	private int bidPrice;
	private int commission;
	private int finalPrice;
	
	private String addressName;
	private String phone;
	private String address;
	private String cardCompany;
	private String cardNumber;
	
	public BiddingDetailVo() {
		
	}
	
	
	public BiddingDetailVo(String productImg, String modelNumber, String productName, String productNameKo,
			String productSize, String bidStatus, String bidExpireDate, int bidPrice, int commission,
			String addressName, String phone, String address, String cardCompany, String cardNumber) {
		super();
		this.productImg = productImg;
		this.modelNumber = modelNumber;
		this.productName = productName;
		this.productNameKo = productNameKo;
		this.productSize = productSize;
		this.bidStatus = bidStatus;
		this.bidExpireDate = bidExpireDate;
		this.bidPrice = bidPrice;
		this.commission = commission;
		this.addressName = addressName;
		this.phone = phone;
		this.address = address;
		this.cardCompany = cardCompany;
		this.cardNumber = cardNumber;
	}


	public String getProductImg() {
		return productImg;
	}


	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}


	public String getModelNumber() {
		return modelNumber;
	}


	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
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


	public String getProductSize() {
		return productSize;
	}


	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}


	public String getBidStatus() {
		return bidStatus;
	}


	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}


	public String getBidExpireDate() {
		return bidExpireDate;
	}


	public void setBidExpireDate(String bidExpireDate) {
		this.bidExpireDate = bidExpireDate;
	}


	public int getBidPrice() {
		return bidPrice;
	}


	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getCommission() {
		return commission;
	}
	
	public void setCommission(int bidPrice) {
		this.commission = (int)((Math.round(bidPrice*0.03)*0.01)*100);
	}
	
	public int getFinalPrice() {
		return finalPrice;
	}
	
	public void setFinalPrice(int bidPrice, int commission) {
		this.finalPrice = bidPrice + commission + 3000;
	}


	public String getAddressName() {
		return addressName;
	}


	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCardCompany() {
		return cardCompany;
	}


	public void setCardCompany(String cardCompany) {
		this.cardCompany = cardCompany;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "BiddingDetailVo [productImg=" + productImg + ", modelNumber=" + modelNumber + ", productName="
				+ productName + ", productNameKo=" + productNameKo + ", productSize=" + productSize + ", bidStatus="
				+ bidStatus + ", bidExpireDate=" + bidExpireDate + ", bidPrice=" + bidPrice + ", commission="
				+ commission + ", addressName=" + addressName + ", phone=" + phone + ", address=" + address
				+ ", cardCompany=" + cardCompany + ", cardNumber=" + cardNumber + "]";
	}

	
	
}
