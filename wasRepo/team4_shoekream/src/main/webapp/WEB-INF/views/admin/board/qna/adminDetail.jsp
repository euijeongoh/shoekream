<%@ page import="com.shoekream.qna.vo.QnaVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% QnaVo vo = (QnaVo)request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/admin/board/qna/admin_detail.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp"%>
			<div class="board_wrap">
				<div class="board_title">Q&A</div>
				<div class="dropdown_head">
					<div class="date"><%= vo.getEnrollDate() %></div>
					<div class="qna_title"> <%= vo.getTitle()%> </div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="contents" id="contents" cols="50" rows="30" readonly><%= vo.getContent() %></textarea>
					</div>
				</div>
				<div class="dropdown_reply">
					<div class="reply_date"></div>
					<div class="reply_title"></div>
					<div class="reply">
						<textarea name="replys" id="replys" cols="50" rows="30" placeholder ="작성된 답변이 없습니다." readonly></textarea>
					</div>
				</div>
				<div class="btn_list">
					<div class="btn_box">
						<a href="/shoekream/admin/qna/list">목록으로</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>