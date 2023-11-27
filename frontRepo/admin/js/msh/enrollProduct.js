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