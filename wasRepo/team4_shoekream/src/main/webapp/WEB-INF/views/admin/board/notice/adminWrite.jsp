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
	href="/shoekream/resources/css/admin/board/notice/admin_edit.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/admin/common/admin_sidebar.jsp"%>
			<div class="board_wrap">
				<div class="board_title">공지사항</div>
				<div class="dropdown_head">
					<form action="/shoekream/admin/notice/write" method="post">
						<div class="notice_title">   
						제목 : <input type="text" name="title"> 
						</div>
				</div>
				<div class="dropdown_content">
					<div class="content">
					  <textarea name="contents" id="contents" cols="50" rows="30" ></textarea>
				 	 
					</div>
				</div>
                <div class="btn_list">
                    <div class="btn_editbox">
<!--                     <a href="">작성완료</a> -->
					<input type="submit" value="작성하기">
					</form>
                    </div>
                </div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>