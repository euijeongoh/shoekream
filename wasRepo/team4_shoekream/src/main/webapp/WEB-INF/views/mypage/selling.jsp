<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/mypage/selling.css">

<script defer src="/shoekream/resources/js/mypage/selling.js"></script>

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
        <div class="mypage_container">
            
            <%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>
            
            <div class="sell-container">
                <div class="selllist-title">
                    판매 내역
                </div>
                <div class="tab-container">
                    <div class="tab" id="bidTab" onclick="bidTabAjax();">
                        <div id="bidCount">${cntVo.cntBid}</div>
                        <div id="stage">판매 입찰</div>
                    </div>
                    <div class="tab" id="pendTab" onclick="pendTabAjax();">
                        <div id="pendCount">${cntVo.cntPend}</div>
                        <div id="stage">진행 중</div>
                    </div>
                    <div class="tab" id="finishTab" onclick="finishTabAjax();">
                        <div id="finishedCount">${cntVo.cntFinished}</div>
                        <div id="stage">종료</div>
                    </div>

                </div>


                <div class="period-search">
                	<form id="periodForm">
                        <div>
                        <div class="month" id="2mths" onclick="set2Mths();">최근 2개월</div>
                        <div class="month" id="4mths" onclick="set4Mths();">4개월</div>
                        <div class="month" id="6mths" onclick="set6Mths();">6개월</div>
                        </div>
                        <input type="date" name="startDate" id="startDate">
                        <span>~</span>
                        <input type="date" name="endDate" id="endDate">
                        <input type="text" name="tab" id="tab" hidden value="bidding">
                        <input type="button" value="조회" onclick="chooseAjax();">
                    </form>
                </div>

                <div class="guide">
                    * 한 번에 조회 가능한 기간은 최대 6개월입니다. 기간별 조회 결과는 입찰일 기준으로 노출됩니다.
                </div>

                <div class="sell-body"> 
                
                	
                </div>
            </div>
        </div>
	</main>


</body>
</html>