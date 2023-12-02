const joinBtn = document.querySelector("#join_btn");
const joinInputTagArr = document.querySelectorAll(".input_txt");

activateJoinBtn();

function activateJoinBtn() {
	for(let i=0; i<joinInputTagArr.length; i++) {
	joinInputTagArr[i].addEventListener('keyup', ()=>{
		let result = checkValidation();
		return result;
	})
	}
}

function checkValidation() {
	// 아이디 6자 이상 12자 이하
	checkId();
		
	// 아이디 중복 검사
	checkIdDup();
	
	// 비밀번호 8-16자 영문, 숫자, 특수문자 조합
	
	// 비밀번호 확인 일치여부
	
	// 닉네임 한글 3-5자
	
	// 이메일 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식
	
	// 휴대폰 번호 '-' 포함 숫자 13자
	
	// 신발 사이즈 null 선택 모달창
}

// 아이디 중복 검사
function checkIdDup() {
	const idInputTag = document.querySelector("input[name=memberId]");
	const idInputValue = document.querySelector("input[name=memberId]").value;
	
	fetch("/shoekream/member/check/id?memberId=" +  idInputValue, {method: "POST"})
	.then((resp) => { return resp.json() })
	.then((data) => { 
		const result = data.msg;
		
		let isDup = false;
		if(result == "no"){
			isDup = true;
		}
		
		if(isDup === true) {
			idInputTag.addEventListener('blur', ()=>{
				const idCheckDiv = document.querySelector("#id_check");
				idCheckDiv.innerHTML = "중복된 아이디입니다.";
				window.idOk = false;
			})
		} else {
			window.idOk = true;
		}	
	 });
}

function checkId() {
	const idCheckDiv = document.querySelector("#id_check");
	const strId = loginInputTagArr[0].value;
	let idChecked=false;
	
	if(strId.length < 5) {
		idCheckDiv.innerHTML="6자 이상 입력해주세요";
	}
	
	if(strId.length > 5) {
		idCheckDiv.innerHTML="";
		idChecked=true;
	}
	
	return idChecked;
}