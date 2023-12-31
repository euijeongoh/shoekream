<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOEKREAM</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/sell/check.css">
    <link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">

    <script defer src="/shoekream/resources/js/bidding/sell/check.js"></script>
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
                            <span>판매 동의</span>
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
                        <div class="title_area">
                            <h2 class="check_title">
                                <span class="accent_text">
                                    판매
                                </span>
                                하시기 전에
                                <br class="br_mo">
                                꼭 확인하세요.
                            </h2>
                        </div>
					<%@ include file="/WEB-INF/views/buy/selectproduct.jsp" %>
                    <div class="buy">
                        <ul class="check_list">
                            <li class="check_item">
                                <a class="check_area">
                                    <div class="notice_group">
                                        <label for="undefined_box1" class="check_label">
                                            <p class="notice_maintext">판매하려는 상품이 맞습니다.</p>
                                            <p class="notice_subtext">상품이미지, 모델번호, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다.</p>
                                        </label>
                                    </div>
                                    <div class="checkbox_item">
                                        <input id="undefined_box1" type="checkbox" name="checklist" onclick="f02()" class="blind" style="width: 100%; height: 100%;" >
                                    </div>
                                </a>
                            </li>
                            <li class="check_item">
                                <a class="check_area">
                                    <div class="notice_group">
                                        <label for="undefined_box2" class="check_label">
                                            <p class="notice_maintext">국내/해외에서 발매한 정품, 새상품입니다.</p>
                                            <p class="notice_subtext">모든 구성품이 그대로이며, 한 번도 착용하지 않은 정품, 새상품입니다. 손상/오염/사용감 있는 상품은 판매가 불가능합니다.</p>
                                        </label>
                                    </div>
                                    <div class="checkbox_item">
                                        <input id="undefined_box2" type="checkbox" name="checklist" onclick="f02()" class="blind" style="width: 100%; height: 100%;" >
                                    </div>
                                </a>
                            </li>
                            <li class="check_item">
                                <a class="check_area">
                                    <div class="notice_group">
                                        <label for="undefined_box3" class="check_label">
                                            <p class="notice_maintext">박스/패키지의 상태를 확인합니다.</p>
                                            <p class="notice_subtext">박스/패키지의 상태에 따른 검수 기준을 확인했습니다.</p>
                                        </label>
                                    </div>
                                    <div class="checkbox_item">
                                        <input id="undefined_box3" type="checkbox" name="checklist" onclick="f02()" class="blind" style="width: 100%; height: 100%;" >
                                    </div>
                                </a>
                            </li>
                            <li class="check_item">
                                <a class="check_area">
                                    <div class="notice_group">
                                        <label for="undefined_box4" class="check_label">
                                            <p class="notice_maintext">이중 포장하여 선불 발송합니다.</p>
                                            <p class="notice_subtext">반드시 이중 포장하여 택배 상자에 담아 선불 발송합니다. 합배송은 권장하지 않으며 이로 인한 박스/패키지 훼손은 판매자의 책임입니다.</p>
                                        </label>
                                    </div>
                                    <div class="checkbox_item">
                                        <input id="undefined_box4" type="checkbox" name="checklist" onclick="f02()" class="blind" style="width: 100%; height: 100%;" >
                                    </div>
                                </a>
                            </li>
                            <li class="check_item">
                                <a class="check_area">
                                    <div class="notice_group">
                                        <label for="undefined_box5" class="check_label">
                                            <p class="notice_maintext">SHOEKREAM의 최신 이용정책을 모두 확인하였으며, 판매를 계속합니다.</p>
                                            <p class="notice_subtext">건전하고 안전한 거래를 위해 반드시 숙지해야 할 미입고, 페널티, 부정거래 등의 이용정책을 확인했습니다.</p>
                                        </label>
                                    </div>
                                    <div class="checkbox_item">
                                        <input id="undefined_box5" type="checkbox" name="checklist" onclick="f02()" class="blind" style="width: 100%; height: 100%;" >
                                    </div>
                                </a>
                            </li>
                        </ul>
                        <div class="btn_confirm">
		                    <form action="/shoekream/sell/now" method="post">
		                         <a disabled="disabled" class="blindAgree">동의버튼</a>
		                         <input type="hidden" name="dbVo" value="${dbVo}">
		                         <input type="hidden" name="productsNo" value="${dbVo.productsNo}">
		                         <input type="hidden" name="price" value="${dbVo.price}">
		                         <input type="hidden" name="size" value="${dbVo.shoesSizes}">
		                         <button id="btn1" disabled="disabled" type="submit" class="button">판매 계속</button>
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