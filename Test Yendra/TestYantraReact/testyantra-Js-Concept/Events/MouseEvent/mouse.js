const element=document.getElementById("add");
function addStyle() {

    element.className="addStyle"
    
}
function removStyle() {
    element.className="removStyle"
}
const bElement=document.getElementById("one");

bElement.onclick=function () {
    alert("You clicked me")
}