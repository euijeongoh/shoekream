<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/sell/biddingsattle.css">
    <link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">
<body>
    <!-- <div class="wrap">
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
    </div> -->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>

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
                                        <dd class="desc">${ accInfo.depositor }</dd>
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

                <!-- 결제 방법 -->
                <!-- <div class="section_payment">
                    <div class="payment_area">
                        <div class="payment_title">
                            <h3 class="payment_title_txt">결제 방법</h3>
                        </div>
                        <div>
                            <div class="payment_card">
                                <h4 class="method_title">
                                    <div class="main_title">
                                        <p class="payment">카드 간편결제</p>
                                    </div>
                                </h4>
                                <div>
                                    <div class="card_list">
                                        <div class="main_card">
                                            <a class="regist_link">
                                                <span class="regist_text">카드를 등록하세요</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
                <!-- 결제 방법 -->

                <!-- <div class="display_separator"></div> -->

                <!-- 최종 주문정보 -->
                <div class="section_orderinfo">
                    <div class="orderinfo_area">
                        <div class="title_wrap">
                            <div>
                                <p class="wrap_title">최종 주문정보</p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">판매 희망가</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        ${ biddingPrice }원
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
                        <div class="display_line"></div>
                        <div class="title_description">
                            <p class="line_title">입찰 마감기한</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        ${ deadline }
                                    </em>
                                </p>
                            </div>
                        </div>
                        <!-- 입찰 -->
                    </div>
                </div>
                <!-- 최종 주문정보 -->

                <!-- 결제하기 -->
                <form action="/shoekream/sell/biddingorder">
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
	                    <div class="btn_confirm">
	                        <a blind class="blind_full_solid_false">계속하기</a>
	                        <button class="blind_full_solid_false">판매 입찰하기</button>
	                        
	                            <input type="hidden" name="memberNo" value="${ loginMember.no }">
	                            <input type="hidden" name="productsNo" value="${ dbVo.productsNo }">
	                         	<input type="hidden" name="productsSizesNo" value="${ dbVo.productsSizesNo }">
	                         	<input type="hidden" name="biddingPrice" value="${ biddingPrice }">
		                        <input type="hidden" name="deadline" value="${ deadline }">
	                         	
	                            <input type="hidden" name="totalPrice" value="${ totalAmount }">
		                        <input type="hidden" name="commission" value="${ commission }">
	                    </div>
	                </div>
                </form>
            </div>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    <!-- 풋터 -->
    <!-- <footer>
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
    </footer> -->

</body>
</html>