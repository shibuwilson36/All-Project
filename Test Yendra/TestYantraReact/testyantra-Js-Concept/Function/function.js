//Named Function

console.log("Named Function");


function add(a,b) {
    var sum=a+b;
    console.log("Sum is :"+sum);
    
}
add(10,15);

console.log("======================================");

function check(n) {

    console.log("N value is "+n);
    
    
}
check();
console.log("======================================");


function test() {

    console.log("Test method");
       
}
test(100);
console.log("======================================");
function multiply(n1,n2) {

    return n1*n2;
    
}

var mul=multiply(10,4);
console.log("Product "+mul);

console.log("======================================");

//Anonymouse function

console.log("Anonymouse function");


var division=function (x,y) {

                               return x/y;
                            }
 
var d=division(25,5);
console.log("division "+d);
                            
console.log("======================================");
//self invoke function
(function (p,q) {
    console.log("value is ",p-q);
    
})(20,10); 
console.log("======================================");

//Arrow Function
// var addition=(a,b,c)=>{
//     return a+b+c;
// }
var addition=(a,b,c)=>a+b+c;
    
var x=addition(10,20,30)
console.log("Sum "+x);

var sqr=x=>x*x;
console.log("Sqare "+sqr(2));

var great=()=>console.log("Good evenig Ladies and Gentlman");

great();