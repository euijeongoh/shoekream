<%@page import="com.shoekream.notice.controller.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% NoticeVo vo = (NoticeVo)request.getAttribute("no"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/board/notice/detail.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/common/service_center_side.jsp"%>
			<div class="board_wrap">
				<div class="board_title">공지사항</div>
				<div class="dropdown_head">
					<div class="date">2023.11.28</div>
					<div class="notice_title"> <%= vo.getTitle()%></div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="content" placeholder="내용을 입력하세요" rows="30" cols="50">
					</div>
				</div>
				<div class="btn_list">
					<div class="btn_box">
						<a href="/shoekream/notice/list">목록으로</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>