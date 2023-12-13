<%@page import="com.shoekream.mypage.vo.AddrBookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<% 
		
	
		AddrBookVo vo = (AddrBookVo) request.getAttribute("vo");
		
		String first = null;
		String middle = null;
		String last = null;
		
		if(vo != null){
		first = vo.getPhoneNumber().substring(0, 3);
		middle = vo.getPhoneNumber().substring(3, 4);
		last = vo.getPhoneNumber().substring(8, 11);
		}
		
		List<AddrBookVo> extraVo = (List<AddrBookVo>) request.getAttribute("extraVo");
		
		String extraFirst = null;
		String extraMiddle = null;
		String extraLast = null;
		
		for(AddrBookVo av : extraVo){
		extraFirst = av.getPhoneNumber().substring(0, 3);
		extraMiddle = av.getPhoneNumber().substring(3, 4);
		extraLast = av.getPhoneNumber().substring(8, 11);
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/shoekream/resources/css/common/mypage_side.css">
<link rel="stylesheet"
	href="/shoekream/resources/css/mypage/Adderss.css">

</head>

<body>

	<%@ include file = "/WEB-INF/views/common/header.jsp" %>

	<div class="mypage_container">
	<%@ include file = "/WEB-INF/views/common/mypage_side.jsp" %>
		<div class="content_area">
			<div class="my_adderssbock">
				<div class="content_title">
					<div class="title">
						<h3>주소록</h3>
					</div>
					<div class="btn_box">
						<a href="#" class="btn_add" id="openModal"> <span
							class="btn_txt">+ 새 배송지 추가</span>
						</a>
					</div>

					<!-- 모달 -->
					<div id="myModal" class="modal">
						<div class="modal-content">
							<!-- 모달 내용을 여기에 추가하세요 -->
							<p><%@ include file="/WEB-INF/views/mypage/newAddr.jsp"%></p>
							<button id="closeModal">모달 닫기</button>
						</div>
					</div>

					<!-- 비활성화된 요소를 나타내는 오버레이 -->
					<div id="overlay" class="overlay"></div>
					

				</div>
				<% if(vo != null){ %>
				<div class="my_list">
					<div class="basic">
						<div class="my_item">
							<div class="info_bind">
								<div class="address_info">
									<div class="name_box">
										<span class="name"><%=vo.getAddersName() %></span> <span class="mark">기본 배송지</span>
									</div>
									<p class="phone">
										<%=first %> <span class="hyphen"></span> <%=middle %> <span class="dot"></span>
										<span class="dot"></span> <span class="dot"></span> <span
											class="hyphen"></span> <span class="dot"></span> <%=last %>
									</p>
									<div class="address_box">
										<span class="zipcode">(<%=vo.getPostCode() %>)</span> <span class="adderss"><%=vo.getAddres() %></span>
									</div>
								</div>
							</div>
							<div class="btn_bind">
								<a href="/shoekream/mypage/addr/edit?no=<%=vo.getNo() %>" class="btn outlinegrey small openModal_edit" id="openModal_edit"><span
							class="btn_txt">수정</span></a> 
							<a href="/shoekream/mypage/addr/delete?no=<%=vo.getNo() %>" class="btn outlinegrey small"> <span
							class="btn_txt">삭제</span></a>
							</div>
						</div>
					</div>
				</div>
				
				<% for(AddrBookVo av : extraVo){ %>
				<div class="my_list">
					<div class="basic">
						<div class="my_item">
							<div class="info_bind">
								<div class="address_info">
									<div class="name_box">
										<span class="name"><%=av.getAddersName() %></span>
									</div>
									<p class="phone">
										<%=extraFirst %> <span class="hyphen"></span> <%=extraMiddle %> <span class="dot"></span>
										<span class="dot"></span> <span class="dot"></span> <span
											class="hyphen"></span> <span class="dot"></span> <%=extraLast %>
									</p>
									<div class="address_box">
										<span class="zipcode">(<%=av.getPostCode() %>)</span> <span class="adderss"><%=av.getAddres() %></span>
									</div>
								</div>
							</div>
							<div class="btn_bind">
								<a href="/shoekream/mypage/addr/change?no=<%=loginMember.getNo() %>" class="btn outlinegrey small"><span
							class="btn_txt">기본배송지 변경</span></a> 
								<a href="/shoekream/mypage/addr/edit?no=<%=av.getNo() %>" class="btn outlinegrey small openModal_edit"  id="openModal_edit"><span
							class="btn_txt">수정</span></a> 
								<a href="/shoekream/mypage/addr/delete?no=<%=av.getNo() %>" class="btn outlinegrey small"><span
							class="btn_txt">삭제</span></a>
							</div>
						</div>
					</div>
				</div>
				<%} %>
			<%} %>
			<!-- 모달 -->
					<div id="myModal_edit" class="modal_edit">
						<div class="modal-content_edit">
							<!-- 모달 내용을 여기에 추가하세요 -->
							<p><%@ include file="/WEB-INF/views/mypage/editAddr.jsp"%></p>
							<button id="closeModal_edit">모달 닫기</button>
						</div>
					</div>

					<!-- 비활성화된 요소를 나타내는 오버레이 -->
					<div id="overlay_edit" class="overlay_edit"></div>
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

	// 수정 모달
	// 모달 요소 및 오버레이 요소 가져오기
	const modal_edit = document.getElementById("myModal_edit");
	const overlay_edit = document.getElementById("overlay_edit");


	// 모달을 닫기 위한 버튼 가져오기
	const closeModalBtn_edit = document.getElementById("closeModal_edit");

	const btns_edit = document.querySelectorAll(".openModal_edit");

	btns_edit.forEach(btn_edit => {
	    btn_edit.onclick = function() {
	        modal_edit.style.display = "block";
	        overlay_edit.style.display = "block";
	    }
	});
	

	// 사용자가 닫기 버튼을 클릭하면 모달 닫기
	closeModalBtn_edit.onclick = function() {
		modal_edit.style.display = "none";
		overlay_edit.style.display = "none";
	}

	// 사용자가 모달 외부를 클릭하면 모달 닫기
	window.onclick = function(event) {
		if (event.target === overlay_edit) {
			modal_edit.style.display = "none";
			overlay_edit.style.display = "none";
		}
	}
	document.addEventListener("DOMContentLoaded", function() {
		// 닫기 버튼에 대한 이벤트 리스너 추가
		document.querySelector('.btn_layer_close_edit').addEventListener('click',
				function() {
			closeModal_edit();
				});

		// 취소 버튼에 대한 이벤트 리스너 추가
		document.querySelector('.btn_delete_edit').addEventListener('click',
				function() {
			closeModal_edit();
				});
	});

	function closeModal_edit() {
		// 모달 닫기
		const modal_edit = document.getElementById("myModal_edit");
		const overlay_edit = document.getElementById("overlay_edit");

		modal_edit.style.display = 'none';
		overlay_edit.style.display = 'none';
	}	
</script>
</html>