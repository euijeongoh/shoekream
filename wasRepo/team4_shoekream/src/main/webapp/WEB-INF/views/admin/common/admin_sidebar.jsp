<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/shoekream/resources/css/admin/commmon/admin_sidebar.css">
</head>
<body>
    <div class="sidebar">
        <a href="/shoekream/admin/home"><h3>관리자 페이지</h3></a>
        <br>
        <nav class="sidenav">
            <div class="sidenav_list">
                <strong class="sidenav_title">주문관리</strong>
                <ul class="sidenav_menu">
                    <li class="menu_item">
                        <a href="/shoekream/admin/order/storage/list?pno=1" class="menu_link">입고 현황</a>
                    </li>
                    <li class="menu_item">
                        <a href="/shoekream/admin/order/check/list?pno=1" class="menu_link">검수 현황</a>
                    </li>
                    <li class="menu_item">
                        <a href="/shoekream/admin/order/send/list?pno=1" class="menu_link">배송 현황</a>
                    </li>
                </ul>
            </div>
            <br>
            <div class="sidenav_list">
                <strong class="sidenav_title">상품 관리</strong>
                <ul class="sidenav_menu">
                    <li class="menu_item">
                        <a href="/shoekream/admin/product/enroll" class="menu_link">상품 등록</a>
                    </li>
                    <li class="menu_item">
                        <a href="/shoekream/admin/product/list" class="menu_link">상품 목록</a>
                    </li>
                </ul>
            </div>
            <br>
            <div class="sidenav_list">
                <strong class="sidenav_title">고객 센터</strong>
                <ul class="sidenav_menu">
                    <li class="menu_item">
                        <a href="" class="menu_link">공지사항</a>
                    </li>
                    <li class="menu_item">
                        <a href="" class="menu_link">FAQ</a>
                    </li>
                    <li class="menu_item">
                        <a href="" class="menu_link">Q&A</a>
                    </li>
                </ul>
            </div>
        </nav>
        </div> 
</body>
</html>