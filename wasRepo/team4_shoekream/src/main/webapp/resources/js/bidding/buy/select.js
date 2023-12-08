function f01(productsNo, price, size ) {
    document.querySelector('.order_price').innerHTML = price;

    document.querySelector('.productsNo').value = productsNo;
    document.querySelector('.price').value = price;
    document.querySelector('.size').value = size;
}