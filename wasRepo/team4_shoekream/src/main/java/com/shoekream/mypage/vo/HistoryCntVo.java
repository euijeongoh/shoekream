package com.shoekream.mypage.vo;

public class HistoryCntVo {
	
//	private int cntAll; // 전체: cntBid + cntPend + cntFinished
	private int cntBid; // 입찰 중
	private int cntPend; // 진행 중
	private int cntFinished; // 완료
	
	public HistoryCntVo() {
		
	}
	
	public HistoryCntVo(int cntBid, int cntPend, int cntFinished) {
		super();
		this.cntBid = cntBid;
		this.cntPend = cntPend;
		this.cntFinished = cntFinished;
	}
	
	public int getCntAll() {
		return cntBid + cntPend + cntFinished;
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
		return "HistoryCntVo [cntBid=" + cntBid + ", cntPend=" + cntPend + ", cntFinished="
				+ cntFinished + "]";
	}
	
	
	
}
