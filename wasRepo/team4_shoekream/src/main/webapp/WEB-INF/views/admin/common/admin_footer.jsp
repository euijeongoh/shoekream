<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String msg = (String) session.getAttribute("alarm"); session.removeAttribute("alarm"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/admin/common/admin_footer.css">
</head>
<body>
	<footer>
		<div class="box1"></div>
		<div class="box2">
			<div></div>
			<div>고객센터 1588-3082</div>
		</div>
		<div class="box3">
			<div class="left_bar">
				<div>
					<a href="/shoekream/admin/notice/list">고객지원</a>
				</div>
				<div>
					<a href="/shoekream/admin/notice/list">공지사항</a>
				</div>
				<div>
					<a href="/shoekream/admin/qna/list">1:1문의</a>
				</div>
				<div>
					<a href="/shoekream/admin/request/list">상품 등록 문의</a>
				</div>
			</div>
			<div class="icons">
				<div>
					<a href=""> <img src="/shoekream/resources/img/footer/인별.png"
						alt="인별">
					</a>
				</div>
				<div>
					<a href=""> <img src="/shoekream/resources/img/footer/페북.png"
						alt="페북">
					</a>
				</div>
				<div>
					<a href=""> <img src="/shoekream/resources/img/footer/카톡.png"
						alt="카톡">
					</a>
				</div>
			</div>
			<div></div>
			<div class="faq">
				<button>
					<a href="/shoekream/admin/faq/list">자주 묻는 질문</a>
				</button>
			</div>
		</div>
		<div class="box4"></div>
	</footer>
	
	<script>
		<% if (msg != null){ %>
			alert("<%= msg %>");
		<% } %>
	</script>


</body>
</html>