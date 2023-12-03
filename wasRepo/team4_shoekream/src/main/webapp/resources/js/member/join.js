const joinBtn = document.querySelector("#join_btn");
const joinInputTagArr = document.querySelectorAll(".input_txt");

activateJoinBtn();

function activateJoinBtn() {
	for(let i=0; i<joinInputTagArr.length; i++) {
	joinInputTagArr[i].addEventListener('keyup', ()=>{
		const result = checkValidation();
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
	checkPwd();
	
	// 비밀번호 확인 일치여부
	checkPwd2();
	
	// 닉네임 한글 3-5자
	
	// 이메일 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식
	checkEmail();
	emailDupCheck();
	authenticateEmail();
	// 이메일 인증 완료
	
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
	const strId = joinInputTagArr[0].value;
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

function checkPwd() {
	const strPwd = joinInputTagArr[1].value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
	const pwdChecked = regPwd.test(strPwd);
	const pwdCheckDiv = document.querySelector("#pwd_check");
	
	if(strPwd.length>1 && pwdChecked===false) {
		pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";	
	} else {
		pwdCheckDiv.innerHTML="";		
	}
		
	return pwdChecked;
	
}

function checkPwd2() {
	const strPwd = joinInputTagArr[1].value;
	const strPwd2 = joinInputTagArr[2].value;
	const pwd2CheckDiv = document.querySelector("#pwd2_check");
	
	if(strPwd2.length>1 && strPwd !== strPwd2) {
		pwd2CheckDiv.innerHTML="비밀번호와 일치하지 않습니다.";
	} else {
		pwd2CheckDiv.innerHTML="";
	}
}

function checkEmail() {
	const strEmail = joinInputTagArr[4].value;
	const regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	const emailChecked = regEmail.test(strEmail);
	const emailCheckDiv = document.querySelector("#email_check");
	const emailBtn = document.querySelector("input[type=button]");
	
	if(strEmail.length>1 && emailChecked===false) {
		emailCheckDiv.innerHTML="이메일 형식이 올바르지 않습니다.";	
	} else {
		emailCheckDiv.innerHTML="";	
	}
	
			
	return emailChecked;
	
}

function emailDupCheck() {
	const emailInputTag = document.querySelector("input[name=email]")
	const emailValue = document.querySelector("input[name=email]").value;
	
	fetch("/shoekream/member/check/email?email=" + emailValue, {method:"POST"})
	.then((resp)=>{ return resp.json() })
	.then((data)=>{
		const result = data.msg;
		const isDup = (result == "no");
		console.log(isDup);
		if(isDup === true) {
			emailInputTag.addEventListener('blur', ()=>{
				const emailCheckDiv = document.querySelector("#email_check");
				emailCheckDiv.innerHTML = "이미 가입한 이메일입니다.";
			})
		}
		
		return isDup;
	});
}

function authenticateEmail() {
	
}