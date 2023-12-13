<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/mypage/wishlist.css">
<script defer src="/shoekream/resources/js/mypage/wishlist.js"></script>
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

               <div class="wishlist-body">
               	<c:forEach items="${ wishList }" var="wishVo">
               		<div class="wish-item" onclick="location.href='/shoekream/product/detail?modelNumber=${ wishVo.modelNumber }'">
                       <div class="wish-product">
                           <div class="product-img">
                               <img src=${ wishVo.productImg }>
                           </div>
                           <div class="product-info">
                               <div id="brand">${ wishVo.brandName }</div>
                               <div id="model">${ wishVo.productName }</div>
                           </div>
                       </div>
                       <div class="wish-price">
                           <button>
                               <div>구매</div>
                               <div>
                                   <span id="immediate-price">${ wishVo.immediatePrice }원</span>
                                   <br><span>즉시구매가</span>
                               </div>
                           </button>
                           <div id="a">
                           	<a>삭제</a>
                            <input type="text" name="productNo" value="${ wishVo.productNo }" hidden>
                           </div>
                       </div>
                   </div>
               	</c:forEach>
                <div class="page-container">
                	<div class="page-area">
					    <c:if test="${pvo.startPage != 1}">
					        <button type="button" onclick="location.href='/shoekream/mypage/wishlist?pno=${pvo.startPage - 1}'">이전</button>
					    </c:if>
					
					    <c:forEach var="i" begin="${pvo.startPage}" end="${pvo.endPage}">
					        <c:choose>
					            <c:when test="${i eq pvo.currentPage}">
					                <span>${i}</span>
					            </c:when>
					            <c:otherwise>
					                <a href="/shoekream/mypage/wishlist?pno=${i}">${i}</a>
					            </c:otherwise>
					        </c:choose>
					    </c:forEach>
					
					    <c:if test="${pvo.endPage != pvo.maxPage}">
					        <button type="button" onclick="location.href='/shoekream/mypage/wishlist?pno=${pvo.endPage + 1}'">다음</button>
					    </c:if>

                
<%--                 	<c:if test="${ pvo.startPage != 1 }"> --%>
<%-- 						<button type="button" onclick="location.href='/app99/board/list?pno= ${ pvo.startPage - 1}'">이전</button>				                		 --%>
<%--                 	</c:if> --%>
                	
<%--                 	<c:for start="${ pvo.startPage }" end="${ pvo.endPage }" step="1" var="i"> --%>
<%--                 		<c:if test="${ i == pvo.currentPage }"> --%>
<%--                 			<span>${ i }</span> --%>
<%--                 		</c:if> --%>
<%--                 		<c:if test="${ i != pvo.currentPage }"> --%>
<%--                 			<a href="/app99/board/list?pno=${ i }">${ i }</a> --%>
<%--                 		</c:if> --%>
<%--                 	</c:for> --%>
				
<%-- 					<c:if test="${ pvo.endPage != pvo.maxPage }"> --%>
<%-- 						<button type="button" onclick="location.href='/app99/board/list?pno=${ pvo.endPage + 1 }'">다음</button>									 --%>
<%-- 					</c:if>				 --%>
					</div>
					</div>
               	</div>
           	</div>
       	</div>
       	</div>
     </main>


	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>