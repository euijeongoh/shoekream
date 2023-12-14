<%@page import="com.shoekream.request.vo.RequestVo"%>
<%@page import="com.shoekream.page.vo.PageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		List<RequestVo> requestVoList = (List<RequestVo>)request.getAttribute("requestVoList");
		PageVo pvo = (PageVo)request.getAttribute("pvo");
		String x = (String) request.getAttribute("x");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/admin/board/request/admin_list.css">

</head>
<body>

<%-- ${ requestVoList } --%>

	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp"%>

			<!-- 본문 -->
			<div class="board_wrap">
				<div class="board_title">상품 등록 요청</div>
				<div class="board_search">
					<div>	
					<form action="/shoekream/admin/request/search" method="get">
						검색: <input class="search" name="search" type="text"  value="${ x }">
						<input type="submit" value="검색하기">
					</div>
					</form>
				</div>
				<ul class="dropdown_list">
					<%for(RequestVo vo : requestVoList) {%>
					<li>
					<a href="/shoekream/admin/request/detail?no=<%= vo.getNo() %>">
						<div class="dropdown"><%= vo.getTitle() %></div>
						<div class="serve">
							<div class="nickname"><%= vo.getMemberNick() %></div>
							<div class="hit"><%= vo.getHit() %></div>
							<div class="date"><%= vo.getEnrollDate() %></div>
						</div>
					</a>
					</li>
					<% } %>
				</ul>
				<% if(x != null && x.length() > 0){ %>
					<div class="pagination">
					<div class="pagination_box">
						<div class="prev_btn">
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/admin/request/search?pno=1&search=<%= x %>">《 </a>
							<% } %>
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/admin/request/search?pno=<%= pvo.getStartPage() - 1 %>&search=<%= x %>">〈 </a>
							<% } %>
						</div>

						<div class="page_bind">
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++) { %>
							<% if(i == pvo.getCurrentPage()) { %>
								<a href="/shoekream/admin/request/search?pno=<%= i %>&search=<%= x %>"><%= i %></a>
							<% }else {%>
								<a href="/shoekream/admin/request/search?pno=<%= i %>&search=<%= x %>"><%= i %></a>
							<% } %>
						<% } %>
						</div>
						
						<div class="next_btn_box">
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							<a href="/shoekream/admin/request/search?pno=<%= pvo.getEndPage() + 1 %>&search=<%= x %>"> 〉</a>
							<% } %>
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							 <a href="/shoekream/admin/request/search?pno=<%= pvo.getMaxPage() %>&search=<%= x %>"> 》</a>
							 <% } %>
						
						</div>
					</div>
				</div>
				<% }else{ %>
					<div class="pagination">
					<div class="pagination_box">
						<div class="prev_btn">
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/admin/request/list?pno=1">《 </a>
							<% } %>
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/admin/request/list?pno=<%= pvo.getStartPage() - 1 %>">〈 </a>
							<% } %>
						</div>

						<div class="page_bind">
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++) { %>
							<% if(i == pvo.getCurrentPage()) { %>
								<a href="/shoekream/admin/request/list?pno=<%= i %>"><%= i %></a>
							<% }else {%>
								<a href="/shoekream/admin/request/list?pno=<%= i %>"><%= i %></a>
							<% } %>
						<% } %>
						</div>
						
						<div class="next_btn_box">
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							<a href="/shoekream/admin/request/list?pno=<%= pvo.getEndPage() + 1 %>"> 〉</a>
							<% } %>
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							 <a href="/shoekream/admin/request/list?pno=<%= pvo.getMaxPage() %>"> 》</a>
							 <% } %>
						
						</div>
					</div>
				</div>
				<% } %>
	           </div>
			</div>
		</div>
	<%@ include file="/WEB-INF/views/admin/common/admin_footer.jsp"%>
</body>
</html>