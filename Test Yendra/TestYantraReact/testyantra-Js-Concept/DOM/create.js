let element=document.createElement("p")
element.textContent="JavaScript is Easy"
console.log(element);

document.body.appendChild(element)

const ulElement=document.createElement("ul")
const li1Element=document.createElement("li")
const li2Element=document.createElement("li")

ulElement.textContent="LipSticks"
li1Element.textContent="Lakme"
li2Element.textContent="Loreal"

ulElement.appendChild(li1Element)
ulElement.appendChild(li2Element)

console.log(ulElement);


document.body.appendChild(ulElement)

const olElement=document.createElement("ol")
const li3Element=document.createElement("li")
const li4Element=document.createElement("li")

olElement.textContent="LipSticks"
li3Element.textContent="Lakme"
li4Element.textContent="Loreal"

olElement.appendChild(li3Element)
olElement.appendChild(li4Element)
document.body.appendChild(olElement)




var array=["A","B","C","D","E","F","G","H","I","J",]


for (let i = 0; i < 10; i++) {
    let buttonElement=document.createElement("button")
     buttonElement.textContent=array[i]
    document.body.appendChild(buttonElement)
}
   
let items=`
          <ul>
              <li>A</li>
              <li>B</li>
          </ul>
          <button>Click me</button>
         `
let divElement=document.getElementById("test");

divElement.innerHTML=items






