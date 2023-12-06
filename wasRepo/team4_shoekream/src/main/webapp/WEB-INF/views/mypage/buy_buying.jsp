<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/mypage/buy_buying.css">

<script defer src="/shoekream/resources/js/mypage/buy_buying.js"></script>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
        <div class="mypage_container">
            
            <%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>
            
            <div class="shoplist-container">
                <div class="shoplist-title">
                    구매 내역
                </div>
                <div class="tab-container">
                    <div class="tab" id="bidTab" onclick="location.href='/shoekream/mypage/buying/bidding?pno=1'">
                        <div id="bidCount">0</div>
                        <div id="stage">구매 입찰</div>
                    </div>
                    <div class="tab" id="pendTab" onclick="location.href='/shoekream/mypage/buying/pending?pno=1'">
                        <div id="pendCount">0</div>
                        <div id="stage">진행 중</div>
                    </div>
                    <div class="tab" id="finishTab" onclick="location.href='/shoekream/mypage/buying/finished?pno=1">
                        <div id="finishedCount">0</div>
                        <div id="stage">종료</div>
                    </div>

                </div>


                <div class="period-search">
                    <form action="/shoekream/mypage/buying" method="get">
                        <div>
                        <div class="month" id="2mths" onclick="set2Mths();">최근 2개월</div>
                        <div class="month" id="4mths" onclick="set4Mths();">4개월</div>
                        <div class="month" id="6mths" onclick="set6Mths();">6개월</div>
                        </div>
                        <input type="date" name="startDate">
                        <span>~</span>
                        <input type="date" name="endDate">
                        <input type="submit" value="조회">
                    </form>
                </div>

                <div class="guide">
                    * 한 번에 조회 가능한 기간은 최대 6개월입니다. 기간별 조회 결과는 입찰일 기준으로 노출됩니다.
                </div>

                <div class="purchase-body">
					<div class="purchase">
					   <div class="product-detail">
					       <img class="product_img" src="/shoekream/resources/img/product/logo.svg">
					       <div class="detail">
					           <div id="product">dkfsjldkjflwkejfidlsjfkdsfj</div>
					           <div id="size">250</div>
					       </div>
					   </div>
					   <div class="purchase-detail">
					  		<div>등록일</div>
					  		<div>입찰마감일</div>
					  		<div>입찰희망가</div>
					   </div>
					</div>
                </div>
            </div>
        </div>
	</main>
	
</body>
</html>