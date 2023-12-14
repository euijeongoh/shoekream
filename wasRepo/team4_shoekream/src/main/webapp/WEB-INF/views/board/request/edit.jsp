<%@page import="com.shoekream.request.vo.RequestVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
RequestVo vo = (RequestVo) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/board/request/edit.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
${vo }
	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/common/service_center_side.jsp"%>
			<div class="board_wrap">
				<div class="board_title">공지사항</div>
				<div class="dropdown_head">
					<form action="/shoekream/request/edit?no=<%=vo.getNo()%>" method="post">
						<div class="request_title">
							제목 : <input class="title_input" type="text" name="title" value= <%=vo.getTitle()%>>
						</div>
				</div>
				<div class="dropdown_content">
					<div class="content">
						<textarea name="contents" id="contents" cols="50" rows="30"> <%=vo.getContent()%></textarea>

					</div>
				</div>
				<div class="btn_list">
					<div class="btn_editbox">
						<input type="submit" id="submit" value="수정하기">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>