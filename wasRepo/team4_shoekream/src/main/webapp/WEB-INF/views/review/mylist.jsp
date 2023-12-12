<%@page import="com.shoekream.review.vo.ReviewVo"%>
<%@page import="com.shoekream.review.service.ReviewProductService"%>
<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="com.shoekream.review.dao.ReviewDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
    	List<ReviewDao> reviewVoList = (List<ReviewVo>)request.getAttribute("ReviewVoList");
    	EnrollProductVo productVo = (EnrollProductVo) request.getAttribute("productVo");
    	ReviewProductService reviewVo = (ReviewProductVo) request.getAttribute("reviewVo");
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
                <img src="/shoekream/resources/img/review/wave.png" alt="프로필사진" class="profile_img02">
                <div class="profile_info_box">
                    <ul>
                        <li><h2>helloprofile</h2></li>
                        <br>
                        <li>홍길동</li>
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
                <%for(ReviewVo vo : reviewVoList) { %>
                <a href="/shoekream/review/detail?no=<%= vo.getNo() %>">
                <div class="listphoto"><img src="${ vo.image }" alt=" ${vo.productNo }" class= "wave">
                </div>
                    <div class="one">
                        </a>
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/mylist01.png" alt="사진02" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                           
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/mylist02.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/mylist03.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>
                </div>
                

                <div class="listphoto2">
                    <div class="one">
                        <img src="/shoekream/resources/img/review/vans01.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/polo01.png"" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/mylist05.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/mylist04.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>
                </div>

                <div class="listphoto3">
                    <div class="one">
                        <img src="/shoekream/resources/img/review/vans03.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/reviewlist05.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/polo03.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/mylist05.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>
                </div>

                <div class="listphoto4">
                    <div class="one">
                        <img src="/shoekream/resources/img/review/vans04.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/nike04.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/list01.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/list05.png" alt="사진01" class="photo">
                        <div class="detail">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>
                </div>
        <div class="abcd"> 

        </div>
        
      <%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>
</html>