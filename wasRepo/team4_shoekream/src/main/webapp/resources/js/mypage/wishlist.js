
const deleteArr = document.querySelectorAll("#a a");
console.log(deleteArr);

deleteArr.forEach((item)=>{
	item.addEventListener('click', (event)=>{
		const productNo = event.currentTarget.parentNode.children[1].value;	
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



