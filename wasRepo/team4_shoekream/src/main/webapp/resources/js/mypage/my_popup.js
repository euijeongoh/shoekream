const uploadBtn = window.document.querySelector("#upload_profile");
const fileInput = window.document.querySelector("input[name=f]");

uploadBtn.addEventListener('click', ()=>{
	
	window.opener.parent.location.reload();
	
})