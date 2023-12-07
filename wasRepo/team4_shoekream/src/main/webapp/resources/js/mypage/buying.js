const tabBidding = document.querySelector("#bidTab");
const tabPending = document.querySelector("#pendTab");
const tabFinished = document.querySelector("#finishTab");



tabBidding.addEventListener('click', ()=>{
	
	const bidCount = document.querySelector("#bidCount");
	bidCount.style.color="#F15746";
	tabBidding.style.borderBottom="2px solid #222222";
	
	
	fetch("/shoekream/")
	
})


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