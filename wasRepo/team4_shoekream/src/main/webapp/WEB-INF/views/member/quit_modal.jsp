<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/member/quit_modal.css">

</head>
<body>
	
	<div class="modal_quit">
        <!-- a 태그 삭제 버튼 -->
        <a href="#" class="btn_layer_close">
            <div>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x"
                    viewBox="0 0 16 16"w>
                    <path
                        d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                </svg>
            </div>
        </a>
        <div class="layer_header">
            <!-- 여기 헤더 -->
            <div>정말 탈퇴하시겠습니까?</div>
        </div>
        <div class="layer_content">
            <!-- 여기 내용 -->
            <div class="input_title">
                <div>탈퇴하기 클릭 시 바로 탈퇴 처리됩니다.<br><br>
                <input type="checkbox" name="quit_yn" value="yes"> ShoeKream 회원을 탈퇴하겠습니다.
                </div>
            </div>
            <div class="layer_btn">
                <!-- 여기 하단(풋터) -->
                <button type="button">탈퇴 안 할래요</button>
                <a>탈퇴하기</a>
            </div>
        </div>
    </div>

</body>
</html>