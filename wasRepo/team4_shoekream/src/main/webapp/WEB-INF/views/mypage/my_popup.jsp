<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/mypage/my_popup.css">
<script defer src="/shoekream/resources/mypage/my_popup.js"></script>
</head>
<body>
	
	<h3 class="change_title">프로필 이미지 변경</h3>
	
	<form class="change_area" action="/shoekream/mypage/profile/upload" method="post" enctype="multipart/form-data">
		<div class="input_area">
		<input type="file" name="f" multiple="multiple">
		<input type="submit" id="upload_profile" value="사진 업로드">
		</div>
	</form>
	
</body>
</html>