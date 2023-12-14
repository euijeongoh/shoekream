<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String quitFail = (String) session.getAttribute("quitFail");
    	session.removeAttribute("quitFail");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/member/quit.css">

<script defer src="/shoekream/resources/js/member/quit.js"></script>
</head>
<body>

<script>
<%
	if(quitFail != null) {%>
		alert("<%=quitFail%>");
	<%}

%>

</script>


	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
        <div class="mypage_container">
			<!-- 마이페이지 메뉴 -->
			<%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>
			<div class="quit-container">
                <div class="quit-title">
                    회원탈퇴
                    <div></div>
                </div>

                <div class="quit-head">
                    회원 탈퇴에 앞서 아래 내용을 반드시 확인해 주세요.
                </div>

                <div class="quit-body">
                    <form action="/shoekream/member/quit" method="post">
                        <div class="quit_term">
                        	<div class="main_term">
	                            <input type="checkbox">
	                            <span>SHOEKREAM을 탈퇴하면 회원 정보 및 서비스 이용 기록이 삭제됩니다.</span>
                        	</div>
                            <div class="detail">재가입 시에도 복구 불가능하며, 탈퇴한 아이디, 이메일로는 재가입이 불가능합니다</div>
                        </div>
                        <div class="quit_term">
                        	<div class="main_term">
	                            <input type="checkbox">
	                            <span>관련 법령 및 내부 기준에 따라 별도 보관하는 경우 일부 정보가 보관될 수 있습니다.</span>
                            </div>
                            <div class="detail">전자상거래 등 소비자 보호에 관한 법률, 통신비밀보호법, 회사 내부 기준</div>
                        </div>
                        <div class="quit_term">
                        	<div class="main_term">
	                            <input type="checkbox">
	                            <span>대금 미지급 등의 사유로 패널티가 부여된 회원은 회원탈퇴가 불가능합니다.</span>
                            </div>
                        </div>

						<div class="btn_area">
                        <input type="submit" value="탈퇴하기">
                        <input type="button" onclick="location.href='/shoekream/mypage/info'" value="취소하기">						
						</div>
						
<%-- 						<%@ include file="/WEB-INF/views/member/quit_modal.jsp" %> --%>
                    </form>
                    
                </div>
            </div>
		</div>
	</main>

</body>
</html>