let pElement=document.getElementById("demo");
console.log(pElement);
let pText=pElement.textContent
console.log(pText);
pElement.textContent="Hi Everyone"
console.log(pElement.textContent);

console.log("----------------------");

let testElement=document.querySelector(".test")
console.log(testElement.textContent);

let textElements=document.getElementsByClassName("test");
console.log(textElements);

for (const element of textElements) {
    console.log(element.textContent);
    
}

// textElements[2].textContent="instagram"
for (const element of textElements) {
    if(element.textContent==="FaceBook"){
        element.textContent="instagram"
    }
    
}
let h2Elements=document.querySelectorAll("h2")
console.log(h2Elements);


for (const h2Element of h2Elements) {
    var array=h2Element.textContent.split(" ")
    
   // console.log(array.join("-"));
    h2Element.textContent=array.join("-")
    // console.log(h2Element.textContent);
    
}

let tagElement=document.getElementsByTagName("h2")
for (const ele of tagElement) {
    console.log(ele.textContent);
    
}
let bElement=document.getElementsByName("btn")
for (const ele of bElement) {
    console.log(ele.textContent);
    
}

document.write("Good Afternoon")
