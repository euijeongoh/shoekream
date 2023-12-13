<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/buy/now.css">
    <link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">

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
                            <span>즉시 구매하기</span>
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
                <!-- 상품 정보 -->
                <%@ include file="/WEB-INF/views/buy/selectproduct.jsp" %>
                <!-- 상품 정보 -->
                

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
                            <ul class="tab_list">
                                <form action="/shoekream/buy/bidding" method="post" style="height: 50%; width: 50%;">
                                    <li class="item">
                                        <button class="item_link" id="btn1" type="submit" >구매 입찰</button>
                                        <!-- <a class="item_link">구매 입찰</a> -->
                                        <input type="hidden" name="productsNo" value="${ productsNo }">
                                        <input class="buyPrice" type="hidden" name="buyPrice" value="${ buyPrVo.price }">
                                        <input class="buySize" type="hidden" name="buySize" value="${ buyPrVo.shoesSizes }">
                                        <input class="sellPrice" type="hidden" name="sellPrice" value="${ sellPrVo.price }">
                                        <input class="sellSize" type="hidden" name="sellSize" value="${ sellPrVo.shoesSizes }">
                                    </li>
                                </form>
                                <li class="item_on">
                                    <a color class="item_link">즉시 구매</a>
                                </li>
                            </ul>
                        </div>
                        <div class="price_now">
                            <dl class="price_now_box">
                                <dt class="price_now_title">즉시구매가</dt>
                                <dd class="price">
                                    <span class="amount_b">${ buyPrVo.price }</span>
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

                <!-- 즉시 구매 계속 -->
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
                    <form action="/shoekream/buy/nowpayment">
                        <div class="btn_confirm">
                            <input 					type="hidden" name="loginMemberNo" value="${ loginMember.no }">
                            <input 					type="hidden" name="productsNo" value="${ productsNo }">
                            <input class="buyPrice" type="hidden" name="buyPrice" value="${ buyPrVo.price }">
                            <input class="buySize" type="hidden" name="buySize" value="${ buyPrVo.shoesSizes }">
                            <a blind class="blind_full_solid_false">계속하기</a>
                            <button type="submit" class="blind_full_solid_false">즉시 구매 계속</button>
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

</body>
</html>