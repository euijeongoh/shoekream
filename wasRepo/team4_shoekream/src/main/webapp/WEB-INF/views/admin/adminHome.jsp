<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_sidebar.css">
<link rel="stylesheet" href="/shoekream/resources/css/admin/admin_page.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp" %>
	
		<div class="container">
	
	    	<%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp" %>
	    		<div class="order_area">
            <div class="order_area">
                <div class="order_title">
                    <h4 class="title">입고 필요</h4>
                    <a href="/shoekream/admin/order/storage/list" class="breakdown_views">+ 내역 보기</a>
                </div>
                <div class="order_contant">
                    <h5 class="contant">입고가 필요한 주문</h5>
                    <p class="order_count">${storageSize }</p> <!-- 주문 수를 나타내는 요소 -->
                </div>
            </div>
            <div class="order_area">
                <div class="order_title">
                    <h4 class="title">검수 진행</h4>
                    <a href="/shoekream/admin/order/check/list" class="breakdown_views">+ 내역 보기</a>
                </div>
                <div class="order_contant">
                    <h5 class="contant">검수를 진행중인 주문</h5>
                    <p class="order_count">${checkSize }</p> <!-- 주문 수를 나타내는 요소 -->
                </div>
            </div>
            <div class="order_area">
                <div class="order_title">
                    <h4 class="title">배송 필요</h4>
                    <a href="/shoekream/admin/order/send/list" class="breakdown_views">+ 내역 보기</a>
                </div>
                <div class="order_contant">
                    <h5 class="contant">발송이 필요한 주문</h5>
                    <p class="order_count">${sendSize }</p> <!-- 주문 수를 나타내는 요소 -->
                </div>
            </div>
        </div>
	    </div>

</body>
</html>