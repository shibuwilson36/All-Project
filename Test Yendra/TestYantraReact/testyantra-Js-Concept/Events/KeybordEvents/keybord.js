const element=document.getElementById("one")


element.onkeydown=function () {
    console.log("triggered");
    
}

const second=document.getElementById("two")

const show =document.getElementById("show")

second.addEventListener("keyup",function () {
    console.log(second.value);
    show.textContent=second.value
    // console.log(second.textContent);
    
    // console.log("Keyup event");
      
})
let pElement=document.createElement("p") 
const cElement =document.getElementById("three")

cElement.addEventListener("keyup",function () {

    // console.log(cElement.value);
    // pElement.textContent=cElement.value
    //  document.body.appendChild("pElement")
    
    
      
})

