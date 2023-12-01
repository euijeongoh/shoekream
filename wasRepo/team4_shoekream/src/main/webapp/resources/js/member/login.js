/**
 * 
 */

// 아이디input과 비밀번호input이 모두 채워졌을 때 로그인 버튼 활성화
// 이 때 비밀번호 영문, 숫자, 특수문자 조합 확인

const loginBtn = document.querySelector("#login_btn");

const loginInputTagArr = document.querySelectorAll(".input_txt");
console.log(loginInputTagArr);
console.log(loginInputTagArr[0]);

for(let i=0; i<loginInputTagArr.length; i++) {
	loginInputTagArr[i].addEventListener('keyup', ()=>{
		activateLoginBtn();
	})
}


function activateLoginBtn() {
	const pwdChecked = checkPwd();
	
	if(loginInputTagArr[0].value.length>6 && pwdChecked==true){
		loginBtn.style.backgroundColor="black";
		loginBtn.style.cursor="pointer";
	}	
}

function checkPwd() {
	const str = loginInputTagArr[1].value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
	const pwdChecked = regPwd.test(str);
	
	if(str.length>1 && pwdChecked===false) {
		const pwdCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";	
	}
	
	if(pwdChecked===true) {
		const pwdCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="";
	}
	
	return pwdChecked;
}
 



