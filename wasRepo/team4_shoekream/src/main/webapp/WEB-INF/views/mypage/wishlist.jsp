<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/mypage/wishlist.css">

</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<main>
       <div class="mypage_container">
		   <%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>

           <div class="wishlist-container">
               <div class="wishlist-title">
                   관심
                   <div></div>
               </div>

               <div class="wishlist-head">
                   <div>전체 0</div>
               </div>

               <div class="wishlist-body">
                   <div class="wish-item">
                       <div class="wish-product">
                           <div class="product-img">
                               <img src="./resources/product1.webp">
                           </div>
                           <div class="product-info">
                               <div id="brand">UGG</div>
                               <div id="model">UGG Classic Mini Platform Boots Black</div>
                               <div id="release">US 12W</div>
                           </div>
                       </div>
                       <div class="wish-price">
                           <button>
                               <div>구매</div>
                               <div>
                                   <span id="immediate-price">104,000원</span>
                                   <br><span>즉시구매가</span>
                               </div>
                           </button>
                           <div id="a"><a>삭제</a></div>
                       </div>
                   </div>
               </div>
           </div>
       </div>
     </main>

</body>
</html>