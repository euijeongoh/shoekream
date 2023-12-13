package com.shoekream.admin.vo;

public class BreakdownVo {

	private String storageSize;
	private String checkSize;
	private String sendSize;

	public BreakdownVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BreakdownVo(String storageSize, String checkSize, String sendSize) {
		super();
		this.storageSize = storageSize;
		this.checkSize = checkSize;
		this.sendSize = sendSize;
	}

	public String getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(String storageSize) {
		this.storageSize = storageSize;
	}

	public String getCheckSize() {
		return checkSize;
	}

	public void setCheckSize(String checkSize) {
		this.checkSize = checkSize;
	}

	public String getSendSize() {
		return sendSize;
	}

	public void setSendSize(String sendSize) {
		this.sendSize = sendSize;
	}

	@Override
	public String toString() {
		return "BreakdownVo [storageSize=" + storageSize + ", checkSize=" + checkSize + ", sendSize=" + sendSize + "]";
	}

	

}
