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

const input_amount1 = document.querySelector('.input_amount1');
const biddingPrice = document.querySelector('.biddingPrice');
function mouseover() {
    biddingPrice.value = input_amount1.value;
    console.log(biddingPrice.value);
    // 4. 구매 입찰 계속에 마우스 올리면 input 태그 value 에 구매 희망가 입력
    

    var comm = input_amount1.value;
    Math.round(comm*0.05 / 10) 
    console.log(comm*0.05);
    var result = String(Math.round(comm*0.05 / 100)*100);
    console.log(result);

    const textar = document.querySelector('#textar');
    textar.innerText = String(Math.round(comm*0.05 / 100)*100) + "원";
    
    var x = input_amount1.value;
    var totalPrice = String(parseInt(x, 10) - (Math.round(comm*0.05 / 100)*100));
    console.log(totalPrice);

    const amount_c = document.querySelector('.amount_c');
    amount_c.innerHTML = String(parseInt(x, 10) - (Math.round(comm*0.05 / 100)*100)) + "원";
    amount_c.classList.add('unit');
}   




