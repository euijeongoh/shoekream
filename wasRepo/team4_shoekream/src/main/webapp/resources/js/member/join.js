/**
 * 
 */

const joinBtn = document.querySelector("#join_btn");

const inputBoxTagArr = document.querySelectorAll("input[class=input_txt]");
const idInputTag = document.querySelector("input[name=memberId]");
const pwdInputTag = document.querySelector("input[name=memberPwd]");
const pwd2InputTag = document.querySelector("input[name=memberPwd2]");

for(let i = 0; i<inputBoxTagArr.length; i++){
	inputBoxTagArr[i].addEventListener('keyup', (event)=>{
		activateJoinBtn();
	})
}

function activateJoinBtn() {
	const pwdChecked = checkPwd();
	const idChecked = checkId();
	const pwd2Checked = checkPwd2();
	
	if(idChecked==true && pwdChecked==true && pwd2Checked==true){
		joinBtn.style.backgroundColor="black";
		joinBtn.style.cursor="pointer";
	}	
}

function checkId() {
	const strId = idInputTag.value;
	let idChecked = false;
	
	if(strId.length>5) {
		const idCheckDiv = document.querySelector("#id_check");
		idCheckDiv.innerHTML="영문, 숫자를 조합해서 입력해주세요.(6-12자)";
	}
	
	if(strId.length<5) {
		const idCheckDiv = document.querySelector("#id_check");
		idCheckDiv.innerHTML="";
	}
	
	return idChecked;
}

function checkPwd() {
	const strPwd = pwdInputTag.value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
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

function checkPwd2() {
	const pwd2CheckDiv = document.querySelector("#pwd2_equalCheck");
	
	if(pwd2InputTag.value.length>1 && pwdInputTag.value !== pwd2InputTag.value) {
		pwd2CheckDiv.innerHTML="비밀번호가 일치하지 않습니다.";
	}
	
	if(pwd2InputTag.value === pwdInputTag.value){
		pwd2CheckDiv.innerHTML="";
	}
}

function checkNick() {
	
}

function checkEmail() {
	
}

function checkPhone() {
	
}

