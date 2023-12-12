<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="/shoekream/resources/css/mypage/account_info.css">
    </head>

    <body>

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

            <div class="mypage_container">
                <%@ include file="/WEB-INF/views/common/mypage_side.jsp" %>
                    <div class="content_area">
                        <div class="my_account">
                            <div class="content_title">
                                <div class="title">
                                    <h3>정산 계좌 변경</h3>
                                </div>
                            </div>
                            <div class="registered_account_box">
                                <h4 class="box_title">등록된 계좌 정보</h4>
                                <p class="box_account_info">
                                    <span class="account">${avo.bankAgentName } ${avo.accountNumber }</span><span
                                        class="account_devider">/</span><span class="name">${avo.depositor}</span>
                                </p>
                            </div>
                            <form action="" method="post">
                                <div class="content_registration">
                                    <div class="account_registration">
                                        <div class="input_logistics_companies input_box">
                                            <h4 class="input_title">은행명</h4>
                                            <div class="input_item">
                                                <input type="text" placeholder="선택하세요" readonly="readonly"
                                                    autocomplete="off" inputmode="numeric" class="input_txt"
                                                    id="selectedBank" name="bank">
                                                <button type="button" class="btn btn_dropdown"
                                                    onclick="toggleDropdown()">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                        fill="currentColor" class="bi bi-caret-down-fill"
                                                        viewBox="0 0 16 16">
                                                        <path
                                                            d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" />
                                                    </svg>
                                                </button>
                                                <div id="dropdown" class="layer_dropdown layer lg"
                                                    style="display: none;">
                                                    <div class="layer_container">
                                                        <a href="#" class="btn_layer_close"><svg
                                                                xmlns="http://www.w3.org/2000/svg"
                                                                class="ico-close icon sprite-icons">
                                                                <use data-v-4be3d37a=""
                                                                    href="/_nuxt/e72fd9e874df2e60bd653f838dce3aab.svg#i-ico-close"
                                                                    xlink:href="/_nuxt/e72fd9e874df2e60bd653f838dce3aab.svg#i-ico-close">
                                                                </use>
                                                            </svg></a>
                                                        <div class="layer_header">
                                                            <h2 class="title">은행 선택</h2>
                                                        </div>
                                                        <div class="layer_content">
                                                            <ul class="drop_list">
                                                                <li class="drop_item"><a href="#" class="drop_link"
                                                                        onclick="selectBank('국민은행')">국민은행</a></li>
                                                                <li class="drop_item"><a href="#" class="drop_link"
                                                                        onclick="selectBank('신한은행')">신한은행</a></li>
                                                                <li class="drop_item"><a href="#" class="drop_link"
                                                                        onclick="selectBank('우리은행')">우리은행</a></li>
                                                                <li class="drop_item"><a href="#" class="drop_link"
                                                                        onclick="selectBank('하나은행')">하나은행</a></li>
                                                                <li class="drop_item"><a href="#" class="drop_link"
                                                                        onclick="selectBank('기업은행')">기업은행</a></li>
                                                                <li class="drop_item"><a href="#" class="drop_link"
                                                                        onclick="selectBank('농협은행')">농협은행</a></li>
                                                                <li class="drop_item"><a href="#" class="drop_link"
                                                                        onclick="selectBank('SC은행')">SC은행</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="input_box">
                                            <h4 class="input_title">계좌번호</h4>
                                            <div class="input_item">
                                                <input type="tel" placeholder="- 없이 입력하세요" autocomplete="off"
                                                    class="input_txt" name="accountNumber">
                                            </div>
                                           
                                        </div>
                                        <div class="input_box">
                                            <h4 class="input_title">예금주</h4>
                                            <div class="input_item">
                                                <input type="text" placeholder="예금주명을 정확히 입력하세요." autocomplete="off"
                                                    class="input_txt" name="depositor">
                                                <input type="hidden" class="input_txt" name="no" value="${avo.no }">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="registration_btn_box">
                                        <input type="submit" disabled="disabled" href="#" id="submitBtn" class="btn btn_save solid medium disabled" value="변경하기">
                                        
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
            </div>

            <%@ include file="/WEB-INF/views/common/footer.jsp" %>

<script>
                    function toggleDropdown() {
                        var dropdown = document.getElementById("dropdown");
                        dropdown.style.display = (dropdown.style.display === "none" || dropdown.style.display === "") ? "block" : "none";
                    }

                    function selectBank(bankName) {
                        var selectedBankInput = document.getElementById("selectedBank");
                        selectedBankInput.value = bankName;

                        // 추가로 원하는 동작을 수행할 수 있습니다.
                        // 예: 드롭다운을 닫기

                        toggleDropdown();
                    }

        function enableSubmitButton() {
        var submitBtn = document.getElementById("submitBtn");
        var bankInput = document.getElementById("selectedBank");
        var accountNumberInput = document.querySelector(".input_box input[type='tel']");
        var accountHolderInput = document.querySelector(".input_box input[type='text']");

        var isInputsValid = bankInput.value.trim() !== "" &&
                            accountNumberInput.value.trim() !== "" &&
                            accountHolderInput.value.trim() !== "";

        submitBtn.disabled = !isInputsValid;

        // 입력이 유효하면 버튼의 배경 색상을 변경합니다
        if (isInputsValid) {
            submitBtn.style.backgroundColor = "#030303"; // 여기에 원하는 색상 코드를 넣어주세요
        } else {
            submitBtn.style.backgroundColor = ""; // 유효하지 않으면 기본 색상으로 설정합니다
        }
    }

    document.getElementById("selectedBank").addEventListener("input", enableSubmitButton);
    document.querySelector(".input_box input[type='tel']").addEventListener("input", enableSubmitButton);
    document.querySelector(".input_box input[type='text']").addEventListener("input", enableSubmitButton);
</script>
    </body>

    </html>