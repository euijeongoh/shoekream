<%@page import="java.util.List"%>
<%@page import="com.shoekream.mypage.vo.PayInfoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	PayInfoVo payVo = (PayInfoVo) request.getAttribute("payVo");
		String first = null;
		
		if(payVo != null){
		first = payVo.getCardNumber().substring(12, 16);
		}
		
		List<PayInfoVo> extraPayInfoVo = (List<PayInfoVo>) request.getAttribute("extraPayInfoVo");
		String extraFirst = null;
		
		for(PayInfoVo pv : extraPayInfoVo){
		extraFirst = pv.getCardNumber().substring(11, 15);
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/shoekream/resources/css/mypage/payment.css">
    
</head>
<body>

<%@ include file = "/WEB-INF/views/common/header.jsp" %>

<div class="mypage_container">
	<%@ include file = "/WEB-INF/views/common/mypage_side.jsp" %>
		<div class="content_area">
            <div class="my_payment">
                <div class="content_title">
                    <div class="title">
                        <h3>결제 정보</h3>
                        <p class="sub_title">수수료(패널티, 착불 배송비 등)가 정산되지 않을 경우, 별도 고지 없이 해당 금액을 결제 시도할 수 있습니다.</p>
                    </div>
                    <div class="btn_box">
                        <a href="#" class="btn btn_add" id="openModal">
                            <span class="btn_txt">+ 새 카드 추가하기</span>
                        </a>
                    </div>
                    <!-- 모달 -->
					<div id="myModal" class="modal">
						<div class="modal-content">
							<!-- 모달 내용을 여기에 추가하세요 -->
							<p><%@ include file="/WEB-INF/views/mypage/newPay.jsp"%></p>
							<button id="closeModal">모달 닫기</button>
						</div>
					</div>

					<!-- 비활성화된 요소를 나타내는 오버레이 -->
					<div id="overlay" class="overlay"></div>
                    
                </div>
                <%if(payVo != null){ %>
                <div class="my_list">
                    <div class="basic">
                        <div class="my_item" default-mark="기본 결제">
                            <div class="info_bind"><!---->
                                <div class="card_info"><span class="card_name"> <%= payVo.getCardCompanyName() %></span>
                                    <div class="card_num"><span class="num_bind"><span class="dot"><span
                                                    class="dot"></span></span><span class="hyphen"></span><span
                                                class="dot"><span class="dot"></span></span><span
                                                class="hyphen"></span><span class="dot"><span
                                                    class="dot"></span></span><span class="hyphen"></span>
                                            <div d class="last_num_box"><span class="last_num"><%= first %></span></div>
                                        </span><span class="mark">기본 결제</span></div>
                                </div>
                            </div>
                            <div data-v-7d49a47c="" class="btn_bind"><!----><!----><a data-v-0a6aebaa=""
                                    data-v-7d49a47c="" href="#" class="btn outlinegrey small"> 삭제 </a></div>
                        </div>
                    </div>
                </div>
                <%for(PayInfoVo pv : extraPayInfoVo){ %>
                <div class="my_list">
                    <div class="basic">
                        <div class="my_item">
                            <div class="info_bind"><!---->
                                <div class="card_info"><span class="card_name"> <%= pv.getCardCompanyName() %></span>
                                    <div class="card_num"><span class="num_bind"><span class="dot"><span
                                                    class="dot"></span></span><span class="hyphen"></span><span
                                                class="dot"><span class="dot"></span></span><span
                                                class="hyphen"></span><span class="dot"><span
                                                    class="dot"></span></span><span class="hyphen"></span>
                                            <div d class="last_num_box"><span class="last_num"><%= extraFirst %></span></div>
                                        </span></div>
                                </div>
                            </div>
                            <div class="btn_bind"><a href="shoekream/mypage/payInfo/change?no=<%=loginMember.getNo() %>" class="btn outlinegrey small"> 기본결제 변경 </a></div>
                            <div class="btn_bind delete"><a href="#" class="btn outlinegrey small"> 삭제 </a></div>
                        </div>
                    </div>
                </div>
                <%} %>
                <%} %>
            </div>
        </div>
	</div>


	<%@ include file = "/WEB-INF/views/common/footer.jsp" %>

</body>
<script>
	// 모달 요소 및 오버레이 요소 가져오기
	const modal = document.getElementById("myModal");
	const overlay = document.getElementById("overlay");

	// 모달을 열기 위한 버튼 가져오기
	const btn = document.getElementById("openModal");

	// 모달을 닫기 위한 버튼 가져오기
	const closeModalBtn = document.getElementById("closeModal");

	// 사용자가 버튼을 클릭하면 모달 열기
	btn.onclick = function() {
		modal.style.display = "block";
		overlay.style.display = "block";
	}
	

	// 사용자가 닫기 버튼을 클릭하면 모달 닫기
	closeModalBtn.onclick = function() {
		modal.style.display = "none";
		overlay.style.display = "none";
	}

	// 사용자가 모달 외부를 클릭하면 모달 닫기
	window.onclick = function(event) {
		if (event.target === overlay) {
			modal.style.display = "none";
			overlay.style.display = "none";
		}
	}
	document.addEventListener("DOMContentLoaded", function() {
		// 닫기 버튼에 대한 이벤트 리스너 추가
		document.querySelector('.btn_layer_close').addEventListener('click',
				function() {
					closeModal();
				});

		// 취소 버튼에 대한 이벤트 리스너 추가
		document.querySelector('.btn_delete').addEventListener('click',
				function() {
					closeModal();
				});
	});

	function closeModal() {
		// 모달 닫기
		const modal = document.getElementById("myModal");
		const overlay = document.getElementById("overlay");

		modal.style.display = 'none';
		overlay.style.display = 'none';
	}
</script>
</html>