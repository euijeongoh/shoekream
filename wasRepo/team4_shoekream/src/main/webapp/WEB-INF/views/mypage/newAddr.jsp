<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>새주소추가</title>

<link rel="stylesheet"
	href="/shoekream/resources/css/mypage/newAdderss.css">

</head>

<body>

	<form action="/shoekream/mypage/addr" method="post">
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
								<input type="text" placeholder="수령인 이름" class="input_txt">
							</div>
							<!-- <p class="input_error">올바른 이름을 입력해주세요. (2-50자)</p> -->
						</div>
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">휴대폰 번호</h4>
							<div class="input_item">
								<input type="text" placeholder="-없이 입력" class="input_txt">
							</div>
						</div>
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">우편번호</h4>
							<div class="input_item" id="map">
								<input type="text" placeholder="우편 번호를 검색하세요" class="input_txt" id="sample6_postcode">
								<input type="button" class="btn btn_zipcode outline small" onclick="sample6_execDaumPostcode()"  value="우편번호">
							</div>
						</div>
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">주소</h4>
							<div class="input_item">
								<input type="text" id="sample6_address" placeholder="우편 번호 검색 후, 자동입력 됩니다"
									class="input_txt">
							</div>
						</div>
						<div class="input_box">
							<!-- 여기 내용 -->
							<h4 class="input_title">상세 주소</h4>
							<div class="input_item">
								<input type="text" id="sample6_detailAddress" placeholder="건물, 아파트, 동/호수 이력"
									class="input_txt">
							</div>
							<div class="delivery_check">
								<div class="checkbox_item" data-v-4be3d37a="">
									<input id="check1" type="checkbox" name="" class="blind">
									<label for="check1" class="check_label"> <span
										class="label_txt">기본 배송지로 설정</span>
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
    	new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
             // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</html>
