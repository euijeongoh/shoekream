<%@page import="com.shoekream.review.vo.ReviewVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<ReviewVo> categoryVoList = (List<ReviewVo>)request.getAttribute("ReviewVoList");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/common/header.css">
<link rel="stylesheet" href="/shoekream/resources/css/review/write.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	
 	<div class="write_wrap">

        <div class="write_review">
            <p class="wreview"><b>상품 후기 작성</b></p>
        </div>
        <br>
        <div class="picjor">
            <div class="picture">
                <img src="/resources/img/review/tage_img.png" alt="상품이미지" class="picture_img">
            </div>
            <div class="jordan">
                <p class="jordan_eg"><b>(W) Jordan 1 Low White Wolf Grey</b></p>
                <p class="jordan_ko">(W) 조던 1 로우 화이트 울프 그레이</p>
            </div>
        </div>
        <div class="ggg">
            <div class="star">
                <div class="wstar">
                    <p id="wstar"><b>별 점</b></p>
                </div>
                <div class="starjom">
                    <div class="stars" data-rating="1">&#9733;</div>
                    <div class="stars" data-rating="2">&#9733;</div>
                    <div class="stars" data-rating="3">&#9733;</div>
                    <div class="stars" data-rating="4">&#9733;</div>
                    <div class="stars" data-rating="5">&#9733;</div>
                
                  	<p> </p><span id="selectedRating"></span>
                </div>
            </div>
            <div class="ignition">
                <div class="wignition">
                    <p id="wignition"><b>착화감</b></p>
                </div>
                <div class="three">
                    <ul>
                        <li><button>편함</button></li>
                        <li><button>보통</button></li>
                        <li><button>불편함</button></li>
                    </ul>
                </div>
            </div>
        </div>
        
        <br><br>
        <div class="content">
            <p id="wcontent"><b>내용</b></p>
                <textarea name="write" placeholder="     다른 회원 분들에게 도움이 되는 나만의 팁을 소개해주세요 !" id="write"
                ></textarea>
        </div>
        <br><br>
        <div class="upload">
            <p id="wupload"><b>사진 업로드</b></p>
            <div class="upload_picture">
                <img src="/resources/img/review/picture01.png" alt="리뷰사진" id="reviewpng">
                <a href="/resources/img/review/reviewlist01.png" id="reviewpng"><div>이미지업로드</div></a>
            </div>
        </div>
        <div class="update">
           <ul>
            <li id="update_detail"><input type="submit" value="올리기"></li>
            <li id="update_detail"><input type="submit" value="취소"></li>
           </ul>
        </div>
            
    </div>
</body>
</html>

<script type="text/javascript">

function previewImage(event) {
    const fileInput = event.target;
    
    const pictureimg = document.getElementsByClassName('picture_img');

    const file = fileInput.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function(e) {
            Array.from(pictureimg).forEach(function(img) {
                img.src = e.target.result;
            });
        };

        reader.readAsDataURL(file);
    }
}



	//별점코드
  // DOM 요소 가져오기
   const stars = document.querySelectorAll('.stars');

   // 각 별표에 이벤트 리스너 추가
   stars.forEach((star, index) => {
       star.addEventListener('click', () => {
           // 클릭한 별표까지 강조 효과 추가
           for (let i = 0; i <= index; i++) {
               stars[i].classList.add('selected');
           }

           // 클릭한 별표 이후의 별표에는 강조 효과 제거
           for (let i = index + 1; i < stars.length; i++) {
               stars[i].classList.remove('selected');
           }
       });
   });
</script>
