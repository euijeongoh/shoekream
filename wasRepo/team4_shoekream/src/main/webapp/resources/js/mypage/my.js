/**
 * 
 */

// 프로필 이미지 업로드 + 업로드 후에 프로필 영역에 사진 뜨게
function openPopup() {
	const url = "/shoekream/mypage/profile/upload";
	const name = "프로필 이미지 바꾸기";
	const option = "width = 600, height = 300, top = 100, left = 200, location = no"
	window.open(url, name, option);
}


imgInputTag.addEventListener('change', ()=>{
	const fileReader = new FileReader();
	fileReader.onload = ({target}) => {
		profileImg.src = target.result;
	};
	fileReader.readAsDataURL(imgInputTag.files[0]);
})