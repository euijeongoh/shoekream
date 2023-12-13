// const btnoutlinegrey = document.querySelectorAll('.btnoutlinegrey');

/*
< 배열요소.forEach( 함수01 ) >
배열요소에서 하나씩 요소를 꺼내서 함수01 을 실행
마치 자바의 향상된 포문과 같다.
*/

// 배열요소.forEach( 함수01 )

// function 함수01(요소){
    // 요소 가지고 하고싶은 작업 ~~~ //이 떄 요소는 배열요소 에서 하나씩 꺼내온 요소가 담김
// }

// btnoutlinegrey.forEach( (x) =>{ x.addEventListener("click" , function(){
//     alert(123);
// }) } );

// btnoutlinegrey.addEventListener('click' , function() {
    // alert('클릭 이벤트 발생 ㅋㅋ');
    // const test2 = document.querySelector('.test2');
    // 클릭 이벤트가 발생하면 버튼 disabled
// });

// function f01() {
    
// }



// 마감기한 박스 색깔 두껍게
const btnoutlinegreyArr = document.querySelectorAll('.btnoutlinegrey');
btnoutlinegreyArr.forEach( (x) =>{ x.addEventListener("click" , handleClick )});


// 마감기한 띄워주기
function handleClick(){
    btnoutlinegreyArr.forEach( (x)=>{x.classList.remove('btnoutlinegrey_color')});
    this.classList.add('btnoutlinegrey_color');
    var selectDay = this.innerHTML
    console.log(selectDay);
    console.log(selectDay.slice(0, -1));
    // 1. 박스에 값 가져오기 (1일, 3일, 7일 등등..)

    /*
        Date.prototype.addDays = function (days) {
                var date = this;
                return new Date(date.setDate(date.getDate() + days));
        };
            // var day = new Date().addDays(selectDay.slice(0, -1));
            // 라이브러리 추가하고 아래꺼 사용해야 함
        // var day = moment(new Date().addDays(selectDay.slice(0, -1))).format('YYYY/MM/DD');
        var day = moment(new Date().addDays(selectDay.slice(0, -1))).format('YYYY/MM/DD');
        console.log(day);
        // 2. 가져온 숫자 값을 현재 날짜에 += 해주고 포맷 변경해주기
    */


        var day = moment().add(selectDay.slice(0,-1),"days").format("YYYY/MM/DD");
        console.log(day);
        // 2. moment().add(추가할 날짜, 현재 날짜).format(날짜포맷변환)


        var deadline_txt = document.querySelector('.deadline_txt');
        deadline_txt.innerHTML = selectDay + ' (' + day + ' 마감)';
        var deadline = document.querySelector('.deadline');
        // deadline.value = selectDay.slice(0, -1);
        deadline.value = day;
        console.log(deadline.value);
        // 3. 태그에 입력해주기 / 인풋태그에 마감기한 입력해주기
    
    
    // alert("성공ㅋ");
}


// const nextbtn = document.querySelector('.blind_full_solid_false');
// nextbtn.addEventListener("mouseover", mouseover)
// function mouseover() {
    //     alert('성공');
    // }
const input_amount1 = document.querySelector('.input_amount1');
const biddingPrice = document.querySelector('.biddingPrice');
function mouseover() {
    biddingPrice.value = input_amount1.value;
    console.log(biddingPrice.value);
}   // 4. 구매 입찰 계속에 마우스 올리면 input 태그 value 에 구매 희망가 입력


