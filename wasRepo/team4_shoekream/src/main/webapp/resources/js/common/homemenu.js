/**
 * 
 */

const mainSpan = document.querySelector("#menutab #main");
const mainSpanLink = document.querySelector("#menutab #main a");
const headListHome = document.querySelector(".head_list ul li a");

window.onload=() => {
    if(location.href.indexOf("/shoekream/home")>-1) {
    mainSpanLink.style.color="black";
    mainSpan.style.fontWeight = "700";
	mainSpan.style.borderBottom = "3px solid rgba(34, 34, 34)";
	headListHome.style.fontWeight = "700";
    }

    // if(location.href="/shoekream/ranking") {
    // rankingSpan.style.borderBottom="2px solid rgba(34, 34, 34)";
    // }
}