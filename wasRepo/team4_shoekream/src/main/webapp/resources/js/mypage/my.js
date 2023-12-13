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
	
	openPopUp();
	const file = imgInputTag.files[0];
	
	const imgForm = document.querySelector("#img_form");
	const formData = new FormData(imgForm);
	formData.set('file', file);
	

		fetch("/shoekream/mypage/profile/upload"
		, {method: "POST", body: formData})
		.then((resp) => { return resp.json() })
		.then((data) => {
			alert("잘 됐음");
			
			profileImg.src=""
			
		});
	
});

function openPopUp() {
	
	const url = "/shoekream/mypage/profile/upload";
	const name = "profileUpload";
	const option = "width = 500, height = 300, top = 100, left = 200, location = no";
	
	const childWindow = window.open(url, name, option);
	
}