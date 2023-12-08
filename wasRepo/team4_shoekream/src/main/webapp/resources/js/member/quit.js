
// 탈퇴하기 창 로드 시에는 모달창이 보이지 않는다
window.onload = ()=>{
	const modal = document.querySelector(".modal_quit");
	modal.style.display="none";
}

// 탈퇴하기 버튼 누르면 모달창이 뜬다
const quitBtn = document.querySelector(".btn_area :first-child");

quitBtn.addEventListener('click', ()=>{
	const modal = document.querySelector(".modal_quit");
	
	// 부모창의 체크박스가 모두 체크되어있지 않으면 모달창은 뜨지 않는다
	const isChecked = checkParentWindow();
	console.log(isChecked);
	
	if(isChecked === false) {
		alert("체크박스 체크하셈");		
	}
	
	if(isChecked) {
		modal.style.display="block";		
	}
	
})

// 부모창에서 탈퇴 관련 약관 체크박스 모두 체크되었는지 확인
function checkParentWindow() {
	let isChecked=false;
	const checkBoxArr = document.querySelectorAll(".quit_term input[type=checkbox]");
	console.log(checkBoxArr);
	console.log(checkBoxArr[0].checked);
	console.log(checkBoxArr[1].checked);
	console.log(checkBoxArr[2].checked);
	if(checkBoxArr[0].checked && checkBoxArr[1].checked && checkBoxArr[2].checked){
		isChecked = true;
	}
	
	return isChecked;
}

 