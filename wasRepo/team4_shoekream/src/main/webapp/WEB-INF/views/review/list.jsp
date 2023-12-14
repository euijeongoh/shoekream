<%@page import="com.shoekream.review.vo.ReviewProductVo"%>
<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="com.shoekream.review.vo.ReviewVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<ReviewVo> reviewVoList = (List<ReviewVo>)request.getAttribute("ReviewVoList");
    	EnrollProductVo productVo = (EnrollProductVo) request.getAttribute("productVo");
    	ReviewProductVo reviewVo = (ReviewProductVo) request.getAttribute("reviewVo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/review/list.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


<div class="abcd"> </div>

        <div class="style_wrap">
            <div class="style_header">
                <h2>STYLE</h2>
            </div>
            <div class="abcd"> </div>
            <div class="feed">
                <div class="listphoto">
                    <div class="one">
                        <a href="/shoekream/review/detail">
                            <img src="/shoekream/resources/img/review/된장포스최종.png" alt="사진01" class="photo3">
                        </a>
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            </a>
                            <div class="text2">
                            <p>너무 예뻐용</p>
                            </div>  
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/picture.png" alt="사진02" class="photo3">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile01.png" alt="wave" class="wave">
                            </a> 
                            <div class="text2">
                            <p>역시 예뻐요!
                            <br>반사이즈 업 추천드려요!</p>
                            </div>                                           
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                           
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/reviewlist03.png" alt="사진01" class="photo5">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile02.png" alt="wave" class="wave">
                            </a>   
                            <div class="text2">
                            <p>예뻐!!!</p>
                            </div>                           
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                           
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/mylist02.png" alt="사진01" class="photo2">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile03.png" alt="wave" class="wave">
                            </a> 
                            <div class="text">
                            <p>남찡구랑 데이트</p>
                            </div>                                           
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
                        <img src="/shoekream/resources/img/review/vans01.png" alt="사진01" class="photo3">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile04.png" alt="wave" class="wave">
                            </a> 
                            <div class="text">
                            <p>살말살말사길잘했다</p>
                            </div>                                           
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/polo01.png" alt="사진01" class="photo4">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            </a>    
                            <div class="text">
                            <p>#폴로#겨울#따뜻행
                            <br> 다들 감기 조심</p>
                            </div>                          
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/prada01.png" alt="사진01" class="photo5">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile_img.png" alt="wave" class="wave">
                            </a>
                            <div class="text">
                            <p>나의 첫 푸라닭 아니고
                            <br>#프라다 #존예</p>
                            </div>                              
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/nike01.png" alt="사진01" class="photo2">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile_img.png" alt="wave" class="wave">
                            </a>
                            <div class="text">
                            <p>눈에 잘 띄네용 굿</p>
                            </div>                            
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
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile05.png" alt="wave" class="wave">
                            </a>       
                            <div class="text">
                            <p>색감맛집은 #반스</p>
                            </div>                     
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                            <br>
                            
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/reviewlist05.png" alt="사진01" class="photo4">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile06.png" alt="wave" class="wave">
                            </a>  
                            <div class="text">
                            <p>핑쿠핑쿠한 내 신발</p>
                            </div>                                          
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
                            <a href="">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            </a>                            
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/reviewlist06.png" alt="사진01" class="photo3">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile07j.png" alt="wave" class="wave">
                            </a>
                            <div class="text2">
                            <p>신발 뭐살지 모르겠으면
                            <br>일단 뉴발 그레이 ㄱ</p>
                            </div>                              
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
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile_img.png" alt="wave" class="wave">
                            </a>                            
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/list01.png" alt="사진01" class="photo4">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            </a>
                            <div class="text">
                            <p>보라보라보라돌이</p>
                            </div>                            
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/vans05.png" alt="사진01" class="photo"5>
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/profile_img.png" alt="wave" class="wave">
                            </a>
                            <div class="text">
                            <p>운동할 때 신어야지</p>
                            </div>                             
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>

                    <div class="one">
                        <img src="/shoekream/resources/img/review/reviewlist01.png" alt="사진01" class="photo2">
                        <div class="detail">
                            <a href="">
                                <img src="/shoekream/resources/img/review/wave.png" alt="wave" class="wave">
                            </a> 
                            <div class="text">
                            <p>내 신발 자랑하기</p>
                            </div>                                           
                            <div>
                                <a href="">
                                    <img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likey">  
                                </a>                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="abcd"> </div>
        
        <%@ include file="/WEB-INF/views/common/footer.jsp"%>
        <script>
    // 좋아요 이미지에 대한 클릭 이벤트를 모두 찾아서 처리합니다.
    document.addEventListener('DOMContentLoaded', (event) => {
        const likeImages = document.querySelectorAll('.likey');
        likeImages.forEach(image => {
            image.addEventListener('click', function() {
                // 클릭된 이미지의 src 속성을 변경합니다.
                image.src = '/shoekream/resources/img/review/blacklike.png'; // 업로드한 검은색 하트 이미지 경로로 변경해야 합니다.
            });
        });
    });
</script>
        

</body>
</html>