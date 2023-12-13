<%@page import="com.shoekream.admin.vo.EnrollProductVo"%>
<%@page import="com.shoekream.biddingVo.BiddingVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    EnrollProductVo productDetailVo = (EnrollProductVo) request.getAttribute("productDetailVo");
    List<EnrollProductVo> shoesSizesList = (List<EnrollProductVo>) request.getAttribute("shoesSizesList");
    List<BiddingVo> biddingList = (List<BiddingVo>) request.getAttribute("biddingList");
    String sellingPrice = (String) request.getAttribute("sellingPrice");
    String buyingPrice = (String) request.getAttribute("buyingPrice");
    List<BiddingVo> sellBiddingList = (List<BiddingVo>) request.getAttribute("sellBiddingList");
    List<BiddingVo> buyBiddingList = (List<BiddingVo>) request.getAttribute("buyBiddingList");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>관리자 헤더</title>

    <link rel="stylesheet" href="/shoekream/resources/css/product/detail.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <main>
            <div class="container">
                    <div class="slider_container">
                        <div class="slider">
                            <div class="slide"><img src="/shoekream/resources/img/product/<%=productDetailVo.getModelNumber() %>.webp" alt="" id="pro_img"></div>
                        </div>
                    </div>
                    <div class="column_2">
                        <div class="price_container">
                            <div class="product_direct_purchase"><span >즉시 구매가</span></div>
                            <div class="product_price"><span ><%=buyingPrice %></span></div>
                        </div>
                        <div class="main_title_container">
                            <div><span><%= productDetailVo.getProductName() %></span></div>
                            <div><span><%= productDetailVo.getProductNameKo() %></span></div>
                        </div>
                        <div class="product_size_select">
                            <select name="product_size" class="select_box">
                                <option value="all_size">모든 사이즈</option>
								<% for(EnrollProductVo vo : shoesSizesList) { %>
								    <option value="<%= vo.getSizeStr() %>"><%= vo.getSizeStr() %></option>
								<% } %>
                            </select>
                        </div>
                        <dl  class="detail-product-container">
                            <div class="detail-price">
                                <div class="title-text">최근 거래가</div>
                                <div>
                                    <div class="amount">
                                        <span class="price-info"><%=biddingList.get(0).getPrice() %></span>
                                        <span class="price-info">원</span>
                                    </div>
                                    <div class="fluctuation decrease">
                                    </div>
                                </div>
                            </div>
                            <div class="detail-box">
                                <div class="product_title">발매가</div>
                                <div class="product_info"><%= productDetailVo.getReleasePrice() %>원</div>
                            </div>
                            <div class="detail-box">
                                <div class="product_title">모델번호</div>
                                <div class="product_info"><%= productDetailVo.getModelNumber() %></div>
                            </div>
                            <div class="detail-box">
                                <div class="product_title">출시일</div>
                                <div class="product_info"><%= productDetailVo.getReleaseDate() %></div>
                            </div>
                            
                        </dl>
                        <div class="buttons">
                            <div class="division_btn_box lg">
                                 <a class="buy_btn" href="/shoekream/buy/select?productsNo=<%= productDetailVo.getProductNo()%>">
	                               <button class="btn_action" style="background-color: rgb(239, 98, 83);">
	                                   <strong class="title">구매</strong>
	                                   <div class="price">
	                                       <span class="amount">
	                                           <em class="num"></em>
	                                           <span class="won"><%=buyingPrice %>원</span>
	                                       </span>
	                                       <span class="desc">즉시 구매가</span>
	                                   </div>
	                               </button>
                                 </a>
                                  <a href="/shoekream/sell/select?productsNo=?<%=productDetailVo.getProductNo() %>">
	                                <button class="btn_action" style="background-color: rgb(65, 185, 121);">
	                                    <strong class="title">판매</strong>
	                                    <div class="price">
	                                        <span class="amount">
	                                            <em class="num"></em>
	                                                <span class="won"><%=sellingPrice %>원</span>
	                                        </span>
	                                        <span class="desc">즉시 판매가</span>
	                                    </div>
	                                </button>
                                  </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="wrap_bids">
                                <a href="#" class="item_link">체결 거래</a>
                        <div>
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>옵션</th>
                                        <th>체결 가격</th>
                                        <th>체결날짜</th>
                                    </tr>
                                </thead>
                                <thead>
                                <tbody>
                                <% for(BiddingVo vo : biddingList){%>
                                    <tr>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span><%=vo.getShoesSizes() %></span>
                                        </td>
                                        <td class="table_td">
                                            <div></div>
                                            <span><%=vo.getPrice() %></span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span><%=vo.getExpireDate() %></span>
                                        </td>
                                    </tr>
                            	 <%} %>
                                </tbody>
                            </table>
                        </div>
                </div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
        
        
<script>
    let currentIndex = 0;
    const slides = document.querySelectorAll('.slide');
    const totalSlides = slides.length;

    document.querySelector('.slider_container button:nth-child(2)').addEventListener('click', function() {
        currentIndex = (currentIndex + 1) % totalSlides;
        updateSlidePosition();
    });

    document.querySelector('.slider_container button:nth-child(1)').addEventListener('click', function() {
        currentIndex = (currentIndex - 1 + totalSlides) % totalSlides;
        updateSlidePosition();
    });

    function updateSlidePosition() {
        for (let slide of slides) {
            slide.style.transform = `translateX(-${currentIndex * 100}%)`;
        }
    }
    
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        const sellBidsLink = document.querySelector('.item_link:nth-child(2)'); // "판매 입찰" 링크

        sellBidsLink.addEventListener('click', function(event) {
            event.preventDefault(); // 기본 동작 방지
            fetchSellBiddingList();
        });

        function fetchSellBiddingList() {
            // 판매 입찰 데이터 요청
            // 예시 URL: /bidding/sellList, 실제 URL은 서버 구현에 따라 달라질 수 있음
            fetch('/product/detail')
                .then(response => response.json())
                .then(data => {
                    displaySellBiddingList(data.sellBiddingList);
                })
                .catch(error => console.error('Error:', error));
        }

        function displaySellBiddingList(sellBiddingList) {
            const tableBody = document.querySelector('.wrap_bids table tbody');
            tableBody.innerHTML = ''; // 기존 테이블 내용을 초기화

            // 판매 입찰 데이터를 테이블로 생성
            sellBiddingList.forEach(vo => {
                const tr = document.createElement('tr');
                tr.innerHTML = `<td class="table_td align_right"><span>${vo.getName()}</span></td>
                                <td class="table_td"><span>${vo.getPrice()}</span></td>
                                <td class="table_td align_right"><span>${vo.getDate()}</span></td>`;
                tableBody.appendChild(tr);
            });
        }
    });
    </script>
</body>
</html>