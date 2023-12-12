<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/shoekream/resources/css/mypage/payment.css">
    
</head>
<body>

<%@ include file = "/WEB-INF/views/common/header.jsp" %>

<div class="mypage_container">
	<%@ include file = "/WEB-INF/views/common/mypage_side.jsp" %>
		<div class="content_area">
            <div class="my_payment">
                <div class="content_title">
                    <div class="title">
                        <h3>결제 정보</h3>
                        <p class="sub_title">수수료(패널티, 착불 배송비 등)가 정산되지 않을 경우, 별도 고지 없이 해당 금액을 결제 시도할 수 있습니다.</p>
                    </div>
                    <div class="btn_box">
                        <a href="#" class="btn btn_add">
                            <span class="btn_txt">+ 새 카드 추가하기</span>
                        </a>
                    </div>
                </div>
                <div class="my_list">
                    <div class="basic">
                        <div class="my_item" default-mark="기본 결제">
                            <div class="info_bind"><!---->
                                <div class="card_info"><span class="card_name"> KB</span>
                                    <div class="card_num"><span class="num_bind"><span class="dot"><span
                                                    class="dot"></span></span><span class="hyphen"></span><span
                                                class="dot"><span class="dot"></span></span><span
                                                class="hyphen"></span><span class="dot"><span
                                                    class="dot"></span></span><span class="hyphen"></span>
                                            <div d class="last_num_box"><span class="last_num">1039</span></div>
                                        </span><span class="mark">기본 결제</span></div>
                                </div>
                            </div>
                            <div data-v-7d49a47c="" class="btn_bind"><!----><!----><a data-v-0a6aebaa=""
                                    data-v-7d49a47c="" href="#" class="btn outlinegrey small"> 삭제 </a></div>
                        </div>
                    </div>
                    <div class="other" data-v-1c284ef0=""></div>
                </div>
            </div>
        </div>
	</div>


<%@ include file = "/WEB-INF/views/common/footer.jsp" %>

</body>
</html>