<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/mypage/info.css">
<script defer src="/shoekream/resources/js/mypage/info.js"></script>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
		<div class="mypage_container">
			<%@include file="/WEB-INF/views/common/mypage_side.jsp" %>
			
			<div class="myinfo-container">
               <div class="myinfo-title">
                   로그인 정보
                   <div></div>
               </div>
			 <form action="/shoekream/mypage/info" method="post" onsubmit="return checkValidation();">

                   	<div class="myinfo-input">
                       <div>아이디</div>
                       <input class="input-box" type="text" name="memberId" value="<%=loginMember.getId()%>">
                       <div id="id_check"></div>
                   	</div>



                   	<div class="myinfo-input">
                       <div>비밀번호</div>
                       <input class="input-box" type="password" name="memberPwd" value="<%=loginMember.getPwd()%>">
                       <div id="pwd_check"></div>
                   	</div>



                   	<div class="myinfo-input">
                       <div>닉네임</div>
                       <input class="input-box" type="text" name="memberNick" value="<%=loginMember.getNickname()%>">
                       <div id="nick_check"></div>
                   	</div>



                   <div class="myinfo-input">
                       	<div>이메일</div>
                       	<input class="input-box" type="text" name="email" value="<%=loginMember.getEmail()%>">
						<div id="email_check"></div>                       
                       	<button disabled onclick="sendEmail();">인증하기</button>
                       	<div class="approval_area">
                    	<input class="input_txt" type="text" name="appr_no" placeholder="인증번호 입력">
                    	<span id="auth_check"></span>
                    	</div>
					</div>

					<input type="submit" id="submit" value="로그인 정보 수정">
			</form>

               <a id="quit" href="/shoekream/member/quit">회원탈퇴</a>
           </div>
		</div>
	</main>
</body>
</html>