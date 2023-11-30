/**
 * 
 */

// 프로필 이미지 업로드 + 업로드 후에 프로필 영역에 사진 뜨게
const profileImg = document.querySelector("#profile-img");
const imgInputTag = document.querySelector("#img_upload");
profileImg.addEventListener('click', ()=>{
	imgInputTag.click();
})

imgInputTag.addEventListener('change', ()=>{
	const fileReader = new FileReader();
	fileReader.onload = ({target}) => {
		profileImg.src = target.result;
	};
	fileReader.readAsDataURL(imgInputTag.files[0]);
})