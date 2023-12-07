const joinBtn = document.querySelector("#join_btn");
const joinInputTagArr = document.querySelectorAll(".input_txt");

checkValidation();
if(checkValidation()){
	joinBtn.style.backgroundColor="black";
	joinBtn.disabled = false;
}

function checkValidation(){
	// 아이디 유효성 체크
	joinInputTagArr[0].addEventListener('keyup', ()=>{		
		// 아이디 6자 이상 12자 이하
		const idInputTag = document.querySelector("input[name=memberId]");
		const strId = joinInputTagArr[0].value;
		const idCheckDiv = document.querySelector("#id_check");
		
		if(strId.length>=1 && strId.length < 6) {
			idCheckDiv.innerHTML="6자 이상 입력해주세요";
			return false;
		} else {
			idCheckDiv.innerHTML="";
		}

		// 아이디 중복체크
		fetch("/shoekream/member/check/id?memberId=" +  strId, {method: "POST"})
		.then((resp) => { return resp.json() })
		.then((data) => { 
			const result = data.msg;
			const isDup = (result == "no");
					
					
			if(isDup===true) {
				idCheckDiv.innerHTML="사용할 수 없는 아이디입니다.(중복)";
				return false;
			} 
			
			if(isDup===false){
				idCheckDiv.innerHTML="";
			}
		});	
	})
	
	
	// 비밀번호 유효성 체크
	// 비밀번호 영문, 숫자, 특수문자 조합 8-16자
	joinInputTagArr[1].addEventListener('keyup', ()=>{
		const strPwd = joinInputTagArr[1].value;
		const regPwd = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		const pwdChecked = regPwd.test(strPwd);
		const pwdCheckDiv = document.querySelector("#pwd_check");
		
		if(strPwd.length>1 && pwdChecked===false) {
			pwdCheckDiv.innerHTML="영문, 숫자, 특수문자를 조합해서 입력해주세요.(8-16자)";
			return false;	
		} else {
			pwdCheckDiv.innerHTML="";		
		}
	})
	
	// 비밀번호 확인 작업(일치 여부)
	joinInputTagArr[2].addEventListener('keyup', ()=>{	
		const strPwd = joinInputTagArr[1].value;	
		const strPwd2 = joinInputTagArr[2].value;
		const pwd2CheckDiv = document.querySelector("#pwd2_check");
		
		if(strPwd2.length>1 && strPwd !== strPwd2) {
			pwd2CheckDiv.innerHTML="비밀번호와 일치하지 않습니다.";
			return false;
		} else {
			pwd2CheckDiv.innerHTML="";
		}	
	})
	
	// 닉네임 유효성 체크
	joinInputTagArr[3].addEventListener('keyup', ()=>{
		const strNick = joinInputTagArr[3].value;
		const regNick = /^[ㄱ-ㅣ가-힣]{3,5}$/;
		const nickChecked = regNick.test(strNick);
		console.log(nickChecked);
		const nickCheckDiv = document.querySelector("#nick_check");
		if(nickChecked===false){
			nickCheckDiv.innerHTML="닉네임을 올바른 형식으로 입력해주세요(한글 3-5자)";
			return false;
		} else {
			nickCheckDiv.innerHTML="";			
		}
	})
	
	
	// 이메일 유효성 체크
	joinInputTagArr[4].addEventListener('keyup', ()=>{		
		// 이메일 형식 검사
		const strEmail = joinInputTagArr[4].value;
		const regEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
		const emailChecked = regEmail.test(strEmail);
		const emailCheckDiv = document.querySelector("#email_check");
		const emailBtn = document.querySelector("input[type=button]");
		
		if(strEmail.length>=1 && emailChecked===false) {
			emailCheckDiv.innerHTML="이메일 형식이 올바르지 않습니다.";
			emailBtn.disabled=true;	
			emailBtn.style.backgroundColor="#ebebeb";	
			emailBtn.style.cursor="default";	
			return false;	
		} else {
			
		}
		
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
				return false;
			} else {
				if(emailChecked===true){
					emailCheckDiv.innerHTML = "";
					emailBtn.disabled=false;	
					emailBtn.style.backgroundColor="black";	
					emailBtn.style.cursor="pointer";					
				}
			}
		});	
	})	
	
	return true;
}



function sendEmail(){
	const emailInputValue = document.querySelector("input[name=email]").value;
	const approvalArea = document.querySelector(".approval_area");		
    approvalArea.style.visibility = 'visible'; 	
 
 	fetch("/shoekream/send/email?email=" + emailInputValue, {method : "POST"})
 	.then( (resp) => { return resp.json() })
 	.then( (data) => {
		 const result = (data.reply == "ok")
		 console.log(data.reply);
		 if(result === false){
			 alert("이메일 전송에 실패했습니다.");
		 }
	 })

}