<%@page import="com.shoekream.admin.vo.OrdersVo" %>
    <%@page import="java.util.List" %>
        <%@page import="com.shoekream.page.vo.PageVo" %>
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
                <% List<OrdersVo> OrderVoList = (List<OrdersVo>) request.getAttribute("OrderCheckVoList");
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

                                            
                                            <form name="selectForm">
                                                <table class="order-table" border="1">
                                                <h2>검수 현황</h2>
                                                    <thead>
                                                        <tr class="order">
                                                            <th class="checkbox-header">번호</th>
                                                            <th class="order-date">주문일자</th>
                                                            <th class="order-info">입찰번호/<br>이메일</th>
                                                            <th class="product">상품</th>
                                                            <th class="price">구매가격</th>
                                                            <th class="seller-buyer">구매자</th>
                                                            <th class="inspection-progress">검수진행</th>
                                                            <th class="status">진행현황</th>
                                                            <th class="button">저장</th>
                                                        </tr>
                                                    </thead>
                                                    <%for(OrdersVo vo : OrderVoList){ %>
                                                        <form action="" method="post">
                                                        <tbody>
                                                            <tr class="order-item">
                                                                <td class="checkbox-cell">
                                                                    
                                                                   
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
                                                                    <%=vo.getCheckResult() %>
                                                                </td>
                                                                <td class="status">
                                                                    <input type="radio" value="1" id="storage" name="order_status" checked="checked">입고완료<br>
                                                                    <input type="radio" value="2" id="check" name="order_status">검수완료<br>
                                                                    <input type="radio" value="6" id="send_success" name="order_status">배송완료<br>
                                                                    <input type="radio" value="3" id="send_fail" name="order_status">반송처리
                                                                </td>
                                                                <td class="button">
                                                                    <input type="submit" value="저장">
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </form>
                                                        <%} %>
                                                </table>

                                            </form>
                                            <div class="page-area">

                                                <% if(pvo.getStartPage()> 1){%>
                                                    <a href="/shoekream/admin/order/check/list?pno=<%=pvo.getStartPage()-1%>">이전</a>
                                                    <%} %>
                                                        <%for(int i=pvo.getStartPage(); i <=pvo.getEndPage(); i++){ %>
                                                            <%if( i==pvo.getCurrentPage()) {%>
                                                                <span>
                                                                    <%= i %>
                                                                </span>
                                                                <% }else{ %>
                                                                    <a href="/shoekream/admin/order/check/list?pno=<%=i%>">
                                                                        <%= i %>
                                                                    </a>
                                                                    <% } %>
                                                                        <%} %>
                                                                            <% if( pvo.getEndPage() !=pvo.getMaxPage()){
                                                                                %>
                                                                                <a
                                                                                    href="/shoekream/admin/order/check/list?pno=<%=pvo.getEndPage()+1%>">다음</a>
                                                                                <%} %>
                                            </div>
                                        </div>
                                </div>


                        </body>
                        

                        </html>