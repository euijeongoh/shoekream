<%@page import="com.shoekream.request.vo.RequestVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% RequestVo vo = (RequestVo)request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/admin/board/request/admin_detail.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp"%>
	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp"%>
			<div class="board_wrap">
				<div class="board_title">상품 등록 요청</div>
				<div class="dropdown_head">
					<div class="date_box">
						<div class="date"><%= vo.getEnrollDate() %></div>
					</div>
					<div class="request_box">
						<div class="request_title"> <%= vo.getTitle()%> </div>
						<div class="request_nick"> <%= vo.getMemberNick() %></div>
					</div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="contents" id="contents" cols="50" rows="30" readonly><%= vo.getContent() %></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/admin/common/admin_footer.jsp"%>
</body>
</html>