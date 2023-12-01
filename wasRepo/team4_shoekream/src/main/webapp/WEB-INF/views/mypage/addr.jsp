<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<link rel="stylesheet" href="/shoekream/resources/css/common/header.css"> 
	<link rel="stylesheet" href="/shoekream/resources/css/common/mypage_side.css"> 
	<link rel="stylesheet" href="/shoekream/resources/css/mypage/Adderss.css"> 
</head>
<body>

<body>

    <header>
        <div class="header_inner">
            <div class="top_list">
                <ul>
                    <li><a href="">고객센터</a></li>
                    <li><a href="">마이페이지</a></li>
                    <li><a href="">관심</a></li>
                    <li><a>알림</a></li>
                    <li><a href="">로그인</a></li>
                </ul>
            </div>
            <div class="main_list">
                <div class="logo_area">
                    <a href="">
                    <img src="/user/common/logo.svg">
                    </a>
                </div>
                <div class="head_list">
                    <ul>
                        <li><a href="">HOME</a></li>
                        <li><a href="">SHOP</a></li>
                        <li id="search_btn"><a><img src="/user/common/searchIcon.png"></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>

    <div class="mypage_container">
        <div class="menu_container">
            <div class="menu_title">마이 페이지</div>
            <nav>
                <div class="shop_menu">
                    <div id="title">쇼핑 정보</div>
                    <ul>
                        <li><a href="">구매 내역</a></li>
                        <li><a href="">판매 내역</a></li>
                        <li><a href="">관심</a></li>
                    </ul>
                </div>
                <div class="my_menu">
                    <div id="title">내 정보</div>
                    <ul>
                        <li><a href="">로그인 정보</a></li>
                        <li><a href="">주소록</a></li>
                        <li><a href="">결제 정보</a></li>
                        <li><a href="">정산 계좌</a></li>
                        <li><a href="">포인트</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="content_area">
            <div class="my_adderssbock">
                <div class="content_title">
                    <div class="title">
                        <h3>주소록</h3>
                    </div>
                    <div class="btn_box">
                        <a href="#" class="btn_add">
                            <span class="btn_txt">+ 새 배송지 추가</span>
                        </a>
                    </div>
                </div>
                <div class="my_list">
                    <div class="basic">
                        <div class="my_item">
                            <div class="info_bind">
                                <div class="address_info">
                                    <div class="name_box">
                                        <span class="name">***</span>
                                        <span class="mark">기본 배송지</span>
                                    </div>
                                    <p class="phone">
                                        "010"
                                        <span class="hyphen"></span>
                                        "9"
                                        <span class="dot"></span>
                                        <span class="dot"></span>
                                        <span class="dot"></span>
                                        <span class="hyphen"></span>
                                        <span class="dot"></span>
                                        "339"
                                    </p>
                                    <div class="address_box">
                                        <span class="zipcode">(00000)</span>
                                        <span class="adderss">서울시 강남구 테해란로어딘가</span>
                                    </div>
                                </div>
                            </div>
                            <div class="btn_bind">
                                <a href="#" class="btn outlinegrey small"> 수정</a>
                                <a href="#" class="btn outlinegrey small"> 삭제</a>
                            </div>
                        </div>
                    </div>
                    <div class="other">
                        <div class="other_list"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="box1"></div>
        <div class="box2">
            <div></div>
            <div>고객센터 1588-4444</div>
        </div>
        <div class="box3">
            <div class="left_bar">
                <div>고객지원</div>
                <div>공지사항</div>
                <div>1:1문의</div>
                <div>상품 등록 문의</div>
            </div>
            <div class="icons">
                <div>
                    <img src="/user/common/footer_img/인별.png" alt="인별">
                </div>
                <div>
                    <img src="/user/common/footer_img/페북.png" alt="페북">
                </div>
                <div>
                    <img src="/user/common/footer_img/카톡.png" alt="카톡">
                </div>
            </div>
            <div></div>
            <div class="faq">
                <button>자주 묻는 질문</button>
            </div>
        </div>
        <div class="box4"></div>
    </footer>
</body>


</body>
</html>