const idInputTag = document.querySelector("input[name=memberId]");

idInputTag.addEventListener("keydown", ()=>{
    const idInputTagValue = idInputTag.value;

    fetch("/app99/member/check/id?memberId="+idInputTagValue)
    .then( (resp)=>{return resp.json()} )
    .then( (data)=>{
        
    } );
})