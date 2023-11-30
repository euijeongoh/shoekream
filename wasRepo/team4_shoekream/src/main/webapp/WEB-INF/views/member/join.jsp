<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/member/join.css"> 

</head>
<body>
<!-- 	헤더 -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="content">
        <div class="join_area">
            <div class="join_title">
                회원가입
            </div>
            <form action="/member/join" method="post">
                <div class="input_box">
                    <div class="input_title">아이디</div>
                    <input class="input_txt" type="text" name="memberId" placeholder="영문, 숫자 조합 6-12자">
                </div>
                <div class="input_box">
                    <div class="input_title">비밀번호</div>
                    <input class="input_txt" type="password" name="memberPwd" placeholder="영문, 숫자, 특수문자 조합 8-16자">
                </div>
                <div class="input_box">
                    <div class="input_title">비밀번호 확인</div>
                    <input class="input_txt" type="password" name="memberPwd2">
                </div>
                <div class="input_box">
                    <div class="input_title">닉네임</div>
                    <input class="input_txt" type="text" name="memberNick" placeholder="한글 3-5자">
                </div>
                <div class="input_box">
                    <div class="input_title">이메일</div>
                    <input class="input_txt" type="text" name="email" placeholder="예) shoekream@kream.co.kr">
                </div>
                <div class="input_box">
                    <div class="input_title">휴대폰 번호</div>
                    <input class="input_txt" type="text" name="phone" placeholder="- 포함 13자">
                </div>
                <div id="size">
                    <div class="input_title">신발 사이즈</div>
                    <button type="button">선택</button>
                </div>
                <div class="join_btn_box">
                    <button id="join_btn">가입하기</button>
                </div>
            </form>
        </div>
    </div>
	
</body>
</html>