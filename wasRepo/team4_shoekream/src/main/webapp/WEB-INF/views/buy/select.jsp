<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.shoekream.biddingVo.BiddingVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/buy/select.css">
	<link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">
	
	<script defer src="/shoekream/resources/js/bidding/buy/select.js"></script>
	
<body>
    <div class="wrap">
        <header>
            <div class="header-inner">
                <div class="top-list">
                    <ul>
                        <li><a href="">고객센터</a></li>
                        <li><a href="">마이페이지</a></li>
                        <li><a href="">관심</a></li>
                        <li><a>알림</a></li>
                        <li><a href="">로그인</a></li>
                    </ul>
                </div>
                <div class="main-list">
                    <div class="logo-area">
                        <a href="">
                        <img src="/shoekream/resources/img/header/logo.svg">
                        </a>
                    </div>
                    <div class="center">
                        <h2 class="h2_buy">
                            <span>구매하기</span>
                        </h2>
                    </div>
                    <div class="right">
                        <button type="button" class="btn_standard">
                            검수기준
                        </button>
                    </div>
                </div>
            </div>
        </header>
    </div>

    <div class="container buy lg">
        <div class="content_area">
            <div class="buy_before">
                <div id="buy_before_check">
                    <div class="product_info">
                        <div class="product_thumb">
                            <div class="porduct">
                                <img id="airforce" src="/shoekream/resources/img/bidding/airforce.webp">
                            </div>
                        </div>
                        <div class="product_detail">
                            <p class="code">CJ9179-200</p>
                            <p class="name">Nike Air Force 1 '07 WB Flax</p>
                            <p class="translated_name">나이키 에어포스 1 '07 WB 플랙스</p>
                        </div>
                    </div>
                    <div><div></div></div>
                    <div class="buy_before_select">
                        <div class="select_area md">
                            <ul class="select_list grid_3">
								<c:forEach items="${ voList }" var="vo">
	                            	<li id="select_item">
	                                    <button type="button" class="select_link buy" onclick="f01('46', '${ vo.price }', '${ vo.shoesSizes }' )">
	                                        <div class="link_inner">
	                                            <div class="size">${ vo.shoesSizes }</div>
	                                            <div class="price">${ vo.price }</div>
	                                        </div>
	                                    </button>
	                                </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="order_btn_area">
                            <form action="/shoekream/buy/select" method="post">
                                <button class="btn_order order_buy buy clickable">
                                    <div class="box">
                                        <input class="products_No" value="" type="hidden" name="productsNo">
                                        <input class="products_price" value="" type="hidden" name="price">
                                        <input class="products_size" type="hidden" name="size">
                                        <div class="order_price">-</div>
                                        <div class="order_desc">5-7일소요</div>
                                    </div>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="box1"></div>
        <div class="box2">
            <div></div>
            <div>고객센터 1588-4444</div>
        </div>
        <div class="box3">
            <div class="left_bar">
                <div>고객지원</div>
                <div>공지사항</div>
                <div>1:1문의</div>
                <div>상품 등록 문의</div>
            </div>
            <div class="icons">
                <div>
                    <img src="/shoekream/resources/img/footer/인별.png" alt="인별">
                </div>
                <div>
                    <img src="/shoekream/resources/img/footer/페북.png" alt="페북">
                </div>
                <div>
                    <img src="/shoekream/resources/img/footer//카톡.png" alt="카톡">
                </div>
            </div>
            <div></div>
            <div class="faq">
                <button>자주 묻는 질문</button>
            </div>
        </div>
        <div class="box4"></div>
    </footer>

</body>
</html>