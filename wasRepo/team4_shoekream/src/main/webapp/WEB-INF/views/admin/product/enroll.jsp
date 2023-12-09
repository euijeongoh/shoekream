<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/shoekream/resources/css/admin/product/enroll.css">
    <link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_header.css">
    <link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_sidebar.css">
</head>
<body>
    <header>
        <div class="header-inner">
            <div class="top-list">
                <ul>
                    <li><a href="/shoekream/notice/list">고객센터</a></li>
                    <li><a href="">마이페이지</a></li>
                    <li><a href="">관심</a></li>
                    <li><a>알림</a></li>
                    <li><a href="">로그인</a></li>
                </ul>
            </div>
            <div class="main-list">
                <div class="logo-area">
                    <a href="/shoekream/admin/home">
                    <img src="/shoekream/resources/img/admin/header/logo.svg">
                    <span>관리자</span>
                    </a>
                </div>
                <div class="head-list">
                    <ul>
                        <li><a href="">HOME</a></li>
                        <li><a href="">SHOP</a></li>
                        <li id="search-btn"><a><img src="/shoekream/resources/img/admin/header/searchIcon.png"></a></li>
                    </ul>
                </div>
            </div>
            <div class="header_list">
                <a href="/shoekream/admin/product/enroll"><b><u><span>상품등록</span></u></b></a>
                <a href="/shoekream/admin/product/list"><span>상품목록</span></a>
            </div>        
        </div>
        </header>

        <br>
    <br><br>
    <hr>
    <br><br><br>
    <div class="side-body">
        <div class="sidebar">
            <a href="/admin"><h3>관리자 페이지</h3></a>
            <br>
            <nav class="sidenav">
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">주문관리</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="" class="menu_link">입고 현황</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">검수진행 현황</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">배송 현황</a>
                        </li>
                    </ul>
                </div>
                <br>
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">상품 관리</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="/shoekream/admin/product/enroll" class="menu_link"><b><u>상품등록</u></b></a>
                        </li>
                        <li class="menu_item">
                            <a href="/shoekream/admin/product/list?pno=1" class="menu_link">상품 목록</a>
                        </li>
                    </ul>
                </div>
                <br>
                <div class="sidenav_list">
                    <strong class="sidenav_title"><a href="">고객 센터</a></strong>
                    <ul class="sidenav_menu">
                        <li class="menu_item">
                            <a href="" class="menu_link">공지사항</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">FAQ</a>
                        </li>
                        <li class="menu_item">
                            <a href="" class="menu_link">Q&A</a>
                        </li>
                    </ul>
                </div>
            </div> 
            </nav>
            
            <div class="enroll-area">
                <br>
                <div id="product-information">
                    <form action="/shoekream/admin/product/enroll" method="post" enctype="multipart/form-data">
	                <div id="product-image-container">
	                <input type="file" id="file-input" accept="image/*" onchange="previewImage(event)" name="f">
	                    <div id="image-preview-container" >
	                        <img id="image-preview" src="#" alt="이미지 미리보기">
	                    </div>
	                    <div>
	                        <label for="file-input" id="file-input-label" >이미지 선택</label>
	                    </div>
	                </div>
	                
                        <input type="text" name="productName" placeholder="제품명">
                        <input type="text" name="productNameKo" placeholder="한글명">
                        <input type="text" name="modelNumber" placeholder="모델 번호">
                        <input type="text" name="releasePrice" placeholder="발매가">
                        <input type="text" name="category" placeholder="카테고리">	
                        <input type="text" name="brand" placeholder="브랜드">
                        <input type="date" name="releaseDate" placeholder="출시일">
                        <span>사이즈</span>
                        <div>
                            <input type="checkbox" name="size" value="215">215
                            <input type="checkbox" name="size" value="220">220
                            <input type="checkbox" name="size" value="225">225
                            <input type="checkbox" name="size" value="230">230
                            <input type="checkbox" name="size" value="235">235
                            <input type="checkbox" name="size" value="240">240  
                            <input type="checkbox" name="size" value="245">245<br>
                            <input type="checkbox" name="size" value="250">250
                            <input type="checkbox" name="size" value="255">255
                            <input type="checkbox" name="size" value="260">260
                            <input type="checkbox" name="size" value="265">265
                            <input type="checkbox" name="size" value="270">270
                            <input type="checkbox" name="size" value="275">275
                            <input type="checkbox" name="size" value="280">280<br>
                            <input type="checkbox" name="size" value="285">285
                            <input type="checkbox" name="size" value="290">290
                            <input type="checkbox" name="size" value="295">295
                            <input type="checkbox" name="size" value="300">300
                        </div>
                        <input type="submit" value="저장">
                        <input type="reset" onclick="resetForm(event)">
                    </form>
                </div>
                <br>
                
                
            </div>
        </div>
  <br><br><br><br><br>


</body>
</html>

<script type="text/javascript">
function previewImage(event) {
    const fileInput = event.target;
    const imagePreview = document.getElementById('image-preview');

    const file = fileInput.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function(e) {
            imagePreview.src = e.target.result;
        };

        reader.readAsDataURL(file);
    }
}

function resetForm(event) {
    // 기본 동작 막기
    event.preventDefault();

    // form 요소를 ID로 찾아옴
    var form = document.querySelector('#product-information form');
    
    // form을 리셋 (내용 초기화)
    form.reset();
    
    // 이미지 미리보기도 초기화
    document.getElementById('image-preview').src = '#';
}
</script>