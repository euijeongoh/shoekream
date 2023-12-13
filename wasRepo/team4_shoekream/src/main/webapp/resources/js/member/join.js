const joinBtn = document.querySelector("#join_btn");
const joinInputTagArr = document.querySelectorAll(".input_txt");

// 이름 체크
let nameValid = false;
joinInputTagArr[0].addEventListener('keyup', () => {
	// 이름 2~4자 한글
	const strName = joinInputTagArr[0].value;
	const regName = /^[ㄱ-ㅣ가-힣]{2,5}$/;
	const nameChecked = regName.test(strName);
	const nameCheckDiv = document.querySelector("#name_check");
	if(nameChecked===false){
		nameCheckDiv.innerHTML="본인의 실명을 적어주세요.";
		nameValid = false;
	} else {
		nameCheckDiv.innerHTML="";			
		nameValid = true;
	}
	
})


// 아이디 유효성 체크 keyup
let idValid = false;	
joinInputTagArr[1].addEventListener('keyup', ()=>{	
	// 아이디 6자 이상 12자 이하
	const strId = joinInputTagArr[1].value;
	const idCheckDiv = document.querySelector("#id_check");
	
	if(strId.length>=1 && strId.length < 6) {
		idCheckDiv.innerHTML="6자 이상 입력해주세요";
	}
	
	if(strId.length>=6){
		idCheckDiv.innerHTML="";
		idValid = true;
	}

	// 아이디 중복체크
	const jsonObj = {
		strId : strId
	}
	
	const jsonStr = JSON.stringify(jsonObj);
	
	fetch("/shoekream/member/check/id", {method: "POST", body: jsonStr})
	.then((resp) => { return resp.json() })
	.then((data) => { 
		const result = data.msg;
		const isDup = (result == "no");
				
				
		if(isDup===true) {
			idCheckDiv.innerHTML="사용할 수 없는 아이디입니다.(중복)";
			idValid = false;
		} 
		
		if(isDup===false){
			idCheckDiv.innerHTML="";
			idValid = true;
		}
	});	
})


// 비밀번호 유효성 체크
// 비밀번호 영문, 숫자, 특수문자 조합 8-16자
let pwdValid = false;
joinInputTagArr[2].addEventListener('keyup', ()=>{
	const strPwd = joinInputTagArr[2].value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
	const pwdChecked = regPwd.test(strPwd);
	const pwdCheckDiv = document.querySelector("#pwd_check");
	
	if(strPwd.length>=1 && pwdChecked===false) {
		pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";
		pwdValid = false;
	} else {
		pwdCheckDiv.innerHTML="";
		pwdValid = true;		
	}
})

// 비밀번호 확인 작업(일치 여부)
joinInputTagArr[3].addEventListener('keyup', ()=>{	
	const strPwd = joinInputTagArr[2].value;	
	const strPwd2 = joinInputTagArr[3].value;
	const pwd2CheckDiv = document.querySelector("#pwd2_check");
	
	if(strPwd2.length>=1 && strPwd !== strPwd2) {
		pwd2CheckDiv.innerHTML="비밀번호와 일치하지 않습니다.";
		pwdValid = false;
	} else {
		pwd2CheckDiv.innerHTML="";
		pwdValid = true;
	}	
})

console.log(pwdValid);

// 닉네임 유효성 체크
let nickValid = false;
joinInputTagArr[4].addEventListener('keyup', ()=>{
	const strNick = joinInputTagArr[4].value;
	const regNick = /^[ㄱ-ㅣ가-힣]{3,5}$/;
	const nickChecked = regNick.test(strNick);
	const nickCheckDiv = document.querySelector("#nick_check");
	if(nickChecked===false){
		nickCheckDiv.innerHTML="닉네임을 올바른 형식으로 입력해주세요(한글 3-5자)";
		nickValid = false;
	} else {
		nickCheckDiv.innerHTML="";			
		nickValid = true;
	}
})

// 이메일 유효성 체크
let emailValid = false;	
joinInputTagArr[5].addEventListener('keyup', ()=>{	
	// 이메일 형식 검사
	const strEmail = joinInputTagArr[5].value;
	const regEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	const emailChecked = regEmail.test(strEmail);
	const emailCheckDiv = document.querySelector("#email_check");
	const emailBtn = document.querySelector("input[type=button]");
	
	if(strEmail.length>=1 && emailChecked===false) {
		emailCheckDiv.innerHTML="이메일 형식이 올바르지 않습니다.";
		emailBtn.disabled=true;	
		emailBtn.style.backgroundColor="#ebebeb";	
		emailBtn.style.cursor="default";
		emailValid = false;		
	} else {
		emailValid = true;	
	}

	// 이메일 중복 체크
	const jsonObj = {
		strEmail : strEmail
	}
	
	const jsonStr = JSON.stringify(jsonObj);
	
	fetch("/shoekream/member/check/email", { method: "POST" , body: jsonStr})
	.then((resp)=>{ return resp.json() })
	.then((data)=>{
		const result = data.reply;
		const isDup = (result == "no");
		const emailCheckDiv = document.querySelector("#email_check");
		if(isDup === true) {
			emailCheckDiv.innerHTML = "이미 가입한 이메일입니다.";
			emailBtn.disabled=true;	
			emailBtn.style.backgroundColor="#ebebeb";	
			emailBtn.style.cursor="default";
			emailValid = false;	
		} else {
			if(emailChecked===true){
				emailCheckDiv.innerHTML = "";
				emailBtn.disabled=false;	
				emailBtn.style.backgroundColor="black";	
				emailBtn.style.cursor="pointer";
				emailValid = true;					
			}
		}
	});	
});	


let emailAuthorized = false;
function checkValidation() {
	if(nameValid===true && idValid===true && pwdValid===true && nickValid===true && emailValid===true && emailAuthorized ===true){
		return true;
	} else {
		alert("회원가입을 할 수 없습니다. 양식을 다시 확인해주세요.");
		return false;
	}
}


function sendEmail(){
	const emailInputValue = document.querySelector("input[name=email]").value;
	const approvalArea = document.querySelector(".approval_area");		
    approvalArea.style.visibility = 'visible'; 	
 
 	fetch("/shoekream/send/email?email=" + emailInputValue, {method : "POST"})
 	.then( (resp) => { return resp.json() })
 	.then( (data) => {
		 const result = (data.mail == "ok");

		 if(result === false){
			 alert("이메일 전송에 실패했습니다. 다시 시도해주세요.");
			 return false;
		 }
		 
		 if(result === true) {
			 const authKey = data.authKey;
			 console.log(authKey);			 
			 const apprNo = document.querySelector("input[name=appr_no]");
			 const authCheck = document.querySelector("#auth_check");
			 
			 apprNo.addEventListener('keyup', ()=>{
				const apprNoValue = document.querySelector("input[name=appr_no]").value;
				let isAuthorized = (apprNoValue === authKey);
			 	if(isAuthorized === true) {
				 	authCheck.innerHTML="인증되었습니다."
				 	emailAuthorized=true;
			 	} else {
				 	authCheck.innerHTML="인증번호가 일치하지 않습니다.";
			 	} 		 
			 })			 
		 }
	 });
}
