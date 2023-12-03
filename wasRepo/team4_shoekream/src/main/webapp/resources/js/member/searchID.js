/**
 * 
 */

const emailInputTag = document.querySelector("input[name=email]");
const searchIdBtn = document.querySelector("input[type=submit]");
 
emailInputTag.addEventListener('keyup', ()=>{
	
	const regEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	
	if(regEmail.test(emailInputTag.value)){
		searchIdBtn.style.backgroundColor = "black";
		searchIdBtn.style.cursor="pointer";
		searchIdBtn.disabled = false;
	} else {
		searchIdBtn.style.backgroundColor = "#ebebeb";
		searchIdBtn.style.cursor="default";
		searchIdBtn.disabled = true;
		
	}
})