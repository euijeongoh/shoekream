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
	
	<main>
		<div class="mypage-container">
			<%@include file="/WEB-INF/views/common/mypage_side.jsp" %>
			
			<div class="myinfo-container">
               <div class="myinfo-title">
                   로그인 정보
                   <div></div>
               </div>

               <div class="myinfo-body">
                   <div class="myinfo-input">
                       <div>아이디</div>
                       <input type="text" name="memberId">
                   </div>
               </div>

               <div class="myinfo-body">
                   <div class="myinfo-input">
                       <div>비밀번호</div>
                       <input type="password" name="memberPwd">
                   </div>
               </div>

               <div class="myinfo-body">
                   <div class="myinfo-input">
                       <div>닉네임</div>
                       <input type="text" name="memberNick">
                   </div>
               </div>

               <div class="myinfo-body">
                   <div class="myinfo-input">
                       <div>이메일</div>
                       <input type="text" name="email">
                   </div>
               </div>


               <a href="/shoekream/member/quit">회원탈퇴</a>
           </div>
		</div>
	</main>
</body>
</html>