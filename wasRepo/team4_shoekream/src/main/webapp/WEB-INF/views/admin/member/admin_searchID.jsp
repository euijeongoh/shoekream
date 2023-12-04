<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_header.css">
	<link rel="stylesheet" href="/shoekream/resources/css/admin/member/admin_searchID.css">	
	
	<script defer src="/shoekream/resources/js/admin/member/admin_searchID.js"></script>
	
	
</head>
<body>

<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp" %>
	
	<div class="content">
        <div class="searchID-area">
            <div class="searchID-title">
                아이디 찾기
                <div></div>
            </div>
            <form action="/shoekream/member/searchID" method="post">
                <div id="guide">
                    관리자 이름과 휴대폰 번호를 입력하시면<br>
                    아이디의 일부를 알려드립니다.
                </div>
                <div class="input-box">
                    <div id="input-title">이름</div>
                    <input id="input-txt" type="text" name="adminName" placeholder="이름">
                </div>
                <div class="input-box">
                    <div id="input-title">휴대폰 번호</div>
                    <input id="input-txt" type="text" name="adminPhone" placeholder="가입하신 휴대폰 번호">
                </div>
                
                <input type="submit" value="아이디 찾기" disabled>
            </form>
        </div>
    </div>

</body>
</html>