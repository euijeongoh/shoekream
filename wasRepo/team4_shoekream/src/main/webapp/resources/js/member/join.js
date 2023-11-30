/**
 * 
 */

const joinBtn = document.querySelector("#join_btn");

const idInputTag = document.querySelector("input[name=memberId]");
const pwdInputTag = document.querySelector("input[name=memberPwd]");

idInputTag.addEventListener('keyup', ()=> {
	activateJoinBtn();
})

pwdInputTag.addEventListener('keyup', () => {
	activateJoinBtn();
})


function activateJoinBtn() {
	const pwdChecked = checkPwd();
	const idChecked = checkId();
	
	if(idInputTag.value.length>6 && isChecked==true){
		loginBtn.style.backgroundColor="black";
		loginBtn.style.cursor="pointer";
	}	
}

function checkId() {
	const strId = idInputTag.value;
	const regId = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z]{6,12}$/;
	const idChecked = regId.test(strId);
	
	if(strId.length>1 && idChecked==false) {
		const idCheckDiv = document.querySelector("#id_check");
		idCheckDiv.innerHTML="영문, 숫자를 조합해서 입력해주세요.(6-12자)";
	}
	
	if(idChecked===true) {
		const idCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="";
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