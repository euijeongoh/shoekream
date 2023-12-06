package com.shoekream.mypage.vo;

import java.util.List;
import java.util.Map;

import com.shoekream.admin.vo.EnrollProductVo;

public class WishListVo {

	private String brandName;
	private String productNo;
	private String productName;
	private String productImg;
	private String immediatePrice;
	public WishListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishListVo(String brandName, String productNo, String productName, String productImg,
			String immediatePrice) {
		super();
		this.brandName = brandName;
		this.productNo = productNo;
		this.productName = productName;
		this.productImg = productImg;
		this.immediatePrice = immediatePrice;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	public String getImmediatePrice() {
		return immediatePrice;
	}
	public void setImmediatePrice(String immediatePrice) {
		this.immediatePrice = immediatePrice;
	}
	@Override
	public String toString() {
		return "WishListVo [brandName=" + brandName + ", productNo=" + productNo + ", productName=" + productName
				+ ", productImg=" + productImg + ", immediatePrice=" + immediatePrice + "]";
	}
	
	
	
	
	
}
