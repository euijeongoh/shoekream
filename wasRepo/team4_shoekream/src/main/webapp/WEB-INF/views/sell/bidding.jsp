<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/sell/bidding.css">
    <link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">
    
    <script defer src="/shoekream/resources/js/bidding/sell/bidding.js"></script>
    <!-- <script defer src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script> -->
    <script type="text/javascript" src="/shoekream/resources/js/bidding/sell/moment.min.js"></script>
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
                            <span>판매 입찰하기</span>
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
                            <form action="/shoekream/sell/now" method="post" >
                        		<input class="productsNo" type="hidden" name="productsNo" value="${ productsNo }">
                        		<input class="sellPrice" type="hidden" name="price" value="${ sellPrVo.price }">
                                <input class="sellSize" type="hidden" name="size" value="${ sellPrVo.shoesSizes }">
                                <ul class="tab_list">
                                    <li class="item">
                                        <a color class="item_link">판매 입찰</a>
                                    </li>
                                    <li class="item_on">
                                        <button class="btn1" type="submit">즉시 판매</button>
                                    </li>
                                </ul>
                            </form>
                        </div>
                        <div class="price_now">
                            <dl class="price_now_box">
                                <dt class="price_now_title">판매 희망가</dt>
                                <dd class="price">
                                    <input class="input_amount1" type="text" placeholder="희망가 입력">
                                    <span class="unit_b">원</span>
                                </dd>
                            </dl>
                            <div class="price_warning"></div>
                        </div>
                        <div class="price_bind">
                            <dl class="price_addition">
                                <dt class="price_title">
                                    <span id="fo">검수비</span>
                                </dt>
                                <dd class="price_text">무료</dd>
                            </dl>
                            <dl class="price_addition">
                                <dt class="price_title">
                                    <span id="fo">수수료</span>
                                </dt>
                                <dd class="price_text" id="textar">-</dd>
                            </dl>
                            <dl class="price_addition">
                                <dt class="price_title">
                                     <span id="fo">배송비</span>
                                </dt>
                                <dd class="price_text">선불, 판매자 부담</dd>
                            </dl>
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
                    <!-- 여기부터 ㄱㄱ -->
                    <div class="price_total">
                        <dl class="price_box">
                            <dt class="price_title">정산금액</dt>
                            <dd class="price_b">
                                <span class="amount_c">-</span>
                                <span class="unit"></span>
                            </dd>
                        </dl>
                    </div>
                    <form action="/shoekream/sell/biddingsattle">
                        <div class="btn_confirm" onmouseover="mouseover()">
                            <a blind class="blind_full_solid_false">계속하기</a>
                            <button class="blind_full_solid_false">판매 입찰 계속</button>
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