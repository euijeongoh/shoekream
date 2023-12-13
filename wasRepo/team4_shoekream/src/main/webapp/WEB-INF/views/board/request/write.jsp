<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	href="/shoekream/resources/css/board/request/wirte.css">

</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div class="wrap">
		<div class="wrap_inner">
			<%@ include file="/WEB-INF/views/common/service_center_side.jsp"%>
			<div class="board_wrap">
				<div class="board_title">상품 등록 요청</div>
				<div class="dropdown_head">
					<form action="/shoekream/request/write" method="post">
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
					<input type="submit" id="submit" value="작성하기">
					</form>
                    </div>
                </div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>
</html>