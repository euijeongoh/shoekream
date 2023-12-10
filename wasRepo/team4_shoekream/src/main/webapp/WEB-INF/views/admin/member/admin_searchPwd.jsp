<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/admin/common/admin_header.jsp" %>
	
	<div class="content">
        <div class="searchPwd-area">
            <div class="searchPwd-title">
                비밀번호 찾기
                <div></div>
            </div>
            <form action="/member/searchPwD" method="post">
                <div id="guide">
                    계정 발급 시 등록한 이메일을 입력하시면<br>
                    이메일로 임시 비밀번호를 전송해 드립니다.
                </div>
                <form>
                    <div class="input-box">
                        <div id="input-title">이메일 주소</div>
                        <input id="input-txt" type="text" name="email" placeholder="예) shoekream@shoekream.co.kr">
                    </div>
                    
                    <input type="submit" value="비밀번호 찾기">
                </form>
            </form>
        </div>
    </div>
</body>
</html>