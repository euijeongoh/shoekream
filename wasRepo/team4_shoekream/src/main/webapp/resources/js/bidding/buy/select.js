function f01(productsNo, price, size ) {
    document.querySelector('.order_price').innerHTML = price;

    document.querySelector('.products_No').value = productsNo;
    document.querySelector(".products_price").value = price;
    document.querySelector(".products_size").value = size;

    const btn_order = document.querySelector('.btn_order');
    btn_order.disabled = false;
    btn_order.style.cursor = 'pointer';
}