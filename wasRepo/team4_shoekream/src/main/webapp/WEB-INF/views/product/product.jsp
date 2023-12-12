<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    List<EnrollProductVo> productVoList = (List<EnrollProductVo>) request.getAttribute("productVoList");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>document</title>

    <link rel="stylesheet" href="/shoekream/resources/css/product/product.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <div class="search_title">
            <h1 class="title_txt">SHOP</h1>
        </div>
        <main>
            <div class="content">
                <aside>
                    <div class="search_filter">
                        <div class="filter_status">
                            <div class="status_box">
                                <span class="status_txt">필터</span>
                            </div>
                            <a href="#" class="btn_delete">초기화</a>
                        </div>
                        <div class="filter_list filter_open selected">
                            <div class="filter_title">
                                <div class="title_box">
                                    <span class="main_title">카테고리</span>
                                </div>
                                   <form action="" class="category" id="categoryForm">
                                        <div class="category_select">
                                            <label><input type="checkbox" name="category" value="Sneaker"> 스니커즈</label><br>
                                            <label><input type="checkbox" name="category" value="Sandal"> 샌들/슬리퍼</label><br>
                                            <label><input type="checkbox" name="category" value="flat" > 플랫</label><br>
                                            <label><input type="checkbox" name="category" value="loafers"> 로퍼</label><br>
                                            <label><input type="checkbox" name="category" value="derby"> 더비/레이스업</label><br>
                                            <label><input type="checkbox" name="category" value="heel-pumps"> 힐/펌프스</label><br>
                                            <label><input type="checkbox" name="category" value="boots"> 부츠</label><br>
                                            <label><input type="checkbox" name="category" value="etc"> 기타신발</label>
                                        </div>
                                    </form>
                                    <div>
                                        <span class="main_title">브랜드</span>
                                    </div>
                                    <div class="brand_select">
                                       <form action="" class="brand" id="brandForm">
                                            <label><input type="checkbox" name="brand" value="Nike"> Nike</label><br>
                                            <label><input type="checkbox" name="brand" value="Adidas"> Adidas</label><br>
                                            <label><input type="checkbox" name="brand" value="Gucci"> Gucci</label><br>
                                            <label><input type="checkbox" name="brand" value="Balenciaga"> Balenciaga</label><br>
                                            <label><input type="checkbox" name="brand" value="Louis_Vuitton"> Louis Vuitton</label><br>
                                            <label><input type="checkbox" name="brand" value="Polo"> Polo</label><br>
                                            <label><input type="checkbox" name="brand" value="Yeezy"> Yeezy</label><br>
                                            <label><input type="checkbox" name="brand" value="Supreme"> Supreme</label><br>
                                            <label><input type="checkbox" name="brand" value="Prada"> Prada</label><br>
                                            <label><input type="checkbox" name="brand" value="Saint_Laurent"> Saint Laurent</label><br>
                                            <label><input type="checkbox" name="brand" value="Givenchy"> Givenchy</label><br>
                                            <label><input type="checkbox" name="brand" value="Fendi"> Fendi</label><br>
                                            <label><input type="checkbox" name="brand" value="Versace"> Versace</label><br>
                                            <label><input type="checkbox" name="brand" value="Alexander McQueen"> Alexander McQueen</label><br>
                                            <label><input type="checkbox" name="brand" value="Puma"> Puma</label><br>
                                            <label><input type="checkbox" name="brand" value="Chanel"> Chanel</label><br>
                                            <label><input type="checkbox" name="brand" value="Dior"> Dior</label><br>
                                            <label><input type="checkbox" name="brand" value="Converse"> Converse</label><br>
                                            <label><input type="checkbox" name="brand" value="New_Balance"> New Balance</label><br>
                                            <label><input type="checkbox" name="brand" value="Vans"> Vans</label>
                                        </form>
                                    </div>
                                </div>
                                <br>
                                <div>
                                    <span class="main_title">가격대</span>
                                </div>
                                <form action="" class="price" id="priceForm">
                                    <div class="price_select">
                                        <label><input type="checkbox" name="price" value="under_10"> 10만원 이하</label><br>
                                        <label><input type="checkbox" name="price" value="10_30"> 10-30만원</label><br>
                                        <label><input type="checkbox" name="price" value="30_50"> 30-50만원</label><br>
                                        <label><input type="checkbox" name="price" value="50_100"> 50-100만원</label><br>
                                        <label><input type="checkbox" name="price" value="100_300"> 100-300만원</label><br>
                                        <label><input type="checkbox" name="price" value="over_300"> 300만원 이상</label><br>
                                    </div>
                                </form>
                            </div>
                        </div>
                </aside>
                <div class="search_content">
                    <div class="shop_counts">
                        <div class="filter_result">
                            <span class="title">상품</span>
                        </div>
                        <div class="filter_sorting">
                            <button type="button" class="sorting_title">남성 인기순</button>
                        </div>
                    </div>
                    <div class="search_product_content">
                        <ul class="product_list_wrap">
                           <%for(EnrollProductVo vo : productVoList){ %>	
                            <li>
                            <a href="/shoekream/product/detail?modelNumber=<%=vo.getModelNumber()%>">
                            
                                <div class="product">
                                    <div id="product_img">
                                        <img src="./resources/product1.webp">
                                    </div>
                                    <div class="info_box">
                                        <div id="brand"><%= vo.getBrand()%></div>
                                        <div id="model_name"><%= vo.getProductName() %></div>
                                        <div id="price"><%=vo.getReleasePrice() %></div>
                                    </div>
                                </div>
                            </a>
                            </li>
                           <%} %>
                        </ul>
                    </div>
                </div>
            </div>
        </main>
        
</body>
</html>
        <script>
            const searchBtn = document.querySelector("#search_btn");
        </script>
        <!-- JavaScript 코드를 추가 -->
<script>
 document.addEventListener("DOMContentLoaded", function () {
            const searchBtn = document.querySelector("#search_btn");

            // 카테고리, 브랜드, 가격대 체크박스들을 모두 선택합니다.
            const categoryCheckboxes = document.querySelectorAll('[name="category"]');
            const brandCheckboxes = document.querySelectorAll('[name="brand"]');
            const priceCheckboxes = document.querySelectorAll('[name="price"]');

            // 초기화 버튼을 선택합니다.
            const resetButton = document.querySelector(".btn_delete");

            // 초기화 버튼에 이벤트 리스너를 추가합니다.
            resetButton.addEventListener("click", function () {
                // 모든 카테고리, 브랜드, 가격대 체크박스를 해제합니다.
                categoryCheckboxes.forEach(function (checkbox) {
                    checkbox.checked = false;
                });

                brandCheckboxes.forEach(function (checkbox) {
                    checkbox.checked = false;
                });

                priceCheckboxes.forEach(function (checkbox) {
                    checkbox.checked = false;
                });

                filterProducts(); // 초기화할 때도 필터링을 수행합니다.
            });

            // 상품을 필터링하고 결과를 콘솔에 출력하는 함수입니다.
            function filterProducts() {
                // 선택된 카테고리, 브랜드, 가격대를 저장할 배열들입니다.
                const selectedCategories = [];
                const selectedBrands = [];
                const selectedPrices = [];

                // 선택된 카테고리 체크박스들을 확인하고 배열에 추가합니다.
                categoryCheckboxes.forEach(function (checkbox) {
                    if (checkbox.checked) {
                        selectedCategories.push(checkbox.value);
                    }
                });

                // 선택된 브랜드 체크박스들을 확인하고 배열에 추가합니다.
                brandCheckboxes.forEach(function (checkbox) {
                    if (checkbox.checked) {
                        selectedBrands.push(checkbox.value);
                    }
                });

                // 선택된 가격대 체크박스들을 확인하고 배열에 추가합니다.
                priceCheckboxes.forEach(function (checkbox) {
                    if (checkbox.checked) {
                        selectedPrices.push(checkbox.value);
                    }
                });

                // 여기에 상품 필터링 및 화면 갱신 로직을 추가하세요.
                // 여기서는 콘솔에 로그를 출력하는 예시 코드를 작성합니다.
                console.clear(); // 콘솔을 정리합니다.
                console.log("Selected Categories:", selectedCategories);
                console.log("Selected Brands:", selectedBrands);
                console.log("Selected Prices:", selectedPrices);
            }
        });
 document.addEventListener("DOMContentLoaded", function () {
	    const categoryCheckboxes = document.querySelectorAll('#categoryForm input[type="checkbox"]');
	    const brandCheckboxes = document.querySelectorAll('#brandForm input[type="checkbox"]');
	    const priceCheckboxes = document.querySelectorAll('#priceForm input[type="checkbox"]');

	    // 체크박스들에 대해 이벤트 리스너를 추가합니다.
	    addChangeEventListeners(categoryCheckboxes, '#categoryForm');
	    addChangeEventListeners(brandCheckboxes, '#brandForm');
	    addChangeEventListeners(priceCheckboxes, '#priceForm');

	    function addChangeEventListeners(checkboxes, formSelector) {
	        checkboxes.forEach(checkbox => {
	            checkbox.addEventListener('change', function() {
	                sendAjaxRequest(formSelector);
	            });
	        });
	    }

	    function sendAjaxRequest(formSelector) {
	        const form = document.querySelector(formSelector);
	        const formData = new FormData(form);
	        const xhr = new XMLHttpRequest();
	        xhr.open("POST", form.action, true);
	        xhr.setRequestHeader("Accept", "application/json");

	        xhr.onreadystatechange = function() {
	            if (xhr.readyState === XMLHttpRequest.DONE) {
	                if (xhr.status === 200) {
	                    console.log("Response:", xhr.responseText);
	                    // 여기서 필요한 로직을 추가하세요 (예: 페이지의 내용 갱신)
	                } else {
	                    console.error("AJAX request failed:", xhr.statusText);
	                }
	            }
	        };

	        xhr.send(formData);
	    }
	});

        
</script>
    