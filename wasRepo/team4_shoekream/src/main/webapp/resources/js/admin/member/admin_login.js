/**
 * 
 */

// 아이디input과 비밀번호input이 모두 채워졌을 때 로그인 버튼 활성화
// 이 때 비밀번호 영문, 숫자, 특수문자 조합 확인

const loginBtn = document.querySelector("#login-btn");
const loginInputTagArr = document.querySelectorAll(".input-txt");

activateLoginBtn();

function activateLoginBtn() {
	for(let i=0; i<loginInputTagArr.length; i++) {
	loginInputTagArr[i].addEventListener('keyup', ()=>{
		const result = checkValidation();
		return result;
	})
	}
}


function checkValidation() {
	const pwdChecked = checkPwd();
	const idChecked = checkId();
	
	if(idChecked===true && pwdChecked===true){
		loginBtn.style.backgroundColor="black";
		loginBtn.style.cursor="pointer";
		
		return true;
	}
	
	return false;
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

function checkPwd() {
	const strPwd = loginInputTagArr[1].value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
	const pwdChecked = regPwd.test(strPwd);
	
	if(strPwd.length>1 && pwdChecked===false) {
		const pwdCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";	
	}
	
	if(pwdChecked===true) {
		const pwdCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="";
	}
	
	return pwdChecked;
}
 



