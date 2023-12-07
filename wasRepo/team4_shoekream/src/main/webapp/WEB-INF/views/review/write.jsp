<%@page import="com.shoekream.review.vo.ReviewVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<ReviewVo> reviewVoList = (List<ReviewVo>)request.getAttribute("ReviewVoList");
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

        <form action="" class="aaa">
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
                            <li><input type="radio" name="comfort_btn"  class="comfort-button" data-comfort="comfortable">편함</li>
                            <li><input type="radio" name="comfort_btn" class="comfort-button" data-comfort="normal">보통</li>
                            <li><input type="radio" name="comfort_btn" class="comfort-button" data-comfort="uncomfortable">불편함</li>
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
                <input type="file" id="file-input" accept="image/*" onchange="previewImage(event)">
                <div>
                    <div class="upload_picture">
                        <img src="/resources/img/review/picture01.png" alt="리뷰사진" id="reviewpng">
                    </div>
                    <div class="img_label">
                        <label for="file-input" id="file-input-label">이미지 선택</label>
                    </div>
                </div>
            </div>
            <div class="update">
                <ul>
                    <li id="update_detail"><input type="submit" value="올리기"></li>
                    <li id="update_detail"><input type="submit" value="취소"></li>
                </ul>
            </div>
        </form>
            
        </div>


    
    <%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>

<script type="text/javascript">

// 이미지 미리보기 함수
function previewImage(event) {
    const fileInput = event.target;
    const reviewpng = document.getElementById('reviewpng');

    const file = fileInput.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function(e) {
            reviewpng.src = e.target.result;
        };

        reader.readAsDataURL(file);
    }
}

//JavaScript를 사용하여 각 버튼의 클릭 이벤트를 처리합니다
const comfortButtons = document.querySelectorAll('.comfort-button');

comfortButtons.forEach(button => {
    button.addEventListener('click', () => {
        // 모든 버튼의 클래스를 초기화합니다
        comfortButtons.forEach(btn => btn.classList.remove('selected'));

        // 클릭된 버튼에 'selected' 클래스를 추가하여 스타일을 변경합니다
        button.classList.add('selected');

        // 선택된 착화감 값을 서버로 전송하거나 다른 작업을 수행할 수 있습니다.
        const selectedComfort = button.getAttribute('data-comfort');
        console.log(`선택된 착화감: ${selectedComfort}`);
    });
});
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
