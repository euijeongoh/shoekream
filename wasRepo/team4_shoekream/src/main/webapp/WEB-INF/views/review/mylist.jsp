<%@page import="com.shoekream.review.vo.ReviewProductVo"%>
<%@page import="com.shoekream.review.vo.ReviewVo"%>
<%@page import="com.shoekream.review.service.ReviewProductService"%>
<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="com.shoekream.review.dao.ReviewDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
 		List<ReviewVo> reviewVoList = (List<ReviewVo>)request.getAttribute("reviewVoList");
    	EnrollProductVo productVo = (EnrollProductVo) request.getAttribute("productVo");
    	ReviewProductVo reviewVo = (ReviewProductVo) request.getAttribute("reviewVo");

    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/review/mylist.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="abcd"> 

</div>

        <div class="user_top">
            <div class="profile_img">
            <%
			    String reviewImage = "";
			    if (reviewVoList != null && !reviewVoList.isEmpty()) {
			        reviewImage = reviewVoList.get(0).getReviewImage();
			    }
			%>
                <img src="/shoekream/resources/img/review/wave.png" alt="프로필사진" class="profile_img02">
                <div class="profile_info_box">
                    <ul>
                        <li><h2>helloprofile</h2></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="abcd"> </div>
        
        <div class="review-container">
            <div class="boardtap">
                <p class="board"><h3>게시물</h3></p>
            </div>
            <div class="abcd"> </div>
            <div class="feed">
            <ul class="review_mylist_wrap">
                <%for(ReviewVo vo : reviewVoList) { %>

               <li>

                <a href="/shoekream/review/write?no=<%= productVo.getProductNo() %>">
                
                	<div class="listphoto">
                		<div class="mylist">
	                		<div class="photo">
	                			<img src="/shoekream/resources/img/review/<%=vo.getReviewImage() %>">
	                		</div>
                		</div>
                	</div>
                    <div class="profileimage">
                        <div class="detail"><%= vo.getProfileImage() %></div>
                    </div>    
                  </a>
                </li>
                 <% } %>
              </ul>
              </div>
            </div>

        <div class="abcd"> 

        </div>
        
      <%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>
</html> 