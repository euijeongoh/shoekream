<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	String AuthenticationKey = (String) session.getAttribute("AuthenticationKey");
    	session.removeAttribute("AuthenticationKey");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/member/join.css"> 

<script defer src="/shoekream/resources/js/member/join.js"></script>

</head>
<body>
<!-- 	헤더 -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="content">
        <div class="join_area">
            <div class="join_title">
                회원가입
            </div>
            <form action="/shoekream/member/join" method="post" onsubmit="return checkValidation();")>
            	<div class="input_box">
                    <div class="input_title">이름(실명)*</div>
                    <input class="input_txt" type="text" name="memberName" placeholder="이름">
                    <div id="name_check"></div>
                </div>
                <div class="input_box">
                    <div class="input_title">아이디*</div>
                    <input class="input_txt" type="text" name="memberId" placeholder="아이디">
                    <div id="id_check"></div>
                </div>
                <div class="input_box">
                    <div class="input_title">비밀번호*</div>
                    <input class="input_txt" type="password" name="memberPwd" placeholder="영문, 숫자, 특수문자 조합 8-16자">
                    <div id="pwd_check"></div>
                </div>
                <div class="input_box">
                    <div class="input_title">비밀번호 확인*</div>
                    <input class="input_txt" type="password" name="memberPwd2">
                    <div id="pwd2_check"></div>
                </div>
                <div class="input_box">
	                <div class="input_title">닉네임*</div>
	                <input class="input_txt" type="text" name="memberNick" placeholder="한글 3-5자">
	                <div id="nick_check"></div>
                </div>
                <div class="input_box">
                    <div class="input_title">이메일*</div>
                    <div class="email_area">
	                    <input class="input_txt" type="text" name="email" placeholder="예) shoekream@kream.co.kr">
	                    <input type="button" value="인증하기" onclick="sendEmail();" disabled>                    
                    </div>
                    <div id="email_check"></div>
                    <div class="approval_area">
                    	<input class="input_txt" type="text" name="appr_no" placeholder="인증번호 입력">
                    	<span id="auth_check"></span>
                    </div>
                </div>
                <div class="join_btn_box">
                	<input type="submit" id="join_btn" value="가입하기">
                </div>
            </form>
        </div>
    </div>
	
</body>
</html>