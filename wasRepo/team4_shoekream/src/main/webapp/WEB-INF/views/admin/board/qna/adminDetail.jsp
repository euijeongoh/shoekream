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
					<div class="date_box">
						<div class="date"><%= vo.getEnrollDate() %></div>
					</div>
					<div class="qna_box">
						<div class="qna_title"> <%= vo.getTitle()%> </div>
						<div class="qna_nick"> <%= vo.getMemberNick() %></div>
					</div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="contents" id="contents" cols="50" rows="30" readonly><%= vo.getContent() %></textarea>
					</div>
				</div>
				<% if(vo.getReplyTitle()==null) {%>
				<form action="/shoekream/admin/qna/detail?no=<%=vo.getNo()%>" method="post">
					<div class="dropdown_reply">
						<div class="reply_date">날짜</div>
						<div class="reply_title">
							제목: <input type="text" name="replyTitle" >
						</div>
						<div class="reply">
							<textarea  id="replys" name="replyContent" cols="50" rows="30" placeholder ="작성된 답변이 없습니다."></textarea>
						</div>
						<div class="reply_write">
							<div class="reply_btn">
								<input type="submit" id="submit" value="답글 작성">
							</div>
						</div>
					</div>
				</form>
				<% }else{ %>
					<div class="dropdown_reply">
						<div class="reply_date"><%=vo.getReplyEnrollDate() %></div>
						<div class="reply_title">
							제목: <%=vo.getReplyTitle() %>
						</div>
						<div class="reply">
							<textarea  id="replys" name="replyContent" cols="50" rows="30" readonly><%=vo.getReplyContent() %></textarea>
						</div>
						
					</div>
				<% } %>
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