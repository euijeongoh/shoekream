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
                <!-- <div class="commnet_x">
                    <a href="">
                        <img src="/shoekream/resources/img/review/comment_x.png" alt="X" class="x">
                    </a>
                </div> -->
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
                            <a href="/shoekream/review/detail">
                                <p class="nick"><b>helloprofile</b></p>
                            </a>
                        </div>
                        <div>
                            <p class="date01">2023년 2월 9일</p>
                        </div>
                    </div>
                </div>
                <div class="hashtag">
                    <a href=""><p id="brand">역시 예뻐요! 반사이즈 업 추천드려요!</p></a>
                    <!-- <a href=""><p id="brand">#나이키</p></a> -->
                </div>
            </div>
   
        <div class="comment_box">
            <div class="wcomment_profile">
                <img src="/shoekream/resources/img/review/profile_img.png" alt="임시프사" class="exprofile">
            </div>
            <div class="wcomment">
            <form action="/shoekream/review/comment" method="post" onsubmit="submitComment(event)">
                <textarea name="comment" id="write_comment"
                placeholder="   댓글을 남겨주세요!"></textarea>
            </div>
            <div class="uploadid">
                <input type="submit" value="올리기" id="uploadid">
            </div>
        </div>
    </form>
    
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
                <!-- <div>
                    <a href=""><img src="/shoekream/resources/img/review/like.png" alt="좋아요"></a>
                </div> -->
            </div>
    
            <div class="comment_list2">
                <div class="comment_list02">
                    <div class="kitty02">
                        <a href="">
                            <img src="/shoekream/resources/img/review/profile_img.png" alt="프사" class="profile_kitty2">
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
                <!-- <div>
                    <a href=""><img src="/shoekream/resources/img/review/like.png" alt="좋아요"></a>
                </div> -->
            </div>
            
        </div>
        
        </div>


 
</body>
</html>

<script>
    function submitComment(event) {
        event.preventDefault(); // 기본 form 제출 방지

        // 댓글 내용 가져오기
        var commentContent = document.getElementById('write_comment').value;

        // AJAX를 이용한 서버로의 요청
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/shoekream/review/comment', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // 성공적으로 댓글이 서버에 전송되면 해야 할 동작
                // 예: 화면 갱신, 새로운 댓글 추가
                // 여기서는 간단히 새로고침
                location.reload();
            }
        };
        // 댓글 내용을 서버로 전송
        xhr.send('comment=' + encodeURIComponent(commentContent));
    }
</script>
