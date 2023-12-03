<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link rel="stylesheet" href="/WEB-INF/resources/css/common/header.jsp">
	<link rel="stylesheet" href="/WEB-INF/resources/css/member/searchID.jsp">

</head>
<body>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="content">
        <div class="searchID-area">
            <div class="searchID-title">
                아이디 찾기
                <div></div>
            </div>
            <form action="/member/searchID" method="post">
                <div id="guide">
                    가입 시 등록한 이메일 주소를 입력하면<br>
                    아이디의 일부를 알려드립니다.
                </div>
                <div class="input-box">
                    <div id="input-title">이메일</div>
                    <input id="input-txt" type="text" name="email" placeholder="가입하신 이메일 주소">
                </div>
                
                <input type="submit" value="아이디 찾기">
            </form>
        </div>
    </div>
	
</body>
</html>