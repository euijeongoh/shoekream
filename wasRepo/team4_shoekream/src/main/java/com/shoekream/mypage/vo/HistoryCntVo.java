package com.shoekream.mypage.vo;

public class HistoryCntVo {
	
	private int cntAll;
	private int cntBid;
	private int cntPend;
	private int cntFinished;
	
	public HistoryCntVo() {
		
	}
	
	public HistoryCntVo(int cntAll, int cntBid, int cntPend, int cntFinished) {
		super();
		this.cntAll = cntBid + cntPend + cntFinished;
		this.cntBid = cntBid;
		this.cntPend = cntPend;
		this.cntFinished = cntFinished;
	}

	public int getCntAll() {
		return cntAll;
	}

	public void setCntAll(int cntAll) {
		this.cntAll = cntAll;
	}

	public int getCntBid() {
		return cntBid;
	}

	public void setCntBid(int cntBid) {
		this.cntBid = cntBid;
	}

	public int getCntPend() {
		return cntPend;
	}

	public void setCntPend(int cntPend) {
		this.cntPend = cntPend;
	}

	public int getCntFinished() {
		return cntFinished;
	}

	public void setCntFinished(int cntFinished) {
		this.cntFinished = cntFinished;
	}

	@Override
	public String toString() {
		return "HistoryCntVo [cntAll=" + cntAll + ", cntBid=" + cntBid + ", cntPend=" + cntPend + ", cntFinished="
				+ cntFinished + "]";
	}
	
	
	
}
