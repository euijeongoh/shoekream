package com.shoekream.page.vo;

public class PageVo {
	
	private int listCount;		//총 게시글 갯수
	private int imageLimit;		//사진 페이징 영역 페이지 갯수
	private int reviewLimit;	//전체 게시글 갯수
	
//	private int maxPage;		//가장 마지막 페이지
//	private int startPage;		//페이징 영역 시작값
//	private int endPage;		//페이징 영역 마지막값
	
//	private int startRow;		//조회할 첫번째 행 번호 (ROWNUM)
//	private int lastRow;		//조회할 마지막 행 번호 (ROWNUM)
	
	//생성자
	public PageVo(int listCount , int imageLimit , int reviewLimit) {
		this.listCount = listCount;
		this.imageLimit = imageLimit;
		this.reviewLimit = reviewLimit;
		
//		this.maxPage = (int) Math.ceil((double)listCount/boardLimit);
//	    this.startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
//	    this.endPage = startPage + pageLimit - 1;
//		
//		if(endPage > maxPage) {
//	       endPage = maxPage;
//	      }	
//		
//		this.startPage = (currentPage -1) * boardLimit + 1 ;
//		this.lastRow = startRow + boardLimit - 1;
	}

	public int getListCount() {
		return listCount;
	}

	public int getImageLimit() {
		return imageLimit;
	}

	public int getReviewLimit() {
		return reviewLimit;
	}
	
	

	
}

