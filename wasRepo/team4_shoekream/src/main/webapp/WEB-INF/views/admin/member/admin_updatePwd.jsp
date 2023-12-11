<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="content">
        <div class="searchPwd-area">
            <form action="/shoekream/admin/updatePwd" method="post" onsubmit="">
                <div id="guide">
                    이메일 인증번호와<br>
                    새로 설정할 비밀번호를 입력해주세요.
                </div>

                	<div class="input-box">
                        <div id="input-title">이메일 인증번호</div>
                        <input id="input-txt" type="text" name="authKey" placeholder="이메일 인증번호">
                    </div>
                
                    <div class="input-box">
                        <div id="input-title">새 비밀번호</div>
                        <input id="input-txt" type="text" name="newPwd" placeholder="새 비밀번호">
                    </div>
                    
                    <input type="submit" value="비밀번호 재설정">


            </form>
        </div>
    </div>
	
</body>
</html>