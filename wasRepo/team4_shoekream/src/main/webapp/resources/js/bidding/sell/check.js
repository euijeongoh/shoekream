function f02() {

    const undefined_box1 = document.querySelector('#undefined_box1');
    const undefined_box2 = document.querySelector('#undefined_box2');
    const undefined_box3 = document.querySelector('#undefined_box3');
    const undefined_box4 = document.querySelector('#undefined_box4');
    const undefined_box5 = document.querySelector('#undefined_box5');

    const btn1 = document.querySelector('#btn1');

    if (undefined_box1.checked === true &&
        undefined_box2.checked === true &&
        undefined_box3.checked === true &&
        undefined_box4.checked === true &&
        undefined_box5.checked === true 
        ) {
            btn1.style.backgroundColor = "#333";
            btn1.disabled = false;
            btn1.style.cursor = 'pointer';
    } else {
        btn1.style.backgroundColor = "#ebebeb";
        btn1.disabled = true;
        btn1.style.cursor = 'default';
    }
    
}