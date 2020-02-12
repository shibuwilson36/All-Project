//var keyword

//global scope variable

var a = 10;

function check() {
    //local scope
    var b = 20
    console.log("b value is" + b);

}
check()

for (var i = 0; i < 5; i++) {


}
console.log("i value is " + i);

//let keyword

//global scope
//console.log("x value is"+x); no hoisting 

let x = 10;
//let x=20; no redeclaration

x = 30;   //Reassigning is possible

function test() {

    //local scope
    let y = 10;
    console.log("y value is " + y);

}
test()

for (let j = 0; j < 5; j++) {
    //block scope
    console.log("j value is " + j);
}
console.log("------------------ ");

//const keyword
//global scope
//const p; ony Declaration is not possible

const p=10;
//const p=20; reDeclaration is not possible

//p=20 :no Reassiging

const items=["watch","shoe","chocolate","mobiles"]
items.push("Laptops");
console.log("Items "+items);
//items={}

const person={
    name:"smithi mandana"
}
console.log("person ",person);
/* const person={
    name:"smithi mandana"
    no Reassigment
} */

person.name="alia bhat"

console.log("person ",person);
