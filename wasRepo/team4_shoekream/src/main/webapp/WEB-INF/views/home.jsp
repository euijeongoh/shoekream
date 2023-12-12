<%@page import="com.shoekream.product.vo.ProductInfoVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	List<ProductInfoVo> enrollList = (List<ProductInfoVo>) request.getAttribute("enrollList");
    	List<ProductInfoVo> immediatePriceList = (List<ProductInfoVo>) request.getAttribute("immediatePriceList");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/home.css"> 


<script defer src="/shoekream/resources/js/common/homemenu.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<%@ include file="/WEB-INF/views/common/homemenu.jsp" %>

    <div class="main_img">
        <img src="/shoekream/resources/img/main/mainimg.png" onclick="location.href='/shoekream/product/detail?modelNo=CJ9179-200'">
    </div>

    <div class="home_products">
        <div class="container_title">
            <div class="title">
                <div id="title">New In</div>
                <div id="sub_title">신규 등록 상품</div>
            </div>
            <div id="more"><a href="">더보기</a></div>
        </div>
        <ul class="product_list_wrap">
        	<%for( ProductInfoVo vo : enrollList ) { %>
               	<li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand"><%= vo.getBrandName() %></div>
                    <div id="model_name"><%= vo.getProductName() %></div>
                    <div id="price"><%= vo.getImmediatePrice() %></div>
                </div>
            	</li>
            <% }%>
        </ul>
    </div>


    
    <div class="home_products">
        <div class="container_title">
            <div class="title">
                <div id="title">New Lowest Asks</div>
                <div id="sub_title">새로운 즉시 구매가</div>
            </div>
            <div id="more"><a href="">더보기</a></div>
        </div>
        <ul class="product_list_wrap">
        	<%for( ProductInfoVo priceVo : immediatePriceList ) { %>
               	<li>
                <div id="product_img">
                    <img src="./resources/product1.webp">
                </div>
                <div class="info_box">
                    <div id="brand"><%= priceVo.getBrandName() %></div>
                    <div id="model_name"><%= priceVo.getProductName() %></div>
                    <div id="price"><%= priceVo.getImmediatePrice() %></div>
                </div>
            	</li>
            <% }%>
        </ul>
    </div>
</body>
</html>