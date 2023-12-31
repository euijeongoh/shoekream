<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	String loginError = (String) session.getAttribute("loginError");
    	session.removeAttribute("loginError");
    	String searchIdFailed = (String) session.getAttribute("searchIdFailed");
    	session.removeAttribute("searchIdFailed");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_header.css">
	<link rel="stylesheet" href="/shoekream/resources/css/admin/member/admin_login.css">
	
	<script defer src="/shoekream/resources/js/admin/member/admin_login.js"></script>
</head>
<body>

<%if(searchIdFailed != null) { %>
	alert(<%= searchIdFailed %>);
<%} %>
	
	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp" %>
	
	<div class="content">
        <div class="login-area">
            <div class="login-title">
                <img src="/shoekream/resources/img/admin/header/logo.svg" id="login-img">
                <div>관리자</div>
                <%if(loginError != null) {%>
		            <div id="login_fail"><%= loginError %></div>            	
   	            <%}%>
            </div>
            <form action="/shoekream/admin/login" method="post" onsubmit="return activateLoginBtn();">
                <div class="input-box">
                    <div class="input-title">아이디</div>
                    <input class="input-txt" type="text" name="adminId" placeholder="아이디">
                    <div id="id_check"></div>
                </div>
                <div class="input-box">
                    <div class="input-title">비밀번호</div>
                    <input class="input-txt" type="password" name="adminPwd" placeholder="비밀번호">
                    <div id="pwd_check"></div>
                </div>
                <div class="login-btn-box">
                    <button id="login-btn">로그인</button>
                </div>
            </form>
            <ul>
            </ul>
        </div>
    </div>
	
</body>
</html>