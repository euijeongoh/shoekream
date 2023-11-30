/**
 * 
 */

// 아이디input과 비밀번호input이 모두 채워졌을 때 로그인 버튼 활성화
// 이 때 비밀번호 영문, 숫자, 특수문자 조합 확인

function checkLogin() {
	
}

const loginBtn = document.querySelector("#login_btn");

const idInputTag = document.querySelector("input[name=memberId]");
const pwdInputTag = document.querySelector("input[name=memberPwd]");

pwdInputTag.addEventListener('keyup', (event) => {
	// 비밀번호: 영문 숫자 특수문자 하나이상 있는지 + 글자 수가 8자 이상인지
	const str = event.target.value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
	if(regPwd.test(str)===false) {
		const pwdCheckDiv = document.querySelector("#pwd_check");
		pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";	
	}
	
	// *: 1개 이상
	// .: 전체
	
	if(idInputTag.value.length>6 && regPwd.test(str)){
		loginBtn.style.backgroundColor="black";
		loginBtn.style.cursor="pointer";
	}
})



