<%@page import="com.shoekream.admin.vo.OrdersVo" %>
    <%@page import="java.util.List" %>
        <%@page import="com.shoekream.page.vo.PageVo" %>
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
                <% List<OrdersVo> OrderVoList = (List<OrdersVo>) request.getAttribute("OrderStorageVoList");
                        PageVo pvo = (PageVo)request.getAttribute("pvo");
                        %>
                        <!DOCTYPE html>
                        <html>

                        <head>
                            <meta charset="UTF-8">
                            <title>Insert title here</title>
                            <link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_sidebar.css">
                            <link rel="stylesheet" href="/shoekream/resources/css/admin/list/breakdown.css">
                        </head>

                        <body>

                            <%@ include file="/WEB-INF/views/admin/common/admin_header.jsp" %>

                                <div class="container">

                                    <%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp" %>

                                        <div class="table_container">

                                            <form name="searchForm">
                                                <div class="search_box">
                                                    <table class="table left_gray filters-table collapsed">
                                                        <tbody>
                                                            <tr>
                                                                <td id="search-title">일자</td>
                                                                <td colspan="3" class="form-inline">
                                                                    <select class="input-sm" name="date_option">
                                                                        <option value="order" selected="">주문일자</option>
                                                                        <option value="send">발송일자</option>
                                                                        <option value="invInput">인쇄일자</option>
                                                                    </select>

                                                                    <div class="form-group" role="group"
                                                                        aria-label="...">
                                                                        <label><input type="radio" name="date_type"
                                                                                class="date_type">3개월</label>
                                                                        <label><input type="radio" name="date_type"
                                                                                class="date_type">어제</label>
                                                                        <label><input type="radio" name="date_type"
                                                                                class="date_type">오늘</label>
                                                                        <label><input type="radio" name="date_type"
                                                                                class="date_type">일주일</label>
                                                                        <label><input type="radio" name="date_type"
                                                                                class="date_type">한달</label>
                                                                        <label><input type="radio" name="date_type"
                                                                                class="date_type">임의기간</label>
                                                                    </div>

                                                                    <input type="text"
                                                                        class="form-control input-sm hasDatepicker"
                                                                        id="start_date" name="start_date" maxlength="10"
                                                                        value="2023-11-30" size="10" disabled=""
                                                                        onblur="javascript:jsDayCheck(this);"
                                                                        autocomplete="off">
                                                                    ~
                                                                    <input type="text"
                                                                        class="form-control input-sm hasDatepicker"
                                                                        id="end_date" name="end_date" maxlength="10"
                                                                        value="2023-11-30" size="10" disabled=""
                                                                        onblur="javascript:jsDayCheck(this);"
                                                                        autocomplete="off">


                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td id="search-title">키워드 </td>
                                                                <td colspan="3">
                                                                    <div id="search_div">
                                                                        <select id="search_how" class="input-sm"
                                                                            name="search_how">
                                                                            <option value="all">통합검색</option>
                                                                            <option value="order_code">주문번호</option>
                                                                            <option value="opt_match_p_nm">재고매칭상품명
                                                                            </option>
                                                                            <option value="opt_match_o_nm">재고매칭옵션명
                                                                            </option>
                                                                            <option value="option_note_search_key">옵션비고
                                                                            </option>
                                                                        </select>
                                                                        <input type="text"
                                                                            class="form-control input-sm">
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="btn_center">
                                                    <button type="submit" id="search_button"
                                                        class="btn btn-primary btn-lg"></i> 검색</button>
                                                </div>


                                            </form>
                                            <form name="selectForm">
                                                <table class="order-table" border="1">
                                                	<h2>입고 현황</h2>
                                                    <thead>
                                                        <tr class="order">
                                                            <th class="checkbox-header"><input type="checkbox"></th>
                                                            <th class="order-date">주문일자</th>
                                                            <th class="order-info">주문번호/<br>이메일</th>
                                                            <th class="product">상품</th>
                                                            <th class="price">구매가격</th>
                                                            <th class="seller-buyer">구매자</th>
                                                            <th class="inspection-progress">검수진행</th>
                                                            <th class="status">진행현황</th>
                                                        </tr>
                                                    </thead>
                                                    <%for(OrdersVo vo : OrderVoList){ %>
                                                        <tbody>
                                                            <tr class="order-item">
                                                                <td class="checkbox-cell">
                                                                    <input type="checkbox">
                                                                    <br>
                                                                    <p>
                                                                        <%=vo.getNo() %>
                                                                    </p>
                                                                </td>
                                                                <td class="order-date">
                                                                    <%=vo.getOrdersDate() %>
                                                                </td>
                                                                <td class="order-info">
                                                                    <%=vo.getBiddingNo() %>/<br>
                                                                        <%=vo.getEmail() %>
                                                                </td>
                                                                <td class="product">
                                                                    <%=vo.getProductName() %>
                                                                        <p>
                                                                            <%=vo.getProductNameKo() %>
                                                                        </p>
                                                                </td>
                                                                <td class="price">
                                                                    <%=vo.getPrice() %>원
                                                                </td>
                                                                <td class="seller-buyer">
                                                                    <%=vo.getMemberName() %>
                                                                </td>
                                                                <td class="inspection-progress">
                                                                    <select name="inspection" id="inspection">
                                                                        <option value="inspection_ing" >입고필요</option>
                                                                        <option value="inspection_ing" >검수중</option>
                                                                    </select>
                                                                </td>
                                                                <td class="status">
                                                                    <input type="checkbox" value="inspection-completed">입고완료<br>
                                                                    <input type="checkbox"
                                                                        value="requires-warehousing">검수완료<br>
                                                                    <input type="checkbox"
                                                                        value="delivery-completed">배송완료<br>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                        <%} %>
                                                </table>

                                            </form>
                                            <div class="page-area">

                                                <% if(pvo.getStartPage()> 1){%>
                                                    <a href="/shoekream/admin/order/storage/list?pno=<%=pvo.getStartPage()-1%>">이전</a>
                                                    <%} %>
                                                        <%for(int i=pvo.getStartPage(); i <=pvo.getEndPage(); i++){ %>
                                                            <%if( i==pvo.getCurrentPage()) {%>
                                                                <span>
                                                                    <%= i %>
                                                                </span>
                                                                <% }else{ %>
                                                                    <a href="/shoekream/admin/order/storage/list?pno=<%=i%>">
                                                                        <%= i %>
                                                                    </a>
                                                                    <% } %>
                                                                        <%} %>
                                                                            <% if( pvo.getEndPage() !=pvo.getMaxPage()){
                                                                                %>
                                                                                <a
                                                                                    href="/shoekream/admin/order/storage/list?pno=<%=pvo.getEndPage()+1%>">다음</a>
                                                                                <%} %>
                                            </div>
                                        </div>
                                </div>


                        </body>
                        

                        </html>