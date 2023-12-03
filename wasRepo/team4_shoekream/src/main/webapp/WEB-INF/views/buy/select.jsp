<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<link rel="stylesheet" href="/shoekream/resources/css/bidding/Userheader.css">
	<link rel="stylesheet" href="/shoekream/resources/css/bidding/buy/select.css">
	<link rel="stylesheet" href="../../../common/footer.css">
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
                            <span>구매하기</span>
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

    

    <div class="container buy lg">
        <div class="content_area">
            <div class="buy_before">
                <div id="buy_before_check">
                    <div class="product_info">
                        <div class="product_thumb">
                            <div class="porduct">
                                <img id="airforce" src="/shoekream/resources/img/bidding/airforce.webp">
                            </div>
                        </div>
                        <div class="product_detail">
                            <p class="code">CJ9179-200</p>
                            <p class="name">Nike Air Force 1 '07 WB Flax</p>
                            <p class="translated_name">나이키 에어포스 1 '07 WB 플랙스</p>
                        </div>
                    </div>
                    <div><div></div></div>
                    <div class="buy_before_select">
                        <div class="select_area md">
                            <ul class="select_list grid_3">
                            	<% for(int i = 1; i <= 20; i++) { %>
	                            	<li id="select_item">
	                                    <button class="select_link buy">
	                                        <div class="link_inner">
	                                            <div class="size"><%= 210 + (i*5)%></div>
	                                            <div class="price">180,000</div>
	                                        </div>
	                                    </button>
	                                </li>
                            	<% } %>
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">215</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">220</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">225</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">230</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">235</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">240</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">245</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">250</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">255</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">260</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">265</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">270</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">275</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">280</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">285</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">290</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">295</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">300</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">305</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
<!--                                 <li id="select_item"> -->
<!--                                     <button class="select_link buy"> -->
<!--                                         <div class="link_inner"> -->
<!--                                             <div class="size">310</div> -->
<!--                                             <div class="price">180,000</div> -->
<!--                                         </div> -->
<!--                                     </button> -->
<!--                                 </li> -->
                            </ul>
                        </div>
                        <div class="order_btn_area">
                            <button class="btn_order order_buy buy clickable">
                                <div class="box">
                                    <div class="order_price">180,000</div>
                                    <div class="order_desc">5-7일소요</div>
                                </div>
                            </button>
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
                    <img src="./img/인별.png" alt="인별">
                </div>
                <div>
                    <img src="./img/페북.png" alt="페북">
                </div>
                <div>
                    <img src="./img/카톡.png" alt="카톡">
                </div>
            </div>
            <div></div>
            <div class="faq">
                <button>자주 묻는 질문</button>
            </div>
        </div>
        <div class="box4"></div>
    </footer>



    <script>
        const searchBtn = document.querySelector("#search-btn");
    </script>

</body>
</html>