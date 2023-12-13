<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    List<EnrollProductVo> productVoList = (List<EnrollProductVo>) request.getAttribute("productVoList");
    List<EnrollProductVo> filterProductList = (List<EnrollProductVo>) request.getAttribute("filterProductList");
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
                  <form action="/shoekream/product" method="POST" class="category" id="categoryForm">
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
                                        <div class="category_select">
                                            <label><input type="checkbox" name="category" value="1"> 스니커즈</label><br>
                                            <label><input type="checkbox" name="category" value="2"> 샌들/슬리퍼</label><br>
                                            <label><input type="checkbox" name="category" value="3" > 플랫</label><br>
                                            <label><input type="checkbox" name="category" value="4"> 로퍼</label><br>
                                            <label><input type="checkbox" name="category" value="5"> 더비/레이스업</label><br>
                                            <label><input type="checkbox" name="category" value="6"> 힐/펌프스</label><br>
                                            <label><input type="checkbox" name="category" value="7"> 부츠</label><br>
                                            <label><input type="checkbox" name="category" value="8"> 기타신발</label>
                                        </div>
                                
                                    <div>
                                        <span class="main_title">브랜드</span>
                                    </div>
                                    <div class="brand_select">
                                            <label><input type="checkbox" name="brand" value="1"> Nike</label><br>
                                            <label><input type="checkbox" name="brand" value="2"> Adidas</label><br>
                                            <label><input type="checkbox" name="brand" value="3"> Gucci</label><br>
                                            <label><input type="checkbox" name="brand" value="4"> Balenciaga</label><br>
                                            <label><input type="checkbox" name="brand" value="5"> Louis Vuitton</label><br>
                                            <label><input type="checkbox" name="brand" value="6"> Polo</label><br>
                                            <label><input type="checkbox" name="brand" value="7"> Yeezy</label><br>
                                            <label><input type="checkbox" name="brand" value="8"> Supreme</label><br>
                                            <label><input type="checkbox" name="brand" value="9"> Prada</label><br>
                                            <label><input type="checkbox" name="brand" value="10"> Saint Laurent</label><br>
                                            <label><input type="checkbox" name="brand" value="11"> Givenchy</label><br>
                                            <label><input type="checkbox" name="brand" value="12"> Fendi</label><br>
                                            <label><input type="checkbox" name="brand" value="13"> Versace</label><br>
                                            <label><input type="checkbox" name="brand" value="14"> Alexander McQueen</label><br>
                                            <label><input type="checkbox" name="brand" value="15"> Puma</label><br>
                                            <label><input type="checkbox" name="brand" value="16"> Chanel</label><br>
                                            <label><input type="checkbox" name="brand" value="17"> Dior</label><br>
                                            <label><input type="checkbox" name="brand" value="18"> Converse</label><br>
                                            <label><input type="checkbox" name="brand" value="19"> New Balance</label><br>
                                            <label><input type="checkbox" name="brand" value="20"> Vans</label>
                                    </div>
                                </div>
                    </form>
                </aside>
                <div class="search_content">
                    <div class="shop_counts">
                        <div class="filter_result">
                            <span class="title">상품</span>
                        </div>
                    </div>
                    <div class="search_product_content">
                        <ul class="product_list_wrap">
                           <%for(EnrollProductVo vo : productVoList){ %>	
                            <li>
                            <a href="/shoekream/product/detail?modelNumber=<%=vo.getModelNumber()%>">
                                <div class="product">
                                    <div id="product_img">
                                    <%if(Integer.parseInt(vo.getProductNo()) >= 52){ %>
                                        <img src="/shoekream/resources/img/product/<%=vo.getModelNumber()%>.png">
                                    <%}else{ %>
                                        <img src="/shoekream/resources/img/product/<%=vo.getModelNumber()%>.webp">
                                        <%} %>
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
	document.addEventListener("DOMContentLoaded", function () {
    // 체크박스와 초기화 버튼 선택
    const categoryCheckboxes = document.querySelectorAll('input[name=category]');
    const brandCheckboxes = document.querySelectorAll('input[name=brand]');
    const resetButton = document.querySelector(".btn_delete");

    // 체크박스에 이벤트 리스너 추가
    [categoryCheckboxes, brandCheckboxes].forEach(group => {
        group.forEach(checkbox => {
            checkbox.addEventListener('change', sendAjaxRequest);
        });
    });

    // 초기화 버튼에 이벤트 리스너 추가
    resetButton.addEventListener("click", function () {
        [categoryCheckboxes, brandCheckboxes].forEach(group => {
            group.forEach(checkbox => {
                checkbox.checked = false;
            });
        });
        sendAjaxRequest(); // 초기화 후 필터링 수행
    });

    // AJAX 요청 전송 함수
    function sendAjaxRequest() {
    const selectedCategories = getSelectedValues(categoryCheckboxes);
    const selectedBrands = getSelectedValues(brandCheckboxes);

    const jsonObj = {
        categoryNos: selectedCategories,
        brandNos: selectedBrands
    };

    const jsonStr = JSON.stringify(jsonObj);

    fetch("/shoekream/product", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json' // JSON 데이터를 보낼 때는 Content-Type 헤더 설정 필요
        },
        body: jsonStr
    })
    .then(response => response.json())
    .then(data => {
    console.log(data); // 여기서 응답 데이터 확인
    updateProductList(data);
})
    .catch(error => console.error('Error:', error));
}

// 선택된 체크박스 값 배열로 반환하는 함수
function getSelectedValues(checkboxes) {
    return Array.from(checkboxes)
                .filter(checkbox => checkbox.checked)
                .map(checkbox => checkbox.value);
}

// 서버로부터 받은 데이터로 상품 목록을 업데이트하는 함수
function updateProductList(products) {
    const productListElement = document.querySelector('.product_list_wrap');
    productListElement.innerHTML = ''; // 기존 목록 초기화

    products.forEach(product => {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <a href="/shoekream/product/detail?modelNumber=${product.modelNumber}">
                <div class="product">
                    <div id="product_img">
                        <img src="/shoekream/resources/img/product/${product.modelNumber}.webp">
                    </div>
                    <div class="info_box">
                        <div id="brand">${product.brand}</div>
                        <div id="model_name">${product.productName}</div>
                        <div id="price">${product.releasePrice}</div>
                    </div>
                </div>
            </a>`;
        productListElement.appendChild(listItem);
    });
}

    // 선택된 체크박스 값 배열로 반환 함수
    function getSelectedValues(checkboxes) {
        return Array.from(checkboxes)
                    .filter(checkbox => checkbox.checked)
                    .map(checkbox => checkbox.value);
    }
});

        
</script>
    