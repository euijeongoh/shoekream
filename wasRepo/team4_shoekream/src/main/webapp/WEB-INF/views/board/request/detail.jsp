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
	href="/shoekream/resources/css/board/request/detail.css">
</head>
<body>

<%-- ${vo} --%>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/common/service_center_side.jsp"%>
			<div class="board_wrap">
				<div class="board_title">상품 등록 요청</div>
				<div class="dropdown_head">
					<div class="date_box">
						<div class="date"><%= vo.getEnrollDate() %></div>
					</div>
					<div class="request_box">
						<div class="request_title"> <%= vo.getTitle()%> </div>
						<div class="serve">
						<div class="request_nick"> 닉네임: <%= vo.getMemberNick() %></div>
						<div class="request_hit"> 조회수: <%= vo.getHit() %></div>
						</div>
						
					</div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="contents" id="contents" cols="50" rows="30" readonly><%= vo.getContent() %></textarea>
					</div>
				</div>
				<div class="btn_list">
					<div class="btn_box">
						<a href="/shoekream/request/list">목록으로</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>