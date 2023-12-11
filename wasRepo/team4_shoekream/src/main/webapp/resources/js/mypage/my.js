/**
 * 
 */

const imgInputTag = document.querySelector("#img_upload");
const profileImg = document.querySelector("#profile-img");

profileImg.addEventListener('click', () => {
	imgInputTag.click();
})


const changeProfile = document.querySelector("#change_profile");

changeProfile.addEventListener('click', () => {
	
	const file = imgInputTag.files[0];
	
	const imgForm = document.querySelector("#img_form");
	const formData = new FormData(imgForm);
	formData.set('file', file);
	

		fetch("/shoekream/mypage/profile/upload"
		, {method: "POST", body: formData})
		.then((resp) => { return resp.json() })
		.then((data) => {
			alert("잘 됐음");
			
		});
	
});