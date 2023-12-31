<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/sell/nowsattle.css">
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
                            <span>주문/정산</span>
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
    <!-- 헤더 -->
    

    <div class="container">
        <div class="content">
            <div class="buy_immediate">

                <!-- 상품 정보 -->
           		<%@ include file="/WEB-INF/views/buy/selectproduct.jsp" %>
                <!-- 상품 정보 -->

                <div class="display_separator"></div>

                <!-- 판매 정산 계좌 -->
                <div class="section_payout_account">
                    <div class="payout_account_area">
                        <div class="section_title">
                            <h3 class="title_txt">판매 정산 계좌</h3>
                        </div>
                        <div class="section_content_b">
                            <div class="account_info">
                                <dl class="info_list">
                                    <div class="info_box">
                                        <dt class="title">계좌</dt>
                                        <dd class="desc">${ accInfo.bankAgentName }${ accInfo.accountNumber }</dd>
                                    </div>
                                    <div margin class="info_box">
                                        <dt class="title">예금주</dt>
                                        <dd class="desc">${ loginMember.name }</dd>
                                    </div>
                                </dl>
                            </div>
                            <a class="btn_account_edit">변경</a>
                        </div>
                    </div>
                </div>
                <!-- 판매 정산 계좌 -->

                <div class="display_separator"></div>
                
                <!-- 반송 주소 -->
                <section>
                    <div class="section_unit">
                        <div class="section_title">
                            <h3 class="title_txt">반송 주소</h3>
                            <a class="add_more_btn">+ 새 주소 추가</a>
                        </div>
                        <div class="section_content">
                            <div class="delivery_info">
                                <div class="address_info">
                                    <dl class="info_list">
                                        <div class="info_box">
                                            <dt class="title">받는 분</dt>
                                            <dd class="desc">${addInfo.addersName}</dd>
                                        </div>
                                        <div class="info_box">
                                            <dt class="title">연락처</dt>
                                            <dd class="desc">${addInfo.phoneNumber}</dd>
                                        </div>
                                        <div class="info_box">
                                            <dt class="title">배송 주소</dt>
                                            <dd class="desc">${addInfo.addres}${addInfo.detailAddres}</dd>
                                        </div>
                                    </dl>
                                </div>
                                <a class="btn_edit">변경</a>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- 반송 주소 -->
                
                <div class="display_separator"></div>

                <!-- 최종 주문정보 -->
                <div class="section_orderinfo">
                    <div class="orderinfo_area">
                        <div class="title_wrap">
                            <div>
                                <p class="wrap_title">최종 주문정보</p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">즉시 판매가</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        ${ dbVo.price }원
                                    </em>
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">검수비</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        무료
                                    </em>
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">수수료</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        -${ commission }원
                                    </em>
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">배송비</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        선불,판매자 부담
                                    </em>
                                </p>
                            </div>
                        </div>
                        <!-- 입찰 -->
                        <!-- <div class="display_line"></div>
                        <div class="title_description">
                            <p class="line_title">입찰 마감기한</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        60일-2024/01/31
                                    </em>
                                </p>
                            </div>
                        </div> -->
                        <!-- 입찰 -->
                    </div>
                </div>
                <!-- 최종 주문정보 -->

                <!-- 결제하기 -->
                <div class="buy_total_confirm">
                    <div class="price_total">
                        <dl class="price_box">
                            <dt class="price_title">정산금액</dt>
                            <dd class="price_empty_desc">
                                <span class="amount">${ totalAmount }</span>
                                <span class="unit">원</span>
                            </dd>
                        </dl>
                        <span class="price_warning">
                            <em></em>
                        </span>
                    </div>
                    <form action="/shoekream/sell/order" method="get">
	                    <div class="btn_confirm">
	                    	<input class="memberNo" type="hidden" name="memberNo" value="${ loginMember.no }">
	                        <input class="biddingNo" type="hidden" name="biddingNo" value="${ BuyProductInfo.no }">
	                        <input class="productsNo" type="hidden" name="productsNo" value="${ BuyProductInfo.productsNo }">
	                        <a blind class="blind_full_solid_false">계속하기</a>
	                        <button class="blind_full_solid_false">바로 판매하기</button>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
        
    <!-- 풋터 -->
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