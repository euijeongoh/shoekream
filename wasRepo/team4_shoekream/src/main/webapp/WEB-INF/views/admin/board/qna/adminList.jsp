<%@page import="com.shoekream.page.vo.PageVo"%>
<%@page import="com.shoekream.qna.vo.QnaVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		List<QnaVo> QnaVoList = (List<QnaVo>)request.getAttribute("qnaVoList");
		PageVo pvo = (PageVo)request.getAttribute("pvo");
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/admin/board/qna/admin_list.css">

</head>
<body>

<%-- ${ pvo } --%>

	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp"%>

			<!-- 본문 -->
			<div class="board_wrap">
				<div class="board_title">Q&A</div>
				<div class="board_search">
					<div>	
					<form action="/shoekream/admin/qna/search" method="get">
						검색: <input class="search" name="search" type="text">
						<input type="submit" value="검색하기">
					</div>
					</form>
				</div>
				<ul class="dropdown_list">
					<%for(QnaVo vo : QnaVoList) {%>
					<li>
					<a href="/shoekream/admin/qna/detail?no=<%= vo.getNo() %>">
							<div class="dropdown"><%= vo.getTitle() %></div>
							<div class="nickname"><%= vo.getMemberNick() %></div>
							<div class="date"><%= vo.getEnrollDate() %></div>
					</a>
					</li>
					<% } %>
				</ul>
				<div class="pagination">
					<div class="pagination_box">
						<div class="prev_btn">
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/admin/qna/list?pno=1">《 </a>
							<% } %>
							<% if(pvo.getStartPage() != 1) { %>
							<a href="/shoekream/admin/qna/list?pno=<%= pvo.getStartPage() - 1 %>">〈 </a>
							<% } %>
						</div>

						<div class="page_bind">
						<% for(int i = pvo.getStartPage(); i <= pvo.getEndPage(); i++) { %>
							<% if(i == pvo.getCurrentPage()) { %>
								<a href="/shoekream/admin/qna/list?pno=<%= i %>"><%= i %></a>
							<% }else {%>
								<a href="/shoekream/admin/qna/list?pno=<%= i %>"><%= i %></a>
							<% } %>
						<% } %>
						</div>
						
						<div class="next_btn_box">
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							<a href="/shoekream/admin/qna/list?pno=<%= pvo.getEndPage() + 1 %>"> 〉</a>
							<% } %>
							<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
							 <a href="/shoekream/admin/qna/list?pno=<%= pvo.getMaxPage() %>"> 》</a>
							 <% } %>
						
						</div>
					</div>
				</div>
	           </div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>