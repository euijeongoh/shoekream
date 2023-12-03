<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link rel="stylesheet" href="/shoekream/resources/css/common/header.css">
	<link rel="stylesheet" href="/shoekream/resources/css/member/searchID.css">
	
	<script defer src="/shoekream/resources/js/member/searchID.js"></script>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="content">
        <div class="searchID-area">
            <div class="searchID-title">
                아이디 찾기
                <div></div>
            </div>
            <form action="/shoekream/member/searchID" method="post">
                <div id="guide">
                    가입 시 등록한 이메일 주소를 입력하면<br>
                    아이디의 일부를 알려드립니다.
                </div>
                <div class="input-box">
                    <div id="input-title">이메일</div>
                    <input id="input-txt" type="text" name="email" placeholder="가입하신 이메일 주소">
                </div>
                
                <input type="submit" value="아이디 찾기" disabled>
            </form>
        </div>
    </div>
	
</body>
</html>