<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String msg = (String) session.getAttribute("alarm"); session.removeAttribute("alarm"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shoekream/resources/css/common/footer.css">
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
					<a href="/shoekream/notice/list" class="footer_a">고객지원</a>
				</div>
				<div>
					<a href="/shoekream/notice/list" class="footer_a">공지사항</a>
				</div>
				<div>
					<a href="/shoekream/qna/list" class="footer_a">1:1문의</a>
				</div>
				<div>
					<a href="/shoekream/request/list" class="footer_a">상품 등록 문의</a>
				</div>
			</div>
			<div class="icons">
				<div>
					<a href=""> <img class="etc" src="/shoekream/resources/img/footer/인별.png"
						alt="인별">
					</a>
				</div>
				<div>
					<a href=""> <img class="etc" src="/shoekream/resources/img/footer/페북.png"
						alt="페북">
					</a>
				</div>
				<div>
					<a href=""> <img class="etc" src="/shoekream/resources/img/footer/카톡.png"
						alt="카톡">
					</a>
				</div>
			</div>
			<div></div>
			<div class="faq">
				<button class="faq_button">
					<a href="/shoekream/faq/list" class="footer_a">자주 묻는 질문</a>
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