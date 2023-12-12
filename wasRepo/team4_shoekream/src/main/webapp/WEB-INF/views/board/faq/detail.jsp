<%@page import="com.shoekream.faq.vo.FaqVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% FaqVo vo = (FaqVo)request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/board/faq/detail.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/common/service_center_side.jsp"%>
			<div class="board_wrap">
				<div class="board_title">FAQ</div>
				<div class="dropdown_head">
					<div class="date"><%= vo.getEnrollDate() %></div>
					<div class="faq_title"> <%= vo.getTitle()%> </div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="contents" id="contents" cols="50" rows="30" readonly><%= vo.getContent() %></textarea>
					</div>
				</div>
				<div class="btn_list">
					<div class="btn_box">
						<a href="/shoekream/faq/list">목록으로</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>