function f01(productsNo, price, size ) {
    document.querySelector('.order_price').innerHTML = price;

    document.querySelector('.products_No').value = productsNo;
    document.querySelector(".products_price").value = price;
    document.querySelector(".products_size").value = size;
}