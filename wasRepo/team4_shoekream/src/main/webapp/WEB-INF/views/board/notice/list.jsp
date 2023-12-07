<%@page import="com.shoekream.page.vo.PageVo"%>
<%@page import="com.shoekream.notice.controller.NoticeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
		List<NoticeVo> noticeVoList = (List<NoticeVo>)request.getAttribute("noticeVoList");
		PageVo pvo = (PageVo)request.getAttribute("pvo");
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/common/service_center_side.css">
<link rel="stylesheet"
	href="/shoekream/resources/css/board/notice/notice.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/common/service_center_side.jsp"%>

			<!-- 본문 -->
			<div class="board_wrap">
				<div class="board_title">공지사항</div>
				<div class="board_search">
					<div>검색</div>
				</div>
				<ul class="dropdown_list">
					<%for(NoticeVo vo : noticeVoList) {%>
					<li><a href="">
							<div class="dropdown"><%= vo.getTitle() %></div>
							<div class="date"><%= vo.getEnrollDate() %></div>
					</a></li>
					<% } %>
				</ul>
				<div class="pagination">
					<div class="pagination_box">
						<div class="prev_btn">
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/notice/list?pno=1">《 </a>
							<% } %>
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/notice/list?pno=<%= pvo.getStartPage() - 1 %>">〈 </a>
							<% } %>
						</div>

								<div class="page_bind">
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++) { %>
							<% if(i == pvo.getCurrentPage()) { %>
								<a href="/shoekream/notice/list?pno=<%= i %>"><%= i %></a>
							<% }else {%>
								<a href="/shoekream/notice/list?pno=<%= i %>"><%= i %></a>
							<% } %>
						<% } %>
								</div>
						
						<div class="next_btn_box">
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							<a href="/shoekream/notice/list?pno=<%= pvo.getEndPage() + 1 %>"> 〉</a>
							<% } %>
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							 <a href="/shoekream/notice/list?pno=<%= pvo.getMaxPage() %>"> 》</a>
							 <% } %>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>