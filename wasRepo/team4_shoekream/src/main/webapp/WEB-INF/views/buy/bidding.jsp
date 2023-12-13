<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/buy/bidding.css">
	<link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">

    <script defer src="/shoekream/resources/js/bidding/buy/bidding.js"></script>
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <!-- <script type="text/javascript" defer src="/shoekream/WEB-INF/lib/moment.min.js"></script> -->
</head>
<!-- <html>
    <script>
        $(document).ready(function(){
            alert('jquery 동작합니다');            
        })
    </script>
</html> -->

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
                            <span>구매 입찰하기</span>
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

    

    <div class="container">
        <div class="content">
            <div class="buy_immediate">
            
				<%@ include file="/WEB-INF/views/buy/selectproduct.jsp" %>

                <div class="price_descision_box">

                    <ul class="price_list">
                        <li class="list_item">
                            <p class="title">즉시 구매가</p>
                            <div style="display: flex; justify-content: center;">
                                <span class="price_a">${ buyPrVo.price }</span>
                                <span class="unit_a">원</span>
                            </div>
                        </li>
                        <li class="list_item">
                            <p class="title">즉시 판매가</p>
                            <div style="display: flex; justify-content: center;">
                                <span class="price_a">${ sellPrVo.price }</span>
                                <span class="unit_a">원</span>
                            </div>
                        </li>
                    </ul>

                    <div class="instant_group">
                        <div class="tab_area">
                        	<form action="/shoekream/buy/now" method="post" >
                        		<input class="productsNo" type="hidden" name="productsNo" value="${ productsNo }">
                        		<input class="buyPrice" type="hidden" name="price" value="${ buyPrVo.price }">
                                <input class="buySize" type="hidden" name="size" value="${ buyPrVo.shoesSizes }">
<%--                                 <input class="sellPrice" type="hidden" name="sellPrice" value="${ sellPrVo.price }"> --%>
<%--                                 <input class="sellSize" type="hidden" name="sellSize" value="${ sellPrVo.shoesSizes }"> --%>
	                            <ul class="tab_list">
	                                <li class="item">
	                                    <a item_link_color class="item_link">구매 입찰</a>
	                                </li>
	                                <li class="item_on">
<!-- 	                                    <a class="item_link">즉시 구매</a> -->
	                                    <button id="btn1" type="submit" >즉시 구매</button>
	                                </li>
	                            </ul>
                            </form>
                        </div>
                        <div class="price_now">
                            <dl class="price_now_box">
                                <dt class="price_now_title">구매 희망가</dt>
                                <dd class="price">
                                    <!-- input_amount1 이거 CSS 안됨.. -->
                                    <input class="input_amount1" type="number" max="${ buyPrVo.price }" min="1000" placeholder="희망가 입력">
                                    <span class="unit_b">원</span>
                                </dd>
                            </dl>
                            <div class="price_warning"></div>
                        </div>
                        <div class="price_bind">
                            <p class="price_bind_empty">총 결제금액은 다음 화면에서 계산됩니다.</p>
                        </div>
                    </div>

                </div>
            <!-- 여기부터 ㅡㅡ -->
                <div class="deadline_info_area">
                    <div class="section_title">
                        <h3 class="title_txt">입찰 마감기한</h3>
                    </div>
                    <div class="section_content">
                        <div class="bid_deadline">
                            <p class="deadline_txt">-</p>
                            <div class="deadline_tab">
                                <a class="btnoutlinegrey">1일</a>
                                <a class="btnoutlinegrey">3일</a>
                                <a class="btnoutlinegrey">7일</a>
                                <a class="btnoutlinegrey">30일</a>
                                <a class="btnoutlinegrey" id="btnoutlinegrey_color">60일</a>
                            </div>
                        </div>
                    </div>
                </div>
            <!-- 여기부터 ㅡㅡ -->
                <div class="buy_total_confirm">
                    <div class="price_total">
                        <dl class="price_box">
                            <dt class="price_title">총 결제금액</dt>
                            <dd class="price_empty_desc">다음 화면에서 확인</dd>
                        </dl>
                        <span class="price_warning">
                            <em></em>
                        </span>
                    </div>
                    <form action="/shoekream/buy/biddingpayment">
                        <div class="btn_confirm" onmouseover="mouseover()">
                            <a blind class="blind_full_solid_false">계속하기</a>
                            <button class="blind_full_solid_false" type="submit" >구매 입찰 계속</button>
                            <input class="deadline" type="hidden" name="deadline" value="">
                            <input class="biddingPrice" type="hidden" name="biddingPrice" value="">
                            
                            <input type="hidden" name="loginMemberNo" value="${ loginMember.no }">
                         	<input type="hidden" name="productsNo" value="${BuyProductInfo.productsNo}">
	                        <input type="hidden" name="buyPrice" value="${BuyProductInfo.price}">
	                        <input type="hidden" name="buySize" value="${BuyProductInfo.shoesSizes}">
                        </div>
                    </form>
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
                    <img src="/shoekream/resources/img/footer/카톡.png" alt="카톡">
                </div>
            </div>
            <div></div>
            <div class="faq">
                <button>자주 묻는 질문</button>
            </div>
        </div>
        <div class="box4"></div>
    </footer>



    <script>
        const searchBtn = document.querySelector("#search-btn");
    </script>

</body>
</html>