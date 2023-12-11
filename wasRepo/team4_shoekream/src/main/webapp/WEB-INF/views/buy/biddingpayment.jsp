<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/buy/biddingpayment.css">
	<link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">
</head>


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
                            <span>배송/결제</span>
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

                <div class="display_separator"></div>
                
                <!-- 배송 주소 -->
                <section>
                    <div class="section_unit">
                        <div class="section_title">
                            <h3 class="title_txt">배송 주소</h3>
                            <a class="add_more_btn">+ 새 주소 추가</a>
                        </div>
                        <div class="section_content">
                            <div class="delivery_info">
                                <div class="address_info">
                                    <dl class="info_list">
                                        <div class="info_box">
                                            <dt class="title">받는 분</dt>
                                            <dd class="desc">곽태윤</dd>
                                        </div>
                                        <div class="info_box">
                                            <dt class="title">연락처</dt>
                                            <dd class="desc">010-9740-4885</dd>
                                        </div>
                                        <div class="info_box">
                                            <dt class="title">배송 주소</dt>
                                            <dd class="desc">인천 연수구 함박뫼로 100 (연수동, 문남마을아파트) 109-505</dd>
                                        </div>
                                    </dl>
                                </div>
                                <a class="btn_edit">변경</a>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- 배송 주소 -->
                
                <div class="display_separator"></div>

                <!-- 결제 방법 -->
                <div class="section_payment">
                    <div class="payment_area">
                        <div class="payment_title">
                            <h3 class="payment_title_txt">결제 방법</h3>
                        </div>
                        <div>
                            <div class="payment_card">
                                <h4 class="method_title">
                                    <div class="main_title">
                                        <p>카드 간편결제</p>
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
                </div>
                <!-- 결제 방법 -->

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
                            <p class="line_title">구매 희망가</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        168,000원
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
                                        5,000원
                                    </em>
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">배송비</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        3,000원
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
                                        60일-2024/01/31
                                    </em>
                                </p>
                            </div>
                        </div>
                        <!-- 입찰 -->
                    </div>
                </div>
                <!-- 최종 주문정보 -->

                <!-- 결제하기 -->
                <div class="buy_total_confirm">
                    <div class="price_total">
                        <dl class="price_box">
                            <dt class="price_title">총 결제금액</dt>
                            <dd class="price_empty_desc">
                                <span class="amount">176,000</span>
                                <span class="unit">원</span>
                            </dd>
                        </dl>
                        <span class="price_warning">
                            <em></em>
                        </span>
                    </div>
                    <div class="btn_confirm">
                        <a blind class="blind_full_solid_false">계속하기</a>
                        <button class="blind_full_solid_false">결제하기</button>
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



    <script>
        const searchBtn = document.querySelector("#search-btn");
    </script>

</body>
</html>