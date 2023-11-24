// $("#file").on('change',function(){
//     var fileName = $("#file").val();
//     $(".upload-name").val(fileName);
//   });

        // 파일 선택 시 미리보기 함수
        function previewImage(event) {
            const fileInput = event.target;
            const imagePreview = document.getElementById('image-preview');

            const file = fileInput.files[0];

            if (file) {
                const reader = new FileReader();

                reader.onload = function(e) {
                    imagePreview.src = e.target.result;
                };

                reader.readAsDataURL(file);
            }
        }