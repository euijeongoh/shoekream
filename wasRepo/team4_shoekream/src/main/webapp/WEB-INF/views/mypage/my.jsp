<%@page import="com.shoekream.mypage.vo.WishListVo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    List<WishListVo> wishList = (List<WishListVo>) request.getAttribute("wishList");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/mypage/my.css"> 

<script defer src="/shoekream/resources/js/mypage/my.js"></script>

</head>
<body>

<!-- 헤더 -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<main>
        <div class="mypage_container">
			<!-- 마이페이지 메뉴 -->
			<%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>

            <div class="mypage-home">
                <div class="profile">
                    <div class="user-detail">
                        <div><img id="profile-img" src="${ loginMember.profileImage }"></div>
                        <div class="user-info">
                            <div><%= loginMember.getNickname() %></div>
                            <div><%= loginMember.getId() %></div>
                            <form id="img_form">
                            	<input id="img_upload" name="f" type="file">
                            	<button type="button" id="change_profile">프로필 사진 변경</button>
                            	<button type="button" onclick="location.href='/shoekream/review/mylist'">내 리뷰</button>
                            </form>
                        </div>
                    </div>
                    <div class="user-menu">
                        <div class="icon">
                            <div>
                                <a>
                                <img onclick="location.href='/shoekream/notice/list'" src="/shoekream/resources/img/mypage/noticeicon.png">
                                <div>공지사항</div>      
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mypage-title">
                    <span class="list">구매 내역</span>
                    <span class="more"><a href="/shoekream/mypage/buying">더보기</a></span>
                </div>
                <div class="count-box">
                    <div class="tab">
                        <div>전체</div>
                        <div>${ buyCntVo.cntAll }</div>
                    </div>
                    <div class="tab">
                        <div>입찰 중</div>
                        <div>${ buyCntVo.cntBid }</div>
                    </div>
                    <div class="tab">
                        <div>진행 중</div>
                        <div>${ buyCntVo.cntPend }</div>
                    </div>
                    <div class="tab">
                        <div>종료</div>
                        <div>${ buyCntVo.cntFinished }</div>
                    </div>
                </div>


                <div class="mypage-title">
                    <span class="list">판매 내역</span>
                    <span class="more"><a href="/shoekream/mypage/selling">더보기</a></span>
                </div>
                <div class="count-box">
                    <div class="tab">
                        <div>전체</div>
                        <div>${ sellCntVo.cntAll }</div>
                    </div>
                    <div class="tab">
                        <div>입찰 중</div>
                        <div>${ sellCntVo.cntBid }</div>
                    </div>
                    <div class="tab">
                        <div>진행 중</div>
                        <div>${ sellCntVo.cntPend }</div>
                    </div>
                    <div class="tab">
                        <div>종료</div>
                        <div>${ sellCntVo.cntFinished }</div>
                    </div>
                </div>


                <div class="mypage-title">
                    <span class="list">관심 상품</span>
                    <span class="more">더보기</span>
                </div>
                <ul class="product-list-wrap">
                	<%for( WishListVo vo : wishList) { %>
                		<li>
                        <div id="product-img">
                            <img src="./resources/product1.webp" href="location.href='/shoekream/product/detail?modelNo'">
                        </div>
                        <div class="info-box">
                            <div id="brand"><%= vo.getBrandName() %></div>
                            <div id="model-name"><%= vo.getProductName() %> </div>
                        </div>
                   		</li>
                	<%} %>
                </ul>
             </div>
        </div>

	</main>

</body>
</html>