<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/member/login.css"> 

<script defer src="/shoekream/resources/js/member/login.js"></script>

</head>
<body>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="content">
        <div class="login_area">
            <div class="login_title">
                <img src="/shoekream/resources/img/member/logo.svg" id="login_img">
            </div>
            <form>
                <div class="input_box">
                    <div class="input_title">아이디</div>
                    <input class="input_txt" type="text" name="memberId">
                    <div id="id_check"></div>
                </div>
                <div class="input_box">
                    <div class="input_title">비밀번호</div>
                    <input class="input_txt" type="password" name="memberPwd">
                    <div id="pwd_check"></div>
                </div>
                <div class="login_btn_box">
                    <button id="login_btn">로그인</button>
                </div>
            </form>
            <ul>
                <li><a href="/shoekream/member/join">회원가입</a></li>
                <li><a href="/shoekream/member/searchID">아이디 찾기</a></li>
                <li><a href="/shoekream/member/searchPwd">비밀번호 찾기</a></li>
            </ul>
            <div class="social_login_area">
                <div class="social_btn_box">
                    
                    <button id="social_btn">
                        <img id="navericon" src="/shoekream/resources/img/member/navericon.png">
                        네이버로 로그인
                    </button>
                </div>
                <div class="social_btn_box">
                    <button id="social_btn">
                        <img id="kakaoicon" src="/shoekream/resources/img/member/kakaoicon.png">
                        카카오로 로그인
                    </button>
                </div>
            </div>
        </div>
    </div>
	
</body>
</html>