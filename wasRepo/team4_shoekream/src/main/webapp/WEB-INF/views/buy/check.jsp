<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/buy/check.css">
    <link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">

    <script defer src="/shoekream/resources/js/bidding/buy/check.js"></script>
<body>
    <div class="wrap">
        <header>
            <div class="header-inner">
                <div class="top-list">
                    <ul>
                        <li><a href="">고객센터</a></li>
                        <li><a href="">마이페이지</a></li>
                        <li><a href="">관심</a></li>
                        <li><a>알림</a></li>
                        <li><a href="">로그인</a></li>
                    </ul>
                </div>
                <div class="main-list">
                    <div class="logo-area">
                        <a href="">
                        <img src="/shoekream/resources/img/header/logo.svg">
                        </a>
                    </div>
                    <div class="center">
                        <h2 class="h2_buy">
                            <span>구매 동의</span>
                        </h2>
                    </div>
                    <div class="right">
                        <button type="button" class="btn_standard">
                            검수기준
                        </button>
                    </div>
                </div>
            </div>
        </header>
    </div>

    <div class="container">
        <div class="content">
            <div class="buy_before">
                <div id="buy_before_check">
                    <div>
                        <div class="title_area">
                            <h2 class="check_title">
                                <span class="accent_text">
                                    구매
                                </span>
                                하시기 전에
                                <br class="br_mo">
                                꼭 확인하세요.
                            </h2>
                        </div>
                        <div class="buy_product_area">
                            <div class="product_thumb">
                                <div class="porduct">
                                    <img id="airforce" src="/shoekream/resources/img/bidding/airforce.webp">
                                </div>
                            </div>
                            <div class="product_detail">
                                <p class="code">CJ9179-200</p>
                                <p class="name">Nike Air Force 1 '07 WB Flax</p>
                                <p class="translated_name">나이키 에어포스 1 '07 WB 플랙스</p>
                                <div class="model_desc">
                                    <p class="size_txt">250</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="buy">
	                    <ul class="check_list">
	                        <li class="check_item">
	                            <a class="check_area">
	                                <div class="notice_group">
	                                    <label for="undefined_box1" class="check_label">
	                                        <p class="notice_maintext">구매하려는 상품이 맞습니다.</p>
	                                        <p class="notice_subtext">상품이미지, 모델번호, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다. 단, 상품의 이미지는 촬영 환경에 따라 실제와 다를 수 있습니다.</p>
	                                    </label>
	                                </div>
	                                <div class="checkbox_item">
	                                    <input id="undefined_box1" type="checkbox" name="checklist" onclick="f01()" class="blind" style="width: 100%; height: 100%;" >
	                                    <label for="" class="check_label">
	                                        
	                                    </label>
	                                </div>
	                            </a>
	                        </li>
	                        <li class="check_item">
	                            <a class="check_area">
	                                <div class="notice_group">
	                                    <label for="undefined_box2" class="check_label">
	                                        <p class="notice_maintext">국내/해외에서 발매한 정품, 새상품입니다.</p>
	                                        <p class="notice_subtext">모든 구성품이 그대로이며, 한 번도 착용하지 않은 정품, 새상품입니다. 국내 발매 상품 여부는 확인드리지 않습니다.</p>
	                                    </label>
	                                </div>
	                                <div class="checkbox_item">
	                                    <input id="undefined_box2" type="checkbox" name="checklist" onclick="f01()" class="blind" style="width: 100%; height: 100%;" >
	                                    <label for="" class="check_label">
	                                        
	                                    </label>
	                                </div>
	                            </a>
	                        </li>
	                        <li class="check_item">
	                            <a class="check_area">
	                                <div class="notice_group">
	                                    <label for="undefined_box3" class="check_label">
	                                        <p class="notice_maintext">제조사에서 볼량으로 인정하지 않는 기준은 하자로 판단하지 않습니다.</p>
	                                        <p class="notice_subtext">박스/패키지와 상품 컨디션에 민감하시다면 검수 기준을 반드시 확인하시기 바랍니다.</p>
	                                    </label>
	                                </div>
	                                <div class="checkbox_item">
	                                    <input id="undefined_box3" type="checkbox" name="checklist" onclick="f01()" class="blind" style="width: 100%; height: 100%;" >
	                                    <label for="" class="check_label">
	                                        
	                                    </label>
	                                </div>
	                            </a>
	                        </li>
	                        <li class="check_item">
	                            <a class="check_area">
	                                <div class="notice_group">
	                                    <label for="undefined_box4" class="check_label">
	                                        <p class="notice_maintext">SHOEKREAM의 최신 이용정책을 모두 확인하였으며, 구매를 계속합니다.</p>
	                                        <p class="notice_subtext">건전하고 안전한 거래를 위해 반드시 숙지해야 할 미입고, 페널티, 부정거래 등의 이용정책을 확인했습니다.</p>
	                                    </label>
	                                </div>
	                                <div class="checkbox_item">
	                                    <input id="undefined_box4" type="checkbox" name="checklist" onclick="f01()" class="blind" style="width: 100%; height: 100%;" >
	                                    <label for="" class="check_label">
	                                        
	                                    </label>
	                                </div>
	                            </a>
	                        </li>
	                    </ul>
	                    <div class="btn_confirm">
		                    <form action="/shoekream/buy/now">
		                         <a disabled="disabled" class="blindAgree">동의버튼</a>
		                         <input type="hidden" name="productsNo" value="${dbVo.productsNo}">
		                         <input type="hidden" name="price" value="${dbVo.price}">
		                         <input type="hidden" name="size" value="${dbVo.shoesSizes}">
		                         <button id="btn1" disabled="disabled" type="submit" class="button">구매 계속</button>
	                        </form>
	                    </div>
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
                    <img src="/shoekream/resources/img/footer/인별.png" alt="인별">
                </div>
                <div>
                    <img src="/shoekream/resources/img/footer/페북.png" alt="페북">
                </div>
                <div>
                    <img src="/shoekream/resources/img/footer/카톡.png" alt="카톡">
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
</html>