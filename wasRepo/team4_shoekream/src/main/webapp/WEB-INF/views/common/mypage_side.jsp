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
                  <ul>
                      <li><a href="/shoekream/mypage/buying?tab=bidding">구매 내역</a></li>
                      <li><a href="/shoekream/mypage/selling?tab=bidding">판매 내역</a></li>
                      <li><a href="/shoekream/mypage/wishlist">관심</a></li>
                  </ul>
              </div>
              <div class="my_menu">
                  <div id="title">내 정보</div>
                  <ul>
                      <li><a href="/shoekream/mypage/info">로그인 정보</a></li>
                      <li><a href="/shoekream/mypage/addr">주소록</a></li>
                      <li><a href="/shoekream/mypage/payInfo">결제 정보</a></li>
                      <li><a href="/shoekream/mypage/ACCOUNT">정산 계좌</a></li>
                      <li><a href="/shoekream/mypage/point">포인트</a></li>
                  </ul>
              </div>
          </nav>
      </div>
</body>
</html>