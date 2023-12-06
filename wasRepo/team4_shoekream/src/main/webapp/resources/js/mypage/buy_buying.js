// 선택된 tab에 따라 css 적용
const inputTab = document.querySelector("input[name=tab]");

if(location.href.indexOf("/buying/bidding")>-1){
	// tab css 적용
	const tabBidding = document.querySelector("#bidTab");
	const bidCount = document.querySelector("#bidCount");
	bidCount.style.color="#F15746";
	tabBidding.style.borderBottom="2px solid #222222";
	inputTab.value="bidding";
	
	// 카테고리 선택에 따라 ajax
}

if(location.href.indexOf("/buying/pending")>-1){
	const tabPending = document.querySelector("#pendTab");
	const pendCount = document.querySelector("#pendCount");
	pendCount.style.color="#F15746";
	tabPending.style.borderBottom="2px solid #222222";
	inputTab.value="pending";
}

if(location.href.indexOf("/buying/finished")>-1){
	const tabFinished = document.querySelector("#finishTab")
	const finishedCount = document.querySelector("#finishedCount")
	finishedCount.style.color="#F15746";
	tabFinished.style.borderBottom="2px solid #222222";
	inputTab.value="finished";
}


