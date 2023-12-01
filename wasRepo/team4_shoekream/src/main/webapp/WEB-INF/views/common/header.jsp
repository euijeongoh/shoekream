<%@page import="com.shoekream.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<script defer src="/shoekream/resources/common/header.js"></script>
	
</head>
<body>
	<header>
        <div class="header_inner">
            <div class="top_list">
                <ul>
                    <li><a href="/shoekream/notice/main">고객센터</a></li>
                    <li><a href="/shoekream/mypage/main">마이페이지</a></li>
                    <li><a href="/shoekream/mypage/wishlist">관심</a></li>
                    <li><a>알림</a></li>
                    <%if(loginMember==null){%>
	                    <li><a href="/shoekream/member/login">로그인</a></li>                	
                    <%} else {%>
                    	<li><a href="/shoekream/member/logout">로그아웃</a><li>
                    <%}%>
                    
                </ul>
            </div>
            <div class="main_list">
                <div class="logo_area">
                    <a href="/shoekream/home">
                    <img src="/shoekream/resources/img/header/logo.svg">
                    </a>
                </div>
                <div class="head_list">
                    <ul>
                        <li><a href="/shoekream/home">HOME</a></li>
                        <li><a href="/shoekream/product">SHOP</a></li>
                        <li id="search_btn"><a><img src="/shoekream/resources/img/header/searchIcon.png"></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>  
    
</body>
</html>