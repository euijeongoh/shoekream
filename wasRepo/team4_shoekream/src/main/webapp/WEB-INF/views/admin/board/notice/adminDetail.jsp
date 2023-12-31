<%@page import="com.shoekream.notice.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% NoticeVo vo = (NoticeVo)request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="/shoekream/resources/css/admin/board/notice/admin_detail.css">
</head>
<body>
<%-- 	${ vo }; --%>
	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp"%>
			<div class="board_wrap">
				<div class="board_title">공지사항</div>
				<div class="dropdown_head">
					<div class="date"><%= vo.getEnrollDate() %></div>
					<div class="notice_title"> <%= vo.getTitle()%> </div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="contents" id="contents" cols="50" rows="30" readonly><%= vo.getContent() %></textarea>
					</div>
				</div>
				<div class="btn_list">
                    <div class="btn_leftbox"></div>
                    <div class="btn_centerbox">
                        <div class="btn_listbox"><a href="/shoekream/admin/notice/list">목록으로</a></div>
                    </div>
                    <div class="btn_rightbox">
                        <div class="btn_editbox">
                        <a href="/shoekream/admin/notice/edit?no=<%=vo.getNo()%>">수정</a>
                        </div>
                        <div class="btn_deletebox">
                            <a href="/shoekream/admin/notice/delete?no=<%= vo.getNo() %>">삭제</a>
                        </div>
                    </div>
                </div>
<%--                             <a href="/shoekream/admin/notice/edit?no=<%=vo.getNo()%>&title=<%=vo.getTitle()%>&content=<%=vo.getContent()%>">수정</a> --%>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/admin/common/admin_footer.jsp"%>
</body>
</html>