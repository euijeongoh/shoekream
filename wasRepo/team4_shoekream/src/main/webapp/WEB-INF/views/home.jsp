<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/home.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/common/homemenu.css"> 

<script src="/resources/js/common/homemenu.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<%@ include file="/WEB-INF/views/common/homemenu.jsp" %>

    <div class="main_img">
        <img src="./resources/mainimg.webp">
    </div>

    <div class="home_products">
        <div class="container_title">
            <div class="title">
                <div id="title">New In</div>
                <div id="sub_title">신규 등록 상품</div>
            </div>
            <div id="more"><a href="">더보기</a></div>
        </div>
        <ul class="product_list_wrap">
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
        </ul>
    </div>


    
    <div class="home_products">
        <div class="container_title">
            <div class="title">
                <div id="title">New Lowest Asks</div>
                <div id="sub_title">새로운 즉시 구매가</div>
            </div>
            <div id="more"><a href="">더보기</a></div>
        </div>
        <ul class="product_list_wrap">
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
            <li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand">Nike</div>
                    <div id="model_name">Nike x Ambush Air More Uptempo Low Black and White</div>
                    <div id="price">250,000원</div>
                </div>
            </li>
        </ul>
    </div>
</body>

<script>
// homemenu js
const mainSpan = document.querySelector("#menutab #main");
const rankingSpan = document.querySelector("#menutab #ranking");

window.onload=() => {
    if(location.href.indexOf("/shoekream/home")>-1) {
    mainSpan.style.color="rgba(34, 34, 34)";
    mainSpan.style.fontWeight = "700";
	mainSpan.style.borderBottom = "3px solid rgba(34, 34, 34)";
    }

    // if(location.href="/shoekream/ranking") {
    // rankingSpan.style.borderBottom="2px solid rgba(34, 34, 34)";
    // }
}

// header js

</script>
</html>