const tabBidding = document.querySelector("#bidTab");
const tabPending = document.querySelector("#pendTab");
const tabFinished = document.querySelector("#finishTab");



tabBidding.addEventListener('click', ()=>{
	
	const bidCount = document.querySelector("#bidCount");
	bidCount.style.color="#F15746";
	tabBidding.style.borderBottom="2px solid #222222";
	
	set2Mths();
	
	// formData 객체 생성
	const form = document.querySelector(".period-search form");
	const formData = new FormData(form);
	
	const startDateValue = document.querySelector("input[name=startDate]").value;
	const endDateValue = document.querySelector("input[name=endDate]").value;
	
	fetch("/shoekream/mypage/buying/bidList?startDate=" + startDateValue + "&endDate=" + endDateValue,
		{method: "POST", body: formData})
	.then( (resp)=>{return resp.json()} )
	.then( (data) => {
		console.log(data);
		
		
		
	});
	
});

tabPending.addEventListener('click', ()=>{
	
	const pendCount = document.querySelector("#pendCount");
	pendCount.style.color="#F15746";
	tabPending.style.borderBottom="2px solid #222222";
	
})


tabFinished.addEventListener('click', ()=>{
	
	const finishedCount = document.querySelector("#finishedCount");
	finishedCount.style.color="#F15746";
	tabFinished.style.borderBottom="2px solid #222222";
	
})

// 날짜값 지정
function formatDate(date) {
  var year = date.getFullYear();
  var month = (date.getMonth() + 1).toString().padStart(2, '0');
  var day = date.getDate().toString().padStart(2, '0');
  return year + '-' + month + '-' + day;
}

function set2Mths(){
	const startDateInput = document.querySelector("input[name=startDate]");
	const endDateInput = document.querySelector("input[name=endDate]");
	
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

function set4Mths(){
	const startDateInput = document.querySelector("input[name=startDate]");
	const endDateInput = document.querySelector("input[name=endDate]");
	
	let currentDate = new Date();

	// Get the date from two months ago
	let fourMonthsAgo = new Date();
	fourMonthsAgo.setMonth(fourMonthsAgo.getMonth() - 4);
	
	// Format the dates if needed
	let formattedCurrentDate = formatDate(currentDate);
	let formattedFourMonthsAgo = formatDate(fourMonthsAgo);
	
	startDateInput.value = formattedFourMonthsAgo;
	endDateInput.value = formattedCurrentDate;
}

function set6Mths(){
	const startDateInput = document.querySelector("input[name=startDate]");
	const endDateInput = document.querySelector("input[name=endDate]");
	
	let currentDate = new Date();

	// Get the date from two months ago
	let sixMonthsAgo = new Date();
	sixMonthsAgo.setMonth(sixMonthsAgo.getMonth() - 6);
	
	// Format the dates if needed
	let formattedCurrentDate = formatDate(currentDate);
	let formattedSixMonthsAgo = formatDate(sixMonthsAgo);
	
	startDateInput.value = formattedSixMonthsAgo;
	endDateInput.value = formattedCurrentDate;
}