<%@page import="java.util.Map"%>
<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="java.util.List"%>
<%@page import="com.shoekream.page.vo.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
    	List<EnrollProductVo> boardVoList = (List<EnrollProductVo>) request.getAttribute("enrollProductList");
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    	
    	Map<String, String>searchMap = (Map<String, String>)request.getAttribute("searchMap");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/shoekream/resources/css/admin/product/enroll.css">

    <script src="/frontRepo/admin/js/msh/enrollProduct.js"></script>
</head>
<body>
	<%@ include file = "/WEB-INF/views/common/header.jsp" %>
        <br>
        <div class="header-list">
            <a href="/shoekream/admin/product/enroll"><b><u>상품등록</u></b></a>
            <a href="/shoekream/admin/product/edit">상품수정</a>
            <a href="/shoekream/admin/product/delete">상품삭제</a>
            <a href="/shoekream/admin/product/list">상품목록</a>
        </div>        
    <br><br>
    <hr>
    <br><br><br>
    <div class="side-body">
        <div class="sidebar">
            <a href="/admin"><h3>관리자 페이지</h3></a>
            <br>
            <nav class="sidenav">
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">주문관리</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">    
                            <a href="" class="menu_link">입고 현황</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">검수진행 현황</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">배송 현황</a>
                        </li>
                    </ul>
                </div>
                <br>
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">상품 관리</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="/shoekream/admin/product/enroll" class="menu_link"><b><u>상품등록</u></b></a>
                        </li>
                        <li class="menu_item">
                            <a href="/shoekream/admin/product/edit" class="menu_link">상품 수정</a>
                        </li>
                        <li class="menu_item">
                            <a href="/shoekream/admin/product/delete" class="menu_link">상품 삭제</a>
                        </li>
                        <li class="menu_item">
                            <a href="/shoekream/admin/product/list" class="menu_link">상품 목록</a>
                        </li>
                    </ul>
                </div>
                <br>
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">고객 센터</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="" class="menu_link">공지사항</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">FAQ</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">Q&A</a>
                        </li>
                    </ul>
                </div>
            </div> 
            </nav>
         </div>
  <br><br><br><br><br><hr>
	
		

</body>
</html>