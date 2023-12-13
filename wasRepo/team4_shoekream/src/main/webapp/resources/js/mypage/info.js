const infoInputTagArr = document.querySelectorAll(".input-box");

function updateId() {
	const strId = infoInputTagArr[0].value;
	
	if(strId.length<6) {
		alert("아이디는 6자 이상이어야 합니다.");
	}
	
	
	
	fetch("/shoekream/member/update/id", {method: "POST"})
	.then( (resp) => { return resp.json() })
	.then( (data) => {
		
	})
}




let idValid = false;
infoInputTagArr[0].addEventListener('keyup', () => {
	// 아이디 6자 이상 12자 이하
	const strId = infoInputTagArr[0].value;
	const idCheckDiv = document.querySelector("#id_check");
	
	if((strId.length>=1 && strId.length < 6) || strId.length===0) {
		idCheckDiv.innerHTML="6자 이상 입력해주세요";
	} else {
		idCheckDiv.innerHTML="";
		idValid = true;
	}
	
	const jsonObj = {
		strId : strId
	}
	
	const jsonStr = JSON.stringify(jsonObj);

	// 아이디 중복체크
	fetch("/shoekream/member/check/id", 
		{method: "POST", body: jsonStr})
	.then((resp) => { return resp.json() })
	.then((data) => { 
		const result = data.msg;
		const isDup = (result == "no");
		console.log("isDup" + isDup);	
		if(isDup===true) {
			idCheckDiv.innerHTML="사용할 수 없는 아이디입니다.(중복)";
		} 
		
		if(isDup===false){
			idValid = true;
			idCheckDiv.innerHTML="";
		}
	});	
});

let pwdValid = false;
infoInputTagArr[1].addEventListener('keyup', ()=>{
	const strPwd = infoInputTagArr[1].value;
	const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
	const pwdChecked = regPwd.test(strPwd);
	const pwdCheckDiv = document.querySelector("#pwd_check");
	
	if(strPwd.length>=1 && pwdChecked===false) {
		pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";
	} else {
		pwdCheckDiv.innerHTML="";
		pwdValid = true;		
	}
});

let nickValid = false;
infoInputTagArr[2].addEventListener('keyup', ()=>{
	const strNick = infoInputTagArr[2].value;
	const regNick = /^[ㄱ-ㅣ가-힣]{3,5}$/;
	const nickChecked = regNick.test(strNick);
	const nickCheckDiv = document.querySelector("#nick_check");
	if(nickChecked===false){
		nickCheckDiv.innerHTML="닉네임을 올바른 형식으로 입력해주세요(한글 3-5자)";
	} else {
		nickCheckDiv.innerHTML="";			
		nickValid = true;
	}
});

let emailValid = false;	
infoInputTagArr[3].addEventListener('keyup', ()=>{	
	// 이메일 형식 검사
	const strEmail = infoInputTagArr[3].value;
	const regEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	const emailChecked = regEmail.test(strEmail);
	const emailCheckDiv = document.querySelector("#email_check");
	const emailBtn = document.querySelector("#send_email");
	
	if(strEmail.length>=1 && emailChecked===false) {
		emailCheckDiv.innerHTML="이메일 형식이 올바르지 않습니다.";
		emailBtn.disabled=true;	
		emailBtn.style.backgroundColor="#ebebeb";	
		emailBtn.style.cursor="default";
	} else {
		emailValid = true;	
	}

	// 이메일 중복절차	
	fetch("/shoekream/member/check/email?email=" + strEmail, { method: "POST" })
	.then((resp)=>{ return resp.json() })
	.then((data)=>{
		const result = data.reply;
		console.log(result);
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
	if(idValid===true && pwdValid===true && nickValid===true && emailValid===true && emailAuthorized===true){
		return true;
	} else {
		alert("회원정보 수정을 할 수 없습니다. 양식을 다시 확인해주세요.");
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
				console.log(apprNoValue);
			 	console.log(isAuthorized);
			 	if(isAuthorized) {
				 	authCheck.innerHTML="인증되었습니다."
				 	emailAuthorized=true;
			 	} else {
				 	authCheck.innerHTML="인증번호가 일치하지 않습니다.";
			 	} 		 
			 })			 
		 }
	});
}