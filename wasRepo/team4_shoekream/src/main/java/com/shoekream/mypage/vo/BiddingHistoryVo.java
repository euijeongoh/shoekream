package com.shoekream.mypage.vo;

import java.util.List;

import com.shoekream.biddingVo.BiddingVo;

public class BiddingHistoryVo {

	// fields
	private List<BiddingVo> bidList; // 입찰내역 리스트
	private HistoryCntVo cntVo; // 입찰 및 주문 cnt값들
	
	// constructor
	public BiddingHistoryVo() {
	
	}
	
	public BiddingHistoryVo(List<BiddingVo> bidList, HistoryCntVo cntVo) {
		super();
		this.bidList = bidList;
		this.cntVo = cntVo;
	}
	
	// getter setter
	public List<BiddingVo> getBidList() {
		return bidList;
	}
	public void setBidList(List<BiddingVo> bidList) {
		this.bidList = bidList;
	}
	public HistoryCntVo getCntVo() {
		return cntVo;
	}
	public void setCntVo(HistoryCntVo cntVo) {
		this.cntVo = cntVo;
	}
	
	// toString
	@Override
	public String toString() {
		return "BiddingHistoryVo [bidList=" + bidList + ", cntVo=" + cntVo + "]";
	}
	
	
}
