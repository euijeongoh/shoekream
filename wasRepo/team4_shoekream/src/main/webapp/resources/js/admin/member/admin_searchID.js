const nameInputTag = document.querySelector("input[name=adminName]");
const phoneInputTag = document.querySelector("input[name=adminPhone]");
const searchIdBtn = document.querySelector("input[type=submit]");
 
emailInputTag.addEventListener('keyup', ()=>{
	
	const regPhone = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	
	if(nameInputTag.length >= 1 && regPhone.test(phoneInputTag.value)){
		searchIdBtn.style.backgroundColor = "black";
		searchIdBtn.style.cursor="pointer";
		searchIdBtn.disabled = false;
	} else {
		searchIdBtn.style.backgroundColor = "#ebebeb";
		searchIdBtn.style.cursor="default";
		searchIdBtn.disabled = true;
		
	}
})