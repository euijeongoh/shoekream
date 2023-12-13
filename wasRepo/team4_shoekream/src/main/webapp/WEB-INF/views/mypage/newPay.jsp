<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>새주소추가</title>

<link rel="stylesheet"
	href="/shoekream/resources/css/mypage/newPayment.css">

</head>

<body>

	<form action="/shoekream/mypage/payInfo" method="post">
		<div class="layer_container">
			<!-- a 태그 삭제 버튼 -->
			<a href="#" class="btn_layer_close">
				<div>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                    <path
							d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                </svg>
				</div>
			</a>
			<div class="layer_header">
				<!-- 여기 헤더 -->
				<h2>새 주소 추가</h2>
			</div>
			<div class="layer_content">
				<div class="delivery_bind">
					<div class="delivery_input">
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">이름</h4>
							<div class="input_item">
								<input type="text" placeholder="카드 소유자" class="input_txt" name="name">
							</div>
							<!-- <p class="input_error">올바른 이름을 입력해주세요. (2-50자)</p> -->
						</div>
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">카드번호</h4>
							<div class="input_item">
								<input type="text" placeholder="-없이 입력" class="input_txt" name="card_num">
							</div>
						</div>
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">유효기간</h4>
							<div class="input_item" id="map">
								<input type="text" placeholder="YY" class="input_txt" id="expiration_date" name="expiration_date" >
								<input type="text" placeholder="MM" class="input_txt" id="expiration_date" name="expiration_date" >
							</div>
						</div>
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">CVC</h4>
							<div class="input_item">
								<input type="text" id="CVC" name="CVC" placeholder="CVC를 입력하세요"
									class="input_txt" >
							</div>
						</div>
						<div class="input_box">
							<div class="delivery_check">
								<div class="checkbox_item" data-v-4be3d37a="">
									<input id="check1" type="checkbox" class="blind" name="default_addr" onchange="updateDefaultAddress()">
									<input type="hidden" id="defaultAddressHiddenInput" name="default_addr" value="N">
									
									<label for="check1" class="check_label"> <span
										class="label_txt">기본 결제 설정</span>
									</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layer_btn">
					<!-- 여기 하단(풋터) -->
					<a href="#" class="btn btn_delete outlinegrey medium"> 취소 </a>
					<button type="submit" class="btn btn_save solid medium disabled">
						저장하기</button>
				</div>
			</div>
		</div>
	</form>

</body>
<script>
    
    
    function updateDefaultAddress() {
        var checkbox = document.getElementById("check1");
        var hiddenInput = document.getElementById("defaultAddressHiddenInput");

        // 체크박스가 선택된 경우, 숨겨진 입력 필드 값을 'Y'로 설정하고 그렇지 않은 경우 'N'으로 설정합니다.
        hiddenInput.value = checkbox.checked ? 'Y' : 'N';
    }
</script>
</html>
