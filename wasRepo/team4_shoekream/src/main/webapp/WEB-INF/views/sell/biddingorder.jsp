<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/buy/order.css">
    <link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">

    <script defer src="/shoekream/resources/js/bidding/order.js"></script>
<body>
<!--     <div class="wrap"> -->
<!--         <header> -->
<!--             <div class="header-inner"> -->
<!--                 <div class="top-list"> -->
<!--                     <ul> -->
<!--                         <li><a href="">고객센터</a></li> -->
<!--                         <li><a href="">마이페이지</a></li> -->
<!--                         <li><a href="">관심</a></li> -->
<!--                         <li><a>알림</a></li> -->
<!--                         <li><a href="">로그인</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--                 <div class="main-list"> -->
<!--                     <div class="logo-area"> -->
<!--                         <a href=""> -->
<!--                         <img src="/shoekream/resources/img/header/logo.svg"> -->
<!--                         </a> -->
<!--                     </div> -->
<!--                     <div class="center"> -->
<!--                         <h2 class="h2_buy"> -->
<%--                             <span>${ trade }${ process }</span> --%>
<!--                         </h2> -->
<!--                     </div> -->
<!--                     <div class="right"> -->
<!--                         <button type="button" class="btn_standard"> -->
<!--                             검수기준 -->
<!--                         </button> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </header> -->
<!--     </div> -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
    

    <div class="container">
        <div class="content">
            <div class="buy_immediate">
                <!-- 주문번호  -->
<!--                 <div class="order_area"> -->
<!--                     <div class="area_number"> -->
<!--                         <dt class="title">주문번호</dt> -->
<!--                         <dd class="desc">43124284</dd> -->
<!--                     </div> -->
<!--                 </div> -->
                <!-- 주문번호  -->

                <div class="display_separator"></div>

                <!-- 상품 정보 -->
                <%@ include file="/WEB-INF/views/buy/selectproduct.jsp" %>
                <!-- 상품 정보 -->

                <div class="display_separator"></div>

                <!-- 진행 상황 -->
<!--                 <div class="order_area"> -->
<!--                     <div class="status_process">진행상황</div> -->
<!--                     <div class="status_area"> -->
<%--                         <input class="ordersStatus" type="hidden" name="ordersStatus" value="${ ordersVo.ordersStatus }"> --%>
<!--                         <div class="order_status order_status_1" >결제완료</div> -->
<!--                         <div class="order_status order_status_2" >입고완료</div> -->
<!--                         <div class="order_status order_status_3" >검수완료</div> -->
<!--                         <div class="order_status order_status_4" >배송완료</div> -->
<!--                     </div> -->
<!--                 </div> -->
                <!-- 진행 상황 -->

                <div class="display_separator"></div>
                
                <!-- 최종 주문정보 -->
                <div class="section_orderinfo">
                    <div class="orderinfo_area">
                        <div class="title_wrap">
                            <div>
                                <p class="wrap_title">결제 내역</p>
                            </div>
                        </div>
                        <div class="title_description" id="totalAmount">
                            <p class="line_title title_txt">총 결제금액</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em class="title_txt" style="color:inherit;">
                                        ${ totalAmount }원
                                    </em>
                                    <input class="totalAmount" type="hidden" name="totalAmount" value="${ totalAmount }">
                                </p>
                            </div>
                        </div>
                        <div class="title_description">
                            <p class="line_title">즉시 구매가</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        ${ price }원
                                    </em>
                                    <input class="price" type="hidden" name="price" value="${ dbVo.price }">
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
                                        ${ commission }원
                                    </em>
                                    <input class="commission" type="hidden" name="commission" value="${ commission }">
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
                                    <input class="deliveryCharge" type="hidden" name="deliveryCharge" value="3000">
                                </p>
                            </div>
                        </div>
                        <div class="title_description" id="expire_date">
                            <p class="line_title">입찰 마감기한</p>
                            <div class="description_wrap">
                                <p class="line_description">
                                    <em style="color:inherit;">
                                        까지
                                    </em>
                                    <input class="111" type="hidden" name="1111" value="${ totalAmount }">
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 최종 주문정보 -->

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
                                <div class="payment_account">
                                    <!-- <h4 class="method_title">
                                        <div class="main_title">
                                            <p>계좌</p>
                                        </div>
                                        <a class="btn_card_add">새 계좌 추가</a>
                                    </h4> -->
                                    <div>
                                        <div class="payment_detail">
                                            <div class="payment_item">
                                                <div class="info_wrap">
                                                    <div class="bank_info">
                                                        <span class="bank_name">${ cardInfo.cardCompanyName }</span>
                                                        <div class="account_number">${ cardInfo.cardNumber }</div>
                                                    </div>
                                                    <!-- <a class="regist_link">계좌를 등록하세요</a> -->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- <div class="payment_card">
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
                                </div> -->
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
<!--     <footer> -->
<!--         <div class="box1"></div> -->
<!--         <div class="box2"> -->
<!--             <div></div> -->
<!--             <div>고객센터 1588-4444</div> -->
<!--         </div> -->
<!--         <div class="box3"> -->
<!--             <div class="left_bar"> -->
<!--                 <div>고객지원</div> -->
<!--                 <div>공지사항</div> -->
<!--                 <div>1:1문의</div> -->
<!--                 <div>상품 등록 문의</div> -->
<!--             </div> -->
<!--             <div class="icons"> -->
<!--                 <div> -->
<!--                     <img src="/shoekream/resources/img/footer/인별.png" alt="인별"> -->
<!--                 </div> -->
<!--                 <div> -->
<!--                     <img src="/shoekream/resources/img/footer/페북.png" alt="페북"> -->
<!--                 </div> -->
<!--                 <div> -->
<!--                     <img src="/shoekream/resources/img/footer/카톡.png" alt="카톡"> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div></div> -->
<!--             <div class="faq"> -->
<!--                 <button>자주 묻는 질문</button> -->
<!--             </div> -->
<!--         </div> -->
<!--         <div class="box4"></div> -->
<!--     </footer> -->

</body>
</html>