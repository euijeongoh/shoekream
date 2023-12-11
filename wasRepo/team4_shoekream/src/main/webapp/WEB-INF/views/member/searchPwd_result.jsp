<%@page import="com.shoekream.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    MemberVo searchedVo = (MemberVo) request.getAttribute("searchedVo");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/member/searchPwd_result.css">

</head>
<body>
	
	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp" %>
	
	<div class="content">
        <div class="result-area">
            변경된 새 비밀번호로<br>
            다시 로그인해주세요.<br>

            <button type="button" onclick="location.href='/shoekream/admin/login'">로그인</button>
            
        </div>
    </div>

</body>
</html>