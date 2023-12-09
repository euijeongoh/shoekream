<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
<link rel="stylesheet" href="/shoekream/resources/css/review/comment.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

        <br>


    <div class="comment_wrap">
        <div class="nocomment">
            <div class="commnet_x">
                <a href="">
                    <img src="/shoekream/resources/img/review/comment_x.png" alt="X" class="x">
                </a>
            </div>
            <div class="comment_xwrite">
                <p class="xx"><h3>댓글</h3></p>
            </div>
        </div>
    
        <div class="profile">
            <div class="profiless">
                <div>
                    <a href="">
                        <img src="/shoekream/resources/img/review/wave.png" alt="프사" class="profile_img">
                    </a>
                </div>  
                <div class="profile_detail">
                    <div>
                        <a href="">
                            <p class="nick"><b>nickname</b></p>
                        </a>
                    </div>
                    <div>
                        <p class="date01">2023년 2월 9일</p>
                    </div>
                </div>
            </div>
            <div class="hashtag">
                <a href=""><p id="brand">#조던</p></a>
                <a href=""><p id="brand">#나이키</p></a>
            </div>
        </div>

        <div class="comment_box">
            <div class="wcomment_profile">
                <img src="/shoekream/resources/img/review/profile_img.png" alt="임시프사" class="exprofile">
            </div>
            <div class="wcomment">
                <textarea name="comment" id="write_comment"
                placeholder="   댓글을 남겨주세요!"></textarea>
            </div>
        </div>

    <div class="comment_list_box">

        <div class="comment_list">
            <div class="comment_list01">
                <div class="kitty">
                    <a href="">
                        <img src="/shoekream/resources/img/review/kitty.png" alt="키티프사" class="profile_kitty">
                    </a>
                </div>  
                <div class="list_name_date">
                    <div>
                        <a href="">
                            <p class="commnet_nick"><b>ejeong</b></p>
                        </a>
                    </div>
                    <div>
                        <p class="date02">2023년 2월 13일</p>
                    </div>
                </div>
            </div>
            <div class="airforce">
                <p>혹시 에어포스 240이면 조던 몇신어야 하나요? ㅠㅠ</p>
            </div>
            <div>
                <a href=""><img src="/shoekream/resources/img/review/like.png" alt="좋아요"></a>
            </div>
        </div>

        <div class="comment_list2">
            <div class="comment_list02">
                <div class="kitty02">
                    <a href="">
                        <img src="/shoekream/resources/img/review/kitty.png" alt="프사" class="profile_kitty2">
                    </a>
                </div>  
                <div class="list_name_date">
                    <div>
                        <a href="">
                            <p class="melomance"><b>melomance</b></p>
                        </a>
                    </div>
                    <div>
                        <p class="date03">2023년 4월 17일</p>
                    </div>
                </div>
            </div>
            <div class="meto">
                <p>나두우 이거 살걸....</p>
            </div>
            <div>
                <a href=""><img src="/shoekream/resources/img/review/like.png" alt="좋아요"></a>
            </div>
        </div>
        
    </div>
    
    </div>



</body>
</html>