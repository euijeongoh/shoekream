// 선택된 tab에 따라 css 적용
const inputTab = document.querySelector("input[name=tab]");

if(location.href.indexOf("/buying/bidding")>-1){
	// tab css 적용
	const tabBidding = document.querySelector("#bidTab");
	bidCount.style.color="#F15746";
	tabBidding.style.borderBottom="2px solid #222222";
	
	// 기본적인 startDate, endDate 설정하기
	const startDateInput = document.querySelector("input[name=startDate");
	const endDateInput = document.querySelector("input[name=endDate");
	
	let currentDate = new Date();

	// Get the date from two months ago
	let twoMonthsAgo = new Date();
	twoMonthsAgo.setMonth(twoMonthsAgo.getMonth() - 2);
	
	// Format the dates if needed
	let formattedCurrentDate = formatDate(currentDate);
	let formattedTwoMonthsAgo = formatDate(twoMonthsAgo);
	
	startDateInput.value = formattedTwoMonthsAgo;
	endDateInput.value = formattedCurrentDate;
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

function formatDate(date) {
  var year = date.getFullYear();
  var month = (date.getMonth() + 1).toString().padStart(2, '0');
  var day = date.getDate().toString().padStart(2, '0');
  return year + '-' + month + '-' + day;
}