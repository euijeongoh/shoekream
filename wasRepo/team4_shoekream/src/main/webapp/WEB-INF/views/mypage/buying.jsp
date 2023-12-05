<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/shoekream/resources/css/common/header.css">
<link rel="stylesheet" href="/shoekream/resources/css/common/mypage_side.css">
<link rel="stylesheet" href="/shoekream/resources/css/mypage/buying.css">

</head>
<body>
	
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
        <div class="mypage_container">
            
            <%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>
            
            <div class="shoplist-container">
                <div class="shoplist-title">
                    구매 내역
                </div>
                <div class="tab-container">
                    <div class="tab" onclick="location.href='/shoekream/mypage/buying?tab=bidding'">
                        <div id="count">0</div>
                        <div id="stage">구매 입찰</div>
                    </div>
                    <div class="tab" onclick="location.href='/shoekream/mypage/buying?tab=pending'">
                        <div id="count">0</div>
                        <div id="stage">진행 중</div>
                    </div>
                    <div class="tab" onclick="location.href='/shoekream/mypage/buying?tab=finished'">
                        <div id="count">0</div>
                        <div id="stage">종료</div>
                    </div>

                </div>


                <div class="period-search">
                    <form>
                        <div>
                        <div class="month" onclick="">최근 2개월</div>
                        <div class="month" onclick="">4개월</div>
                        <div class="month" onclick="">6개월</div>
                        </div>
                        <input type="date" name="startDate">
                        <span>~</span>
                        <input type="date" name="endDate">
                        <input type="submit" value="조회">
                    </form>
                </div>

                <div class="guide">
                    * 한 번에 조회 가능한 기간은 최대 6개월입니다. 기간별 조회 결과는 입찰일 기준으로 노출됩니다.
                </div>

                <div class="purchase-head">
                    <select type="filter">
                        <option>전체</option>
                        <option>입찰 중</option>
                        <option>기한만료</option>
                    </select>
                </div>

                <div class="purchase-body">
                    <div>구매 입찰 내역이 없습니다.</div>
                </div>
            </div>
        </div>
	</main>
	
</body>
</html>