<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	String searchResult = (String) request.getAttribute("searchResult");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="/shoekream/resources/css/common/header.css">
	<link rel="stylesheet" href="/shoekream/resources/css/member/findID.css">
	
</head>
<body>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="result-area">
            <div class="result-title">
                아이디 찾기에 성공하였습니다.
                <div></div>
            </div>
            <div class="result">
                <div>
                    아이디
                </div>
                <div id="find_id">
                    <%= searchResult %>
                </div>
            </div>
            <div class="btn-area">
                <button type="button" onclick="location.href='/shoekream/member/searchPwd'">
                    비밀번호 찾기
                </button>
                <button type="button" onclick="location.href='/shoekream/member/login'">
                    로그인
                </button>
            </div>
        </div>
        
</body>
</html>