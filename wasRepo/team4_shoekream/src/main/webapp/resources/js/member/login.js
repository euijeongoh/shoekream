/**
 * 
 */

// 아이디input과 비밀번호input이 모두 채워졌을 때 로그인 버튼 활성화
// 이 때 비밀번호 영문, 숫자, 특수문자 조합 확인
const loginBtn = document.querySelector("#login_btn");

const idInputTag = document.querySelector("input[name=memberId]");
const pwdInputTag = document.querySelector("input[name=memberPwd]");

idInputTag.addEventListener('keyup', ()=> {
	activateLoginBtn();
})

pwdInputTag.addEventListener('keyup', () => {
	activateLoginBtn();
})


function activateLoginBtn() {
	const isChecked = checkPwd();
	
	if(idInputTag.value.length>6 && isChecked==true){
		loginBtn.style.backgroundColor="black";
		loginBtn.style.cursor="pointer";
	}	
}

function checkPwd() {
	const str = pwdInputTag.value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
	const isChecked = regPwd.test(str);
	
	if(str.length>1 && isChecked===false) {
		const pwdCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";	
	}
	
	if(isChecked===true) {
		const pwdCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="";
	}
	
	return isChecked;
}
 



