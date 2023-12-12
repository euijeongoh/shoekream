
const deleteA = document.querySelector("#a");
deleteA.addEventListener('click', (event)=>{
	const productNo = document.querySelector("input[name=productNo]");
	fetch("/shoekream/mypage/wishlist/delete?productNo=" + productNo.value)
	.then((resp)=>{return resp.json()})
	.then((data)=>{
		if(data.msg==="done"){
			const parentDiv = event.target.parentNode.parentNode.parentNode;
			parentDiv.remove();		
		}		
	});
	
})

