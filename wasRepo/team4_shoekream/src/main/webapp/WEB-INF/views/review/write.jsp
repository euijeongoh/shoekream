<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <img src="./img/tage_img.png" alt="상품이미지" class="picture_img">
            </div>
            <div class="jordan">
                <p class="jordan_eg"><b>(W) Jordan 1 Low White Wolf Grey</b></p>
                <p class="jordan_ko">(W) 조던 1 로우 화이트 울프 그레이</p>
            </div>
        </div>
        <div class="ggg">
            <div class="star">
                <div class="wstar">
                    <p id="wstar"><b>별점</b></p>
                </div>
                <div class="starjom">
                    <img src="./img/nstar.png" alt="별점" id="starjom">
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
                <img src="./img/picture.png" alt="리뷰사진" id="reviewpng">
                <a href="" id="reviewpng"><div >이미지업로드</div></a>
                <!-- <img src="" alt="리뷰사진" id="reviewpng">
                <img src="" alt="리뷰사진" id="reviewpng"> -->
            </div>
            <!-- <div>
                <img src="" alt="리뷰사진" id="reviewpng">
            </div> -->
        </div>
        <div class="update">
           <ul>
            <li id="update_detail"><button>올리기</button></li>
            <li id="update_detail"><button>취소</button></li>
           </ul>
        </div>
            
    </div>
</body>
</html>