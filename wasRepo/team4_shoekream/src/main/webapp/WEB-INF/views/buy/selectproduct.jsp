<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/selectproduct.css">
<body>

	<div class="buy_product_area">
	     <div class="product_thumb">
	         <div class="porduct">
	             <img id="select_product" src="/shoekream/resources/img/bidding/airforce.webp">
	         </div>
	     </div>
	     <div class="product_detail">
	         <p class="code">${ infoVo.immediatePrice }</p>
	         <p class="name">${ infoVo.productName }</p>
	         <p class="translated_name">${ infoVo.productKoName }</p>
	         <div class="model_desc">
	             <p class="size_txt">${ BuyProductInfo.shoesSizes }</p>
	         </div>
	     </div>
	</div>
    
</body>
</html>