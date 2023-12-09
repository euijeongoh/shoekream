<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/review/detail.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="review_wrap">
        <div class="profile_state">
            <div class="profile">
                <div class="kitty">
                        <img href="" src="/shoekream/resources/img/review/wave.png" alt="kitty" class="profile_kitty">
                </div>
                <div class="profile_detail">
                    <div>
                        <a href="#">
                            <h4>nickname</h4>
                        </a>
                    </div>
                    <div>
                        <p class="date001">2023년2월9일</p>
                    </div>
                </div>
            </div>
            
            <div class="user_button">
                <a href="#"><p id="click">수정</p></a>
                <a href="#"><p id="click">삭제</p></a>
            </div>


        </div>

        <br>
        
        <div class="picture">
            <img src="/shoekream/resources/img/review/picture.png" alt="리뷰이미지" class="main_picture">
        </div>
        
        <div class="tage01">
            <br><p class="tage02"><b>상품태그 1개</b></p><br>
    
            <div class="tage_img">
                <div> 
                    <a href="">
                        <img src="/shoekream/resources/img/review/tage_img.png" alt="상품태그" class="pink_tag">
                    </a>
                </div>
                <div class="jordan">
                    <p class="jordan_eg">(W) Jordan 1 Low White Wolf Grey</p>
                    <p class="jordan_ko">(W) 조던 1 로우 화이트 울프 그레이</p>
                </div>
            </div>
        </div>
        <br>
        <div class="test">
            <div class="licom">
                <a href=""><img src="/shoekream/resources/img/review/like.png" alt="좋아요" class="likeimg"></a>
                <a href="shoekream/review/comment"><img src="/shoekream/resources/img/review/comment.png" alt="댓글" class="commentimg"></a>
            </div>
        </div>
        
        <div class="like">
            <p><b>좋아요 8개</b></p>
        </div>
        <div class="abcd">

        </div>
        <div class="content">
            <div class="review">
                <h3>역시 예뻐요! 반사이즈 업 추천드려요!</h3>
            </div>
            <div class="abcd">

            </div>
            <div class="hashtag">
                <a href="#" class="ht">#조던</a>
                <a href="#" class="ht">#나이키</a>
            </div>
        </div>
        <br>
        <div class="ignition">
            <ul class="a">
                <li><h3>편함</h3></li>
                <li><h3>보통</h3></li>
                <li><h3>불편함</h3></li>
            </ul>
        </div>

        <div class="kitty_box">
            <div class="one_comment">
                <br><br><p class="commentnum"><b>댓글 5개</b></p><br>
            </div>
            <div class="comment">
                <div>
                    <a href="#">
                        <img src="/shoekream/resources/img/review/kitty.png" alt="profile_img"  class="profile_img02">
                    </a>
                </div>
                <div>
                    <div class="ejeong">
                        <p><h4>ejeong</h4></p>
                    </div>
                    <div class="airforce">
                        <p>혹시 에어포스 240이면 조던 몇신어야 하나요? ㅠㅠ</p>
                    </div>
                </div>
            </div>

            <div>
                <div class="date02">
                    <p class="date002">2023년11월09일</p>
                </div>
                <br>
                <div class="comment">
                    <div>
                        <a href="#">
                            <img src="/shoekream/resources/img/review/kitty.png" alt="profile_img"  class="profile_img02">
                        </a>
                    </div>
                    <div>
                        <div class="ejeong">
                            <p><h4>ejeong</h4></p>
                        </div>
                        <div class="airforce">
                            <p>나도 이거 살 걸..</p>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="date02">
                        <p class="date002">2023년11월10일</p>
                    </div>
                <div class="more">
                    <a href="/shoekream/review/comment"><p class="morecom">댓글 더 보기</p></a>
                </div>
            </div>
        </div>
    
    </div>
</body>
</html>