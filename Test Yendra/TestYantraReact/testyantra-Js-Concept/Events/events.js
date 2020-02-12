function great() {
    alert("Welcome to JavaScript class!!!!")
}
// function elementCreation() {
     
//     let pElement=document.createElement("p")
//     pElement.textContent="hai"
//     document.body.appendChild(pElement)

// }
let pElement=document.createElement("p")
pElement.textContent="hai"
function elementCreation() {
     
    document.body.appendChild(pElement)

}
function showData() {
    const ele=document.getElementById("show")
    console.log(ele.textContent);
    
}