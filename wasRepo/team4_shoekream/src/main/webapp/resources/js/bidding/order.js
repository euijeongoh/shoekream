window.onload=function(){
    const ordersStatus = document.querySelector('.ordersStatus');
    const order_status_1 = document.querySelector('.order_status_1');
    const order_status_2 = document.querySelector('.order_status_2');
    const order_status_3 = document.querySelector('.order_status_3');
    const order_status_4 = document.querySelector('.order_status_4');
    console.log(ordersStatus.value);
    console.log(order_status_1.id);
    console.log(order_status_2.id);
    console.log(order_status_3.id);
    console.log(order_status_4.id);
    if (ordersStatus.value === '거래체결') {
        order_status_1.id = 'success';
    } else if (ordersStatus.value === '입고완료') {
        order_status_1.id = 'success';
        order_status_2.id = 'success';
    } else if (ordersStatus.value === '검수완료') {
        order_status_1.id = 'success';
        order_status_2.id = 'success';
        order_status_3.id = 'success';
    } else if (ordersStatus.value === '배송완료') {
        order_status_1.id = 'success';
        order_status_2.id = 'success';
        order_status_3.id = 'success';
        order_status_4.id = 'success';
        order_status_4.innerHTML = '배송완료';
    } else if (ordersStatus.value === '반송처리') {
        order_status_1.id = 'success';
        order_status_2.id = 'success';
        order_status_3.id = 'success';
        order_status_4.id = 'success';
        order_status_4.innerHTML = "반송처리";
    } else {
        alert('order 페이지 js 에러');
    }
  }