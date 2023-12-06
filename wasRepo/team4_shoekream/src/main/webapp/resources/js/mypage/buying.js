const biddingHrefIndexOf = location.href.indexOf("?tab=bidding")>-1;
const pendingHrefIndexOf = location.href.indexOf("?tab=pending")>-1;
const finishedHrefIndexOf = location.href.indexOf("?tab=finished")>-1;
const inputTab = document.querySelector("input[name=tab]");

// 선택된 tab에 따라 css 적용
if(biddingHrefIndexOf){
	const tabBidding = document.querySelector("#bidTab");
	const bidCount = document.querySelector("#bidCount");
	bidCount.style.color="#F15746";
	tabBidding.style.borderBottom="2px solid #222222";
	inputTab.value="bidding";
	
}

if(pendingHrefIndexOf){
	const tabPending = document.querySelector("#pendTab");
	const pendCount = document.querySelector("#pendCount");
	pendCount.style.color="#F15746";
	tabPending.style.borderBottom="2px solid #222222";
	inputTab.value="pending";
}

if(finishedHrefIndexOf){
	const tabFinished = document.querySelector("#finishTab")
	const finishedCount = document.querySelector("#finishedCount")
	finishedCount.style.color="#F15746";
	tabFinished.style.borderBottom="2px solid #222222";
	inputTab.value="finished";
}




