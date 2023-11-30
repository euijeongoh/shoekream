<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/common/mypage_side.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/mypage/my.css"> 

<script defer src="/shoekream/resources/js/mypage/my.js"></script>

</head>
<body>

<!-- 헤더 -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<main>
        <div class="mypage_container">
			<!-- 마이페이지 메뉴 -->
			<%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>

            <div class="mypage-home">
                <div class="profile">
                    <div class="user-detail">
                        <div><img id="profile-img"></div>
                        <div class="user-info">
                            <div>가리반</div>
                            <div>sillacurry</div>
                            <div>
                            	<input id="img_upload" type="file" accept="image/*" style="display:none">
                            	<button type="button">내 리뷰</button>
                            </div>
                        </div>
                    </div>
                    <div class="user-menu">
                        <div class="icon">
                            <div>
                                <a>
                                <img src="/shoekream/resources/img/mypage/pointicon.png">
                                <div>포인트</div>      
                                </a>
                            </div>
                        </div>  
                        <div class="icon">
                            <div>
                                <a>
                                <img src="/shoekream/resources/img/mypage/noticeicon.png">
                                <div>공지사항</div>      
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mypage-title">
                    <span>구매 내역</span>
                    <span>더보기</span>
                </div>
                <div class="count-box">
                    <div class="tab">
                        <div>전체</div>
                        <div>0</div>
                    </div>
                    <div class="tab">
                        <div>입찰 중</div>
                        <div>0</div>
                    </div>
                    <div class="tab">
                        <div>진행 중</div>
                        <div>0</div>
                    </div>
                    <div class="tab">
                        <div>종료</div>
                        <div>0</div>
                    </div>
                </div>
                <div class="my-list">
                    <div>거래 내역이 없습니다.</div>
                </div>


                <div class="mypage-title">
                    <span>판매 내역</span>
                    <span>더보기</span>
                </div>
                <div class="count-box">
                    <div class="tab">
                        <div>전체</div>
                        <div>0</div>
                    </div>
                    <div class="tab">
                        <div>입찰 중</div>
                        <div>0</div>
                    </div>
                    <div class="tab">
                        <div>진행 중</div>
                        <div>0</div>
                    </div>
                    <div class="tab">
                        <div>종료</div>
                        <div>0</div>
                    </div>
                </div>
                <div class="my-list">
                    <div>거래 내역이 없습니다.</div>
                </div>


                <div class="mypage-title">
                    <span>관심 상품</span>
                    <span>더보기</span>
                </div>
                <ul class="product-list-wrap">
                    <li>
                        <div id="product-img">
                            <img src="./resources/product1.webp">
                        </div>
                        <div class="info-box">
                            <div id="brand">Nike</div>
                            <div id="model-name">Nike x Ambush Air More Uptempo Low Black and White</div>
                            <div id="price">250,000원</div>
                        </div>
                    </li>
                    <li>
                        <div id="product-img">
                            <img src="./resources/product1.webp">
                        </div>
                        <div class="info-box">
                            <div id="brand">Nike</div>
                            <div id="model-name">Nike x Ambush Air More Uptempo Low Black and White</div>
                            <div id="price">250,000원</div>
                        </div>
                    </li>
                    <li>
                        <div id="product-img">
                            <img src="./resources/product1.webp">
                        </div>
                        <div class="info-box">
                            <div id="brand">Nike</div>
                            <div id="model-name">Nike x Ambush Air More Uptempo Low Black and White</div>
                            <div id="price">250,000원</div>
                        </div>
                    </li>
                    <li>
                        <div id="product-img">
                            <img src="./resources/product1.webp">
                        </div>
                        <div class="info-box">
                            <div id="brand">Nike</div>
                            <div id="model-name">Nike x Ambush Air More Uptempo Low Black and White</div>
                            <div id="price">250,000원</div>
                        </div>
                    </li>
                </ul>
             </div>
        </div>

	</main>

</body>
</html>