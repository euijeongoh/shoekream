function f01(productsNo, price, size ) {
    document.querySelector('.order_price').innerHTML = price;

    document.querySelector('.products_No').value = productsNo;
    console.log(document.querySelector('.products_No').value);
    document.querySelector(".products_price").value = price;
    console.log(document.querySelector('.products_price').value);
    document.querySelector(".products_size").value = size;
    console.log(document.querySelector('.products_size').value);
}