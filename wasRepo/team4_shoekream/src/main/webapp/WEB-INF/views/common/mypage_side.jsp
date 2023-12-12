<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/shoekream/resources/css/common/mypage_side.css">

</head>
<body>
      <div class="menu_container">
          <div class="menu_title">마이 페이지</div>
          <nav>
              <div class="shop_menu">
                  <div id="title">쇼핑 정보</div>
                  <ul class="shop">
                      <li><a href="/shoekream/mypage/buying">구매 내역</a></li>
                      <li><a href="/shoekream/mypage/selling">판매 내역</a></li>
                      <li><a href="/shoekream/mypage/wishlist?pno=1">관심</a></li>
                  </ul>
              </div>
              <div class="my_menu">
                  <div id="title">내 정보</div>
                  <ul class="myinfo">
                      <li><a href="/shoekream/mypage/info">로그인 정보</a></li>
                      <li><a href="/shoekream/mypage/addr">주소록</a></li>
                      <li><a href="/shoekream/mypage/payInfo">결제 정보</a></li>
                      <li><a href="/shoekream/mypage/ACCOUNT">정산 계좌</a></li>
                  </ul>
              </div>
          </nav>
      </div>
</body>


<script>

const shopTagArr = document.querySelectorAll(".shop li a");
const myInfoTagArr = document.querySelectorAll(".myinfo li a");


if(location.href.indexOf("/mypage/buying")>-1) {
	shopTagArr[0].style.fontWeight= "700";
	shopTagArr[0].style.color="#222222";	
} 
if(location.href.indexOf("/mypage/selling")>-1) {
	shopTagArr[1].style.fontWeight= "700";
	shopTagArr[1].style.color="#222222";
} 
if(location.href.indexOf("/mypage/wishlist")>-1){
	shopTagArr[2].style.fontWeight= "700";
	shopTagArr[2].style.color="#222222";
}

if(location.href.indexOf("/mypage/info")>-1) {
	myInfoTagArr[0].style.fontWeight= "700";
	myInfoTagArr[0].style.color= "#222222";
} 
if(location.href.indexOf("/mypage/addr")>-1) {
	myInfoTagArr[1].style.fontWeight= "700";
	myInfoTagArr[1].style.color= "#222222";
} 
if(location.href.indexOf("/mypage/payInfo")>-1) {
	myInfoTagArr[2].style.fontWeight= "700";
	myInfoTagArr[2].style.color= "#222222";
} 
if(location.href.indexOf("/mypage/ACCOUNT")>-1){
	myInfoTagArr[3].style.fontWeight= "700";
	myInfoTagArr[3].style.color= "#222222";
}
</script>
</html>