<%@page import="com.shoekream.admin.manager.vo.ManagerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        ManagerVo loginAdmin = (ManagerVo) session.getAttribute("loginAdmin");
    	String alertMsg = (String) session.getAttribute("alertMsg");
    	session.removeAttribute("alertMsg");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_header.css">

</head>
<body>

<script>
		<%if(alertMsg!=null){ %>
			alert(<%=alertMsg%>);			
		<%} %>
</script>

	
	<header>
        <div class="header_inner">
            <div class="top_list">
                <ul>
                    <li><a href="">고객센터</a></li>
                    <%if(loginAdmin==null){%>
	                    <li><a href="/shoekream/admin/login">로그인</a></li>                	
                    <%} else {%>
                    	<li><a href="/shoekream/admin/logout">로그아웃</a><li>
                    <%}%>
                </ul>
            </div>
            <div class="main_list">
                <div class="logo_area">
                    <a href="">
                    <img src="/shoekream/resources/img/admin/header/logo.svg">
                    <span>관리자</span>
                    </a>
                </div>
                <div class="head_list">
                    <ul>
                        <li><a href="/shoekream/home">HOME</a></li>
                        <li><a href="/shoekream/review/list">STYLE</a></li>
                        <li><a href="/shoekream/product">SHOP</a></li>
                        <li id="search_btn"><a><img src="/shoekream/resources/img/admin/header/searchIcon.png"></a></li>
                    </ul>
                </div>
            </div>
        </div>
        </header>
        
	
</body>
</html>