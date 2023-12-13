const tabBidding = document.querySelector("#bidTab");
const tabPending = document.querySelector("#pendTab");
const tabFinished = document.querySelector("#finishTab");

const bidCount = document.querySelector("#bidCount");
const pendCount = document.querySelector("#pendCount");
const finishedCount = document.querySelector("#finishedCount");

let inputTabValue = document.querySelector("#tab").value;

function chooseAjax() {
	if(inputTabValue === "bidding") {
		bidTabAjax();
	}
	
	if(inputTabValue === "pending") {
		pendTabAjax();
	} 
	
	if(inputTabValue === "finished") {
		finishTabAjax();
	}
}


function bidTabAjax() {
	
	bidCount.style.color="#F15746";
	tabBidding.style.borderBottom="2px solid #222222";
	pendCount.style.color="#222222";
	tabPending.style.borderBottom="none";	
	finishedCount.style.color="#222222";
	tabFinished.style.borderBottom="none";
	// hidden input 값 설정(chooseAjax메소드 실행을 위해)
	inputTabValue = "bidding";
	
	// json 형태로 데이터 보내기
	const startDateValue = document.querySelector("input[name=startDate]").value;
	const endDateValue = document.querySelector("input[name=endDate]").value;

	if(startDateValue==="" || endDateValue === "") {
		set2Mths();
	}

	const jsonObj = {
		startDate : startDateValue,
		endDate : endDateValue
	}
	
	const jsonStr = JSON.stringify(jsonObj);
	
	// ajax 요청
	fetch("/shoekream/mypage/selling/bidList",
		{method: "POST", body: jsonStr})
	.then( (resp)=>{return resp.json()} )
	.then( (data) => {
		const sellBody = document.querySelector(".sell-body");
		sellBody.innerHTML="";
		for(let i=0; i<data.length; ++i) {
			const sell = document.createElement("div");
			sellBody.appendChild(sell);
			sell.className = "sell";
			
			const productDetail = document.createElement("div");
			sell.appendChild(productDetail);
			productDetail.className = "product-detail";
						
			const productImg = document.createElement("div");
			productDetail.appendChild(productImg);
			productImg.className = "product_img";
			const img = document.createElement("img");
			productImg.appendChild(img);
			img.src=data[i].productImg;
			
			
			const detail = document.createElement("div");
			productDetail.appendChild(detail);
			detail.className = "detail";
			
			const product = document.createElement("div");
			detail.appendChild(product);
			product.id="product";
			product.innerHTML=data[i].productName;
			
			const size = document.createElement("div");
			detail.appendChild(size);
			size.id="size";
			size.innerHTML=data[i].productSize;
			
			const sellDetail = document.createElement("ul");
			sellDetail.className = "sell-detail";
			sell.appendChild(sellDetail);
			
			const li1 = document.createElement("li");
			const li2 = document.createElement("li");
			const li3 = document.createElement("li");
			
			sellDetail.appendChild(li1);
			sellDetail.appendChild(li2);
			sellDetail.appendChild(li3);
			
			const detailBtn = document.createElement("button");
			li1.appendChild(detailBtn);
			detailBtn.className = "detail-btn"
			detailBtn.innerHTML="상세내역";
			detailBtn.onclick="location.href='/shoekream/sell/order'";
			
			li2.innerHTML=data[i].bidStatus;
			li3.innerHTML=data[i].bidPrice + "원";
		}
		
	});
	

}

function pendTabAjax() {
	
	bidCount.style.color="#222222";
	tabBidding.style.borderBottom="none";
	pendCount.style.color="#F15746";
	tabPending.style.borderBottom="2px solid #222222";
	finishedCount.style.color="#222222";
	tabFinished.style.borderBottom="none";
	
	inputTabValue = "pending";
	
	// json 형태로 데이터 보내기
	const startDateValue = document.querySelector("input[name=startDate]").value;
	const endDateValue = document.querySelector("input[name=endDate]").value;

	if(startDateValue==="" || endDateValue === "") {
		set2Mths();
	}

	const jsonObj = {
		startDate : startDateValue,
		endDate : endDateValue
	}
	
	const jsonStr = JSON.stringify(jsonObj);
	console.log(jsonStr);
	
	// ajax 요청
	fetch("/shoekream/mypage/selling/pendList",
		{method: "POST", body: jsonStr})
	.then( (resp)=>{return resp.json()} )
	.then( (data) => {
		const sellBody = document.querySelector(".sell-body");
		sellBody.innerHTML="";		
		for(let i=0; i<data.length; ++i) {
			const sell = document.createElement("div");
			sellBody.appendChild(sell);
			sell.className = "sell";
			
			const productDetail = document.createElement("div");
			sell.appendChild(productDetail);
			productDetail.className = "product-detail";
						
			const productImg = document.createElement("div");
			productDetail.appendChild(productImg);
			productImg.className = "product_img";
			const img = document.createElement("img");
			productImg.appendChild(img);
			img.src=data[i].productImg;
			
			
			const detail = document.createElement("div");
			productDetail.appendChild(detail);
			detail.className = "detail";
			
			const product = document.createElement("div");
			detail.appendChild(product);
			product.id="product";
			product.innerHTML=data[i].productName;
			
			const size = document.createElement("div");
			detail.appendChild(size);
			size.id="size";
			size.innerHTML=data[i].productSize;
			
			const sellDetail = document.createElement("ul");
			sellDetail.className = "sell-detail";
			sell.appendChild(sellDetail);
			
			const li1 = document.createElement("li");
			const li2 = document.createElement("li");
			const li3 = document.createElement("li");

			sellDetail.appendChild(li1);
			sellDetail.appendChild(li2);
			sellDetail.appendChild(li3);
			
			const detailBtn = document.createElement("button");
			li1.appendChild(detailBtn);
			detailBtn.className = "detail-btn"
			detailBtn.innerHTML="상세내역";
			detailBtn.onclick="location.href='/shoekream/buy/order'";
			li2.innerHTML=data[i].orderStatus;
			li3.innerHTML=data[i].orderDate;
		}
		
	});
}


function finishTabAjax() {
	bidCount.style.color="#222222";
	tabBidding.style.borderBottom="none";
	pendCount.style.color="#222222";
	tabPending.style.borderBottom="none";	
	finishedCount.style.color="#F15746";
	tabFinished.style.borderBottom="2px solid #222222";
	
	inputTabValue = "finished";
	
	// json 형태로 데이터 보내기
	const startDateValue = document.querySelector("input[name=startDate]").value;
	const endDateValue = document.querySelector("input[name=endDate]").value;

	if(startDateValue==="" || endDateValue === "") {
		set2Mths();
	}

	const jsonObj = {
		startDate : startDateValue,
		endDate : endDateValue
	}
	
	const jsonStr = JSON.stringify(jsonObj);
	
	// ajax 요청
	fetch("/shoekream/mypage/selling/finishList",
		{method: "POST", body: jsonStr})
	.then( (resp)=>{return resp.json()} )
	.then( (data) => {
		const sellBody = document.querySelector(".sell-body");
		sellBody.innerHTML="";		
		for(let i=0; i<data.length; ++i) {
			const sell = document.createElement("div");
			sellBody.appendChild(sell);
			sell.className = "sell";
			
			const productDetail = document.createElement("div");
			sell.appendChild(productDetail);
			productDetail.className = "product-detail";
						
			const productImg = document.createElement("div");
			productDetail.appendChild(productImg);
			productImg.className = "product_img";
			productImg.src=data[i].productImg;
			
			
			const detail = document.createElement("div");
			productDetail.appendChild(detail);
			detail.className = "detail";
			
			const product = document.createElement("div");
			detail.appendChild(product);
			product.id="product";
			product.innerHTML=data[i].productName;
			
			const size = document.createElement("div");
			detail.appendChild(size);
			size.id="size";
			size.innerHTML=data[i].productSize;
			
			const sellDetail = document.createElement("ul");
			sellDetail.className = "sell-detail";
			sell.appendChild(sellDetail);
			
			const li1 = document.createElement("li");
			const li2 = document.createElement("li");
			const li3 = document.createElement("li");
			
			sellDetail.appendChild(li1);
			sellDetail.appendChild(li2);
			sellDetail.appendChild(li3);

			const detailBtn = document.createElement("button");
			li1.appendChild(detailBtn);
			detailBtn.className = "detail-btn"
			detailBtn.innerHTML="상세내역";
			detailBtn.onclick="location.href='/shoekream/buy/order'";
			
			li2.innerHTML=data[i].orderStatus;

			const reviewLink = document.createElement("a");
			li3.appendChild(reviewBtn);
			reviewLink.innerHTML=data[i].finalPrice;
			reviewLink.href="location.href='/shoekream/review/write?productNo='" + data[i].shoeNo;
		}
		
	});	
}









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