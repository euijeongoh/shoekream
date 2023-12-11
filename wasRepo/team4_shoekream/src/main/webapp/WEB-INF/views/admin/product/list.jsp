<%@page import="java.util.Map"%>
<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="java.util.List"%>
<%@page import="com.shoekream.page.vo.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
    	List<EnrollProductVo> productVoList = (List<EnrollProductVo>) request.getAttribute("productVoList");
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/shoekream/resources/css/admin/product/list.css">
    <link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_sidebar.css">
    <link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_header.css">
    
</head>
<body>
    <header>
        <div class="header-inner">
            <div class="top-list">
                <ul>
                    <li><a href="">고객센터</a></li>
                    <li><a href="">마이페이지</a></li>
                    <li><a href="">관심</a></li>
                    <li><a>알림</a></li>
                    <li><a href="">로그인</a></li>
                </ul>
            </div>
            <div class="main-list">
                <div class="logo-area">
                    <a href="">
                    <img src="/shoekream/resources/img/admin/header/logo.svg">
                    <span>관리자</span>
                    </a>
                </div>
                <div class="head-list">
                    <ul>
                        <li><a href="">HOME</a></li>
                        <li><a href="">SHOP</a></li>
                        <li id="search-btn"><a><img src="/shoekream/resources/img/admin/header/searchIcon.png"></a></li>
                    </ul>
                </div>
            </div>
            <div class="header_list">
                <a href="/shoekream/admin/product/enroll">상품등록</a>
                <a href="/shoekream/admin/product/list"><b><u>상품목록</u></b></a>
            </div>        
        </div>
    </header>

        <br>
    <br><br>
    <hr>
    <br><br><br>
    <div class="main_body">
        <div class="side_body">
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
                            <a href="/shoekream/admin/product/enroll" class="menu_link">상품등록</a>
                        </li>
                        <li>
                            <a href="/shoekream/admin/product/list" class="menu_link"><b><u>상품 목록</u></b></a>
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
                </nav>
            </div>
            <div class="list_body">
               <form action="/shoekream/admin/product/list" method="post">
                   <table border="1">
                       <tbody>
                       
                       		<%for(EnrollProductVo vo : productVoList) {%>
                           <tr>
                               <td>상품</td>
                               <td><img src="/shoekream/resources/img/admin/header/logo.svg" alt="씀네일"></td>
								<td><a href="/shoekream/admin/product/edit/modelNumber=<%=vo.getModelNumber()%>"><%=vo.getProductNameKo() + " " + vo.getModelNumber()%></a></td>

                               <td><input type="checkbox" name="modelNumber" value="<%=vo.getModelNumber() %>"></td>
                           </tr>
                       		
                       		<%} %>
                          
                        </tbody>
                   </table>
                   <br>
                   
                  <input type="submit" value="삭제하기">
               </form>
               <br>
             <div class="page-area">
        <% 
            PageVo pvoVo = (PageVo)request.getAttribute("pvo");
            int startPage = pvoVo.getStartPage();
            int endPage = pvoVo.getEndPage();
            int maxPage = pvoVo.getMaxPage();
            int currentPage = pvoVo.getCurrentPage();

            if(startPage > 1){ 
        %>
            <a href="/shoekream/admin/product/list?pno=<%=startPage-1%>">이전</a>
        <% 
            }

            for(int i = startPage; i <= endPage; i++) { 
        %>
            <a href="/shoekream/admin/product/list?pno=<%=i%>"><%=i%></a>
        <% 
            }

            if(endPage < maxPage){ 
        %>
            <a href="/shoekream/admin/product/list?pno=<%=endPage+1%>">다음</a>
        <% 
            } 
        %>
    </div>
        </div>
    </div>

</body>
</html>