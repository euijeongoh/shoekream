<%@page import="com.shoekream.page.vo.PageVo"%>
<%@page import="com.shoekream.request.vo.RequestVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
		List<RequestVo> requestVoList = (List<RequestVo>)request.getAttribute("requestVoList");
		PageVo pvo = (PageVo)request.getAttribute("pvo");
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/request/list.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/common/service_center_side.jsp"%>

			<!-- 본문 -->
			<div class="board_wrap">
				<div class="board_title">상품 요청 등록</div>
				<div class="board_search">
					<div>	
					<form action="/shoekream/request/search" method="get">
						검색: <input class="search" name="search" type="text">
						<input type="submit" value="검색하기">
					</div>
					</form>
				</div>
				<ul class="dropdown_list">
					<%for(RequestVo vo : requestVoList) {%>
					<li>
					<a href="/shoekream/request/detail?no=<%= vo.getNo() %>">
							<div class="dropdown"><%= vo.getTitle() %></div>
							<div class="date"><%= vo.getEnrollDate() %></div>
					</a>
					</li>
					<% } %>
				</ul>
				<div class="pagination">
					<div class="pagination_box">
						<div class="prev_btn">
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/request/list?pno=1">《 </a>
							<% } %>
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/request/list?pno=<%= pvo.getStartPage() - 1 %>">〈 </a>
							<% } %>
						</div>

						<div class="page_bind">
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++) { %>
							<% if(i == pvo.getCurrentPage()) { %>
								<a href="/shoekream/request/list?pno=<%= i %>"><%= i %></a>
							<% }else {%>
								<a href="/shoekream/request/list?pno=<%= i %>"><%= i %></a>
							<% } %>
						<% } %>
						</div>
						
						<div class="next_btn_box">
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							<a href="/shoekream/request/list?pno=<%= pvo.getEndPage() + 1 %>"> 〉</a>
							<% } %>
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							 <a href="/shoekream/request/list?pno=<%= pvo.getMaxPage() %>"> 》</a>
							 <% } %>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>