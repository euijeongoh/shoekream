<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String joinSuccess = (String)session.getAttribute("joinSuccess");
    	session.removeAttribute("joinSuccess");
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

<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/member/login.css"> 

<script defer src="/shoekream/resources/js/member/login.js"></script>

</head>
<body>
	
	
<script>
	<%if(searchIdFailed != null ){ %>
		alert("<%= searchIdFailed %>");
	<%} %>
	
	<%if(joinSuccess != null ){ %>
	alert("<%= joinSuccess %>");
	<%} %>
</script>		
	
<!-- 	헤더 -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
<!-- 	로그인 -->
	<div class="content">
        <div class="login_area">
            <div class="login_title">
                <img src="/shoekream/resources/img/member/logo.svg" id="login_img">
	            <%if(loginError != null) {%>
		            <div id="login_fail"><%= loginError %></div>            	
   	            <%}%>
            </div>
            
<!--    로그인 폼 -->
            <form action="/shoekream/member/login" method="post" onsubmit="return activateLoginBtn();">
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
                    <input type="submit" id="login_btn" value="로그인">
                </div>
            </form>
            
<!--    로그인 메뉴 (회원가입, 아이디 찾기, 비밀번호 찾기) -->
            <ul>
                <li><a href="/shoekream/member/join">회원가입</a></li>
                <li><a href="/shoekream/member/searchID">아이디 찾기</a></li>
                <li><a href="/shoekream/member/searchPwd">비밀번호 찾기</a></li>
            </ul>
            
        </div>
    </div>
	
</body>
</html>