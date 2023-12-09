<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	
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
                            <div class="slide"><img src="./KakaoTalk_20231117_164603392-removebg-preview.png" alt=""></div>
                            <div class="slide"><img src="./KakaoTalk_20231117_164605398-removebg-preview.png" alt=""></div>
                            <div class="slide"><img src="./KakaoTalk_20231117_164607805-removebg-preview.png" alt=""></div>
                        </div>
                        <button>이전</button>
                        <button>다음</button>
                    </div>
                    <div class="column_2">
                        <div class="price_container">
                            <div class="product_direct_purchase"><span >즉시 구매가</span></div>
                            <div class="product_price"><span >116,000원</span></div>
                        </div>
                        <div class="main_title_container">
                            <div><span>Nike Air Force 1 '07 Low White</span></div>
                            <div><span>나이키 에어포스 1'07로우 화이트</span></div>
                        </div>
                        <div class="product_size_select">
                            <select name="product_size" class="select_box">
                                <option value="all_size">모든 사이즈</option>
                                <option value="230">230</option>
                                <option value="235">235</option>
                                <option value="240">240</option>
                                <option value="245">245</option>
                                <option value="250">250</option>
                                <option value="255">255</option>
                                <option value="260">260</option>
                                <option value="265">265</option>
                                <option value="270">270</option>
                                <option value="275">275</option>
                                <option value="280">280</option>
                                <option value="285">285</option>
                                <option value="290">290</option>
                                <option value="295">295</option>
                                <option value="300">300</option>
                            </select>
                        </div>
                        <dl  class="detail-product-container">
                            <div class="detail-price">
                                <div class="title-text">최근 거래가</div>
                                <div>
                                    <div class="amount">
                                        <span class="price-info">289,000</span>
                                        <span class="price-info">원</span>
                                    </div>
                                    <div class="fluctuation decrease">
                                        <span class="triangle">▼</span>
                                        <span>10,000 (-3.3%)</span>
                                    </div>
                                </div>
                            </div>
                            <div class="detail-box">
                                <div class="product_title">발매가</div>
                                <div class="product_info"> ¥33,000 (약 288,800원) </div>
                            </div>
                            <div class="detail-box">
                                <div class="product_title">모델번호</div>
                                <div class="product_info"> A01FW702-BLACK </div>
                            </div>
                            <div class="detail-box">
                                <div class="product_title">출시일</div>
                                <div class="product_info">22/07/30</div>
                            </div>
                            
                        </dl>
                        <div class="buttons">
                            <div class="division_btn_box lg">
                                
                                <button class="btn_action" style="background-color: rgb(239, 98, 83);">
                                    <strong class="title">구매</strong>
                                    <div class="price">
                                        <span class="amount">
                                            <em class="num">272,000</em>
                                            <span class="won">원</span>
                                        </span>
                                        <span class="desc">즉시 구매가</span>
                                    </div>
                                </button>
                                <button class="btn_action" style="background-color: rgb(65, 185, 121);">
                                    <strong class="title">판매</strong>
                                    <div class="price">
                                        <span class="amount">
                                            <em class="num">294,000</em>
                                                <span class="won">원</span>
                                        </span>
                                        <span class="desc">즉시 판매가</span>
                                    </div>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="wrap_bids">
                    <div class="tap_area">
                        <ul role="tablist" class="tab_list">
                            <li class="item_on">
                                <a href="#" class="item_link">체결 거래</a>
                            </li>
                            <li>
                                <a href="#" class="item_link">판매 입찰</a>
                            </li>
                            <li>
                                <a href="#" class="item_link">구매 입찰</a>
                            </li>
                        </ul>
                    </div>
                        <div>
                            <table>
                                <thead>
                                    <tr>
                                        <th>옵션</th>
                                        <th>구매 희망가</th>
                                        <th>수량</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="table_td">
                                            <div></div>
                                            <span>230</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>121,000원</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>23/12/01</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="table_td">
                                            <div></div>
                                            <span>230</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>121,000원</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>23/12/01</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="table_td">
                                            <div></div>
                                            <span>230</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>121,000원</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>23/12/01</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="table_td">
                                            <div></div>
                                            <span>230</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>121,000원</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>23/12/01</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="table_td">
                                            <div></div>
                                            <span>230</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>121,000원</span>
                                        </td>
                                        <td class="table_td align_right">
                                            <div></div>
                                            <span>23/12/01</span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                </div>
                <div class="detail_item_title feed_title">
                    
                    <p class="product_detail_item_title reviews"> 스타일 418 </p>
                    <!---->
                </div>
        </main>
        
        <div class="listpoto">
            <div class="one">
                <img src="../ouj/img/reviewlist02.png" alt="사진02" class="poto">
                <div class="detail">
                    <div>
                        <img src="../ouj/img/물결.png" alt="물결프사" class="wave">
                    </div>
                    <div>
                            <img src="../ouj/img/like.png" alt="좋아요" class="likey">  
                    </div>
                </div>
            </div>

            <div class="one">
                <img src="../ouj/img/reviewlist02.png" alt="사진02" class="poto">
                <div class="detail">
                    <div>
                        <img src="../ouj/img/물결.png" alt="물결프사" class="wave">
                    </div>
                    <div>
                            <img src="../ouj/img/like.png" alt="좋아요" class="likey">  
                    </div>
                </div>
            </div>

            <div class="one">
                <img src="../ouj/img/reviewlist03.png" alt="사진03" class="poto">
                <div class="detail">
                    <div>
                        <img src="../ouj/img/물결.png" alt="물결프사" class="wave">
                    </div>
                    <div>
                        <img src="../ouj/img/like.png" alt="좋아요" class="likey">  
                    </div>
                </div>
            </div>

            <div class="one">
                <img src="../ouj/img/reviewlist04.png" alt="사진04" class="poto">
                <div class="detail">
                    <div>
                        <img src="../ouj/img/물결.png" alt="물결프사" class="wave">
                    </div>
                    <div>
                        <img src="../ouj/img/like.png" alt="좋아요" class="likey">  
                    </div>
                </div>
            </div>
        </div>

</body>
</html>