<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<div class="wrap">
		<div class="wrap_inner">
			<!-- 레프트 사이드바 -->
			<div class="service-container">
				<div class="menu-container">
					<div class="service-title">
						<h2>고객센터</h2>
					</div>
					<nav>
						<div class="notice">
							<div id="title">
								<a href="">공지사항</a>
							</div>
						</div>
						<div class="faq">
							<div id="title">
								<a href="">자주 묻는 질문</a>
							</div>
						</div>
						<div class="qna">
							<div id="title">
								<a href="">Q&A</a>
							</div>
						</div>
						<div class="request">
							<div id="title">
								<a href="">상품 등록 요청</a>
							</div>
						</div>
					</nav>
				</div>
			</div>

			<!-- 본문 -->
			<div class="board_wrap">
				<div class="board_title">공지사항</div>
				<div class="board_search">
					<div>검색</div>
				</div>
				<ul class="dropdown_list">
					<li><a href="">
							<div class="dropdown">글1</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글2</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글3</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글4</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글5</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글6</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글7</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글8</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글9</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글10</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글11</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글12</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글13</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글14</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글15</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글16</div>
							<div class="date">2023.11.15</div>
					</a></li>
					<li><a href="">
							<div class="dropdown">글17</div>
							<div class="date">2023.11.15</div>
					</a></li>
				</ul>
				<div class="pagination">
					<div class="pagination_box">
						<div class="prev_btn">
							<a href="">--</a> <a href="">-</a>
						</div>
						<div class="page_bind">
							<a href="">6</a> <a href="">7</a> <a href="">8</a> <a href="">9</a>
							<a href="">10</a>
						</div>
						<div class="next_btn_box">
							<a href="">-</a> <a href="">--</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>