const nameInputTag = document.querySelector("input[name=adminName]");
const phoneInputTag = document.querySelector("input[name=adminPhone]");
const searchIdBtn = document.querySelector("input[type=submit]");
 
phoneInputTag.addEventListener('keyup', ()=>{
	
	const regPhone = /^[0-9]{3}[-]+[0-9]{4}[-]+[0-9]{4}$/;
	
	if(nameInputTag.length >= 1 && regPhone.test(phoneInputTag.value)){
		searchIdBtn.style.backgroundColor = "black";
		searchIdBtn.style.cursor="pointer";
		searchIdBtn.disabled = false;
	}
	
	if(nameInputTag.length===0 || regPhone.test(phoneInputTag.value)===false) {
		searchIdBtn.style.backgroundColor = "#ebebeb";
		searchIdBtn.style.cursor="default";
		searchIdBtn.disabled = true;	
	}
})