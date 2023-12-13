<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
<link rel="stylesheet" href="/shoekream/resources/css/mypage/biddingdetail.css">

</head>
<body>

	<div class="wrap">
        <header>
            <div class="header-inner">
                <div class="top-list">
                    <ul>
                        <li><a href="/shoekream/notice/list">고객센터</a></li>
                        <li><a href="/shoekream/mypage/main">마이페이지</a></li>
                        <li><a href="/shoekream/mypage/wishlist">관심</a></li>
                        <li><a href="/shoerkeam/member/logout">로그아웃</a></li>
                    </ul>
                </div>
                <div class="main-list">
                    <div class="logo-area">
                        <a href="/shoekream/home">
                        <img src="/shoekream/resources/img/header/logo.svg">
                        </a>
                    </div>
                    <div class="center">
                        <h2 class="h2_buy">
                            <span>거래 상세내역</span>
                        </h2>
                    </div>
                    <div class="right">
                    </div>
                </div>
            </div>
        </header>
    </div>
	
	<div class="container">
        <div class="content">
            <div class="buy_immediate">
                <!-- 주문번호  -->
                <!-- <div class="order_area">
                    <div class="area_number">
                        <dt class="title">주문번호</dt>
                        <dd class="desc">43124284</dd>
                    </div>
                </div> -->
                <!-- 주문번호  -->

                <div class="display_separator"></div>

                <!-- 상품 정보 -->
                <div class="buy_product_area">
				     <div class="product_thumb">
				         <div class="porduct">
				             <img id="select_product" src=${ orderDetailVo.productImg }>
				         </div>
				     </div>
				     <div class="product_detail">
				         <p class="code">${ orderDetailVo.modelNumber }</p>
				         <p class="name">${ orderDetailVo.productName }</p>
				         <p class="translated_name">${ orderDetailVo.productNameKo }</p>
				         <div class="model_desc">
				             <p class="size_txt">${ orderDetailVo.productSize }</p>
				         </div>
				     </div>
				</div>
                

            
                <div class="display_separator"></div>
                
                <!-- 최종 주문정보 -->
                <div class="section_orderinfo">
                    <div class="orderinfo_area">
                        <div class="title_description" id="totalAmount">
                            <p class="line_title title_txt">총 결제금액</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em class="title_txt" style="color:inherit;">
                                        ${ orderDetailVo.finalPrice }원
                                    </em>
                                    <input class="totalAmount" type="hidden" name="totalAmount" value="${ orderDetailVo.finalPrice }">
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">구매 희망가</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        ${ orderDetailVo.bidPrice }원
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
                                        ${ detailVo.commission }원
                                    </em>
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">배송비</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        3000원
                                    </em>
                                    <input class="deliveryCharge" type="hidden" name="deliveryCharge" value="3000">
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">입찰 마감기한</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        ${ detailVo.bidExpireDate }까지
                                    </em>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 최종 주문정보 -->
                <!--  -->
                <div class="display_separator"></div>

                <form action="/shoekream/buy/order" method="post">
                    <!-- 배송 주소 -->
                    <section>
                        <div class="section_unit">
                            <div class="section_title">
                                <h3 class="title_txt">배송 주소</h3>
                                <!-- <a class="add_more_btn">+ 새 주소 추가</a> -->
                            </div>
                            <div class="section_content">
                                <div class="delivery_info">
                                    <div class="address_info">
                                        <dl class="info_list">
                                            <div class="info_box">
                                                <dt class="title">받는 분</dt>
                                                <dd class="desc">${orderDetailVo.addressName}</dd>
                                            </div>
                                            <div class="info_box">
                                                <dt class="title">연락처</dt>
                                                <dd class="desc">${orderDetailVo.phone}</dd>
                                            </div>
                                            <div class="info_box">
                                                <dt class="title">배송 주소</dt>
                                                <dd class="desc">${orderDetailVo.address}</dd>
                                            </div>
                                        </dl>
                                    </div>
                                    <!-- <a class="btn_edit">변경</a> -->
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
                                <h3 class="payment_title_txt">결제 정보</h3>
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
                                                    <!-- <span class="regist_text">카드를 등록하세요</span> -->
                                                    <span class="bank_name">${ orderDetailVo.cardCompany }</span>
                                                    <div class="account_number">${ orderDetailVo.cardNumber }</div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 결제 방법 -->


                    <!-- 결제하기 -->
                    <!-- <div class="buy_total_confirm">
                        <div class="price_total">
                            <dl class="price_box">
                                <dt class="price_title">총 결제금액</dt>
                                <dd class="price_empty_desc">
                                    <span class="amount">${ totalAmount }원</span>
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
                    </div> -->
                </form>

            </div>
        </div>
    </div>
    
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
	

</body>
</html>