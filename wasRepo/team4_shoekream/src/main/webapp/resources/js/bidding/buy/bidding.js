const btnoutlinegrey = document.querySelectorAll('.btnoutlinegrey');

/*
< 배열요소.forEach( 함수01 ) >
배열요소에서 하나씩 요소를 꺼내서 함수01 을 실행
마치 자바의 향상된 포문과 같다.
*/

배열요소.forEach( 함수01 )

function 함수01(요소){
    // 요소 가지고 하고싶은 작업 ~~~ //이 떄 요소는 배열요소 에서 하나씩 꺼내온 요소가 담김
}

btnoutlinegrey.forEach( (x) =>{ x.addEventListener("click" , function(){
    alert(123);
}) } );

// btnoutlinegrey.addEventListener('click' , function() {
    // alert('클릭 이벤트 발생 ㅋㅋ');
    // const test2 = document.querySelector('.test2');
    // 클릭 이벤트가 발생하면 버튼 disabled
// });

// function f01() {
    
// }