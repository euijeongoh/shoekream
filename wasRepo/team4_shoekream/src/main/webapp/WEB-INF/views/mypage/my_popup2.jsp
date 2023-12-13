<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.close_guide {
	width: 300px;
	height: 200px;
	margin: auto;
	font-family: 'Pretendard';
	font-size: 13px; 
	padding-top: 50px;
}
</style>

</head>
<body>
	
	<div class="close_guide">프로필 사진 변경이 완료되었습니다. 창을 닫아주십시오.</div>
	
</body>

<script>

reloadParent();

function reloadParent() {
	window.opener.parent.location.reload();
	
}


</script>
</html>