
const deleteArr = document.querySelectorAll("#a");

function deleteWish() {
	
	deleteArr.forEach((item)=>{
		item.addEventListener('click', (event)=>{
			const productNo = event.target.nextSibling.value;	
			console.log(productNo);	
			fetch("/shoekream/mypage/wishlist/delete?productNo=" + productNo)
			.then((resp)=>{return resp.json()})
			.then((data)=>{
			if(data.msg==="done"){
				const parentDiv = event.target.parentNode.parentNode.parentNode;
				parentDiv.remove();		
			}		
			});
		})
	})
}



